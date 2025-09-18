package com.example.advanced;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownTest {
    private WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void testDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // Select dropdown option by visible text
        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.xpath("//option[text()='Option 2']")).click();

        // WebElement dropdown = driver.findElement(By.id("country"));
        // Select select = new Select(dropdown);
        // By visible text
        // select.selectByVisibleText("Canada");
        // By index
        // select.selectByIndex(2);
        // By value
        // select.selectByValue("CA");
        
        // Verify the selected option
        String selectedOption = driver.findElement(By.xpath("//option[@selected='selected']")).getText();
        Assert.assertTrue(selectedOption.contains("Option 2"), "Selected option does not match expected value");
    }
    @AfterClass
    public void teardown() {
        if (driver != null){
            driver.quit();
        }
    }
    
}
