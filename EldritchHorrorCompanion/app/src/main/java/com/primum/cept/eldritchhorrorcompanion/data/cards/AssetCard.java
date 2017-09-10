package com.primum.cept.eldritchhorrorcompanion.data.cards;

import android.database.Cursor;

import com.primum.cept.eldritchhorrorcompanion.data.CardContract.CardEntry;

/**
 * Created by Peter on 4/5/2017.
 */

public class AssetCard extends Card {
    public String[] type;
    public int cost;

    public AssetCard(String n, String[] t, int c) {
        super(n);
        type = t;
        cost = c;
    }
    public AssetCard() {
        super();
    }

    @Override
    public String displayCard() {
        return super.displayCard() + "Type: " + type[0] + "\nCost: " + cost;

    }

    public static Card generateCard(Cursor cursor){
        String name = cursor.getString(cursor.getColumnIndexOrThrow(CardEntry.COLUMN_NAME));
        String[] type = new String[5];
        type[0] = cursor.getString(cursor.getColumnIndexOrThrow(CardEntry.COLUMN_TYPE));
        int cost = cursor.getInt(cursor.getColumnIndexOrThrow(CardEntry.COLUMN_COST));
        return new AssetCard(name, type, cost);
    }

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
