package com.hpractice.in;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmzMenulink {

	public WebDriver d;
	public WebElement menu1;
	String homeTitle;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",  "E:\\Upgraded_sel\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		d= new ChromeDriver(opt);
		d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void statusCheck1() {
		System.out.println("Next test is executing now....");
	}
	
	@AfterMethod
	public void statusCheck2() {
		System.out.println("Execution is completed for the current test..");
	}
	
	@Test(priority=1)
	public void launchSite() {
		d.navigate().to("https://www.amazon.in");
		d.manage().window().maximize();
		homeTitle = d.getTitle();
		System.out.println("Title of the page : "+homeTitle);
	}
	
	@Test(priority=2)
	public void menuLink() throws InterruptedException {
		menu1 = d.findElement(By.linkText("Amazon Pay"));
		menu1.click();
		String pagenm = d.getTitle();
		System.out.println("Title of the page : "+pagenm);
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	public void homeAgain() {
		d.navigate().back();
		String checkp = d.getTitle();
		System.out.println("Title of the page : "+checkp);
		if(homeTitle.matches(checkp)==true) {
			System.out.println("Page titles are matching.");
		}
		else {
			System.out.println("Page titles does not match.");
		}
			
	}
	
}
