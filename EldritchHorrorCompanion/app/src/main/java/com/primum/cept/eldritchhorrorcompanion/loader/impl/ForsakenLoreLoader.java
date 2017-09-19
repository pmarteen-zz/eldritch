package com.primum.cept.eldritchhorrorcompanion.loader.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.primum.cept.eldritchhorrorcompanion.loader.AbstractLoader;

/**
 * Card loader for the Forsaken Lore expansion
 *
 * Created by Peter on 4/27/2017.
 */

public class ForsakenLoreLoader extends AbstractLoader {
    private final String spellPath = "ForsakenLore/spells.json";
    private final String assetPath = "ForsakenLore/assets.json";
    private final String artifactPath = "ForsakenLore/artifacts.json";
    private final String conditionPath = "ForsakenLore/conditions.json";

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

    public ForsakenLoreLoader(Context ctx, SQLiteDatabase database) {
        context = ctx;
        db = database;
    }
}