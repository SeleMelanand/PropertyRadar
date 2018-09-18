package com.propertyradar.phonenumbercollection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Rebomarketingdata extends Loginpropertyradar {

	@Test
	public void robodataretrieval() throws InterruptedException {
		login();
		launchrebogaetway();

		driver.findElementByXPath("//a[text()='Leads / Farms']").click();
		System.out.println("Navigated to correct page");
		Thread.sleep(15000);
		
		Select county = new Select(driver.findElementById("county_options"));
		county.selectByVisibleText("Los Angeles, CA");

		//driver.findElementById("lead_type_options").sendKeys("Affidavit", Keys.TAB);;
		Thread.sleep(5000);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElementById("lead_type_options")).click().build().perform();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//select[@id='lead_options']/optgroup[1]/option[1]").click();
	
		Thread.sleep(3000);
		driver.findElementById("offer_from_date").clear();
		driver.findElementById("offer_from_date").sendKeys("05/07/2018");
		Thread.sleep(3000);
		
		driver.findElementById("offer_to_date").clear();
		driver.findElementById("offer_to_date").sendKeys("05/13/2018");
		Thread.sleep(3000);
		
		driver.findElementByName("search_list").click();

		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.elementToBeClickable(driver.findElementById("no_filter_search")));

		driver.findElementById("rebo_marketing_button").click();
		wait2.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//ul[contains(@class,'current_transaction_menu_bar')]/li[2]")));
		
		driver.findElementByXPath("//ul[contains(@class,'current_transaction_menu_bar')]/li[2]/a").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//img[@id='export_csv']").click();
		
		

		/*
		 * List<WebElement> countydetails = county.getOptions(); for(int
		 * i=0;i<countydetails.size();i++){ county.selectByIndex(i);
		 * 
		 * 
		 * 
		 * }
		 */

	}

	public void exceldata() throws IOException {
		FileInputStream fis = new FileInputStream(".//testdata/Rebomarketingdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet worksheet = workbook.getSheet("Sheet1");
		int rowcount = worksheet.getLastRowNum() + 1;

		for (int i = 0; i <= rowcount - 1; i++) {
			String cellvalue = worksheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(cellvalue);
			al.add(cellvalue);
		}

	}

}
