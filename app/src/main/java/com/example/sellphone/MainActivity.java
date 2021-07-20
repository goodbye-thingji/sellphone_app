package com.example.sellphone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
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
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sellphone.ui.gallery.GalleryFragment;
import com.example.sellphone.ui.home.HomeFragment;
import com.example.sellphone.ui.slideshow.SlideshowFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity<phone1> extends AppCompatActivity {
    private static final String TAG = "Main_Activity";
    private static final int RC_SIGN_IN = 5252;

    private ImageView ivMenu;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private long lastTime;
    private Context context = this;
    private AppBarConfiguration mAppBarConfiguration;
    ImageView phone, phone2, phone3, phone4, phone5, phone6, phone7, phone8, phone9, phone10, phone11, phone12;

    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInAccount account;
    //

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
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();

                if (id == R.id.inform) {
                    Intent i = new Intent(context, GalleryFragment.class);
                    context.startActivity(i);
                } else if (id == R.id.mallinfo) {
                    Intent i2 = new Intent(context, HomeFragment.class);
                    context.startActivity(i2);
                } else if (id == R.id.userguide) {
                    Intent i3 = new Intent(context, SlideshowFragment.class);
                    context.startActivity(i3);
                }

                return true;
            }
        });

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
            handleValidateUser();
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

    private void handleValidateUser() {
        try {
            if (account != null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("idToken", account.getIdToken());
            } else {
                Toast.makeText(getApplicationContext(), "존재하지 않는 사용자입니다", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            Log.w(TAG, "JSONObject: " + e.getMessage());
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            account = completedTask.getResult(ApiException.class);
            handleValidateUser();
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
        return true;
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
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