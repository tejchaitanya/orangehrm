package orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard {
    WebDriver webDriver = null;
    By ADMINLOC = By.cssSelector("#menu_admin_viewAdminModule");
    public DashBoard(WebDriver webDriver)
    {
        this.webDriver=webDriver;
    }
    public String getAdminText()
    {
        String adminText = webDriver.findElement(ADMINLOC).getText();
        return adminText;
    }
    public void clickAdmin()
    {
        webDriver.findElement(ADMINLOC).click();

    }
    public String CurrentUrl()
    {
        String currentUrl=webDriver.getCurrentUrl();
        return currentUrl;
    }
}
