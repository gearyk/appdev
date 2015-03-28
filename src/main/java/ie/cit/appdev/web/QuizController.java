package ie.cit.appdev.web;

import java.util.HashMap;
import java.util.List;

import ie.cit.appdev.dao.QuizRepository;
import ie.cit.appdev.domain.Account;
import ie.cit.appdev.domain.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {

	@Autowired
	private QuizRepository quizRepo;
	
	//returns the model and logical name of the view 
		@RequestMapping("quiz")
		public ModelAndView getQuestions(){
			List<Question> quizQuestions=quizRepo.getQuestions();
			HashMap<String, Object> model=new HashMap<String, Object>();
			model.put("questions", quizQuestions);
			return new ModelAndView("questions",model);
			
		}
		
		
		@RequestMapping(value="/quiz/{myid}", method=RequestMethod.GET)
		public ModelAndView answer(@PathVariable String myid){
			System.out.println("Kevin...........");
			List<Question> quizQuestion=quizRepo.getAnswer(myid);
			HashMap<String, Object> model=new HashMap<String, Object>();
			model.put("answer", quizQuestion);
			return new ModelAndView("answer",model);
			
		}

	
	
}
