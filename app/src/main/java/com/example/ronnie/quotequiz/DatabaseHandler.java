package com.example.ronnie.quotequiz;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.*;
import android.provider.Settings;

/**
 * Created by ronnie on 02.05.16.
 */
public class DatabaseHandler extends SQLiteOpenHelper{
    public DatabaseHandler(Context context) {
        super ( context , "Tablica" , null , 1 ) ;
        System.out.print( "DATABASE CREATED\n" ) ;
    }

    public void addQuote ( String quote_text , String quote_author ) {
        SQLiteDatabase db = this.getWritableDatabase ( ) ;
        ContentValues contentValues = new ContentValues ( ) ;
        contentValues.put ( "kolonka_citat" , quote_text ) ;
        contentValues.put ( "kolonka_avtor" , quote_author ) ;
        db.insert ( "Tablica" , null , contentValues ) ;
    }
    public Cursor getRandomQuote ( ) {
        SQLiteDatabase db = this.getReadableDatabase();
        //String[] curstr = {"random_string1" , "random_string2" } ;
        System.out.print("DOTUKA SYSHTO STIGA\n");
        Cursor cursor = db.rawQuery("SELECT kolonka_citat, kolonka_avtor FROM Tablica ORDER BY RAND();" ,  null );
        return cursor ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL ( "CREATE TABLE Tablica(kolonka_citat TEXT, kolonka_avtor TEXT);") ;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
