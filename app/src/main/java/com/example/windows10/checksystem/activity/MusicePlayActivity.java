package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.adapter.CommonRecyclerViewAdapter;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.CheckDetailsAllBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityMusicePlayBinding;
import com.example.windows10.checksystem.databinding.MusicPlayItemLayoutBinding;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;

import java.io.IOException;

public class MusicePlayActivity extends BaseActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener {

    private ActivityMusicePlayBinding mBinding;
    private CheckDetailsAllBean.ProblemListBean mBean;
    private CommonRecyclerViewAdapter<MusicPlayItemLayoutBinding, CheckDetailsAllBean.ProblemListBean.VoiceListBean> mAdapter;
    private MediaPlayer mPlayer;
    private IOSLoadingDialog iosLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_musice_play);
        mIntent = getIntent();
        mBean = (CheckDetailsAllBean.ProblemListBean) mIntent.getSerializableExtra(Constants.INTENT_DETAILS_CHECK_ALL);
        initView();
    }

    private void initView() {
        mBinding.rlvMusicplay.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mAdapter = new CommonRecyclerViewAdapter<MusicPlayItemLayoutBinding, CheckDetailsAllBean.ProblemListBean.VoiceListBean>(this, R.layout.music_play_item_layout) {
            @Override
            public void bindData(MusicPlayItemLayoutBinding binding, int position) {
                binding.tvMusicPlayItem.setText(mData.get(position).getVoiceName());
                binding.tvMusicPlayItem.setTag(R.id.position_tag, position);
                binding.tvMusicPlayItem.setOnClickListener(MusicePlayActivity.this);
            }
        };
        mBinding.rlvMusicplay.setAdapter(mAdapter);
        mAdapter.refresh(mBean.getVoiceList());
        mBinding.btnMusicPlayQitaqixiuchang.setOnClickListener(this);
        mBinding.btnMusicPlayTuijianqixiuchang.setOnClickListener(this);
        mBinding.includeMusicPlay.ivTitleBack.setOnClickListener(this);
        mBinding.includeMusicPlay.tvTitleTitle.setText("详细检测");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_title_back:
                finish();
                break;
            case R.id.btn_music_play_tuijianqixiuchang:
                //推荐汽修厂

                break;
            case R.id.btn_music_play_qitaqixiuchang:
                //其他汽修厂

                break;
            case R.id.tv_music_play_item:
                //播放音频
                playMusic(mBean.getVoiceList().get((int) v.getTag(R.id.position_tag)).getVoiceAddress());
                break;

        }

    }

    private void playMusic(String voiceAddress) {
        if (mPlayer == null) {
            mPlayer = new MediaPlayer();
            mPlayer.setOnPreparedListener(this);
            mPlayer.setOnCompletionListener(this);
            mPlayer.setOnInfoListener(this);
            mPlayer.setOnErrorListener(this);

        }
        Log.e("TAG", "音频的地址为：" + SystemApplication.BASE_AUDIO_URL + voiceAddress);
        Uri uri = Uri.parse(SystemApplication.BASE_AUDIO_URL + voiceAddress);
        try {
            if (mPlayer.isPlaying()) {
                mPlayer.reset();
            }
            mPlayer.setDataSource(this, uri);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        pauseMusic();
    }

    //暂停播放音乐
    private void pauseMusic() {
        if (mPlayer == null) {
            return;
        }
        mPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumeMusic();
    }

    //恢复播放音乐
    private void resumeMusic() {
        if (mPlayer == null) {
            return;
        }
        mPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyMusic();
    }

    private void destroyMusic() {
        if (mPlayer == null) {
            return;
        }
        mPlayer.stop();
        mPlayer.release();
        mPlayer = null;
    }

    private void stopMusic() {
        if (mPlayer != null)
            mPlayer.stop();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        showIOSLoading();
    }

    private void showIOSLoading() {
        iosLoading = CommonUtils.showIOSLoadingDialog(this);
    }

    private void dismissIOSLoading() {
        if (iosLoading != null) {
            iosLoading.dismiss();
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stopMusic();
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        dismissIOSLoading();
        return true;
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        dismissIOSLoading();
        Toast.makeText(MusicePlayActivity.this, "播放出错", Toast.LENGTH_SHORT).show();
        stopMusic();
        return false;
    }
}
