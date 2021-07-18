package com.example.sellphone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class iphone12pro extends AppCompatActivity {
    private ImageView ip12pro;
    private Button button;
    String[] telecom = {"=== 선택하세요 ===","SKT(5G) / 89000원", "KT(5G) / 90000원", "LG U+(5G) / 85000원"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iphone12pro);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, telecom
        );

        // 드롭다운 클릭 시 선택 창
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinner.setAdapter(adapter);

        // 스피너에서 선택 했을 경우 이벤트 처리

        ip12pro = (ImageView) findViewById(R.id.iphone12pro);
        button = (Button)findViewById(R.id.bt1);
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), iphone12proselect.class);
                startActivity(i);

            }
        });
    }

}
