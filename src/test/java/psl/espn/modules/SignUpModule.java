package psl.espn.modules;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import psl.espn.config.Startup;
import psl.espn.config.baseclass;
import psl.espn.library.Utility;
import psl.espn.pages.homepage;
import psl.espn.pages.loginPage;
import psl.espn.pages.profilePage;
import psl.espn.results.HTMLReportGenerator;

public class SignUpModule {

	final static Logger logger = Logger.getLogger(SignUpModule.class);

	String screenshot_path;

	@Test
	@Parameters({ "loginusername", "loginfirstname", "loginlastname", "loginnewpassword", "cityname", "statename" })
	public void CreateAccount(String loginusername, String loginfirstname, String loginlastname,
			String loginnewpassword, String cityname, String statename) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		Thread.sleep(2000);
		hm.clickSignUpButton();
		lp.enterEmailInput(loginusername);
		lp.clickContinueButton();
		Thread.sleep(1000);
		lp.enterFirstName(loginfirstname);
		Thread.sleep(100);
		lp.enterLastName(loginlastname);
		Thread.sleep(100);
		lp.enterNewPassword(loginnewpassword);
		Thread.sleep(100);
		lp.clickCreateAccountButton();
		Thread.sleep(10000);
		hm.clickProfileImage();
		hm.clickESPNProfileLink();
		profilePage pp = new profilePage(Startup.wd);
		pp.verifyProfileEmail(loginusername);
		Thread.sleep(5000);
		pp.clickOTPCancelButton();
		Thread.sleep(5000);
		pp.verifyProfileFirstName(loginfirstname);
		pp.verifyProfilelastName(loginlastname);
		pp.verifyProfileCountry();
		pp.EditAddressBook();
		Thread.sleep(5000);
		pp.addCityInput(cityname);
		pp.addStateInput(statename);
		pp.clickSaveAddressButton();
		pp.clickEmailPreferenceLink();
		ArrayList<String> tabs = new ArrayList<String>(Startup.wd.getWindowHandles());
		Startup.wd.switchTo().window(tabs.get(1));
		Thread.sleep(20000);
		pp.clickUnsubscribeButton();
		Thread.sleep(5000);
		pp.clickSaveEmailPreferenceButton();
		Startup.wd.close();
		Startup.wd.switchTo().window(tabs.get(0));
		pp.clickAccountDeleteLink();
		pp.clickConfirmDeleteButton();
		Thread.sleep(1000);
	}

	@Test
	@Parameters({ "loginusername", "loginfirstname", "loginlastname", "loginpassword", "cityname", "statename" })
	public void AddressBook(String loginusername, String loginfirstname, String loginlastname, String loginpassword,
			String cityname, String statename) throws Exception {

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
		Thread.sleep(10000);
		hm.clickProfileImage();
		hm.clickESPNProfileLink();
		Thread.sleep(10000);
		profilePage pp = new profilePage(Startup.wd);
		pp.verifyProfileEmail(loginusername);
		Thread.sleep(5000);
		pp.clickOTPCancelButton();
		Thread.sleep(5000);
		pp.verifyProfileFirstName(loginfirstname);
		pp.verifyProfilelastName(loginlastname);
		pp.verifyProfileCountry();
		pp.EditAddressBook();
		Thread.sleep(5000);
		pp.addCityInput(cityname);
		pp.addStateInput(statename);
		pp.clickSaveAddressButton();
		pp.clickDoneButton();
	}

	@Test
	@Parameters({ "loginusername", "loginpassword" })
	public void SignInDeletedAccount(String loginusername, String loginpassword) throws Exception {

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
		Thread.sleep(1000);
		lp.verifyDelAccountloginError();
		lp.clickCloseButton();
	}

	@Test
	@Parameters({ "loginusername", "loginfirstname", "loginlastname", "loginnewpassword" })
	public void SignUpInvalidUser1(String loginusername, String loginfirstname, String loginlastname,
			String loginnewpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		hm.clickSignUpButton();
		lp.enterEmailInput(loginusername);
		lp.clickContinueButton();
		lp.verifyEmailError();
		lp.clickCloseButton();
		
		Utility.saveConsoleLogsToFile();
		Utility.saveLogsToFile();
		Utility.saveNetworkLogsToFile();
	}

	@Test
	@Parameters({ "loginusername", "loginfirstname", "loginlastname", "loginnewpassword" })
	public void SignUpInvalidUser2(String loginusername, String loginfirstname, String loginlastname,
			String loginnewpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		hm.clickSignUpButton();
		lp.enterEmailInput(" ");
		lp.clickContinueButton();
		lp.verifyErrorMessage();
		lp.clickCloseButton();
	}

	@Test
	@Parameters({ "loginusername", "loginfirstname", "loginlastname", "loginnewpassword" })
	public void SignUpInvalidFirstName(String loginusername, String loginfirstname, String loginlastname,
			String loginnewpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		hm.clickSignUpButton();
		lp.enterEmailInput(loginusername);
		lp.clickContinueButton();
		lp.enterFirstName(loginfirstname);
		lp.clickCreateAccountButton();
		lp.verifyFirstNameError();
		lp.verifyLastNameError();
		lp.verifyNewPasswordError();
		lp.clickCloseButton();
	}

	@Test
	@Parameters({ "loginusername", "loginfirstname", "loginlastname", "loginnewpassword" })
	public void SignUpInvalidPassword1(String loginusername, String loginfirstname, String loginlastname,
			String loginnewpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		hm.clickSignUpButton();
		lp.enterEmailInput(loginusername);
		lp.clickContinueButton();
		lp.enterFirstName(loginfirstname);
		lp.enterLastName(loginlastname);
		lp.enterNewPassword(loginnewpassword);
		lp.clickCreateAccountButton();
		lp.verifyShortPasswordError();
		lp.clickCloseButton();
	}

	@Test
	@Parameters({ "loginusername", "loginfirstname", "loginlastname", "loginnewpassword" })
	public void SignUpInvalidPassword2(String loginusername, String loginfirstname, String loginlastname,
			String loginnewpassword) throws Exception {
		Thread.sleep(10000);
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		homepage hm = new homepage(Startup.wd);
		hm.clickProfileImage();
		hm.clickSignUpButton();
		lp.enterEmailInput(loginusername);
		lp.clickContinueButton();
		lp.enterFirstName(loginfirstname);
		lp.enterLastName(loginlastname);
		lp.enterNewPassword(loginnewpassword);
		lp.clickCreateAccountButton();
		lp.verifyNewPasswordError1();
		lp.verifyNewPasswordError2();
		lp.verifyNewPasswordError3();
		lp.clickCloseButton();
	}

	@AfterTest
	public void tearDown() {
		Utility.saveConsoleLogsToFile();
		Utility.saveLogsToFile();
		Utility.saveNetworkLogsToFile();
		// Close the browser after the test
		Startup.wd.quit();
	}

}
