package com.example.android.songlines;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Lyrics extends AppCompatActivity {

    TextView LYRICS;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lyrics);

        LYRICS=(TextView)findViewById(R.id.Lyrics);
        s=MainActivity.lyricsText.getText().toString();
        LYRICS.setText(s);
    }
}
