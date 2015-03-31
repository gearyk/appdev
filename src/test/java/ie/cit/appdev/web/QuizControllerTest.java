package ie.cit.appdev.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;


import static org.mockito.Mockito.verify;

import java.util.List;

import ie.cit.appdev.dao.QuizRepository;
import ie.cit.appdev.dao.SessionRepository;
import ie.cit.appdev.domain.Question;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;

public class QuizControllerTest {

	private QuizRepository quizRepo;
	private SessionRepository sessionRepo;
	private QuizController tested;
	private ModelAndView mav;
	private ExtendedModelMap model;
	//private ExtendedModelMap model;

	@Before
	public void setup(){
		quizRepo=mock(QuizRepository.class);
		sessionRepo=mock(SessionRepository.class);
		tested=new QuizController(quizRepo,sessionRepo);
	}
	
	//model = new ExtendedModelMap();
	
	
	
	
	
	@Test
	public void testGetQuestions() {
		model = new ExtendedModelMap();
		List<Question> sessionQuestions=sessionRepo.getQuizQuestions();
		mav=tested.getQuestions();
		model.put("questions", sessionQuestions);
		assertThat(mav,notNullValue());
		assertThat("questions", CoreMatchers.equalTo(mav.getViewName()));
		verify(sessionRepo).getQuizQuestions();
	}
	
	@Test
	public void testSetQuestions(){
		mav=tested.setQuestions();
		assertThat("Model is not null",mav,notNullValue());
		verify(sessionRepo).getQuizQuestions();
		verify(quizRepo).getRandomQuestions();
	}
	
	@Test
	public void testAnswer() {
	tested.answer("3", "attempt", "answer");
	verify(sessionRepo).updateAnswerResult("attempt", "answer", "3");
	}
	
	@Test
	public void testGetScore() {
		mav=tested.getScore();
		assertThat(mav,notNullValue());
		verify(sessionRepo).getScore();
	}

}
