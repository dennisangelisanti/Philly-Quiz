package com.techelevator.model;

import java.util.List;


public interface QuizDAO {
	
	List<Question> getMusicQuestions();
	List<Question> getHistoryQuestions();
	List<Question> getFoodQuestions();
	Quiz makeQuiz(List<String> categories);
	
	Quiz quizResults(Quiz quiz);
	
	

}
