package com.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public  static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("/src/main/java/com/qa/config/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.getMessage();
        }
    }

        public static void initialzation() {

            System.out.println(prop.getProperty("browser"));
            String browserName = prop.getProperty("browser");
            if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "/chromedriver");
                driver = new ChromeDriver();
            }
            else if(browserName.equals("firefox")) {
                System.setProperty("webdriver.firefox.driver", "/firefoxdriver");
                driver = new FirefoxDriver();
            }
            else {
                System.out.println("please pass the correct browser" + browserName);
            }
            driver.manage().deleteAllCookies();
            driver.get(prop.getProperty("url"));


        }



    }
