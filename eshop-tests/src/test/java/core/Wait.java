package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dorota.zelga on 23/03/2017.
 */
public class Wait {

	private static final int DEFAULT_TIMEOUT = 20;
	private WebDriver driver;

	public Wait(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement untilElementIsVisible(By locator) {
		return new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void untilElementIsInvisible(By locator) {
		new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
}
