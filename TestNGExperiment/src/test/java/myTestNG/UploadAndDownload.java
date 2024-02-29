package myTestNG;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class UploadAndDownload {

	public static void main(String[] args) throws Exception 
	{
		ChromeOptions option =new ChromeOptions();
		option.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation","disable-popup-blocking"));
		Map<String, Object> prefs=new HashMap<String,Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.default_content_settings.popups", 0);
		String downloadFilepath="D:\\eclipseOld062022\\TestNGExperiment\\test-output\\downloads";
		//String downloadFilepath="C:\\Users\\Dell\\Desktop\\tset";
		prefs.put("download.default_directory", downloadFilepath);
		option.setExperimentalOption("prefs", prefs);
		option.setBrowserVersion("116");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Dell\\Downloads\\Transaction Receipt.pdf");
		driver.findElement(By.id("file-submit")).click();
		WebElement message=driver.findElement(By.xpath("//h3[text()=\"File Uploaded!\"]"));
		System.out.println(message.getText());
		driver.switchTo().newWindow(WindowType.TAB);
		//when type="file" attribute is not present then we should go with robot class
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.xpath("//span[text()=\"Select PDF files\"]")).click();
		Robot ro =new Robot();
		ro.delay(2000);
		//ctrl+c
		StringSelection path=new StringSelection("C:\\Users\\Dell\\Downloads\\Transaction Receipt.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		//ctrl+v
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_CONTROL);
		ro.keyRelease(KeyEvent.VK_V);
		//enter
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//li[@data-name='dpi' and@data-value='300']")).click();
		driver.findElement(By.id("processTask")).click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("pickfiles"))));
		driver.findElement(By.id("pickfiles")).click();
		//validate wheather downloaded or not
		String ExpecFilename="Transaction Receipt_page-0001.jpg";
		File file=new File(downloadFilepath,ExpecFilename);
		//listOfFiles= new File(downloadFilepath).listFiles();
		//System.out.println(listOfFiles.length);

		/*for (File file : listOfFiles) 
		{
			String ActFileName=file.getName().toString();
			if((ActFileName.contains(ExpecFilename)))
			{
				System.out.println(ActFileName+ " is downloaded successfully");
			}
			else
				System.out.println("File not found");
		}	*/
		FluentWait<File> fwait=new FluentWait<File>(file)
				.withTimeout(Duration.ofMillis(500000000))
				.pollingEvery(Duration.ofMillis(10))
				.ignoring(Exception.class).withMessage("file not found");
		try {


			boolean isDownloaded=fwait.until(f-> f.exists() && f.canRead());
			if (isDownloaded) 
			{
				System.out.println(file.getName()+" is completely downloaded");
			}
		} catch (io.netty.handler.timeout.TimeoutException e) {
			System.out.println(file+"file is not completely downloaded");
		}
		finally {
			driver.quit();
		}


	}

}

