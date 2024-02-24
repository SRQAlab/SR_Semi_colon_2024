package psl.espn.library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import psl.espn.config.Startup;

public class Utility {

	public void isElementPresent(WebElement ele, int time) {

		for (int i = 0; i < time; i++) {
			try {

				if (ele.isDisplayed()) {
					System.out.println("Element displayed" + ele);
					break;
				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}

		}

	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			String dest = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + ".png";

			File destination = new File(dest);

			FileUtils.copyFile(source, destination);

			System.out.println("Screenshot taken");
			System.out.println(dest);
			return dest;
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
			return e.getMessage();
		}

	}
	

	public static void saveConsoleLogsToFile() {
	        // Get browser console logs
	        LogEntries logEntries = Startup.wd.manage().logs().get(LogType.BROWSER);

	        // Write logs to file
	        File logFile = new File("console_logs.txt");
	        try {
	            BufferedWriter writer = logFile.exists() ? new BufferedWriter(new FileWriter(logFile, true)) : new BufferedWriter(new FileWriter(logFile));
	            for (LogEntry entry : logEntries) {
	                writer.write(entry.getLevel() + " " + entry.getMessage()+ " " + entry.getTimestamp());
	                writer.newLine();
	            }
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	public static void saveLogsToFile() {
	        // Get browser console logs
	        LogEntries logEntries = Startup.wd.manage().logs().get(LogType.BROWSER);

	        // Write logs to file
	        File logFile = new File("browser_logs.txt");
	        try {
	            BufferedWriter writer = logFile.exists() ? new BufferedWriter(new FileWriter(logFile, true)) : new BufferedWriter(new FileWriter(logFile));
	            for (LogEntry entry : logEntries) {
	                writer.write(entry.toString()+"========"+entry.toJson()+"========");
	                writer.newLine();
	            }
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	public static void saveNetworkLogsToFile() {
		 
		Object netData = ((JavascriptExecutor)Startup.wd).executeScript("return window.performance.getEntries();", Startup.wd.getCurrentUrl());
			
		File logFile = new File("network_logs.txt");
        try {
            BufferedWriter writer = logFile.exists() ? new BufferedWriter(new FileWriter(logFile, true)) : new BufferedWriter(new FileWriter(logFile));
            writer.write(netData.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//	        // Get network logs
//	        Network.getAllEvents().forEach(event -> {
//	            if (event instanceof NetworkEvent) {
//	                NetworkEvent networkEvent = (NetworkEvent) event;
//	                System.out.println(networkEvent.toString());
//	            }
//	        });
//
//	        // Write logs to file
//	        File logFile = new File("browser_network_logs.txt");
//	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile))) {
//	            Network.getAllEvents().forEach(event -> {
//	                if (event instanceof NetworkEvent) {
//	                    NetworkEvent networkEvent = (NetworkEvent) event;
//	                    try {
//	                        writer.write(networkEvent.toString());
//	                        writer.newLine();
//	                    } catch (IOException e) {
//	                        e.printStackTrace();
//	                    }
//	                }
//	            });
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
		 
		 
	    }
	
	
}