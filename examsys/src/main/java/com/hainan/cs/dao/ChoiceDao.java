package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.ChoiceQuestionBean;

public interface ChoiceDao {

	void delete(String id);

	void insert(ChoiceQuestionBean cqb);

	ChoiceQuestionBean getCQB(String id);

	List<ChoiceQuestionBean> queryPaper(String paperid);

}
