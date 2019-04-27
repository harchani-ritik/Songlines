package com.example.android.songlines;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Lyrics extends AppCompatActivity {

    TextView lyrics,K1,K2,K3,K4,K6,K7,V1,V2,V3,V4,V6,V7;
    Typeface lyricsfonts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lyrics);
        lyrics=(TextView)findViewById(R.id.Lyrics);
        lyrics.setText(MainActivity.trackLyrics);

        K1=(TextView)findViewById(R.id.k1);
        K2=(TextView)findViewById(R.id.k2);
        K3=(TextView)findViewById(R.id.k3);
        K4=(TextView)findViewById(R.id.k4);
        K6=(TextView)findViewById(R.id.k6);
        K7=(TextView)findViewById(R.id.k7);

        V1=(TextView)findViewById(R.id.v1);
        V2=(TextView)findViewById(R.id.v2);
        V3=(TextView)findViewById(R.id.v3);
        V4=(TextView)findViewById(R.id.v4);
        V6=(TextView)findViewById(R.id.v6);
        V7=(TextView)findViewById(R.id.v7);

        V1.setText(MainActivity.trackName);
        V2.setText(MainActivity.artName);
        V3.setText(MainActivity.albumName);
        V4.setText(MainActivity.genre);
        V6.setText(MainActivity.yLink);
        V7.setText(MainActivity.des);

        lyricsfonts=Typeface.createFromAsset(getAssets(),"fonts/cursive.ttf");
        lyrics.setTypeface(lyricsfonts);

        //trackName,artName,albumName,genre,mvd,yLink,des

    }
}
