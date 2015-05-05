package ie.cit.appdev.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;


import static org.mockito.Mockito.verify;

import ie.cit.appdev.service.QuizService;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;


public class QuizControllerTest {


	private QuizController tested;

	private ExtendedModelMap model;
	private QuizService quizService;


	@Before
	public void setup(){
		quizService=mock(QuizService.class);
		//sessionRepo=mock(SessionRepository.class);
		tested=new QuizController(quizService);
	}

		
	@Test
	public void testGetQuestions() {
		model = new ExtendedModelMap();
		//mav=tested.getQuestions();
		String all=tested.getQuestions(model);
		//assertThat(mav.getModel(),notNullValue());
		assertThat(all,notNullValue());
		assertThat("questions", CoreMatchers.equalTo(all));
		verify(quizService).getQuizQuestions();
	}
	
	@Test
	public void testSetQuestions(){
		model = new ExtendedModelMap();
		String questions=tested.setQuestions(model);
		assertThat(questions,notNullValue());
		assertThat("questions", CoreMatchers.equalTo(questions));
		///verify(quizService).getQuizQuestions();
		//((QuizRepository) verify(quizService)).getRandomQuestions();
	}
	
	@Test
	public void testAnswer() {
	tested.answer("3", "attempt", "answer");
	verify(quizService).updateAnswerResult("attempt", "answer", "3");
	}
	
	@Test
	public void testGetScore() {
		model = new ExtendedModelMap();
		String score=tested.getScore(model);
		assertThat("score", CoreMatchers.equalTo(score));
		assertThat(score,notNullValue());
		//verify(quizService).getScore();
	}

}
