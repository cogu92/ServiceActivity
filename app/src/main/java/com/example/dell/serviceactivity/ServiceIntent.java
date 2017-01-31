package com.example.dell.serviceactivity;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class ServiceIntent extends IntentService {
    private static final String TAG = CustomStartedService.class.getSimpleName();
    public ServiceIntent() {
        super(null);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        CustomStartedService.Waitforasecont(20);
        Log.i(ServiceIntent.TAG , "In-onHandleIntent");

    }
}
