package com.example.sellphone.ui;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sellphone.R;

public class userguide extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_slideshow);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
