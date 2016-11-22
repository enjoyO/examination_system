package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.AnswerBean;

public interface AnswerDao {

	AnswerBean getAnswer(String id);

	void insert(AnswerBean answer);

	void delete(String id);

	List<AnswerBean> queryQuestionId(String id);

	List<AnswerBean> queryExamineeId(String id);

	void update(String id, String answer);

	List<AnswerBean> queryPaperIdAndExamineeId(String paperid, String examineeid);

	List<AnswerBean> queryPaperIdAndExamineeIdAndQuestionid(String paperid, String examineeid, String questionid);

}
