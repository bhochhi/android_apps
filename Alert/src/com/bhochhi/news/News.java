package com.bhochhi.news;

import java.util.Date;

public class News {

	private String title;
	public Boolean isRead;
	private String description;
	private String source;
	private Date datetime;
	
	
	public News(){
		
	}
	public News(String title,String description,Boolean isRead){
		this.title = title;
		this.description = description;
		this.isRead = isRead;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	
	
}
