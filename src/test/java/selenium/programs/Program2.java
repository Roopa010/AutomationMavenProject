package selenium.programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program2 {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		//5. Wait for Pageload
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h1[text()='Practice Form']"), 0));
		
		//6. Enter Firstname and Lastname
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		firstName.sendKeys("Param");
		lastName.sendKeys("Jothi");
		
		//7. Enter Email
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		email.sendKeys("param@gmail.com");
		
		//8. Select Gender “Male”
		selectGender("Male");
		
		//9. Enter mobile number “9553220022”
		WebElement mobNo = driver.findElement(By.xpath("//input[@id='userNumber']"));
		mobNo.sendKeys("9553220022");
		
		//10.Select DOB (14-Feb-1991)
		selectDob("14", "February", "1991");
		
		//11.Search and Select “Computer Science”
		selectSubject("Computer Science");
		
		//12.Select Hobbies as “Sports and Reading”
		String[] hobbies = {"Sports","Reading"};
		selectHobbies(hobbies);
		
		//13.Upload photo (irrespective of extensions)
		String photoPath = System.getProperty("user.dir")+"\\Files\\Photo.png";
		WebElement uploadElement = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		uploadElement.sendKeys(photoPath);
		
		//14.Submit Details
		WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
		//submitButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submitButton);
		
		//15.Wait for successful submission message
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[text()='Thanks for submitting the form']"), 0));
		System.out.println("Form submitted successfully!");
		
		//16. Close browser window
		driver.quit();
				
	}
	
	public static void selectGender(String gender) {
		WebElement genderRadioButton = driver.findElement(By.xpath("//label[text()='"+gender+"']"));
		//genderRadioButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", genderRadioButton);
	}
	
	public static void selectDob(String date, String month, String year) {
		
		//click on the calendar input field
		WebElement dobInput = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		//dobInput.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dobInput);
	
		//wait for the calendar to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@class='react-datepicker__month-select']"),0));
		
		//select the month
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByVisibleText(month);
		
		//select the year
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select yearSelect = new Select(yearDropdown);
		yearSelect.selectByVisibleText(year);
		
		//select the date
		WebElement dateElement = driver.findElement(By.xpath("//div[text()='"+date+"' and contains(@aria-label,'"+month+"')]"));
		dateElement.click();	
//		js.executeScript("arguments[0].click();", dateElement);
	}
	
	public static void selectSubject(String subject) {
		WebElement subjectInput = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
		
		//enter characters using Actions class
		Actions actions = new Actions(driver);
		actions.sendKeys(subjectInput, subject).perform();
		
		//wait for the suggestion to appear (Until subject element is loaded, freeze the screen- mouse over until the text box and label is highlighted once it is highlighted, right click on it, Break on->subtree modifications(It gives the control to the user))
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[text()='"+subject+"' and contains(@class,'option')]"), 0));
		
		//click on the suggestion
		WebElement subjectOption = driver.findElement(By.xpath("//div[text()='"+subject+"' and contains(@class,'option')]"));
		//subjectOption.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", subjectOption);			
	}
		
	public static void selectHobbies(String[] hobbies) {
		for(String hobby : hobbies) {
			WebElement hobbyCheckBox = driver.findElement(By.xpath("//label[text()='"+hobby+"']"));
			if(!hobbyCheckBox.isSelected()) {
				//hobbyCheckBox.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", hobbyCheckBox);
			}
		}
	}
	
}
