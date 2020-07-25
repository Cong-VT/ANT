package com.ant.worker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class defineElements {
    public void dropdownbutton (WebDriver driver,WebElement name,String xpath,long timeOuts){

        WebDriverWait wait = new WebDriverWait(driver, timeOuts);
         name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
         name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

    }


}
