package co.jurvis.timerapp;

import android.content.DialogInterface;
import android.icu.util.TimeUnit;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    TextView timerTextView;
    Button oneMinuteBtn;
    Button twoMinuteBtn;
    Button threeMinuteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = (TextView)findViewById(R.id.timerTextView);
        oneMinuteBtn = (Button)findViewById(R.id.oneMinuteBtn);
        twoMinuteBtn = (Button)findViewById(R.id.twoMinuteBtn);
        threeMinuteBtn = (Button)findViewById(R.id.threeMinuteBtn);

        oneMinuteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer = getCountDownTimer(1);
                countDownTimer.start();
                twoMinuteBtn.setEnabled(false);
                threeMinuteBtn.setEnabled(false);
            }
        });
        twoMinuteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer = getCountDownTimer(2);
                countDownTimer.start();
                oneMinuteBtn.setEnabled(false);
                threeMinuteBtn.setEnabled(false);
            }
        });
        threeMinuteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer = getCountDownTimer(3);
                countDownTimer.start();
                oneMinuteBtn.setEnabled(false);
                twoMinuteBtn.setEnabled(false);
            }
        });
    }

    private CountDownTimer getCountDownTimer(int minutes) {
        return new CountDownTimer(minutes * 60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long inSeconds = millisUntilFinished / 1000;
                timerTextView.setText(String.format("%02d:%02d", (inSeconds % 3600) / 60, inSeconds % 60));
            }

            @Override
            public void onFinish() {
                timerTextView.setText("00:00");
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Timer Finished!")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
                oneMinuteBtn.setEnabled(true);
                twoMinuteBtn.setEnabled(true);
                threeMinuteBtn.setEnabled(true);
            }
        };
    }
}
