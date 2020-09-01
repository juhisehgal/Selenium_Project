package com.juhi.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSel {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "//Users//nirpekshtomar//Documents//Workspace_Juhi//chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
	driver.findElement(By.id("email")).sendKeys("hello");
	driver.get("https://www.google.com/");
driver.navigate().back();
System.out.println(driver.getCurrentUrl());
driver.navigate().forward();
System.out.println(driver.getCurrentUrl());

		

	}

}
