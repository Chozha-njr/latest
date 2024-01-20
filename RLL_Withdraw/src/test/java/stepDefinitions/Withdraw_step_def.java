package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Withdraw_from_Account_Page;
import pages.BaseClass;



public class Withdraw_step_def {

    private static final Logger logger = LogManager.getLogger(Withdraw_step_def.class);
    private final WebDriver driver;
    public Withdraw_from_Account_Page Withdraw_Method;

    public Withdraw_step_def() {
        driver = BaseClass.getDriver();
        Withdraw_Method = new Withdraw_from_Account_Page(driver);
        SoftAssert s = new SoftAssert();
    }


		
		
	
	@Given("User navigates to the URL")
	
	public void user_navigates_to_the_url() {
		logger.info("User navigates to the URL");
		Withdraw_Method.navigateToURL("http://dbankdemo.com/bank/login"); //url 
		
	}

	@When("User performs the login process")
	public void user_performs_the_login_process() {   //id , pass
		logger.info("User performs the login process");
		try {
			Withdraw_Method.performLogin("kirans@gmail.com", "Kiran4301@S");
        } catch (Exception ex) {
            Assert.fail("Unable to open browser");
        }
	}
	    

	@Then("User clicks on withdraw link")
	public void click_Withdraw() {
		logger.info("User clicks on withdraw link");
		try {
			Withdraw_Method.clickWithdrawLink();
        } catch (Exception ex) {
            Assert.fail("Unable to click the link");
        }
		
		
	}
	
	@Then("check RestButton")
	public void select_Reset_Button() {
		logger.info("check ResetButton");
		try {
			//Withdraw_Method.clickWithdrawLink();
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.clickonReset();
			Thread.sleep(3000);
        } catch (Exception ex) {
            Assert.fail("unable to reset the page");
        }
		
		
	}
		
	@Then("select DropDown button and test")
	public void select_DropDown_button() {
		logger.info("select DropDown button and test");
		try {
			Withdraw_Method.clickselectaccount();
        } catch (Exception ex) {
            Assert.fail("Unable to click drop down button and select bank");
        }
		
	}
	
	@Then("check withdraw with no value in input")
	public void empty_Input_amount() {
		logger.info("check withdraw with no value in input");
			
		///
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.withdrawcheck("");
        
        	Assert.assertTrue(Withdraw_Method.validate_error(), "Assert failed- Reading empty fields");
        
	}
	@Then("check withdraw with '0' amount")
	public void invalid_input() throws InterruptedException {
		logger.info("check withdraw with invalid amount");
		Withdraw_Method.clickselectaccount();
		Withdraw_Method.invalid_input_0("0");
		
		Thread.sleep(3000);
		Assert.assertTrue(Withdraw_Method.validate_error(), "Assert failed- Reading amount as 0");
		System.out.println(Withdraw_Method.captureError_0_text());
		logger.error(Withdraw_Method.captureError_0_text());
		
		
	}
	
	
	
	@Then("check withdraw with exceed bank amount")
	public void Exceed_bankamount() throws InterruptedException {
		logger.info("check withdraw with exceed bank amount");
		
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.exceedbalance("10000000000000000");
			Thread.sleep(3000);
			Assert.assertTrue(Withdraw_Method.captureError_maxamt(), "Assert failed- Reading amount as empty");
			Thread.sleep(3000);
			System.out.println(Withdraw_Method.captureError_maxamt_Tesxt());
			Thread.sleep(3000);
			logger.error(Withdraw_Method.captureError_maxamt_Tesxt());
			Thread.sleep(3000);
   
		
	}
	
	
	
	@Then("give valid amount and deposite")
	public void Withdraw_Amount_from_account() {
		logger.info("give valid amount and deposite");
		try {
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.withdrawcheck("120");
        } catch (Exception ex) {
        	Assert.fail("Withdraw failed");
        }

        
		
}
	
}

	
	/*@Then("check withdraw with 'o' value")
	public void Exceed_bankamount_fails() {
		logger.info("check withdraw with 'o' value");
		
		Withdraw_Method.navigateToURL("http://dbankdemo.com/bank/login");
		Withdraw_Method.performLogin("kirans@gmail.com", "Kiran4301@S");
		Withdraw_Method.clickWithdrawLink();
		
		Withdraw_Method.clickselectaccount();
		Withdraw_Method.invalid_input_0("0");
		String expected="The withdraw amount  must be greater than $0.00";
		String actual=Withdraw_Method.Error_0();
		actual.equals(expected); 
		Assert.assertTrue(actual.contains(expected),"please type valid input");
	
}}


	/*try {
	            String[] errorXPaths = {
	                    "//span[contains(text(),'The withdraw amount ($0.00) must be greater than $')]", 
	                    "//span[contains(text(),'The withdraw amount ($1000000000000000.00) is grea')]", 
	                    "//div[@id='errorMessageBox3']/span"
	            };
	            String firstErrorMessage = null;

	            for (String errorXPath : errorXPaths) {
	                By errorLocator = By.xpath(errorXPath);

	                try {
	                    WebElement errorMessageElement = driver.findElement(errorLocator);

	                    if (errorMessageElement.isDisplayed()) {
	                        // Capture the first error message and break the loop
	                        firstErrorMessage = errorMessageElement.getText();
	                        throw new AssertionError("Error: " + firstErrorMessage);
	                    }
	                } catch (org.openqa.selenium.NoSuchElementException e) {
	                    // Handle the case when the element is not found (error message not displayed)
	                    
	                }
	            }

	            // If no error message is displayed, you can run specific code
	            if (firstErrorMessage == null) {
	                System.out.println("No error message displayed. Running additional code...");
	            } else {
	                // If an error message is displayed, perform an assertion
	                Assert.fail("Error: " + firstErrorMessage);
	            }

	            // Perform additional actions or verifications
	            // ...

	        } catch (AssertionError e) {
	            // Handle the assertion error
	        	
	            System.out.println("Assertion failed: " + e.getMessage());
	        }
	}
	22222
	@Then("check withdraw with invalid amount")
	public void invalid_input() {
		logger.info("check withdraw with invalid amount");
		Withdraw_Method.clickselectaccount();
		Withdraw_Method.invalid_input_0("0");
		String expected="The withdraw amount ($0.00) must be greater than $0.00";
		String actual=Withdraw_Method.Error_0();
		actual.equals(expected); 
		Assert.assertTrue(actual.contains(expected));
		
		
		
		
	}
	
	@Then("check withdraw with exceed bank amount")
	public void Exceed_bankamount() {
		logger.info("check withdraw with exceed bank amount");
		Withdraw_Method.clickselectaccount();
		Withdraw_Method.exceedbalance("1000000000000000.00");
		String expected="The withdraw amount ($1000000000000000.00) is greater than the available balance ($5999999998641.00) and overdraft limit ($25.00).";
		String actual=Withdraw_Method.Error_exceed_amount();
		actual.equals(expected); 
		Assert.assertTrue(actual.contains(expected));
		
		
	}
	
	
	@Then("give valid amount and deposite")
	public void Withdraw_Amount_from_account() {
		logger.info("give valid amount and deposite");
		try {
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.withdrawcheck("120");
        } catch (Exception ex) {
        	Assert.fail("Withdraw failed");
        }

	*/
    		
