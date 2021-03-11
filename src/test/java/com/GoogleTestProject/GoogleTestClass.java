package com.GoogleTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTestClass {
  
   public static WebDriver driver;
	    
	@BeforeMethod
	public void environmentSetup() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
	}
	
	
  @Test(groups = {"smoketest"})
  public void verifyImagesLink() {
	  
	  WebElement imageLink = driver.findElement(By.linkText("Images"));
	  imageLink.isDisplayed();
  }

  @Test(groups = {"smoketest"})
  public void verfifyGmailLink() {
	  WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
	  gmailLink.isDisplayed();	
  }
  
  
  @Test(groups= {"regressiontest"})
  public void verifySearchBox() {
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.isDisplayed();
  }
  
  @AfterMethod
  public void closeBrowser() {
	  driver.close();
  }
  
}
