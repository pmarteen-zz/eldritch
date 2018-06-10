package com.primum.cept.eldritchhorrorcompanion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.primum.cept.eldritchhorrorcompanion.R;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract;

/**
 * Created by Peter on 1/22/2018.
 */

public class ArtifactSelectionActivity extends SelectionActivity {

    public static final String ELIXIR = "elixir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Use fragments instead of separate layouts for these activities
        setContentView(R.layout.activity_artifact_selection);

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.any:
                if (checked)
                    radioValue = null;
                break;
            case R.id.elixir:
                if (checked)
                    radioValue = ELIXIR;
                break;
            case R.id.item:
                if (checked)
                    radioValue = ITEM;
                break;
            case R.id.magical:
                if (checked)
                    radioValue = MAGICAL;
                break;
            case R.id.relic:
                if (checked)
                    radioValue = RELIC;
                break;
            case R.id.teamwork:
                if (checked)
                    radioValue = TEAMWORK;
                break;
            case R.id.tome:
                if (checked)
                    radioValue = TOME;
                break;
            case R.id.trinket:
                if (checked)
                    radioValue = TRINKET;
                break;
            case R.id.weapon:
                if (checked)
                    radioValue = WEAPON;
                break;
        }
    }

    @Override
    public void displayRandomCard(View view){
        Intent intent = new Intent(this, DisplayCardActivity.class);
        String message = CardContract.CardEntry.ARTIFACT_TABLE_NAME;
        intent.putExtra(CardMenuActivity.CARD_TYPE, message);
        intent.putExtra(SUBCATEGORY, radioValue);
        //TODO: pass db to next activity
        startActivity(intent);
    }
}
