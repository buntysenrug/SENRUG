package com.packagemain.senrug;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Rssreader {
	private String url;
	
	
	public Rssreader(String url){
		this.url=url;
		
	}
	
	public List<RssItem> getItems() throws Exception{
		// SAX parser 
		
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser saxParser=factory.newSAXParser();
		
		RssHandler handler=new RssHandler();
		saxParser.parse(url, handler);
		
		return handler.getItems();
	}

}
