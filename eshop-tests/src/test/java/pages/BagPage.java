package pages;

import org.openqa.selenium.WebDriver;

import components.Bag;

/**
 * Created by dorota.zelga on 23/03/2017.
 */
public class BagPage {

	public WebDriver driver;
	public final Bag bag;

	public BagPage(WebDriver driver) {
		this.driver = driver;
		this.bag = new Bag(driver);
	}
}
