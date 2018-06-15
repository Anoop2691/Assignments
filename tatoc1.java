package automationFramework;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Box {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   WebDriver driver = new ChromeDriver();

           System.out.println("Chrome is opened");

           driver.get("http://10.0.1.86/tatoc/basic/grid/gate");

           System.out.println("tatoc is selected");

//Find the text input element by its name

          WebElement element = driver.findElement(By.className("greenbox"));
//Enter something to search                 
          element.click();
         // WebDriverWait wait= new WebDriverWait(driver,10);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("answer")));
        // int size1 = driver.findElements(By.tagName("iframe")).size();
          
         String s1=driver.switchTo().frame("main").findElement(By.id("answer")).toString();
         
         String s2=driver.switchTo().frame("child").findElement(By.id("answer")).toString();
         System.out.println(s1+"   "+s2);
	}

}
