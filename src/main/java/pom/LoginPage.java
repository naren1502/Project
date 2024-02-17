package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement Login_link;
	
	@FindBy(xpath = "//input[@name='Email']")
	private WebElement Email_txtfeild;
	
	@FindBy(xpath = "//input[@name='Password']")
	private WebElement Password_txtfeild;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement Login_btn;

	public WebElement getLogin_btn() {
		return Login_btn;
	}

	public WebElement getLogin_link() {
		return Login_link;
	}

	public WebElement getEmail_txtfeild() {
		return Email_txtfeild;
	}

	public WebElement getPassword_txtfeild() {
		return Password_txtfeild;
	}

	public WebElement Login_link() {
		return Login_link;
	}
	
	
}
