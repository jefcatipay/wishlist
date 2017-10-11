package com.example.jefkrisfercatipay.wishlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jef Krisfer Catipay on 10/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG ="DatabaseHelper";
    private static final String TABLE_NAME ="wish_table" ;
    private static final String COL1 = "ID";
    private  static final String COL2 = "wName";
    private  static final String COL3 = "wDesc";
    private  static final String COL4 = "wPrice";
    private  static final String COL5 = "wImage";
    public DatabaseHelper (Context context){
        super(context, TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL2 +" TEXT, " + COL3 +
                " TEXT, "+ COL4+ " NUMERIC, " + COL5 + " TEXT " + ")" ;
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    public void deleteWish(Integer id, String name){
    SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'";
        db.execSQL(query);
    }

    public boolean addData(String name, String desc, Double price, String Image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,desc);
        contentValues.put(COL4,price);
        contentValues.put(COL5,Image);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1){
           return  false;
        }
        else {
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return  data;
    }
    public Cursor getWishID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;

    }

}
