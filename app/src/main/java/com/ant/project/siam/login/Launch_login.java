package com.ant.project.siam.login;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.ant.cocoon.HQLogin;
import com.ant.worker.*;
import com.ant.worker.GMTDateTime;
import com.ant.worker.getLogin;
import com.ant.worker.fileUltility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Launch_login {

  @RequiresApi(api = Build.VERSION_CODES.O)
  public static  void   main(String [] atr) throws IOException {

    HQLogin login = new HQLogin();
    System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");
    String filepath=new aa_variable().PathDir;
    File file=new File(filepath);
    if (!file.exists())
    {
      file.mkdirs();
    }
    File myappFile=new File(file  + File.separator + "Login.txt");
    FileOutputStream fos = new FileOutputStream(myappFile);


    WebDriver driver = new ChromeDriver();
    long stime = System.currentTimeMillis();

    try {
      login.logIn(driver, "https://portal.hqsoft.vn:7443/Siam2/", 10, "//*[contains(@id, 'txtUserName-inputEl')]");
    } catch (Exception e) {
    }

    long etime = System.currentTimeMillis();
    timeCount time = new timeCount();
    float t = timeCount.gettime(stime, etime);

    String testFileTitle="###################### Start run at : " + GMTDateTime.DateTime();
        fos.write(testFileTitle.getBytes());

        String TestScenarios_LoadTest ='\n'+ "1.Load test Information" + '\n';
          fos.write(TestScenarios_LoadTest.getBytes());
          String TestScenarios_LoadTest_timeload = "- Time to loading page done (ms) : " + t +'\n';
          fos.write(TestScenarios_LoadTest_timeload.getBytes());
          String TestScenarios_LoadTest_pageSize = "- Total length of the Pgae Source is  : " + driver.getPageSource().length() +'\n';
          fos.write(TestScenarios_LoadTest_pageSize.getBytes());

         int totalLinkSize2 = driver.findElements(By.xpath("//*")).size();
          // System.out.println("Total Links by Way2 : " + totalLinkSize2);
          String TestScenarios_LoadTest_totalements = "- Total elements is  : " + totalLinkSize2 +'\n';
          fos.write(TestScenarios_LoadTest_totalements.getBytes());

        String TestScenarios_DataList ='\n'+ "1.Load test Information" + '\n';












  }



}


