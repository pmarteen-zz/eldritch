package com.primum.cept.eldritchhorrorcompanion.loader;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Process;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract.CardEntry;
import com.primum.cept.eldritchhorrorcompanion.data.cards.AncientOneCard;
import com.primum.cept.eldritchhorrorcompanion.data.cards.ArtifactCard;
import com.primum.cept.eldritchhorrorcompanion.data.cards.AssetCard;
import com.primum.cept.eldritchhorrorcompanion.data.cards.CharacterCard;
import com.primum.cept.eldritchhorrorcompanion.data.cards.ConditionCard;
import com.primum.cept.eldritchhorrorcompanion.data.cards.SpellCard;

import java.io.InputStream;

/**
 * Abstract implementation of loader class which will load all cards from a specific
 * Eldritch Horror expansion set.
 *
 * Created by Peter on 3/13/2017.
 */

public abstract class AbstractLoader implements Runnable {
    protected Context context;
    protected SQLiteDatabase db;

    abstract protected String getSpellPath();
    abstract protected String getAssetPath();
    abstract protected String getArtifactPath();
    abstract protected String getConditionPath();
    abstract protected String getCharacterPath();
    abstract protected String getAncientOnePath();

    protected String spellFile = "/spells.json";
    protected String assetFile = "/assets.json";
    protected String artifactFile = "/artifacts.json";
    protected String conditionFile = "/conditions.json";
    protected String characterFile = "/characters.json";
    protected String ancientOneFile = "/ancientones.json";

    @Override
    public void run() {
        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_FOREGROUND);

        ObjectMapper mapper = new ObjectMapper();
        AssetManager assetManager = context.getAssets();
        loadSpells(mapper, assetManager);
        loadAssets(mapper, assetManager);
        loadArtifacts(mapper, assetManager);
        loadConditions(mapper, assetManager);
        loadCharacters(mapper, assetManager);
        loadAncientOnes(mapper, assetManager);

    }

    protected void loadSpells(ObjectMapper mapper, AssetManager assetManager){
        try {
            InputStream is = assetManager.open(getSpellPath());
            SpellCard[] spells = mapper.readValue(is, SpellCard[].class);
            for (SpellCard spell : spells) {
                ContentValues values = new ContentValues();
                values.put(CardEntry.COLUMN_NAME, spell.name);
                values.put(CardEntry.COLUMN_TYPE, spell.typeString());

                db.insert(CardEntry.SPELL_TABLE_NAME, null, values);
            }
            is.close();
        }
        catch(Exception e){

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

                db.insert(CardEntry.ASSET_TABLE_NAME, null, values);
            }
            is.close();
        }
        catch(Exception e){

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

                db.insert(CardEntry.ARTIFACT_TABLE_NAME, null, values);
            }
            is.close();
        }
        catch(Exception e){

        }
    }
    protected void loadConditions(ObjectMapper mapper, AssetManager assetManager){
        try {
            InputStream is = assetManager.open(getConditionPath());
            ConditionCard[] conditions = mapper.readValue(is, ConditionCard[].class);
            for (ConditionCard condition : conditions) {
                ContentValues values = new ContentValues();
                values.put(CardEntry.COLUMN_NAME, condition.name);
                values.put(CardEntry.COLUMN_TYPE, condition.typeString());

                db.insert(CardEntry.CONDITION_TABLE_NAME, null, values);
            }
            is.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }

    protected void loadCharacters(ObjectMapper mapper, AssetManager assetManager){
        try {
            InputStream is = assetManager.open(getCharacterPath());
            CharacterCard[] characters = mapper.readValue(is, CharacterCard[].class);
            for (CharacterCard character : characters) {
                ContentValues values = new ContentValues();
                values.put(CardEntry.COLUMN_NAME, character.name);

                db.insert(CardEntry.CHARACTER_TABLE_NAME, null, values);
            }
            is.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }

    protected void loadAncientOnes(ObjectMapper mapper, AssetManager assetManager){
        try {
            InputStream is = assetManager.open(getAncientOnePath());
            AncientOneCard[] ancientOneCards = mapper.readValue(is, AncientOneCard[].class);
            for (AncientOneCard ancientOne : ancientOneCards) {
                ContentValues values = new ContentValues();
                values.put(CardEntry.COLUMN_NAME, ancientOne.name);

                db.insert(CardEntry.ANCIENT_ONE_TABLE_NAME, null, values);
            }
            is.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
}
