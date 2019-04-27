package com.example.android.songlines;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
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

public class MainActivity extends AppCompatActivity {

    public static String trackLyrics;
    public static String trackName,artName,albumName,genre,mvd,des,yLink;

    public static TextView lyricsText;
    EditText songName, artistName;
    TextView Title,t2,t3;
    Typeface mycustomfont,anotherfont,newfont;
    ProgressBar loader;
    String song_name,artist_Name,obj;
    Button b;
    EditText print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        loader=(ProgressBar)findViewById(R.id.progressBar);
        songName = (EditText) findViewById(R.id.editText2);
        artistName = (EditText) findViewById(R.id.editText3);
        Title=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        b=(Button)findViewById(R.id.button);
        print=(EditText) findViewById(R.id.print);

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
            String xml = com.example.android.songlines.Function.excuteGet("https://api.lyrics.ovh/v1/"+artist_Name+"/"+song_name);
            obj = com.example.android.songlines.Function.excuteGet("https://www.theaudiodb.com/api/v1/json/1/searchtrack.php?s="+artist_Name+"&t="+song_name);
            return xml;
        }
        @Override
        protected void onPostExecute(String xml) {

            try {
                JSONObject json = new JSONObject(xml);
                JSONObject json2= new JSONObject(obj);
                if (json != null) {
                    trackLyrics=json.getString("lyrics");

                    JSONArray array=json2.getJSONArray("track");
                    JSONObject jo=array.getJSONObject(0);
                    //trackName,artName,albumName,genre,mvd,des,yLink
                    trackName=jo.getString("strTrack");
                    artName=jo.getString("strArtist");
                    albumName=jo.getString("strAlbum");
                    genre=jo.getString("strGenre");
                    mvd=jo.getString("strMusicVidDirector");
                    des=jo.getString("strDescriptionEN");
                    yLink = jo.getString("strMusicVid");

                    Intent i=new Intent(MainActivity.this,Lyrics.class);
                    startActivity(i);
                }
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), "Error, Check SongName", Toast.LENGTH_SHORT).show();
            }
            loader.setVisibility(View.GONE);
        }
    }
}
