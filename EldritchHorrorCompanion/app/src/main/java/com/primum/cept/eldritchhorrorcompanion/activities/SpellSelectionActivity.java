package com.primum.cept.eldritchhorrorcompanion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.primum.cept.eldritchhorrorcompanion.R;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract;

import java.util.ArrayList;
import java.util.List;

public final class SpellSelectionActivity extends SelectionActivity {
    List<String> checkedBoxes = new ArrayList<>();

    private static String GLAMOUR = "glamour";
    private static String INCANTATION = "incantation";
    private static String RITUAL = "ritual";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Use fragments instead of separate layouts for these activities
        setContentView(R.layout.activity_spell_selection_check);
        checkedBoxes.add(GLAMOUR);
        checkedBoxes.add(INCANTATION);
        checkedBoxes.add(RITUAL);

    }
    @Override
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.any:
                if (checked)
                    radioValue = null;
                    break;
            case R.id.rituals:
                if (checked)
                    radioValue = RITUAL;
                    break;
            case R.id.incantations:
                if (checked)
                    radioValue = INCANTATION;
                    break;
            case R.id.glamours:
                if (checked)
                    radioValue = GLAMOUR;
                    break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_glamours:
                if (checked){
                    checkedBoxes.add(GLAMOUR);
                }
                else
                    checkedBoxes.remove(GLAMOUR);
                break;
            case R.id.checkbox_incantations:
                if (checked){
                    checkedBoxes.add(INCANTATION);
                }
                else
                    checkedBoxes.remove(INCANTATION);
                break;
            case R.id.checkbox_ritual:
                if (checked){
                    checkedBoxes.add(RITUAL);
                }
                else
                    checkedBoxes.remove(RITUAL);
                break;
        }
    }

    @Override
    public void displayRandomCard(View view){
        Intent intent = new Intent(this, DisplayCardActivity.class);
        String message = CardContract.CardEntry.SPELL_TABLE_NAME;
        intent.putExtra(CardMenuActivity.CARD_TYPE, message);
        //magic number 3 = total types of spells
        if(!checkedBoxes.isEmpty() && checkedBoxes.size() != 3) {
            intent.putExtra(SUBCATEGORIES, checkedBoxes.toArray(new String[checkedBoxes.size()]));
        }
        //TODO: pass db to next activity
        startActivity(intent);
    }
}
