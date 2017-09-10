package com.primum.cept.eldritchhorrorcompanion.loader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Peter on 4/25/2017.
 */

public class BaseSetLoader extends AbstractLoader {
    private final String spellPath = "BaseSet/spells.json";
    private final String assetPath = "BaseSet/assets.json";
    private final String artifactPath = "BaseSet/artifacts.json";

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

    public BaseSetLoader(Context ctx, SQLiteDatabase database) {
        context = ctx;
        db = database;
    }
}
