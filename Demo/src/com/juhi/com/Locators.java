package com.juhi.com;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

	public static void main(String[] args) throws Exception{
System.setProperty("webdriver.chrome.driver", "//Users//nirpekshtomar//Documents//Workspace_Juhi//chromedriver");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("//Users//nirpekshtomar//Documents//Workspace_Juhi//Demo//src//com//ObjectRepo//Mahape//ObjectRepo.properties");
	
		prop.load(fis);
		System.out.println(driver.findElement(By.xpath(prop.getProperty("ONGC"))).getText());
		
		List<WebElement> alist=driver.findElements(By.xpath(prop.getProperty("CompaniesList")));
		for(int i=0;i<alist.size();i++)
		{
			System.out.println(alist.get(i).getText());
		}
		
		
	}

}
