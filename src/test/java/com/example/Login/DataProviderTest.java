package com.example.Login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//This will run the testLogin() method three times, once for each data set.
public class DataProviderTest {
    
    // declaration of DataProvider
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            // each array = one test run
            {"hadi", "pass123"},
            {"john", "password"},
            {"admin", "adminPass"}
        };
    }

    // usage of DataProvider
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.out.println("Testing login with: " + username + " / " + password);
        // Example: LoginPage.login(username, password);
        // Assert: dashboard appears
    }
}
