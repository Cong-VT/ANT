package com.ant.cocoon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClosedMessage {
    public  void msgCode_64 (WebDriver driver,String screenNbr) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Xpath  message
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
        String MessageXpath ="//div[contains(@class, 'x-window x-message-box x-layer x-window-default x-closable x-window-closable x-window-default-closable x-border-box')]/div[3]/div/div/a/span";
        WebElement btnOK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MessageXpath)));
        btnOK.click();

        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));


    }
    public  void msgCode_confirm (WebDriver driver,String screenNbr,String btnPostition) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Xpath  message
        String xpath_yes="//div[contains(@class, 'x-window x-message-box x-layer x-window-default x-closable x-window-closable x-window-default-closable x-border-box')]/div[3]/div/div/a[2]";
        String xpath_no="//div[contains(@class, 'x-window x-message-box x-layer x-window-default x-closable x-window-closable x-window-default-closable x-border-box')]/div[3]/div/div/a[3]";

        if (btnPostition=="1") {// Yes
            WebElement btnYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_yes)));
            btnYes.click();
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
        }
        if (btnPostition=="2") {// No
            WebElement btnNo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_no)));
            btnNo.click();
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
        }



    }



}
