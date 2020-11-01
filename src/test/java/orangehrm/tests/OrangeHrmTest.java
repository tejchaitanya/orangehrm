package orangehrm.tests;

import orangehrm.browser.Browser;
import orangehrm.pages.DashBoard;
import orangehrm.pages.LoginPage;
import orangehrm.pages.SaveSystemUserPage;
import orangehrm.pages.ViewSystemUsers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class OrangeHrmTest  {

    WebDriver webDriver = null;
    FileInputStream values= null;
    String url ="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    Properties properties = null;

    public OrangeHrmTest()
    {
        try
        {
            values = new FileInputStream("values");
            properties = new Properties();
            properties.load(values);
        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }
    @BeforeTest
    public void LaunchBrowser()
    {
        String browserName=properties.getProperty("browserName");
        Browser browser = new Browser();
        webDriver = browser.getWebdriver(browserName);
        webDriver.get(url);
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage=new LoginPage(webDriver);
        String userName=properties.getProperty("userName");
        String password=properties.getProperty("password");
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        DashBoard dashBoard = new DashBoard(webDriver);
        String currentUrl=dashBoard.CurrentUrl();
        Assert.assertEquals(currentUrl,"https://opensource-demo.orangehrmlive.com/index.php/dashboard","FAIL");
    }

    @Test
    public void test001()
    {
        DashBoard dashBoard=new DashBoard(webDriver );
        String adminText = dashBoard.getAdminText();
        Assert.assertEquals(adminText,"Admin","FAIL");
        dashBoard.clickAdmin();
        ViewSystemUsers viewSystemUsers=new ViewSystemUsers(webDriver);
        String addText = viewSystemUsers.getAddText();
        Assert.assertEquals(addText,"Add","FAIL");
        viewSystemUsers.clickAdd();
        SaveSystemUserPage saveSystemUserPage = new SaveSystemUserPage(webDriver);
        String role=properties.getProperty("userRole");
        saveSystemUserPage.enterUserRole(role);
        String employeeName=properties.getProperty("employeeName");
        saveSystemUserPage.enterEmployeeName(employeeName);
        String userNameReg=properties.getProperty("userNameReg");
        saveSystemUserPage.enterUserName(userNameReg);
        String status=properties.getProperty("status");
        saveSystemUserPage.status(status);
        String passwordReg=properties.getProperty("passwordReg");
        saveSystemUserPage.enterPassword(passwordReg);
        String confirmPassword=properties.getProperty("confirmpassword");
        saveSystemUserPage.enterConfirmPassword(confirmPassword);
        saveSystemUserPage.clickSave();

    }
   @Test
    public void test002()
    {
        webDriver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
        DashBoard dashBoard=new DashBoard(webDriver );
        dashBoard.clickAdmin();
        ViewSystemUsers viewSystemUsers = new ViewSystemUsers(webDriver);
        String searchText = viewSystemUsers.getSearchText();
        Assert.assertEquals(searchText,"Search","FAIL");
        String searchName=properties.getProperty("searchName");
        viewSystemUsers.searchUser(searchName);
        viewSystemUsers.clickSearch();
        String getSearchComText = viewSystemUsers.searchUser();
        Assert.assertEquals(getSearchComText,getSearchComText,"FAIL");

    }

    @AfterTest
    public void quitBrowser()
    {
        webDriver.quit();
    }
}
