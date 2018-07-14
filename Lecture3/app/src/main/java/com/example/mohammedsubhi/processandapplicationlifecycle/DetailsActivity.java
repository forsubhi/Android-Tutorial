package com.example.mohammedsubhi.processandapplicationlifecycle;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView result = (TextView) findViewById(R.id.result);
                String s = result.getText().toString();
                MainActivity.ip = s;
                ProcessApplication processApplication = (ProcessApplication) getApplication();
                processApplication.ip = s;
                Intent intent = new Intent();
                intent.putExtra("ip",s);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
