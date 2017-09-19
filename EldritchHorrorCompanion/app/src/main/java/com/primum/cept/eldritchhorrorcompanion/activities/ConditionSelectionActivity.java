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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Use fragments instead of separate layouts for these activities
        setContentView(R.layout.activity_condition_selection);

    }
    @Override
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.madness:
                if (checked)
                    radioValue = "madness";
                break;
            case R.id.illness:
                if (checked)
                    radioValue = "illness";
                break;
            case R.id.injury:
                if (checked)
                    radioValue = "injury";
                break;
            case R.id.boon:
                if (checked)
                    radioValue = "boon";
                break;
            case R.id.talent:
                if (checked)
                    radioValue = "talent";
                break;
            case R.id.bane:
                if (checked)
                    radioValue = "bane";
                break;
            case R.id.deal:
                if (checked)
                    radioValue = "deal";
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
