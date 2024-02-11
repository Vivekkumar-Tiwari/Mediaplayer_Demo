package com.example.audio_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnpause1, btnplay1, btnstop1;

        btnpause1 = findViewById(R.id.btnpause);
        btnplay1 = findViewById(R.id.btnplay);
        btnstop1 = findViewById(R.id.btnstop);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);


        String apath = "android.resource://"+getPackageName()+"/raw/song/";
       // String onlineAudiopath = "https:sing.com/android-course/android_11.mp3"


        Uri audioURI = Uri.parse(apath);
        // we are use try and ctach fr reduce the runtime error
        try {
            mp.setDataSource(this,audioURI);
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnpause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mp.pause();
            }
        });

        btnstop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mp.pause();
            mp.seekTo(0);
            }
        });

        btnplay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // it is used for playlist , when a song is finish then next song is start .
                // we can add new song ..
            }
        });
    }
}