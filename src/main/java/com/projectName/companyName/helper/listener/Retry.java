package com.projectName.companyName.helper.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//import com.uiFramework.pamTen.cpcommunity.helper.logger.LoggerHelper;
/**
 * 
 * @author Sasi Vinod Akula
 *
 */
public class Retry implements IRetryAnalyzer{
	private int retryCount = 0;
	private int maxRetryCount = 0;
	
//	private Logger log = LoggerHelper.getLogger(Retry.class);

	public boolean retry(ITestResult arg0) {
		if(retryCount < maxRetryCount){
			System.out.println("Trying------"+retryCount);
//			log.info("Retrying test "+arg0.getName()+" with status "+getResultStatusName(arg0.getStatus())+" for the " +(retryCount+1)+" times." );
			retryCount++;
			return true;
		}
		return false;
	}
	
	public String getResultStatusName(int status){
		String resultName = null;
		if(status == 1){
			resultName = "SUCCESS";
		}
		if(status == 2){
			resultName = "FAILURE";
		}
		if(status == 3){
			resultName = "SKIP";
		}
		return resultName;
	}

}
