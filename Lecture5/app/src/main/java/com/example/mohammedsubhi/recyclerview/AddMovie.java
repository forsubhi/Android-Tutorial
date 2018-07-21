package com.example.mohammedsubhi.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class AddMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask asyncTask = new AsyncTask(AddMovie.this) {
                    @Override
                    public void doInBackground() {
                        try {
                            RestClient restClient = new RestClient("https://www.imona.com/platform/rest/publicService/imona2/movieapp/addMovie");
                            JSONObject jsonObject = new JSONObject();
                            EditText title = (EditText) findViewById(R.id.title);
                            jsonObject.put("title", title.getText().toString());
                            EditText genre = (EditText) findViewById(R.id.genre);
                            jsonObject.put("genre", genre.getText().toString());
                            EditText year = (EditText) findViewById(R.id.year);
                            jsonObject.put("year", year.getText().toString());
                            restClient.setBody(jsonObject.toString());
                            String response = restClient.execute(RestClient.POST);
                            JSONObject movieObject = new JSONObject(response);
                            Movie movie = new Movie();
                            movie.setTitle(movieObject.getString("title"));
                            movie.setYear(movieObject.getString("year"));
                            movie.setGenre(movieObject.getString("genre"));
                            Intent intent = new Intent();
                            intent.putExtra("movie", movie);
                            setResult(RESULT_OK, intent);
                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };

                asyncTask.execute();

            }
        });
    }
}
