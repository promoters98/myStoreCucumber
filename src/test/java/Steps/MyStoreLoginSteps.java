package Steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utils.Base;
import Utils.Data;

public class MyStoreLoginSteps extends Base {

	Data d = new Data();

	@Given("the user is on home page")
	public void the_user_is_on_home_page() {
		chromeSetup();
		navigateToHomePage();
	}

	@When("the user clicks on Sign In")
	public void the_user_clicks_on_sign_in() {
		WebElement SigninButton = driver.findElement(By.cssSelector(".login"));
		SigninButton.click();
		System.out.println("*** User has clicked sign in button. ***");
	}

	@And("^enters valid (.*) and (.*)$")
	public void enters_valid_username_and_password(String username, String password) {
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(username);
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys(password);
		WebElement SignIn = driver.findElement(By.id("SubmitLogin"));
		SignIn.click();
	}

	@Then("the user is logged in successfully")
	public void the_user_is_logged_in_successfully() {
		String current = driver.getCurrentUrl();
		if (d.myAccountUrl.equalsIgnoreCase(current)) {
			System.out.println("*** User is on My Account Page. ***");
		} else {
			System.out.println("My Account page is unreachable.");
		}
		tearDown();
	}
}
