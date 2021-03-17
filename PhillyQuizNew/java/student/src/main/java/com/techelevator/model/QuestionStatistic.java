package com.techelevator.model;

public class QuestionStatistic {
	
	private int questionID;
	private int timesAsked;
	private int timesAnsweredCorrect;
	
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public int getTimesAsked() {
		return timesAsked;
	}
	public void setTimesAsked(int timesAsked) {
		this.timesAsked = timesAsked;
	}
	public int getTimesAnsweredCorrect() {
		return timesAnsweredCorrect;
	}
	public void setTimesAnsweredCorrect(int timesAnsweredCorrect) {
		this.timesAnsweredCorrect = timesAnsweredCorrect;
	}

}
