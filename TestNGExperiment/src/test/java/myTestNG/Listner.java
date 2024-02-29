package myTestNG;
import org.testng.ITestListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
public class Listner extends TakeScreenShort implements ITestListener
{

	LocalDateTime ldt=LocalDateTime.now();
	  DateTimeFormatter df=DateTimeFormatter.ofPattern("dd-MM-yyyy : hh-mm-ss");
	  String currentDateTime=ldt.format(df);
	  String screenshortfilename=currentDateTime.toString().replace(":", "-");
	@Override
	public void onTestStart(ITestResult result) {

		ITestListener.super.onTestStart(result);
		System.out.println("hi kiran");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ITestListener.super.onTestSuccess(result);
		System.out.println("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		ITestListener.super.onTestFailure(result);
		try {
			Onfail(result.getMethod().getMethodName()+screenshortfilename+".jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Take ScreenShort Method Is called");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);
	}
}
