package com.example.android.songlines;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Lyrics extends AppCompatActivity {

    TextView lyrics;
    Typeface lyricsfonts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lyrics);
        lyrics=(TextView)findViewById(R.id.Lyrics);
        lyrics.setText(MainActivity.trackLyrics);

        lyricsfonts=Typeface.createFromAsset(getAssets(),"fonts/cursive.ttf");
        lyrics.setTypeface(lyricsfonts);

    }
}
