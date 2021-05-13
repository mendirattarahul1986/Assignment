package com.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public  static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("/Users/Z002KR5/Downloads/TestAssignment/src/main/java/com/qa/config/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.getMessage();
        }
    }

        public static void initialzation() {

            System.out.println(prop.getProperty("browser"));
            System.out.println(prop.getProperty("url"));
            String browserName = prop.getProperty("browser");
            if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "/Users/Z002KR5/Downloads/BDDTEST/chromedriver");
                driver = new ChromeDriver();
            }
            driver.manage().deleteAllCookies();
            driver.get(prop.getProperty("url"));


        }
    }
