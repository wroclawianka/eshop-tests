package pages;

import org.openqa.selenium.WebDriver;

import components.AddToBasketModal;
import components.Results;

/**
 * Created by dorota.zelga on 23/03/2017.
 */
public class ResultPage {

	public WebDriver driver;
	public final Results results;
	public final AddToBasketModal addToBasketModal;

	public ResultPage(WebDriver driver) {
		this.driver = driver;
		this.results = new Results(driver);
		this.addToBasketModal = new AddToBasketModal(driver);
	}
}
