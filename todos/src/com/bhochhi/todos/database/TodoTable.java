package com.bhochhi.todos.database;

import android.database.sqlite.SQLiteDatabase;

public class TodoTable {
	// Database table
		public static final String TABLE_TODO = "todo";
		public static final String COLUMN_ID = "_id";
		public static final String COLUMN_CATEGORY = "category";
		public static final String COLUMN_SUMMARY = "summary";
		public static final String COLUMN_DESCRIPTION = "description";
		private static final String DATABASE_CREATE = "create table "
				+ TABLE_TODO
				+ "(" + COLUMN_ID + " integer primary key autoincrement, " 
				+ COLUMN_CATEGORY + " text not null, " 
				+ COLUMN_SUMMARY + " text not null," 
				+ COLUMN_DESCRIPTION
				+ " text not null" + ");";
		
		public static void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);			
		}
}
