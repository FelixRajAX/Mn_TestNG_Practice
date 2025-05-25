package BDDFrameworkSelenium;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;


public class AppTest {
    WebDriver dr;
    WebDriverWait wt;

    @BeforeTest
    public void Handle_All_Common_Initializations(){
        dr = new EdgeDriver();
        dr.manage().window().maximize();
        wt = new WebDriverWait(dr, Duration.ofSeconds(20));
    }

    @Test
    public void Search_and_SelectFromAjaxList_Specific_ValueIn_AmazonSite() {
        //Scenario to navigate to Amazon and type a value in search box in Amazon site and select a specific search result.
        dr.get("https://www.amazon.in/");
        WebElement Searchbox = dr.findElement(By.id("twotabsearchtextbox"));
        Searchbox.sendKeys("iphone 14");
        //Wait is used here to handle the delay in loading the dynamic search list
        List<WebElement> SearchResultValues = wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']")));
        SearchResultValues.get(9).click();
    }

    @Test
    public void Search_and_SelectFromResults_AmazonSite(){
        //Scenario to navigate to Amazon and type a value in search box in Amazon site and select one from search result
        dr.get("https://www.amazon.in/");
        WebElement Searchbox = dr.findElement(By.id("twotabsearchtextbox"));
        Searchbox.sendKeys("iphone 15");
        Searchbox.sendKeys(Keys.ENTER);
        List<WebElement> SearchResult = wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']")));
        SearchResult.get(4).click();
    }

    @AfterTest
    public void Clear_All_Browser_Sessions(){
        dr.quit();
    }
}
