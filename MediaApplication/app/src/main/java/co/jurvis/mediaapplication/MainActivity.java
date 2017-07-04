package co.jurvis.mediaapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button babyButton = (Button)findViewById(R.id.babyBtn);
        Button manButton = (Button)findViewById(R.id.manBtn);
        Button playVidButton = (Button)findViewById(R.id.playVidBtn);
        final ImageView imageView = (ImageView)findViewById(R.id.imageView);

        babyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.cute_baby);
                playSound(R.raw.baby);
            }
        });

        manButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.laughing_man);
                playSound(R.raw.man);
            }
        });

        playVidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void playSound(int resId) {
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, resId);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                mp.release();
            }
        });
    }
}
