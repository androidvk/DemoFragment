package com.learnat.demofragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class Registration extends AppCompatActivity {
    private static final String TAG = "Registration";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        String name=getIntent().getStringExtra("name");
        int age=getIntent().getIntExtra("age",0);

        Log.e(TAG, "onCreate: "+name );
        Log.e(TAG, "onCreate: "+age );

        SharedPreferences sharedPreferences =
                getSharedPreferences("SharedPref", MODE_PRIVATE);
    }
}