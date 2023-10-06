package com.projectName.companyName.utilities;

import java.io.FileInputStream;

public class PropertiesFileManager {

	

	public static ThreadLocal<FileInputStream> fis = new ThreadLocal<FileInputStream>();
	

	
	
	public static FileInputStream getconfigPath() {		
		return  fis.get();
	}

	public static void setconfigPath(FileInputStream configPath) {
		fis.set(configPath);
	}
}
