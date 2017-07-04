package co.jurvis.mediaapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        final VideoView videoView = (VideoView)findViewById(R.id.videoView);
        final Button playPauseBtn = (Button)findViewById(R.id.playPauseBtn);
        videoView.setVideoURI(getVideoURI());
        videoView.start();

        playPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                    playPauseBtn.setText(R.string.label_pause);
                } else {
                    videoView.start();
                    playPauseBtn.setText(R.string.label_play);
                }
            }
        });
    }

    private Uri getVideoURI() {
        String uriString = "android.resource://" + getPackageName() + "/" + R.raw.rabbid;
        return Uri.parse(uriString);
    }
}
