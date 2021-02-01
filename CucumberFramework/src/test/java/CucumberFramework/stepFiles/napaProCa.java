package CucumberFramework.stepFiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
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

public class napaProCa {
	WebDriver driver;
	Actions a;
	Robot robo;
	@Given("user navigates to the napaprolink wesite")
	public void user_navigates_to_the_napaprolink_wesite() throws AWTException {
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
		driver.get("https://napaprolink.ca/login.aspx?ReturnUrl=%2f");

	}


	

	@And("user logs in with the provided credentials")
	public void user_logs_in_with_the_provided_credentials() {
		WebElement uN = driver.findElement(By.xpath("//input[@id='userLoginTextBox']"));
uN.sendKeys("networksvcs");
WebElement pass = driver.findElement(By.xpath("//input[@id='loginUserControl_passwordTextBox']"));
	pass.sendKeys("prolink");
	robo.keyPress(KeyEvent.VK_ENTER);
	robo.keyPress(KeyEvent.VK_ENTER);
	}
	@And("user searches for the provided vehicle model")
	public void user_searches_for_the_provided_vehicle_model() throws InterruptedException {
		Thread.sleep(8000);
		WebElement year = driver.findElement(By.xpath("//a[contains(text(),'2012')]"));
         a.click(year).build().perform();
         Thread.sleep(3000);
         WebElement make = driver.findElement(By.xpath("//a[@href='#'][contains(text(),'Acura')]"));
	     a.click(make).build().perform();
	     Thread.sleep(3000);
	     WebElement model = driver.findElement(By.xpath("//a[@href='#'][contains(text(),'MDX')]"));
	     a.click(model).build().perform();
	     WebElement engine = driver.findElement(By.xpath("//a[contains(text(),\"Don't Know\")]"));
	     a.click(engine).build().perform();
	}
	@And("user adds the necessary search terms and searches for the product")
	public void user_adds_the_necessary_search_terms_and_searches_for_the_product() {
WebElement searchBox = driver.findElement(By.xpath("//input[@id='txtDescription']"));
	WebElement add = driver.findElement(By.xpath("//img[@id='btnDescriptionSearch']"));
	searchBox.sendKeys("Break Pads");
	add.click();
	searchBox.sendKeys("Front");
	add.click();
	searchBox.sendKeys("Ultra");
	add.click();
	searchBox.sendKeys("Premium");
	add.click();
	searchBox.sendKeys("OE Ceramic");
	add.click();
	WebElement search = driver.findElement(By.xpath("//img[@id='btnMultiSearch']"));
	a.click(search).build().perform();
	}
	@And("user clicks on a product")
	public void user_clicks_on_a_product() throws InterruptedException {
		Thread.sleep(4000);
		WebElement modelBrake = driver.findElement(By.xpath("//a[contains(text(),'NAPA Proformer Front Brake Pads Ceramic')]"));
        a.click(modelBrake).build().perform();
	}
	@And("user adds the item to the cart")
	public void user_adds_the_item_to_the_cart() throws InterruptedException {
		Thread.sleep(8000);
WebElement addKart = driver.findElement(By.xpath("//input[@id='FNTPF8396AX']"));
	addKart.sendKeys("1");
	WebElement ad = driver.findElement(By.xpath("//img[@id='ctl00_mainContentPlaceHolder_addToCartImageButton']"));
	a.click(ad).build().perform();
	}
	@When("user clicks checkout")
	public void user_clicks_checkout() throws InterruptedException {
Thread.sleep(2000);
WebElement checkOut = driver.findElement(By.xpath("//div[@id='ctl00_mainContentPlaceHolder_ShoppingCart1_checkOutBtnDiv']"));
	a.moveToElement(checkOut).click(checkOut).build().perform();
	}
	@Then("user should be able to see price and our added item in cart on next page")
	public void user_should_be_able_to_see_price_and_our_added_item_in_cart_on_next_page() throws InterruptedException {
		Thread.sleep(3000);
		WebElement productName = driver.findElement(By.xpath("//td[contains(text(),'FNT PF8396AX')]"));
		WebElement cost = driver.findElement(By.xpath("//body/form[@id='aspnetForm']/div[@id='pagewrap']/table[@cellspacing='0']/tbody/tr/td[@width='980']/table[@width='980']/tbody/tr/td[@width='980']/table[@style='margin-bottom: 10px;']/tbody/tr/td[@class='wideback']/div[@id='ctl00_mainContentPlaceHolder_shoppingCartUpdatePanel']/div[@id='ctl00_mainContentPlaceHolder_shoppingCartPanel1']/div/table[@id='ctl00_mainContentPlaceHolder_shoppingCartGridView1']/tbody/tr[@class='blueshade']/td[6]"));
        String str = cost.getText();
		if (productName.isDisplayed() & str.equalsIgnoreCase("$0.00")) {
			for (int i = 0; i < 2; i++) {
				driver.navigate().back();
			}
}
		WebElement secondStore = driver.findElement(By.xpath("//a[contains(text(),'NAPA Premium Front Brake Pads Ceramic')]"));
		a.moveToElement(secondStore).click(secondStore).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='FNPSS8396AX']")).sendKeys("1");
		WebElement c = driver.findElement(By.xpath("//img[@id='ctl00_mainContentPlaceHolder_addToCartImageButton']"));
        a.click(c).build().perform();
         
       WebElement cOut = driver.findElement(By.xpath("//div[@id='ctl00_mainContentPlaceHolder_ShoppingCart1_checkOutBtnDiv']"));
       a.moveToElement(cOut).click(cOut).build().perform();
       driver.findElement(By.xpath("//a[@id='ctl00_mainContentPlaceHolder_shoppingCartGridView1_ctl02_removelinkButton']")).click();
       Thread.sleep(3000);
       WebElement pro = driver.findElement(By.xpath("//a[contains(text(),'NAPA Premium Brake Pads Ceramic>')]"));
       WebElement costTwo = driver.findElement(By.xpath("//span[@id='ctl00_mainContentPlaceHolder_shoppingCartGridView1_ctl02_listPricesCostLabel']"));
       String strPrice = costTwo.getText(); 
       if (pro.isDisplayed() & strPrice.equalsIgnoreCase("$117.74")) {
    	   System.out.println("Product and price are successfully displayed after the checkout");
		
	}
       Thread.sleep(3000);
       driver.manage().deleteAllCookies();
driver.quit();

	}
	
}
