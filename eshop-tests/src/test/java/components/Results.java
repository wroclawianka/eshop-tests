package components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dorota.zelga on 23/03/2017.
 */
public class Results {

	private WebDriver driver;

	public Results(WebDriver driver) {
		this.driver = driver;
	}

	public AddToBasketModal addToTheBag(String value) {
		String allResults = "//div[contains(@class,'row-items')]";
		String resultXpath = allResults + "/div[contains(@class,'s-item')][descendant::span[contains(text(),'%s')]]";
		String result = String.format(resultXpath, value);
		String bagIcon = result + "//descendant::span[contains(@class,'i-basket')]";

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bagIcon)));
		driver.findElement(By.xpath(String.format(bagIcon))).click();
		return new AddToBasketModal(driver);
	}
}
