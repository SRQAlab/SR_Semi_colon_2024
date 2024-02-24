package psl.espn.config;


import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import psl.espn.config.PropertiesFileReader;

public class baseclass {
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;
	
	
	public static PropertiesFileReader pfr=new PropertiesFileReader("parameters");
	
	public static String NormalizeString(String ParameterName) 
	{
		try
		{
	
			return pfr.GetParameterValue(ParameterName);
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	
	
	
	
}
