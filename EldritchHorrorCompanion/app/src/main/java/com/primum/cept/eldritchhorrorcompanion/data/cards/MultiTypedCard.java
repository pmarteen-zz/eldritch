package com.primum.cept.eldritchhorrorcompanion.data.cards;

/**
 * Created by peter.marteen on 9/15/17.
 */

public class MultiTypedCard extends Card {
    public String[] type;

    MultiTypedCard(String n, String[] t) {
        super(n);
        type = t;
    }

    MultiTypedCard(){}

    /**
     *  Method to write array of types for card into comma-seperated String
     */
    public String typeString(){
        StringBuilder sb = new StringBuilder();
        sb.append(type[0]);
        for(int i = 1; i < type.length; i++){
            sb.append(",");
            sb.append(type[i]);
        }
        return sb.toString();
    }
}
