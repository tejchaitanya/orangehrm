package orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver webDriver = null;


    By USERNAMELOC=By.cssSelector("input[name='txtUsername']");
    By PASSWORDLOC=By.cssSelector("input[name='txtPassword']");
    By LOGINBUTTONLOC=By.cssSelector(".button");
    public  LoginPage(WebDriver webDriver)
    {
       this.webDriver=webDriver;
    }
    public void enterUserName(String userName)
    {
        webDriver.findElement(USERNAMELOC).sendKeys(userName);

    }
    public void enterPassword(String password)
    {
        webDriver.findElement(PASSWORDLOC).sendKeys(password);
    }
    public void clickLogin()
    {

         WebDriverWait wait = new WebDriverWait(webDriver,2);
         wait.until(ExpectedConditions.elementToBeClickable(LOGINBUTTONLOC));
         webDriver.findElement(LOGINBUTTONLOC).click();



    }
}
