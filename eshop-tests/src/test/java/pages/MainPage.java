package pages;

import org.openqa.selenium.WebDriver;

import components.SearchBox;

/**
 * Created by dorota.zelga on 23/03/2017.
 */
public class MainPage {

	public WebDriver driver;
	public final SearchBox searchBox;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		this.searchBox = new SearchBox(driver);
	}
}
