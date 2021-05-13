package com.qa.pages;


import com.qa.utils.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ValidateTimer extends TestBase {
    long StartTime;
    long EndTime;
    public static String before = null;
    public static String after = null;


    public void CheckTimer(Integer i){
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS) ;
        after = driver.findElement(By.cssSelector("span")).getText();
        after = getSeconds(after);
        StartTime = System.currentTimeMillis();
        i = Integer.parseInt(after) - 1;
        before = after;
        while (true) {
            EndTime = System.currentTimeMillis();
            after = driver.findElement(By.cssSelector("span")).getText();
            after = getSeconds(after);
            if (after.equals("0"))
                break;
            boolean isAfterEqualsBefore = after.equals(before);
            boolean countReducedCorrectly = !isAfterEqualsBefore && after.equals(String.valueOf(i));
            boolean countStableWithinTimeLimit = isAfterEqualsBefore && !((EndTime - StartTime) > 5000);

            if(!countStableWithinTimeLimit) {
                Assert.assertEquals(after, String.valueOf(i));

            }
            if(countReducedCorrectly) {
                StartTime = System.currentTimeMillis();
                i--;
                before = after;
            }
        }
                
        
    }

    private String getSeconds(String after) {
        int i = 0;
        int seconds = 0;
        int num = 0;
        while (i < after.length()) {
            char ch = after.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (num != 0) {
                seconds = seconds * 60 + num;
                num = 0;

            }
            i++;
        }

        return String.valueOf(seconds);
    }
    }

