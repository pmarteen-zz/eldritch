package com.primum.cept.eldritchhorrorcompanion.loader.impl;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract;
import com.primum.cept.eldritchhorrorcompanion.data.cards.UniqueAssetCard;
import com.primum.cept.eldritchhorrorcompanion.loader.UniqueAssetLoader;

import java.io.InputStream;

/**
 * Card loader for the Dreamlands expansion
 *
 * Created by Peter on 8/17/2017.
 */

public class DreamlandsLoader extends UniqueAssetLoader {
    private final String spellPath = "Dreamlands/spells.json";
    private final String assetPath = "Dreamlands/assets.json";
    private final String artifactPath = "Dreamlands/artifacts.json";
    private final String uniqueAssetPath = "Dreamlands/uniqueAssets.json";
    private final String conditionPath = "Dreamlands/conditions.json";

    @Override
    protected String getSpellPath() {
        return spellPath;
    }
    @Override
    protected String getAssetPath() {
        return assetPath;
    }
    @Override
    protected String getArtifactPath() {
        return artifactPath;
    }
    @Override
    protected String getUniqueAssetPath(){
        return uniqueAssetPath;
    }
    @Override
    protected String getConditionPath(){
        return conditionPath;
    }

    public DreamlandsLoader(Context ctx, SQLiteDatabase database) {
        context = ctx;
        db = database;
    }
}
