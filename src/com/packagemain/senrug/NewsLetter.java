package com.packagemain.senrug;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewsLetter extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newsletter);
		ListView list=(ListView)findViewById(android.R.id.list);
		ArrayList<String> headlines,links;
		headlines = new ArrayList<String>();
		links=new ArrayList<String>();
		
		try{
			URL url=new URL("http://www.nusu.co.uk/rss/newsfeed.php");
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = factory.newPullParser();
			
			xpp.setInput(getInputStream(url), "UTF_8");
			
			boolean inside=false;
			int eventType=xpp.getEventType();
			while(eventType != XmlPullParser.END_DOCUMENT){
				if(eventType==XmlPullParser.START_TAG){
					if (xpp.getName().equalsIgnoreCase("item")){
						inside=true;
					}else if(xpp.getName().equalsIgnoreCase("title")){
						if(inside){
							headlines.add(xpp.nextText());
						}	
					}else if(xpp.getName().equalsIgnoreCase("links")){
						if(inside){
							links.add(xpp.nextText());
						}
					}else if(eventType==XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")){
						inside=false;
					}
				}
				eventType = xpp.next(); //move to next element

				
			}


			
		}catch (MalformedURLException e){
			e.printStackTrace();
			
		} catch (XmlPullParserException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,headlines);
		list.setAdapter(adapter);
		
		
	}
	
	public InputStream getInputStream(URL url) {
		   try {
		       return url.openConnection().getInputStream();
		   } catch (IOException e) {
		       return null;
		     }
		}
	
	

}
