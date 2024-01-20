package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;


//@RunWith(Cucumber.class)
//@Listeners(value= {ITestListenerClass.class})
@CucumberOptions(features="C:\\Users\\chozha\\Sl_SeleniumDemo_workspace\\RLL_Withdraw\\src\\test\\java\\feature\\withdraw.feature",
glue={"stepDefinitions","pages"},
plugin= {"pretty","html:target/sample.html"},
		monochrome =true)

public class TestNGRunner extends AbstractTestNGCucumberTests  
{
	//Runs each cucumber scenario found in the# Then give valid amount and deposite features as separated test
	
}


