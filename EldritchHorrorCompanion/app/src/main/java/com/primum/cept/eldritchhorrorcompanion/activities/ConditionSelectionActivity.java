package com.primum.cept.eldritchhorrorcompanion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.primum.cept.eldritchhorrorcompanion.R;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract;

/**
 * Created by peter.marteen on 9/18/17.
 */

public final class ConditionSelectionActivity extends SelectionActivity {

    public static final String BANE = "bane";
    public static final String BOON = "boon";
    public static final String COMMON = "common";
    public static final String DEAL = "deal";
    public static final String EXPOSURE = "exposure";
    public static final String ILLNESS = "illness";
    public static final String INJURY = "injury";
    public static final String MADNESS = "madness";
    public static final String PURSUIT = "pursuit";
    public static final String RESTRICTION = "restriction";
    public static final String TALENT = "talent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Use fragments instead of separate layouts for these activities
        setContentView(R.layout.activity_condition_selection);

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.bane:
                if (checked)
                    radioValue = BANE;
                break;
            case R.id.boon:
                if (checked)
                    radioValue = BOON;
                break;
            case R.id.common:
                if (checked)
                    radioValue = COMMON;
                break;
            case R.id.deal:
                if (checked)
                    radioValue = DEAL;
                break;
            case R.id.exposure:
                if (checked)
                    radioValue = EXPOSURE;
                break;
            case R.id.illness:
                if (checked)
                    radioValue = ILLNESS;
                break;
            case R.id.injury:
                if (checked)
                    radioValue = INJURY;
                break;
            case R.id.madness:
                if (checked)
                    radioValue = MADNESS;
                break;
            case R.id.pursuit:
                if (checked)
                    radioValue = PURSUIT;
                break;
            case R.id.restriction:
                if (checked)
                    radioValue = RESTRICTION;
                break;
            case R.id.talent:
                if (checked)
                    radioValue = TALENT;
                break;
        }
    }
    @Override
    public void displayRandomCard(View view){
        if(radioValue == null)
        {
            Toast.makeText(getApplicationContext(), "Please subcategory", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, DisplayCardActivity.class);
            String message = CardContract.CardEntry.CONDITION_TABLE_NAME;
            intent.putExtra(CardMenuActivity.CARD_TYPE, message);
            intent.putExtra(SUBCATEGORY, radioValue);
            //TODO: pass db to next activity
            startActivity(intent);
        }
    }
}
