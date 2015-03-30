package ie.cit.appdev.web;

import ie.cit.appdev.dao.AccountRespository;
import ie.cit.appdev.domain.Account;

import java.util.List;

import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito.*;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

public class AccountsControllerTest {
	
	private AccountRespository accRepo;
	private AccountsController tested;
	private ExtendedModelMap model;

	@Before
	public void setup(){
		accRepo=mock(AccountRespository.class);
		tested=new AccountsController(accRepo);
	}

	@Test
	public void testGetAllAccounts() {
		ModelAndView mav=tested.getAllAccounts();
		assertThat(mav,notNullValue());
		verify(accRepo).getAllAccounts();
		
	}
	
	@Test
	public void testCreateAccount(){
		tested.createAccount("myFirstName", "myLastName");
		verify(accRepo).addAccount(argThat(new ArgumentMatcher<Account>() {

					@Override
					public boolean matches(Object argument) {
						
						return (((Account) argument).getFirstname().equals("myFirstName") && ((Account) argument).getLastname().equals("myLastName"));
					}
					

					@Override
					public void describeTo(Description description) {
						description.appendText("expected: an Account with myFirstName and myLastName");
					}
				}));
		
	}
	
	@Test
	public void testDeleteAccount(){
		tested.deleteAccount("accountID");
		verify(accRepo).deleteAccount("accountID");
		
	}

	

}
