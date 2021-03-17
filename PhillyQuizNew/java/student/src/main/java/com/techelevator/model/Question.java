package com.techelevator.model;

import java.util.HashMap;
import java.util.Map;

public class Question {
	
	// Private members
	private int questionID;
	private String question;
	private Map<Integer, String> choices = new HashMap<>(); 
	private Integer correctAnswer; 
	private boolean isCorrect;

	
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}	

	public Map<Integer, String> getChoices() {

		return choices;
	}

	public void setChoices(Map<Integer, String> choices) {
		this.choices = choices;
	}

	public Integer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}
