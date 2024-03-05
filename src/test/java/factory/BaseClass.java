package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import factory.BaseClass;

public class BaseClass {

	
		// TODO Auto-generated method stub
		 public static WebDriver driver;
	     static Properties p;
	     static Logger logger;
	     public static TakesScreenshot takesScreenshot;
	  	
	@BeforeTest
	 public static WebDriver initializeBrowser() throws IOException
		{
	    	if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities = new DesiredCapabilities();
				//os
				if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				    capabilities.setPlatform(Platform.WIN11);
				} 
				else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				    capabilities.setPlatform(Platform.MAC);
				} 
				else {
				    System.out.println("No matching OS..");
				}
				//browser
				switch (getProperties().getProperty("browser").toLowerCase()) {
				case "chrome": 
					capabilities.setBrowserName("chrome");
				    break;
			    case "edge":
			        capabilities.setBrowserName("MicrosoftEdge");
			        break;
			    default:
			        System.out.println("No matching browser");
			     }
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			}
	    	else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(getProperties().getProperty("browser").toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
	    	driver.get(p.getProperty("appURL"));
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.manage().window().maximize();
	    	return driver;
		}
	
	  	public static WebDriver getDriver() 
	  	{
		  return driver;
	       }

	
	
        public static Properties getProperties() throws IOException
          {		 
            FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
            p=new Properties();
	        p.load(file);
	        return p;
          }

       public static Logger getLogger() 
        {		 
	       logger=LogManager.getLogger(); //Log4j
	       return logger;
         }
       
       @AfterTest
     	public void tearDown() 
          {
   	    	driver.quit();
        	}
       
   	    public static void explicitWait(WebDriver driver,Duration duration,WebElement element ) 
   	       {
   		     WebDriverWait wait=new WebDriverWait(driver,duration);
   		     wait.until(ExpectedConditions.visibilityOf(element));
        	}


//public void screenShot(String name) {
//   File scrFile = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
//   //The below method will save the screen shot in d drive with name "screenshot.png"
//   File screenShotName = new File(System.getProperty("user.dir")+"\\screenshots\\"+name+".png");
//   try {
//         FileUtils.copyFile(scrFile, screenShotName);
//   } catch (IOException e) {
//         e.printStackTrace();
//   }
//
//
//}

public String captureScreen(String name) {
	String targetFilePath="";
	File sourceFile = null;
	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	try {
	takesScreenshot= (TakesScreenshot) driver;
	sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\" + name + "_" + timeStamp + ".png";
	File targetFile=new File(targetFilePath);
	sourceFile.renameTo(targetFile);
	}
	catch(Exception e) {
	}
	return targetFilePath;
}


	}
