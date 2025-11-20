package selenium.programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program4 {

	public static void main(String[] args) {
		
		//1.Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		
		//2.Maximize the browser window
		driver.manage().window().maximize();
		
		//3.Launch the application (https://demoqa.com/frames)
		driver.get("https://demoqa.com/frames");
		
		//4.Locate elements 'Frames' header in main window and 'This is a sample page' inside the frame
		WebElement mainWindowHeader = driver.findElement(By.xpath("//h1[@class='text-center']"));
		
		//switch to frame from main window
		driver.switchTo().frame("frame1");
		
		//locate frame element
		WebElement frameElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		
		//5.Print frame element text
		System.out.println("Frame Element text: " + frameElement.getText());
		
		//switch back to main window from frame
		driver.switchTo().defaultContent();
		
		//6.Print main window element text
		System.out.println("Main Window Element: " + mainWindowHeader.getText());
		
		//7.Close browser window
		driver.quit();
		
	}

}
