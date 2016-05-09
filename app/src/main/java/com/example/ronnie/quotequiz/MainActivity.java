package com.example.ronnie.quotequiz;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    //Context context ;
    public static DatabaseHandler databaseHandler ;

    public static boolean binary_mode = true ;

    public void PreloadQuotes ( ) {
        databaseHandler = new DatabaseHandler( this ) ;

        databaseHandler.addQuote ( "ZDR" , "CHONEV" ) ;
        databaseHandler.addQuote ( "You can do anything, but not everything." , "David Allen"  ) ;
        databaseHandler.addQuote ( "Perfection is achieved, not when there is nothing more to add, but when there is nothing left to take away." , "Antoine de Saint-Exupéry"  ) ;
        databaseHandler.addQuote ( "The richest man is not he who has the most, but he who needs the least." , "Ivo Karagyozov" ) ;
        databaseHandler.addQuote ( "You miss 100 percent of the shots you never take." , "Wayne Gretzky" ) ;
        databaseHandler.close ( ) ;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.printf ( "Start\n" ) ;
        PreloadQuotes();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void NewGame(View view) {
        Intent PlayGame =  new Intent(this,Game.class);
        startActivity(PlayGame);
    }

    public void Settings(View view) {
        Intent Settings = new Intent(this, Settings.class);
        startActivity(Settings);

    }

    public void Leaderboard(View view) {
    }
}
