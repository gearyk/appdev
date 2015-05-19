package ie.cit.appdev;

import ie.cit.appdev.domain.Account;
import ie.cit.appdev.service.AccountService;
import ie.cit.appdev.service.AuthenticationService;
import static org.mockito.Mockito.*;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class AccountServiceIntegrationTest {

	@Autowired
	private AccountService tested;
	private Account newAcc;
	private Account fromDB;
	private AuthenticationService authService;
	
	
	@Before
	public void setup(){
		authService=mock(AuthenticationService.class);
		
	}
	
	
	@Test @Transactional
	public void testCreateNewAccount(){
		newAcc=tested.createNewAccount("integrationFN", "integrationLN","intergrationUN","integrationPWD");
		fromDB=tested.getByID(newAcc.getId());
		String uname=tested.getAccountUsername(newAcc.getId());
		String pwd=tested.getAccountPassword(newAcc.getId());
		Assert.assertThat(newAcc.getFirstname(), CoreMatchers.equalTo(fromDB.getFirstname()));
		Assert.assertThat(newAcc.getLastname(), CoreMatchers.equalTo(fromDB.getLastname()));
		Assert.assertThat(newAcc.getUsername(), CoreMatchers.equalTo(uname));
		Assert.assertThat(newAcc.getPassword(), CoreMatchers.equalTo(pwd));
	}
	
	@Test @Transactional
	public void testDeleteAccount(){
		
		newAcc=tested.createNewAccount("integrationFN", "integrationLN","intergrationUN","integrationPWD");
		String accountID=newAcc.getId();
		fromDB=tested.getByID(accountID);
		String uname=tested.getAccountUsername(newAcc.getId());
		String pwd=tested.getAccountPassword(newAcc.getId());
		Assert.assertThat(newAcc.getFirstname(), CoreMatchers.equalTo(fromDB.getFirstname()));
		Assert.assertThat(newAcc.getLastname(), CoreMatchers.equalTo(fromDB.getLastname()));
		Assert.assertThat(newAcc.getUsername(), CoreMatchers.equalTo(uname));
		Assert.assertThat(newAcc.getPassword(), CoreMatchers.equalTo(pwd));
		int numberOfAccounts=tested.getAllAccounts().size();
		System.out.println("Accounts before delete: "+numberOfAccounts);
		//Mock out that the username for this session is annonymous - ie no user logged in
		when(authService.getAuthentication()).thenReturn("anonymousUser");
		tested.deleteAccount(accountID,"intergrationUN",authService.getAuthentication());
		System.out.println("Accounts after delete: "+tested.getAllAccounts().size());
		Assert.assertFalse("Not deleted - List of all accounts was not decremented"
				, numberOfAccounts==(tested.getAllAccounts().size()+1)  );
	}
	
	
}
