package com.juhi.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJet {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "//Users//nirpekshtomar//Documents//Workspace_Juhi//chromedriver");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("//Users//nirpekshtomar//Documents//Workspace_Juhi//Demo//src//com//ObjectRepo//Mahape//ObjectRepo.properties");
	//	System.out.println(fis.get);
		prop.load(fis);
		Thread.sleep(5000);
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(prop.getProperty("DeptCity"))))).click();
		//System.out.println(prop.getProperty("DeptCity"));
		/*driver.findElement(By.id(prop.getProperty("DeptCity"))).click();
		driver.findElement(By.xpath(prop.getProperty("Chennai"))).click();*/
		//driver.findElement(By.id(prop.getProperty(DeptCity))).click();
		//driver.findElement(By.id(prop.getProperty("DeptCity"))).click();
		//driver.findElement(By.xpath(prop.getProperty("DeptCity"))).click();
		driver.findElement(By.xpath(prop.getProperty("Chennai"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(prop.getProperty("Ahmedabad"))))).click();
		String expectedMonth="January";
		
		while(!driver.findElement(By.xpath(prop.getProperty("Month"))).getText().contains(expectedMonth))
		{
			driver.findElement(By.cssSelector(prop.getProperty("nextMonth"))).click();
		}
		
		
		
		//ArrayList<Integer> days=new ArrayList<>();
		int days=driver.findElements(By.xpath(prop.getProperty("MonthDays"))).size();
		System.out.println("total days are "+days);
		for(int i=0;i<days;i++)
		{
			String actualDay=driver.findElements(By.xpath(prop.getProperty("MonthDays"))).get(i).getText();
			//System.out.println(actualDay);
			if(actualDay.equals("14"))
			{
				driver.findElements(By.xpath(prop.getProperty("MonthDays"))).get(i).click();
				break;
			}
		}
		driver.findElement(By.cssSelector(prop.getProperty("AdultTab"))).click();
		Select s=new Select(driver.findElement(By.id(prop.getProperty("SelectAdultTb"))));
		s.selectByVisibleText("4");
		//s.selectByIndex(2);
		//s.deselectByIndex();
		//s.selectByValue("7");
	
		driver.findElement(By.id(prop.getProperty("Search"))).click();
		
		
		
		

	}

}
