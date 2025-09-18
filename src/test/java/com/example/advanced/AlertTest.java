package com.example.advanced;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class AlertTest {
        private WebDriver driver;
        @BeforeClass
        public void setup() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            
        }
        @Test
        public void testAlert() {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
            
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            
            Assert.isTrue(alertText.contains("I am a JS Alert"), "Alert text does not match expected value");
            alert.accept();
        }
        @Test
        public void testConfirmationAlert() {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
            
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            
            Assert.isTrue(alertText.contains("I am a JS Confirm"), "Alert text does not match expected value");
            alert.accept();
        }
        @Test
        public void testPromptAlert() {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
            
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            
            Assert.isTrue(alertText.contains("I am a JS prompt"), "Alert text does not match expected value");
            alert.sendKeys("Test Input");
            alert.accept();

            String resultText = driver.findElement(By.id("result")).getText();
            Assert.isTrue(resultText.contains("You entered: Test Input"), "Result text does not match expected value");

        }
        @AfterClass
        public void teardown() {
            if (driver != null) {
                driver.quit();
            }
        }

    
}
