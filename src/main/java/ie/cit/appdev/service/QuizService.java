package ie.cit.appdev.service;

import ie.cit.appdev.domain.Question;

import java.util.List;

public interface QuizService {
	
	List<Question> getQuizQuestions();
	List<Question> setQuiz();
	void updateAnswerResult(String attemptAnswer, String answer, String myId);
	String getScore();
	

}
