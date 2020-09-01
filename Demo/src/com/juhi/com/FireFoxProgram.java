package com.juhi.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxProgram {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "//Users//nirpekshtomar//Documents//Workspace_Juhi//geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
	}

}
