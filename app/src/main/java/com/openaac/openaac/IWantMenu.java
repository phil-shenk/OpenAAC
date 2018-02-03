package com.openaac.openaac;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IWantMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iwant_menu);
    }

    public void buttonPress(View v){
        Speech2.addWordToQueue(v.getTag().toString());
        Speech2.sayQueue();
        startActivity(new Intent(this, MainActivity.class));
    }
}
