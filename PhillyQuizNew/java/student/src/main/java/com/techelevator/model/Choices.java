package com.techelevator.model;

import java.util.HashMap;
import java.util.Map;

public class Choices {
	
	// private members 
	private Map<Integer, String> choices = new HashMap<>(); 
	
	private Integer correctAnswer; 
	
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
	

}
