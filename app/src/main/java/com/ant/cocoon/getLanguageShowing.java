package com.ant.cocoon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.IOException;

public class getLanguageShowing {

    public static  void Testlanguage (WebDriver driver , FileOutputStream fos , String langcode,  String xpath) throws IOException {
        String log_Login_language_header = '\n' + "####### language Show By : " + langcode;
        System.out.print("####### language Show By Default: " + langcode + '\n');
        fos.write(log_Login_language_header.getBytes());

        String loginlangua_titlebody ='\n' + "- Title Body : " +  driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[1]/div/div")).getText();
        fos.write(loginlangua_titlebody.getBytes());
        String loginlangua_user ='\n' + "- User : " +  driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[1]/div/form/div[1]/div/div/dx-validation-group/div[1]/div[1]")).getText();
        fos.write(loginlangua_user.getBytes());
        String loginlangua_pass ='\n' + "- User : " +  driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[1]/div/form/div[1]/div/div/dx-validation-group/div[2]/div[1]")).getText();
        fos.write(loginlangua_pass.getBytes());
        String loginlangua_fotgotpass ='\n' + "- Forgot Pass : " +  driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[1]/div/form/div[2]/a")).getText();
        fos.write(loginlangua_fotgotpass.getBytes());
        String loginlangua_Login ='\n' + "- button Login  : " +  driver.findElement(By.xpath("//*[@id=\"kt_login_signin_submit\"]")).getText();
        fos.write(loginlangua_Login.getBytes());
        String loginlangua_noaccount ='\n' + "- No Acccount  : " +  driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[2]/span")).getText();
        fos.write(loginlangua_noaccount.getBytes());
        String loginlangua_register ='\n' + "- Register  : " +  driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[2]/a")).getText();
        fos.write(loginlangua_register.getBytes());

        WebElement btnregiser=driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[2]/a"));
        btnregiser.click();
        String registerlangua_register_header ='\n' + "- Register Form - Header  : " +  driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-register/div/div/div[1]")).getText();
        fos.write(registerlangua_register_header.getBytes());
        String registerlangua_register_phone ='\n' + "- Register Form - Phone   : " +  driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-register/div/div/dx-validation-group/div/div[1]")).getText();
        fos.write(registerlangua_register_phone.getBytes());
        String registerlangua_register_back ='\n' + "- Register Form - Back  : " +  driver.findElement(By.xpath("//*[@id=\"kt_login_signup_cancel\"]")).getText();
        fos.write(registerlangua_register_back.getBytes());
        String registerlangua_register_send ='\n' + "- Register Form - Send OTP  : " +  driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-register/div/div/div[2]/button[2]")).getText();
        fos.write(registerlangua_register_send.getBytes());


    }

}
