package CucumberFramework.stepFiles;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class napaOnline {
	WebDriver driver;
	Actions a ;

	
	@Given("user gets into the website")
	public void user_gets_into_the_website() {
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
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("https://www.napaonline.com/en/auto-care");
	}

	@And("user clicks on autocare center nearby")
	public void user_clicks_on_autocare_center_nearby() {
	    WebElement clickF = driver.findElement(By.xpath("//img[@src='/medias/landing-1280x424-hero-en-autocare-d-v2.jpg?context=bWFzdGVyfGltYWdlc3w3NTMwOHxpbWFnZS9qcGVnfGltYWdlcy9oY2IvaDgyLzkwNTIwNjM3Mjc2NDYuanBnfGQxMjUxOTk2ZmU3YjhlMmU0ODM3OTVlMzI4MDg1ZGEzZDVhNzZjYjU2NzBiMjUxYzdiNDE4NGFlYmQyNWE5MWQ']"));
	a.click(clickF).build().perform();
	}

	@And("user enters pincode")
	public void user_enters_pincode() {
	 WebElement pin = driver.findElement(By.xpath("//input[@id='autocare-search-input']"));
	pin.sendKeys("30062");
	}

	@When("user clicks search")
	public void user_clicks_search() throws InterruptedException {
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
	  WebElement search = driver.findElement(By.xpath("//a[@id='autocare-search-button']"));
	 a.moveToElement(search).click(search).build().perform();
	}

	@Then("search results should be displayed")
	public void search_results_should_be_displayed() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//a[@class='store-item-title']"));
		for (int i = 0; i < list.size(); i++) {
			String tList = list.get(i).getText();
			
			if (tList.contains(tList)) {
				System.out.println("Results are displayed successfully");
			}else {
				System.out.println("Results not found");
			}
		}
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		driver.quit();
	 
	}

	

}
