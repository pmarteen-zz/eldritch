package com.primum.cept.eldritchhorrorcompanion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.primum.cept.eldritchhorrorcompanion.R;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract;

public class SelectionActivity extends AppCompatActivity {
    public static String SUBCATEGORY = "subcategory";

    String radioValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_selection);

    }

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
                    radioValue = "ritual";
                    break;
            case R.id.incantations:
                if (checked)
                    radioValue = "incantation";
                    break;
            case R.id.glamours:
                if (checked)
                    radioValue = "glamour";
                    break;
        }
    }

    public void displayRandomSpell(View view){
        Intent intent = new Intent(this, DisplayCardActivity.class);
        String message = CardContract.CardEntry.SPELL_TABLE_NAME;
        intent.putExtra(CardMenuActivity.CARD_TYPE, message);
        intent.putExtra(SUBCATEGORY, radioValue);
        //TODO: pass db to next activity
        startActivity(intent);
    }
}
