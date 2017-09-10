package com.primum.cept.eldritchhorrorcompanion.data.cards;

/**
 * Created by Peter on 4/5/2017.
 */

public abstract class Card {
    public String name;

    public Card(String n){
        name = n;
    }

    public Card(){
    }
    public String displayCard() {
        return "Name: " + name + "\n";
    }

}
