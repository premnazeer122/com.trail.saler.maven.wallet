package CTwallet.touriz.wholesaler.trail.mavenCTwallet;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FundTransfer_CTwallet {

	WebDriver driver;
	By Email = By.xpath("//input[@ name='emailId']");
	By Password = By.xpath("//input[@name='password']");
	By showpassword = By.xpath("//span[@class='input-group-text show-password']");
	By Signin = By.xpath("//button[@type='submit']");
	By Signup = By.linkText("Sign Up");
	By forgotPassword = By.linkText("Click Here");
	By Signout = By.linkText("Signout");

	By FundTransfer = By.xpath("//p[contains(text(),'Fund Transfer')]");
	By SelectRecipient = By.xpath("//select[@name='recipients_wallet_id']");

	@BeforeMethod
	public void Ctwallet_Login() throws InterruptedException {

		String url = "http://trial.wholesaler.touriz.net/ctwallet/";
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\CTRSAutomation\\chromedriver.exe");
		System.out.println("Chrome driver is selected and started");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(2500L);
		System.out.println("Welcome to CTwallet login page");
		driver.findElement(Email).click();
		driver.findElement(Email).clear();
		driver.findElement(Email).sendKeys("saaraghagent199@gmail.com");
		driver.findElement(Password).click();
		driver.findElement(Password).clear();
		driver.findElement(Password).sendKeys("admin123");
		driver.findElement(showpassword).click();
		Thread.sleep(999L);
		driver.findElement(showpassword).click();
		driver.findElement(Signin).click();

	}

	@Test
	public void FundTransfer() throws InterruptedException {
		System.out.println("current Url is =" + driver.getCurrentUrl());
		driver.findElement(FundTransfer).click();
		String menutxt = driver.findElement(FundTransfer).getText();
		System.out.println("menu is :" + menutxt);
		System.out.println(menutxt + "is clicked in Ctwallet application");
		
		WebElement Recipientname = driver.findElement(SelectRecipient);
		Select getlistofrecippient = new Select(Recipientname);
		List<WebElement> recipient_list = getlistofrecippient.getOptions();
		int recipient_Count = recipient_list.size();
		System.out.println("<<<Recipient Name List>>>\n\n" + "Count of Recipient List : " + recipient_Count + "\n");
		Random recipient_name = new Random();
		int iSelect = recipient_name.nextInt(recipient_Count);
		getlistofrecippient.selectByIndex(iSelect);
		System.out.println("Recipient dropdown list name:" + Recipientname.getAttribute("value") + "\n\n");
		Recipientname.click();
		Thread.sleep(2500L);
		
	}

	@AfterMethod
	public void logout_Ctwallet() throws InterruptedException {
		Thread.sleep(999L);
		driver.findElement(Signout).click();
		System.out.println("Signed out Successfully from CTwallet");
		driver.quit();
	}
}
