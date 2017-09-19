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
 * Card loader for the Under the Pyramids expansion
 *
 * Created by Peter on 4/27/2017.
 */

public class UnderThePyramidsLoader extends UniqueAssetLoader {
    private final String spellPath = "UnderThePyramids/spells.json";
    private final String assetPath = "UnderThePyramids/assets.json";
    private final String artifactPath = "UnderThePyramids/artifacts.json";
    private final String uniqueAssetPath = "UnderThePyramids/uniqueAssets.json";
    private final String conditionPath = "UnderThePyramids/conditions.json";

    @Override
    protected String getSpellPath() {
        return spellPath;
    }
    @Override
    protected String getAssetPath(){
        return assetPath;
    }
    @Override
    protected String getArtifactPath(){
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

    public UnderThePyramidsLoader(Context ctx, SQLiteDatabase database) {
        context = ctx;
        db = database;
    }
}
