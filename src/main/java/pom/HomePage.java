package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;


	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement Register_link;
	
	@FindBy(xpath = "//input[@value='Search store']")
	private WebElement Search_Txtfeild;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement Search_btn;
	
	
	@FindBy(xpath = "//input[@name='NewsletterEmail']")
	private WebElement NewsLetter_Textfeild;
	
	@FindBy(id = "newsletter-subscribe-button")
	private WebElement Subscribe_btn;
	
	@FindBy(xpath = "//div[@class='customer-blocks']//div[@class='text']")
	private WebElement NewsLetterSuccess_Msg;
	
	

	public WebDriver getDriver() {
		return driver;
	}



	public WebElement getRegister_link() {
		return Register_link;
	}



	public WebElement getSearch_Txtfeild() {
		return Search_Txtfeild;
	}



	public WebElement getSearch_btn() {
		return Search_btn;
	}



	public WebElement getNewsLetter_Textfeild() {
		return NewsLetter_Textfeild;
	}



	public WebElement getSubscribe_btn() {
		return Subscribe_btn;
	}



	public WebElement getNewsLetterSuccess_Msg() {
		return NewsLetterSuccess_Msg;
	}



	public WebElement Register_link() {
		return Register_link;
	}

}
