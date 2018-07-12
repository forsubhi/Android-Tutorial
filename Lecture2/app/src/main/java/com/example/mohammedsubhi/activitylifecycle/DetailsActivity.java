package com.example.mohammedsubhi.activitylifecycle;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    Integer clickCounts = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Log.d("test", "onCreate called");

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this,SubDetailsActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCounts++;
                Toast.makeText(DetailsActivity.this,"click added",Toast.LENGTH_SHORT).show();

            }
        });

        findViewById(R.id.showClicks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this,String.valueOf(clickCounts),Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.openDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailsActivity.this);
                TextView textView = new TextView(DetailsActivity.this);
                textView.setText("Test Dialog");
                builder.setView(textView);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test", "onResume called");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test", "onStart called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test", "onPause called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test", "onDestroy called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("test", "onRestart called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test", "onStop called");

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clickCounts = savedInstanceState.getInt("clickCounts");
        Log.d("test", "onRestoreInstanceState called");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clickCounts",clickCounts);
        Log.d("test", "onSaveInstanceState called");


    }
}
