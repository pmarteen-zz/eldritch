package com.primum.cept.eldritchhorrorcompanion.activities;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.primum.cept.eldritchhorrorcompanion.R;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract.CardEntry;
import com.primum.cept.eldritchhorrorcompanion.data.CardDbHelper;
import com.primum.cept.eldritchhorrorcompanion.loader.BaseSetLoader;
import com.primum.cept.eldritchhorrorcompanion.loader.ForsakenLoreLoader;
import com.primum.cept.eldritchhorrorcompanion.loader.LoadManager;
import com.primum.cept.eldritchhorrorcompanion.loader.StrangeRemnantsLoader;
import com.primum.cept.eldritchhorrorcompanion.loader.UnderThePyramidsLoader;

public class CardMenuActivity extends AppCompatActivity {

    public static String CARD_TYPE = "card_type";
    public CardDbHelper cardDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_menu);
    }

    public void displayRandomSpell(View view){
        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);
    }
    public void displayRandomAsset(View view){
        Intent intent = new Intent(this, DisplayCardActivity.class);
        String message = CardEntry.ASSET_TABLE_NAME;
        intent.putExtra(CARD_TYPE, message);
        startActivity(intent);
    }
    public void displayRandomUniqueAsset(View view){
        Intent intent = new Intent(this, DisplayCardActivity.class);
        String message = CardEntry.UNIQUE_ASSET_TABLE_NAME;
        intent.putExtra(CARD_TYPE, message);
        intent.putExtra(SelectionActivity.SUBCATEGORY, "task");
        startActivity(intent);
    }
    public void displayRandomArtifact(View view){
        Intent intent = new Intent(this, DisplayCardActivity.class);
        String message = CardEntry.ARTIFACT_TABLE_NAME;
        intent.putExtra(CARD_TYPE, message);
        startActivity(intent);
    }

    public void resetDb(View view){
        Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_SHORT).show();
        setupDb();
        Toast.makeText(getApplicationContext(), "Databases cleared and reloaded!", Toast.LENGTH_SHORT).show();
    }

    private void setupDb(){
        Context context = getBaseContext();
        cardDbHelper = CardDbHelper.getInstance(context);
        SQLiteDatabase db = cardDbHelper.getWritableDatabase();
        cardDbHelper.clean(db);

        LoadManager.getInstance().load(context,db);
        //Load Base set
//        BaseSetLoader baseSetLoader = new BaseSetLoader(context, db);
//        baseSetLoader.run();
//
//        //Load Forsaken Lore expansion set
//        ForsakenLoreLoader forsakenLoreLoader = new ForsakenLoreLoader(context,db);
//        forsakenLoreLoader.run();
//
//        //Load Strange Remnants expansion set
//        StrangeRemnantsLoader strangeRemnantsLoader = new StrangeRemnantsLoader(context, db);
//        strangeRemnantsLoader.run();
//
//        //Load Under The Pyramids expansion set
//        UnderThePyramidsLoader underThePyramidsLoader = new UnderThePyramidsLoader(context, db);
//        underThePyramidsLoader.run();
    }
}
