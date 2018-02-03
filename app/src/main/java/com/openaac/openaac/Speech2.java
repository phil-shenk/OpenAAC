package com.openaac.openaac;

import android.speech.tts.TextToSpeech;

import org.w3c.dom.Text;

/**
 * Created by Phil on 2/3/2018.
 */

public class Speech2 {

    public static TextToSpeech tts;
    public static String words = "";

    public static void addWordToQueue(String word) {
        words += " " + word;
        System.out.println("WORDS: "+words);
    }

    public static void immedatelySay(String word){
        tts.speak(word, TextToSpeech.QUEUE_ADD, null);
    }

    public static void clearQueue(){
        words = "";
    }

    public static void sayQueue(){
        tts.speak(words, TextToSpeech.QUEUE_ADD, null);
        clearQueue();
    }

}
