package com.juhi.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "//Users//nirpekshtomar//Documents//Workspace_Juhi//chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("hello");
		driver.findElement(By.id("pass")).sendKeys("abc");
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).getAttribute("role"));
		
		
	}

}
