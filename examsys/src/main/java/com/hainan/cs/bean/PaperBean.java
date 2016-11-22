package com.hainan.cs.bean;

import java.util.Date;

public class PaperBean {
	private String id;
	private String creatorid;
	private String type;
	private String time;
	private Date createtime;
	private String paperinfo;
	private String papername;
	
	
	public String getPapername() {
		return papername;
	}
	public void setPapername(String papername) {
		this.papername = papername;
	}
	public String getPaperinfo() {
		return paperinfo;
	}
	public void setPaperinfo(String paperinfo) {
		this.paperinfo = paperinfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}
