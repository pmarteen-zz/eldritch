package com.primum.cept.eldritchhorrorcompanion.data.cards;

import android.database.Cursor;

import com.primum.cept.eldritchhorrorcompanion.data.CardContract;

/**
 * Created by peter.marteen on 9/16/17.
 */

public class ConditionCard extends MultiTypedCard {
    public ConditionCard(String n, String[] t){
        super(n,t);
    }
    public ConditionCard(){}
    public static Card generateCard(Cursor cursor){
        String name = cursor.getString(cursor.getColumnIndexOrThrow(CardContract.CardEntry.COLUMN_NAME));
        String[] type = new String[5];
        type[0] = cursor.getString(cursor.getColumnIndexOrThrow(CardContract.CardEntry.COLUMN_TYPE));
        return new ConditionCard(name, type);
    }

    @Override
    public String displayCard() {
        return super.displayCard() + "Type: " + type[0];

    }
}
