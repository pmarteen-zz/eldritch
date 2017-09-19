package com.primum.cept.eldritchhorrorcompanion.loader.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.primum.cept.eldritchhorrorcompanion.loader.AbstractLoader;

/**
 * Created by Peter on 4/25/2017.
 */

public class BaseSetLoader extends AbstractLoader {
    private final String spellPath = "BaseSet/spells.json";
    private final String assetPath = "BaseSet/assets.json";
    private final String artifactPath = "BaseSet/artifacts.json";
    private final String conditionPath = "BaseSet/conditions.json";

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
    protected String getConditionPath(){
        return conditionPath;
    }

    public BaseSetLoader(Context ctx, SQLiteDatabase database) {
        context = ctx;
        db = database;
    }
}
