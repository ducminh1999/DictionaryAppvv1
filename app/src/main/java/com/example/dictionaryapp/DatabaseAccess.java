package com.example.dictionaryapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dictionaryapp.ui.home.HomeFragment;

import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }
    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
    public  void open(){
        this.database = openHelper.getWritableDatabase();
    }
    public void close(){
        if(database != null) this.database.close();
    }
    public ArrayList<String> getWords(){
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("Select * from anh_viet" ,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public String getDefination(String word){
        String defition = "";
        Cursor cursor = database.rawQuery("Select*from anh_viet where word = "+word +"",null);
        cursor.moveToNext();
        defition = cursor.getString(2);
        cursor.close();
        return defition;
    }
}

