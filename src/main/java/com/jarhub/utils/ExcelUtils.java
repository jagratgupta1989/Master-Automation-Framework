package com.jarhub.utils;

import com.jarhub.constants.FrameWorkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {

    public List<Map<String, String>> getTestDetails(String sheetname)
    {
        List<Map<String,String>> list=null;
        FileInputStream fs=null;
        try {
            fs = new FileInputStream(FrameWorkConstants.getExcelpath());
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet=workbook.getSheet(sheetname);
            int lastrownum=sheet.getLastRowNum();
            int lastcolnum=sheet.getRow(0).getLastCellNum();
            Map<String,String> map=null;
            list=new ArrayList<>();
            for(int i=1; i<=lastrownum; i++)
            {
                map=new HashMap<>();
                for(int j=0; j<lastcolnum; j++)
                {
                    String key=sheet.getRow(0).getCell(j).getStringCellValue();
                    String value=sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        finally
        {
            try {
                if(Objects.nonNull(fs))
                {
                    fs.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


}
