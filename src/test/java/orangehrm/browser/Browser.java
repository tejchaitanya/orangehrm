package orangehrm.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    WebDriver webDriver=null;
    public WebDriver getWebdriver(String browserName)
    {
        if (browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            webDriver=new ChromeDriver();
            webDriver.manage().window().maximize();
        }
        else if(browserName.equalsIgnoreCase("mozilla"))
        {
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            webDriver=new FirefoxDriver();

        }

        return webDriver;
    }
}
