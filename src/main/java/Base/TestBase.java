package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.TestUtil;
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.remote.DesiredCapabilities;  


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeSuite
	public void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "/src/test-output/ExtentReportResults.html");
		test = report.startTest("Demo");
	}

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\DSS-Test-1\\Downloads\\geckodriver.exe" );   
		WebDriverManager.chromedriver().driverVersion("108.0.5359.99").setup();
		driver = new ChromeDriver();
		//FirefoxProfile profile =new FirefoxProfile(new File("C:\\Users\\DSS-Test-1\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\cnmt125a.telemedicineProfile"));
		//FirefoxOptions option=new FirefoxOptions();
		//option.setProfile(profile);
		
		 //driver = new FirefoxDriver(option);
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

	
	 @AfterTest 
	 public void driver_method_close()
	 { 
		 driver.quit();
	 }
	 

	@AfterSuite
	public void tearDown() {
		report.flush();
	}

}
