package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.JudgeQuestionBean;

public interface JudgeDao {

	JudgeQuestionBean getJQB(String id);

	void insert(JudgeQuestionBean jqb);

	void delete(String id);

	List<JudgeQuestionBean> queryPaper(String id);

}
