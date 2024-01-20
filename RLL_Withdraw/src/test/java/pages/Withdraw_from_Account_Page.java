package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

;


public class Withdraw_from_Account_Page {
	
	 WebDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement Input;

	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordInput;

	@FindBy(xpath="//button[@id='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@id='withdraw-menu-item']")
	private WebElement withdrawlink;
	
	@FindBy(xpath="//select[@id='selectedAccount']")
	private WebElement selectaccount;
	
	@FindBy(xpath="//option[contains(text(),'Basic (Standard Checking)')]")
	private WebElement selectbankaccount;
	
	@FindBy(xpath="//input[@id='amount']")
	private WebElement amountinput;
	
	@FindBy(xpath="(//button[@type='submit'])[3]")
	private WebElement submit;
	
	@FindBy(xpath="//span[contains(text(),'The withdraw amount ($0.00) must be greater than $')]")
	private WebElement Error_0_Amt;
	
	@FindBy(xpath="(//button[@type='reset'])[1]")
	private WebElement Btn_Reset;
	
	@FindBy(xpath="//span[contains(text(),'The withdraw amount ($10000000000000000.00) is grea')]")
	private WebElement Exceed_amount;
	
	
	@FindBy(xpath="//input[@id='amount']")
	static WebElement Txtbox_DepositAmt;
	
	

	
	
	
	
	
	
	
	
	public Withdraw_from_Account_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToURL(String url) {
		driver.get(url);
	}
	
	
	public void performLogin(String input, String password) {
		Input.sendKeys(input);
		passwordInput.sendKeys(password);
		loginButton.click();
	}
	//
	public void clickWithdrawLink() {
		withdrawlink.click();
	}
	public void clickselectaccount() {
		selectaccount.click();
		selectbankaccount.click();
	}
		
	public void withdrawcheck(String amount) {
		
			amountinput.sendKeys(amount);
			submit.click();
			
		}
	
	public void clickonReset() {
		Btn_Reset.click();
	}
	public void invalid_input_0(String amount_0) {
		amountinput.sendKeys(amount_0);
		submit.click();
		amountinput.clear();
		
	}
	public boolean validate_error()
	{
		return selectaccount.isDisplayed();
	}
	public void exceedbalance(String amount_exceed) {
		amountinput.sendKeys(amount_exceed);
		submit.click();
		amountinput.clear();
	}
	public boolean captureError_maxamt()
	{
		return Exceed_amount.isDisplayed();
	}

	public String Error_0()
	
	{
		return Error_0_Amt.getText();
		
	}
    public String Error_exceed_amount()
	
	{
		return Exceed_amount.getText();
		
	}
    public boolean validate_Reset_Btn()
	{
		return Txtbox_DepositAmt.getText().isEmpty();
	}
    public boolean validate_dropdown()
	{
		return selectaccount.isDisplayed();
	}
    public String captureError_0_text()
	{
		String errortxt=Error_0_Amt.getText();
		return errortxt;
	}
    public String captureError_maxamt_Tesxt()
   	{
   		String errortxt=Exceed_amount.getText();
   		return errortxt;
   	}
}
