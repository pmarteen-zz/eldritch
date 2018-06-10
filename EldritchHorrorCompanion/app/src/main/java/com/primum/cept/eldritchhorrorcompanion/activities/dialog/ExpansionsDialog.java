package com.primum.cept.eldritchhorrorcompanion.activities.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.primum.cept.eldritchhorrorcompanion.R;
import com.primum.cept.eldritchhorrorcompanion.activities.DisplayCardActivity;
import com.primum.cept.eldritchhorrorcompanion.activities.MainMenuActivity;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract;
import com.primum.cept.eldritchhorrorcompanion.data.CardDbHelper;
import com.primum.cept.eldritchhorrorcompanion.loader.LoadManager;

import java.util.ArrayList;
import java.util.List;

import static com.primum.cept.eldritchhorrorcompanion.activities.CardMenuActivity.CARD_TYPE;

/**
 * Created by Peter on 5/24/2018.
 */

public class ExpansionsDialog extends DialogFragment {
    List<Integer> mSelectedItems;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mSelectedItems = new ArrayList();  // Where we track the selected items
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Set the dialog title
        builder.setTitle(R.string.select_expansions)
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(R.array.expansions, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                // Set the action buttons
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        Toast.makeText(getActivity(), "Please wait while the card decks are reloaded...", Toast.LENGTH_SHORT).show();
                        setupDb();

                        Intent intent = new Intent(getActivity(), MainMenuActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Cancel?
                    }
                });

        return builder.create();
    }

    private void setupDb(){
        CardDbHelper cardDbHelper = CardDbHelper.getInstance(getActivity());
        SQLiteDatabase db = cardDbHelper.getWritableDatabase();
        cardDbHelper.clean(db);

        LoadManager.getInstance().load(getActivity(),db);

    }
}
