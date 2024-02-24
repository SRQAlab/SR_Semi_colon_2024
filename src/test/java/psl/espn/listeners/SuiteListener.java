package psl.espn.listeners;

import java.net.UnknownHostException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.log4testng.Logger;
import psl.espn.results.HTMLReportGenerator;

public class SuiteListener implements ISuiteListener {

	final static Logger logger = Logger.getLogger(SuiteListener.class);

	public void onStart(ISuite suite) {
		String suitename = suite.getName();
		String reportFilePath = System.getProperty("user.dir") + "\\test-output\\extentreport\\report.html";
		System.out.println("Suite Execution Start. Suite Name:" + suitename);
		logger.info("Suite Execution Start. Suite Name:" + suitename);

		try {
			HTMLReportGenerator.TestSuiteStart(reportFilePath, "spranade");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish(ISuite suite) {
		String reportFilePath = System.getProperty("user.dir") + "\\test-output\\extentreport\\report.html";
		String suitename = suite.getName();
		System.out.println("Suite Execution Over. Suite Name:" + suitename);
		logger.info("Suite Execution Over. Suite Name:" + suitename);
		HTMLReportGenerator.TestSuiteEnd();
	}

}
