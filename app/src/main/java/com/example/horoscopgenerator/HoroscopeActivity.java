package com.example.horoscopgenerator;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class HoroscopeActivity extends AppCompatActivity {

    MaterialButton zodiacNameBtn;
    int choice = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horoscope_layout);
        zodiacNameBtn = findViewById(R.id.horoscope_zodiac_sign_name);

        changeZodiacSign(1);
    }

    public void doGoBack(View v) {
        Toast.makeText(this, "Text", Toast.LENGTH_SHORT).show();
    }

    public void changeZodiacSign(int choice){

        if(choice == 1){
            zodiacNameBtn.setText(R.string.zsAr);
        }
    }
}

