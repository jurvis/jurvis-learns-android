package co.jurvis.madbubble;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView debugTextView;
    private Sensor sensorAccelerometer;
    private SensorManager sensorManager;

    private FrameLayout horiVertFrameLayout;
    private FrameLayout horizontalFrameLayout;
    private FrameLayout verticalFrameLayout;

    private ImageView horiVertBubble;
    private ImageView horizontalBubble;
    private ImageView verticalBubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        debugTextView = (TextView)findViewById(R.id.debugText);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        horiVertBubble = (ImageView)findViewById(R.id.horiVertBubble);
        horizontalBubble = (ImageView)findViewById(R.id.horizontalBubble);
        verticalBubble = (ImageView)findViewById(R.id.verticalBubble);

        horiVertFrameLayout = (FrameLayout)findViewById(R.id.horiVertFrameLayout);
        horizontalFrameLayout = (FrameLayout)findViewById(R.id.horizontalFrameLayout);
        verticalFrameLayout = (FrameLayout)findViewById(R.id.verticalFrameLayout);
    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(this, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this, sensorAccelerometer);
    }

    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0] / 9.8f;
        float y = event.values[1] / 9.8f;
        float z = event.values[2];

        double angle = (Math.acos(y) * (180 / Math.PI)) - 90;

        debugTextView.setText("Angle = " + angle + "|| x = " + x + ", y = " + y + ", z = " + z);


        horizontalBubble.setTranslationX(-y * horizontalFrameLayout.getWidth() / 2f);
        verticalBubble.setTranslationY(-x * verticalFrameLayout.getHeight() / 2f);

        horiVertBubble.setTranslationX(-y * horiVertFrameLayout.getWidth() / 2f);
        horiVertBubble.setTranslationY(-x * horiVertFrameLayout.getHeight() / 2f);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
