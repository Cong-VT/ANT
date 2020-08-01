package com.ant.cocoon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class SaveData {
    public void IN10100 (WebDriver driver,String handle,String MessData,String btnclick) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement btnhandle=driver.findElement(By.xpath("//*[contains(@id, 'Handle-triggerWrap')]/tbody/tr/td[2]"));
        btnhandle.click();
        Thread.sleep(500);
        String slthandle= "//td[contains(text(),'" +handle + "')]";
        System.out.print("Xpath Handle" + slthandle  + '\n');
        WebElement handlesltd=driver.findElement(By.xpath(slthandle));
        handlesltd.click();
        WebElement btnSave= driver.findElement(By.xpath("//*[contains(@id, 'menuClickbtnSave-btnEl')]"));
        btnSave.click();

        String message_success="//*[text()='"+MessData+"']";
        WebElement message= driver.findElement(By.xpath(message_success));
        message.click();


        if (handle.toString()!="Cập Nhật Dữ Liệu") {
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"), "Loading..."));
            String lbl_closed = "//span[contains(text(),'" + btnclick + "')]";
            WebElement btnclosed = driver.findElement(By.xpath(lbl_closed));
            btnclosed.click();
        }else
            if(handle.toString()=="Cập Nhật Dữ Liệu") {
                wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"), "Loading..."));
                String lbl_closed = "//div[contains(text(),'" + handle + "')]";
                WebElement btnclosed = driver.findElement(By.xpath(lbl_closed));
                btnclosed.click();
            }

    }


}
