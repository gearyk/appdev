package ie.cit.appdev.service;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface AuthenticationService {
	
	String getAuthentication();
	

}
