package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	WebDriver driver;
	public CommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class=\"page-title\"]/h1") private WebElement pageTitle;
	
	@FindAll({ @FindBy(id="products-orderby") , @FindBy(name="products-orderby")})private WebElement sortbyDropdown;

	@FindAll({ @FindBy(id="products-pagesize") , @FindBy(name="products-pagesize")})private WebElement displayDropdown;

	@FindAll({ @FindBy(id="products-viewmode") , @FindBy(name="products-viewmode")})private WebElement viewAsDropdown;

	@FindBy(partialLinkText = "Next")private WebElement nextButton;
	
	public List<WebElement> getAllProductNameElement() {
		return driver.findElements(By.xpath("//h2[@class='product-title']/a"));
	}
	public WebElement getAddToCartButton(String productName) {
		return driver.findElement(By.xpath("//a[contains(text(),'"+productName+"')]/../following-sibling::div/descendant::input[@value='Add to cart']"));
	}
	public WebElement getPageTitle() {
		return pageTitle;
	}
	public WebElement getSortbyDropdown() {
		return sortbyDropdown;
	}
	public WebElement getDisplayDropdown() {
		return displayDropdown;
	}
	public WebElement getViewAsDropdown() {
		return viewAsDropdown;
	}
	public WebElement getNextButton() {
		return nextButton;
	}
	public WebElement getPaginationButton(String pageNumber) {
		return driver.findElement(By.xpath("//li/span[text()='"+pageNumber+"']"));		
	}
}
