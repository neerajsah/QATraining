import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author neerajsah
 */
public class Tatoc 
{
    @SuppressWarnings("empty-statement")
    public static void main(String[] args)
    {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\neerajsah\\Downloads\\chromedriver_win32\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      
      driver.get("http://10.0.1.86/tatoc");
      
      driver.findElement(By.linkText("Basic Course")).click();
      
      
      driver.findElement(By.className("greenbox")).click();
      

    driver.switchTo().frame("main");
    String box1= driver.findElement(By.id("answer")).getAttribute("class");
    driver.switchTo().frame("child");
    String box2= driver.findElement(By.id("answer")).getAttribute("class");
    while(!box1.equals(box2))
    {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("main");
        driver.findElement(By.linkText("Repaint Box 2")).click();
        driver.switchTo().frame("child");
        box2= driver.findElement(By.id("answer")).getAttribute("class");
    }
    driver.switchTo().defaultContent();
    driver.switchTo().frame("main");
    driver.findElement(By.linkText("Proceed")).click();
    
    
    WebElement from=driver.findElement(By.id("dragbox"));
    WebElement to=driver.findElement(By.id("dropbox"));
    Actions action = new Actions(driver);
    action.dragAndDrop(from, to).build().perform();
    driver.findElement(By.linkText("Proceed")).click();
    
    
    driver.findElement(By.linkText("Launch Popup Window")).click();
    ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.findElement(By.id("name")).sendKeys("Just_Testing");
    driver.findElement(By.id("submit")).click();
    driver.switchTo().window(tabs.get(0));
    driver.findElement(By.linkText("Proceed")).click();
    
    
    driver.findElement(By.linkText("Generate Token")).click();
    String token = driver.findElement(By.id("token")).getText();
    String cookieName = token.substring(0,5);
    String cookieValue = token.substring(7,token.length());
    Cookie cookie= new Cookie(cookieName,cookieValue);
    driver.manage().addCookie(cookie);
    driver.findElement(By.linkText("Proceed")).click();
    
    }
}
