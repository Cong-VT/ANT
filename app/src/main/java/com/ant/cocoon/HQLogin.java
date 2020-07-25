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

public class HQLogin {
    public void logIn (WebDriver driver, String URL, long timeOuts,String xpathValue)
        // xpathValue : value to verify load done
    {
       try {
           driver.get(URL);
           WebDriverWait wait = new WebDriverWait(driver, timeOuts);
           WebElement uname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
           WebElement txtname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathValue)));
           System.out.print("Login success full ." + '\n');
       }catch (Exception e)
        {
           System.out.print("Login Failed ."+ '\n' );
        }
    }

}
