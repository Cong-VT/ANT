package com.ant.cocoon;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class SQL_JDBC
{
    public static void main(String[] args)
    {
        Calendar cal = new GregorianCalendar();

        //String name="cmscim";
        //String filename = "D:\\programs\\Tomcat 6.0\\webapps\\timescape\\canteen_scheduller\\CMS_CSV\\cms_cim\\"+ name+"-"+cal.get(Calendar.YEAR) +"-" +(cal.get(Calendar.MONTH)+1) + "-"+cal.get(Calendar.DATE)+".csv";
        Connection conn = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://TRUONGSAD;databasename=SIAM_eSales";

        String userName = "sa";
        String password = "P@ssw0rd";
        Statement stmt;
        try
        {

            Class.forName(driver);//.newInstance();
            conn = DriverManager.getConnection(url,userName,password);
            String query = "SELECT UserName,CpnyID,Password FROM dbo.Users where Username ='100034'";
            stmt = conn.createStatement();
            ResultSet flag = stmt.executeQuery(query);
         // FileInputStream fis=new FileInputStream("Result/test.xlsx");
            //  FileInputStream file=new FileInputStream(filepath);
            //File myappFile=new File(file  + File.separator + filename);

            int totalRecord =0;
            while (flag.next()) {
                //System.out.print("USer Name IS :  "  + flag.getString("UserName") + " || Password IS : " + flag.getString(3) + '\n');
                System.out.print('\n' + "Username :  " +flag.getString("UserName")
                                    + '\n'+ "CpnyID  :  "+ flag.getString("CpnyID")
                                        + '\n' + "Passw0rd : " + flag.getString("Password")
                        + '\n');
                totalRecord++;
                System.out.print("start  excel :" + flag.getString("UserName"));
               // XSSFWorkbook wb=new XSSFWorkbook(fis);


            }
            System.out.print('\n' + ">>>>>> Tổng sổ record trả về :  " + totalRecord +'\n');


            conn.close();
            System.out.println('\n' + ">>>>>> Done Test <<<<<<<<  " + '\n');
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    public Connection sqlconn (String SQLServerName , String DBName, String DBloginUser, String DBLoginPw, String sqlQuery) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        //String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url1="jdbc:sqlserver://";
        String url2_ServeName=SQLServerName;
        String url3_DBName =";databasename="+DBName;
        //String url = "jdbc:sqlserver://TRUONGSAD;databasename=SIAM_eSales";
        String url = url1+url2_ServeName+url3_DBName;

        String userName = DBloginUser;
        String password = DBLoginPw;
        Statement stmt;
        Class.forName(driver);//.newInstance();
        conn = DriverManager.getConnection(url,userName,password);
        return conn;

    }

    public ResultSet sqlQuery (Connection conn, String sqlQuery) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String query = sqlQuery;
        stmt = conn.createStatement();
        ResultSet flag = stmt.executeQuery(query);

        return flag;
    }




    public String readDataFromExcel(int rowcount,int columncount,String filepath,String Sheetname )
    {
        String data="";
       // String filepathSQL="Result/SQL";
        try
        {
            FileInputStream input= new FileInputStream(filepath);
           // XSSFWorkbook wb=new XSSFWorkbook(input);
           // XSSFSheet sh=wb.getSheet(Sheetname);
           // XSSFRow row=sh.getRow(rowcount);
           // System.out.print(row);
           // row.getCell(columncount).toString();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return data;
    }

    public static void writeDataFromExcel(int rowcount,int columncount,String filepath,String Sheetname,String value)
    {

        //System.out.println("excel data 1 " );
        try
        {

           // FileInputStream input=new FileInputStream(filepath);
          //  FileInputStream file=new FileInputStream(filepath);
            //File myappFile=new File(file  + File.separator + filename);
           // XSSFWorkbook wb=new XSSFWorkbook();
           // XSSFSheet sh=wb.getSheet(Sheetname);
           // XSSFRow row=sh.getRow(rowcount);
            //System.out.println("excel data 1 " + sh);
            FileOutputStream SQLdata=new FileOutputStream(filepath+  File.separator + "test.xlsx");
           // row.createCell(columncount).setCellValue(value);
         //  System.out.println("excel data 1 " + SQLdata);
          //  wb.write(SQLdata);

        }
        catch(Exception e)
        {
            System.out.println("error");
        }
    }



}

