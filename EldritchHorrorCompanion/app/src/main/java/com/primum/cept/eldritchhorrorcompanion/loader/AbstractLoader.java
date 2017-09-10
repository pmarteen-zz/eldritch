package com.primum.cept.eldritchhorrorcompanion.loader;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Process;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract.CardEntry;
import com.primum.cept.eldritchhorrorcompanion.data.cards.ArtifactCard;
import com.primum.cept.eldritchhorrorcompanion.data.cards.AssetCard;
import com.primum.cept.eldritchhorrorcompanion.data.cards.SpellCard;

import java.io.InputStream;

/**
 * Created by Peter on 3/13/2017.
 */

public abstract class AbstractLoader implements Runnable{
    Context context;
    SQLiteDatabase db;

    abstract String getSpellPath();
    abstract String getAssetPath();
    abstract String getArtifactPath();

    @Override
    public void run() {
        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_FOREGROUND);

        ObjectMapper mapper = new ObjectMapper();
        AssetManager assetManager = context.getAssets();
        loadSpells(mapper, assetManager);
        loadAssets(mapper, assetManager);
        loadArtifacts(mapper, assetManager);

    }

    protected void loadSpells(ObjectMapper mapper, AssetManager assetManager){
        try {
            InputStream is = assetManager.open(getSpellPath());
            SpellCard[] spells = mapper.readValue(is, SpellCard[].class);
            for (SpellCard spell : spells) {
                ContentValues values = new ContentValues();
                values.put(CardEntry.COLUMN_NAME, spell.name);
                values.put(CardEntry.COLUMN_TYPE, spell.type);

                long newRowId = db.insert(CardEntry.SPELL_TABLE_NAME, null, values);
            }
            is.close();
        }
        catch(Exception e){
            context.isRestricted();
        }
    }
    protected void loadAssets(ObjectMapper mapper, AssetManager assetManager){
        try {
            InputStream is = assetManager.open(getAssetPath());
            AssetCard[] assets = mapper.readValue(is, AssetCard[].class);
            for (AssetCard asset : assets) {
                ContentValues values = new ContentValues();
                values.put(CardEntry.COLUMN_NAME, asset.name);
                values.put(CardEntry.COLUMN_TYPE, asset.typeString());
                values.put(CardEntry.COLUMN_COST, asset.cost);

                long newRowId = db.insert(CardEntry.ASSET_TABLE_NAME, null, values);
            }
            is.close();
        }
        catch(Exception e){
            context.isRestricted();
        }
    }
    protected void loadArtifacts(ObjectMapper mapper, AssetManager assetManager){
        try {
            InputStream is = assetManager.open(getArtifactPath());
            ArtifactCard[] artifacts = mapper.readValue(is, ArtifactCard[].class);
            for (ArtifactCard artifact : artifacts) {
                ContentValues values = new ContentValues();
                values.put(CardEntry.COLUMN_NAME, artifact.name);
                values.put(CardEntry.COLUMN_TYPE, artifact.typeString());

                long newRowId = db.insert(CardEntry.ARTIFACT_TABLE_NAME, null, values);
            }
            is.close();
        }
        catch(Exception e){
            context.isRestricted();
        }
    }
}
