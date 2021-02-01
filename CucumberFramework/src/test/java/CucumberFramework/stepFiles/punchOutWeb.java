package CucumberFramework.stepFiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class punchOutWeb {
	WebDriver driver;
	Actions a;
	Robot robo;
	
	
	
	
	@Given("user navigates to napapunchout website")
	public void user_navigates_to_napapunchout_website() throws AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arili\\OneDrive\\Desktop\\CucumberFramework\\CucumberFramework\\Chrome\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments(
				"--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(cap);
		a=new Actions(driver);
		robo = new Robot();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.napapunchout.ca/punchoutweb/");
	}


	@And("user clicks new cart")
	public void user_clicks_new_cart() {
	 WebElement newCart = driver.findElement(By.xpath("//input[@id='NewCartButton']"));
	 a.click(newCart).build().perform();
	}
	@And("user clicks punchout")
	public void user_clicks_punchout() throws Exception  {
		Thread.sleep(3000);
	    WebElement punchOut = driver.findElement(By.xpath("//input[@id='PunchoutButton']"));
	a.click(punchOut).build().perform();
	}
	@And("select click to change the napa store and change it to training and demo for stores")
	public void select_click_to_change_the_napa_store_and_change_it_to_training_and_demo_for_stores() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='PublicUserIDTextBox']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='MyFrame']")));
		Select s = new Select(driver.findElement(By.xpath("//select[@id='storeSelect']")));
		s.selectByVisibleText("Training and demo for stores (9999)");
		s.selectByIndex(6);
	 
	}
	@And("type in the number  in the search bar")
	public void type_in_the_number_in_the_search_bar() {
//Thread.sleep(10000);
 WebElement search = driver.findElement(By.cssSelector("input[id='ctl00_ContentPlaceHolder1_KeywordSearchTextBox']"));

try {
	search.sendKeys("1515");
} catch (StaleElementReferenceException e) {
	search = driver.findElement(By.cssSelector("input[id='ctl00_ContentPlaceHolder1_KeywordSearchTextBox']"));
	search.sendKeys("1515");
}

	}
	@And("click search by keyword")
	public void click_search_by_keyword() {
		WebElement searchKey = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_KeywordSearchButton']"));
	a.moveToElement(searchKey).click(searchKey).build().perform();
	}
	@And("user adds quantity for oil filter and adds item to cart")
	public void user_adds_quantity_for_oil_filter_and_adds_item_to_cart() {
		driver.findElement(By.xpath("//input[@id='NGF1515']")).sendKeys("1");
		WebElement addC = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceHolder1_AddDoubleToListButtonControl2']"));
a.moveToElement(addC).click(addC).build().perform();
	}
	@And("user clicks on open under shopping cart")
	public void user_clicks_on_open_under_shopping_cart() {
	 
	}
	@When("user clicks on checkout")
	public void user_clicks_on_checkout() {
	
	}
	@Then("user should see a page with details of what he purchased")
	public void user_should_see_a_page_with_details_of_what_he_purchased() {

	}

}
