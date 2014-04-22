package com.packagemain.senrug;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RssHandler extends DefaultHandler{
	private List<RssItem> rss;
	private RssItem currentItem;
	private boolean parsingTitle;
	private boolean parsingLink;
	
	public RssHandler(){
		rss=new ArrayList<RssItem>();
		
	}
	public List<RssItem> getItems(){
		return rss;
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		//super.characters(ch, start, length);
		if(parsingTitle){
			if(currentItem!=null){
				currentItem.setTitle(new String(ch,start,length));
			}
		}else if(parsingLink){
			if(currentItem!=null){
				currentItem.setLink(new String(ch,start,length));
				parsingLink=false;
			}
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		//super.endElement(uri, localName, qName);
		if("item".equalsIgnoreCase(qName)){
			rss.add(currentItem);
			currentItem=null;
		}else if("title".equalsIgnoreCase(qName)){
			parsingTitle=false;
		}else if("link".equalsIgnoreCase(qName)){
			parsingLink=false;
		}
		
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//super.startElement(uri, localName, qName, attributes);
		if("item".equalsIgnoreCase(qName)){
			currentItem=new RssItem();
		}else if("title".equalsIgnoreCase(qName)){
			parsingTitle=true;
		}else if("link".equalsIgnoreCase(qName)){
			parsingLink=true;
		}
	}
	
	

}
