package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public static ChromeDriver driver;
	public static Actions builder;
	
	
	@Given("Launch the chrome browser")
	public void launchBrowser() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		builder = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	
	@And("Load the application url")
	public void loadAppURL() {
		// TODO Auto-generated method stub
		driver.get("https://login.salesforce.com/?locale=in");
	}
	
	@And("Enter the username")
	public void enterUsername() {
		// TODO Auto-generated method stub
		
		driver.findElementById("username").sendKeys("matschie@testleaf.com");


	}
	
	@And("Enter the password")
	public void enterPassword() {
		// TODO Auto-generated method stub
		driver.findElementById("password").sendKeys("SeleniumBootcamp@123");
	}
	
	@When("Click the login button")
	public void clickLoginButton() {
		// TODO Auto-generated method stub

	}
	
	@Then("Homepage is displayed")
	public void verifyHomePage() {
		// TODO Auto-generated method stub
		String actualTitle = driver.getTitle();
		if (actualTitle.contains("Lightning Experience")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
	}
}
