package com.boilerplatecode.threadbasic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button btnStart, btnStop;

private volatile boolean stopThread=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.buttonStart);
        btnStop = findViewById(R.id.buttonStop);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThread();
            }
        });

btnStop.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
        stopThread();
    }
});
    }


public void startThread ()
{

    stopThread=false;
    RunnableSolo runnable = new RunnableSolo();
    new Thread(runnable).start();



}

public void stopThread()
{
    Log.d( "***************", "StopStopStop");
    stopThread=true;

}


    class RunnableSolo implements  Runnable {
        @Override
        public void run() {

            for (int i = 1; i < 10; i++) {
                if (stopThread) return;

                Log.d( "***************", "runnable: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
