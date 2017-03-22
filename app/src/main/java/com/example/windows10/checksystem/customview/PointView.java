package com.example.windows10.checksystem.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Windows10 on 2017/3/3.
 */
public class PointView extends View {

    private Paint mPaint;
    private Context mContext;

    private float radius = 20;

    public PointView(Context context) {
        this(context, null);
    }

    public PointView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();

    }

    //初始化view的操作
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(radius / 2, radius / 2, radius / 2, mPaint);
    }

    public void setColor(int color) {
        mPaint.setColor(color);
        postInvalidate();
    }


}
