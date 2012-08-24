package com.bhochhi.news.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NewsDbHelper extends SQLiteOpenHelper{

	
	private static final String DB_NAME = "news.db";
	private static final int DATABASE_VERSION =1;
	
	public NewsDbHelper(Context context){
		super(context,DB_NAME,null,DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		NewsTable.onCreate(db);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	
}
