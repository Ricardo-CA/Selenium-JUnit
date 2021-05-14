package teste.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MantemLoginTestes {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browser_driver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void REQ08MantemLoginTestes() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.cssSelector("button")).click();
		assertEquals("Invalid username and password.", driver.findElement(By.cssSelector("body > div")).getText());
		sleep();
		driver.navigate().refresh();
		//-------------

		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		//validacao jose acessos
		assertEquals(true, !driver.findElement(By.cssSelector("body > nav > div > ul > li:nth-child(2) > a")).isEnabled());
		assertEquals(false, !driver.findElement(By.cssSelector("body > nav > div > ul > li:nth-child(3) > a")).isEnabled());
		assertEquals(false, !driver.findElement(By.cssSelector("body > nav > div > ul > li:nth-child(4) > a")).isEnabled());
		sleep();
		driver.navigate().back();
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();;
		driver.findElement(By.name("username")).sendKeys("maria");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();;
		driver.findElement(By.name("password")).sendKeys("456");
		driver.findElement(By.cssSelector("button")).click();
		//validacao maria acessos
		assertEquals(false, !driver.findElement(By.cssSelector("body > nav > div > ul > li:nth-child(2) > a")).isEnabled());
		assertEquals(false, !driver.findElement(By.cssSelector("body > nav > div > ul > li:nth-child(3) > a")).isEnabled());
		assertEquals(false, !driver.findElement(By.cssSelector("body > nav > div > ul > li:nth-child(4) > a")).isEnabled());
		sleep();

	}


	public void sleep() {
		try {
			Thread.sleep(1750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
