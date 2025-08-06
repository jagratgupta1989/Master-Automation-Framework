package com.jarhub.constants;

import com.jarhub.enums.ConfigProperties;
import com.jarhub.utils.PropertyUtils;

public final class FrameWorkConstants {

    private FrameWorkConstants()
    {

    }
    private static final String RESOURCEPATH=System.getProperty("user.dir")+"/src/test/resources";
    private static final String CONFIGFILEPATH=RESOURCEPATH+"/config/config.properties";
    private static final int IMPLICITWAIT=10;
    private static final int EXPLICITWAIT=10;
    private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output";
    private static String extentReportFilePath="";


    public static String getConfigFilePath()
    {
        return CONFIGFILEPATH;
    }

    public static int getImplicitWait()
    {
        return IMPLICITWAIT;
    }

    public static int getExplicitWait()
    {
        return EXPLICITWAIT;
    }

    public static String getExtentReportFilePath() throws Exception {
        if(extentReportFilePath.isEmpty())
        {
            extentReportFilePath = getReportPath();
        }
        return extentReportFilePath;
    }

    public static String getReportPath() throws Exception {
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
        {
            return EXTENTREPORTFOLDERPATH+"/"+System.currentTimeMillis()+"index.html";
        }
        else {
            return EXTENTREPORTFOLDERPATH+"/"+"index.html";
        }
    }
}
