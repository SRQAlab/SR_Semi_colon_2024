package psl.espn.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import psl.espn.config.Startup;
import psl.espn.library.Helper;
import psl.espn.library.Utility;
import psl.espn.results.HTMLReportGenerator;

import org.openqa.selenium.interactions.Actions;

public class profilePage {

	final static Logger logger = Logger.getLogger(profilePage.class);
	String screenshot_path;

	public profilePage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='AccountDeleteLink']")
	WebElement AccountDeleteLink;

	public void clickAccountDeleteLink() {
		try {
			Startup.wd.switchTo().frame("oneid-iframe");
			Actions action = new Actions(Startup.wd);
			action.moveToElement(AccountDeleteLink).build().perform();
			Helper.highLightElement(Startup.wd, AccountDeleteLink);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickAccountDeleteLink");
			AccountDeleteLink.click();

			System.out.println("Clicked clickAccountDeleteLink link");

			logger.info("User clicked clickAccountDeleteLink link:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click clickAccountDeleteLink link ",
					"Click clickAccountDeleteLink link", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to clickAccountDeleteLink:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click clickAccountDeleteLink link ",
					"Click clickAccountDeleteLink link", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='BtnSubmit']")
	WebElement ConfirmDelete;

	public void clickConfirmDeleteButton() {
		try {

			ConfirmDelete.sendKeys(Keys.TAB);
			ConfirmDelete.sendKeys(Keys.TAB);
			Actions action = new Actions(Startup.wd);
			action.moveToElement(ConfirmDelete).build().perform();
			Helper.highLightElement(Startup.wd, ConfirmDelete);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickConfirmDeleteButton");
			ConfirmDelete.click();

			System.out.println("Clicked clickConfirmDeleteButton ");
			logger.info("User clicked  clickConfirmDeleteButton:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click clickConfirmDeleteButton ",
					"Click clickConfirmDeleteButton", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to clickConfirmDeleteButton:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click clickConfirmDeleteButton ",
					"Click clickConfirmDeleteButton", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='Title']/span")
	WebElement ConfirmDeleteMessage;

	public void verifyConfirmDeleteMessage() {
		try {

			String err = ConfirmDeleteMessage.getText();
			Assert.assertEquals("Your account has been deleted.", err);

			ConfirmDeleteMessage.click();
			Helper.highLightElement(Startup.wd, ConfirmDeleteMessage);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyConfirmDeleteMessage");
			System.out.println("verified verifyConfirmDeleteMessage");

			logger.info("verified verifyConfirmDeleteMessage:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyConfirmDeleteMessage ",
					"verified verifyConfirmDeleteMessage ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyConfirmDeleteMessage:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyConfirmDeleteMessage ",
					"verified verifyConfirmDeleteMessage", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='Email']/div/div[2]")
	WebElement ProfileEmail;

	public void verifyProfileEmail(String loginusername) {
		try {
			Startup.wd.switchTo().frame("oneid-iframe");
			ProfileEmail.click();
			String err = ProfileEmail.getText();
			Helper.highLightElement(Startup.wd, ProfileEmail);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyProfileEmail");
			System.out.println("verified verifyProfileEmail");
			System.out.println("====" + err + "====");

			logger.info("verified verifyProfileEmail:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyProfileEmail ",
					"verified verifyProfileEmail ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyProfileEmail:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyProfileEmail ",
					"verified verifyProfileEmail", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputFirstName']")
	WebElement ProfileFirstName;

	public void verifyProfileFirstName(String LoginFirstName) {
		try {
			ProfileFirstName.click();
			String err = ProfileFirstName.getText();
			Helper.highLightElement(Startup.wd, ProfileFirstName);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyProfileFirstName");
			System.out.println("verified verifyProfileFirstName");
			System.out.println("====" + err + "====");

			logger.info("verified verifyProfileFirstName:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyProfileFirstName ",
					"verified verifyProfileFirstName ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyProfileFirstName:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyProfileFirstName ",
					"verified verifyProfileFirstName", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='InputLastName']")
	WebElement ProfilelastName;

	public void verifyProfilelastName(String LoginLastName) {
		try {
			ProfilelastName.click();
			String err = ProfilelastName.getText();
			Helper.highLightElement(Startup.wd, ProfilelastName);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyProfilelastName");
			System.out.println("verified verifyProfilelastName");
			System.out.println("====" + err + "====");

			logger.info("verified verifyProfilelastName:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyProfilelastName ",
					"verified verifyProfilelastName ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyProfilelastName:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyProfilelastName ",
					"verified verifyProfilelastName", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='Address-HOME']/div/div[2]")
	WebElement ProfileEditAddress;

	public void EditAddressBook() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(ProfileEditAddress).build().perform();
			Helper.highLightElement(Startup.wd, ProfileEditAddress);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "ProfileEditAddress");
			ProfileEditAddress.click();

			System.out.println("Clicked ProfileEditAddress ");
			logger.info("User clicked  ProfileEditAddress:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click ProfileEditAddress ",
					"Click ProfileEditAddress", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to Click ProfileEditAddress:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click ProfileEditAddress ",
					"Click ProfileEditAddress", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='Address-HOME']/div/div[2]")
	WebElement ProfileAddressBook;

	public void verifyAddressBook() {
		try {
			ProfileAddressBook.click();
			String err = ProfileAddressBook.getText();
			System.out.println("====" + err + "====");
			Actions action = new Actions(Startup.wd);
			action.moveToElement(ProfileAddressBook).build().perform();
			Helper.highLightElement(Startup.wd, ProfileAddressBook);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "ProfileAddressBook");
			ProfileAddressBook.click();

			System.out.println("Clicked ProfileAddressBook ");

			logger.info("User clicked  ProfileAddressBook:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click ProfileAddressBook ",
					"Click ProfileAddressBook", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to Click ProfileAddressBook:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click ProfileAddressBook ",
					"Click ProfileAddressBook", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='Address-HOME']/div/div[2]/address")
	WebElement ProfilePrimaryAddress;

	public void verifyProfileCountry() {
		try {
			Select select = new Select(Startup.wd.findElement(By.xpath("//*[@id='CountrySelect']")));
			WebElement option = select.getFirstSelectedOption();
			String defaultItem = option.getText();
			System.out.println(defaultItem);
			Assert.assertEquals("India", defaultItem);

			Helper.highLightElement(Startup.wd, option);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyProfileCountry");
			System.out.println("verified verifyProfileCountry");
			System.out.println("====" + defaultItem + "====");

			logger.info("verified verifyProfileCountry:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyProfileCountry ",
					"verified verifyProfileCountry ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyProfileCountry:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyProfileCountry ",
					"verified verifyProfileCountry", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@class='EmailPreferencesContainer']/div[@class='text-block small']/a[contains(text(),'Manage your email subscriptions')]")
	WebElement EmailPreferenceLink;

	public void clickEmailPreferenceLink() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(EmailPreferenceLink).build().perform();
			Helper.highLightElement(Startup.wd, EmailPreferenceLink);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickEmailPreferenceLink");
			EmailPreferenceLink.click();

			System.out.println("Clicked clickEmailPreferenceLink link");
			logger.info("User clicked clickEmailPreferenceLink link:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click clickEmailPreferenceLink link ",
					"Click clickEmailPreferenceLink link", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to clickEmailPreferenceLink:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click clickEmailPreferenceLink link ",
					"Click clickEmailPreferenceLink link", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='unsubscribeAllButton']")
	WebElement UnsubscribeButton;

	public void clickUnsubscribeButton() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(UnsubscribeButton).build().perform();
			Helper.highLightElement(Startup.wd, UnsubscribeButton);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickUnsubscribeButton");
			UnsubscribeButton.click();

			System.out.println("Clicked clickUnsubscribeButton link");
			logger.info("User clicked clickUnsubscribeButton link:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click clickUnsubscribeButton link ",
					"Click clickUnsubscribeButton link", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to clickUnsubscribeButton:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click clickUnsubscribeButton link ",
					"Click clickUnsubscribeButton link", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='saveButton']")
	WebElement SaveEmailPreferenceButton;

	public void clickSaveEmailPreferenceButton() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(SaveEmailPreferenceButton).build().perform();
			Helper.highLightElement(Startup.wd, SaveEmailPreferenceButton);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickSaveEmailPreferenceButton");
			SaveEmailPreferenceButton.click();

			System.out.println("Clicked clickSaveEmailPreferenceButton link");
			logger.info("User clicked clickSaveEmailPreferenceButton link:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click clickSaveEmailPreferenceButton link ",
					"Click clickSaveEmailPreferenceButton link", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to clickSaveEmailPreferenceButton:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click clickSaveEmailPreferenceButton link ",
					"Click clickSaveEmailPreferenceButton link", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='BtnCancel']")
	WebElement OTPCancelButton;
	@FindBy(how = How.XPATH, using = "//*[@id='InputRedeemOTP']")
	WebElement OTPCodeInput;
	@FindBy(how = How.XPATH, using = "//*[@id='otp-code-input-0']")
	WebElement OTPCodeInput0;

	public void clickOTPCancelButton() {
		try {
			if (OTPCancelButton.isDisplayed() && OTPCodeInput.isDisplayed()) {
				OTPCodeInput0.click();
				Actions action = new Actions(Startup.wd);
				action.moveToElement(OTPCancelButton).build().perform();
				Helper.highLightElement(Startup.wd, OTPCancelButton);
				screenshot_path = Utility.captureScreenshot(Startup.wd, "clickOTPCancelButton");
				OTPCancelButton.click();

				System.out.println("Clicked clickOTPCancelButton link");
				logger.info("User clicked clickOTPCancelButton link:");
				HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click clickOTPCancelButton link ",
						"Click clickOTPCancelButton link", "" + screenshot_path + "");
			}
		} catch (Exception e) {
			logger.error("User failed to clickOTPCancelButton:");
			// HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click
			// clickOTPCancelButton link ", "Click clickOTPCancelButton link", "" +
			// screenshot_path + "");
		}

	}

	@FindBy(how = How.XPATH, using = "//*[@id='HomeAddress-CityInput']")
	WebElement CityInput;

	public void addCityInput(String cityname) {
		try {
			CityInput.click();
			Actions action = new Actions(Startup.wd);
			action.moveToElement(CityInput).build().perform();
			CityInput.clear();
			CityInput.sendKeys(cityname);
			Helper.highLightElement(Startup.wd, CityInput);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "addCityInput");

			System.out.println("Clicked addCityInput ");
			logger.info("User clicked  addCityInput:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click addCityInput ", "Click addCityInput",
					"" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to addCityInput:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click addCityInput ", "Click addCityInput",
					"" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='HomeAddress-RegionInput']")
	WebElement StateInput;

	public void addStateInput(String statename) {
		try {

			StateInput.click();
			Actions action = new Actions(Startup.wd);
			action.moveToElement(StateInput).build().perform();

			StateInput.clear();
			StateInput.sendKeys(statename);
			Helper.highLightElement(Startup.wd, StateInput);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "addStateInput");

			System.out.println("Clicked addStateInput ");
			logger.info("User clicked  addStateInput:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click addStateInput ",
					"Click addStateInput", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to addStateInput:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click addStateInput ",
					"Click addStateInput", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='BtnSubmit']")
	WebElement SaveAddressButton;

	public void clickSaveAddressButton() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(SaveAddressButton).build().perform();
			SaveAddressButton.click();
			Helper.highLightElement(Startup.wd, SaveAddressButton);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickSaveAddressButton");

			System.out.println("Clicked SaveAddressButton ");
			logger.info("User clicked  SaveAddressButton:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click SaveAddressButton ",
					"Click SaveAddressButton", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to clickSaveAddressButton:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click SaveAddressButton ",
					"Click SaveAddressButton", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='BtnSubmit']")
	WebElement DoneButton;

	public void clickDoneButton() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(DoneButton).build().perform();
			DoneButton.click();
			Helper.highLightElement(Startup.wd, DoneButton);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickDoneButton");

			System.out.println("Clicked clickDoneButton ");
			logger.info("User clicked  clickDoneButton:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click clickDoneButton ",
					"Click clickDoneButton", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to clickDoneButton:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click clickDoneButton ",
					"Click clickDoneButton", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='Phone_MOBILE']")
	WebElement MobileInputBox;
	@FindBy(how = How.XPATH, using = "//*[@id='Phone_MOBILE_PhoneNumberInput']")
	WebElement MobileInput;

	public void enterMobileInput(String mobno) {
		try {
			Startup.wd.switchTo().frame("oneid-iframe");
			MobileInputBox.click();
			Actions action = new Actions(Startup.wd);
			action.moveToElement(MobileInputBox).build().perform();
			MobileInput.click();
			MobileInput.clear();
			MobileInput.sendKeys(mobno);
			Helper.highLightElement(Startup.wd, MobileInput);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "enterMobileInput");

			System.out.println("Clicked enterMobileInput ");
			logger.info("User clicked  enterMobileInput:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click enterMobileInput ",
					"Click enterMobileInput", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to enterMobileInput:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click enterMobileInput ",
					"Click enterMobileInput", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='Phone_MOBILE_PhoneNumberInput-error']")
	WebElement MobileError;

	public void verifyMobileError() {
		try {

			String err = MobileError.getText();
			Assert.assertEquals("Please enter a valid email number.", err);
			MobileError.click();
			Helper.highLightElement(Startup.wd, MobileError);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyEmailError");
			System.out.println("verified verifyMobileError");
			logger.info("verified verifyMobileError:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyMobileError ",
					"verified verifyMobileError ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verified verifyMobileError:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyMobileError ",
					"verified verifyMobileError", "" + screenshot_path + "");
		}
	}

}
