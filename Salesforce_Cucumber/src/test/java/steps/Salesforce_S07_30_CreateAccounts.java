package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_S07_30_CreateAccounts {

public static ChromeDriver driver;
public static Actions builder;

@Given("Launch Application")
public void launchApplication() {
	// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			builder = new Actions(driver);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.get("https://login.salesforce.com/?locale=in");
	}
@And("Enter Credentials")
public void enterCredentials() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElementById("username").sendKeys("matschie@testleaf.com");
	driver.findElementById("password").sendKeys("SeleniumBootcamp@123");
	driver.findElementById("Login").click();

}

@And("Click on Global Actions SVG icon and Sales")
public void clickOnGlobalActionsSVGIconAndSales() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
	driver.findElementByXPath("//button[text()='View All']").click();
	driver.findElementByXPath("//input[@placeholder='Search apps or items...']").sendKeys("Sales");
	driver.findElementByXPath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']").click();
	WebElement clickAccountsButton = driver.findElementByXPath("//a[@title='Accounts']/span[text()='Accounts']");
	builder.click(clickAccountsButton).perform();
	
}
@And("Click on New Button")
public void clickOnNewButton() {
    // Write code here that turns the phrase above into concrete actions
	WebElement clickNewButton = driver.findElementByLinkText("New");
	clickNewButton.click();


}
@And("Enter account name and Select Ownership as Public")
public void enterAccountNameAndSelectOwnershipAsPublic() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElementByXPath("//div[@class='slds-form-element__control slds-grow']//input[@name='Name']").sendKeys("Arjun");
	WebElement clickOwnershipButton = driver.findElementByXPath("//lightning-combobox[@class='slds-form-element_stacked slds-form-element']//label[text()='Ownership']//parent::lightning-combobox/div//div//button/span[text()='--None--']");
	
	clickOwnershipButton.click();
		 builder.sendKeys(Keys.ARROW_DOWN).build().perform();
		 builder.sendKeys(Keys.ENTER).build().perform();	 
		 
}
@When("Click save")
public void clickSave() {
    // Write code here that turns the phrase above into concrete actions
    driver.findElementByXPath("//button[@class= 'slds-button slds-button_brand' and text()='Save']").click();


}
@Then("Verify Account name")
public void verifyAccountName() {
    // Write code here that turns the phrase above into concrete actions

}


}
