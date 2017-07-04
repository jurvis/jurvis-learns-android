package co.jurvis.customlistview;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import co.jurvis.customlistview.adapter.ListAdapter;
import co.jurvis.customlistview.model.Song;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Song> songs = new LinkedList<Song>();
        try {
            AssetManager assetManager = getAssets();
            InputStream ims = assetManager.open("songs.json");

            Gson gson = new Gson();
            Reader reader = new InputStreamReader(ims);

            songs = Arrays.asList(gson.fromJson(reader, Song[].class));

        } catch (IOException e) {
            e.printStackTrace();
        }


        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(new ListAdapter(songs));
    }
}
