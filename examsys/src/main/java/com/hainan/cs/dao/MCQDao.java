package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.ChoiceQuestionBean;
import com.hainan.cs.bean.MCQBean;

public interface MCQDao {

	MCQBean getMCQB(String id);

	void insert(MCQBean mcqb);

	void delete(String id);

	List<MCQBean> queryPaper(String paperid);

}
