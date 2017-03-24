package com.example.windows10.checksystem.presenter;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.activity.CheckingActivity;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.CheckResultBean;
import com.example.windows10.checksystem.bean.ParseCheckResultBean;
import com.example.windows10.checksystem.bean.RequestResultBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.fragment.BaseFragment;
import com.example.windows10.checksystem.fragment.NoBlueToothFragment;
import com.example.windows10.checksystem.view.CheckingFragmentView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.RxUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 移动端和OBD进行交互的逻辑页（到这个页面说明蓝牙已经是开启并可用的状态了）
 */
public class CheckingFragmentPresenter extends CheckPresenter implements RxUtils.LoadingNetDataListener<CheckResultBean> {

    private CheckingFragmentView mView;
    //获得的系统提供的蓝牙适配器
    private BluetoothAdapter bluetoothAdapter;
    //通过蓝牙获得的与设备间通信的socket
    private BluetoothSocket clientSocket;
    //发送给蓝牙设备的字符串的变量
    private StringBuilder rawData = new StringBuilder();
    protected ArrayList<Integer> buffer = new ArrayList<>();
    //读取进度条的当前进度
    private int mProgress = 0;
    //判断是否与蓝牙连接成功的变量
    private boolean isBluetoothConnect = false;
    //定义进度条的最大刻度
    private int mMax = 40;
    //检测消息
    private String mSendMsg;
    //检测次数
    private int checkCount = 0;

    private long uploadTime;

    private ArrayList<ParseCheckResultBean> mList = new ArrayList<>();

    public CheckingFragmentPresenter(CheckingFragmentView view, Context context) {
        super(view, context);
        mView = view;
        mContext = context;
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }


    //对蓝牙进行检测
    public void loadingChecking() {
        mView.updateStatus(mContext.getString(R.string.checking_bluetooth));
        bluetoothAdapter.startDiscovery();
        //更新进度条的显示进度
        loadingProgress();
    }

    //更新进度条的显示
    private void loadingProgress() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                while (mProgress <= mMax && !isBluetoothConnect) {
                    SystemClock.sleep(200);
                    mProgress += 1;
                    e.onNext(mProgress);
                }
                while (mProgress <= mMax && isBluetoothConnect) {
                    if (preProgress != mProgress) {
                        preProgress = mProgress;
                        e.onNext(mProgress);
                    }

                }

            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {
                        mView.updateProgress(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    //接收蓝牙扫描过程中状态的广播接收者
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Log.e("TAG", "onReceive（）");
            String action = intent.getAction();
            //找到设备
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getBondState() == BluetoothDevice.BOND_BONDED) {
                    ParcelUuid[] uuids = device.getUuids();
                    if (uuids != null) {
                        try {
                            clientSocket = device.createRfcommSocketToServiceRecord(UUID.fromString(Constants.DEVICE_UUID));
                            clientSocket.connect();
                            isBluetoothConnect = true;
                            mView.updateStatus(mContext.getString(R.string.bluetooth_connect));
                            SystemApplication.BLUETOOTH_STATUS = Constants.BLUE_TOOTH_CONNECT_SUCCESS;
                            loadingProgress();
                            //发送一个07
                            loopForCheck();
                        } catch (Exception e) {
                            Log.e("TAG", "抛出异常了3" + e.getMessage());
                            SystemApplication.BLUETOOTH_STATUS = Constants.BLUE_TOOTH_CONNECT_FAILED;
                            mView.showFragment(BaseFragment.instance(mContext, NoBlueToothFragment.class));
                            e.printStackTrace();
                        }
                    }
                }
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                Log.e("TAG", "完成蓝牙搜索");
                //搜索完成
                bluetoothAdapter.cancelDiscovery();
                if (clientSocket == null) {
                    //连接失败
                    SystemApplication.BLUETOOTH_STATUS = Constants.BLUE_TOOTH_CONNECT_FAILED;
                    mView.showFragment(BaseFragment.instance(mContext, NoBlueToothFragment.class));
                    mView.showToast("连接失败，请重试");

                }
            }
        }
    };

    //开启发送信息的任务
    public void sendTask(String msg) {
        Log.e("TAG", "sendTask");
        try {
            sendCommand(clientSocket.getOutputStream(), msg);
            readResult(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //给OBD发送消息
    protected void sendCommand(OutputStream out, String msg) {
        // add the carriage return char
        Log.e("TAG", "sendCommand");
        String cmd = msg + "\r";
        try {
            out.write(cmd.getBytes());
            out.flush();
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //从OBD读取信息
    protected void readResult(InputStream in) throws IOException {
        Log.e("TAG", "readResult");
        byte b = 0;
        StringBuilder res = new StringBuilder();

        // read until '>' arrives
        while ((char) (b = (byte) in.read()) != '>') {
            if ((char) b != ' ') {
                res.append((char) b);
            }
        }
        //从OBD获取到了字符串信息
        rawData.append(res.toString().trim() + ",");
        Log.e("TAG", checkCount + "rawData的值为：" + rawData);

//        // clear buffer
//        buffer.clear();
//
//        // read string each two chars
//        int begin = 0;
//        int end = 2;
//        while (end <= rawData.length()) {
//            String temp = "0x" + rawData.substring(begin, end);
//            buffer.add(Integer.decode(temp));
//            begin = end;
//            end += 2;
//        }
//        for (int i = 0; i < buffer.size(); i++) {
//            Log.e("TAG", "OBD读取到的数据为：" + buffer.get(i));
//        }
    }

    //给当前的activity注册广播
    public void registReceiver() {
        //发现设备的广播
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        mContext.registerReceiver(mReceiver, filter);
        //设备搜索完成的广播
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        mContext.registerReceiver(mReceiver, filter);
    }

    //给蓝牙搜索的广播解除注册
    public void onDestroy() {
        mContext.unregisterReceiver(mReceiver);
        try {
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String initSendMsg() {
        switch (checkCount) {
            case 0:
                return Constants.OBD_MSG_07;
            default:
                String checkCode = SystemApplication.checkCodes[checkCount % SystemApplication.checkCodes.length].trim();
                Log.e("TAG", "传入的检测项为：" + checkCode);
                return checkCode;
        }
    }

    @Override
    public void onSuccess(CheckResultBean data) {
        if ("true".equals(data.getMessage().getSuccess())) {
            //生成检测文件成功
            loopForResult();
        }
    }

    @Override
    public void onError(String msg) {
        mView.showToast(msg);
    }

    @Override
    public void onComplete() {

    }

    private boolean isLoop = true;

    //开始循环进行检测
    public void loopForCheck() {
        mMax = 80;
        mProgress = 40;
        RxUtils.getInstance().doInBackground(new RxUtils.BackgroundExcutors() {
            @Override
            public void doPrepare() {
                while (checkCount <= SystemApplication.CHECK_TIMES * 60 / SystemApplication.CHECK_FREQUENTS) {
                    checkCount++;
                    mProgress += 1;
                    sendTask(initSendMsg());
                    SystemClock.sleep((long) (SystemApplication.CHECK_FREQUENTS * 1000));
                }
            }

            @Override
            public void doOnNext(Object value) {
            }

            @Override
            public void doComplete() {
                try {
                    if (clientSocket != null)
                        clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mProgress = mMax;
                Log.e("TAG", "rawData最后的数据为" + rawData);
                HashMap<String, String> params = new HashMap<>();
                params.put(Constants.ID, SystemApplication.USER_ID + "");
                uploadTime = System.currentTimeMillis();
                params.put(Constants.UPLOAD_DETECTIONTIME, uploadTime + "");
                String result = rawData.toString().substring(0, rawData.toString().length() - 1);
                Log.e("TAG", "result:" + result);
                params.put(Constants.UPLOAD_TESTDATA, result);
                RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_CHECK_RESULT, params, CheckingFragmentPresenter.this, CheckResultBean.class);
            }

            @Override
            public void onError() {
                showFragment(Constants.FRAGMENT_NOBLUETOOTH);
            }
        });
    }

    private int preProgress;

    //开始轮询到服务器中取文件
    public void loopForResult() {
        mMax = 90;
        RxUtils.getInstance().doInBackground(new RxUtils.BackgroundExcutors() {
            @Override
            public void doPrepare() {
                while (isLoop) {
                    Log.e("TAG", "循环请求消息");
                    mProgress += 1;
                    if (isLoop) {
                        requestFiles();
                        SystemClock.sleep(Constants.LOOP_TIME);
                    }
                }
            }

            @Override
            public void doOnNext(Object value) {

            }

            @Override
            public void doComplete() {
                mView.updateProgress(mProgress);
            }

            @Override
            public void onError() {

            }
        });


    }

    //请求服务器端解析以后文件的信息
    public void requestFiles() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.CHECK_FILE_NAME, "1489469495output.res");
        params.put(Constants.CHECK_CHECK_DATA, "1489469495input.txt");
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_REQUEST_RESULT, params, new RxUtils.LoadingNetDataListener<RequestResultBean>() {
            @Override
            public void onSuccess(RequestResultBean data) {
                isLoop = false;
                if (data == null || data.getMessage() == null || "false".equals(data.getMessage().getSuccess())) {
                    showFragment(Constants.FRAGMENT_NOPROBLEM);
                    return;
                }

                if ("true".equals(data.getMessage().getSuccess())) {
                    mView.updateProgress(100);
                    //当请求文件成功，并且有数据的时候跳转到当前有问题的界面
                    Log.e("TAG", "onSuccess(),停止轮询器");
                    String str = data.getContentResults();
                    if (CommonUtils.isEmpty(str)) {
                        showFragment(Constants.FRAGMENT_NOPROBLEM);
                        return;
                    }
                    String[] split = str.split(";");
//                    4 汽车没电,spareParts:{price:40.0,manualPrice:0.0,btx1:1小时,btx2:汽车保险},partsId:14;
                    mList.clear();
                    for (int i = 0; i < split.length; i++) {
//                       {" 010C":"汽车没电","spareParts":{"price":"","manualPrice":"","btx1":"","btx2":""}","partsId":""}
                        String replace = split[i].replace(",", "\",\"");
                        String replace1 = replace.replace("{", "{\"");
                        String replace2 = replace1.replace("}", "\"}");
                        String replace3 = replace2.replace(":", "\":\"");
                        String replace4 = replace3.replace(" ", "\":\"");
                        String replace5 = ("{\"" + replace4.replace("\"{", "{") + "\"}").replace("}\"", "}");
                        int begin = replace5.indexOf("\"", 1);
                        int end = replace5.indexOf("\"", 2);
                        String s = replace5.substring(0, begin + 1) + "id" + replace5.substring(end);
                        Log.e("TAG", s);
                        mList.add(JSON.parseObject(s, ParseCheckResultBean.class));
                    }

//                    showFragment(Constants.FRAGMENT_NOPROBLEM);
                    if (mList != null && mList.size() > 0) {
                        ((CheckingActivity) mContext).setResultBeens(mList);
                        showFragment(Constants.FRAGMENT_HASPROBLEM);
                    } else {
                        showFragment(Constants.FRAGMENT_NOPROBLEM);
                    }
                }
            }

            @Override
            public void onError(String msg) {
                Log.e("TAG", "onError(),停止轮询器");
                isLoop = false;
                showFragment(Constants.FRAGMENT_NOPROBLEM);
            }

            @Override
            public void onComplete() {

            }
        }, RequestResultBean.class);
    }
}
