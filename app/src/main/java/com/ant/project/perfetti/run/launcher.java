package com.ant.project.perfetti.run;
import com.ant.cocoon.ResetScreentoCreate;
import com.ant.cocoon.SaveData;
import  com.ant.project.perfetti.webElementsDefine.defineXpathlogin;

import android.graphics.Region;
import android.os.Build;
import com.ant.cocoon.Login;

import androidx.annotation.RequiresApi;

import com.ant.cocoon.getUrls;
import com.ant.worker.GMTDateTime;
import com.ant.worker.timeCount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;

public class launcher {
  @RequiresApi(api = Build.VERSION_CODES.O)

  public static  void   main(String [] atr) throws IOException, InterruptedException {
    getUrls login = new getUrls();
    defineXpathlogin Xpathlogin=new defineXpathlogin();
    System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");
    String filepath=new login_variable().PathDir;
    File file=new File(filepath);
    if (!file.exists())
    {
      file.mkdirs();
    }
    File myappFile=new File(file  + File.separator + "Login.txt");
    FileOutputStream fos = new FileOutputStream(myappFile);
    WebDriver driver = new ChromeDriver();
    //driver.manage().window().maximize();

    long stime = System.currentTimeMillis();
    String headerlogin= new login_defineXpath().login_headerform;
    String username=new login_variable().UserName;
    String password= new login_variable().Password;
    String urls=new login_variable().URL;
    String xpathusername=new login_defineXpath().login_txt_uname_input;
    String xpathpass=new login_defineXpath().login_txt_pw_input;
    String btnlogin =new login_defineXpath().login_btn_login;
    String mainmenu =new login_defineXpath().Main;

    new Login().logIn(driver,urls,username,password,10,xpathusername,xpathpass,2,btnlogin,mainmenu);

    String IN10100=urls+"/IN10100";
    driver.navigate().to(IN10100);

    System.out.print("Open screen : " + IN10100 +'\n');
    Popup_selectBranchID getbranch =new Popup_selectBranchID();
    getbranch.getbranchID (driver,IN10100,"//*[contains(@id, 'BatNbr-inputEl')]");

   // OpenBatNbrExisted getbatnbr=new OpenBatNbrExisted();
    //getbatnbr.IN10100(driver,"IN003280","");

    ResetScreentoCreate resetIN10100=new ResetScreentoCreate();
    resetIN10100.resetGetNew(driver,"IN10100");
    CreateBatNbr IN10100_create=new CreateBatNbr();
    //String Qty="8";
    IN10100_create.IN10100(driver,"871111",8,"R");
    SaveData IN10100Save=new SaveData();
    IN10100Save.IN10100(driver,"Cập Nhật Dữ Liệu","Xử lí hoàn tất","OK");



  }

   // driver.close();



}


