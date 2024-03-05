package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;

public class demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='c-omni-searchbox_wrapper '][1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@data-qa-id=\"omni-searchbox-locality\"]")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@data-qa-id=\"omni-searchbox-locality\"]")).sendKeys("Pune");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Pune']")).click();
		
		driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-keyword']")).click();
        driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-keyword']")).sendKeys("Cardiologist");
        driver.findElement(By.xpath("//span[normalize-space()='Cardiologist']")).click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		
		//span[@data-qa-id='doctor_review_count_selected']
		driver.findElement(By.xpath("//span[@data-qa-id='doctor_review_count_selected']")).click();
		driver.findElement(By.xpath("//span[text()='10+ Patient Stories']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[@aria-label='5+ Years of experience']")).click();
		
		Thread.sleep(6000);
		//to open the filter folder
		driver.findElement(By.xpath("//span[text()='All Filters']")).click();
		
		//input[@name='Fees'][@value='Above ₹1000']
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Above ₹1000']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='All Filters']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Available Today']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='Surgeries']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='u-d-item up-triangle']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Health & Wellness Plans']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='name'][1]")).sendKeys("Shreyash");
		
		Thread.sleep(10000);
		driver.quit();
		

	}

}
