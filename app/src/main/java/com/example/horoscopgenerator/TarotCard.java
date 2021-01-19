package com.example.horoscopgenerator;

import java.util.ArrayList;

public class TarotCard {

    private String name;
    private ArrayList<String> fortuneTelling;
    private TarotCardMeaning meaning;
    private ArrayList<String> questionsToAsk;

    public TarotCard(String name,  TarotCardMeaning meaning) {
        this.name = name;
        this.fortuneTelling = new ArrayList<>();
        this.meaning = meaning;
        this.questionsToAsk = new ArrayList<>();
    }

    public TarotCard(){
        fortuneTelling = new ArrayList<>();
        questionsToAsk  = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getFortuneTelling() {
        return fortuneTelling;
    }

    public void setFortune_telling(ArrayList<String> fortune_telling) {
        this.fortuneTelling = fortune_telling;
    }

    public TarotCardMeaning getMeaning() {
        return meaning;
    }

    public void setMeaning(TarotCardMeaning meaning) {
        this.meaning = meaning;
    }

    public ArrayList<String> getQuestions_to_ask() {
        return questionsToAsk;
    }

    public void setQuestions_to_ask(ArrayList<String> questions_to_ask) {
        this.questionsToAsk = questions_to_ask;
    }
}
