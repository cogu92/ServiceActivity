package com.example.dell.serviceactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Service1 extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="Service1" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service1);

        Button mbtnStartService = (Button) findViewById(R.id.btn_Start_Service);
        mbtnStartService.setOnClickListener(this);
        Button mbtnStartBoundService = (Button) findViewById(R.id.btn_Start_Bound_Service);
        mbtnStartBoundService.setOnClickListener(this);
        Button mbtnStartIntentService = (Button) findViewById(R.id.btn_Start_Intent_Service);
        mbtnStartIntentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_Start_Service:
                Log.e(Service1.TAG,"btn_Start_Service");

                Intent intent=new Intent(this,CustomStartedService.class);
                startService(intent);
                return;
            case R.id.btn_Start_Bound_Service:
                Log.v(Service1.TAG,"btn_Start_Bound_Service");
                return;
            case R.id.btn_Start_Intent_Service:
                Log.d(Service1.TAG,"btn_Start_Intent_Service");
                Intent intentInt=new Intent(this, ServiceIntent.class );
                startService(intentInt);

                return;
        }


    }
}
