package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.NewTest;
import com.hainan.cs.bean.TestBean;

public interface NewTestDao {

	NewTest getNewTest(String id);

	List<NewTest> queryExamineeId(String examineeid);

	List<NewTest> queryPaperId(String paperid);

	void insert(NewTest test);

	void delete(String id);

	List<NewTest> queryPaperIdAndExamineeId(String paperid, String Examineeid);

	void updateScore(String id, String score);

	void updateSingleScore(String id, String score);

	void updateMultipleScore(String id, String score);

	void updateJudgeScore(String id, String score);

	void updateEssayScore(String id, String score);

	void updateTeacherScore(String id, String score);

}
