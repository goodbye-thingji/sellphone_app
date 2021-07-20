package com.example.sellphone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class iphone12_mini_lowest_price extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iphone12_mini_lowest_price);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ListView listView = findViewById(R.id.lv_lowest_price);
        List<String> list = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse("https://pf.kakao.com/_Fxlxgjxb");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        list.add("부평역 악어집  30,000 원");
        list.add("신도림 테크노마트  110,000 원");
        list.add("노원역 와우쇼핑몰  70,000 원");
        list.add("강서 동네폰  90,000 원");
        list.add("서초 국제전자센터  150,000 원");
        list.add("송파 가든파이브 주영이네  50,000 원");
        list.add("강변 테크노마트  120,000 원");
    }
}