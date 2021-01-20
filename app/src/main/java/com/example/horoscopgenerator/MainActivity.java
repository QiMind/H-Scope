package com.example.horoscopgenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    private int howTimes = 0;
    private int howManyTimesTarot = 0;
    private HoroscopeActivity horoscopeActivity = new HoroscopeActivity();
    public static String choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_MaterialComponents_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.zodiacSpinner);

        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this,R.array.zodiacs, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                choice = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        horoscopeBtn = findViewById(R.id.main_horoscope_button);
        horoscopeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,HoroscopeActivity.class);
                startActivity(intent);
                Context ct = getApplicationContext();
                CharSequence text = "The Planets are sending you a message";
                CharSequence text2 = "The Planets are sending you a new message";
                Toast rePlanets;
                if(howTimes == 0 )
                {
                    rePlanets = Toast.makeText(ct, text, Toast.LENGTH_SHORT);
                }
                else
                {
                    rePlanets = Toast.makeText(ct, text2, Toast.LENGTH_SHORT);
                }
                rePlanets.show();
                howTimes++;
            }
            });

        tarotBtn = findViewById(R.id.main_tarot_button);
        tarotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TarotActivity.class);
                Context ct = getApplicationContext();
                CharSequence text = "Your Tarot Reading";
                CharSequence text2 = "Your Tarot Card Has been changed";
                Toast reTarot;
                if(howManyTimesTarot == 0 )
                {
                    reTarot = Toast.makeText(ct, text, Toast.LENGTH_SHORT);
                }
                else
                {
                    reTarot = Toast.makeText(ct, text2, Toast.LENGTH_SHORT);
                }
                reTarot.show();
                howManyTimesTarot++;
                Random randomCardNumber = new Random();
                randomCardNumber.nextInt(70);

                intent.putExtra("CardNumber",randomCardNumber);

                startActivity(intent);
            }
        });
    }
}