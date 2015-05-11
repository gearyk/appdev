package ie.cit.appdev;

import ie.cit.appdev.domain.Account;
import ie.cit.appdev.service.AccountService;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
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
	AccountService tested;
	Account newAcc;
	Account fromDB;
	
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
		tested.deleteAccount(accountID,"intergrationUN");
		Assert.assertTrue("Not deleted - List of all accounts was not decremented"
				, numberOfAccounts==(tested.getAllAccounts().size()+1)  );
	}
	
	
}
