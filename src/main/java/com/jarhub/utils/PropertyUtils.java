package com.jarhub.utils;

import com.jarhub.constants.FrameWorkConstants;
import com.jarhub.enums.ConfigProperties;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    
    private static Properties properties=new Properties();
    private static final Map<String,String> CONFIGMAP=new HashMap<>();
    
    private PropertyUtils()
    {
        
    }
    
    static
    {
        FileInputStream file;
        try
        {
            file=new FileInputStream(FrameWorkConstants.getConfigFilePath());
            properties.load(file);
            for(Map.Entry<Object,Object> entry:properties.entrySet())
            {
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperties key) throws Exception {
        if(Objects.isNull(key))
        {
            throw new Exception("Property Name:"+key+"is not found. Please check key again");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
