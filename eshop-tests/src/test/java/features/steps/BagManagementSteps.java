package features.steps;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import core.DriverInitializer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import pages.*;

/**
 * Created by dorota.zelga on 23/03/2017.
 */
public class BagManagementSteps {

	private static final List<String> BOOKS = Arrays
			.asList("Java. Ćwiczenia praktyczne", "Tablice informatyczne. Java");
	private static WebDriver driver;
	private static ResultPage resultPage;
	private static BagPage bagPage;

	@Before
	public static void setUpClass() {
		driver = new DriverInitializer().openChromeDriver();
		resultPage = new ResultPage(driver);
		bagPage = new BagPage(driver);
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	@Given("^user goes to the e-shop page$")
	public void userGoesToTheEShopPage() {
		driver.get("http://www.matras.pl/");
	}

	@When("^user searches by keyword$")
	public void userSearchesByKeyword() {
		String keyWords = "Java Marcin Lis";

		MainPage mainPage = new MainPage(driver);
		mainPage.searchBox
				.clickSearchBox()
				.typeAndEnter(keyWords);
	}

	@When("^user adds two products$")
	public void userAddsTwoProducts() {
		resultPage.results
				.addToTheBag(BOOKS.get(0))
				.backToShopping()
				.addToTheBag(BOOKS.get(1));
	}

	@And("^user goes to the bag$")
	public void userGoesToTheBag() {
		resultPage.addToBasketModal.goToTheBag();
	}

	@And("^user adds one more instance of the product$")
	public void userAddsOneMoreInstanceOfTheProduct() {
		bagPage.bag
				.addAdditionalInstance(BOOKS.get(1))
				.reloadBag(BOOKS.get(1));
	}

	@Then("^cost is correctly calculated$")
	public void costIsCorrectlyCalculated() {

		double expectedSumFirstProduct = bagPage.bag.getPrice(BOOKS.get(0));
		double actualSumFirstProduct = bagPage.bag.getSum(BOOKS.get(0));
		Assert.assertEquals("Sum of one product:", expectedSumFirstProduct, actualSumFirstProduct, 0.001);

		double expectedSumSecondProduct = bagPage.bag.getPrice(BOOKS.get(1)) * 2;
		double actualSumSecondProduct = bagPage.bag.getSum(BOOKS.get(1));
		Assert.assertEquals("Sum of two the same products:", expectedSumSecondProduct, actualSumSecondProduct, 0.001);

		double expectedOverallPrice = expectedSumFirstProduct + expectedSumSecondProduct;
		double actualOverallPrice = bagPage.bag.getOverall();
		Assert.assertEquals("Overall price:", expectedOverallPrice, actualOverallPrice, 0.001);
	}
}
