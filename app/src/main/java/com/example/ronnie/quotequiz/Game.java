package com.example.ronnie.quotequiz;

import android.database.Cursor;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

/**
 * Created by ronnie on 01.05.16.
 */
public class Game extends MainActivity{
    //MainActivity parent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if( MainActivity == null ) System.out.println( "From game, parent is null" );
        //else System.out.println( "From game, parent is not null" );
        if ( MainActivity.binary_mode == true ) {
            setContentView(R.layout.game_binary);
            System.out.print("SO FAR SO GOOD\n");
            Cursor cursor = MainActivity.databaseHandler.getRandomQuote (  ) ;
            System.out.print("GOT THE RANDOM QUOTE\n");
            cursor.moveToFirst();
            final TextView a = (TextView) findViewById(R.id.question_text);
            a.setText((String)cursor.getString((int)cursor.getColumnIndex("kolonka_citat")));
            cursor.close();
            //parent.sqLiteDatabase = parent.getWritableDatabase ( ) ;
            //Cursor cursor = parent.sqLiteDatabase.execSQL("SELECT QUOTE FROM TABLE_NAME");
            /**
            final TextView show = (TextView) findViewById(R.id.show_mode);
            if (parent.binary_mode == true) {
                show.setText("You are playing in binary mode");
            } else {
                show.setText("You are playing in multiple choice mode");
            }
             **/

        }
        else {
            setContentView(R.layout.game_multiple_choice);
        }
    }
}
