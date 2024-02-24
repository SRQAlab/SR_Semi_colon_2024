package psl.espn.modules;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import psl.espn.config.Startup;
import psl.espn.config.baseclass;
import psl.espn.library.ExcelDataConfig;
import psl.espn.library.Utility;
import psl.espn.pages.espnCricInfo;
import psl.espn.pages.homepage;
import psl.espn.pages.loginPage;
import psl.espn.pages.profilePage;
import psl.espn.results.HTMLReportGenerator;

public class loginModule {

	final static Logger logger = Logger.getLogger(loginModule.class);

	String screenshot_path;

	@DataProvider(name = "espntestdata")
	public Object[][] passData() {

		ExcelDataConfig config = new ExcelDataConfig(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel_Operations.xlsx");
		int rows = config.getRowCount(0);
		System.out.println(rows);
		Object[][] data = new Object[rows][2];
		for (int i = 0; i < rows; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
		}

		System.out.println(data);
		return data;
	}

	@Test
	@Parameters({ "loginusername", "loginpassword" })
	public void loginAddFav(String loginusername, String loginpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		Thread.sleep(5000);
		hm.clickLogIn();
		loginPage lp2 = new loginPage(Startup.wd);
		lp2.enterEmailInput(loginusername);
		lp2.clickContinueButton();
		lp2.enterPassword(loginpassword);
		lp2.clickLogInButton();
		String title = hm.verifytitle();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "verifytitle");

		if (title.equalsIgnoreCase("ESPN India - Serving Sports Fans. Anytime. Anywhere.")) {
			System.out.println("Title is verified : " + title);
			logger.info("Title is verified : " + title);
			HTMLReportGenerator.StepDetails("PASS",
					(Startup.counter++) + " - Title is verified successfully: " + title + "",
					"Application title should be correct ", "" + screenshot_path + "");
		} else {
			System.out.println("Title is not correct");
			logger.error("Title is not correct");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + " - Title is not verified : " + title + "",
					"Application title should be correct ", "" + screenshot_path + "");
		}
		Thread.sleep(10000);
		hm.clickAddFavLink();
		Thread.sleep(10000);
		hm.enterFavSearchInput("India ");
		hm.clickSignOut();
	}

	@Test
	@Parameters({ "loginusername", "loginpassword" })
	public void GlobalSearch(String loginusername, String loginpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		Thread.sleep(5000);
		hm.clickLogIn();
		lp = new loginPage(Startup.wd);
		lp.enterEmailInput(loginusername);
		lp.clickContinueButton();
		lp.enterPassword(loginpassword);
		lp.clickLogInButton();
		String title = hm.verifytitle();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "verifytitle");

		if (title.equalsIgnoreCase("ESPN India - Serving Sports Fans. Anytime. Anywhere.")) {
			System.out.println("Title is verified : " + title);
			logger.info("Title is verified : " + title);
			HTMLReportGenerator.StepDetails("PASS",
					(Startup.counter++) + " - Title is verified successfully: " + title + "",
					"Application title should be correct ", "" + screenshot_path + "");
		} else {
			System.out.println("Title is not correct");
			logger.error("Title is not correct");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + " - Title is not verified : " + title + "",
					"Application title should be correct ", "" + screenshot_path + "");
		}
		Thread.sleep(10000);
		hm.clickGlobalSearch();
		hm.clickGlobalSearchInput();
		hm.verifyGlobalSearchResult();
	}

	@Test(dataProvider = "espntestdata", enabled = true)
	@Parameters({ "loginusername", "loginpassword" })
	public void invalidLogin(String loginusername, String loginpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		Thread.sleep(1000);
		hm.clickLogIn();
		Thread.sleep(1000);
		loginPage lp2 = new loginPage(Startup.wd);
		lp2.enterEmailInput(loginusername);
		lp2.clickContinueButton();
		Thread.sleep(1000);
		lp2.verifyEmailError();
		lp2.clickCloseButton();
		Startup.wd.get("https://www.espn.in");
	}

	@Parameters({ "loginusername", "loginpassword" })
	public void invalidLogin1(String loginusername, String loginpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		Thread.sleep(1000);
		hm.clickLogIn();
		Thread.sleep(1000);
		loginPage lp2 = new loginPage(Startup.wd);
		//if (loginusername != null || loginusername != " ") {
		if (loginusername.equals("") || loginusername.equals(" ")) {
			String ParameterName = "loginusername";
			loginusername = baseclass.NormalizeString(ParameterName);

			lp2.enterEmailInput(loginusername);
		} else {
			lp2.enterEmailInput(loginusername);

		}
		lp2.clickContinueButton();
		Thread.sleep(1000);
		lp2.verifyEmailError();
		lp2.clickCloseButton();
	}

	@Test
	@Parameters({ "loginusername", "loginpassword" })
	public void invalidLogin2(String loginusername, String loginpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		Thread.sleep(1000);
		hm.clickLogIn();
		loginPage lp2 = new loginPage(Startup.wd);
		lp2.enterEmailInput(" ");
		lp2.clickContinueButton();
		Thread.sleep(1000);
		lp2.verifyErrorMessage();
		lp2.clickCloseButton();
	}

	@Test
	@Parameters({ "loginusername", "loginpassword" })
	public void invalidLogin3(String loginusername, String loginpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		Thread.sleep(1000);
		hm.clickLogIn();
		loginPage lp2 = new loginPage(Startup.wd);
		lp2.enterEmailInput("QASwanand@yahoo.com");
		lp2.clickContinueButton();
		Thread.sleep(1000);

		//if (loginpassword != null || loginpassword != " ") {
		if (loginpassword.equals("") || loginpassword.equals(" ")) {
			String ParameterName = "loginpassword";
			loginpassword = baseclass.NormalizeString(ParameterName);
			lp2.enterPassword(loginpassword);
		} else {
			lp2.enterPassword(loginpassword);
		}
		lp2.clickLogInButton();
		Thread.sleep(1000);
		lp2.verifyPasswordError();
		lp2.clickCloseButton();
	}

	@Test
	@Parameters({ "loginusername", "loginpassword" })
	public void invalidLogin4(String loginusername, String loginpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		Thread.sleep(1000);
		hm.clickLogIn();
		loginPage lp2 = new loginPage(Startup.wd);
		lp2.enterEmailInput("QASwanand@yahoo.com");
		lp2.clickContinueButton();
		Thread.sleep(1000);
		lp2.enterPassword(" ");
		lp2.clickLogInButton();
		Thread.sleep(1000);
		lp2.verifyErrorMessage();
		lp2.clickCloseButton();
	}

	@Test
	@Parameters({ "loginusername", "loginfirstname", "loginlastname", "loginpassword", "mobno" })
	public void verifyInvalidMobile(String loginusername, String loginfirstname, String loginlastname,
			String loginpassword, String mobno) throws Exception {

		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		Thread.sleep(5000);
		hm.clickLogIn();
		lp = new loginPage(Startup.wd);
		lp.enterEmailInput(loginusername);
		lp.clickContinueButton();
		lp.enterPassword(loginpassword);
		lp.clickLogInButton();
		Thread.sleep(10000);
		hm.clickProfileImage();
		hm.clickESPNProfileLink();
		Thread.sleep(2000);
		profilePage pp = new profilePage(Startup.wd);
		pp.enterMobileInput(mobno);
		lp.clickCreateAccountButton();
		pp.verifyMobileError();
		lp.clickCloseButton();
	}

	@Test
	@Parameters({ "loginusername", "loginpassword" })
	public void verifyTopSection(String loginusername, String loginpassword) throws Exception {

		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		Thread.sleep(30000);
		hm.clickTopEvents();
		Thread.sleep(30000);
		hm.verifyTopEventResult();
		Thread.sleep(30000);
	}

	@Test
	@Parameters({ "loginusername", "loginpassword" })
	public void verifyESPNCricInfoLink(String loginusername, String loginpassword) throws Exception {

		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		Thread.sleep(10000);
		hm.clickMainMenu();
		Thread.sleep(10000);
		hm.clickESPNCricInfoLink();
		Thread.sleep(30000);
		espnCricInfo ci = new espnCricInfo(Startup.wd);
		ci.clickCancelButton();
		Thread.sleep(10000);
		ci.clickTeamsMenu();
		ci.clickResults();
		ci.getResult();
	}

	@Test
	@Parameters({ "loginusername", "loginpassword" })
	public void verifyESPNCricInfoSearch(String loginusername, String loginpassword) throws Exception {

		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		Thread.sleep(10000);
		hm.clickMainMenu();
		Thread.sleep(10000);
		hm.clickESPNCricInfoLink();
		Thread.sleep(30000);
		espnCricInfo ci = new espnCricInfo(Startup.wd);
		ci.clickCancelButton();
		Thread.sleep(10000);
		ci.clickSearchIcon();
	}

	@AfterTest
	public void tearDown() {
		
		Utility.saveConsoleLogsToFile();
		Utility.saveLogsToFile();
		// Close the browser after the test
		Startup.wd.quit();
	}

}
