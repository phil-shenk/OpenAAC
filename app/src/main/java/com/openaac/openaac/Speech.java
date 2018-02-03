package com.openaac.openaac;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.Locale;


public class Speech extends AppCompatActivity implements TextToSpeech.OnInitListener, Button.OnClickListener{
    private TextToSpeech tts;
    private String words = "";

    public Speech(Context con) {
        /**Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, 1234);*/
        tts = new TextToSpeech(con, this);
        onInit(100);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1234) {
            tts = new TextToSpeech(this, this);
        } else {
            Intent installIntent = new Intent();
            installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
            startActivity(installIntent);
        }
    }

    public void addWordToQueue(String word) {
        words += " " + word;
    }

    public void speak() {
        tts.speak(words, TextToSpeech.QUEUE_FLUSH, null);
        words = "";
    }

    @Override
    public void onInit(int i) {
        tts.setLanguage(Locale.US);
        tts.speak("This worked well", TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onClick(View view) {
        addWordToQueue(view.getTag().toString());
    }
}
