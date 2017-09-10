package com.primum.cept.eldritchhorrorcompanion.loader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Peter on 4/27/2017.
 */

public class ForsakenLoreLoader extends AbstractLoader {
    private final String spellPath = "ForsakenLore/spells.json";
    private final String assetPath = "ForsakenLore/assets.json";
    private final String artifactPath = "ForsakenLore/artifacts.json";

    @Override
    String getSpellPath() {
        return spellPath;
    }
    @Override
    String getAssetPath(){
        return assetPath;
    }
    @Override
    String getArtifactPath(){
        return artifactPath;
    }

    public ForsakenLoreLoader(Context ctx, SQLiteDatabase database) {
        context = ctx;
        db = database;
    }
}