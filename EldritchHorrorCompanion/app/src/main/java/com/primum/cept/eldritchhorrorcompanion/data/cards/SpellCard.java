package com.primum.cept.eldritchhorrorcompanion.data.cards;

import android.database.Cursor;

import com.primum.cept.eldritchhorrorcompanion.data.CardContract;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract.CardEntry;

/**
 * Created by Peter on 4/5/2017.
 */

public class SpellCard extends MultiTypedCard {
    private SpellCard(String n, String[] t){
        super(n,t);
    }
    public SpellCard(){}
    public static Card generateCard(Cursor cursor){
        String name = cursor.getString(cursor.getColumnIndexOrThrow(CardEntry.COLUMN_NAME));
        String[] type = new String[5];
        type[0] = cursor.getString(cursor.getColumnIndexOrThrow(CardContract.CardEntry.COLUMN_TYPE));
        return new SpellCard(name, type);
    }

    @Override
    public String displayCard() {
        return super.displayCard() + "Type: " + type[0];

    }
}
