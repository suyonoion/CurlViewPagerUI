package com.mykodetutorial.curlviewpagerui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setResource("activity_main","layout"));
    }
    public int setResource(String name, String Type)
    {
        return getBaseContext().getResources().getIdentifier(name, Type, getBaseContext().getPackageName());
    }
}
