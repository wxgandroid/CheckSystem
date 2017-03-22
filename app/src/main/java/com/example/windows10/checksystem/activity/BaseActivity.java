package com.example.windows10.checksystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.windows10.checksystem.R;

public class BaseActivity extends FragmentActivity {

    public Intent mIntent;
    public long preTime;
    public long currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mIntent = new Intent();
    }

}
