package com.example.windows10.rx_retrofit_library.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.windows10.rx_retrofit_library.R;

/**
 * 仿IOS下的菊花动画效果
 */
public class IOSLoadingDialog extends Dialog {


    private WindowManager.LayoutParams mLp;
    //背景的LinearLayout的控件
    private LinearLayout ll_dialog;
    //旋转的图片的大小
    private ProgressBar pb_dialog;
    //LinearLayout的布局参数
    private ViewGroup.LayoutParams layoutParams;
    //旋转progressBar的布局参数
    private ViewGroup.LayoutParams layoutParams1;

    public IOSLoadingDialog(Context context) {
        super(context);
    }

    public IOSLoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.ios_juhua_layout);
        ll_dialog = (LinearLayout) findViewById(R.id.ll_dialog);
        pb_dialog = (ProgressBar) findViewById(R.id.pb_dialog);
        this.setCancelable(false);
        this.setCanceledOnTouchOutside(false);
        getWindow().getAttributes().gravity = Gravity.CENTER;
        if (mLp == null) {
            mLp = getWindow().getAttributes();
        }
        mLp.dimAmount = 0.2f;
        this.getWindow().setAttributes(mLp);
    }

    public void setWidth(int width) {
        layoutParams = ll_dialog.getLayoutParams();
        layoutParams1 = pb_dialog.getLayoutParams();
        layoutParams.width = width;
        layoutParams1.width = (int) (width * 0.6);
        ll_dialog.setLayoutParams(layoutParams);
        pb_dialog.setLayoutParams(layoutParams1);
        ll_dialog.postInvalidate();
        pb_dialog.postInvalidate();
    }

    public void setHeight(int height) {
        layoutParams = ll_dialog.getLayoutParams();
        layoutParams1 = pb_dialog.getLayoutParams();
        layoutParams.height = height;
        layoutParams1.width = (int) (height * 0.6);
        ll_dialog.setLayoutParams(layoutParams);
        pb_dialog.setLayoutParams(layoutParams1);
        ll_dialog.postInvalidate();
        pb_dialog.postInvalidate();
    }

}
