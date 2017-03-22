package com.example.windows10.checksystem.activity;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.dou361.ijkplayer.widget.PlayerView;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.bean.LingJianDetailsBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityVideoPlayerBinding;

public class VideoPlayerActivity extends BaseActivity {

    private ActivityVideoPlayerBinding mBinding;
    private PlayerView mPlayer;
    private LingJianDetailsBean.SparePartsBean.VideoBean videoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_video_player);
        mIntent = getIntent();
        videoBean = (LingJianDetailsBean.SparePartsBean.VideoBean) mIntent.getSerializableExtra(Constants.INTENT_KEY_VIDEO);
        String url = "http://9890.vod.myqcloud.com/9890_9c1fa3e2aea011e59fc841df10c92278.f20.mp4";
        mPlayer = new PlayerView(this);

        mPlayer.setTitle("测试标题")
                .setPlaySource(url)
                .setOnlyFullScreen(true)
                .startPlay();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPlayer != null) {
            mPlayer.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPlayer != null) {
            mPlayer.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null) {
            mPlayer.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mPlayer != null) {
            mPlayer.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (mPlayer != null && mPlayer.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
