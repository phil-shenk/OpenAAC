package com.openaac.openaac;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NearbyStuff extends AppCompatActivity {

    class GetNearbyStuff implements Callable<ArrayList<String>> {

        @Override
        public ArrayList<String> call() throws Exception {
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
                ArrayList<String> ret = new ArrayList<String>();
                ret.add((String) ((JSONObject) json.getJSONArray("results").get(0)).get("name"));
                ret.add((String) ((JSONObject) json.getJSONArray("results").get(1)).get("name"));
                ret.add((String) ((JSONObject) json.getJSONArray("results").get(2)).get("name"));
                ret.add((String) ((JSONObject) json.getJSONArray("results").get(3)).get("name"));

                return ret;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_stuff);
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

        ((Button) findViewById(R.id.nearby1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Speech2.addWordToQueue((((Button) findViewById(R.id.nearby1)).getText()).toString());
                Speech2.sayQueue();
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });
        ((Button) findViewById(R.id.nearby2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Speech2.addWordToQueue((((Button) findViewById(R.id.nearby2)).getText()).toString());
                Speech2.sayQueue();
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });
        ((Button) findViewById(R.id.nearby3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Speech2.addWordToQueue((((Button) findViewById(R.id.nearby3)).getText()).toString());
                Speech2.sayQueue();
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });
        ((Button) findViewById(R.id.nearby4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Speech2.addWordToQueue((((Button) findViewById(R.id.nearby4)).getText()).toString());
                Speech2.sayQueue();
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });


        ExecutorService service =  Executors.newSingleThreadExecutor();
        GetNearbyStuff g = new GetNearbyStuff();
        Future<ArrayList<String>> future = service.submit(g);
        try {
            ArrayList<String> results = future.get();
            ((Button) findViewById(R.id.nearby1)).setText(results.get(0));
            ((Button) findViewById(R.id.nearby2)).setText(results.get(1));
            ((Button) findViewById(R.id.nearby3)).setText(results.get(2));
            ((Button) findViewById(R.id.nearby4)).setText(results.get(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
