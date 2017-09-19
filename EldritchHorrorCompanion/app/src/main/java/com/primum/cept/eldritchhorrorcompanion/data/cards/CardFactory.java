package com.primum.cept.eldritchhorrorcompanion.data.cards;

import android.database.Cursor;

import com.primum.cept.eldritchhorrorcompanion.data.CardContract.CardEntry;


/**
 * Created by Peter on 4/5/2017.
 */

public class CardFactory {
    private static CardFactory singleton = new CardFactory();
    private CardFactory(){};

    String cardType;
    Cursor cursor;


    public static CardFactory getInstance(){
        return singleton;
    }
    public void setType(String type){
        cardType = type;
    }
    public void setCursor(Cursor csr){
        cursor = csr;
    }
    public Card build() throws Exception {
        if(cardType == null || cursor == null){
            throw new Exception("Type and cursor must be set before card can be built");
        }
        switch (cardType){
            case CardEntry.SPELL_TABLE_NAME :
                return SpellCard.generateCard(cursor);
            case CardEntry.ASSET_TABLE_NAME :
                return AssetCard.generateCard(cursor);
            case CardEntry.ARTIFACT_TABLE_NAME :
                return ArtifactCard.generateCard(cursor);
            case CardEntry.UNIQUE_ASSET_TABLE_NAME :
                return UniqueAssetCard.generateCard(cursor);
            case CardEntry.CONDITION_TABLE_NAME :
                return ConditionCard.generateCard(cursor);
            default :
                throw new Exception("Unknown card type");
        }
    }
}
