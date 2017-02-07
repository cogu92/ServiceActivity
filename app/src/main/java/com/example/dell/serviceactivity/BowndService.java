package com.example.dell.serviceactivity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import java.io.FileDescriptor;
import java.util.Random;

public class BowndService extends Service {
    private static final String TAG =  BowndService.class.getSimpleName();
    private IBinder nBinder = new Binder();
    
    public BowndService (IBinder service)
    {
        Log.d(TAG, "BowndService: Launch");

        this.nBinder=service;
    }

    public BowndService() {
        Log.d(TAG, "BowndService: ");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
    return nBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "UnBind: ");
        return super.onUnbind(intent);
    }
    public int getRandomNumber(){
       Random RandomNumber=new Random();
        return RandomNumber.nextInt();

    }
}
