package myTestNG;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class TestScreenShort extends BaseClass {

	 @Test(priority = 1)
	  public void login() throws Exception 
	  {
		 // System.out.println(driver.getCurrentUrl());
		  String exp="http://www.automationpractice.pl/index.php?controller=my-account";
		 driver.findElement(By.className("login")).click();
		 driver.findElement(By.id("email")).sendKeys("kunuweds@gmail.com");
		 driver.findElement(By.id("passwd")).sendKeys("Balasore1");
		 driver.findElement(By.id("SubmitLogin")).click();
		 String act=driver.getCurrentUrl();
		 test=reports.createTest("App Login");
		 Reporter.log("App Login Succseefull");
		Assert.assertEquals(act, exp);
	   }
	 //@Test(priority = 6)
	  public void deleteDefAddress() throws Exception 
	  {
		 driver.findElement(By.className("login")).click();
		 driver.findElement(By.id("email")).sendKeys("kunuweds@gmail.com");
		 driver.findElement(By.id("passwd")).sendKeys("Balasore@1");
		 driver.findElement(By.id("SubmitLogin")).click();
		 Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[text()=\"Madhu smita\"]")).click();
		  driver.findElement(By.xpath("//a[@title=\"Addresses\"]")).click();
		  driver.findElement(By.xpath("//a[@title=\"Delete\"]")).click();
		  Alert al=driver.switchTo().alert();
			System.out.println(al.getText());
			al.accept();
			System.out.println("Address Deleted Successfully");



	  }
	  //@Test(priority = 2)
	  public void addToKart() throws Exception 
	  {
		     driver.findElement(By.className("login")).click();
			 driver.findElement(By.id("email")).sendKeys("kunuweds@gmail.com");
			 driver.findElement(By.id("passwd")).sendKeys("Balasore@1");
			 driver.findElement(By.id("SubmitLogin")).click();
		  WebElement we =driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		  Actions action=new Actions(driver);
		  action.moveToElement(we).perform();
		  driver.findElement(By.xpath("//a[@title=\"Blouses\"]")).click();
		  JavascriptExecutor js=((JavascriptExecutor)driver);
		  js.executeScript("window.scrollBy (0,600)");
		  //js.executeScript("arguments[0].click()",target);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();
		  js.executeScript("window.scrollBy (0,600)");
		WebElement price=  driver.findElement(By.xpath("//span[@class=\"price product-price\"]"));
		  driver.findElement(By.xpath("//a[@title=\"Add to cart\"]")).click();

		  System.out.println("iteam successfully added to cart with price : "+price.getText());
		}
	 // @Test(priority = 3)
	  public void productCheckout() throws Exception
	  {
		  driver.findElement(By.className("login")).click();
			 driver.findElement(By.id("email")).sendKeys("kunuweds@gmail.com");
			 driver.findElement(By.id("passwd")).sendKeys("Balasore@1");
			 driver.findElement(By.id("SubmitLogin")).click();
		  WebElement we =driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		  Actions action=new Actions(driver);
		  action.moveToElement(we).perform();
		  driver.findElement(By.xpath("//a[@title=\"Blouses\"]")).click();
		  JavascriptExecutor js=((JavascriptExecutor)driver);
		  js.executeScript("window.scrollBy (0,600)");
		  //js.executeScript("arguments[0].click()",target);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();
		  js.executeScript("window.scrollBy (0,600)");
		//WebElement price=  driver.findElement(By.xpath("//span[@class=\"price product-price\"]"));
		  driver.findElement(By.xpath("//a[@title=\"Add to cart\"]")).click();

		  driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]")).click();
		WebElement totalprice=  driver.findElement(By.id("total_price_container"));
		JavascriptExecutor js1=((JavascriptExecutor)driver);
		js1.executeScript("window.scrollBy (0,600)");
		System.out.println("total price of the product with delivery charge is : "+totalprice.getText());
		driver.findElement(By.xpath("(//a[@title=\"Proceed to checkout\"])[2]")).click();

	  }
	  //@Test(priority = 4)
	  public void billingAddress() throws Exception
	  {
		  driver.findElement(By.className("login")).click();
			 driver.findElement(By.id("email")).sendKeys("kunuweds@gmail.com");
			 driver.findElement(By.id("passwd")).sendKeys("Balasore@1");
			 driver.findElement(By.id("SubmitLogin")).click();
		  WebElement we =driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		  Actions action=new Actions(driver);
		  action.moveToElement(we).perform();
		  driver.findElement(By.xpath("//a[@title=\"Blouses\"]")).click();
		  JavascriptExecutor js=((JavascriptExecutor)driver);
		  js.executeScript("window.scrollBy (0,600)");
		  //js.executeScript("arguments[0].click()",target);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();
		  js.executeScript("window.scrollBy (0,600)");
		//WebElement price=  driver.findElement(By.xpath("//span[@class=\"price product-price\"]"));
		  driver.findElement(By.xpath("//a[@title=\"Add to cart\"]")).click();

		  driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]")).click();
		//WebElement totalprice=  driver.findElement(By.id("total_price_container"));
		JavascriptExecutor js1=((JavascriptExecutor)driver);
		js1.executeScript("window.scrollBy (0,600)");
		//System.out.println("total price of the product with delivery charge is : "+totalprice.getText());
		driver.findElement(By.xpath("(//a[@title=\"Proceed to checkout\"])[2]")).click();
		  driver.findElement(By.id("company")).sendKeys("Tcs");
		  driver.findElement(By.id("address1")).sendKeys("Marathalli");
		  driver.findElement(By.id("address2")).sendKeys("Maa Bhubaneswari pg");
		  driver.findElement(By.id("city")).sendKeys("Banglore");
		  driver.findElement(By.id("id_state")).click();

		  driver.findElement(By.xpath("//option[text()=\"Florida\"]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("postcode")).sendKeys("00000");
		  driver.findElement(By.id("phone")).sendKeys("0123456789");
		  driver.findElement(By.id("phone_mobile")).sendKeys("9876543210");
		  driver.findElement(By.id("other")).sendKeys("i love you");
		  driver.findElement(By.id("alias")).sendKeys("Home");
		  driver.findElement(By.id("submitAddress")).click();
		 // JavascriptExecutor js =((JavascriptExecutor)driver);
		  //js.executeScript("windows.scrollBy(0,600)");
		  driver.findElement(By.xpath("//span[text()=\"Proceed to checkout\"]")).click();
		  driver.findElement(By.id("cgv")).click();
		  driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();
		  System.out.println("Billing address updated successfully");


	  }
	  //@Test(priority = 5)
	  public void paymentGateway() throws Exception 
	  {
		  driver.findElement(By.className("login")).click();
			 driver.findElement(By.id("email")).sendKeys("kunuweds@gmail.com");
			 driver.findElement(By.id("passwd")).sendKeys("Balasore@1");
			 driver.findElement(By.id("SubmitLogin")).click();
		  WebElement we =driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		  Actions action=new Actions(driver);
		  action.moveToElement(we).perform();
		  driver.findElement(By.xpath("//a[@title=\"Blouses\"]")).click();
		  JavascriptExecutor js=((JavascriptExecutor)driver);
		  js.executeScript("window.scrollBy (0,600)");
		  //js.executeScript("arguments[0].click()",target);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();
		  js.executeScript("window.scrollBy (0,600)");
		//WebElement price=  driver.findElement(By.xpath("//span[@class=\"price product-price\"]"));
		  driver.findElement(By.xpath("//a[@title=\"Add to cart\"]")).click();

		  driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]")).click();
		//WebElement totalprice=  driver.findElement(By.id("total_price_container"));
		JavascriptExecutor js1=((JavascriptExecutor)driver);
		js1.executeScript("window.scrollBy (0,600)");
		//System.out.println("total price of the product with delivery charge is : "+totalprice.getText());
		driver.findElement(By.xpath("(//a[@title=\"Proceed to checkout\"])[2]")).click();
		 // JavascriptExecutor js =((JavascriptExecutor)driver);
		  //js.executeScript("windows.scrollBy(0,600)");
		  driver.findElement(By.xpath("//span[text()=\"Proceed to checkout\"]")).click();
		  driver.findElement(By.id("cgv")).click();
		  driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();

		  driver.findElement(By.className("bankwire")).click();
		  driver.findElement(By.xpath("//span[text()=\"I confirm my order\"]")).click();
		WebElement  confmsg=driver.findElement(By.xpath("//p[@class=\"alert alert-success\"]"));
		System.out.println(confmsg.isDisplayed());
		System.out.println(confmsg.getText());
	 }
}
