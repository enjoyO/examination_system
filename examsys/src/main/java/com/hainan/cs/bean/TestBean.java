package com.hainan.cs.bean;

public class TestBean {
	private String id;
	private String paperid;
	private String examineeid;
	private String score;
	private String teacherscore;
	private String single;//单选得分
	private String multiple;
	private String judge;
	private String essay;
	
	public String getSingle() {
		return single;
	}
	public void setSingle(String single) {
		this.single = single;
	}
	public String getMultiple() {
		return multiple;
	}
	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	public String getEssay() {
		return essay;
	}
	public void setEssay(String essay) {
		this.essay = essay;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPaperid() {
		return paperid;
	}
	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}
	public String getExamineeid() {
		return examineeid;
	}
	public void setExamineeid(String examineeid) {
		this.examineeid = examineeid;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTeacherscore() {
		return teacherscore;
	}
	public void setTeacherscore(String teacherscore) {
		this.teacherscore = teacherscore;
	}
	
}
