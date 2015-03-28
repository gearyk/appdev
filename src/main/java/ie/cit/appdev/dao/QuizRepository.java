package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Question;

import java.util.List;

public interface QuizRepository {

	List<Question> getQuestions();
	List<Question> getAnswer(String id);
}
