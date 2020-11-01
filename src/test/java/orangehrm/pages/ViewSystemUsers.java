package orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewSystemUsers {
    WebDriver webDriver = null;
    By ADDLOC = By.cssSelector("input[name='btnAdd']");
    By SEARCHUSERLOC = By.cssSelector("#searchSystemUser_userName");
    By CLICKUSERLOC =By.cssSelector("#searchBtn");
    By SEARCHUSERCOMPLOC = By.cssSelector(" tr>td:nth-child(2)>a");
    public ViewSystemUsers(WebDriver webDriver)
    {
        this.webDriver=webDriver;
    }
    public void clickAdd()
    {
        webDriver.findElement(ADDLOC).click();
    }
    public void searchUser(String getSearchUser)
    {
        webDriver.findElement(SEARCHUSERLOC).sendKeys(getSearchUser);
    }
    public void clickSearch()
    {

    }
    public String getAddText()
    {
      String addText =  webDriver.findElement(ADDLOC).getAttribute("value");
      return addText;

    }
    public String getSearchText()
    {
        String searchText = webDriver.findElement(CLICKUSERLOC).getAttribute("value");
        return searchText;
    }
    public String searchUser()
    {
        String searchUser = webDriver.findElement(SEARCHUSERCOMPLOC).getText();
        return searchUser;
    }

}
