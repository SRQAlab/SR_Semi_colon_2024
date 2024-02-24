package psl.espn.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class suite implements ISuiteListener {

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("finished Suite :"+suite.getName());
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Running Suite:"+suite.getName());
	}

}
