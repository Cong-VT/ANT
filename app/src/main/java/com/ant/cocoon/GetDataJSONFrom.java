package com.ant.cocoon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetDataJSONFrom {


    public String DataCombo (WebDriver driver, String xpath , String value) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        String batlist =driver.findElement(By.xpath(xpath)).getAttribute(value);
        System.out.println('\n' + " ##### Current BAT" + batlist + '\n');

        return batlist;
    }


}
