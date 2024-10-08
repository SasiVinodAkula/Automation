package com.projectName.companyName.ExtentListeners;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.projectName.companyName.utilities.DriverManager;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;





public class ExtentManager {

	private static ExtentReports extent;
	
	
	

	    public static ExtentReports createInstance(String fileName) {
//	        ExtentHtmlReporter htmlReporter1 = new ExtentHtmlReporter(fileName);
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	        
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Sasi Vinod Akula");
	        extent.setSystemInfo("Organization", "Self");
	        extent.setSystemInfo("Release:", "3");
	        extent.setSystemInfo("Environment","SIT");
	        
	        
	        return extent;
	    }

	    
	    public static String screenshotPath;
		public static String screenshotName;
		
		public static void captureScreenshot() {

			File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + "_"+(int) (Math.random()*1000)+".jpg";

			try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		
		}
		public static String screenshotName1;
		public static void aShot() {		
			Screenshot fpScreenshot;		
//			WebElement element = DriverManager.getDriver().findElement(By.xpath("//*[@id='header']"));
//			JavascriptExecutor js1 = (JavascriptExecutor) DriverManager.getDriver();
//			js1.executeScript("arguments[0].setAttribute('class','');", element);
			

			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
						.takeScreenshot(DriverManager.getDriver());
			} catch (Exception e) {
				fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
						.takeScreenshot(DriverManager.getDriver());
			}
			
			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") +(int) (Math.random()*1000) +".jpg";

			
			
			
						
			try {
				ImageIO.write(fpScreenshot.getImage(), "jpg",
						new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			js1.executeScript("arguments[0].setAttribute('class','navbar-fixed-top');", element);

//			 ((JavascriptExecutor)
//			 DriverManager.getDriver()).executeScript("arguments[0].style.visibility='hidden'",
//			 element);
//			 Screenshot screenshot = new
//			 AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(DriverManager.getDriver());
	//
//			 ((JavascriptExecutor)
//			 DriverManager.getDriver()).executeScript("arguments[0].style.visibility=''",
//			 element);
//			 js1.executeScript("arguments[0].setAttribute('class','navbar-fixed-top');", element);
			 

		}
	}
