package com.example.justg.ganesh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {
    private Button button1,b11,b2;
    TextView vt;
    private static final String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface tf1=Typeface.createFromAsset(getAssets(),"membra.ttf");
        TextView subtitle1= (TextView) findViewById(R.id.subtitle1);
        Typeface tf2=Typeface.createFromAsset(getAssets(),"membra.ttf");
        TextView heading1=(TextView) findViewById(R.id.heading1);
        heading1.setTypeface(tf2);
        subtitle1.setTypeface(tf1);
        button1= (Button) findViewById(R.id.button1);
        button1.setOnClickListener(MainActivity.this);
        b2= (Button) findViewById(R.id.vt);

        b11= (Button) findViewById(R.id.b11);
        b11.setBackgroundColor(0x00ffff00);
        button1.setBackgroundColor(0x00ffff00);
        b2.setBackgroundColor(0x00ffff00);
        b11.setOnClickListener(MainActivity.this);
        b2.setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button1) {
            Intent intent = new Intent(Main2Activity.class.getName());
            startActivity(intent);
        }
        else if(v.getId()==R.id.b11)
        {
            Intent intent1 = new Intent(Main4Activity.class.getName());
            startActivity(intent1);

        }
        else if(v.getId()==R.id.vt)
        {
            Intent intent2 = new Intent(Main5Activity.class.getName());
            startActivity(intent2);

        }

    }
}
   


this is file is modifed but not staged lets find difference between prev versions
