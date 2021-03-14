package com.hpractice.in;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googleSearch {

	public WebDriver d;
	public WebDriverWait w;
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",  "E:\\Upgraded_sel\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		d= new ChromeDriver(opt);
		d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void searchMethod() {
		d.navigate().to("https://www.google.co.in/");
		WebElement srch = d.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input"));
		srch.sendKeys("selenium");
		
		w = new WebDriverWait(d,120);
		w.until(ExpectedConditions.presenceOfElementLocated(By.className("aajZCb")));
		
		WebElement list = d.findElement(By.className("WebDriverWait w "));
		
		
	}
}
