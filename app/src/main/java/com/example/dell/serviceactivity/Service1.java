package com.example.dell.serviceactivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Service1 extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Service1";
    private TextView mTxtVwAction;
    private EditText mEdtTxt;
  private boolean IsBownd=false;
    private   BowndService mBownService;
    private ServiceConnection mServiceConection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            mBownService=new BowndService(service);
            IsBownd=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            IsBownd=false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service1);
        Button btnStartService = (Button) findViewById(R.id.btn_Start_Service);
        btnStartService.setOnClickListener(this);
        Button btnStartBoundService = (Button) findViewById(R.id.btn_Start_Bound_Service);
        btnStartBoundService.setOnClickListener(this);
        Button btnStartIntentService = (Button) findViewById(R.id.btn_Start_Intent_Service);
        btnStartIntentService.setOnClickListener(this);
        Button btnDispInfo = (Button) findViewById(R.id.btn_Disp_Info);
        btnDispInfo.setOnClickListener(this);
        mEdtTxt= (EditText) findViewById(R.id.edtTxtInputInfo);
        mTxtVwAction=(TextView)findViewById(R.id.txt_View_Action);
        mTxtVwAction.setText("Hello Nicolas");


        //edtTxtInputInfo

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Disp_Info:
                Log.d(Service1.TAG, "btn_Disp_Info");
                if(IsBownd) {
                    int num = this.mBownService.getRandomNumber();
                    Log.d(Service1.TAG, "btn_Disp_Info" + num);
                    mTxtVwAction.setText("" + num);
                }
                else{
                    Toast.makeText(this,"Service Not Started", Toast.LENGTH_SHORT).show();
                }
                    break;
                    case R.id.btn_Start_Service:
                        Log.d(Service1.TAG, "btn_Start_Service");
                        Intent intent = new Intent(this, CustomStartedService.class);
                        startService(intent);
                        break;
                    case R.id.btn_Start_Bound_Service:
                        Log.d(Service1.TAG, "btn_Start_Bound_Service");
                        Intent Bowndintent = new Intent(this, BowndService.class);
                        bindService(Bowndintent, mServiceConection, Context.BIND_AUTO_CREATE);
                        break;
                    case R.id.btn_Start_Intent_Service:
                        Log.d(Service1.TAG, "btn_Start_Intent_Service");
                        Intent intentInt = new Intent(this, ServiceIntent.class);
                        startService(intentInt);
                        break;

        }


    }
}
