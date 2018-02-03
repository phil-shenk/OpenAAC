package com.openaac.openaac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;

import java.util.IllegalFormatException;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonPress(View v) {
        // Do something in response to button
        Log.d("msg", v.getTag().toString());
        Intent intent;
        switch(v.getTag().toString()){
            case "shop":
                System.out.println("SHOP BUTTON PRESSED");
                intent = new Intent(this, ShopMenu.class);
                break;
            case "i_want":
                System.out.println("I WANT");
                intent = new Intent(this, IWantMenu.class);
                break;
            case "i_feel":
                System.out.println("I FEEL BUTTON PRESSED");
                intent = new Intent(this, IFeelMenu.class);
                break;
            case "words":
                System.out.println("WORDS BUTTON PRESSED");
                intent = new Intent(this, WordsMenu.class);
                break;
            default:
                intent = null;
        }

        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, "TEST");
        if(intent != null)
            startActivity(intent);
    }
}
