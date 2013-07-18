package test.java;

import main.java.meollo;
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import javax.swing.*;

public class mainTest {
	
	
	@Test
	public void main() throws Exception{
		
		
		meollo me = new meollo();
				
		
		
		//int num1=Integer.valueOf(System.getProperty("num1"));
		String url=String.valueOf(System.getProperty("url"));
		//System.out.println(num1);
		//System.out.println("Adios");
		me.setUp(url);
		//System.exit(0);
				
		
				
		
	}

}
