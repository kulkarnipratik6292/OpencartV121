package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.AccountRegistrationPage;


public class TC_001_AccountRegistrationTest extends BaseClass {
    
	@Test(groups={"Regression","Master"})
    public void verify_account_registration() {
    	
    	logger.info("**** Starting AccountRegistrationTest ****");
    	
    	try {
        // 1. Home Page actions
        HomePage hp = new HomePage(driver);
        
        hp.clickMyAccount();
        
        logger.info("Clicked on My Account link");
        
        
        hp.clickRegister();

        logger.info("Clicked on Register link");
        
        // 2. Registration Form actions
        AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
        
        logger.info("Providing customer details...");
        
        regpage.setFirstName(randomString().toUpperCase());
        regpage.setLastName(randomString().toUpperCase());
        regpage.setEmail(randomString() + "@gmail.com"); // Dynamically sets a new email per run
        regpage.setTelephone(randomNumber());

        String password = randomAlphaNumeric(); // Ensures Confirm Password matches Password
        regpage.setPassword(password);
        regpage.setConfirmPassword(password);

        regpage.setPrivacyPolicy();
        regpage.clickContinue();

        logger.info("Validating expected message...");
        // 3. Validation
        String confmsg = regpage.getConfirmationMsg();
        if(confmsg.equals("Your Account Has Been Created!"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            logger.error("Test failed..");
            logger.debug("Debug logs..");
            Assert.assertTrue(false);
        }

        //Assert.assertEquals(confmsg,"Your Account Has Been Created!!!");
        }
        catch(Exception e)
        {
        	logger.error("Test failed: ", e);
            Assert.fail();
        }

        logger.info("***** Finished TC001_AccountRegistrationTest  ****");
        }
}