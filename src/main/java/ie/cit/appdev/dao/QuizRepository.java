package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Leaderboard;
import ie.cit.appdev.domain.Question;

import java.util.List;

public interface QuizRepository {

	List<Question> getRandomQuestions();
	List<Question> getAnswer(String id);
	List<Leaderboard> getHighscores();
	
}
