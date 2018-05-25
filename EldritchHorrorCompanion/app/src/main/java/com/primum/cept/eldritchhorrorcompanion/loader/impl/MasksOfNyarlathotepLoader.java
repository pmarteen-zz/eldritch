package com.primum.cept.eldritchhorrorcompanion.loader.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.primum.cept.eldritchhorrorcompanion.loader.UniqueAssetLoader;

/**
 * Created by Peter on 5/19/2018.
 */

public class MasksOfNyarlathotepLoader extends UniqueAssetLoader {
    private final String expansionName = "MasksOfNyarlathotep";
    private final String spellPath = expansionName + spellFile;
    private final String assetPath = expansionName + assetFile;
    private final String artifactPath = expansionName + artifactFile;
    private final String uniqueAssetPath = expansionName + uniqueAssetFile;
    private final String conditionPath = expansionName + conditionFile;
    private final String characterPath = expansionName + characterFile;
    private final String ancientOnePath = expansionName + ancientOneFile;


    @Override
    protected String getUniqueAssetPath() {
        return uniqueAssetPath;
    }

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
    protected String getConditionPath() {
        return conditionPath;
    }

    @Override
    protected String getCharacterPath() {
        return characterPath;
    }

    @Override
    protected String getAncientOnePath() {
        return ancientOnePath;
    }

    public MasksOfNyarlathotepLoader(Context ctx, SQLiteDatabase database) {
        context = ctx;
        db = database;
    }
}
