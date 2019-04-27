package com.example.android.songlines;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Lyrics extends AppCompatActivity {

    TextView title,lyricsTitle,lyrics,K1,K2,K3,K4,K6,K7,V1,V2,V3,V4,V6,V7;//Key-Value Pairs
    Typeface mycustomfont,anotherfont,newfont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lyrics);
        lyrics=(TextView)findViewById(R.id.Lyrics);
        title=(TextView)findViewById(R.id.textView) ;
        lyricsTitle=(TextView)findViewById(R.id.lyricstextview);

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

        lyrics.setText(MainActivity.trackLyrics);
        V1.setText(MainActivity.trackName);
        V2.setText(MainActivity.artName);
        V3.setText(MainActivity.albumName);
        V4.setText(MainActivity.genre);
        V6.setText(MainActivity.yLink);
        V7.setText(MainActivity.des);

        //creating font types
        mycustomfont= Typeface.createFromAsset(getAssets(),"fonts/almedra.ttf");
        anotherfont=Typeface.createFromAsset(getAssets(),"fonts/alice-regular.ttf");
        newfont=Typeface.createFromAsset(getAssets(),"fonts/cursive.ttf");

        //assigning fonts
        lyrics.setTypeface(newfont);
        title.setTypeface(mycustomfont);
        lyricsTitle.setTypeface(mycustomfont);
        K1.setTypeface(anotherfont);
        K2.setTypeface(anotherfont);
        K3.setTypeface(anotherfont);
        K4.setTypeface(anotherfont);
        K6.setTypeface(anotherfont);
        K7.setTypeface(anotherfont);
        V1.setTypeface(newfont);
        V2.setTypeface(newfont);
        V3.setTypeface(newfont);
        V4.setTypeface(newfont);
        V6.setTypeface(newfont);
        V7.setTypeface(newfont);

        //trackName,artName,albumName,genre,mvd,yLink,des

    }
}
