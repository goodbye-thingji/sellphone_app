package com.example.sellphone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class iphone12pro extends AppCompatActivity {
    private ImageView ip12pro;
    private TextView telecom;
    private RadioButton radioButton, radioButton2, radioButton3;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iphone12pro);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ip12pro = (ImageView) findViewById(R.id.iphone12pro);
        button = (Button)findViewById(R.id.button);
    }


}
