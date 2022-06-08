package BaseClass;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import Utilities.ReadConfigFile;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseClass{
	
	ReadConfigFile readconfigfile = new ReadConfigFile();
	public String BaseURL = readconfigfile.GetApplicationURL();//read the data from the method in ReadConfigFile class
	public String username = "gayathri";
	public String password = "gaya3@123";
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() throws Exception{
		
		//chromedriver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//driver//chromedriver.exe");
		driver = new ChromeDriver();
		
		//firefoxdriver
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//driver//geckodriver.exe");
		driver = new FirefoxDriver();
		
		//generate logs 
		logger = Logger.getLogger("DSAlgoAssignments");//added logger
		PropertyConfigurator.configure("log4j.properties");//location of property file
		logger.setLevel(Level.DEBUG);
		
	}
	
	public void teardown()
	{
		driver.quit();
	}
	
}
