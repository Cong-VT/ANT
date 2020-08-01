package com.ant.cocoon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetScreentoCreate {
    public void resetGetNew(WebDriver driver , String ScreenNbr) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
       if (ScreenNbr.equals("IN10100")) {
           WebElement clearbtn = driver.findElement(By.xpath("//*[contains(@id, 'BatNbr-triggerWrap')]/tbody/tr/td[2]"));
           clearbtn.click();
           wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
       }


    }


}
