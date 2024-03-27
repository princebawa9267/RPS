package com.example.rockpaperscissor;

import android.os.Bundle;
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
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.vs_animation);
        vs.startAnimation(animation);
    }
}