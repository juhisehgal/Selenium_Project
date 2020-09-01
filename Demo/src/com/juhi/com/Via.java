package com.juhi.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Via {

	public static void main(String[] args) throws Exception {
System.setProperty("webdriver.chrome.driver", "//Users//nirpekshtomar//Documents//Workspace_Juhi//chromedriver");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://in.via.com/");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("//Users//nirpekshtomar//Documents//Workspace_Juhi//Demo//src//com//ObjectRepo//Mahape//ObjectRepo.properties");
	//	System.out.println(fis.get);
		prop.load(fis);
		
		driver.findElement(By.cssSelector(prop.getProperty("Source"))).sendKeys("m");
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SourceTable"))));
		
		 List<WebElement> sourceCities=driver.findElements(By.xpath(prop.getProperty("FromList")));
		 System.out.println("total cities are "+sourceCities.size());
		 for(int i=0;i<sourceCities.size();i++)
		 {
			 if(sourceCities.get(i).getText().contains("MAA"))
			 {
				 sourceCities.get(i).click();
			 }
		 }
		 driver.findElement(By.id(prop.getProperty("Destination"))).sendKeys("a");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("DestinationTable"))));
		List<WebElement> destCities= driver.findElements(By.xpath(prop.getProperty("ToList")));
		
		for(int i=0;i<destCities.size();i++)
		{
			if(destCities.get(i).getText().contains("AMD"))
			{
				destCities.get(i).click();
			}
		}
		
	/*	
		for(int i=0;i<4;i++)
		{
			driver.findElement(By.xpath(prop.getProperty("Adult"))).click();
		}
		System.out.println("total adult count is "+driver.findElement(By.xpath(prop.getProperty("AdultCount"))).getText());
		driver.close();  */
		

	}

}
