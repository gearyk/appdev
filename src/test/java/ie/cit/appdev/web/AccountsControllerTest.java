package ie.cit.appdev.web;

import ie.cit.appdev.dao.AccountRespository;
import ie.cit.appdev.service.AccountService;
import ie.cit.appdev.service.AuthenticationService;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.ui.ExtendedModelMap;



import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

public class AccountsControllerTest {
	
	@SuppressWarnings("unused")
	private AccountRespository accRepo;
	private AccountsController tested;
	private ExtendedModelMap model;
	private AccountService accountService;
	private AuthenticationService auth;

	@Before
	public void setup(){
		accountService=mock(AccountService.class);
		accRepo=mock(AccountRespository.class);
		auth=mock(AuthenticationService.class);
		tested=new AccountsController(accountService,auth);
		
	}

	@Test
	public void testGetAllAccounts() {
		model = new ExtendedModelMap();
		String all=tested.getAllAccounts(model);
		assertThat("allaccounts", CoreMatchers.equalTo(all));
		assertThat(all,notNullValue());
		verify(accountService).getAllAccounts();
		
	}
	
	
	@Test
	public void testCreateAccount(){
		tested.createAccount("myFirstName", "myLastName","myUsername","myPassword");
		verify(accountService).createNewAccount(
		
		argThat(new ArgumentMatcher<String>() {

					@Override
					public boolean matches(Object argument) {
						
						return ((String) argument).equals("myFirstName");
					}
					
					@Override
					public void describeTo(Description description) {
						description.appendText("expected: an Account with myFirstName");
					}
				}), 
				
				argThat(new ArgumentMatcher<String>() {

					@Override
					public boolean matches(Object argument) {
						
						return ((String) argument).equals("myLastName");
					}
					
					@Override
					public void describeTo(Description description) {
						description.appendText("expected: an Account with myLastName");
					}
				}),
				argThat(new ArgumentMatcher<String>() {

					@Override
					public boolean matches(Object argument) {
						
						return ((String) argument).equals("myUsername");
					}
					
					@Override
					public void describeTo(Description description) {
						description.appendText("expected: an Account with myUsername");
					}
				}),
				argThat(new ArgumentMatcher<String>() {

					@Override
					public boolean matches(Object argument) {
						
						return ((String) argument).equals("myPassword");
					}
					
					@Override
					public void describeTo(Description description) {
						description.appendText("expected: an Account with myPassword");
					}
				}));
		
	}
	
	
	@Test
	public void testDeleteAccount(){
		tested.deleteAccount("accountID");
		verify(accountService).deleteAccount("accountID",accountService.getAccountUsername("accountID"),auth.getAuthentication());
		
	}

	

}
