package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Question;

import java.util.List;


public interface SessionRepository {
	
	void setQuiz(List<Question> questionsInSession);
	void updateWithSessionQuestion(Question quizSessionQuestion);
	List<Question> getQuizQuestions();
	void updateAnswerResult(String attempt, String correctAnswer, String id);
	String getScore();

}
