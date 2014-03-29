package com.qa.test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import org.testng.reporters.XMLReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class CareFirst {
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	
	
 @Test
 public void f() throws Exception {
	  
	  driver.get(baseUrl + "/individuals/home.page");
	    //test for change
	   // Actions action = new Actions(driver);C:\Users\parviz\.jenkins\jobs\CareFirst\workspace\test-output
	    
	   
	    
	    driver.findElement(By.cssSelector("#main-nav>ul:nth-child(1)>li:nth-child(5)>a:nth-child(1)>div:nth-child(1)")).click();
	    driver.findElement(By.cssSelector("#main-nav >ul:nth-child(1)>li:nth-child(5)>div:nth-child(2)>div:nth-child(5)>ul:nth-child(1)>li:nth-child(2)>a:nth-child(1)")).click(); 
	    Thread.sleep(3000);
	    String oldTab = driver.getWindowHandle();
	    System.out.println(oldTab);
	    driver.findElement(By.linkText("Find a Provider")).click();
	    
	    //driver.switchTo().window(title);
	   //
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	   
	    System.out.println(newTab);  
	    //System.out.println("new Tab");
	    driver.findElement(By.xpath(".//*[@id='Point of Service (POS)']/div[2]/input")).click();
	    Thread.sleep(4000);
	    //driver.findElement(By.cssSelector("#btnContinue > span")).click();
	    driver.findElement(By.id("zipCode")).clear();
	    driver.findElement(By.id("zipCode")).sendKeys("20853");
	    driver.findElement(By.id("primaryCare")).click();
	    driver.findElement(By.cssSelector("#step2Continuebtn > span")).click();
	    AssertJUnit.assertEquals("Cho, Yoon J, DO", driver.findElement(By.linkText("Cho, Yoon J, DO")).getText());
	    //if we want to switch to previous page
	    driver.switchTo().window(oldTab);
	    
	    driver.findElement(By.cssSelector("#main-nav > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1) > div:nth-child(1)")).click();
	    
	    driver.findElement(By.cssSelector("#main-nav>ul:nth-child(1)>li:nth-child(6)>div:nth-child(2)>div:nth-child(5)>ul:nth-child(1)>li:nth-child(2)>a:nth-child(1)")).click();
	    //String pcmh = driver.findElement(By.cssSelector("h1")).getText();
	    //System.out.println(pcmh);
	    
	    try {
	        AssertJUnit.assertEquals("About Patient-Centered Medical Home (PCMH)", driver.findElement(By.cssSelector("h1")).getText());
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	      }    
	     //assertEquals("What is PCMH?",driver.findElement(By.linkText("What is PCMH?")).getText());
	   // assertEquals("What is PCMH?", driver.findElement(By.xpath(".//*[@id='1383943815442']/h2/text()")).getText());
	       
	  
	  
 }
 @BeforeMethod
 public void beforeMethod() {
	  driver = new FirefoxDriver();
	    baseUrl = "https://member.carefirst.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }

 @AfterMethod
 public void afterMethod() {
	  
	  driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      Assert.fail(verificationErrorString);
	    }
 }

}