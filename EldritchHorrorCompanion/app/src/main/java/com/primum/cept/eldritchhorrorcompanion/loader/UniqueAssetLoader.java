package com.primum.cept.eldritchhorrorcompanion.loader;

import android.content.ContentValues;
import android.content.res.AssetManager;
import android.os.Process;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract;
import com.primum.cept.eldritchhorrorcompanion.data.cards.UniqueAssetCard;

import java.io.InputStream;

/**
 * An extension to the base AbstractLoader class. Adds support for loading of Unique Asset cards
 * Created by peter.marteen on 9/14/17.
 */

public abstract class UniqueAssetLoader extends AbstractLoader {

    protected abstract String getUniqueAssetPath();

    protected String uniqueAssetFile = "/uniqueAssets.json";

    protected void loadUniqueAssets(ObjectMapper mapper, AssetManager assetManager) {
        try {
            InputStream is = assetManager.open(getUniqueAssetPath());
            UniqueAssetCard[] uniqueAssets = mapper.readValue(is, UniqueAssetCard[].class);
            for (UniqueAssetCard uniqueAsset : uniqueAssets) {
                ContentValues values = new ContentValues();
                values.put(CardContract.CardEntry.COLUMN_NAME, uniqueAsset.name);
                values.put(CardContract.CardEntry.COLUMN_TYPE, uniqueAsset.typeString());

                db.insert(CardContract.CardEntry.UNIQUE_ASSET_TABLE_NAME, null, values);
            }
            is.close();
        } catch (Exception e) {

        }
    }

    @Override
    public void run() {
        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_FOREGROUND);

        ObjectMapper mapper = new ObjectMapper();
        AssetManager assetManager = context.getAssets();
        super.run();
        loadUniqueAssets(mapper, assetManager);
    }
}
