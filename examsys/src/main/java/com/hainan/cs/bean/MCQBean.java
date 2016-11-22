package com.hainan.cs.bean;
/**
 * 多选题java bean
 * @author hl
 *
 */
public class MCQBean {
	private String id;
	private String paperid;
	private int number;//题目编号
	private String description;//题目描述
	private String adescription;//A选项描述
	private String bdescription;
	private String cdescription;
	private String ddescription;
	private String ansewer;//"A_B_C"表示答案是A,B,C
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdescription() {
		return adescription;
	}
	public void setAdescription(String adescription) {
		this.adescription = adescription;
	}
	public String getBdescription() {
		return bdescription;
	}
	public void setBdescription(String bdescription) {
		this.bdescription = bdescription;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	public String getDdescription() {
		return ddescription;
	}
	public void setDdescription(String ddescription) {
		this.ddescription = ddescription;
	}
	public String getAnsewer() {
		return ansewer;
	}
	public void setAnsewer(String ansewer) {
		this.ansewer = ansewer;
	}
	
}
