package BDDFrameworkSelenium;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class AppTest {
    WebDriver dr;

    @Test
    public void Firefox() {
        dr = new EdgeDriver();
        dr.get("https://www.yahoo.com");
    }


}
