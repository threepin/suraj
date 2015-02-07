package com.threepin.dal;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ViewDatabaseHelper extends SQLiteOpenHelper{

	public ViewDatabaseHelper(Context context) {
		super(context, "ViewDatabase.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	 db.execSQL("create table tblNavigation (NavId Integer primary key autoincrement ,Name varchar,visible varchar)");

	 db.execSQL("insert into tblNavigation (Name,visible) values ('Home','true')");
	 db.execSQL("insert into tblNavigation (Name,visible) values ('Transactions','true')");
	 db.execSQL("insert into tblNavigation (Name,visible) values ('Clients','true')");
	 db.execSQL("insert into tblNavigation (Name,visible) values ('Employees','true')");
	 db.execSQL("insert into tblNavigation (Name,visible) values ('Summarys','true')");
	 db.execSQL("insert into tblNavigation (Name,visible) values ('Reports','false')");
	 db.execSQL("insert into tblNavigation (Name,visible) values ('About Us','true')");
	 db.execSQL("insert into tblNavigation (Name,visible) values ('Exit','false')");
	}


	public ArrayList<String> getNavigationMenuList()
	{
		ArrayList<String> list = new ArrayList<String>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from tblNavigation where visible = 'true'", null);
		if(cursor.moveToFirst())
		{
			do {
				list.add(cursor.getString(1));
			} while (cursor.moveToNext());
		}
		return list;
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
