package com.hainan.cs.singleton;

public class Examine {
	private String examineeid="";
	private String paperid="";
	
	public String getExamineeid() {
		return examineeid;
	}
	public void setExamineeid(String examineeid) {
		this.examineeid = examineeid;
	}
	public String getPaperid() {
		return paperid;
	}
	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}
	private Examine(){}
	private static Examine instance;
	public static Examine getInstance(){
		if(instance==null){
			instance=new Examine();
		}
		return instance;
	}
}
