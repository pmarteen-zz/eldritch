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

    String radioValue;

    abstract public void onRadioButtonClicked(View view);

    abstract public void displayRandomCard(View view);
}
