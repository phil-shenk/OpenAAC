package com.openaac.openaac;

import android.speech.tts.TextToSpeech;

/**
 * Created by Phil on 2/3/2018.
 */

public class Speech2 {

    public static TextToSpeech tts;
    public static String words = "";
    public static void addWordToQueue(String word) {
        words += " " + word;
    }

}
