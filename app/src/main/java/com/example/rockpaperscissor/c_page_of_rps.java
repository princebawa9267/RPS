package com.example.rockpaperscissor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.view.animation.Animation;
import androidx.appcompat.app.AppCompatActivity;
public class c_page_of_rps extends AppCompatActivity {
    ImageView vs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpage_of_rps);
//        vs = findViewById(R.id.vs);
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.vs_animation);
//        vs.startAnimation(animation);
        Intent finalPage = new Intent(this,MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(finalPage);
                finish();
            }
        },3000);
    }
}