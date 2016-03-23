package com.akshaykhanna.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  int seconds=0;
    private  boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runStopWatch();
    }

    private void runStopWatch()
    {
        final TextView tv = (TextView) findViewById(R.id.tv_timer);
        final Handler handler = new Handler();
        handler.post(new Runnable()

        {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, sec);
                tv.setText(time);
                if (running) {
                    seconds += 1;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void onButtomStart(View v)
    {
        //Toast.makeText(this,"Start",Toast.LENGTH_SHORT).show();
        running=true;
    }
    public void onButtomStop(View v)
    {
        //Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();
        running=false;
    }
    public void onButtomReset(View v)
    {
       // Toast.makeText(this,"Reset",Toast.LENGTH_SHORT).show();
        running=false;
        seconds=0;
    }
}
