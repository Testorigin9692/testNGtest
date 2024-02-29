package myTestNG;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class TakeScreenShort  extends BaseClass
{
	 public void Onfail(String filename) throws Exception
	    {
	     TakesScreenshot takescreenshot= (TakesScreenshot) driver;
	     File srcFile =takescreenshot.getScreenshotAs(OutputType.FILE);
	     File destFile=new File("./ScreenShot/"+filename);
		try {
			 FileUtils.copyFile(srcFile,destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	    	System.out.println("Screen short saved successfully");
	    }

}
