package com.primum.cept.eldritchhorrorcompanion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.primum.cept.eldritchhorrorcompanion.R;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract;

/**
 * Created by peter.marteen on 9/16/17.
 */

public abstract class SelectionActivity extends AppCompatActivity {
    public static String SUBCATEGORY = "subcategory";
    public static String SUBCATEGORIES = "subcategories";
    public static final String RELIC = "relic";
    public static final String TOME = "tome";
    public static final String TASK = "task";
    public static final String WEAPON = "weapon";
    public static final String ALLY = "ally";
    public static final String CHARACTER = "character";
    public static final String MAGICAL = "magical";
    public static final String TRINKET = "trinket";
    public static final String TAROT = "tarot";
    public static final String ITEM = "item";
    public static final String SERVICE = "service";
    public static final String TEAMWORK = "teamwork";


    String radioValue;

    abstract public void displayRandomCard(View view);
}
