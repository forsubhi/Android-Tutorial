package com.example.mohammedsubhi.processandapplicationlifecycle;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int getTheIp = 10;
    Button button1 ;
    static String ip ="";
    boolean firstTimeExecuted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                startActivityForResult(intent, getTheIp);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==getTheIp&&resultCode==RESULT_OK)
        {
         // button1.setText(data.getStringExtra("ip"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(firstTimeExecuted) {
            ProcessApplication processApplication = (ProcessApplication) getApplication();
            button1.setText(processApplication.ip);
        }
        firstTimeExecuted = true;
    }
}
