package ztrialpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Trialclass  {
	
	@DataProvider(name="fetchData")
	public Object[][] getData() throws IOException{
		return Dataprovide.getSheet();		
	}

	
	@Test(dataProvider="fetchData")
	public void samplea( String uname, String email) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://kpntravels.in/frmUserRegistration.aspx");
		driver.findElementById("WebContent_txtUserId").sendKeys(uname);
		driver.findElementById("WebContent_txtMail").sendKeys(email);
	}

}
