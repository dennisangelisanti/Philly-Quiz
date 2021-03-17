package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
	
	// Private members
	
	private List<Question> quizQuestions = new ArrayList<>();
	double score;
	
	public List<Question> getQuizQuestions() {
		return quizQuestions;
	}
	
	public void setQuizQuestions(List<Question> quizQuestions) {
		this.quizQuestions = quizQuestions;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}

}
