package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.Wait;

/**
 * Created by dorota.zelga on 23/03/2017.
 */
public class Bag {

	private static final String CART = "//section[@id='checkout-cart']";
	private static final String ITEM = CART + "//descendant::div[contains(@class,'cart-table-item')][ descendant::a[@title='%s']]";
	private static final String AMOUNT = ITEM + "//descendant::div[contains(@class,'amount-cell')]";
	private Wait wait;

	public Bag(WebDriver driver) {
		this.wait = new Wait(driver);
	}

	public Bag addAdditionalInstance(String value) {
		String addButton = AMOUNT + "//descendant::span[contains(@class,'add')]";
		wait.untilElementIsVisible(By.xpath(String.format(addButton, value))).click();
		return this;
	}

	public void reloadBag(String value) {
		By reloadButton = By.xpath(String.format(AMOUNT + "//descendant::span[contains(@class,'reload')]", value));
		wait.untilElementIsVisible(reloadButton).click();
		wait.untilElementIsInvisible(reloadButton);
	}

	public double getPrice(String value) {
		return getProductValue(value, "base-price");
	}

	public double getSum(String value) {
		return getProductValue(value, "summary-value");
	}

	public double getOverall() {
		String overallPrice = "//descendant::div[@class='overal-price']//descendant::span[@class='price']";
		return getValue(overallPrice);
	}

	private double getValue(String costXpath) {
		String price = wait.untilElementIsVisible(By.xpath(costXpath)).getText();
		return Double.parseDouble(price.substring(0, price.length() - 3).replace(",", "."));
	}

	private double getProductValue(String value, String cost){
		String item = String.format(ITEM, value);
		String costXpath = String.format(item + "//descendant::span[contains(@class,'%s')]", cost);
		return getValue(costXpath);
	}
}
