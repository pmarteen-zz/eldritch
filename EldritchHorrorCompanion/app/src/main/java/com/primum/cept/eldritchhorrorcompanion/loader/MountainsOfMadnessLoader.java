package com.primum.cept.eldritchhorrorcompanion.loader;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract;
import com.primum.cept.eldritchhorrorcompanion.data.cards.UniqueAssetCard;

import java.io.InputStream;

/**
 * Created by Peter on 5/26/2017.
 */

public class MountainsOfMadnessLoader extends AbstractLoader {
    private final String spellPath = "MountainsOfMadness/spells.json";
    private final String assetPath = "MountainsOfMadness/assets.json";
    private final String artifactPath = "MountainsOfMadness/artifacts.json";
    private final String uniqueAssetPath = "MountainsOfMadness/uniqueAssets.json";

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

    String getUniqueAssetPath(){
        return uniqueAssetPath;
    }

    public MountainsOfMadnessLoader(Context ctx, SQLiteDatabase database) {
        context = ctx;
        db = database;
    }
    @Override
    public void run() {
        ObjectMapper mapper = new ObjectMapper();
        AssetManager assetManager = context.getAssets();
        loadSpells(mapper, assetManager);
        loadAssets(mapper, assetManager);
        loadArtifacts(mapper, assetManager);
        loadUniqueAssets(mapper, assetManager);
    }

    private void loadUniqueAssets(ObjectMapper mapper, AssetManager assetManager) {
        try {
            InputStream is = assetManager.open(getUniqueAssetPath());
            UniqueAssetCard[] uniqueAssets = mapper.readValue(is, UniqueAssetCard[].class);
            for (UniqueAssetCard uniqueAsset : uniqueAssets) {
                ContentValues values = new ContentValues();
                values.put(CardContract.CardEntry.COLUMN_NAME, uniqueAsset.name);
                values.put(CardContract.CardEntry.COLUMN_TYPE, uniqueAsset.typeString());

                long newRowId = db.insert(CardContract.CardEntry.UNIQUE_ASSET_TABLE_NAME, null, values);
            }
            is.close();
        } catch (Exception e) {
            context.isRestricted();
        }
    }
}
