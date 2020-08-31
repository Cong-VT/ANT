package com.ant.project.perfetti.run;
import com.ant.cocoon.ClosedMessage;
import com.ant.cocoon.ResetScreentoCreate;
import com.ant.cocoon.ribbon_Save;
import  com.ant.project.perfetti.webElementsDefine.defineXpathlogin;

import android.os.Build;
import com.ant.cocoon.Login;

import androidx.annotation.RequiresApi;

import com.ant.cocoon.getUrls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
    WebDriverWait wait = new WebDriverWait(driver, 20);

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

    // IN10100 - review testing
    String IN10100=urls+"/IN10100";
    driver.navigate().to(IN10100);
    System.out.print("Open screen : " + IN10100 +'\n');
    Popup_selectBranchID getbranch =new Popup_selectBranchID();
    getbranch.getbranchID (driver,IN10100,"HO CHI MINH","100742");
    wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
               //<- Xem lô nhập kho đã có -->
            OpenBatNbrExisted getbatnbr=new OpenBatNbrExisted();
            getbatnbr.IN10100(driver,"IN003280","HO");
              //<- Tạo mới lô nhập kho -->
            ResetScreentoCreate resetIN10100=new ResetScreentoCreate();
            resetIN10100.resetGetNew(driver,"IN10100");
            CreateBatNbr IN10100_create=new CreateBatNbr();
                  //>> RElease lô nhập kho
            IN10100_create.IN10100(driver,"871111",8,"R");
            ribbon_Save IN10100Save=new ribbon_Save();
            IN10100Save.IN10100(driver,"Cập Nhật Dữ Liệu","Lưu thành công","OK");
            //Closed messcode succes
             wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
             ClosedMessage processdone=new ClosedMessage();
             processdone.msgCode_64(driver,"IN10100");
             System.out.print("Done screen : " + IN10100 +'\n');

    // IN10200 - review testing
    String IN10200=urls+"/IN10200";
    driver.navigate().to(IN10200);
    System.out.print("Open screen : " + IN10200 +'\n');
    Popup_selectBranchID getbranchIN10200 =new Popup_selectBranchID();
    getbranchIN10200.getbranchID (driver,IN10200,"HO CHI MINH","100742");
    wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
    //<- Xem lô xuất kho đã có -->
             OpenBatNbrExisted IN10200_getbatnbr=new OpenBatNbrExisted();
             IN10200_getbatnbr.IN10100(driver,"IN003286","HO");
                //<- Tạo mới lô nhập kho -->
              ResetScreentoCreate resetIN10200=new ResetScreentoCreate();
              resetIN10200.resetGetNew(driver,"IN10200");
              CreateBatNbr IN10200_create=new CreateBatNbr();
               //>> RElease lô nhập kho
               IN10100_create.IN10100(driver,"871111",8,"R");
               ribbon_Save IN10200Save=new ribbon_Save();
               IN10200Save.IN10100(driver,"Cập Nhật Dữ Liệu","Lưu thành công","OK");
               wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class,'x-mask-msg-text')]"),"Please wait..."));
               //Closed messcode succes
                ClosedMessage IN10200_processdone=new ClosedMessage();
                IN10200_processdone.msgCode_64(driver,"IN10200");




  }

   // driver.close();



}


