package com.bhochhi.news;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class NewsDataSource {

	private SQLiteDatabase db;
	private DBHelper dbHelper;
	private String[] allColumns = { DBHelper.COLUMN_TITLE,DBHelper.COLUMN_DESC,DBHelper.COLUMN_ISREAD,DBHelper.COLUMN_SOURCE };

	public NewsDataSource(Context context) {
		dbHelper = new DBHelper(context);
	}

	public void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	public void deleteAll(){
		db.delete(DBHelper.TABLE_NAME, null, null);
	}

	public void insertNews(String title, String desc, String source,String isRead) {
		ContentValues cv = new ContentValues();
		cv.put(DBHelper.COLUMN_TITLE, title);
		cv.put(DBHelper.COLUMN_DESC, desc);
		cv.put(DBHelper.COLUMN_SOURCE, source);
		cv.put(DBHelper.COLUMN_ISREAD, isRead);
		db.insert(DBHelper.TABLE_NAME, null, cv);
	}
	
	public ArrayList<News> getAllNews(){
		ArrayList<News> news = new ArrayList<News>();
		Cursor  cursor = db.query(DBHelper.TABLE_NAME, allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			News nw = cursorToNews(cursor);
			news.add(nw);
			cursor.moveToNext();
		}
		return news;
	}

	private News cursorToNews(Cursor cursor) {
		News nw = new News();
		nw.setTitle(cursor.getString(0));
		nw.setDescription(cursor.getString(1));
		nw.isRead = Boolean.parseBoolean(cursor.getString(2));
		nw.setSource(cursor.getString(3));
		return nw;
	}
}

class DBHelper extends SQLiteOpenHelper {

	public static final String TABLE_NAME = "news";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_DESC = "description";
	public static final String COLUMN_ISREAD = "isRead";
	public static final String COLUMN_SOURCE = "source";

	private static final String DATABASE_NAME = "news.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	  private static final String DATABASE_CREATE = "create table "
	      + TABLE_NAME + "(" + COLUMN_TITLE + " text not null,"+COLUMN_DESC + " text not null,"+COLUMN_ISREAD+" text not null,"+COLUMN_SOURCE+" text not null);";
	  
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
		  Log.w(DBHelper.class.getName(),
			        "Upgrading database from version " + oldVer + " to "
			            + newVer + ", which will destroy all old data");
		  
			    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
			    onCreate(db);
	}

}