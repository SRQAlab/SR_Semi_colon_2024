package psl.espn.results;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.NetworkMode;

import psl.espn.config.Startup;

public class HTMLReportGenerator {

	static ExtentReports report = null;
	static ExtentTest logger;

	public static void TestSuiteStart(String ResultHTMLFilePath, String UserName) throws UnknownHostException {
		// report=new ExtentReports(ResultHTMLFilePath,false,NetworkMode.OFFLINE);
		report = new ExtentReports(ResultHTMLFilePath);
		report.addSystemInfo("Host Name", InetAddress.getLocalHost().getHostName()).addSystemInfo("Environment", "QA")
				.addSystemInfo("User Name", UserName);
	}

	public static void TestSuiteEnd() {
		report.flush();
		report.close();
//		Startup.wd.get(System.getProperty("user.dir") +"\\test-output\\extentreport\\report.html");
	}

	public static void TestCaseStart(String TestName, String Description) {
		logger = report.startTest(TestName, Description);

	}

	public static void TestCaseEnd() {
		report.endTest(logger);

	}

	public static void StepDetails(String Status, String StepName, String StepDetails, String objectImagePath) {
		String tbl = StepDetails + "<br>" + logger.addScreenCapture(objectImagePath);

		if (Status.equalsIgnoreCase("fatal")) {
			logger.log(LogStatus.FATAL, StepName, tbl);
		} else if (Status.equalsIgnoreCase("fail")) {
			logger.log(LogStatus.FAIL, StepName, tbl);
		} else if (Status.equalsIgnoreCase("error")) {
			logger.log(LogStatus.ERROR, StepName, tbl);
		} else if (Status.equalsIgnoreCase("warning")) {
			logger.log(LogStatus.WARNING, StepName, tbl);
		} else if (Status.equalsIgnoreCase("skip")) {
			logger.log(LogStatus.SKIP, StepName, tbl);
		} else if (Status.equalsIgnoreCase("pass")) {
			logger.log(LogStatus.PASS, StepName, tbl);
		} else if (Status.equalsIgnoreCase("info")) {
			logger.log(LogStatus.INFO, StepName, tbl);
		} else if (Status.equalsIgnoreCase("unknown")) {
			logger.log(LogStatus.UNKNOWN, StepName, tbl);
		}

	}

}
