package wrapperclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Genericwrappers {
	RemoteWebDriver driver;

	public void launchchrome(String url){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	public void enterbyID(String idname, String idvalue ){
		driver.findElementById(idname).clear();
		driver.findElementById(idname).sendKeys(idvalue);
		
	}
	
	public void enterbyXpath(String xpathname, String xpathvalue ){
		driver.findElementByXPath(xpathname).clear();
		driver.findElementByXPath(xpathname).sendKeys(xpathvalue);
		
	}
	
	public void clickbyXpath(String xpathname){
		driver.findElementByXPath(xpathname).click();
	}
	
	

}
