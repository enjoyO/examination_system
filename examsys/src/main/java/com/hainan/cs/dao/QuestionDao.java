package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.QuestionBean;

public interface QuestionDao {

	QuestionBean getQuestion(String id);

	void insert(QuestionBean question);

	void deleteQuestion(String id);

	List<QuestionBean> queryPaperId(String id);

	void delete(String questionid);
	
}
