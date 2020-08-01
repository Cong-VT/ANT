package com.ant.project.perfetti.run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class Popup_selectBranchID {
    public  void getbranchID(WebDriver driver ,String screenNbr,String xpathDone) throws InterruptedException {

        driver.navigate().to(screenNbr);

        System.out.print("Open screen : " + screenNbr +'\n');

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement IN10100_popupbranch=driver.findElement(By.xpath("//*[contains(@id, 'winPopup_header-targetEl')]"));
        IN10100_popupbranch.click();

        WebElement teritory_clear=driver.findElement(By.xpath("//*[contains(@id, 'cboTerritory-triggerWrap')]/tbody/tr/td[2]"));
        teritory_clear.click();
        WebElement teritory=driver.findElement(By.xpath("//*[contains(@id, 'cboTerritory-triggerWrap')]/tbody/tr/td[3]"));
        // WebElement terr=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/span/div/table[1]/tbody/tr/td[2]/table/tbody/tr/td[3]/div")));
        Thread.sleep(500);
        teritory.click();
        Thread.sleep(500);
        WebElement slt_terri=driver.findElement(By.xpath("//td[contains(text(),'HO CHI MINH')]"));
        slt_terri.click();
        Thread.sleep(500);
        teritory.click();

        Thread.sleep(500);
        WebElement branch_clear=driver.findElement(By.xpath("//*[contains(@id, 'cboBranchID-triggerWrap')]/tbody/tr/td[2]"));
        branch_clear.click();
        WebElement branchlist=driver.findElement(By.xpath("//*[contains(@id, 'cboBranchID-triggerWrap')]/tbody/tr/td[3]"));
        // WebElement terr=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/span/div/table[1]/tbody/tr/td[2]/table/tbody/tr/td[3]/div")));
        Thread.sleep(500);
        branchlist.click();
        Thread.sleep(500);
        WebElement slt_branch=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(),'HOABTAN')]")));
        slt_branch.click();
        Thread.sleep(500);

        WebElement OK=driver.findElement(By.xpath("//*[contains(@id, 'btnPopupOk-btnWrap')]"));
        OK.click();
        long time1=System.currentTimeMillis();
        try {

            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
            //WebElement IN10100_BatNbr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id, 'BatNbr-inputEl')]")));
            WebElement IN10100_BatNbr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathDone)));
            IN10100_BatNbr.click();

        }catch (Exception e) {
            System.out.print("Time out at  " + 10 + "S" + '\n');
        }
        long time2=System.currentTimeMillis();
        long timeload=time2-time1;
        System.out.print("Load done total time : " + timeload + '\n');
    }



}

