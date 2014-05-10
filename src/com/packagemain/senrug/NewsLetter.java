package com.packagemain.senrug;


import java.util.List;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.PushService;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewsLetter extends Activity{
	
	private NewsLetter local;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Set view
				setContentView(R.layout.newsletter);
			
			
				// Set reference to this activity
				local = this;

				RSSTask task = new RSSTask();

				// Start download RSS task
				task.execute("http://www.senrug.co.uk/rss/");

				// Debug the thread name
				Log.d("RSS Reader", Thread.currentThread().getName());
	}
	
	private class RSSTask extends AsyncTask<String,Void,List<RssItem>>{
		
		
		@Override
		protected List<RssItem> doInBackground(String... urls) {

			// Debug the task thread name
			Log.d("Rss Reader", Thread.currentThread().getName());

			try {
				// Create RSS reader
				Rssreader rssReader = new Rssreader(urls[0]);

				// Parse RSS, get items
				return rssReader.getItems();

			} catch (Exception e) {
				Log.e("RssReader", e.getMessage());
			}

			return null;
		}

		@Override
		protected void onPostExecute(List<RssItem> result) {
			// Get a ListView from main view
						ListView itcItems = (ListView) findViewById(R.id.list_news);

						// Create a list adapter
						ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(local,android.R.layout.simple_list_item_1, result);
						// Set list adapter for the ListView
						itcItems.setAdapter(adapter);

						// Set list view item click listener
						itcItems.setOnItemClickListener(new ListAdapterListener(result, local));

		}
		
		
		
	}
	
	

}
