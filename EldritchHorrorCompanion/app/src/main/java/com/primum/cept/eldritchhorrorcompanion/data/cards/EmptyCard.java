package com.primum.cept.eldritchhorrorcompanion.data.cards;

import android.database.Cursor;

import com.primum.cept.eldritchhorrorcompanion.data.CardContract;

/**
 * Created by Peter on 4/5/2017.
 */

public class EmptyCard extends Card {
    private static EmptyCard singleton = new EmptyCard("empty");
    private EmptyCard(String n) {
        super(n);
    }
    public static Card getInstance() {
        return singleton;
    }
    @Override
    public String displayCard() {
        return "No more cards in that deck!";
    }
}
