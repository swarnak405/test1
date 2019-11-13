package com.test.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigdataProvider {
	Properties pro;
	
	public ConfigdataProvider() throws IOException{
		
		File src=new File("./Config/Config.properties");
		
		FileInputStream fis;
		
			fis = new FileInputStream(src);
            pro=new Properties();
			pro.load(fis);
	}
	public String getDataFromConfig(String keytoSearch){
	return	pro.getProperty(keytoSearch);
		
	}
	public String getBrowser(){
		 
		return pro.getProperty("Browser");
	}
	public String getStagingURL(){
		return pro.getProperty("qaUrl");
	}
	

}
