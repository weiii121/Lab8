package com.example.lab8;

import static android.text.TextUtils.TruncateAt.START;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import java.security.Provider;

public class MyService1 extends Service {
    public  void onCreate(){
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Intent intent = new Intent(MyService1.this, MainActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyService1.this.startActivity(intent);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        stopSelf();
    }

    @Override
    public int onStartCommand (Intent intent, int flags, int startId){
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy(){super.onDestroy();}

    @Override
    public IBinder onBind(Intent intent){
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
