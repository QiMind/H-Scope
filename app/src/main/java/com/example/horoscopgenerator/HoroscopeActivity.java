package com.example.horoscopgenerator;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
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
    protected String data_pred;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horoscope_layout);
        zodiacNameBtn = findViewById(R.id.horoscope_zodiac_sign_name);
        prediction = findViewById(R.id.horoscope_prediction_text);

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
                        prediction.setText((String) val.getValue());
                        break;
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("The read failed: " + error.getCode());
            }
        });
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

