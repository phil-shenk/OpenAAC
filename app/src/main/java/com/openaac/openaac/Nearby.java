package com.openaac.openaac;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Nearby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=40.4442530,-79.9532390&radius=500&type=bar&key=AIzaSyDLnJE39mhOXOe2KJ06p07OZryXom86awk");
                    HttpURLConnection request = (HttpURLConnection) url.openConnection();
                    request.connect();


                    InputStreamReader in = new InputStreamReader((InputStream) request.getContent());
                    BufferedReader buff = new BufferedReader(in);

                    String line;
                    StringBuffer text = new StringBuffer();
                    do {
                        line = buff.readLine();
                        text.append(line + "\n");
                    } while (line != null);

                    // System.out.println(text.toString());
                    JSONObject json = new JSONObject(text.toString());
                    System.out.println(((JSONObject) json.getJSONArray("results").get(0)).get("name"));

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();
    }

}
