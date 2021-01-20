package com.example.horoscopgenerator;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class TarotActivity extends AppCompatActivity {

    private ArrayList<Integer> tarotCardImages = new ArrayList<Integer>();

    public void initializeImageArray(){

        tarotCardImages.add(R.drawable.m00);
        tarotCardImages.add(R.drawable.m01);
        tarotCardImages.add(R.drawable.m02);
        tarotCardImages.add(R.drawable.m03);
        tarotCardImages.add(R.drawable.m04);
        tarotCardImages.add(R.drawable.m05);
        tarotCardImages.add(R.drawable.m06);
        tarotCardImages.add(R.drawable.m07);
        tarotCardImages.add(R.drawable.m08);
        tarotCardImages.add(R.drawable.m09);
        tarotCardImages.add(R.drawable.m10);
        tarotCardImages.add(R.drawable.m11);
        tarotCardImages.add(R.drawable.m12);
        tarotCardImages.add(R.drawable.m13);
        tarotCardImages.add(R.drawable.m14);
        tarotCardImages.add(R.drawable.m15);
        tarotCardImages.add(R.drawable.m16);
        tarotCardImages.add(R.drawable.m17);
        tarotCardImages.add(R.drawable.m18);
        tarotCardImages.add(R.drawable.m19);
        tarotCardImages.add(R.drawable.m20);
        tarotCardImages.add(R.drawable.m21);


        tarotCardImages.add(R.drawable.c01);
        tarotCardImages.add(R.drawable.c02);
        tarotCardImages.add(R.drawable.c03);
        tarotCardImages.add(R.drawable.c04);
        tarotCardImages.add(R.drawable.c05);
        tarotCardImages.add(R.drawable.c06);
        tarotCardImages.add(R.drawable.c07);
        tarotCardImages.add(R.drawable.c08);
        tarotCardImages.add(R.drawable.c09);
        tarotCardImages.add(R.drawable.c10);
        tarotCardImages.add(R.drawable.c11);
        tarotCardImages.add(R.drawable.c12);
        tarotCardImages.add(R.drawable.c13);
        tarotCardImages.add(R.drawable.c14);


        tarotCardImages.add(R.drawable.s01);
        tarotCardImages.add(R.drawable.s02);
        tarotCardImages.add(R.drawable.s03);
        tarotCardImages.add(R.drawable.s04);
        tarotCardImages.add(R.drawable.s05);
        tarotCardImages.add(R.drawable.s06);
        tarotCardImages.add(R.drawable.s07);
        tarotCardImages.add(R.drawable.s08);
        tarotCardImages.add(R.drawable.s09);
        tarotCardImages.add(R.drawable.s10);
        tarotCardImages.add(R.drawable.s11);
        tarotCardImages.add(R.drawable.s12);
        tarotCardImages.add(R.drawable.s13);
        tarotCardImages.add(R.drawable.s14);


        tarotCardImages.add(R.drawable.w01);
        tarotCardImages.add(R.drawable.w02);
        tarotCardImages.add(R.drawable.w03);
        tarotCardImages.add(R.drawable.w04);
        tarotCardImages.add(R.drawable.w05);
        tarotCardImages.add(R.drawable.w06);
        tarotCardImages.add(R.drawable.w07);
        tarotCardImages.add(R.drawable.w08);
        tarotCardImages.add(R.drawable.w09);
        tarotCardImages.add(R.drawable.w10);
        tarotCardImages.add(R.drawable.w11);
        tarotCardImages.add(R.drawable.w12);
        tarotCardImages.add(R.drawable.w13);
        tarotCardImages.add(R.drawable.w14);


        tarotCardImages.add(R.drawable.p01);
        tarotCardImages.add(R.drawable.p02);
        tarotCardImages.add(R.drawable.p03);
        tarotCardImages.add(R.drawable.p04);
        tarotCardImages.add(R.drawable.p05);
        tarotCardImages.add(R.drawable.p06);
        tarotCardImages.add(R.drawable.p07);
        tarotCardImages.add(R.drawable.p08);
        tarotCardImages.add(R.drawable.p09);
        tarotCardImages.add(R.drawable.p11);
        tarotCardImages.add(R.drawable.p12);
        tarotCardImages.add(R.drawable.p13);
        tarotCardImages.add(R.drawable.p14);
    }

    private ArrayList<TarotCard> tarot_cards = new ArrayList<>() ;
    private TextView mTextViewFortuneTelling;
    private TextView mTextViewLightMeaning;
    private TextView mTextViewShadowMeaning;
    private TextView mTextViewQuestion;
    private TextView mTextViewName;
    private ImageView mImageViewCard;
    int cardChoice;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarot_layout);

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());

            JSONArray cardsArray =  obj.getJSONArray("cards");

            for(int i = 0; i < cardsArray.length(); i++) {
                JSONObject cardDetail = cardsArray.getJSONObject(i);
                TarotCard tarotCard = new TarotCard();
                tarotCard.setName(cardDetail.getString("name"));

                TarotCardMeaning tarotCardMeaning = new TarotCardMeaning();
                JSONObject meaningsArray = cardDetail.getJSONObject("meanings");
                JSONArray shadow = meaningsArray.getJSONArray("shadow");
                JSONArray light = meaningsArray.getJSONArray("light");

                for(int j = 0; j < light.length(); j++){
                    tarotCardMeaning.getLight().add(light.getString(j));
                }

                for(int k = 0; k < shadow.length(); k++){
                    tarotCardMeaning.getShadow().add(shadow.getString(k));
                }


                tarotCard.setMeaning(tarotCardMeaning);
                JSONArray fortuneArray = cardDetail.getJSONArray("fortune_telling");
                for(int l = 0; l < fortuneArray.length(); l++){
                    tarotCard.getFortuneTelling().add(fortuneArray.getString(l));
                }
                JSONArray questionsArray = cardDetail.getJSONArray("Questions to Ask");
                for(int m = 0; m < questionsArray.length(); m++){
                    tarotCard.getQuestions_to_ask().add(questionsArray.getString(m));
                }

                tarot_cards.add(tarotCard);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

       // mTextView = findViewById(R.id.card_name);
        //mTextView.setText(tarot_cards.get(12).getName());

        initializeImageArray();
        generateCard();


    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("tarot-images.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void generateCard()
    {
        Random card = new Random();
        int cardChoice = card.nextInt(62);

        mImageViewCard = findViewById(R.id.card_image);
        mImageViewCard.setImageResource(tarotCardImages.get(cardChoice));

        mTextViewName = findViewById(R.id.card_name);
        mTextViewName.setText(tarot_cards.get(cardChoice).getName());

        Random fortuneChoice = new Random();
        int fortune = fortuneChoice.nextInt(2);
        if(fortune > 1) {
            mTextViewFortuneTelling = findViewById(R.id.fortune_telling_text);
            mTextViewFortuneTelling.setText(tarot_cards.get(cardChoice).getFortuneTelling().get(fortune));
        }
        else
        {  mTextViewFortuneTelling = findViewById(R.id.fortune_telling_text);
            mTextViewFortuneTelling.setText(tarot_cards.get(cardChoice).getFortuneTelling().get(0   ));

        }
        Random lightChoice = new Random();
        int light = lightChoice.nextInt(4);
        mTextViewLightMeaning = findViewById(R.id.light_text);
        mTextViewLightMeaning.setText(tarot_cards.get(cardChoice).getMeaning().getLight().get(light));

        Random shadowChoice = new Random();
        int shadow = shadowChoice.nextInt(4);
        mTextViewShadowMeaning = findViewById(R.id.shadow_text);
        mTextViewShadowMeaning.setText(tarot_cards.get(cardChoice).getMeaning().getShadow().get(shadow));

        Random questionChoice = new Random();
        int question = questionChoice.nextInt(2);
        mTextViewQuestion = findViewById(R.id.question_text);
        mTextViewQuestion.setText(tarot_cards.get(cardChoice).getQuestions_to_ask().get(question));


    }
}
