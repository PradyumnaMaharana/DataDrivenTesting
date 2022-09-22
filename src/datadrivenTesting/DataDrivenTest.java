package datadrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(dataProvider = "LoginData")
	public void loginTest(String user, String pwd, String exp) {
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		WebElement txtEmail = driver.findElement(By.id("Email"));
		txtEmail.clear();
		txtEmail.sendKeys(user);
		WebElement txtpassword = driver.findElement(By.id("Password"));
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
		driver.findElement(By.cssSelector("button[type='submit']"));
		String exp_title = "Dashboard/nopcommerce adminstration";
		String act_title = driver.getTitle();
		System.out.println(driver.getTitle());
		if (exp.equalsIgnoreCase("valid")) {
			if (exp_title.equals(act_title)) {
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} else if (exp.equalsIgnoreCase("invalid")) {
			if (exp_title.equals(act_title)) {
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = "./Resources\\LoginData.xlsx";
		XLUtility xlutil = new XLUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		String[][] loginData = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
