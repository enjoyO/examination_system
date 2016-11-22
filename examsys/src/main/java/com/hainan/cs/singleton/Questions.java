package com.hainan.cs.singleton;

import java.util.ArrayList;
import java.util.HashMap;

public class Questions {
	private ArrayList<String> single=new ArrayList<String>();
	private ArrayList<String> multiple=new ArrayList<String>();
	private ArrayList<String> judge=new ArrayList<String>();
	private ArrayList<String> essay=new ArrayList<String>();
	private ArrayList<String> all=new ArrayList<String>();
	private HashMap<String,String> allhash=new HashMap<String,String>();
	
	public HashMap<String, String> getAllhash() {
		return allhash;
	}
	public void setAllhash(HashMap<String, String> allhash) {
		this.allhash = allhash;
	}
	public ArrayList<String> getAll() {
		return all;
	}
	public void setAll(ArrayList<String> all) {
		this.all = all;
	}
	public ArrayList<String> getSingle() {
		return single;
	}
	public void setSingle(ArrayList<String> single) {
		this.single = single;
	}
	public ArrayList<String> getMultiple() {
		return multiple;
	}
	public void setMultiple(ArrayList<String> multiple) {
		this.multiple = multiple;
	}
	public ArrayList<String> getJudge() {
		return judge;
	}
	public void setJudge(ArrayList<String> judge) {
		this.judge = judge;
	}
	public ArrayList<String> getEssay() {
		return essay;
	}
	public void setEssay(ArrayList<String> essay) {
		this.essay = essay;
	}
	private static Questions instance;
	private Questions(){}
	public static Questions getInstance(){
		if(instance==null){
			instance=new Questions();
		}
		return instance;
	}

}
