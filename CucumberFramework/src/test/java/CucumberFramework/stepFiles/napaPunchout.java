package CucumberFramework.stepFiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class napaPunchout {
	WebDriver driver;
	Actions a;
	Robot robo;
	
	
	
	
	@Given("user navigates into napapunchout website")
	public void user_navigates_into_napapunchout_website() throws AWTException {
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
		driver.get("http://m.napapunchout.com/Account/Login?ReturnUrl=%2f");
	}


	

	@And("user enters the tracs id")
	public void user_enters_the_tracs_id() {
WebElement tracId = driver.findElement(By.xpath("//input[@id='PunchoutId']"));
	tracId.sendKeys("1867293818");
	}
	@And("user clicks login")
	public void user_clicks_login() {
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
a.click(login).build().perform();
	}
	@And("user navigates to vingenerator")
	public void user_navigates_to_vingenerator() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");
		driver.get("https://vingenerator.org/");
		

	}
	@And("user copies the VIN")
	public void user_copies_the_VIN() {
		WebElement vin = driver.findElement(By.xpath("//input[@type='text']"));
a.doubleClick(vin).build().perform();
a.contextClick(vin).build().perform();
for (int i = 0; i < 1; i++) {
	robo.keyPress(KeyEvent.VK_DOWN);
	robo.keyRelease(KeyEvent.VK_DOWN);
}
robo.keyPress(KeyEvent.VK_ENTER);
robo.keyRelease(KeyEvent.VK_ENTER);
	}
	@And("user navigates back to napapunchout and copies VIN")
	public void user_navigates_back_to_napapunchout_and_copies_VIN() {
		driver.navigate().back();
		WebElement vinClick = driver.findElement(By.xpath("//input[@id='vin']"));
a.click(vinClick).build().perform();
robo.keyPress(KeyEvent.VK_CONTROL);
robo.keyPress(KeyEvent.VK_V);
robo.keyRelease(KeyEvent.VK_V);
robo.keyRelease(KeyEvent.VK_CONTROL);
	}
	@When("user clicks vehicle history")
	public void user_clicks_vehicle_history() {
WebElement vehHis = driver.findElement(By.xpath("//a[@class='btn btn-block']"));
	a.click(vehHis).build().perform();
	}
	@Then("VIN details should be displayed")
	public void vin_details_should_be_displayed() throws InterruptedException {
		WebElement vinD = driver.findElement(By.xpath("//div[@class='row']"));
String str = vinD.getText();
System.out.println(str);
if (vinD.isDisplayed()) {
	System.out.println("VIN details are exposed");
}else {
	System.out.println("Failed");
}
Thread.sleep(3000);
driver.quit();
	}
	
}
