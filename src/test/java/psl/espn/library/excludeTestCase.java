package psl.espn.library;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import psl.espn.config.Startup;
import psl.espn.results.HTMLReportGenerator;

public class excludeTestCase {

	@BeforeTest
	@Parameters({ "exclude", "TestCaseID" })
	public void excludeTest(String exclude, String TestCaseID) {
		System.out.println("~~~~" + exclude + "~~~~");
		System.out.println("~~~~" + TestCaseID + "~~~~");

		if (exclude.contains(TestCaseID)) {

			String[] arr = exclude.split(",");
			String finalString = null;
			String result = null;
			for (String i : arr) {
				System.out.println(i);
				if (i.indexOf('-') > 0) {
					String[] dashes = i.split("-");
					String first = dashes[0];
					String second = dashes[1];

					for (int j = Integer.parseInt(first); j < Integer.parseInt(second) + 1; j++) {
						finalString += Integer.toString(j) + ",";

					}
				}
			}

			System.out.println(exclude);
			if (exclude.contains("-")) {
				result = exclude.replaceAll("-", ",");
			}
			if (result.contains("null")) {
				result = result + finalString.replaceAll("null", ",");
			}
			/*
			if (result.contains("") ) {
				result = result + finalString.replaceAll("", ",");
				
			} */
			/*if ( result.contains(" ")) {
				result = result + finalString.replaceAll(" ", ",");
				
			}*/
			System.out.println("result is :-" + result);

			String[] nos = result.split(",");

			int[] b = new int[nos.length];
			for (int i = 0; i < nos.length; i++) {
				b[i] = Integer.parseInt(nos[i]);
			}

			for (int i = 0; i < b.length; i++) {
				System.out.println(b[i]);

				if (Integer.parseInt(TestCaseID) == b[i]) {
					HTMLReportGenerator.StepDetails("SKIP", (Startup.counter++) + " - " + TestCaseID + " - ",
							"skip testcase", "");

					throw new SkipException("skipping this testcase-----" + TestCaseID);
				}
			}

		}
	}

}