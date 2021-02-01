package CucumberFramework.stepFiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class autoEstimator {
	WebDriver driver;
	Actions a;
	Robot robo;

	
	@Given("user navigates to napaonline website")
	public void user_navigates_to_napaonline_website() throws AWTException {
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
		driver.get("https://www.napaonline.com/en/auto-care");

	}
   @And("user clicks on get an estimate button")
	public void user_clicks_on_get_an_estimate_button() {
	WebElement estClick = driver.findElement(By.xpath("//img[@class='drop']"));
	a.moveToElement(estClick).click(estClick).build().perform();
   }
	@And("user fills in the vehicle details")
	public void user_fills_in_the_vehicle_details() throws InterruptedException {
		Thread.sleep(3000);
		WebElement vehYear = driver.findElement(By.xpath("//input[@id='vehicle_year']"));
        a.click(vehYear).build().perform();
       
        vehYear.sendKeys("2013");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='vehicle_make']")).sendKeys("Ford");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='vehicle_model']")).sendKeys("F-150");
	}
	@And("user enters the pincode")
	public void user_enters_the_pincode() {
		WebElement pin = driver.findElement(By.xpath("//input[@id='zip_code']"));
	   a.click(pin).build().perform();
	   pin.sendKeys("30062");
	}
	@And("user clicks on the select vehicle and continue button")
	public void user_clicks_on_the_select_vehicle_and_continue_button() {
		driver.findElement(By.xpath("//button[@id='continue']")).click();

	}
	@And("user selects brakes and brakes and pad replacement")
	public void user_selects_brakes_and_brakes_and_pad_replacement() throws InterruptedException {
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='category-1']")).click();
		Thread.sleep(3000);
		for (int i = 0; i < 7; i++) {
			robo.keyPress(KeyEvent.VK_TAB);
			robo.keyRelease(KeyEvent.VK_TAB);
		}
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);

	
}

	
	@When("user clicks on get an estimate")
	public void user_clicks_on_get_an_estimate() {
WebElement getEst = driver.findElement(By.xpath("//button[@id='getEstimate']"));
	a.click(getEst).build().perform();
	}
	@Then("dollar estimation should be displayed")
	public void dollar_estimation_should_be_displayed() throws InterruptedException {
		Thread.sleep(3000);
		WebElement estVal = driver.findElement(By.xpath("//div[@class='ncol-xs-12 estimate price-range']"));

		if (estVal.isDisplayed()) {
			System.out.println("Estimated Amount In Dollars Is Displayed");
			
		}else {
			System.out.println("Failed");
		}
		Thread.sleep(3000);
		driver.quit();
	}
	
}
