package com.qa.pages;

import com.qa.utils.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {


   public HomePage() {
      PageFactory.initElements(driver, this);
   }

   public String ValidatePageTitle() {
      return driver.getTitle();
   }

   public void ValidatePageCompletelyLoaded() {

      WebDriverWait wait=new WebDriverWait(driver,20);
      WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EggTimer-start-time-input-text")));

   }
   public void MaximizeBrowser(){
      driver.manage().window().maximize();

   }

   public Boolean EditableBox(){
      WebElement element = driver.findElement(By.id("EggTimer-start-time-input-text"));
       element.isEnabled();
      return true;
   }

   public void StartButton(){
      driver.findElement(By.cssSelector(".validTime")).click();
   }

   public void sendTime(){
      driver.findElement(By.id("EggTimer-start-time-input-text"));
   }


   public void AcceptAlert() throws InterruptedException {
      Thread.sleep(1000);
      Alert alert = driver.switchTo().alert();
      String alertMessage= driver.switchTo().alert().getText();
      System.out.println(alertMessage);
      alert.accept();

   }
}
