package psl.espn.pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import org.openqa.selenium.interactions.Actions;

public class homepage {

	final static Logger logger = Logger.getLogger(homepage.class);

	String screenshot_path;

	public homepage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='global-user-trigger']")
	WebElement profileimage;

	public void clickProfileImage() {
		try {

			Actions action = new Actions(Startup.wd);
			action.moveToElement(profileimage).build().perform();
			Helper.highLightElement(Startup.wd, profileimage);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickProfileImage");
			profileimage.click();
			System.out.println("Clicked Profile Image link");
			logger.info("User clicked Profile Image link:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click Profile Image link ",
					"Click Profile Image link", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to click Profile Image link:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click Profile Image link ",
					"Click Profile Image link", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//ul[@class='account-management']//li/a[contains(text(),'Log In')]")
	WebElement LogInlink;

	public void clickLogIn() {
		try {

			Actions action = new Actions(Startup.wd);
			action.moveToElement(LogInlink).build().perform();
			Helper.highLightElement(Startup.wd, LogInlink);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickLogIn");
			LogInlink.click();
			System.out.println("Clicked log in link");
			logger.info("User clicked log in link:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click log in link ", "Click log in link",
					"" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to click log in link:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click log in link ", "Click log in link",
					"" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign Up')]")
	WebElement SignUpButton;

	public void clickSignUpButton() {
		try {

			Helper.highLightElement(Startup.wd, SignUpButton);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickSignUpButton");
			SignUpButton.click();
			System.out.println("verified clickSignUpButton");
			logger.info("verified clickSignUpButton:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickSignUpButton ",
					"verified clickSignUpButton ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickSignUpButton:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickSignUpButton ",
					"verified clickSignUpButton", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//ul[@class='account-management']//li/a[contains(text(),'signOut')]")
	WebElement signOutlink;

	public void clickSignOut() {
		try {

			Actions action = new Actions(Startup.wd);
			action.moveToElement(signOutlink).build().perform();
			Helper.highLightElement(Startup.wd, signOutlink);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickSignOut");
			signOutlink.click();
			System.out.println("Clicked sign out link");
			logger.info("User clicked sign out link:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click sign out link ",
					"Click sign out link", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to click sign out link:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click sign out link ",
					"Click sign out link", "" + screenshot_path + "");
		}
	}

	public String verifytitle() {
		Assert.assertEquals(Startup.wd.getTitle(), "ESPN India - Serving Sports Fans. Anytime. Anywhere.",
				"Title is verified");
		String t = Startup.wd.getTitle();
		return t;

	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'ESPN Profile')]")
	WebElement ESPNProfileLink;

	public void clickESPNProfileLink() {
		try {

			Actions action = new Actions(Startup.wd);
			action.moveToElement(ESPNProfileLink).build().perform();
			Helper.highLightElement(Startup.wd, ESPNProfileLink);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickESPNProfileLink");
			ESPNProfileLink.click();

			System.out.println("Clicked ESPNProfileLink ");
			logger.info("User clicked ESPNProfileLink :");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-verified ESPNProfileLink  ",
					"verified ESPNProfileLink ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickESPNProfileLink:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-verified clickESPNProfileLink  ",
					"verified clickESPNProfileLink ", "" + screenshot_path + "");
		}
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

			System.out.println("verified clickAccountDeleteLink ");
			logger.info("User verified  clickAccountDeleteLink :");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-verified clickAccountDeleteLink  ",
					" clickAccountDeleteLink ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to clickAccountDeleteLink:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-verified clickAccountDeleteLink  ",
					" clickAccountDeleteLink ", "" + screenshot_path + "");
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

			System.out.println("verified clickConfirmDeleteButton ");
			logger.info("User verified  clickConfirmDeleteButton:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-verified clickConfirmDeleteButton ",
					"verified clickConfirmDeleteButton", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to clickConfirmDeleteButton:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-verified clickConfirmDeleteButton ",
					"verified clickConfirmDeleteButton", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='Title']/span")
	WebElement ConfirmDeleteMessage;

	public void verifyConfirmDeleteMessage() {
		try {

			String err = ConfirmDeleteMessage.getText();
			Assert.assertEquals("Your account has been deleted.", err);
			Helper.highLightElement(Startup.wd, ConfirmDeleteMessage);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyConfirmDeleteMessage");
			ConfirmDeleteMessage.click();

			System.out.println("verified ConfirmDeleteMessage");
			logger.info("verified ConfirmDeleteMessage:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified ConfirmDeleteMessage ",
					"verified ConfirmDeleteMessage ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify ConfirmDeleteMessage:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified ConfirmDeleteMessage ",
					"verified ConfirmDeleteMessage", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@class='quicklinks__container']/footer/a[contains(text(),'Manage Favourites')]")
	WebElement AddFavLink;

	public void clickAddFavLink() {
		try {

			Actions action = new Actions(Startup.wd);
			action.moveToElement(AddFavLink).build().perform();
			Helper.highLightElement(Startup.wd, AddFavLink);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickAddFavLink");
			AddFavLink.click();

			System.out.println("verified clickAddFavLink");
			logger.info("verified clickAddFavLink:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickAddFavLink ",
					"verified clickAddFavLink ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickAddFavLink:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickAddFavLink ",
					"verified clickAddFavLink", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@class='current-favorites']/div[@class='message']/a[contains(text(),'Add favourites')]")
	WebElement AddFavButton;

	public void clickAddFavButton() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(AddFavButton).build().perform();
			AddFavButton.click();
			Helper.highLightElement(Startup.wd, AddFavButton);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickAddFavButtonButton");
			System.out.println("verified clickAddFavButtonButton");
			logger.info("verified clickAddFavButtonButton:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickAddFavButtonButton ",
					"verified clickAddFavButtonButton ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickAddFavButtonButton:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickAddFavButtonButton ",
					"verified clickAddFavButtonButton", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//button[@class='lightbox__closebtn absolute overflow-hidden']/div")
	WebElement CloseFavSearch;
	@FindBy(how = How.XPATH, using = "//ul[1]//li[2]//div[2]//div[1]//button[1]")
	WebElement FavTeam;
	@FindBy(how = How.XPATH, using = "//*[@id='FavMgmt__Pane__Search__Input']")
	WebElement FavSearchInput;

	public void enterFavSearchInput(String Favr) {
		try {
			Startup.wd.switchTo().frame("favorites-manager-iframe");
			Actions action = new Actions(Startup.wd);
			action.moveToElement(FavSearchInput).build().perform();
			FavSearchInput.click();
			FavSearchInput.sendKeys(Keys.TAB);
			Thread.sleep(5000);
			FavSearchInput.sendKeys(Keys.ENTER);
			FavSearchInput.click();
			FavSearchInput.sendKeys(Favr);
			FavTeam.click();
			Thread.sleep(5000);
			Helper.highLightElement(Startup.wd, FavSearchInput);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickFavSearchInput");
			System.out.println("verified clickFavSearchInput");
			logger.info("verified clickFavSearchInput:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickFavSearchInput ",
					"verified clickFavSearchInput ", "" + screenshot_path + "");

			CloseFavSearch.click();
		} catch (Exception e) {
			logger.error("User failed to verify clickFavSearchInput:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickFavSearchInput ",
					"verified clickFavSearchInput", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='global-search-trigger']")
	WebElement GlobalSearch;

	public void clickGlobalSearch() {
		try {

			Actions action = new Actions(Startup.wd);
			action.moveToElement(GlobalSearch).build().perform();
			Helper.highLightElement(Startup.wd, GlobalSearch);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickGlobalSearch");
			GlobalSearch.click();
			System.out.println("verified clickGlobalSearch");

			logger.info("verified clickGlobalSearch:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickGlobalSearch ",
					"verified clickGlobalSearch ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickGlobalSearch:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickGlobalSearch ",
					"verified clickGlobalSearch", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@id='global-search-input']")
	WebElement GlobalSearchInput;

	public void clickGlobalSearchInput() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(GlobalSearchInput).build().perform();
			GlobalSearchInput.click();
			GlobalSearchInput.sendKeys("Virat Kohli");
			Helper.highLightElement(Startup.wd, GlobalSearchInput);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickGlobalSearchInput");
			GlobalSearchInput.sendKeys(Keys.ENTER);

			System.out.println("verified clickGlobalSearchInput");
			logger.info("verified clickGlobalSearchInput:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickGlobalSearchInput ",
					"verified clickGlobalSearchInput ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickGlobalSearchInput:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickGlobalSearchInput ",
					"verified clickGlobalSearchInput", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//img[@alt=\"Virat Kohli\"]")
	WebElement GlobalSearchResult;

	public void verifyGlobalSearchResult() {
		try {

			Actions action = new Actions(Startup.wd);
			action.moveToElement(GlobalSearchResult).build().perform();
			Helper.highLightElement(Startup.wd, GlobalSearchResult);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyGlobalSearchResult");
			GlobalSearchResult.click();
			System.out.println("verified GlobalSearchResult");

			logger.info("verified GlobalSearchResult:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified GlobalSearchResult ",
					"verified GlobalSearchResult ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify GlobalSearchResult:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified GlobalSearchResult ",
					"verified GlobalSearchResult", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@class='sub-module gameHeader']//span[@class='cscore_date']")
	WebElement TopEvent;
	@FindBy(how = How.XPATH, using = "//div[@class='sub-module gameHeader']//div[@class='cscore_info-overview']")
	WebElement TopEventResultOverview;
	@FindBy(how = How.XPATH, using = "//div[@class='sub-module gameHeader']//span[@class='cscore_notes_game']")
	WebElement TopEventResult;

	public void verifyTopEventResult() {
		try {
			FileWriter fr;
			BufferedWriter br;
			fr = new FileWriter("TopEventResult.txt");
			br = new BufferedWriter(fr);

			Actions action = new Actions(Startup.wd);
			action.moveToElement(TopEvent).build().perform();
			Helper.highLightElement(Startup.wd, TopEvent);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "TopEvent");
			String err = TopEvent.getText();
			br.write("" + err);
			System.out.println("====" + err + "====");

			action.moveToElement(TopEventResultOverview).build().perform();
			Helper.highLightElement(Startup.wd, TopEventResultOverview);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "TopEventResultOverview");
			err = TopEventResultOverview.getText();
			br.write("" + err);
			System.out.println("====" + err + "====");

			if (TopEventResult.isDisplayed()) {
				action.moveToElement(TopEventResult).build().perform();
				Helper.highLightElement(Startup.wd, TopEventResult);
				screenshot_path = Utility.captureScreenshot(Startup.wd, "verifyTopEventResult");
				err = TopEventResult.getText();
				br.write("" + err);
				System.out.println("====" + err + "====");
				br.close();
			} else {

				System.out.println("====Result Pending====");

			}

			System.out.println("verified verifyTopEventResult");
			logger.info("verified verifyTopEventResult:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified verifyTopEventResult ",
					"verified verifyTopEventResult ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify verifyTopEventResult:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified verifyTopEventResult ",
					"verified verifyTopEventResult", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='leagues']/li[1]/div")
	WebElement TopEvents;

	public void clickTopEvents() {
		try {

			Actions action = new Actions(Startup.wd);
			action.moveToElement(TopEvents).build().perform();
			Helper.highLightElement(Startup.wd, TopEvents);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickTopEvents");
			TopEvents.click();

			System.out.println("verified clickTopEvents");
			logger.info("verified clickTopEvents:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickTopEvents ",
					"verified clickTopEvents ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickTopEvents:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickTopEvents ",
					"verified clickTopEvents", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='global-nav']/ul/li[8]/a")
	WebElement MainMenu;

	public void clickMainMenu() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(MainMenu).build().perform();
			Helper.highLightElement(Startup.wd, MainMenu);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickMainMenu");
			MainMenu.click();

			System.out.println("verified clickMainMenu");
			logger.info("verified clickMainMenu:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickMainMenu ",
					"verified clickMainMenu ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickMainMenu:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickMainMenu ",
					"verified clickMainMenu", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//span[@class='link-text'][normalize-space()='ESPN Cricinfo']")
	WebElement ESPNCricInfoLink;

	public void clickESPNCricInfoLink() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(ESPNCricInfoLink).build().perform();
			Helper.highLightElement(Startup.wd, ESPNCricInfoLink);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickESPNCricInfoLink");
			ESPNCricInfoLink.click();

			System.out.println("verified clickESPNCricInfoLink");
			logger.info("verified clickESPNCricInfoLink:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickESPNCricInfoLink ",
					"verified clickESPNCricInfoLink ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickESPNCricInfoLink:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickESPNCricInfoLink ",
					"verified clickESPNCricInfoLink", "" + screenshot_path + "");
		}
	}

}
