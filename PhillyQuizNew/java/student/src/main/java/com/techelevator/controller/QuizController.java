package com.techelevator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Question;
import com.techelevator.model.Quiz;
import com.techelevator.model.QuizDAO;

@RestController
//@RequestMapping("quiz/music")
public class QuizController {
	
	private QuizDAO quizDao;
	
	
	public QuizController(QuizDAO quizDao) {
		
		this.quizDao = quizDao;
	}
	
	
	 @RequestMapping(path = "quiz/music", method = RequestMethod.GET)
	 public List<Question> getAllMusicQuestions() {
		 return quizDao.getMusicQuestions(); 
	 }
	 
	 @RequestMapping(path = "quiz/history", method = RequestMethod.GET)
	 public List<Question> getAllHistoryQuestions() {
		 return quizDao.getHistoryQuestions(); 
	 }
	 
	 @RequestMapping(path = "quiz/food", method = RequestMethod.GET)
	 public List<Question> getAllFoodQuestions() {
		 return quizDao.getFoodQuestions(); 
	 }
	 
	 @RequestMapping(path = "quiz/makeQuiz", method = RequestMethod.GET)
	 public Quiz makeQuiz(@RequestBody List<String> categories) {
		 return quizDao.makeQuiz(categories);
	 }
	 
	 @RequestMapping(path = "quiz/quizResults", method = RequestMethod.POST)
	 public void quizResults(@RequestBody Quiz newQuiz) {
		 quizDao.quizResults(newQuiz); 
	 }
	

}
