package com.example.sellphone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class galaxyzflip5gselect extends AppCompatActivity {
    private ImageView g21;
    private Button button, button2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zflip5gselect);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        button = (Button)findViewById(R.id.mnp);
        button2 = (Button)findViewById(R.id.same);
        findViewById(R.id.mnp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RESTfulAsyncTask restfulAsyncTask = new RESTfulAsyncTask(
                        galaxyzflip5gselect.this,
                        "https://sso1.mju.ac.kr/mju/userCheck.do",
                        "POST",
                        "Loading...",
                        null,
                        null,
                        new AsyncCallback() {
                            @Override
                            public void responseCallback(int statusCode, Set<Map.Entry<String, List<String>>> headers, JSONObject body) {
                                Toast.makeText(getApplicationContext(), body.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                restfulAsyncTask.execute();
            }
        });
        findViewById(R.id.same).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RESTfulAsyncTask restfulAsyncTask = new RESTfulAsyncTask(
                        galaxyzflip5gselect.this,
                        "https://sso1.mju.ac.kr/mju/userCheck.do",
                        "POST",
                        "Loading...",
                        null,
                        null,
                        new AsyncCallback() {
                            @Override
                            public void responseCallback(int statusCode, Set<Map.Entry<String, List<String>>> headers, JSONObject body) {
                                Toast.makeText(getApplicationContext(), body.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                restfulAsyncTask.execute();
            }
        });
    }



}