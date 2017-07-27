package com.canguangliu.getimsi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TelephonyManager tm;
    Button get_imsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        get_imsi = (Button) findViewById(R.id.get_imsi);
        get_imsi.setOnClickListener(this);
    }

    private String GetSimSPN(){
        return tm.getSimOperatorName();
    }

    private String GetSimISMSI(){
        return tm.getSubscriberId();
    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(this,"get IMSI",Toast.LENGTH_LONG).show();
        String getIMSI = GetSimISMSI();
        switch(view.getId()){
            case R.id.get_imsi:
                if( getIMSI!= null){
                    if(getIMSI.startsWith("46000") || getIMSI.startsWith("46002")){
                        Toast.makeText(this,"CMCC",Toast.LENGTH_LONG).show();
                    }else if(getIMSI.startsWith("46001")){
                        Toast.makeText(this,"CU",Toast.LENGTH_LONG).show();
                    }else if(getIMSI.startsWith("46003")){
                        Toast.makeText(this,"CT",Toast.LENGTH_LONG).show();
                    }
                }
                return;
        }
    }
}
