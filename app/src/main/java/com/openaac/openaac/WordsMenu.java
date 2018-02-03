package com.openaac.openaac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class WordsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_menu);
    }

    public void buttonPress(View v){
        Speech2.addWordToQueue(v.getTag().toString());
        Speech2.sayQueue();
        startActivity(new Intent(this, MainActivity.class));
    }
}
