package com.example.horoscopgenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_SAMPLE_EXTRA = "com.example.course4.course4.key.SAMPLE_EXTRA";

    private Button horoscopeBtn;
    private MaterialButton tarotBtn;
    private ImageView im;
    private boolean cond = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        horoscopeBtn = findViewById(R.id.main_horoscope_button);
        horoscopeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,HoroscopeActivity.class);
                startActivity(intent);

            }
            });

        tarotBtn = findViewById(R.id.main_tarot_button);
        tarotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TarotActivity.class);
                startActivity(intent);
            }
        });
    }
}