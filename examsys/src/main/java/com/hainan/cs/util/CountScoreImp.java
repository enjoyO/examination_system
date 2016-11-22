package com.hainan.cs.util;

public class CountScoreImp implements CountScore {
	@Override
	public float judgeSingle(String credita,String creditb,String creditc,String creditd,
			String rightanswer){
		float score=(float) 0.00;
		int confa=Integer.parseInt(credita);
		int confb=Integer.parseInt(creditb);
		int confc=Integer.parseInt(creditc);
		int confd=Integer.parseInt(creditd);
		int total=confa+confb+confc+confd;
		int ascore=0;
		int bscore=0;
		int cscore=0;
		int dscore=0;
		if(rightanswer.equals("A")){
			ascore=5;
		}
		if(rightanswer.equals("B")){
			bscore=5;
		}
		if(rightanswer.equals("C")){
			cscore=5;
		}
		if(rightanswer.equals("D")){
			dscore=5;
		}
		score=(float)confa/total*ascore+(float)confb/total*bscore+
				(float)confc/total*cscore+(float)confd/total*dscore;
		return score;
	}
	@Override
	public float judgeMultiple(String credita,String creditb,String creditc,String creditd,
			String rightanswer,String youranswer){
		float score=0;
		int confa=Integer.parseInt(credita);
		int confb=Integer.parseInt(creditb);
		int confc=Integer.parseInt(creditc);
		int confd=Integer.parseInt(creditd);
		int total=confa+confb+confc+confd;
		//获取正确答案的数组
		int answer[]={0,0,0,0};
		for(int i=0;i<rightanswer.length();i++){
			if(rightanswer.charAt(i)=='A'){
				answer[0]=1;
			}
			if(rightanswer.charAt(i)=='B'){
				answer[1]=1;
			}
			if(rightanswer.charAt(i)=='C'){
				answer[2]=1;
			}
			if(rightanswer.charAt(i)=='D'){
				answer[3]=1;
			}
		}
		//获取给出答案的数组
		int yanswer[]={0,0,0,0};
		for(int i=0;i<youranswer.length();i++){
			if(youranswer.charAt(i)=='A'){
				yanswer[0]=1;
			}
			if(youranswer.charAt(i)=='B'){
				yanswer[1]=1;
			}
			if(youranswer.charAt(i)=='C'){
				yanswer[2]=1;
			}
			if(youranswer.charAt(i)=='D'){
				yanswer[3]=1;
			}
		}
		//每个正确选项的分值
		float average=(float)5/4;
		//答错扣分
		for(int i=0;i<answer.length;i++){
			if(answer[i]==0&&yanswer[i]==1){
				if(i==0){
					score= score-(float)confa/100*average;
				}
				if(i==1){
					score=score-(float)confb/100*average;
				}
				if(i==2){
					score=score-(float)confc/100*average;
				}
				if(i==3){
					score=score-(float)confd/100*average;
				}
			}else if(answer[i]==1&&yanswer[i]==1){
				if(i==0){
					score= score+(float)confa/100*average;
				}
				if(i==1){
					score=score+(float)confb/100*average;
				}
				if(i==2){
					score=score+(float)confc/100*average;
				}
				if(i==3){
					score=score+(float)confd/100*average;
				}
			}else if(answer[i]==1&&yanswer[i]==0){
				if(i==0){
					score= score-(float)confa/100*average;
				}
				if(i==1){
					score=score-(float)confb/100*average;
				}
				if(i==2){
					score=score-(float)confc/100*average;
				}
				if(i==3){
					score=score-(float)confd/100*average;
				}
			}else if(answer[i]==0&&yanswer[i]==0){
				if(i==0){
					score= score+(float)confa/100*average;
				}
				if(i==1){
					score=score+(float)confb/100*average;
				}
				if(i==2){
					score=score+(float)confc/100*average;
				}
				if(i==3){
					score=score+(float)confd/100*average;
				}
			}
		}
		if(score<0){
			score=0;
		}
		return score;
	}
	@Override
	public float judgeJudge(String credity,String creditn,String rightanswer){
		float score=0;
		int confy=Integer.parseInt(credity);
		int confn=Integer.parseInt(creditn);
		int total=confy+confn;
		int yscore=0;
		int nscore=0;
		if(rightanswer.equals("right")){
			yscore=5;
		}
		if(rightanswer.equals("wrong")){
			nscore=5;
		}
		score=score+(float)confy/total*yscore+(float)confn/total*nscore;
		return score;
	}
}
