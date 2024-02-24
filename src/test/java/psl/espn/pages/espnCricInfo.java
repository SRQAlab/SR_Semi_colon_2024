package psl.espn.pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
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

public class espnCricInfo {

	final static Logger logger = Logger.getLogger(espnCricInfo.class);

	String screenshot_path;

	public espnCricInfo(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Cricket Teams']")
	WebElement TeamsMenu;
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='India']")
	WebElement IndiaTeam;

	public void clickTeamsMenu() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(TeamsMenu).build().perform();
			Helper.highLightElement(Startup.wd, TeamsMenu);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickTeamsMenu");

			action.moveToElement(IndiaTeam).build().perform();
			Helper.highLightElement(Startup.wd, IndiaTeam);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "IndiaTeam");
			IndiaTeam.click();

			System.out.println("verified clickTeamsMenu");
			logger.info("verified clickTeamsMenu:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickTeamsMenu ",
					"verified clickTeamsMenu ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickTeamsMenu:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickTeamsMenu ",
					"verified clickTeamsMenu", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//button[@id='wzrk-cancel'][@class='No thanks']")
	WebElement CancelButton;

	public void clickCancelButton() {
		try {

			ArrayList<String> tabs = new ArrayList<String>(Startup.wd.getWindowHandles());
			Startup.wd.switchTo().window(tabs.get(1));
//		Startup.wd.close();
//		Startup.wd.switchTo().window(tabs.get(0));

			if (CancelButton.isDisplayed()) {
				Actions action = new Actions(Startup.wd);
				action.moveToElement(CancelButton).build().perform();
				CancelButton.click();
				Helper.highLightElement(Startup.wd, CancelButton);
				screenshot_path = Utility.captureScreenshot(Startup.wd, "clickCancelButton");

				System.out.println("verified clickCancelButton");
				logger.info("verified clickCancelButton:");
				HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickCancelButton ",
						"verified clickCancelButton ", "" + screenshot_path + "");
			}

		} catch (Exception e) {
			logger.error("User failed to verify clickCancelButton:");
			// HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified
			// clickCancelButton ","verified clickCancelButton", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//div/span[contains(text(),'Results')]")
	WebElement Results;

	public void clickResults() {
		try {
			Thread.sleep(10000);
			Actions action = new Actions(Startup.wd);
			action.moveToElement(Results).build().perform();
			Helper.highLightElement(Startup.wd, Results);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickResults");
			Results.click();

			logger.info("verified clickResults:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickResults ",
					"verified clickResults ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickResults:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickResults ",
					"verified clickResults", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@class='ds-relative']//a[1]//div[1]//div[1]//div[1]//div[1]//span[1]//span[1]")
	WebElement GetResult1;
	@FindBy(how = How.XPATH, using = "//a[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[1]")
	WebElement GetResult2;
	@FindBy(how = How.XPATH, using = "//*[@id='main-container']/div[5]/div[1]/div[2]/div[1]/div/div/div/div/div[2]/div/div[1]/a[1]/div/div/p/span")
	WebElement GetResult3;

	public void getResult() {
		try {

			FileWriter fr;
			BufferedWriter br;
			fr = new FileWriter("ESPNCricInfoResult.txt");
			br = new BufferedWriter(fr);

			Actions action = new Actions(Startup.wd);
			action.moveToElement(GetResult1).build().perform();
			Helper.highLightElement(Startup.wd, GetResult1);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "GetResult1");
			String err = GetResult1.getText();
			br.write("" + err);
			System.out.println("====" + err + "====");

			action = new Actions(Startup.wd);
			action.moveToElement(GetResult2).build().perform();
			Helper.highLightElement(Startup.wd, GetResult2);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "GetResult2");
			err = GetResult2.getText();
			br.write("" + err);
			System.out.println("====" + err + "====");

			action = new Actions(Startup.wd);
			action.moveToElement(GetResult3).build().perform();
			Helper.highLightElement(Startup.wd, GetResult3);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "GetResult3");
			err = GetResult3.getText();
			br.write("" + err);
			System.out.println("====" + err + "====");
			br.close();

			logger.info("verified GetResult:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified GetResult ",
					"verified GetResult ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify GetResult:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified GetResult ", "verified GetResult",
					"" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//i[@class='icon-search-outlined ds-text-icon-inverse ci-nav-item ci-nav-hover']")
	WebElement SearchIcon;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Players, Teams or Series']")
	WebElement SearchIconInput;

	public void clickSearchIcon() {
		try {
			Actions action = new Actions(Startup.wd);
			action.moveToElement(SearchIcon).build().perform();
			Helper.highLightElement(Startup.wd, SearchIcon);
			screenshot_path = Utility.captureScreenshot(Startup.wd, "clickSearchIcon");
			SearchIcon.click();
			SearchIconInput.click();
			SearchIconInput.sendKeys("India");
			SearchIconInput.sendKeys(Keys.ENTER);

			logger.info("verified clickSearchIcon:");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "- verified clickSearchIcon ",
					"verified clickSearchIcon ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("User failed to verify clickSearchIcon:");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "- verified clickSearchIcon ",
					"verified clickSearchIcon", "" + screenshot_path + "");
		}
	}

}
