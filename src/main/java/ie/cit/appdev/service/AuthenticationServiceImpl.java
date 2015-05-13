package ie.cit.appdev.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

	private Authentication auth;
	
	public String getAuthentication() {
		
		auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
                     return "null";
            } else {
                     return  (String) auth.getName();
            }
	}


}
