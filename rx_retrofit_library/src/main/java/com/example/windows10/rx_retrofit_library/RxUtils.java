package com.example.windows10.rx_retrofit_library;


import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Windows10 on 2017/2/17.
 */
public class RxUtils {

    private static RxUtils mRxUtils = new RxUtils();
    private RetrofitUtils mRetrofit;

    //单例模式
    private RxUtils() {

    }

    public static RxUtils getInstance() {
        return mRxUtils;
    }

    //发送get请求进行联网请求数据
    public <T extends Object> void get(String baseUrl, String interfaceName
            , Map<String, String> params, final LoadingNetDataListener<T> loadingNetDataListener
            , final Class<T> t) {
        mRetrofit = RetrofitUtils.getInstance();
        mRetrofit.get(baseUrl, interfaceName, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(String value) {
                        if (loadingNetDataListener != null) {
                            loadingNetDataListener.onSuccess(JSON.parseObject(value, t));
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (loadingNetDataListener != null) {
                            loadingNetDataListener.onError("错误信息:" + e.getMessage());
                        }

                    }

                    @Override
                    public void onComplete() {
                        if (loadingNetDataListener != null) {
                            loadingNetDataListener.onComplete();
                        }
                    }
                });


    }

    //发送post请求进行联网请求数据
    public <T extends Object> void post(String baseUrl, String interfaceName, Map<String, String> params, final LoadingNetDataListener<T> loadingNetDataListener, final Class<T> t) {
        mRetrofit = RetrofitUtils.getInstance();
        mRetrofit.post(baseUrl, interfaceName, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(String value) {
                        if (loadingNetDataListener != null) {
                            loadingNetDataListener.onSuccess(JSON.parseObject(value, t));
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (loadingNetDataListener != null) {
                            loadingNetDataListener.onError("错误信息:" + e.getMessage());
                        }

                    }

                    @Override
                    public void onComplete() {
                        if (loadingNetDataListener != null) {
                            loadingNetDataListener.onComplete();
                        }
                    }
                });


    }

    //使用Jsoup解析html的方法
    public void parseHtmlByUrl(String url) {


//            if (mMainBean == null) {
//                mMainBean = new MainBean();
//            }
//
//            try {
//                //1.获取doc对象(开启子线程)(不设置userAgent可能导致获取不到数据)
//                Document doc = Jsoup.connect("http://www.allnature.com/index.php").timeout(5000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36").get();
//
//                //2.获取logo的标签(根据class名称获取标签)
//                Elements elements = doc.getElementsByClass("logo");
//
//                //3.遍历集合,根据标签取出属性值
//                for (Element element : elements) {
//                    //4.取出集合中对应标签的集合
//                    Elements a = element.getElementsByTag("img");
//
//                    //5.按照属性名称取出对应的内容
//                    Log.e("TAG1", a.get(0).attr("src"));
//
//                    //给MainBean设置logo
//                    mMainBean.setLogo(a.get(0).attr("src"));
//                }
//
//                //获取轮播图的标签
//                Elements banners = doc.getElementsByClass("switchable-panel");
//                BannerBean bannerBean = new BannerBean();
//
//                List<String> imageList = new ArrayList<>();
//                List<String> toUrlList = new ArrayList<>();
//                int begin = 0;
//                int last = 0;
//                for (Element element : banners) {
//
//                    String image = element.toString();
//                    begin = image.indexOf("http://");
//                    last = image.indexOf(".jpg");
//                    String substring = image.substring(begin, last + ".jpg".length());
//                    Log.e("TAG1", substring);
//
//                    String toUrl = element.attr("a");
//                    toUrlList.add(toUrl);
//                    imageList.add(substring);
//
//                }
//
//                mMainBean.setBannerBean(bannerBean);
//
//
//            } catch (IOException e) {
//
//                Toast.makeText(SplashActivity.this, "出现错误了" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.e("TAG1", "出现异常了");
//            }
//
//            return null;


    }

    //传入的监听方法中的doPrepare（在子线程中）先运行，执行完以后执行doComplete方法
    public void doInBackground(final BackgroundExcutors backgroundExcutors) {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                if (backgroundExcutors != null) {
                    backgroundExcutors.doPrepare();
                }
                e.onNext("onNext");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG", "onSubscribe");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e("TAG", "onNext");
                        if (backgroundExcutors != null) {
                            backgroundExcutors.doOnNext(value);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "onError");
                        if (backgroundExcutors != null) {
                            backgroundExcutors.onError();
                        }
                    }

                    @Override
                    public void onComplete() {
                        if (backgroundExcutors != null) {
                            backgroundExcutors.doComplete();
                        }
                    }
                });

    }

    public void doInBackground(final BackgroundExcutors backgroundExcutors, final int times) {

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                for (int i = 0; i < times; i++) {
                    if (backgroundExcutors != null) {
                        backgroundExcutors.doPrepare();
                    }
                    e.onNext(e);
                }

            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG", "onSubscribe");
                    }

                    @Override
                    public void onNext(Object value) {
                        if (backgroundExcutors != null) {
                            backgroundExcutors.doOnNext(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "onError");
                    }

                    @Override
                    public void onComplete() {
                        if (backgroundExcutors != null) {
                            backgroundExcutors.doComplete();
                        }
                    }
                });

    }


    //联网请求数据的监听（成功，失败，完成）状态
    public interface LoadingNetDataListener<T extends Object> {

         void onSuccess(T data);

         void onError(String msg);

         void onComplete();

    }

    public interface BackgroundExcutors {

        void doPrepare();

        void doOnNext(Object value);

        void doComplete();

        void onError();

    }


    //向服务器上传字符串
    public static void uploadString(final String url, String value) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("id", "001");
//        jsonObject.put("timestamp", System.currentTimeMillis() / 1000 + "");
//        jsonObject.put("result", "result");
//
//        final String content = String.valueOf(jsonObject);
//        Log.e("TAG", content);
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                HttpURLConnection conn;
//                URL url1 = new URL(url);
//                OutputStream outputStream = null;
//                conn = (HttpURLConnection) url1.openConnection();
//                conn.setRequestMethod("GET");
//                conn.setDoOutput(true);
//                conn.setConnectTimeout(15000);
//                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//                outputStream = conn.getOutputStream();
//                outputStream.write(content.getBytes());
//                outputStream.flush();
//                outputStream.close();
//                e.onNext(conn.getResponseCode());
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer value) {
//                        Log.e("TAG", "onNext()"+value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("TAG", "onError()");
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

}
