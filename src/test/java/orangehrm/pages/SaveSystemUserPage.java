package orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaveSystemUserPage {
    WebDriver webDriver=null;
    By EMPLOYEENAMELOC = By.cssSelector(".ac_input");
    By USERNAMELOC = By.cssSelector("#systemUser_userName");
    By PASSWORDLOC = By.cssSelector("input[name='systemUser[password]']");
    By CONFIRMPASSWORDLOC = By.cssSelector("input[name='systemUser[confirmPassword]']");
    By STATUSLOC = By.cssSelector("#systemUser_status");
    By USERROLELOC= By.cssSelector("select[name='systemUser[userType]']");
    By SAVELOC = By.cssSelector("input[id='btnSave']");

    public  SaveSystemUserPage(WebDriver webDriver)
    {
        this.webDriver=webDriver;
    }
    public void enterUserRole(String getUserRole)
    {
        Select select = new Select(webDriver.findElement(USERROLELOC));
        if(getUserRole.equalsIgnoreCase("Admin"))
        {
            select.selectByVisibleText("Admin");
        }
        else
        {
            select.selectByVisibleText("ESS");
        }

    }
    public void enterEmployeeName(String getEmployeeName)
    {

              webDriver.findElement(EMPLOYEENAMELOC).sendKeys(getEmployeeName);
    }
    public void enterUserName(String getUserName)
    {
        webDriver.findElement(USERNAMELOC).sendKeys(getUserName);

    }
    public void enterPassword(String getPassword)
    {
        webDriver.findElement(PASSWORDLOC).sendKeys(getPassword);
    }
    public void enterConfirmPassword(String getConfirmPaasword)
    {
        webDriver.findElement(CONFIRMPASSWORDLOC).sendKeys(getConfirmPaasword);
    }
    public void status(String getStatus)
    {

        Select select = new Select(webDriver.findElement(STATUSLOC));
        if(getStatus.equalsIgnoreCase("enabled"))
        {
            select.selectByVisibleText("Enabled");
        }
        else
        {
            select.selectByVisibleText("Disabled");
        }
    }
    public void clickSave()
    {


        WebDriverWait wait = new WebDriverWait(webDriver,5);
        wait.until(ExpectedConditions.elementToBeClickable(SAVELOC));
        webDriver.findElement(SAVELOC).click();

    }
}
