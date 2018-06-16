package Auto;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Box {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kumar\\Desktop\\selenium jar files\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();

           System.out.println("Chrome is opened");

           driver.get("http://10.0.1.86/tatoc/basic/grid/gate");

           System.out.println("tatoc is selected");

//Find the text input element by its name

          WebElement element = driver.findElement(By.className("greenbox"));
//Enter something to search                 
          element.click();
          String parentFrameDivClass="",childFrameDivClass="";
          parentFrameDivClass=driver.switchTo().frame("main").findElement(By.id("answer")).getAttribute("class");
          //System.out.println(s);
          do {
        	  childFrameDivClass=driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");;
          //System.out.println(s1);
          driver.switchTo().parentFrame();
          if(parentFrameDivClass.equals(childFrameDivClass)) {
        	  driver.findElement(By.linkText("Proceed")).click();
          }
          else {
        	  driver.findElement(By.linkText("Repaint Box 2")).click();
          }
          }while(!parentFrameDivClass.equals(childFrameDivClass));
          new Actions(driver).dragAndDrop(driver.findElement(By.id("dragbox")),driver.findElement(By.id("dropbox"))).perform();
          driver.findElement(By.linkText("Proceed")).click();
          driver.findElement(By.linkText("Launch Popup Window")).click();
          String winHandleBefore = driver.getWindowHandle();
          for(String winHandle : driver.getWindowHandles()){
        	  driver.switchTo().window(winHandle);
          }
          WebElement we=driver.findElement(By.id("name"));
          we.sendKeys("Anoop Kumar");
          driver.findElement(By.id("submit")).click();
          driver.switchTo().window(winHandleBefore);
          driver.findElement(By.linkText("Proceed")).click();
          driver.findElement(By.linkText("Generate Token")).click();
          String c=driver.findElement(By.id("token")).getText();
          String[] str=c.split(" ");
          Cookie ck=new Cookie("Token", str[str.length-1]);
          driver.manage().addCookie(ck);
          //Thread.sleep(2000);
         driver.findElement(By.linkText("Proceed")).click();
       // Continue with original browser (first window)


          
	}


}
