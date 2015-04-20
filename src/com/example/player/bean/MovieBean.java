package com.example.player.bean;

import java.io.Serializable;

public class MovieBean implements Serializable{
/**
 * vid string ��Ƶid 
 * title string ��Ƶ���� 
	content string ��Ƶ���� 
	tag string ��Ƶ��ǩ 
	bimg string ��Ƶ����ͼ��ַ, ��ͼ 
	user_id string �û�id 
	comments string ��Ƶ������ 
	public_time string ��Ƶ����ʱ�� 
	totaltime string ��Ƶ��ʱ�� 
 */
	
 private String vid;
 public String getVid() {
	return vid;
}
public void setVid(String vid) {
	this.vid = vid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getTag() {
	return tag;
}
public void setTag(String tag) {
	this.tag = tag;
}
public String getBimg() {
	return bimg;
}
public void setBimg(String bimg) {
	this.bimg = bimg;
}
public String getMimg() {
	return mimg;
}
public void setMimg(String mimg) {
	this.mimg = mimg;
}
public String getSimg() {
	return simg;
}
public void setSimg(String simg) {
	this.simg = simg;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public String getAddTime() {
	return addTime;
}
public void setAddTime(String addTime) {
	this.addTime = addTime;
}
public String getAllTime() {
	return allTime;
}
public void setAllTime(String allTime) {
	this.allTime = allTime;
}
private String title;
 private String content;
 private String tag; 
 private String bimg;
 private String mimg;
 private String simg;
 private String userId;
 private String comments;
 private String addTime;
 private String allTime;
public MovieBean(String vid, String title) {
	super();
	this.vid = vid;
	this.title = title;
}

 
 
 
}
