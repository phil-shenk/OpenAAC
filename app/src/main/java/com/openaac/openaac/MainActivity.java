package com.openaac.openaac;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.IllegalFormatException;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    //public TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Speech2.tts = new TextToSpeech(this, null);

    }

    public void buttonPress(View v) {
        // Do something in response to button
        Log.d("msg", v.getTag().toString());
        Intent intent = null;
        switch(v.getTag().toString()){
            case "shop":
                Speech2.addWordToQueue("I'd like to buy");
                intent = new Intent(this, ShopMenu.class);
                break;
            case "i_want":
                Speech2.addWordToQueue("I want");
                intent = new Intent(this, IWantMenu.class);
                break;
            case "i_feel":
                Speech2.addWordToQueue("I feel");
                intent = new Intent(this, IFeelMenu.class);
                break;
            case "words":
                intent = new Intent(this, WordsMenu.class);
                break;
            default:
                Speech2.immedatelySay(v.getTag().toString());
                intent = null;
                break;
        }

        if(intent != null)
            startActivity(intent);
    }

}
