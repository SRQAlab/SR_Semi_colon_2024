package psl.espn.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import psl.espn.config.Startup;
import psl.espn.library.Helper;
import psl.espn.library.Utility;
import psl.espn.results.HTMLReportGenerator;

public class loginPage {

	final static Logger logger = Logger.getLogger(loginPage.class);
	String screenshot_path;

	public loginPage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='InputIdentityFlowValue']")
	WebElement EmailInput;

	public void enterEmailInput(String loginusername) {
		try {
			Startup.wd.switchTo().frame("oneid-iframe");
			EmailInput.sendKeys(Keys.TAB);
			EmailInput.click();

			EmailInput.sendKeys(loginusername);
			Helper.highLightElement(Startup.wd, EmailInput);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "enterEmailInput");
			System.out.println("Username entered:" + EmailInput);
			System.out.println("Entered Email Input");

			logger.info("User Entered Email Input:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Entered Email Input ",
					"Entered Email Input", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to Enter Email Input:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Entered Email Input ",
					"Entered Email Input", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputPassword']")
	WebElement passwordInput;

	public void enterPassword(String loginpassword) {
		try {
			passwordInput.sendKeys(Keys.TAB);
			passwordInput.click();
			passwordInput.sendKeys(loginpassword);
			Helper.highLightElement(Startup.wd, passwordInput);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "enterPassword");
			System.out.println("password entered:");

			logger.info("login password entered:" + loginpassword);
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- Enter valid password ",
					"User should be able to enter valid password ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("login password entered is wrong or login password is not entered: ");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- Enter invalid password ",
					"User should be able to enter valid password ", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//div/button[@data-testid='BtnSubmit']")
	WebElement ContinueButton;

	public void clickContinueButton() {
		try {
			Helper.highLightElement(Startup.wd, ContinueButton);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickContinueButton");
			ContinueButton.click();
			System.out.println("Clicked Continue Button");

			logger.info("User clicked Continue Button:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- Click on Continue button ",
					"Click on Continue button ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to click Continue Button:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- Click on Continue button ",
					"Click on Continue button", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//div/button[@data-testid='BtnSubmit']")
	WebElement LogInButton;

	public void clickLogInButton() {
		try {
			Helper.highLightElement(Startup.wd, LogInButton);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickLogInButton");
			LogInButton.click();
			System.out.println("Clicked Login Button");

			logger.info("User clicked LogIn Button:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- Click on LogIn button ",
					"Click on LogIn button ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to click LogIn Button:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- Click on LogIn button ",
					"Click on LogIn button", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='BtnSubmit']")
	WebElement CreateAccountButton;

	public void clickCreateAccountButton() {
		try {

			Helper.highLightElement(Startup.wd, CreateAccountButton);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickCreateAccountButton");
			CreateAccountButton.click();
			System.out.println("Clicked CreateAccountButton Button");

			logger.info("User clicked CreateAccountButton Button:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- Click on CreateAccountButton button ",
					"Click on CreateAccountButton button ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to click CreateAccountButton Button:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- Click on CreateAccountButton button ",
					"Click on CreateAccountButton button", "" + screenshot_path + "");
		}
	}

	public void clearFields() {
		EmailInput.clear();
//		passwordInput.clear();
	}

	public void verifyloginPage() {

		String title = Startup.wd.getTitle();
		Assert.assertEquals("ESPN India - Serving Sports Fans. Anytime. Anywhere.", title);
		System.out.println("Login page is displayed");
	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputIdentityFlowValue-error']")
	WebElement errormsg;

	public void verifyErrorMessage() {
		String err = errormsg.getText();
		Assert.assertEquals("Required", err);
		System.out.println(errormsg.getAttribute("innerhtml"));
		System.out.println(errormsg.getText());

	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputIdentityFlowValue-error']")
	WebElement EmailError;

	public void verifyEmailError() {
		try {

			String err = EmailError.getText();
			Assert.assertEquals("Please enter a valid email address.", err);
			EmailError.click();
			Helper.highLightElement(Startup.wd, EmailError);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyEmailError");
			System.out.println("verified EmailError");

			logger.info("verified EmailError:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified EmailError ",
					"verified EmailError ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify EmailError:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified EmailError ",
					"verified EmailError", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='close']")
	WebElement CloseButton;

	public void clickCloseButton() {
		try {
			Helper.highLightElement(Startup.wd, CloseButton);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickCloseButton");
			CloseButton.click();
			System.out.println("verified clickCloseButton");

			logger.info("verified clickCloseButton:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickCloseButton ",
					"verified clickCloseButton ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickCloseButton:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickCloseButton ",
					"verified clickCloseButton", "" + screenshot_path + "");
		}

	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputPassword-error']")
	WebElement PasswordError;

	public void verifyPasswordError() {
		try {

			String err = PasswordError.getText();
			Assert.assertEquals(
					"We couldn't log you in. Please check your email and password and try again. Note: passwords are case sensitive. If you can't remember your details, use the forgot password link below.",
					err);
			PasswordError.click();
			Helper.highLightElement(Startup.wd, PasswordError);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyPasswordError");
			System.out.println("verified PasswordError");

			logger.info("verified PasswordError:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified PasswordError ",
					"verified PasswordError ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify PasswordError:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified PasswordError ",
					"verified PasswordError", "" + screenshot_path + "");
		}

	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputFirstName']")
	WebElement FirstName;

	public void enterFirstName(String LoginFirstName) {
		try {

			FirstName.click();
			FirstName.sendKeys(LoginFirstName);
			Helper.highLightElement(Startup.wd, FirstName);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "enterFirstName");
			System.out.println("verified enterFirstName");

			logger.info("verified enterFirstName:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified enterFirstName ",
					"verified enterFirstName ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify enterFirstName:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified enterFirstName ",
					"verified enterFirstName", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputFirstName-error']")
	WebElement FirstNameError;

	public void verifyFirstNameError() {
		try {

			String err = FirstNameError.getText();
			Assert.assertEquals("Please enter your first name.", err);
			FirstNameError.click();
			Helper.highLightElement(Startup.wd, FirstNameError);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyFirstNameError");
			System.out.println("verified verifyFirstNameError");

			logger.info("verified verifyFirstNameError:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyFirstNameError ",
					"verified verifyFirstNameError ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyFirstNameError:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyFirstNameError ",
					"verified verifyFirstNameError", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputLastName']")
	WebElement LastName;

	public void enterLastName(String LoginLastName) {
		try {

			LastName.click();
			LastName.sendKeys(LoginLastName);
			Helper.highLightElement(Startup.wd, LastName);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "enterLastName");
			System.out.println("verified enterLastName");

			logger.info("verified enterLastName:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified enterLastName ",
					"verified enterLastName ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify enterLastName:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified enterLastName ",
					"verified enterLastName", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputLastName-error']")
	WebElement LastNameError;

	public void verifyLastNameError() {
		try {
			String err = LastNameError.getText();
			Assert.assertEquals("Please enter your surname.", err);
			LastNameError.click();
			Helper.highLightElement(Startup.wd, LastNameError);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyLastNameError");
			System.out.println("verified verifyLastNameError");

			logger.info("verified verifyLastNameError:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyLastNameError ",
					"verified verifyLastNameError ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyLastNameError:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyLastNameError ",
					"verified verifyLastNameError", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='password-new']")
	WebElement NewPasswordInput;

	public void enterNewPassword(String NewLoginPassword) {
		try {

//			Startup.wd.switchTo().frame("oneid-iframe");
//			passwordInput.sendKeys(Keys.TAB);
//			passwordInput.sendKeys(Keys.ENTER);
			NewPasswordInput.click();
			NewPasswordInput.sendKeys(NewLoginPassword);
			Helper.highLightElement(Startup.wd, NewPasswordInput);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "enterNewPassword");

			System.out.println("password entered:");
			logger.info(" enterNewPassword :");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-  enterNewPassword  ",
					"User should be able to enterNewPassword   ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("login password entered is wrong or login password is not entered: ");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- Enter invalid enterNewPassword ",
					"User should be able to enter valid enterNewPassword ", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='PasswordPanel']/small/div[2]/text()")
	WebElement NewPasswordError;

	public void verifyNewPasswordError() {
		try {

			String err = NewPasswordError.getText();
			Assert.assertEquals("Please enter a password.", err);
			NewPasswordError.click();
			Helper.highLightElement(Startup.wd, NewPasswordError);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyNewPasswordError");
			System.out.println("verified verifyNewPasswordError");

			logger.info("verified verifyNewPasswordError:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyNewPasswordError ",
					"verified verifyNewPasswordError ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyNewPasswordError:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyNewPasswordError ",
					"verified verifyNewPasswordError", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='password-new-error']")
	WebElement ShortPasswordError;

	public void verifyShortPasswordError() {
		try {
			Thread.sleep(3000);
			String err = ShortPasswordError.getText();
			Assert.assertEquals("The password is too short.", err);

			ShortPasswordError.click();
			Helper.highLightElement(Startup.wd, ShortPasswordError);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyShortPasswordError");
			System.out.println("verified verifyShortPasswordError");

			logger.info("verified verifyNewPasswordError:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyNewPasswordError ",
					"verified verifyNewPasswordError ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyNewPasswordError:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyNewPasswordError ",
					"verified verifyNewPasswordError", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='PasswordPanel']/small/div[2]")
	WebElement NewPasswordError1;

	public void verifyNewPasswordError1() {
		try {

			String err = NewPasswordError1.getText();
			Assert.assertEquals("Enter at least 6 characters.", err);

			NewPasswordError1.click();
			Helper.highLightElement(Startup.wd, NewPasswordError1);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyNewPasswordError1");
			System.out.println("verified verifyNewPasswordError1");

			logger.info("verified verifyNewPasswordError1:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyNewPasswordError1 ",
					"verified verifyNewPasswordError1 ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyNewPasswordError1:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyNewPasswordError1 ",
					"verified verifyNewPasswordError1", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='PasswordPanel']/small/div[3]")
	WebElement NewPasswordError2;

	public void verifyNewPasswordError2() {
		try {

			String err = NewPasswordError2.getText();
			Assert.assertEquals("Use letters together with spaces, numbers, or symbols (!@#$%^&*).", err);

			NewPasswordError2.click();
			Helper.highLightElement(Startup.wd, NewPasswordError2);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyNewPasswordError2");
			System.out.println("verified verifyNewPasswordError2");

			logger.info("verified verifyNewPasswordError2:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyNewPasswordError2 ",
					"verified verifyNewPasswordError2 ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyNewPasswordError2:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyNewPasswordError2 ",
					"verified verifyNewPasswordError2", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='PasswordPanel']/small/div[4]")
	WebElement NewPasswordError3;

	public void verifyNewPasswordError3() {
		try {

			String err = NewPasswordError3.getText();
			Assert.assertEquals("Don't use the password from another account.", err);

			NewPasswordError3.click();
			Helper.highLightElement(Startup.wd, NewPasswordError3);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyNewPasswordError3");
			System.out.println("verified verifyNewPasswordError3");

			logger.info("verified verifyNewPasswordError3:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyNewPasswordError3 ",
					"verified verifyNewPasswordError3 ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyNewPasswordError3:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyNewPasswordError3 ",
					"verified verifyNewPasswordError3", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputIdentityFlowValue-error']")
	WebElement DelAccountloginError;

	public void verifyDelAccountloginError() {
		try {

			String err = DelAccountloginError.getText();
			Assert.assertEquals(
					"There's a problem with the account for this email address. Make sure you entered it correctly, or contact Guest Services for help.",
					err);

			DelAccountloginError.click();
			Helper.highLightElement(Startup.wd, DelAccountloginError);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyDelAccountloginError");
			System.out.println("verified verifyDelAccountloginError");

			logger.info("verified verifyDelAccountloginError:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyDelAccountloginError ",
					"verified verifyDelAccountloginError ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyDelAccountloginError:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyDelAccountloginError ",
					"verified verifyDelAccountloginError", "" + screenshot_path + "");
		}
	}

}
