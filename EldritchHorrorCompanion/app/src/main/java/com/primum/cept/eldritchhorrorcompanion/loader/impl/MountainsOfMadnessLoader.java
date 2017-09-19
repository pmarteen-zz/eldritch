package com.primum.cept.eldritchhorrorcompanion.loader.impl;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract;
import com.primum.cept.eldritchhorrorcompanion.data.cards.UniqueAssetCard;
import com.primum.cept.eldritchhorrorcompanion.loader.AbstractLoader;
import com.primum.cept.eldritchhorrorcompanion.loader.UniqueAssetLoader;

import java.io.InputStream;

/**
 * Card loader for the Mountains of Madness expansion
 *
 * Created by Peter on 5/26/2017.
 */

public class MountainsOfMadnessLoader extends UniqueAssetLoader {
    private final String spellPath = "MountainsOfMadness/spells.json";
    private final String assetPath = "MountainsOfMadness/assets.json";
    private final String artifactPath = "MountainsOfMadness/artifacts.json";
    private final String uniqueAssetPath = "MountainsOfMadness/uniqueAssets.json";
    private final String conditionPath = "MountainsOfMadness/conditions.json";

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

    public MountainsOfMadnessLoader(Context ctx, SQLiteDatabase database) {
        context = ctx;
        db = database;
    }
}
