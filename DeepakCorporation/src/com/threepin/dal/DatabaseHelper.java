package com.threepin.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	public DatabaseHelper(Context context) {
		super(context, "loacal.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	 db.execSQL("create table tblArea (AreaId varchar ,Name varchar)");
	 db.execSQL("create table tblEmployee (EmployeeId varchar ,Name varchar,Username varchar,Password varchar,Password varchar,ManagerId varchar)");
	 db.execSQL("create table tblClient (ClientId varchar ,Name varchar,EmployeeId varchar,AreaId varchar,Active varchar)");
	 db.execSQL("CREATE table tblTransaction (TransactionId varchar,Type varchar,EmployeeId varchar,ClientId varchar,Date varchar,Amount varchar,Remark varchar");
	 db.execSQL("create table tblActivity (ActivityId varchar,TransactionId varchar ,EmployeeId varchar,ClientId varchar)");
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
