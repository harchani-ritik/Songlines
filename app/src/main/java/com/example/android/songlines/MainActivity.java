package com.example.android.songlines;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    public static TextView lyricsText;
    EditText songName, artistName;
    TextView Title,t2,t3;
    Typeface mycustomfont,anotherfont,newfont;
    ProgressBar loader;
    String song_name,artist_Name,link;
    Button b;
    TextView print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        loader=(ProgressBar)findViewById(R.id.progressBar);
        songName = (EditText) findViewById(R.id.editText2);
        artistName = (EditText) findViewById(R.id.editText3);
        lyricsText = (TextView) findViewById(R.id.setLyrics);
        Title=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        b=(Button)findViewById(R.id.button);
        print=(TextView)findViewById(R.id.print);

        loader.setVisibility(View.GONE);
        mycustomfont= Typeface.createFromAsset(getAssets(),"fonts/monoton-regular.ttf");
        Title.setTypeface(mycustomfont);
        anotherfont=Typeface.createFromAsset(getAssets(),"fonts/alice-regular.ttf");
        t2.setTypeface(anotherfont);
        t3.setTypeface(anotherfont);
        b.setTypeface(anotherfont);
        newfont=Typeface.createFromAsset(getAssets(),"fonts/cursive.ttf");
        songName.setTypeface(newfont);
        artistName.setTypeface(newfont);

    }

    public void getLyrics(View v)
    {
        song_name=songName.getText().toString();
        artist_Name=artistName.getText().toString();
        Toast.makeText(getApplicationContext(), "Searching", Toast.LENGTH_SHORT).show();
        taskLoadUp(song_name);
    }

    public void taskLoadUp(String query) {//checks Internet and then starts process
        if (com.example.android.songlines.Function.isNetworkAvailable(getApplicationContext())) {
            DownloadLyrics task = new DownloadLyrics();
            task.execute(query);
        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }

    class DownloadLyrics extends AsyncTask< String, Void, String > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute( );
            loader.setVisibility(View.VISIBLE);

        }
        protected String doInBackground(String...args) {
            String xml = com.example.android.songlines.Function.excuteGet("https://theaudiodb.com/api/v1/json/1/searchtrack.php?s=akon&t=beautiful");
            return xml;
        }
        @Override
        protected void onPostExecute(String xml) {

            try {
                JSONObject json = new JSONObject(xml);
                if (json != null) {
                    JSONArray array=json.getJSONArray("track");
                    JSONObject jo=array.getJSONObject(0);
                    link = jo.getString("strMusicVid");

                    /*lyricsText.setText(json.getString("lyrics"));
                    loader.setVisibility(View.GONE);
                    Intent i=new Intent(MainActivity.this,Lyrics.class);
                    startActivity(i);*/
                    print.setText(link);


                }
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), "Error, Check SongName", Toast.LENGTH_SHORT).show();
            }
            loader.setVisibility(View.GONE);
        }
    }
}
