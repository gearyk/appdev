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
		newAcc=tested.createNewAccount("integrationFN", "integrationLN");
		fromDB=tested.getByID(newAcc.getId());
		Assert.assertThat(newAcc.getFirstname(), CoreMatchers.equalTo(fromDB.getFirstname()));
		Assert.assertThat(newAcc.getLastname(), CoreMatchers.equalTo(fromDB.getLastname()));
	}
	
	@Test @Transactional
	public void testDeleteAccount(){
		newAcc=tested.createNewAccount("integrationFN", "integrationLN");
		String accountID=newAcc.getId();
		fromDB=tested.getByID(accountID);
		Assert.assertThat(newAcc.getFirstname(), CoreMatchers.equalTo(fromDB.getFirstname()));
		Assert.assertThat(newAcc.getLastname(), CoreMatchers.equalTo(fromDB.getLastname()));
		int numberOfAccounts=tested.getAllAccounts().size();
		tested.deleteAccount(accountID);
		Assert.assertTrue("Not deleted - List of all accounts was not decremented"
				, numberOfAccounts==(tested.getAllAccounts().size()+1)  );
	}
	
	
}
