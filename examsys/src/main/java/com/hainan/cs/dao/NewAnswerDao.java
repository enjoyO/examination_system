package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.NewAnswer;

public interface NewAnswerDao {

	NewAnswer getAnswer(String id);

	void insert(NewAnswer answer);

	void delete(String id);

	List<NewAnswer> queryQuestionId(String id);

	List<NewAnswer> queryExamineeId(String id);

	void update(String id, String answer);

	List<NewAnswer> queryPaperIdAndExamineeId(String paperid, String examineeid);

	void updateCreditN(String id, String credit);

	void updateCreditY(String id, String credit);

	void updateCreditD(String id, String credit);

	void updateCreditC(String id, String credit);

	void updateCreditB(String id, String credit);

	void updateCreditA(String id, String credit);

	List<NewAnswer> queryPaperIdAndExamineeIdAndQuestionid(String paperid, String examineeid, String questionid);

}
