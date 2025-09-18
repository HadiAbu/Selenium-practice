package com.example.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By welcomeMsg = By.id("welcomeText");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMsg).getText();
    }
}
