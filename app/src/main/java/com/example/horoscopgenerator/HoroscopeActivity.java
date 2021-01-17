package com.example.horoscopgenerator;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class HoroscopeActivity extends AppCompatActivity {

    MaterialButton zodiacNameBtn;
    int choice = 1;
    private TextView prediction;
    ImageView zodiacImg;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horoscope_layout);
        zodiacNameBtn = findViewById(R.id.horoscope_zodiac_sign_name);
        prediction = findViewById(R.id.horoscope_prediction_text);
        zodiacImg = findViewById(R.id.zodiacImg);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = mDatabase.child("preds");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Random rnd = new Random();
                int rnd_index = rnd.nextInt(101);
                int index = 0;
                for(DataSnapshot val : snapshot.getChildren())
                {
                    index++;
                    if(rnd_index == index)
                    {
                        prediction.setText(((String) val.getValue()).toUpperCase());
                        break;
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("The read failed: " + error.getCode());
            }
        });
        zodiacNameBtn.setText(changeZodiacSign(7));
    }

    public void doGoBack(View v) {
        Toast.makeText(this, "Text", Toast.LENGTH_SHORT).show();
    }

    public String changeZodiacSign(int choice){
        switch (choice)
        {
            case 1:
                zodiacImg.setImageResource(R.drawable.ic_aquarius);
                return getResources().getString(R.string.zsAq);
            case 2:
                zodiacImg.setImageResource(R.drawable.ic_pisces);
                return getResources().getString(R.string.zsPs);
            case 3:
                zodiacImg.setImageResource(R.drawable.ic_aries);
                return getResources().getString(R.string.zsAr);
            case 4:
                zodiacImg.setImageResource(R.drawable.ic_taurus);
                return getResources().getString(R.string.zsTr);
            case 5:
                zodiacImg.setImageResource(R.drawable.ic_gemini);
                return getResources().getString(R.string.zsGm);
            case 6:
                zodiacImg.setImageResource(R.drawable.ic_cancer);
                return getResources().getString(R.string.zsCn);
            case 7:
                zodiacImg.setImageResource(R.drawable.ic_leo);
                return getResources().getString(R.string.zsLeo);
            case 8:
                zodiacImg.setImageResource(R.drawable.ic_virgo);
                return getResources().getString(R.string.zsVr);
            case 9:
                zodiacImg.setImageResource(R.drawable.ic_libra);
                return getResources().getString(R.string.zsLb);
            case 10:
                zodiacImg.setImageResource(R.drawable.ic_scorpio);
                return getResources().getString(R.string.zsSc);
            case 11:
                zodiacImg.setImageResource(R.drawable.ic_sagittarius);
                return getResources().getString(R.string.zsSag);
            case 12:
                zodiacImg.setImageResource(R.drawable.ic_capricorn__1_);
                return getResources().getString(R.string.zsCap);
            default:
                return "NOTHING SELECTED";
        }
    }
}

