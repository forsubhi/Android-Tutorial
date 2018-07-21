package com.example.mohammedsubhi.recyclerview;

import android.app.Activity;

public abstract class AsyncTask {
    Activity activity;

    public AsyncTask(Activity activity) {
        this.activity = activity;
    }


    public void onPreExecute() {

    }

    public abstract void doInBackground();

    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (activity != null)
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            onPreExecute();
                        }
                    });

                doInBackground();

                if (activity != null)
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            onPostExecute();
                        }
                    });

            }
        }).start();


    }

    public void onPostExecute() {

    }
}
