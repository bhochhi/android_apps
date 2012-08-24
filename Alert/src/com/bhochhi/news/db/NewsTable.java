package com.bhochhi.news.db;

import android.database.sqlite.SQLiteDatabase;

public class NewsTable {

	public static final String TABLE_NEWS = "news";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_ISREAD = "isRead";
	
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_NEWS
			+ "("
			+ COLUMN_ID +" integer primary key autoincrement, "
			+ COLUMN_TITLE+" text not null,"
			+ COLUMN_DESCRIPTION+" text not null,"
			+ COLUMN_ISREAD+" text not null)";
	
	public static void onCreate(SQLiteDatabase database){
		database.execSQL(DATABASE_CREATE);
	}
}
