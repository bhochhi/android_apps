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
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private NewsAdaper nAdapter;
	private ArrayList<News> newsList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		newsList = getAllNews();
		this.nAdapter = new NewsAdaper(this, R.layout.news_items, newsList);
		setListAdapter(this.nAdapter);
	}

	private ArrayList<News> getAllNews() {

		ArrayList<News> newsL = new ArrayList<News>();
		newsL.add(new News(
				"Title 1 dsfsa dajf askdjfkl jafeiwkl jeklwj e sDASDasdqw",
				"dwewewe", false));
		newsL.add(new News("Title 2", "dwewewe", false));
		newsL.add(new News("Title 3", "dwewewe", false));
		newsL.add(new News("Title 4", "dwewewe", true));
		newsL.add(new News("Title 5", "dwewewe", true));
		newsL.add(new News("Title 6", "dwewewe", true));
		newsL.add(new News("Title 7", "dwewewe", true));
		newsL.add(new News("Title 8", "dwewewe", true));
		newsL.add(new News("Title 9", "dwewewe", true));
		newsL.add(new News("Title 10", "dwewewe", true));
		newsL.add(new News("Title 11", "dwewewe", true));
		newsL.add(new News("Title 1", "dwewewe", false));
		newsL.add(new News("Title 2", "dwewewe", false));
		newsL.add(new News("Title 3", "dwewewe", false));
		newsL.add(new News("Title 4", "dwewewe", true));
		newsL.add(new News("Title 5", "dwewewe", true));
		newsL.add(new News("Title 6", "dwewewe", true));
		newsL.add(new News("Title 7", "dwewewe", true));
		newsL.add(new News("Title 8", "dwewewe", true));
		newsL.add(new News("Title 9", "dwewewe", true));
		newsL.add(new News("Title 10", "dwewewe", true));
		newsL.add(new News("Title 11", "dwewewe", true));
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
						v.setBackgroundColor(R.color.read);
					} else {
						tt.setTypeface(Typeface.DEFAULT_BOLD);
						v.setBackgroundColor(R.color.unRead);
					}

					tt.setText(n.getTitle());
				}

			}

			return v;
		}

	}
}
