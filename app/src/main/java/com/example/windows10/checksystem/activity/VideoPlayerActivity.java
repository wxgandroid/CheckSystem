package com.example.windows10.checksystem.activity;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.dou361.ijkplayer.widget.PlayerView;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.LingJianDetailsBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityVideoPlayerBinding;
import com.example.windows10.rx_retrofit_library.CommonUtils;

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
        if (videoBean == null) {
            Toast.makeText(VideoPlayerActivity.this, "视频文件信息错误", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        String url = SystemApplication.getInstance().getBASE_VIDEO_URL()+ videoBean.getVideoAddress();
        if (CommonUtils.isEmpty(url)) {
            Toast.makeText(VideoPlayerActivity.this, "视频文件地址为空", Toast.LENGTH_SHORT).show();
            finish();
        }
        mPlayer = new PlayerView(this);
        mPlayer.setTitle(videoBean.getVideoName())
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
