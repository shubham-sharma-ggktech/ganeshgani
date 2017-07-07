package com.example.justg.ganesh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class Main2Activity extends Activity implements SensorEventListener {
    Handler handler;
    int flag = 0;
    private Sensor acc, lig, lin;
    private SensorManager sm;
    private SensorManager pm;
    TextView val, val2;
    int y = 1;
    private final Runnable ps = new Runnable() {

        public void run() {
            flag = 1;
            handler.postDelayed(this, 1000);
        }
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        val = (TextView) findViewById(R.id.acc1);
        val2 = (TextView) findViewById(R.id.acc2);
        TextView subtitle1= (TextView) findViewById(R.id.acc1);
        Typeface tf2=Typeface.createFromAsset(getAssets(),"champagne.ttf");
        subtitle1.setTypeface(tf2);
        handler = new Handler();
        pm = (SensorManager) getSystemService(SENSOR_SERVICE);


        lig = pm.getDefaultSensor(Sensor.TYPE_LIGHT);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onResume() {
        super.onResume();
        pm.registerListener(this, lig, SensorManager.SENSOR_DELAY_NORMAL);

        handler.post(ps);
    }

    @Override
    public void onPause() {
        handler.removeCallbacks(ps);
        super.onPause();
    }


    public void onSensorChanged(SensorEvent event) {
        if (flag == 1) {
            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                val2.setText("light readings:\n" + event.values[0]);
                float x = event.values[0];
                if (x < 20) {
                    Intent intent1 = new Intent(Main3Activity.class.getName());
                    startActivity(intent1);
                }
            }

            flag = 0;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main2 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

}