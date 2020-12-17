package com.example.flyingbird;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private  static int SPLASH=2000;
    Animation logoAnim, nameAnim;
    ImageView logo,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        //Hiding Action bar
//        ActionBar actionBar=getSupportActionBar();
//        assert actionBar != null;
//        actionBar.hide();

        logoAnim= AnimationUtils.loadAnimation(this,R.anim.logo_animation);
        nameAnim= AnimationUtils.loadAnimation(this,R.anim.name_animation);

        logo=findViewById(R.id.imageView);
        name=findViewById(R.id.imageView2);

        logo.setAnimation(logoAnim);
        name.setAnimation(nameAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH);
    }
}