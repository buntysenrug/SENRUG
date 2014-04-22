package com.packagemain.senrug;

public class RssItem {
	private String title;
	private String link;
	
	public RssItem(){
		this.setTitle("");
		this.setLink("");
	}
	
	public RssItem(String title,String description, String link){
		this.setTitle(title);
		this.setLink(link);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	

}
