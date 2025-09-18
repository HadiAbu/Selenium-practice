package com.example.advanced;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IframeTest {
    private WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test(enabled=false)
    public void testIframe() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        // Switch to iframe using its ID
        driver.switchTo().frame("mce_0_ifr");
        
        // Now you can interact with elements inside the iframe
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Hello, I am inside an iframe!");
        
        // Switch back to the main content
        driver.switchTo().defaultContent();
        
        // Verify that we are back in the main content by checking for an element outside the iframe
        String heading = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(heading.contains("An iFrame containing the TinyMCE WYSIWYG Editor"), "Heading text does not match expected value");
    }
    @AfterClass
    public void teardown() {
        if (driver != null){
            driver.quit();
        }
    }
    
}
