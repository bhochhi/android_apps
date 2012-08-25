package com.bhochhi.todos;

import android.app.ListActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.bhochhi.todos.contentprovider.MyTodoContentProvider;
import com.bhochhi.todos.database.TodoTable;

public class TodosOverviewActivity extends ListActivity implements LoaderCallbacks<Cursor> {
	private static final int ACTIVITY_CREATE = 0;
	private static final int ACTIVITY_EDIT = 1;
	private static final int DELETE_ID = Menu.FIRST + 1;
	// private Cursor cursor;
	private SimpleCursorAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_list);
        this.getListView().setDividerHeight(2);
        fillData();
    }
    private void fillData() {

		// Fields from the database (projection)
		// Must include the _id column for the adapter to work
		String[] from = new String[] { TodoTable.COLUMN_SUMMARY };
		// Fields on the UI to which we map
		int[] to = new int[] { R.id.label };

		getLoaderManager().initLoader(0, null, this);
		adapter = new SimpleCursorAdapter(this, R.layout.todo_row, null, from,
				to, 0);

		setListAdapter(adapter);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listmenu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch (item.getItemId()) {
		case R.id.insert:
			createTodo();
			return true;
			}
    	return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case DELETE_ID:
    		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
    		Uri uri = Uri.parse(MyTodoContentProvider.CONTENT_URI +"/"+info.id);
    		getContentResolver().delete(uri, null, null);
    		fillData();
    		return true;
    	}
    	return super.onContextItemSelected(item);    	
    }

    @Override
    protected void onListItemClick(ListView l,View v, int position,long id){
    	super.onListItemClick(l, v, position, id);
    	Intent i = new Intent(this,TodoDetailActivity.class);
    	Uri todoUri = Uri.parse(MyTodoContentProvider.CONTENT_URI+"/"+id);
    	i.putExtra(MyTodoContentProvider.CONTENT_ITEM_TYPE, todoUri);
    	startActivityForResult(i, ACTIVITY_EDIT);
    }
    
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
    	super.onActivityResult(requestCode, resultCode, intent);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo){
    	super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, DELETE_ID, 0, R.string.menu_delete);
    }
    
    private void createTodo() {
		Intent i = new Intent(this, TodoDetailActivity.class);
		startActivityForResult(i, ACTIVITY_CREATE);
	}
	
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		String[] projection = { TodoTable.COLUMN_ID, TodoTable.COLUMN_SUMMARY };
		CursorLoader cursorLoader = new CursorLoader(this,MyTodoContentProvider.CONTENT_URI, projection, null, null, null);
		return cursorLoader;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		adapter.swapCursor(data);		
		
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		adapter.swapCursor(null);
	}

    
}
