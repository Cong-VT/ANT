package com.ant.cocoon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ribbon_Delete {
    public void DeleteBat (WebDriver driver,String ScreenNbr,String xpathCursor,String Confirm) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement btnhandle = driver.findElement(By.xpath("//*[contains(@id, 'BatNbr-bodyEl')]/table/tbody/tr/td"));
        WebElement delete = driver.findElement(By.xpath(xpathCursor));
        delete.click();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
    }

    public void DeleteGrid_Row (WebDriver driver,String ScreenNbr,String BatNbr,String Confirm) {






    }




}
