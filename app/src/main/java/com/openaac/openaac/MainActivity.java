package com.openaac.openaac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;


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
            case "cheese":
                System.out.println("CHEESEBUTTON");
                intent = new Intent(this, CheeseMenu.class);
                break;
            case "burger":
                System.out.println("BURGERBUTTON");
                intent = new Intent(this, BurgerMenu.class);
                break;
            default:
                intent = new Intent(this, MainActivity.class);
        }

        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, "TEST");
        startActivity(intent);
    }
}
