package com.example.sellphone;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private long lastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gAdapter.addItem("아이폰 12 mini", R.drawable.iphone12_1);
        gAdapter.addItem("아이폰 12", R.drawable.iphone12_2);
        gAdapter.addItem("아이폰 12 PRO", R.drawable.iphone12_3);
        gAdapter.addItem("아이폰 12 PRO MAX", R.drawable.iphone12_4);
        gAdapter.addItem("갤럭시 S21", R.drawable.s21_1);
        gAdapter.addItem("갤럭시 S21+", R.drawable.s21_2);
        gAdapter.addItem("갤럭시 S21 Ultra", R.drawable.s21_3);
        gAdapter.addItem("갤럭시 Z Fold", R.drawable.z_1);
        gAdapter.addItem("갤럭시 노트20",R.drawable.note20_1);
        gAdapter.addItem("갤럭시 노트20 Ultra", R.drawable.note20_2);
        gAdapter.addItem("갤럭시 Z Flip (5G)", R.drawable.zflip_5g);
        gAdapter.addItem("갤럭시 Z Flip (LTE)", R.drawable.zflip_lte);

        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        Integer[] posterID = {R.drawable.iphone12_1, R.drawable.iphone12_2,
                R.drawable.iphone12_3, R.drawable.iphone12_4, R.drawable.s21_1, R.drawable.s21_2,
                R.drawable.s21_3, R.drawable.z_1,R.drawable.note20_1, R.drawable.note20_2,
                R.drawable.zflip_5g, R.drawable.zflip_lte};

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);

            imageview.setImageResource(posterID[position]);

            return imageview;
        }

        public void addItem(String s, int iphone12_1) {
        }
    }
    @Override
    public void onBackPressed()
    {
        if(System.currentTimeMillis() - lastTime < 1500){
            finish();
            ActivityCompat.finishAffinity(this);
            System.exit(0);
        }

        Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();

        lastTime = System.currentTimeMillis();
    }

}