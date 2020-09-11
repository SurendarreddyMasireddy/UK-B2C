package com.B2C.Core;

 

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

 

 

public class ObjectRepository extends ReporterClass
{
    public String getObjectProperties(String key) throws IOException, URISyntaxException
    {
        Map<String, String> m = objectRepositoryData;
        String value = m.get(key);
        return value;
    }
    
    public List<String> getCellValue() throws IOException, URISyntaxException
    {
        //Returns Productnames from Excel
        List<String> values =  CellValue;
        return values;
    }
    
    
        
}