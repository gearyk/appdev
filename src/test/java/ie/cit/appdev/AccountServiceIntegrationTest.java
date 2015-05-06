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
	
	@Test @Transactional
	public void testCreateNewAccount(){
		newAcc=tested.createNewAccount("integrationFN", "integrationLN");
		Account fromDB=tested.getByID(newAcc.getId());
		Assert.assertThat(newAcc.getFirstname(), CoreMatchers.equalTo(fromDB.getFirstname()));
		Assert.assertThat(newAcc.getLastname(), CoreMatchers.equalTo(fromDB.getLastname()));
	}
	
	
}
