package api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListener.class);

	public void onStart(ITestContext context) {
		logger.info("**********Test Suite Started**********");
	}

	public void onTestStart(ITestResult result) {
		logger.info("Test Method = " + result.getMethod().getMethodName());
		logger.info("Test Description " + result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test " + result.getMethod().getMethodName() + " is Passed");
	}

	public void onTestFailure(ITestResult result) {
		logger.error("Test " + result.getMethod().getMethodName() + " is Failed");
	}

	public void onTestSkipped(ITestResult result) {
		logger.error("Test " + result.getMethod().getMethodName() + " is Skipped");
	}

	public void onFinish(ITestContext context) {
		logger.info("**********Test Suite Completed**********");
	}
}
