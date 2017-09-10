package com.primum.cept.eldritchhorrorcompanion.data;

import android.provider.BaseColumns;

/**
 * Created by Peter on 2/19/2017.
 */

public final class CardContract {

    private CardContract(){};

    public static class CardEntry implements BaseColumns {
        public static final String SPELL_TABLE_NAME = "SpellTable";
        public static final String ASSET_TABLE_NAME = "AssetTable";
        public static final String ARTIFACT_TABLE_NAME = "ArtifactTable";
        public static final String UNIQUE_ASSET_TABLE_NAME = "UniqueAssetTable";
        public static final String TYPE_TABLE_NAME = "TypeTable";
        public static final String COLUMN_NAME = "CardName";
        public static final String COLUMN_TYPE = "CardType";
        public static final String COLUMN_COST = "AssetCost";
    }

    public static final String SPELL_TABLE_CREATE =
            "CREATE TABLE " + CardEntry.SPELL_TABLE_NAME + " (" +
                    CardEntry._ID + " INTEGER PRIMARY KEY," +
                    CardEntry.COLUMN_NAME + " VARCHAR(20)," +
                    CardEntry.COLUMN_TYPE + " VARCHAR(40))";

    public static final String ASSET_TABLE_CREATE =
            "CREATE TABLE " + CardEntry.ASSET_TABLE_NAME + " (" +
                    CardEntry._ID + " INTEGER PRIMARY KEY," +
                    CardEntry.COLUMN_NAME + " TEXT," +
                    CardEntry.COLUMN_TYPE + " TEXT," + CardEntry.COLUMN_COST + " INT)";

    public static final String UNIQUE_ASSET_TABLE_CREATE =
            "CREATE TABLE " + CardEntry.UNIQUE_ASSET_TABLE_NAME + " (" +
                    CardEntry._ID + " INTEGER PRIMARY KEY," +
                    CardEntry.COLUMN_NAME + " TEXT," + CardEntry.COLUMN_TYPE + " TEXT)";

    public static final String ARTIFACT_TABLE_CREATE =
            "CREATE TABLE " + CardEntry.ARTIFACT_TABLE_NAME + " (" +
                    CardEntry._ID + " INTEGER PRIMARY KEY," +
                    CardEntry.COLUMN_NAME + " TEXT," + CardEntry.COLUMN_TYPE + " TEXT)";

    public static final String TYPE_TABLE_CREATE =
            "CREATE TABLE " + CardEntry.TYPE_TABLE_NAME + " (" +
                    CardEntry._ID + " INTEGER PRIMARY KEY," +
                    CardEntry.COLUMN_TYPE + " TEXT)";

    public static final String SPELL_TABLE_DELETE =
            "DROP TABLE IF EXISTS " + CardEntry.SPELL_TABLE_NAME;
    public static final String ASSET_TABLE_DELETE =
            "DROP TABLE IF EXISTS " + CardEntry.ASSET_TABLE_NAME;
    public static final String UNIQUE_ASSET_TABLE_DELETE =
            "DROP TABLE IF EXISTS " + CardEntry.UNIQUE_ASSET_TABLE_NAME;
    public static final String ARTIFACT_TABLE_DELETE =
            "DROP TABLE IF EXISTS " + CardEntry.ARTIFACT_TABLE_NAME;


}
