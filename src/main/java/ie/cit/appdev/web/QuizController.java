package ie.cit.appdev.web;







import ie.cit.appdev.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	
	@Autowired
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
		
	}


//	@RequestMapping("quiz")
//	public ModelAndView getQuestions(){
//		List<Question> sessionQuestions=thisSession.getQuizQuestions();
//		HashMap<String, Object> model=new HashMap<String, Object>();
//		model.put("questions", sessionQuestions);
//		return new ModelAndView("questions",model);
//	}
	
	@RequestMapping("quiz")
	public String getQuestions(Model model){
		model.addAttribute("questions", quizService.getQuizQuestions());
		return "questions";
	}
	
	@RequestMapping("setquiz")
	public String setQuestions(Model model){
		model.addAttribute("questions", quizService.setQuiz());
		return "questions";
		//return "redirect:/accounts/quiz";
	}
	

//	@RequestMapping("setquiz")
//	public ModelAndView setQuestions(){
//		List<Question> quizQuestions=quizRepo.getRandomQuestions();
//		thisSession.setQuiz(quizQuestions);
//		List<Question> sessionQuestions=thisSession.getQuizQuestions();
//		HashMap<String, Object> model=new HashMap<String, Object>();
//		model.put("questions", sessionQuestions);
//		return new ModelAndView("questions",model);
//		//return "redirect:/accounts/quiz";
//	}

	@RequestMapping(value="/quiz/{myId}/{attemptAnswer}/{answer}", method=RequestMethod.GET)
	public String answer(@PathVariable String myId, @PathVariable String attemptAnswer,@PathVariable String answer){
		quizService.updateAnswerResult(attemptAnswer,answer, myId);
		//thisSession.updateAnswerResult(attemptAnswer,answer, myId);
		return "redirect:/accounts/quiz";
	}

//	@RequestMapping("score")
//	public ModelAndView getScore(){
//		String result= thisSession.getScore();
//		HashMap<String, String> model=new HashMap<String, String>();
//		model.put("score", result);
//		return new ModelAndView("score",model);
//	}
	@RequestMapping("score")
	public String getScore(Model model){
		//String result= thisSession.getScore();
		//HashMap<String, String> model=new HashMap<String, String>();
		//model.put("score", result);
		model.addAttribute("score", quizService.getScore());
		return "score";
	}

}
