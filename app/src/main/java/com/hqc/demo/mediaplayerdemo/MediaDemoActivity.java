package com.hqc.demo.mediaplayerdemo;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import com.hqc.demo.R;
import com.hqc.demo.utils.LogUtils;

import java.io.IOException;


public class MediaDemoActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "MediaDemoActivity";

    private MediaPlayer mMediaPlayer;
    private Button bt_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_demo);
        bt_stop = (Button) findViewById(R.id.bt_stop);
        bt_stop.setOnClickListener(this);
//        mMediaPlayer = MediaPlayer.create(R.raw.flash);
        mMediaPlayer = new MediaPlayer();
        play();
    }

    private void play() {
        String defaultUri = Settings.System.getString(
                this.getContentResolver(), Settings.System.ALARM_ALERT);
        try {
            mMediaPlayer.setDataSource(this, Uri.parse(defaultUri));
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
            mMediaPlayer.setLooping(true);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
            mMediaPlayer.stop();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_stop:
                if (mMediaPlayer != null){
                    LogUtils.d(TAG,"mMediaPlayer.stop()");
//                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                }
                break;
            default:
                break;
        }
    }
}
