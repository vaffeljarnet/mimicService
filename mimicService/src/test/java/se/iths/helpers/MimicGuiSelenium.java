package se.iths.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MimicGuiSelenium {

	
	private WebDriver webdriver;

	public MimicGuiSelenium() {
		System.setProperty("webdriver.chrome.driver", "commonFiles/webDrivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public MimicGuiSelenium(String browser) {
			webdriver = selectWebDriver(browser);
			webdriver.manage().window().maximize();
			webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void openURL(String siteURL) {
		webdriver.get(siteURL);
	}  
	
	public void sendText(String text) {
		WebElement element = webdriver.findElement(By.xpath("/html/body/form/textarea"));
		element.click();
		delay(2000);
		element.sendKeys(text);	
	}
	
	public void clickLearn() {
		WebElement element = webdriver.findElement(By.cssSelector("#learn"));
		element.click();
	}
	
	public String getValue() {
		WebElement element = webdriver.findElement(By.cssSelector("body"));
		return element.getText();
	}
	
	public void delay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
			}
			catch (InterruptedException a) {
			}
	}
	
	public void quitSelenium() {
		webdriver.quit();
	}
	
	private WebDriver selectWebDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "commonFiles/webDrivers/chromedriver.exe");
			return new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "commonFiles/webDrivers/geckodriver.exe");
			return new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "commonFiles/webDrivers/MicrosoftWebDriver.exe");
			return new EdgeDriver();
		}else {
			return null;
		}
	}
	
}
