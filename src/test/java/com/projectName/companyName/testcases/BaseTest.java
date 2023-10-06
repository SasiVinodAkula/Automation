package com.projectName.companyName.testcases;

import java.awt.AWTException;
import java.awt.Robot;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.projectName.companyName.ExtentListeners.ExtentListeners;
import com.projectName.companyName.utilities.*;






public class BaseTest {

	private WebDriver driver;
	private Properties Config = new Properties();
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseTest.class);
	public boolean grid=false;
	private static String defaultUserName;
	private static String defaultPassword;
	private static String testSiteURL;

	
	public static ThreadLocal<String> url = new ThreadLocal<String>();
	public static ThreadLocal<String> dUserName = new ThreadLocal<String>();
	public static ThreadLocal<String> dPassword = new ThreadLocal<String>();
	
	
	
	
	
	public static String getTestSiteURL() {		
		return testSiteURL = url.get();
	}

	public static void setTestSiteURL(String testSiteURL) {
		url.set(testSiteURL);
	}
	
	public static String getDefaultUserName() {		
		return defaultUserName = dUserName.get();
	}

	public static void setDefaultUserName(String defaultUserName) {
		dUserName.set(defaultUserName);
	}
	
	
	public static String getDefaultPassword() {		
		return defaultPassword = dPassword.get();
	}

	public static void setDefaultPassword(String defaultPassword) {
		dPassword.set(defaultPassword);
	}
	







	@BeforeSuite
	public void setUpFramework() {

		configureLogging();
		DriverFactory.setGridPath("http://localhost:4444");
		DriverFactory.setConfigPropertyFilePath(
				System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");
	
		
        if (System.getProperty("os.name").equalsIgnoreCase("mac")) {
        	
        	DriverFactory.setChromeDriverExePath(
    				System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver");
    		DriverFactory.setGeckoDriverExePath(
    				System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver");
    	
        }else {
		
		
		DriverFactory.setChromeDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver.exe");
		DriverFactory.setGeckoDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver.exe");
		DriverFactory.setIeDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//IEDriverServer.exe");

        }		

	}
	

	
	public void InitializePropertiesFile() {
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFilePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Config.load(fis);
			log.info("Config properties file loaded");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void logInfo(String message) {
		
		ExtentListeners.testReport.get().info(message);
	}

public void logPassed(String message) {
		
		ExtentListeners.testReport.get().pass(message);
	}
	
	public void configureLogging() {
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src/test/resources/properties" + File.separator
				+ "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}



	public void openBrowser(String browser) throws MalformedURLException {
		
		
		InitializePropertiesFile();
		
		
		if(System.getenv("ExecutionType")!=null && System.getenv("ExecutionType").equals("Grid")) {
			
			grid=false;
		}
		

		DriverFactory.setRemote(grid);

		
		if (DriverFactory.isRemote()) {
			

			if (browser.equals("firefox")) {

				FirefoxOptions browserOptions = new FirefoxOptions();
				browserOptions.setPlatformName("Windows 11");
				
				Map<String, Object> cloudOptions = new HashMap<>();
				cloudOptions.put("build", "myTestBuild");
				cloudOptions.put("name", "myTestName");
				cloudOptions.put("Browser", "myBrowserName");
				browserOptions.setCapability("cloud:options", cloudOptions);
				driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), browserOptions);
//				WebDriver driver = new RemoteWebDriver(new URL(cloudUrl), browserOptions);
	
			} else if (browser.equals("chrome")) {

				ChromeOptions browserOptions = new ChromeOptions();
				browserOptions.setPlatformName("Windows 11");
				browserOptions.setBrowserVersion("117");

				
				System.out.println(DriverFactory.getGridPath());
				driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), browserOptions);
//				
//				
			} else if (browser.equals("edge")) {

//				
	
			}

			/*try {
			 * 
			 
//				driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), browserOptions);
//				driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), cap);
				

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

		} else

		if (browser.equals("chrome")) {
			System.out.println("Launching : " + browser);
		//	System.setProperty("webdriver.chrome.driver",
			//		DriverFactory.getChromeDriverExePath());

			driver = new ChromeDriver();
			
						
			
		} else if (browser.equals("firefox")) {
			System.out.println("Launching : " + browser);
			System.setProperty("webdriver.gecko.driver",
					DriverFactory.getGeckoDriverExePath());
			driver = new FirefoxDriver();

		}
				
		DriverManager.setWebDriver(driver);
		log.info("Driver Initialized !!!");
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		setDefaultUserName(Config.getProperty("defaultUserName"));
		setDefaultPassword(Config.getProperty("defaultPassword"));
		setTestSiteURL(Config.getProperty("testsiteurl"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		JavaScript.setJavaScriptObject(js);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		waitHelper.setWebDriverWaitObject(wait);
		try {
			Robot robot = new Robot();
			RobotClass.setRobotClassObject(robot);	
		} catch (AWTException e) {

			e.printStackTrace();
		}
		
		
		
		
	}

	public void quit() {

		DriverManager.getDriver().quit();
		log.info("Test Execution Completed !!!");
	}
}
