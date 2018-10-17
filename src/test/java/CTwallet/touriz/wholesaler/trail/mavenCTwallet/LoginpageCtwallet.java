package CTwallet.touriz.wholesaler.trail.mavenCTwallet;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginpageCtwallet {

	WebDriver driver;
By Email = By.xpath("//input[@ name='emailId']");
By Password = By.xpath("//input[@name='password']");
By showpassword = By.xpath("//span[@class='input-group-text show-password']");
By Signin = By.xpath("//button[@type='submit']");
By Signup = By.linkText("Sign Up");
By forgotPassword = By.linkText("Click Here");
	@Test
	public void Ctwallet_Login() throws InterruptedException {
		Thread.sleep(2500L);
		System.out.println("Welcome to CTwallet login page");
		driver.findElement(Email).click();
		driver.findElement(Email).clear();
		driver.findElement(Email).sendKeys("admin@ctwallet.net");
		driver.findElement(Password).click();
		driver.findElement(Password).clear();
		driver.findElement(Password).sendKeys("admin123");
		driver.findElement(showpassword).click();
		Thread.sleep(999L);
		driver.findElement(showpassword).click();
		driver.findElement(Signin).click();
		
	}
	
	@Test
	public void Ctwallet_sigup() throws InterruptedException{
		Thread.sleep(2000L);
		driver.findElement(Signup).click();
	}
	
	@Test
	public void Ctwallet_forgotpassword() throws InterruptedException{
		Thread.sleep(2000L);
		driver.findElement(forgotPassword).click();
	}
	

	@BeforeMethod
	public void beforeMethod() {
		String url = "http://trial.wholesaler.touriz.net/ctwallet/";
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\CTRSAutomation\\chromedriver.exe");
		System.out.println("Chrome driver is selected and started");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000L);
		driver.quit();
		System.out.println("Login Works as Expected");
	}

}
