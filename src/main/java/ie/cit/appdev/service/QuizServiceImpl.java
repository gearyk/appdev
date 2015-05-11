package ie.cit.appdev.service;

import ie.cit.appdev.dao.QuizRepository;
import ie.cit.appdev.dao.SessionRepository;
import ie.cit.appdev.domain.Leaderboard;
import ie.cit.appdev.domain.Question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class QuizServiceImpl implements QuizService{
	
	QuizRepository quizrepo;
	SessionRepository sessionrepo;

	@Autowired
	public QuizServiceImpl(QuizRepository quizrepo,SessionRepository sessionrepo) {
		super();
		this.quizrepo = quizrepo;
		this.sessionrepo=sessionrepo;
	}

	public List<Question> getQuizQuestions() {
		List<Question> sessionQuestions=sessionrepo.getQuizQuestions();
		return sessionQuestions;
	}

	public List<Question> setQuiz() {
		List<Question> randomQuestions=quizrepo.getRandomQuestions();
		sessionrepo.setQuiz(randomQuestions);
		List<Question> sessionQuestions=sessionrepo.getQuizQuestions();
		return sessionQuestions;
	}

	public void updateAnswerResult(String attemptAnswer, String answer,
			String myId) {
		sessionrepo.updateAnswerResult(attemptAnswer, answer, myId);
		
	}

	public String getScore() {
		return sessionrepo.getScore();
	
	}

	public List<Leaderboard> getHighscores() {
		List<Leaderboard> leaderboard=quizrepo.getHighscores();
		System.out.print(leaderboard.get(0).toString());
		return leaderboard;
	}

}
