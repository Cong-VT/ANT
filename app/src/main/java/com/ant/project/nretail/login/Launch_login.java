package com.ant.project.nretail.login;
import  com.ant.worker.defineElements;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.ant.cocoon.HQLogin;
import com.ant.worker.GMTDateTime;
import com.ant.worker.timeCount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Launch_login {

  @RequiresApi(api = Build.VERSION_CODES.O)
  public static  void   main(String [] atr) throws IOException {

    HQLogin login = new HQLogin();

    System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");
    String filepath=new variable().PathDir;
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
      login.logIn(driver, "http://nretail.vn/auth/login/", 10, "/html/body/kt-auth/div/div/div[2]/kt-login/div[1]/div/form/div[1]/div/div/dx-validation-group/div[1]/div[2]/div/dx-text-box/div/div[1]/input");
    } catch (Exception e) {
    }

    long etime = System.currentTimeMillis();
    timeCount time = new timeCount();
    float t = timeCount.gettime(stime, etime);
    WebDriverWait wait = new WebDriverWait(driver, 2);

    String testFileTitle="###################### Start run at : " + GMTDateTime.DateTime();
        fos.write(testFileTitle.getBytes());

          String TestScenarios_LoadTest ='\n'+ "1.Load test Information" + '\n';
          fos.write(TestScenarios_LoadTest.getBytes());
          String TestScenarios_title ="- Web Tittle : "+ driver.getTitle().toString() + '\n';
          fos.write(TestScenarios_title.getBytes());
          String TestScenarios_LoadTest_timeload = "- Time to loading page done (ms) : " + t +'\n';
          fos.write(TestScenarios_LoadTest_timeload.getBytes());
          String TestScenarios_LoadTest_pageSize = "- Total length of the Pgae Source is  : " + driver.getPageSource().length() +'\n';
          fos.write(TestScenarios_LoadTest_pageSize.getBytes());

         int totalLinkSize2 = driver.findElements(By.xpath("//*")).size();
          // System.out.println("Total Links by Way2 : " + totalLinkSize2);
          String TestScenarios_LoadTest_totalements = "- Total elements is  : " + totalLinkSize2 +'\n';
          fos.write(TestScenarios_LoadTest_totalements.getBytes());

          String languagedefaultxpath="//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[1]/div/form/div[1]/div/div/dx-validation-group/div[1]/div[2]/div/dx-select-box/div[1]/div/div[1]/input";
          // WebElement nationaldefault=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(languagedefaultxpath)));
           String langegedeault=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(languagedefaultxpath))).getAttribute("value").toString();

          String nationalxpath="//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[1]/div/form/div[1]/div/div/dx-validation-group/div[1]/div[2]/div/dx-select-box/div[1]/div/div[2]/div[2]/div/div";
          WebElement national=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nationalxpath)));
          national.click();
          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div/div[1]/div/div[1]/div[2]")));
          WebElement table = driver.findElement(By.xpath("//html/body/div/div/div/div/div[1]/div/div[1]/div[2]"));//dx-scrollview-content
          List<WebElement> rows = table.findElements(By.tagName("div"));

          // remove data dyplic
          boolean ind = false;
          for (int i = 0; i < rows.size(); i++) {
            rows.remove(i);
             for (int j = 0; j < rows.size(); j++) {
                      if (rows.get(i).getText().equals(rows.get(j).getText()))
                      { System.out.println(rows.get(i).getText()  +" "+ rows.get(j).getText());
                  ind = true;
              }
             }
          }





          int xpathCountlanguage = driver.findElements(By.xpath("/html/body/div/div/div/div/div[1]/div/div[1]/div[2]/*")).size();
          String TestScenarios_LoadTest_totalanguage = "+ Total country/Language is  : " + xpathCountlanguage +'\n';
          fos.write(TestScenarios_LoadTest_totalanguage.getBytes());

         //>>  Detail language
            //  String [] Listlanguage=new String[xpathCountlanguage+10];
                int i =1;
                 for(WebElement element:rows )
                 {
                     String data="              Language :" + i +  ".   " + element.getText()+'\n';
                        System.out.printf(data);// print to log
                        fos.write(data.getBytes());// Write to file Result
                       // Listlanguage[i-1]=element.getText();
                    i++;
                   }
            String wlangegedeault ="- Default language : " + langegedeault + '\n';
            fos.write(wlangegedeault.getBytes());
            //national.click();// closed button


      String TestScenarios_GUI_language ='\n'+ "2.Testing Language Show " + '\n';
      fos.write(TestScenarios_GUI_language.getBytes());

      ArrayList<String> Listalllanguage = new ArrayList<String>();
      int il=0;
      for(WebElement element:rows )
      {
        Listalllanguage.add(il,element.getText());
        System.out.print("new list " + Listalllanguage.get(il) + '\n');
        il++;
      }



     // driver.navigate().refresh();


    }

private static  void Testlanguage (WebDriver driver ,FileOutputStream fos ,String langcode) throws IOException {
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

   // driver.close();



}


