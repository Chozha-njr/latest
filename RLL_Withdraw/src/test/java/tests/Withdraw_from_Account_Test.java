package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.TestBase;
import pages.Withdraw_from_Account_Page;
import stepDefinitions.Withdraw_step_def;



    public class Withdraw_from_Account_Test extends TestBase {
	Logger logger = LogManager.getLogger(this);   
	//private final WebDriver driver;
	public Withdraw_from_Account_Page Withdraw_Method ;
	//private final Withdraw_from_Account_Page Withdraw_Method ;
	

	
	@BeforeMethod
	public void setup()
	{

		Withdraw_Method=new Withdraw_from_Account_Page(driver);
		
	}
		

    
    @Test
	public void testdeposite() throws InterruptedException
	
	{
    	logger.info("User navigates to the URL");
    	Withdraw_Method.navigateToURL("http://dbankdemo.com/bank/login");
    	Thread.sleep(3000);
    
    	//Withdraw_Method
    	logger.info("User performs the login process");
		Withdraw_Method.performLogin("kirans@gmail.com", "Kiran4301@S");
		
	    
		logger.info("User clicks on withdraw link");
		Withdraw_Method.clickWithdrawLink();
	    
		//Validating Reset button
		logger.info("check ResetButton");
		//Withdraw_Method.clickWithdrawLink();
		Withdraw_Method.clickselectaccount();
		Withdraw_Method.clickonReset();
		Assert.assertTrue(Withdraw_Method.validate_Reset_Btn(), "Assert failed- Reset button not working");
	    
		//Validating clickselectaccount button
		logger.info("select DropDown button and test");
	    Withdraw_Method.clickselectaccount();
	    Assert.assertTrue(Withdraw_Method.validate_dropdown(), "Assert failed- didn't click amount");
    	
	    
	    //Validating withdraw with no value
	    logger.info("check withdraw with no value in input");
		Withdraw_Method.clickselectaccount();
		Withdraw_Method.withdrawcheck("");
		Thread.sleep(3000);
		Assert.assertTrue(Withdraw_Method.validate_error(), "Assert failed- Reading amount as empty");
    	
    	//Validating withdraw with no value
    	logger.info("check withdraw with invalid amount");
    	Withdraw_Method.clickselectaccount();
		Withdraw_Method.invalid_input_0("0");
		Thread.sleep(3000);
		Assert.assertTrue(Withdraw_Method.validate_error(), "Assert failed- Reading amount as 0");
		System.out.println(Withdraw_Method.captureError_0_text());
		logger.error(Withdraw_Method.captureError_0_text());
		
    	
		
		//Validating withdraw with exceed value
		logger.info("check withdraw with exceed bank amount");
		Withdraw_Method.clickselectaccount();
		Withdraw_Method.exceedbalance("10000000000000000");
		Thread.sleep(3000);
		Assert.assertTrue(Withdraw_Method.captureError_maxamt(), "Assert failed- Reading amount as empty");
		System.out.println(Withdraw_Method.captureError_maxamt_Tesxt());
		logger.error(Withdraw_Method.captureError_maxamt_Tesxt());
		
        
		//Validating withdraw with valid amount
		logger.info("give valid amount and deposite");
    	Withdraw_Method.clickselectaccount();
		Withdraw_Method.withdrawcheck("120");
		
		driver.close();
		
		
	}

	
}

