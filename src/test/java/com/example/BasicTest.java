package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BasicTest {
    WebDriver driver;    
    // WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @Test(enabled=false)   
    public void openGoogleAndSearch() {
        driver.get("https://www.google.com/?hl=en");
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        driver.findElement(By.name("q")).submit();
    }
    //test classname
    @Test(enabled=false)   
    public void openWikiAndSearch() {
        driver.get("https://en.wikipedia.org/wiki/Taco");
        String text= driver.findElement(By.className("infobox-caption")).getText();
         Assert.assertTrue(text.contains("Three varieties of taco "),
                "Expected text 'Three varieties of taco ' was not found on the page!");

    }
    //test xpath
    @Test
    public void openWebsiteAndSearch() {
        driver.get("https://en.wikipedia.org/wiki/Taco");
        String text= driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr[1]/td/div/a[3]")).getText();
         Assert.assertTrue(text.contains("al pastor"),
                "Expected text 'al pastor' was not found on the page!");

    }


    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
