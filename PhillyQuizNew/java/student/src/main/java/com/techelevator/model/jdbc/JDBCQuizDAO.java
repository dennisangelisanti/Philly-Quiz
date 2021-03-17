package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Question;
import com.techelevator.model.QuestionStatistic;
import com.techelevator.model.Quiz;
import com.techelevator.model.QuizDAO;
import com.techelevator.model.QuizNotFoundException;




@Component
public class JDBCQuizDAO implements QuizDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCQuizDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	// Get List all questions and answers
	@Override
	public List<Question> getMusicQuestions() {
		
	
		List<Question> questions = new ArrayList<>();
		
		String query = "SELECT question_id, question, choice1, choice2, choice3, choice4, choice5, answer FROM questions "
				+ "WHERE category_id=1";
		SqlRowSet results = jdbcTemplate.queryForRowSet(query); 
		
		 while (results.next()) {
			 
			 try {
			 Question question = new Question();
			 question = mapRowToQuestion(results);
			 questions.add(question); 
			 } catch (QuizNotFoundException ex) {
				 System.out.println("Error!");
			 }
		 }
	
		return questions;
	}
	
	@Override
	public List<Question> getHistoryQuestions() {
		
	
		List<Question> questions = new ArrayList<>();
		
		String query = "SELECT question_id, question, choice1, choice2, choice3, choice4, choice5, answer FROM questions "
				+ "WHERE category_id=2";
		SqlRowSet results = jdbcTemplate.queryForRowSet(query); 
		
		 while (results.next()) {
			 
			 try {
			 Question question = new Question();
			 question = mapRowToQuestion(results);
			 questions.add(question); 
			 } catch (QuizNotFoundException ex) {
				 System.out.println("Error!");
			 }
		 }
	
		return questions;
	}
	
	@Override
	public List<Question> getFoodQuestions() {
		
	
		List<Question> questions = new ArrayList<>();
		
		String query = "SELECT question_id, question, choice1, choice2, choice3, choice4, choice5, answer FROM questions "
				+ "WHERE category_id=3";
		SqlRowSet results = jdbcTemplate.queryForRowSet(query); 
		
		 while (results.next()) {
			 
			 try {
			 Question question = new Question();
			 question = mapRowToQuestion(results);
			 questions.add(question); 
			 } catch (QuizNotFoundException ex) {
				 System.out.println("Error!");
			 }
		 }
	
		return questions;
	}
	
	@Override
	public Quiz makeQuiz(List<String> categories) {
		
		Quiz quiz = new Quiz();
		
		List<Question> finalQuestionsList = new ArrayList<>(); 
		
		for (String category : categories) {
			
			if(category.equals("music")) {
				List<Question> musicQuestions = getMusicQuestions();
				
				for (int i = 0; i < 4; i++) {
					int lastIndex = musicQuestions.size() - 1;
					int randomQuestionIndex = (int) (Math.random() * lastIndex); 
					finalQuestionsList.add(musicQuestions.get(randomQuestionIndex));
					musicQuestions.remove(randomQuestionIndex);

				}
			} else if (category.equals("history")) {
				List<Question> historyQuestions = getHistoryQuestions(); 
				
				for (int i = 0; i < 4; i++) {
					int lastIndex = historyQuestions.size() - 1;
					int randomQuestionIndex = (int) (Math.random() * lastIndex); 
					finalQuestionsList.add(historyQuestions.get(randomQuestionIndex));
					historyQuestions.remove(randomQuestionIndex);

				}
			} else if (category.equals("food")) {
				List<Question> foodQuestions = getFoodQuestions(); 
				
				for (int i = 0; i < 4; i++) {
					int lastIndex = foodQuestions.size() - 1;
					int randomQuestionIndex = (int) (Math.random() * lastIndex); 
					finalQuestionsList.add(foodQuestions.get(randomQuestionIndex));
					foodQuestions.remove(randomQuestionIndex);

				}
			}
		}
		
		
		quiz.setQuizQuestions(finalQuestionsList);
		return quiz;
		
	}
	
	@Override
	public Quiz quizResults(Quiz quiz) {
		
		List<Question> answeredQuestions = quiz.getQuizQuestions();
		QuestionStatistic stats = new QuestionStatistic();
		
		for (Question question : answeredQuestions) {
			
			int questionID = question.getQuestionID();
			boolean isCorrect = question.isCorrect(); 
			
			String sql = "SELECT * FROM question_statistics WHERE question_id = ?";
			
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, questionID); 
			
			if (results.next()) {
				stats = mapRowToQuestionStatistic(results); 
				int timesAnsweredCorrect = stats.getTimesAnsweredCorrect(); 
				int timesAsked = stats.getTimesAsked() + 1;
				
				if (isCorrect) {
					timesAnsweredCorrect++;
				}
				//times_answered_correct
				String sql2 = "UPDATE question_statistics SET times_asked = ?, times_answered_correct = ? WHERE question_id = ?";
				jdbcTemplate.update(sql2, timesAsked, timesAnsweredCorrect, questionID); 
				
			} else {
				
				String sql2 = "INSERT INTO question_statistics (question_id, times_asked, times_answered_correct) "
						+ "VALUES(?, ?, ?)";
				int timesCorrect = 0;
				if (isCorrect) {
					timesCorrect++;
				}
				jdbcTemplate.update(sql2, questionID, 1, timesCorrect);
				
			}
		}
		
		return quiz;
	}
	
	
	
	private QuestionStatistic mapRowToQuestionStatistic(SqlRowSet rs) {
		
		QuestionStatistic stats = new QuestionStatistic();
		
		stats.setQuestionID(rs.getInt("question_id"));
		stats.setTimesAnsweredCorrect(rs.getInt("times_answered_correct"));
		stats.setTimesAsked(rs.getInt("times_asked"));
		
		return stats;
	}
	
	// Map questions from database 
	private Question mapRowToQuestion(SqlRowSet rs) {
		
		Question question = new Question();

		question.setQuestionID(rs.getInt("question_id"));
		question.setQuestion(rs.getString("question"));
		
		question.setChoices(mapRowToChoices(rs));
		question.setCorrectAnswer(rs.getInt("answer"));
		
		return question;
		
	}
	
	// Map answers from database
	private Map<Integer, String> mapRowToChoices(SqlRowSet rs) {
		
		Map<Integer, String> choices = new HashMap<>();
		
		choices.put(1, rs.getString("choice1"));
		choices.put(2, rs.getString("choice2"));
		choices.put(3, rs.getString("choice3"));
		choices.put(4, rs.getString("choice4"));
		choices.put(5, rs.getString("choice5"));
		
		return choices;
		
	}



	
}
