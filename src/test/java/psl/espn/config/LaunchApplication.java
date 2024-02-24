package psl.espn.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.bidi.log.LogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import psl.espn.library.Utility;
import psl.espn.results.HTMLReportGenerator;

public class LaunchApplication {

	
	Startup c = new Startup();
	static String screenshot_path;
	public static DevTools devTools;

	@Test
	@Parameters({ "Browser", "url", "filepath", "execute_remotely" })
	public static void launchApp(String Browser, String url, String filepath, String execute_remotely) {


		if (Browser.equals("") || Browser.equals(" ")) {
			String ParameterName = "Browser";
			Browser = baseclass.NormalizeString(ParameterName);
			System.out.println("Browser parameter not given" + Browser);
		} else {						
			System.out.println("~~~~~parameter Browser = " + Browser);			
		}
		
		if (url.equals("") || url.equals(" ")) {
			String ParameterName = "url";
			url = baseclass.NormalizeString(ParameterName);
			System.out.println("url parameter not given" + url);
			
		} else {			
			
			System.out.println("~~~~~parameter url = " + url);			
		}


		try {
			if (Browser.equalsIgnoreCase("firefox")) {

				if (execute_remotely.equalsIgnoreCase("N")) {
					// System.setProperty("webdriver.firefox.marionette",filepath);
					// System.setProperty("webdriver.geckodriver.driver",filepath);
					Startup.wd = new FirefoxDriver();
					screenshot_path = Utility.captureScreenshot(Startup.wd, "firefox");
					HTMLReportGenerator.StepDetails("PASS",
							(Startup.counter++) + " - Launch the " + Browser + " Browser",
							"Browser should get launched", "" + screenshot_path + "");
				} else {
					DesiredCapabilities dc = new DesiredCapabilities("firefox", "any",
							org.openqa.selenium.Platform.WINDOWS);
					Startup.wd = new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"), dc);
				}
			}
		} catch (Exception e) {
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + " - Launch the " + Browser + " Browser",
					"Browser should get launched", "" + screenshot_path + "");
		}

		try {
			if (Browser.equalsIgnoreCase("chrome")) {
				if (execute_remotely.equalsIgnoreCase("N")) {
					// System.setProperty("webdriver.chrome.driver",filepath);
//					Startup.wd = new ChromeDriver();
					
					
					// Set Chrome options to enable logging
//			        ChromeOptions options = new ChromeOptions();
//					options.setCapability("goog:loggingPrefs", "{\"browser\": \"ALL\"}");
//					Startup.wd = new ChromeDriver(options);
					
					ChromeOptions options = new ChromeOptions();    
					LoggingPreferences logPrefs = new LoggingPreferences();
					logPrefs.enable(LogType.BROWSER, Level.ALL);
					options.setCapability("goog:loggingPrefs", logPrefs);
					options.addArguments();
					
					Startup.wd = new ChromeDriver(options);
					
					
					  DevTools devTools = ((ChromeDriver) Startup.wd).getDevTools();
				      devTools.createSession();
				      devTools.send(new Command("Network.enable", ImmutableMap.of()));
				      
		              devTools.addListener(Network.responseReceived(), l -> {
		                  System.out.print("Response URL: ");
		                  System.out.println(l.getResponse().getUrl());
		              });
		              devTools.addListener(Network.requestWillBeSent(), l -> {
		                  System.out.print("Request URL: ");
		                  System.out.println(l.getRequest().getUrl());
		              });
				        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
//				        devTools.addListener(Network.requestWillBeSent(), request -> {
//				            System.out.println("Request Method : " + request.getRequest().getMethod());
//				            System.out.println("Request URL : " + request.getRequest().getUrl());
//				            System.out.println("Request headers: " + request.getRequest().getHeaders().toString());
//				            System.out.println("Request body: " + request.getRequest().getPostData().toString());
//				        });
					
					/*
					// Initialize DevTools
			        devTools = ((ChromeDriver) Startup.wd).getDevTools();
			        devTools.createSession();

			        // Enable network logging
			         devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			         
			         devTools.addListener(Network.requestWillBeSent(), request ->
			         {
			        	 Request req=request.getRequest();
			        	 System.out.println("--"+req.getUrl());
			        	 System.out.println("=="+req.getHeaders());
			         });
			         
			         // Event will get fired
			         
			         devTools.addListener(Network.responseReceived(), response ->
			         {
			        	 Response res=response.getResponse();
			        	 System.out.println("--"+res.getStatus());
			        	 System.out.println("=="+res.getResponseTime());
			         });
					*/
					screenshot_path = Utility.captureScreenshot(Startup.wd, "chrome");
					HTMLReportGenerator.StepDetails("PASS",
							(Startup.counter++) + " - Launch the " + Browser + " Browser",
							"Browser should get launched", "" + screenshot_path + "");

				} else {
					System.out.println("code will soon come here");
					DesiredCapabilities dc = new DesiredCapabilities("chrome", "any",
							org.openqa.selenium.Platform.WINDOWS);
					Startup.wd = new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"), dc);
				}
			}
		}

		catch (Exception e) {
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + " - Launch the " + Browser + " Browser",
					"Browser should get launched", "" + screenshot_path + "");
		}

		try {
			if (Browser.equalsIgnoreCase("IE")) {
				if (execute_remotely.equalsIgnoreCase("N")) {
					// System.setProperty("webdriver.ie.driver",filepath);
					Startup.wd = new InternetExplorerDriver();
					screenshot_path = Utility.captureScreenshot(Startup.wd, "IE");
					HTMLReportGenerator.StepDetails("PASS",
							(Startup.counter++) + " - Launch the " + Browser + " Browser",
							"Browser should get launched", "" + screenshot_path + "");

				} else {
					System.out.println("code will soon come here");
					DesiredCapabilities dc = new DesiredCapabilities("IE", "any", org.openqa.selenium.Platform.WINDOWS);
					Startup.wd = new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"), dc);
				}
			}
		} catch (Exception e) {
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + " - Launch the " + Browser + " Browser",
					"Browser should get launched", "" + screenshot_path + "");
		}

		
		Startup.wd.get(url);
		Startup.wd.manage().window().maximize();
		Startup.wd.manage().getCookies().clear();
		Startup.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		System.out.println("\n~~~~~~ BROWSER LOGS ~~~~~~~~~");
		LogEntries browserLogs = Startup.wd.manage().logs().get(LogType.BROWSER);
		for (org.openqa.selenium.logging.LogEntry entry : browserLogs) {
			System.out.println(entry.getMessage());
		}
		
//		Object netData = ((JavascriptExecutor)Startup.wd).executeScript("return window.performance.getEntries();", Startup.wd.getCurrentUrl());
////		System.out.println(netData.toString().substring(0, 5000));
//		File logFile = new File("network_logs.txt");
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
//            writer.write(netData.toString());
//            writer.newLine();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
		screenshot_path = Utility.captureScreenshot(Startup.wd, "url");
		HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + " - Launch the URL of the Application",
				"User should be able to launch the URL of the Application and application should be on the Login Page",
				"" + screenshot_path + "");
	}

}
