package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;


	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='FirstName']")
	private WebElement FirstName_txtfeild;
	
	@FindBy(xpath = "//input[@name='LastName']")
	private WebElement LastName_txtfeild;
	
	@FindBy(xpath = "//input[@name='Email']")
	private WebElement Email_txtfeild;
	
	@FindBy(xpath = "//input[@name='Password']")
	private WebElement Password_txtfeild;
	
	@FindBy(xpath = "//input[@name='ConfirmPassword']")
	private WebElement ConfirmPassword_txtfeild;
	
	@FindBy(xpath = "//input[@name='register-button']")
	private WebElement Registerbtn;
	

	@FindBy(xpath = "//div[@class='result']")
	private WebElement RegisterSucessMsg;
		
	
	
	public WebElement FirstName_txtfeild() {
		return FirstName_txtfeild;
	}
	
	public WebElement LastName_txtfeild() {
		return LastName_txtfeild;
	}
	
	public WebElement Email_txtfeild() {
		return Email_txtfeild;
	}
	
	public WebElement Password_txtfeild() {
		return Password_txtfeild;
	}
	
	public WebElement ConfirmPassword_txtfeild() {
		return ConfirmPassword_txtfeild;
	}
	
	public WebElement Registerbtn() {
		return Registerbtn;
	}
	
	public WebElement RegisterSucessMsg() {
		return RegisterSucessMsg;
	}
	
	public void GenderRadiobtn(String gender) {
		WebElement genderbtn = driver.findElement(By.xpath("//div[@class='gender']/input/following-sibling::label[text()='"+gender+"']"));
		genderbtn.click();
	}
}
