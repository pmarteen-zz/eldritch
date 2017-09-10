package com.primum.cept.eldritchhorrorcompanion.data.cards;

import android.database.Cursor;

import com.primum.cept.eldritchhorrorcompanion.data.CardContract;

/**
 * Created by Peter on 4/5/2017.
 */

public class ArtifactCard extends Card {
    public String[] type;
    private ArtifactCard(String n, String[] t){
        super(n);
        type = t;
    }

    public ArtifactCard() {super(); }
    @Override
    public String displayCard() {
        return super.displayCard() + "Type: " + type[0];
    }

    public static Card generateCard(Cursor cursor){
        String name = cursor.getString(cursor.getColumnIndexOrThrow(CardContract.CardEntry.COLUMN_NAME));
        String[] type = new String[5];
        type[0] = cursor.getString(cursor.getColumnIndexOrThrow(CardContract.CardEntry.COLUMN_TYPE));
        return new ArtifactCard(name, type);
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
