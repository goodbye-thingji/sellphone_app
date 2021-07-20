package com.example.sellphone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity<phone1> extends AppCompatActivity {
    private static final String TAG = "Main_Activity";
    private static final int RC_SIGN_IN = 5252;

    private ImageView ivMenu;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private long lastTime;
    ImageView phone, phone2, phone3, phone4, phone5, phone6, phone7, phone8, phone9, phone10, phone11, phone12;

    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInAccount account;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = (ImageView) findViewById(R.id.iv1);
        phone2 = (ImageView) findViewById(R.id.iv2);
        phone3 = (ImageView) findViewById(R.id.iv3);
        phone4 = (ImageView) findViewById(R.id.iv4);
        phone5 = (ImageView) findViewById(R.id.iv5);
        phone6 = (ImageView) findViewById(R.id.iv6);
        phone7 = (ImageView) findViewById(R.id.iv7);
        phone8 = (ImageView) findViewById(R.id.iv8);
        phone9 = (ImageView) findViewById(R.id.iv9);
        phone10 = (ImageView) findViewById(R.id.iv10);
        phone11 = (ImageView) findViewById(R.id.iv11);
        phone12 = (ImageView) findViewById(R.id.iv12);
        phone.setOnClickListener(this::onClick);
        phone2.setOnClickListener(this::onClick);
        phone3.setOnClickListener(this::onClick);
        phone4.setOnClickListener(this::onClick);
        phone5.setOnClickListener(this::onClick);
        phone6.setOnClickListener(this::onClick);
        phone7.setOnClickListener(this::onClick);
        phone8.setOnClickListener(this::onClick);
        phone9.setOnClickListener(this::onClick);
        phone10.setOnClickListener(this::onClick);
        phone11.setOnClickListener(this::onClick);
        phone12.setOnClickListener(this::onClick);
        ivMenu = findViewById(R.id.iv_menu);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);

        //액션바 변경하기(들어갈 수 있는 타입 : Toolbar type
        setSupportActionBar(toolbar);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 클릭됨");
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            Toast.makeText(getApplicationContext(), "반갑습니다, " + account.getDisplayName() + " 님", Toast.LENGTH_SHORT).show();
        } else {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv1:
                Intent it = new Intent(this, iphone12_mini.class);
                startActivity(it);
                break;
            case R.id.iv2:
                Intent it2 = new Intent(this, iphone12.class);
                startActivity(it2);
                break;
            case R.id.iv3:
                Intent it3 = new Intent(this, iphone12pro.class);
                startActivity(it3);
                break;
            case R.id.iv4:
                Intent it4 = new Intent(this, iphone12promax.class);
                startActivity(it4);
                break;
            case R.id.iv5:
                Intent it5 = new Intent(this, galaxys21.class);
                startActivity(it5);
                break;
            case R.id.iv6:
                Intent it6 = new Intent(this, galaxys21plus.class);
                startActivity(it6);
                break;
            case R.id.iv7:
                Intent it7 = new Intent(this, galaxys21ultra.class);
                startActivity(it7);
                break;
            case R.id.iv8:
                Intent it8 = new Intent(this, galaxyzfold.class);
                startActivity(it8);
                break;
            case R.id.iv9:
                Intent it9 = new Intent(this, galaxynote20.class);
                startActivity(it9);
                break;

            case R.id.iv10:
                Intent it10 = new Intent(this, galaxynote20ultra.class);
                startActivity(it10);
                break;
            case R.id.iv11:
                Intent it11 = new Intent(this, galaxyzflip5g.class);
                startActivity(it11);
                break;
            case R.id.iv12:
                Intent it12 = new Intent(this, galaxyzfliplte.class);
                startActivity(it12);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            account = completedTask.getResult(ApiException.class);
            // TODO: Server-side Authentication of account.getIdToken()
            Toast.makeText(getApplicationContext(), "환영합니다, " + account.getDisplayName() + " 님", Toast.LENGTH_SHORT).show();
        } catch (ApiException e) {
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(
                    getApplicationContext(),
                    "알 수 없는 이유로 로그인에 실패했습니다.\n오류 코드: " + e.getStatusCode(),
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return false;
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