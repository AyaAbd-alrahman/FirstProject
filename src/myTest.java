import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTest {

	WebDriver driver = new EdgeDriver();

	String THEWEBSITE = "https://www.saucedemo.com/";

	String UserName = "standard_user";
	String Password = "secret_sauce";

	@BeforeTest
	public void mySetup() {

		driver.manage().window().maximize();

		driver.get(THEWEBSITE);

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {

		WebElement UserNameInput = driver.findElement(By.id("user-name"));

		WebElement PasswordInput = driver.findElement(By.id("password"));

		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		LoginButton.click();

	}

	@Test(priority = 2)
	public void AddAllItems() throws InterruptedException {

		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();
		}

	}

	@Test(priority = 3)

	public void RemoveAllItems() throws InterruptedException {

		Thread.sleep(2000);
		List<WebElement> RemoveButtons = driver.findElements(By.className("btn_secondary"));

		for (int i = 0; i < RemoveButtons.size(); i++) {
			RemoveButtons.get(i).click();
		}
	}

	@Test(priority = 4)
	public void Task() {

		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < ItemsNames.size(); i++) {

			String itemName = ItemsNames.get(i).getText();
			System.out.println(itemName.charAt(0));
		}
	}

	@Test(priority = 5)
	public void Task1() {

		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < ItemsNames.size(); i++) {

			String itemName = ItemsNames.get(i).getText();
			if (itemName.endsWith("t")) {
				continue;
			} else {
				System.out.println(itemName);
			}
		}
	}

	@Test(priority = 6)
	public void Task2() {
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < ItemsNames.size(); i++) {

			String itemName = ItemsNames.get(i).getText();

			if (itemName.startsWith("S")) {
				continue;
			} else {
				System.out.println(itemName);
			}
		}
	}

	@Test(priority = 7)
	public void Task3() {
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 1; i < ItemsNames.size(); i = i + 2) {

			System.out.println(ItemsNames.get(i).getText());

		}
	}

	@Test(priority = 8)
	public void Task4() {
		
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

	for(int i = 0 ; i < ItemsNames.size();i++) {
		
		if(ItemsNames.get(i).getText().equals("Sauce Labs Fleece Jacket")) {
			
			break ; 
		}
		System.out.println(ItemsNames.get(i).getText());

	}
	}

	@Test(priority = 9, enabled = false)
	public void Logout() throws InterruptedException {

		WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
		BurgerMenu.click();
		Thread.sleep(1000);
		WebElement LogOutButton = driver.findElement(By.id("logout_sidebar_link"));
		LogOutButton.click();

		Thread.sleep(1000);

		WebElement MainLogo = driver.findElement(By.className("login_logo"));
		System.out.println(MainLogo.getText());

		WebElement UserNames = driver.findElement(By.id("login_credentials"));
		System.out.println(UserNames.getText());
	}

	@AfterTest
	public void myAfterTest() {

//		driver.quit();
	}

}