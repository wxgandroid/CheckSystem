package com.example.windows10.rx_retrofit_library;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.windows10.rx_retrofit_library.view.CYPLoadingDialog;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;
import com.example.windows10.rx_retrofit_library.wheelview.NumericWheelAdapter;
import com.example.windows10.rx_retrofit_library.wheelview.OnWheelScrollListener;
import com.example.windows10.rx_retrofit_library.wheelview.WheelView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Windows10 on 2017/2/17.
 */
public class CommonUtils {

    private static final String SHARED_PREFERENCES = "preferences";
    public static CYPLoadingDialog mLoadingDialog = null;
    private static Intent mIntent = new Intent();

    //判断字符串是否为空
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    //获取一个url，如果不是以http://开头，添加http://
    public static String getUrl(String baseUrl) {
        if (baseUrl.startsWith("http://")) {
            if (baseUrl.endsWith("/")) {
                return baseUrl;
            } else {
                return baseUrl + "/";
            }
        } else {
            if (baseUrl.endsWith("/")) {
                return "http://" + baseUrl;
            } else {
                return "http://" + baseUrl + "/";
            }
        }
    }

    //判断输入的字符串是否为手机号
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,//D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    //判断输入的字符串是否为正确的邮箱号
    public static boolean isEmail(String strEmail) {
        String strPattern = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(strEmail);
        return m.matches();
    }

    //在sp存储中按照key值存入字符串数据
    public static boolean saveStringExtras(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return sp.edit().putString(key, value).commit();
    }

    //从sp存储中按照key值取出字符串数据
    public static String getStringExtras(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }

    //显示读取数据的progressDialog
    public static CYPLoadingDialog showLoadingDialog(Context context, String message) {

        if (mLoadingDialog == null) {
            mLoadingDialog = new CYPLoadingDialog(context, message);
        }

        if (!mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }
        return mLoadingDialog;
    }

    //仿IOS系统下的菊花动画加载效果
    public static IOSLoadingDialog showIOSLoadingDialog(Context context) {
        IOSLoadingDialog mIOSLoadingDialog = new IOSLoadingDialog(context, R.style.NoTitleDialog);
        mIOSLoadingDialog.show();
        return mIOSLoadingDialog;
    }

    //dp单位转换成px单位的方法
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    //sp单位转换成px单位的方法
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    //px单位转换成dp单位的方法
    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    //px单位转换成sp单位的方法
    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }

    //获取字符串的MD5加密值
    public static String getMd5(String str) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    //请求权限
    public static void requestPermission(Activity activity, String permissionName, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && ContextCompat.checkSelfPermission(activity, permissionName) != PackageManager.PERMISSION_GRANTED) {
            //android版本大于等于23，并且所申请的权限并未被开启的情况下，进行权限的申请
            ActivityCompat.requestPermissions(activity, new String[]{permissionName}, requestCode);
        }
    }

    //检查权限是否开启
    public static void checkPermission(Activity activity, int requestCode, String[] permissions, int[] grantResults, int permissionRequestCode, String refuseMsg) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && requestCode == permissionRequestCode) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                // 判断用户是否 点击了不再提醒。(检测该权限是否还可以申请)
                boolean b = activity.shouldShowRequestPermissionRationale(permissions[0]);
                if (!b) {
                    // 用户还是想用我的 APP 的
                    // 提示用户去应用设置界面手动开启权限
                    showDialogTipUserGoToAppSettting(activity, refuseMsg, permissionRequestCode);
                } else
                    activity.finish();
            } else {
                Toast.makeText(activity, "权限获取成功", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //弹出对话框设置去设置权限
    private static void showDialogTipUserGoToAppSettting(final Activity activity, String refuseMsg, final int permissionRequestCode) {
        new AlertDialog.Builder(activity)
                .setTitle("权限不可用")
                .setMessage(refuseMsg)
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 跳转到应用设置界面
                        goToAppSetting(activity, permissionRequestCode);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finish();
                    }
                }).setCancelable(false).show();
    }

    // 跳转到当前应用的设置界面
    private static void goToAppSetting(Activity activity, int permissionRequestCode) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);
        activity.startActivityForResult(intent, permissionRequestCode);
    }

    //跳转到其他的activity
    public static <T extends Activity> void toOtherActivity(Activity startActivity, Class<T> endActivity) {
        mIntent.setClass(startActivity, endActivity);
        startActivity.startActivity(mIntent);
    }

    public static <T extends Activity> void toOtherActivity(Activity startActivity, Class<T> endActivity, Intent intent) {

        intent.setClass(startActivity, endActivity);
        startActivity.startActivity(intent);
    }

    public static <T extends Activity> void toOtherActivityForResult(Activity startActivity, Class<T> endActivity, Intent intent, int requestCode) {
        intent.setClass(startActivity, endActivity);
        startActivity.startActivityForResult(intent, requestCode);
    }


    private static WheelView year;
    private static WheelView month;
    private static WheelView day;
    private static int mYear = 1996;
    private static int mMonth = 0;
    private static int mDay = 1;

    //获取日期选择器
    public static View getDatePicker(final Activity activity) {
        Calendar c = Calendar.getInstance();
        int norYear = c.get(Calendar.YEAR);
        int curYear = mYear;
        int curMonth = mMonth + 1;
        int curDate = mDay;
        View view = View.inflate(activity, R.layout.wheel_date_picker, null);
        year = (WheelView) view.findViewById(R.id.year);
        NumericWheelAdapter numericWheelAdapter1 = new NumericWheelAdapter(activity, 1950, norYear);
        numericWheelAdapter1.setLabel("年");
        year.setViewAdapter(numericWheelAdapter1);
        year.setCyclic(false);
        OnWheelScrollListener onWheelScrollListener = new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                int n_year = year.getCurrentItem() + 1950;
                int n_month = month.getCurrentItem() + 1;
                initDay(activity, n_year, n_month);
            }
        };
        year.addScrollingListener(onWheelScrollListener);

        month = (WheelView) view.findViewById(R.id.month);
        NumericWheelAdapter numericWheelAdapter2 = new NumericWheelAdapter(activity, 1, 12, "%02d");
        numericWheelAdapter2.setLabel("月");
        month.setViewAdapter(numericWheelAdapter2);
        month.setCyclic(false);
        month.addScrollingListener(onWheelScrollListener);

        day = (WheelView) view.findViewById(R.id.day);
        initDay(activity, curYear, curMonth);
        day.setCyclic(false);

        year.setVisibleItems(7);
        month.setVisibleItems(7);
        day.setVisibleItems(7);

        year.setCurrentItem(curYear - 1950);
        month.setCurrentItem(curMonth - 1);
        day.setCurrentItem(curDate - 1);
        return view;
    }

    //获取日期选择器中的年月日的信息
    public static String getBirthDay() {
        return new StringBuilder().append((year.getCurrentItem() + 1950)).append("-").append((month.getCurrentItem() + 1) < 10 ? "0" + (month.getCurrentItem() + 1) : (month.getCurrentItem() + 1)).append("-").append(((day.getCurrentItem() + 1) < 10) ? "0" + (day.getCurrentItem() + 1) : (day.getCurrentItem() + 1)).toString();
    }

    private static void initDay(Activity activity, int arg1, int arg2) {
        NumericWheelAdapter numericWheelAdapter = new NumericWheelAdapter(activity, 1, getDay(arg1, arg2), "%02d");
        numericWheelAdapter.setLabel("日");
        day.setViewAdapter(numericWheelAdapter);
    }

    //根据年和月获得当月的天数
    private static int getDay(int year, int month) {
        int day = 30;
        boolean flag = false;
        switch (year % 4) {
            case 0:
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 2:
                day = flag ? 29 : 28;
                break;
            default:
                day = 30;
                break;
        }
        return day;
    }

    //按照传入的参数弹出popupwindow
    public static PopupWindow showPopupWindow(Activity activity, int resId,
                                              View.OnClickListener onClickListener, int[] ress, int x, int y) {

        PopupWindow popupWindow = new PopupWindow(activity);
        View view = View.inflate(activity, resId, null);
        for (int i = 0; i < ress.length; i++) {
            view.findViewById(ress[i]).setOnClickListener(onClickListener);
        }
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(activity.getWindow().getDecorView(), Gravity.CENTER, x, y);
        return popupWindow;
    }

    //按照传入的参数弹出popupwindow
    public static PopupWindow showPopupWindow(Activity activity, View view,
                                              View.OnClickListener onClickListener, int[] ress, int x, int y) {

        PopupWindow popupWindow = new PopupWindow(activity);
        for (int i = 0; i < ress.length; i++) {
            view.findViewById(ress[i]).setOnClickListener(onClickListener);
        }
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(activity.getWindow().getDecorView(), Gravity.CENTER, x, y);
        return popupWindow;
    }

//    //显示带列表的PopupWindow
//    public static PopupWindow showListPopupWindow(Context context) {
//        PopupWindow popupWindow = new PopupWindow(context);
//        View inflate = View.inflate(context, R.layout.list_popupwindow, null);
//        ListView listView = (ListView) inflate.findViewById(R.id.lv_common);
//        CommonListViewAdapter adapter = new CommonListViewAdapter(context,);
//        listView.setAdapter(adapter);
//        popupWindow.setContentView(inflate);
//        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
//        popupWindow.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
//
//        return null;
//    }


    //根据类名以及属性名获取属性的id的方法
    public static int getResourceIdByName(Context context, String className, String name) {
        int id = 0;
        if (context == null) {
            return id;
        } else {
            String packageName = context.getPackageName();
            //$符号，表示在R里面的内部类
            String var10 = packageName + ".R$" + className;
            Log.e("TAG", var10);
            try {
                Class desireClass = Class.forName(var10);
                if (desireClass != null) {
                    id = desireClass.getField(name).getInt(desireClass);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        return id;
    }

    //拨打电话
    public static void callPhone(Context context, String num) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
        context.startActivity(intent);
    }

    public static Ringtone playNotification(Context context) {
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        return RingtoneManager.getRingtone(context, notification);
    }
}
