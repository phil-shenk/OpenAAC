package com.openaac.openaac;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Locale;

public class IFeelMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ifeel_menu);
    }

    public void buttonPress(View v){
        Speech2.addWordToQueue(v.getTag().toString());
        Speech2.sayQueue();
        startActivity(new Intent(this, MainActivity.class));
    }
}
