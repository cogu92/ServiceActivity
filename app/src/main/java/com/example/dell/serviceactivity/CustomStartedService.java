package com.example.dell.serviceactivity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CustomStartedService extends Service {

    private static final String TAG = CustomStartedService.class.getSimpleName();

    public CustomStartedService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();


        Log.e(CustomStartedService.TAG, "In-onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Waitforasecont(20);
        Log.i(CustomStartedService.TAG, "In-onStartCommand");
        return Service.START_NOT_STICKY;
    }

    public static void Waitforasecont(int i) {
        int timeLapseSeconts = i;
        long endTime = System.currentTimeMillis() + timeLapseSeconts * 100;
        while (System.currentTimeMillis() < endTime) {

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
        //   throw new UnsupportedOperationException("Not yet implemented");
    }
}
