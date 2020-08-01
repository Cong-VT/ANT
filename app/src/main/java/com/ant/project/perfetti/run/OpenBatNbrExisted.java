package com.ant.project.perfetti.run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenBatNbrExisted {

    public  static  void main(String [] atn) {


    }
    public  void    IN10100 (WebDriver driver,String BatNbr ,String xpathDone) throws InterruptedException {
       WebDriverWait wait = new WebDriverWait(driver, 10);

         String xpathBatnNbr ="//*[contains(@id, 'BatNbr-triggerWrap')]/tbody/tr/td[3]";
        WebElement btnBatNbr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBatnNbr)));
        btnBatNbr.click();

        Thread.sleep(1000);
        String BatNbrxpath= "//td[contains(text(),'"+ BatNbr +"')]";
        //td[contains(text(),'HOABTAN')]
        WebElement slt_BatNbr=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BatNbrxpath)));
        slt_BatNbr.click();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));

        WebElement StatusBat=driver.findElement(By.xpath("//*[contains(@id, 'Status-bodyEl')]/input"));
        String Status=StatusBat.getAttribute("value");
        System.out.print("Status Of BatNbr : " + Status + '\n');


    }

}
