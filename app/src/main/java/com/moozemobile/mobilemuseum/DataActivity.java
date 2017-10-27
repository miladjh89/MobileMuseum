package com.moozemobile.mobilemuseum;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton playbtn , pausebtn;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    SeekBar seekBar2;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        // Action bar back shift
        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        playbtn = (ImageButton) findViewById(R.id.playbtn);
        pausebtn = (ImageButton) findViewById(R.id.pausebtn);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBar.setProgress(curVolume);
        seekBar.setMax(maxVolume);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                               @Override
                                               public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                   audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

                                               }

                                               @Override
                                               public void onStartTrackingTouch(SeekBar seekBar) {

                                               }

                                               @Override
                                               public void onStopTrackingTouch(SeekBar seekBar) {

                                               }
                                           });
        playbtn.setOnClickListener(this);
        pausebtn.setOnClickListener(this);
        mediaPlayer = MediaPlayer.create(this,R.raw.m1);
        mediaPlayer.start();
        seekBar2.setMax(mediaPlayer.getDuration());
        seekBar2.setProgress(0);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar2.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,100);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mediaPlayer != null && fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            mediaPlayer.stop();
            DataActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.playbtn:
                mediaPlayer.start();
                break;
            case R.id.pausebtn:
                mediaPlayer.pause();
                break;

            default:break;
        }
        return;

    }
/*
    @Override
    protected void onStop() {
        Toast.makeText(DataActivity.this,"stop page",Toast.LENGTH_SHORT).show();
        super.onStop();
    }*/
}
