package com.bhochhi.news;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bhochhi.todos.R;


public class MainActivity extends ListActivity {

	private NewsAdaper nAdapter;
	private ArrayList<News> newsList;
	private NewsDataSource dataSource;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		newsList = getAllNews(this);
		this.nAdapter = new NewsAdaper(this, R.layout.news_items, newsList);
		setListAdapter(this.nAdapter);
	}

	private ArrayList<News> getAllNews(Context context) {

		ArrayList<News> newsL = new ArrayList<News>();
		dataSource = new NewsDataSource(context);
		dataSource.open();
		dataSource.deleteAll();

		dataSource.insertNews("Title 1", "dwewewedadf", "source 1", "false");
		dataSource.insertNews("Title 2", "dwewewedadf", "source 2", "false");
		dataSource.insertNews("Title 3", "dwewewedadf", "source 3", "true");
		dataSource.insertNews("Title 4", "dwewewedadf", "source 4", "true");
		dataSource.insertNews("Title 5", "dwewewedadf", "source 5", "true");
		dataSource.insertNews("Title 6", "dwewewedadf", "source 6", "false");
		dataSource.insertNews("Title 7", "dwewewedadf", "source 7", "true");
		dataSource.insertNews("Title 8", "dwewewedadf", "source8", "true");
		dataSource.insertNews("Title 9", "dwewewedadf", "source 9", "true");
		dataSource.insertNews("Title 10", "dwewewedadf", "source 10", "true");
		dataSource.insertNews("Title 11", "dwewewedadf", "source 11", "true");
		dataSource.insertNews("Title 62 long one to see the ellipse so more long loooooooonnnnnnnng","dwewewedadf", "source 6", "false");
		dataSource.insertNews("Title 7", "dwewewedadf", "source 7", "true");
		dataSource.insertNews("Title 8", "dwewewedadf", "source8", "true");
		dataSource.insertNews("Title 9", "dwewewedadf", "source 9", "true");
		dataSource.insertNews("Title 10", "dwewewedadf", "source 10", "true");
		dataSource.insertNews("Title 11", "dwewewedadf", "source 11", "true");
		dataSource.insertNews("Title 63", "dwewewedadf", "source 6", "false");
		dataSource.insertNews("Title3 7", "dwewewedadf", "source 7", "true");
		dataSource.insertNews("Title 28", "dwewewedadf", "source8", "true");
		dataSource.insertNews("Title 29", "dwewewedadf", "source 9", "true");
		dataSource.insertNews("Title 310", "dwewewedadf", "source 10", "true");
		dataSource.insertNews("Title 1323", "dwewewedadf", "source 11", "false");
		newsL = dataSource.getAllNews();

		return newsL;
	}

	private class NewsAdaper extends ArrayAdapter<News> {
		private ArrayList<News> items;

		public NewsAdaper(Context context, int textViewResourceId,
				ArrayList<News> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.news_items, null);
			}
			News n = items.get(position);

			if (n != null) {
				TextView tt = (TextView) v.findViewById(R.id.titleText);
				if (tt != null) {

					if (n.isRead) {
						tt.setTypeface(Typeface.DEFAULT);
						// v.setBackgroundColor(R.color.read);
					} else {
						tt.setTypeface(Typeface.DEFAULT_BOLD);
					}

					tt.setText(n.getTitle());
				}

			}

			return v;
		}

	}
}
