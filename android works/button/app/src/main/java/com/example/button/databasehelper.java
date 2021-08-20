package com.example.button;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class  databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "customerItemCompany.db";
    public static final String TABLE_NAME1 = "item_table";
    public static final String TABLE_NAME2 = "customer_table";
    public static final String TABLE_NAME3 = "company_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM";
    public static final String COL3 = "COMPANY_NAME";
    public static final String COL4 = "HSN_CODE";
    public static final String COL5 = "MRP";

    public static  final String COL11 = "ID";
    public static final String COL12 = "NAME";
    public static final String COL13 = "SHOPNAME";
    public static final String COL14 = "ADDRESS";
    public static final String COL15 = "AREA";
    public static final String COL16 = "PHONE1";
    public static final String COL17 = "PHONE2";

    public static final String COL22 = "COMPANY_NAME";
    public static final String COL23 = "OWNER";
    public static final String COL24 = "ADDRESS";
    public static final String COL25 = "AREA";
    public static final String COL26 = "PHONE1";
    public static final String COL27 = "PHONE2";

    public databasehelper(@Nullable Context context){
        super(context, DATABASE_NAME,null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME1+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,ITEM TEXT,COMPANY_NAME TEXT,HSN_CODE TEXT,MRP TEXT)");
        db.execSQL("create table "+ TABLE_NAME2 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SHOPNAME TEXT,ADDRESS TEXT,AREA TEXT,PHONE1 TEXT,PHONE2 TEXT)");
        db.execSQL("create table "+ TABLE_NAME3 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,COMPANY_NAME TEXT,OWNER TEXT,ADDRESS TEXT,AREA TEXT,PHONE1 TEXT,PHONE2 TEXT)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME3);
        onCreate(db);
    }

    public boolean insertitem(String item,String company,String hsn,String mrp)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,item);
        contentValues.put(COL3,company);
        contentValues.put(COL4,hsn);
        contentValues.put(COL5,mrp);
        long result =  db.insert(TABLE_NAME1,null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor res =  db.rawQuery("SELECT ITEM FROM "  + TABLE_NAME1 + " GROUP BY COMPANY_NAME ",null );
        return res;
    }

    public boolean insertcustomer(String name,String shopname,String address,String area,String phone1,String phone2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(COL12,name);
        contentValues.put(COL13,shopname);
        contentValues.put(COL14,address);
        contentValues.put(COL15,area);
        contentValues.put(COL16,phone1);
        contentValues.put(COL17,phone2);
        long val = db.insert(TABLE_NAME2,null,contentValues);
        System.out.println("inserted");
        if(val == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean insertcompany(String companyname,String owner,String address,String area,String phone1,String phone2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(COL22,companyname);
        contentValues.put(COL23,owner);
        contentValues.put(COL24,address);
        contentValues.put(COL25,area);
        contentValues.put(COL26,phone1);
        contentValues.put(COL27,phone2);
        long val = db.insert(TABLE_NAME3,null,contentValues);
        if(val == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}

