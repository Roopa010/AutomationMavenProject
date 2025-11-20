package selenium.programs;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program3 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/alerts");
		
		//4.Locate Alert buttons
		WebElement infoAlertButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
		WebElement confirmAlertButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		WebElement promtAlertButton = driver.findElement(By.xpath("//button[@id='promtButton']"));

		//5.Launch Information alert
		//infoAlertButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", infoAlertButton);
		
		//we need to wait until the alert is displayed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent()); // Wait until the alert is displayed within the webpage 
		
		//To perform any action, first capture the alert (Without locating/inspecting the element)
		Alert infoAlert = driver.switchTo().alert(); //capture the complete alert option automatically from webpage
		
		//6.Print Alert message
		System.out.println("Information Alert Message: " +infoAlert.getText());
		
		//7.Click on OK button
		infoAlert.accept();
		
		//8.Launch confirmation alert
		//confirmAlertButton.click();
		js.executeScript("arguments[0].click();", confirmAlertButton);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert confirmAlert = driver.switchTo().alert();
		
		//9.Print Alert message
		System.out.println("Confirmation Alert Message: " +confirmAlert.getText());
		
		//10.Click on Cancel button
		confirmAlert.dismiss();
		
		//11.Launch prompt alert with dialog box alert
		//promtAlertButton.click();
		js.executeScript("arguments[0].click();", promtAlertButton);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert promtAlert = driver.switchTo().alert();
		
		//12.Print message
		System.out.println("Promt Alert Message: " +promtAlert.getText());
		
		//13.Enter Text in Alert
		promtAlert.sendKeys("Roopa");
		
		//14.Click on OK button
		promtAlert.accept();
		
		//15.Close browser window
		driver.quit();
		
	}

}
