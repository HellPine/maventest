package main.java;

import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.text.*; 

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import javax.swing.*;


public class meollo {

	
	private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp(String url) throws Exception {

	    //driver.quit();
		driver = new FirefoxDriver();
	   //baseUrl = "http://okbingo.stminver-demo.com/okbingo/bingo/corporate/responsible-gaming/2983/responsible-gaming.thtml";
	    //baseUrl="http://uk.vipcasinoclub.co.uk/vipcasinoclub/casino/corporate/info/responsible-gaming/";
	    //baseUrl="http://uk.slotmine.com/slotmine/casino/corporate/info/responsible-gaming/8539/responsible-gaming.thtml";
	    //baseUrl="http://uk.slotsngames.co.uk/slotsandgames/casino/corporate/info/responsible-gaming/8539/responsible-gaming.thtml";
	    //baseUrl="https://www.pokerheaven.es/es/casino/responsible-gaming";
	    //baseUrl="http://www.club3000livebingo.com/club3000bingo/bingo/corporate/responsible-gaming/2983/responsible-gaming.thtml";
	    //baseUrl="http://www.lovebingo.co.uk/lovebingo/bingo/corporate/responsible-gaming/5842/responsible-gaming.thtml";
	    //baseUrl="https://casino-v2.st-minver.com/slotsandgames/casino/corporate/info/responsible-gaming/8539/responsible-gaming.thtml";
		//baseUrl="http://www.gmail.com";
		baseUrl=url;
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    testGmail();
	  }

	  @Test
	  public void testGmail() throws Exception {

		System.out.println("Starting test execution!!");
		driver.get(baseUrl);
		System.out.println("Page title is: " + driver.getTitle());
	    driver.findElement(By.id("Email")).clear();
	    driver.findElement(By.id("Email")).sendKeys("as@as.com");
	    driver.findElement(By.id("Passwd")).clear();
	    driver.findElement(By.id("Passwd")).sendKeys("aaaaaa");
	    driver.findElement(By.id("signIn")).click();
	    try {
	    	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The username or password you entered is incorrect\\. [\\s\\S]*$"));
	      	}
	    catch (Error e) {
	        verificationErrors.append(e.toString());
	        System.out.println("Something went wrong!!");
	    	}
	    File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile1, new File("./target/screenshots/image_" + (new Date().getTime()) + ".png"));
	    Thread.sleep(2000);
	    System.out.println("Works perfectly!!");

	    driver.get(baseUrl);
	    //driver.findElement(By.id("Email")).clear();
	    //driver.findElement(By.id("Email")).sendKeys("as@as.com");
	    //driver.findElement(By.id("Passwd")).clear();
	    //driver.findElement(By.id("Passwd")).sendKeys("aaaaaa");
	    //driver.findElement(By.id("signIn")).click();
	    // Warning: assertTextPresent may require manual changes
	    //assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The username or password you entered is incorrect\\. [\\s\\S]*$"));
	    // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
	    // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot | c:\Temp\xxx_${timestamp}.jpg | ]]
	    //System.out.println("Works perfectly!!");
	    
	   List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'articlecontainer') or contains(@class,'content') or contains(@id,'content')]"));
	   String tocheck="";
	   if(elements.size()>0){
		   
		   System.out.print(elements.size()+"\n");
		   //int i=0;
		   
		   for (WebElement we: elements){ 
			   if(! we.getText().equals(" ")){
			   tocheck=tocheck+"--------------------<p>"; 
				tocheck=tocheck+we.getText()+"<p>";}
				
		   }
			
		   System.out.print(tocheck);//: elements){
		   
		   
			   //System.out.print(i+"\n");
			   //System.out.print(we.getText());
			 //  i++;
			   //System.out.print(elements.toString());
			   
		   
		   
	   }
	   Date date = new Date();
	   SimpleDateFormat lt = 
	   new SimpleDateFormat ("dd.MM.yyyy.hh.mm.ss");
	   File file = new File("report"+lt.format(date)+".html");
	   FileWriter write = new FileWriter(file,true);
	   SimpleDateFormat ft = 
			   new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
	   write.write("<html><head> Report of "+ ft.format(date) + "</head><body>"+ tocheck +"</body></html>");
	   
	   write.close();
	   	   
	   driver.close();
	   driver.quit();
	   //System.exit(0);
	   return;


	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	
	//public void writehola(){
		
		
		//System.out.println("Hola");
	//}
	
	
	
	
}

