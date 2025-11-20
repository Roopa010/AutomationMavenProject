package selenium.programs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program5 {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/frames");
		
		//Locate the Logo element
		WebElement logoElement = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
		
		//take screenshot of logo element
		getElementScreenshot(logoElement, "Logo");
		
		WebElement mainWindowHeader = driver.findElement(By.xpath("//h1[@class='text-center']"));
		
		driver.switchTo().frame("frame1");
		
		WebElement frameElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		
		System.out.println("Frame Element Text: " + frameElement.getText());
		
		driver.switchTo().defaultContent();
		
		System.out.println("Main Window Header: " + mainWindowHeader.getText());
		
		getWindowScreenshot(driver, "MainWindow");
		
		driver.quit();
		
	}
	
	// Method to capture screenshot of browser window
	public static String getWindowScreenshot(WebDriver driver, String fileName) throws IOException {
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(destination));
		return destination;
	}

	// Method to capture screenshot of webelement
	public static String getElementScreenshot(WebElement element, String fileName) throws IOException {
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(destination));
		return destination;	
	}

}
