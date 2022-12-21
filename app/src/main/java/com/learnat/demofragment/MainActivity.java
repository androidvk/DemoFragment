package com.learnat.demofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /*
        // Starting a fragment
        Bundle bundle = new Bundle();
        bundle.putString("key", "Hii");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragmentContainerView2, BlankFragment.class, bundle)
                .commit();

        // calling a dialog
        DialogFragment dialogFragment = DemoDialog.newInstance();
        dialogFragment.show(getSupportFragmentManager(), "dialog");*/


       onClicks();
    }

    private void onClicks() {

        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Frag1");
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .add(R.id.fragmentContainerView2, Fragment1.class, bundle)
                        .commit();
            }
        });

        findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Frag2");
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .add(R.id.fragmentContainerView2, BlankFragment.class, bundle)
                        .commit();
            }
        });

        findViewById(R.id.b3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", "Vikash");
                bundle.putInt("age",28);

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .add(R.id.fragmentContainerView2, Frag3.class, bundle)
                        .commit();
            }
        });

        findViewById(R.id.b4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Registration.class)
                        .putExtra("name","vikash")
                        .putExtra("age",28)
                );
            }
        });

    }
}