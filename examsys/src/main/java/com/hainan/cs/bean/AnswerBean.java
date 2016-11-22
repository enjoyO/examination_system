package com.hainan.cs.bean;

public class AnswerBean {
	private String id;
	private String questionid;
	private String examineeid;
	private String answer;
	private String paperid;
	
	public String getPaperid() {
		return paperid;
	}
	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getExamineeid() {
		return examineeid;
	}
	public void setExamineeid(String examineeid) {
		this.examineeid = examineeid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
