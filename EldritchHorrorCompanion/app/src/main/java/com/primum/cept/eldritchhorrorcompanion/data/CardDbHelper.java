package com.primum.cept.eldritchhorrorcompanion.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Peter on 2/19/2017.
 */

public class CardDbHelper extends SQLiteOpenHelper {
    private static CardDbHelper instance = null;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Cards.db";

    public static CardDbHelper getInstance(Context context) {
        if(instance == null){
            instance = new CardDbHelper(context.getApplicationContext());
        }
        return instance;
    }
    private CardDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CardContract.SPELL_TABLE_CREATE);
        db.execSQL(CardContract.ASSET_TABLE_CREATE);
        db.execSQL(CardContract.UNIQUE_ASSET_TABLE_CREATE);
        db.execSQL(CardContract.ARTIFACT_TABLE_CREATE);
        db.execSQL(CardContract.CONDITION_TABLE_CREATE);
        db.execSQL(CardContract.CHARACTER_TABLE_CREATE);
        db.execSQL(CardContract.ANCIENT_ONE_TABLE_CREATE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CardContract.SPELL_TABLE_DELETE);
        db.execSQL(CardContract.ASSET_TABLE_DELETE);
        db.execSQL(CardContract.UNIQUE_ASSET_TABLE_DELETE);
        db.execSQL(CardContract.ARTIFACT_TABLE_DELETE);
        db.execSQL(CardContract.CONDITION_TABLE_DELETE);
        db.execSQL(CardContract.CHARACTER_TABLE_DELETE);
        db.execSQL(CardContract.ANCIENT_ONE_TABLE_DELETE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void clean(SQLiteDatabase db){
        //Drop em
        db.execSQL(CardContract.SPELL_TABLE_DELETE);
        db.execSQL(CardContract.ASSET_TABLE_DELETE);
        db.execSQL(CardContract.UNIQUE_ASSET_TABLE_DELETE);
        db.execSQL(CardContract.ARTIFACT_TABLE_DELETE);
        db.execSQL(CardContract.CONDITION_TABLE_DELETE);
        db.execSQL(CardContract.CHARACTER_TABLE_DELETE);
        db.execSQL(CardContract.ANCIENT_ONE_TABLE_DELETE);
        //Make em again
        db.execSQL(CardContract.SPELL_TABLE_CREATE);
        db.execSQL(CardContract.ASSET_TABLE_CREATE);
        db.execSQL(CardContract.UNIQUE_ASSET_TABLE_CREATE);
        db.execSQL(CardContract.ARTIFACT_TABLE_CREATE);
        db.execSQL(CardContract.CONDITION_TABLE_CREATE);
        db.execSQL(CardContract.CHARACTER_TABLE_CREATE);
        db.execSQL(CardContract.ANCIENT_ONE_TABLE_CREATE);
    }
}
