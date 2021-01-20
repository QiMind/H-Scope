package com.example.horoscopgenerator;

import java.util.ArrayList;

public class TarotCardMeaning {

    private ArrayList<String> shadow;
    private ArrayList<String> light;

    public TarotCardMeaning() {
        this.shadow = new ArrayList<>();
        this.light = new ArrayList<>();
    }



    public ArrayList<String> getShadow() {
        return shadow;
    }

    public void setShadow(ArrayList<String> shadow) {
        this.shadow = shadow;
    }

    public ArrayList<String> getLight() {
        return light;
    }

    public void setLight(ArrayList<String> light) {
        this.light = light;
    }
}
