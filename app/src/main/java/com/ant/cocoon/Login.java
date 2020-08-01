package com.ant.cocoon;
import android.widget.EditText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.TreeMap;

import jxl.write.WriteException;

public class Login {
    public void logIn (WebDriver driver, String URL,String userName ,String password ,long timeOuts
                            ,String xpathuname
                            ,String xpathpass
                            , int captcha
                            ,String xpathbtnlogin
                            ,String xpathloginsuccess)
    // xpathValue : value to verify load done
    {
        try {

            getUrls URLS=new getUrls();
            URLS.logIn(driver,URL,10,xpathuname);
            driver.get(URL);
            WebDriverWait wait = new WebDriverWait(driver, timeOuts);

            WebElement txtuname=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathuname)));
            txtuname.click();
            txtuname.sendKeys(userName);
            WebElement txtpassword=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathpass)));
            txtpassword.click();
            txtpassword.sendKeys(password);

            WebElement btnlogin=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathbtnlogin)));
            btnlogin.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathloginsuccess)));

        }catch (Exception e)
        {
            System.out.print("Login Failed ."+ '\n' );
        }
    }

}
