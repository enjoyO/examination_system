package com.hainan.cs.util;

public interface CountScore {

	float judgeJudge(String credity, String creditn, String rightanswer);

	float judgeMultiple(String credita, String creditb, String creditc, String creditd, String rightanswer,
			String youranswer);

	float judgeSingle(String credita, String creditb, String creditc, String creditd, String rightanswer);

}
