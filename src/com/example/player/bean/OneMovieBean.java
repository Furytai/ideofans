package com.example.player.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class OneMovieBean implements Serializable{
	/**
	 * vid	string	��Ƶid
title	string	��Ƶ����
content	string	��Ƶ����
tag	string	��Ƶ��ǩ
bimg	string	��Ƶ����ͼ��ַ, ��ͼ
user_id	string	�û�id
comments	string	��Ƶ������
public_time	string	��Ƶ����ʱ��
totaltime	string	��Ƶ��ʱ��
	 */
	
/**
 * vid	string	��Ƶid
bimg	string	��Ƶ����ͼ,��ͼ 520*312
textid	string	vid��Ӧbase64����
key	string	��Ƶkey
Subject	string	��Ƶ����
img	string	��Ƶ����ͼ,Сͼ 130*78
duration	string	����ʱ��
hd	string  	�������
cid2	string  	��Ƶ���ͱ��
rfiles	 jsonarray	��Ƶ���ŵ�ַ����
url	 string	��Ƶ���ŵ�ַ
 */
private String id;
private String title;
private String content;
private String tag;
private String comments;
private String public_time;
private String totaltime;

private String img;
private String hd;
private String type;
private ArrayList<String> urls;
private String url;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public String getPublic_time() {
	return public_time;
}
public void setPublic_time(String public_time) {
	this.public_time = public_time;
}
public String getTotaltime() {
	return totaltime;
}
public void setTotaltime(String totaltime) {
	this.totaltime = totaltime;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getHd() {
	return hd;
}
public void setHd(String hd) {
	this.hd = hd;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public ArrayList<String> getUrls() {
	return urls;
}
public void setUrls(ArrayList<String> urls) {
	this.urls = urls;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

}
