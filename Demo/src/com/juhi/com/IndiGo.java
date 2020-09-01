package com.juhi.com;

import java.beans.Visibility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndiGo {

	public static void main(String[] args)  {
		try
		{
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "//Users//nirpekshtomar//Documents//Workspace_Juhi//chromedriver");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goindigo.in/");
		driver.manage().window().maximize();
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("//Users//nirpekshtomar//Documents//Workspace_Juhi//Demo//src//com//ObjectRepo//Mahape//ObjectRepo.properties");
	//	System.out.println(fis.get);
		prop.load(fis);
		Thread.sleep(5000);
		
		Actions a=new Actions(driver);
		
		WebElement ele=driver.findElement(By.cssSelector(prop.getProperty("FromCity")));
		ele.click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty("CityBar"))));
		
		//a.moveToElement(ele).doubleClick().build().perform();
//		ele.sendKeys("AMD");
//		
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.))
		
		
		/*
		 * while(!driver.findElement(By.xpath(prop.getProperty("CityList"))).getText().
		 * contains("AMD")) {
		 * driver.findElement(By.xpath(prop.getProperty("CityList"))).sendKeys(Keys.
		 * ARROW_DOWN); }
		 */
		
		int cities=driver.findElements(By.xpath(prop.getProperty("CityList"))).size();
		System.out.println(cities);
		for(int i=0;i<cities;i++)
		{
			String actualCity=driver.findElements(By.xpath(prop.getProperty("CityList"))).get(i).getText();
			System.out.println(actualCity);
			if(!actualCity.contains("AMD"))
			{
				//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getProperty("CityList"))));
				driver.findElements(By.xpath(prop.getProperty("CityList"))).get(i).sendKeys(Keys.ARROW_DOWN);
				continue;
			}
			driver.findElements(By.xpath(prop.getProperty("CityList"))).get(i).click();
		}
	
		
		}
		catch(FileNotFoundException e) 
		{
			
		}
		
		catch(InterruptedException e)
		{
			
		}
		
		catch(IOException e)
		{
			
		}

}
}
