package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.Wait;

/**
 * Created by dorota.zelga on 23/03/2017.
 */
public class AddToBasketModal {

	private final WebDriver driver;
	private final Wait wait;

	public AddToBasketModal(WebDriver driver) {
		this.driver = driver;
		this.wait = new Wait(driver);
	}

	public Results backToShopping() {
		clickButton("Kontynuuj zakupy");
		return new Results(driver);
	}

	public void goToTheBag() {
		clickButton("Przejdź do koszyka");
	}

	private void clickButton(String value) {
		String modalAddBasket = "//div[@id='modal-add-basket']";
		String modalFooter = modalAddBasket + "//descendant::div[@class='modal-footer']";
		String modalButton = modalFooter + "//descendant::span[contains(text(),'%s')]";

		By button = By.xpath(String.format(modalButton, value));
		wait.untilElementIsVisible(button).click();
		wait.untilElementIsInvisible(By.xpath(modalAddBasket));
	}
}
