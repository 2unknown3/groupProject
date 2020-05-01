package com.example.harta;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "myDB";
    public static final String TABLE_NAME = "myProfile_Data";
    public static final String TABLE_NAME2 = "sensorDatabase";
    public static final String TABLE_NAME3 = "graphDatabase";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "AGE";
    public static final String COL4 = "PHONE";

    public static final String TABLE2_COL1 = "ID2";
    public static final String TABLE2_COL2 = "AVERAGEBPM";
    public static final String TABLE2_COL3 = "MAXBPM";
    public static final String TABLE2_COL4 = "MINBPM";
    public static final String TABLE2_COL5 = "DATEBPM";

    public static final String TABLE3_COL1 = "ID3";
    public static final String TABLE3_COL2 = "AVGBPM";
    public static final String TABLE3_COL3 = "DTBPM";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, " + "AGE TEXT, " + "PHONE TEXT)";
        String pulseSensorDatabase = "CREATE TABLE " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + "AVERAGEBPM INTEGER, " + "MAXBPM INTEGER, " +"MINBPM INTEGER, "+ "DATEBPM TEXT)";
      //  String graphViewTable = "CREATE TABLE " + TABLE_NAME3 + " (ID INTERGER PRIMARY KEY AUTOINCREMENT, " + " AVGBPM INTEGER, " + "DTBPM TEXT)";
        db.execSQL(createTable);
        db.execSQL(pulseSensorDatabase);
      //  db.execSQL(graphViewTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
    }

    public boolean addData(String name,String age,String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3,age);
        contentValues.put(COL4,phone);

        long result = db.insert(TABLE_NAME, null,contentValues);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean addPulseData(int avg,int max,int min,String dt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE2_COL2, avg);
        contentValues.put(TABLE2_COL3, max);
        contentValues.put(TABLE2_COL4, min);
        contentValues.put(TABLE2_COL5, dt);

        long result = db.insert(TABLE_NAME2, null,contentValues);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean addGraphData(int avg,String dt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE3_COL2, avg);
        contentValues.put(TABLE3_COL3, dt);

        long result = db.insert(TABLE_NAME3, null,contentValues);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getListContent(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return data;
    }

    public Cursor getListContent2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME2 + " ORDER BY ID DESC",null);
        return data;
    }

    public Cursor getListContent3(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME3,null);
        return data;
    }

    public boolean updateData(String name, String age, String phone){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,age);
        contentValues.put(COL4,phone);
        db.update(TABLE_NAME,contentValues,  "id=1", null);
        return true;
    }

}
