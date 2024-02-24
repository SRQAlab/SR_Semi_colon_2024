package psl.espn.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import psl.espn.config.Startup;
import psl.espn.library.excludeTestCase;
import psl.espn.results.HTMLReportGenerator;

public class TestCaseListener implements ITestListener {

	public String TestCaseID = null;
	public String exclude = null;

	public void onFinish(ITestContext test) {
		HTMLReportGenerator.TestCaseEnd();
	}

	public void onStart(ITestContext test) {
		TestCaseID = test.getCurrentXmlTest().getAllParameters().get("TestCaseID");
		exclude = test.getCurrentXmlTest().getAllParameters().get("exclude");
		HTMLReportGenerator.TestCaseStart(test.getName(), test.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult test) {

	}

	public void onTestFailure(ITestResult test) {
		System.out.println(
				"test case failed" + test.getTestName() + "----" + test.getTestClass() + "----" + test.getClass());
	}

	public void onTestSkipped(ITestResult test) {
		HTMLReportGenerator.StepDetails("SKIP", (Startup.counter++) + " - " + test.getTestClass() + "-",
				"skip testcase", "");
		System.out.println(
				"test case skipped" + test.getTestName() + "----" + test.getTestClass() + "----" + test.getClass());
	}

	public void onTestStart(ITestResult test) {
		excludeTestCase ex = new excludeTestCase();
		ex.excludeTest(exclude, TestCaseID);
		String result = test.getName();
		System.out.println("\n Test started is :" + result);
		if (test.getParameters().length != 0) {
			String params = "";
			for (Object parameter : test.getParameters()) {
				params += parameter.toString() + ",";
			}
			System.out.println("Parameteres are :" + params);
		}

	}

	public void onTestSuccess(ITestResult test) {

	}

}
