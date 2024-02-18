package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApparelAndShoesPage {
	WebDriver driver;

	public ApparelAndShoesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "Apparel & Shoes")
	private WebElement apparelAndShoesTab;

	public WebElement getApparelAndShoesTab() {
		return apparelAndShoesTab;
	}
}
