package com.example.devruwanrathnayake.trip_plan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class  Places extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton diyaluma = (ImageButton)findViewById(R.id.imageButton2);
        ImageButton sigiriya = (ImageButton)findViewById(R.id.imageButton3);
        ImageButton ohiya = (ImageButton)findViewById(R.id.imageButton);
        ImageButton arugambay = (ImageButton)findViewById(R.id.imageButton6);

        diyaluma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Places.this,placestovisit.class);
                startActivity(intent);
            }
        });

        sigiriya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Places.this,placestovisit.class);
                startActivity(intent);
            }
        });
        ohiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Places.this,placestovisit.class);
                startActivity(intent);
            }
        });
        arugambay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Places.this,placestovisit.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Places.this,userdetails.class);
                startActivity(intent);
            }
        });
    }


}
