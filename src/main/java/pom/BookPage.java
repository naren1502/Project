package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage {
	
	public BookPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Books')]")
	private WebElement BooksLink;
	
	public WebElement getBooksLink() {
		return BooksLink;
	}
	
	@FindBy(xpath = "//h1[text()='Books']")
	private WebElement Bookstext;
	
	public WebElement getBookstext() {
		return Bookstext;
	}
	
	@FindBy (xpath = "//select[@id='products-orderby']")
	private WebElement SortByDropDown;
	
	public WebElement getSortByDropDown() {
		return SortByDropDown;
	}
	
	@FindBy(xpath = "//select[@id='products-pagesize']")
	private WebElement DisplayDropDown;
	
	public WebElement getDisplayDropDown() {
		return DisplayDropDown;
	}
	
	@FindBy(xpath = "//select[@id='products-viewmode']")
	private WebElement ViewAsDropDown;
	

	
}
