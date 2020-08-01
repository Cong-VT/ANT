package com.ant.project.perfetti.run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CreateBatNbr {
    public  void IN10100 (WebDriver driver ,String InvtID , int Qty,String Handle) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Chọn lý do
        WebElement btnReason =driver.findElement(By.xpath("//*[contains(@id, 'ReasonCD-triggerWrap')]/tbody/tr/td[3]"));
        btnReason.click();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
        String reasoncode= "//td[contains(text(),'DC')]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(reasoncode)));
        WebElement Reason =driver.findElement(By.xpath(reasoncode));
        Reason.click();

        // Nhập diễn giải
        WebElement txtDescr =driver.findElement(By.xpath("//*[contains(@id, 'Descr-inputEl')]"));
        txtDescr.click();
        txtDescr.sendKeys("Testing");

        // CHuyển xuống lướin chi tiết
        WebElement bodyGrid =driver.findElement(By.xpath("//*[contains(@id, 'pnlTrans-body')]"));
        bodyGrid.click();
        WebElement  grdTrans_body =driver.findElement(By.xpath("//*[contains(@id, 'grdTrans-body')]/div/table/tbody/tr/td"));
        grdTrans_body.click();

        //Chọn mã sản phẩm
        WebElement  InvtID_1 =driver.findElement(By.xpath("//*[contains(@id, 'grdTrans-body')]/div/table/tbody/tr/td[2]"));
        InvtID_1.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, 'cboTransInvtID-triggerWrap')]/tbody/tr/td[3]/div")));
        WebElement  InvtID_1_Dropdown =driver.findElement(By.xpath("//*[contains(@id, 'cboTransInvtID-triggerWrap')]/tbody/tr/td[3]/div"));
        InvtID_1_Dropdown.click();
        String InvtID_1_SKUCode= "//td[contains(text(),'" + InvtID  + "')]";
        WebElement  InvtID_1_slt =driver.findElement(By.xpath(InvtID_1_SKUCode));
        InvtID_1_slt.click();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Loading..."));

        String col_xpathDescr="//*[contains(@id, 'grdTrans-body')]/div/table/tbody/tr/td[3]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(col_xpathDescr)));
        WebElement  InvtID_1_Descr =driver.findElement(By.xpath(col_xpathDescr));
        InvtID_1_Descr.click();

        // Nhập số lượng
        Thread.sleep(3000);
        String col_xpathQty="//*[contains(@id, 'grdTrans-body')]/div/table/tbody/tr/td[5]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(col_xpathQty)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(col_xpathQty)));
        WebElement  InvtID_1_Qty =driver.findElement(By.xpath(col_xpathQty));
        InvtID_1_Qty.click();
        //Thread.sleep(2000);
        String col_xpathQty1="//*[contains(@id, 'txtTransQty-inputEl')]";
        WebElement  InvtID_1_Qtysend =driver.findElement(By.xpath(col_xpathQty1));
        //InvtID_1_Qtysend.click();
        InvtID_1_Qtysend.sendKeys(String.valueOf(Qty));

        String col_xpathLineAmt="//*[contains(@id, 'grdTrans-body')]/div/table/tbody/tr/td[8]";
        WebElement  InvtID_1_LineAmt =driver.findElement(By.xpath(col_xpathLineAmt));
        InvtID_1_LineAmt.click();
       // wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Loading..."));





    }


}
