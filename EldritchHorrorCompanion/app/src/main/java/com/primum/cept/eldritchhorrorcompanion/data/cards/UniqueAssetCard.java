package com.primum.cept.eldritchhorrorcompanion.data.cards;

import android.database.Cursor;

import com.primum.cept.eldritchhorrorcompanion.data.CardContract;

/**
 * Created by Peter on 4/27/2017.
 */

public class UniqueAssetCard extends MultiTypedCard {

    private UniqueAssetCard(String n, String[] t) {
        super(n,t);
    }
    public UniqueAssetCard() {
        super();
    }

    @Override
    public String displayCard() {
        return super.displayCard() + "Type: " + type[0];
    }

    static Card generateCard(Cursor cursor){
        String name = cursor.getString(cursor.getColumnIndexOrThrow(CardContract.CardEntry.COLUMN_NAME));
        String[] type = new String[5];
        type[0] = cursor.getString(cursor.getColumnIndexOrThrow(CardContract.CardEntry.COLUMN_TYPE));
        return new UniqueAssetCard(name, type);
    }
}
