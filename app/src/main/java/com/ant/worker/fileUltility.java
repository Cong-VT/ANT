package com.ant.worker;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class fileUltility {
    public static void main(String[] atr) throws IOException, WriteException, BiffException {
        URL url = new URL("https://portal.hqsoft.vn:7443/Siam2/");
        URLConnection conn = url.openConnection();
        InputStream in = conn.getInputStream();
        System.out.println("test " + in);
        String filename = "Result/siam/siam_login.xls";

        try {
            Workbook existingWorkbook = Workbook.getWorkbook(new File(filename));
            System.out.println("test " + in);
        WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(filename), existingWorkbook);
        WritableSheet sheetToEdit = workbookCopy.getSheet("LoadTest");
        for(int i =0;i<=existingWorkbook.getNumberOfSheets();i++){
            if (workbookCopy.getSheet(i).getName().contentEquals("LoadTest"))
            {
                System.out.print(" Founded sheet with ID = " + i );
            }

        }
        } catch (IOException | BiffException e) {

        }

        try {
            String fileName = "Result/file.xls";
            WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
            WritableSheet writablesheet1 = workbook.createSheet("Sheet1", 0);
            WritableSheet writablesheet2 = workbook.createSheet("Sheet2", 1);
            WritableSheet writablesheet3 = workbook.createSheet("Sheet3", 2);
            writablesheet1.addCell(new Label(0, 0, "id1"));
            writablesheet1.addCell(new Label(0, 1, in.toString()));
            writablesheet2.addCell(new Label(0, 1, in.toString()));
            //writablesheet2.addCell(label2);
            //   writablesheet3.addCell(label3);

            workbook.write();
            workbook.close();

        } catch (WriteException e) {

        }


    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public  void writeToExistExcel (String filename , String sheetname, int sheetID , int Col , int row , String data ) {
        try {
            String fn = filename;

                Workbook existingWorkbook = Workbook.getWorkbook(new File(filename));
                WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(filename), existingWorkbook);
                WritableSheet sheetToEdit = workbookCopy.getSheet(sheetname);
                for(int i =0;i<=existingWorkbook.getNumberOfSheets();i++){
                    if (workbookCopy.getSheet(i).getName().contentEquals(sheetname))
                    {
                        System.out.print(" Founded sheet with ID = " + i );
                    }

                }
                WritableCell cell;
                Label l = new Label(Col, row, data);
                cell = (WritableCell) l;
                sheetToEdit.addCell(cell);
                workbookCopy.write();
                workbookCopy.close();
                existingWorkbook.close();
        } catch (WriteException | IOException | BiffException e) {

        }


    }



    public  void writeToNewExcel (String filename , String sheetname, int sheetID , int Col , int row , String data ) {
        try {
            String fn = filename;
                WritableWorkbook workbook = Workbook.createWorkbook(new File(fn));
                WritableSheet writablesheet = workbook.createSheet(sheetname,sheetID);
                writablesheet.addCell(new Label(Col, row, data));
                workbook.write();
                workbook.close();
                // file exist

        } catch (WriteException | IOException e) {

        }


    }

    public  void Logerror (String filename ,String Step ,String content ) throws IOException {
        File LogEx = new File(filename);
        FileOutputStream fos=new FileOutputStream(LogEx);
        String LogContent = "Error at " + Step +"      " + content;
        fos.write(LogContent.getBytes());

    }

    public  void writetoTXT (String filename ,String title ,String content ) throws IOException {
      try {
          File file = new File(filename);
          if (file.exists()) {
              FileOutputStream fos = new FileOutputStream(file);
              fos.write(content.getBytes());
              System.out.print("file da ton tai");
              fos.close();
          } else {
              System.out.print("file chưa ton tai");
              file.createNewFile();
              FileOutputStream fos = new FileOutputStream(file);
              fos.write(content.getBytes());
              fos.close();
          }

      }catch (IOException e) {
          e.printStackTrace();
      }
    }







}
