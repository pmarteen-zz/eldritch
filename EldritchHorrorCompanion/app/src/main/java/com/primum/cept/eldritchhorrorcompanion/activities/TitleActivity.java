package com.primum.cept.eldritchhorrorcompanion.activities;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.primum.cept.eldritchhorrorcompanion.R;
import com.primum.cept.eldritchhorrorcompanion.activities.dialog.ExpansionsDialog;


/**
 * Created by Peter on 5/24/2018.
 */

public class TitleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

    }

    public void displayDialog(View view){
        // Create and show the dialog.
        DialogFragment newFragment = new ExpansionsDialog();
        newFragment.show(getFragmentManager(), "dialog");
    }

    public void displayMainMenu(View view){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
