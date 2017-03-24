package components;

import org.openqa.selenium.*;

/**
 * Created by dorota.zelga on 23/03/2017.
 */
public class SearchBox {

	private static final String HEADER = "//header[@id='main-header']";
	private static final String SEARCH_FIELD = HEADER + "//descendant::div[@class='search-col col']";
	private static final String INPUT_XPATH = SEARCH_FIELD + "//descendant::input";
	private WebDriver driver;

	public SearchBox(WebDriver driver) {
		this.driver = driver;
	}

	public SearchBox clickSearchBox() {
		driver.findElement(By.xpath(INPUT_XPATH)).click();
		return this;
	}

	public void typeAndEnter(String value) {
		driver.switchTo().activeElement().sendKeys(value + Keys.ENTER);
	}
}
