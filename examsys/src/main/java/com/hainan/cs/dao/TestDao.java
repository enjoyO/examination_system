package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.TestBean;

public interface TestDao {

	TestBean getTest(String id);

	void insert(TestBean tb);

	void delete(String id);

	List<TestBean> queryPaperId(String id);

	List<TestBean> queryExamineeId(String id);

	List<TestBean> queryPaperIdAndExamineeId(String paperid, String Examineeid);

	void updateScore(String id, String score);

	void updateMultipleScore(String id, String score);

	void updateJudgeScore(String id, String score);

	void updateEssayScore(String id, String score);

	void updateSingleScore(String id, String score);

	void updateTeacherScore(String id, String score);

}
