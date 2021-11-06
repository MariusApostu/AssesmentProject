package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNgListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Log.info("++++ Start of test case :++"  + result.getMethod().getMethodName() +"+++++++++++++++++++");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Log.info("+++Start time : ++ " + timeStamp+"+++++++++++++++++++");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Log.info("++++ End of test case :++"  + result.getMethod().getMethodName() +"+++++++++++++++++++");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Log.info("+++End time : ++ " + timeStamp+"+++++++++++++++++++");    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Log.error("++++ Failed of test case :++"  + result.getMethod().getMethodName() +"+++++++++++++++++++");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Log.error("+++Failed  time : ++ " + timeStamp+"+++++++++++++++++++");
        TakeScreenshot screenshot = new TakeScreenshot(BaseTest.driver);
        screenshot.scrennshot(result.getMethod().getMethodName() + timeStamp);
        Log.error(result.getThrowable().toString());
    }
}
