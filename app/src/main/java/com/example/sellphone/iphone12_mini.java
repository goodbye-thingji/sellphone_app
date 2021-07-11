package com.example.sellphone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class iphone12_mini extends AppCompatActivity {
    private ImageView ip12mini;
    private TextView telecom;
    private RadioButton radioButton, radioButton2, radioButton3;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iphone12_mini);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ip12mini = (ImageView) findViewById(R.id.iphone12mini);
        button = (Button)findViewById(R.id.button);
    }


}
