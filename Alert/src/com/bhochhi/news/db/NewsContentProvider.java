package com.bhochhi.news.db;

import java.util.Arrays;
import java.util.HashSet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class NewsContentProvider extends ContentProvider {

	private NewsDbHelper database;
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		database = new NewsDbHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
			String sortOrder) {
		  SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		  checkColumns(projection);
		  
		  queryBuilder.setTables(NewsTable.TABLE_NEWS);
		  
		  
		  
		return null;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void checkColumns(String[] projection) {
	    String[] available = { NewsTable.COLUMN_ID,
	        NewsTable.COLUMN_TITLE, NewsTable.COLUMN_DESCRIPTION,
	        NewsTable.COLUMN_ISREAD };
	    if (projection != null) {
	      HashSet<String> requestedColumns = new HashSet<String>(Arrays.asList(projection));
	      HashSet<String> availableColumns = new HashSet<String>(Arrays.asList(available));
	      // Check if all columns which are requested are available
	      if (!availableColumns.containsAll(requestedColumns)) {
	        throw new IllegalArgumentException("Unknown columns in projection");
	      }
	    }
	  }

}
