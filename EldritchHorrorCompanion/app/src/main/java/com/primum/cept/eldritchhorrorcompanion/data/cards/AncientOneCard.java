package com.primum.cept.eldritchhorrorcompanion.data.cards;

import android.database.Cursor;

import com.primum.cept.eldritchhorrorcompanion.data.CardContract;

/**
 * Created by peter.marteen on 9/16/17.
 */

public class AncientOneCard extends Card {
    public AncientOneCard(String n){
        super(n);
    }
    public AncientOneCard(){}
    public static Card generateCard(Cursor cursor){
        String name = cursor.getString(cursor.getColumnIndexOrThrow(CardContract.CardEntry.COLUMN_NAME));
        return new AncientOneCard(name);
    }
}
