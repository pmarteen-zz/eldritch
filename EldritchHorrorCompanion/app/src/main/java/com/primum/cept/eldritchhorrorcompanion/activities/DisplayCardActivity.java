package com.primum.cept.eldritchhorrorcompanion.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.primum.cept.eldritchhorrorcompanion.R;
import com.primum.cept.eldritchhorrorcompanion.data.CardContract.CardEntry;
import com.primum.cept.eldritchhorrorcompanion.data.CardDbHelper;
import com.primum.cept.eldritchhorrorcompanion.data.cards.Card;
import com.primum.cept.eldritchhorrorcompanion.data.cards.CardFactory;
import com.primum.cept.eldritchhorrorcompanion.data.cards.EmptyCard;

public class DisplayCardActivity extends AppCompatActivity {
    public CardDbHelper cardDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        cardDbHelper = CardDbHelper.getInstance(getBaseContext());


        Intent intent = getIntent();
        String cardType = intent.getStringExtra(CardMenuActivity.CARD_TYPE);
        String subcategory = intent.getStringExtra(SelectionActivity.SUBCATEGORY);

        try {
            Card randomCard = getRandomCard(cardType, subcategory);
            TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText(randomCard.displayCard());

            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
            layout.addView(textView);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    private Card getRandomCard(String tableName, String subcategory) throws Exception {
        SQLiteDatabase db = cardDbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery(createQuery(tableName, subcategory), null);
        int max = cursor.getCount() - 1;
        if(max < 0) return EmptyCard.getInstance();
        int rand = (int) (Math.random() * max);
        cursor.moveToPosition(rand);
        //TODO: Use card class rather than string
        CardFactory builder = CardFactory.getInstance();
        builder.setType(tableName);
        builder.setCursor(cursor);
        Card card = builder.build();

        long id = cursor.getLong(cursor.getColumnIndexOrThrow(CardEntry._ID));
        db.delete(tableName, CardEntry._ID + "=" + id, null);
        cursor.close();
        return card;
    }

    private String createQuery(String tableName, String subcategory){
        String query = "SELECT * FROM "+ tableName;
        if(subcategory != null){
            query += " WHERE " + CardEntry.COLUMN_TYPE + "='" + subcategory + "'";
        }
        return query;

    }

    private Card ToCard(Cursor cursor, String cardTable){
        return null;
    }


}
