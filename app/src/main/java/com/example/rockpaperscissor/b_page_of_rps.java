package com.example.rockpaperscissor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class b_page_of_rps extends AppCompatActivity {
    ImageView StartGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpage_of_rps);
        StartGame = findViewById(R.id.StartGame);
        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cPage = new Intent(b_page_of_rps.this,c_page_of_rps.class);
                startActivity(cPage);
                finish();
            }
        });
    }
}