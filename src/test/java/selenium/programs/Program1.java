package selenium.programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Program1 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		//5.Verify application title
		String actualTitle = driver.getTitle();
		String expectedTitle = "ParaBank | Welcome | Online Banking";
		Assert.assertEquals(actualTitle, expectedTitle, "Title Mismatch");
		
		//6.Verify application logo
		WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
		Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");
		
		//7.Verify application caption "Experience the difference"
		WebElement caption = driver.findElement(By.xpath("//p[@class='caption']"));
		String expectedCaption = "Experience the difference";
		String actualCaption = caption.getText();
		Assert.assertEquals(actualCaption, expectedCaption, "Caption verification failed");
		
		//8.Enter Invalid credentials in Username (Invalid User) and Password (“ “-empty) text boxes
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		username.sendKeys("Invalid User");
		password.sendKeys("");
		
		//9.Click on Login Button
		WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
		logInButton.click();
		
		//10.Verify error message is displayed (Please enter a username and password.)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"),0));
		
		WebElement error = driver.findElement(By.xpath("//p[@class='error']"));
		String actualError = "Please enter a username and password.";
		String expectedError = error.getText();
		Assert.assertEquals(actualError, expectedError, "Error message verification failed");
				
		//11.Click on Admin page link
		WebElement adminPage = driver.findElement(By.xpath("//a[text()='Admin Page']"));
		adminPage.click();
		
		//12.Wait for admin page	
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h1[contains(text(),'Administration')]"), 0));
		
		//13.Select Data access mode 'SOAP'
		SelectDataAccessMode("soap");
		
		//14.Scrolldown till Loan provider
		WebElement loanProvider = driver.findElement(By.xpath("//select[@name='loanProvider']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", loanProvider);
		
		//15.Select Loanprovider as 'Web Service'
		Select loanSelect = new Select(loanProvider);
		loanSelect.selectByVisibleText("Web Service");
		
		//16.Click on Submit button
		WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));
		submit.click();
		
		//17.wait for Successful submission message
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//b[text()='Settings saved successfully.']"), 0));

		//18.Click on Services Link
		WebElement servicesLink = driver.findElement(By.xpath("//ul[@class='leftmenu']//a[text()='Services']"));
		servicesLink.click();
		
		//19.Wait for Services page
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[text()='Bookstore services:']"), 0));
		
		//20.Scrolldown till Bookstore services
		WebElement bookstoreServices = driver.findElement(By.xpath("//span[text()='Bookstore services:']"));
		js.executeScript("arguments[0].scrollIntoView(true);", bookstoreServices);
		
		//21.Get total rows, columns in the bookstore service table
		List<WebElement> rows = driver.findElements(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr[1]//td"));
		int totalRows = rows.size();
		int totalColumns = columns.size();
		System.out.println("Total Rows: " + totalRows);
		System.out.println("Total Columns: " + totalColumns);
		
		//22.Get Column headers of book store services table
		for(int i=1; i<=totalColumns; i++) {
			WebElement columnHeader = driver.findElement(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr[1]//td["+i+"]"));
			System.out.println("Column " + i + "header: " + columnHeader.getText());
		}
		
		//23.Get all the data from book store service table
		for(int r=1; r<=totalRows; r++) {
			for(int c=1; c<=totalColumns; c++) {
				WebElement cellData = driver.findElement(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr["+r+"]//td["+c+"]"));
				System.out.println("Rows "+r+" Columns "+c+" Data :" + cellData.getText());
			}
		}
		
		//24.Close browser window
		driver.quit();	
	}
	
	public static void SelectDataAccessMode(String mode) {
		WebElement dataAccessMode = driver.findElement(By.xpath("//input[@value='"+mode+"']"));
		dataAccessMode.click();
	}

}
