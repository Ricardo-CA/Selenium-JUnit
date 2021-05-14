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

public class MantemEmprestimoTestes {

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
	public void REQ06e07MantemEmprestimoTestes() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		sleep();
		driver.findElement(By.linkText("Empréstimo")).click();
		sleep();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("7451");
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("4242");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		sleep();

		driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
		sleep();
		driver.findElement(By.cssSelector("a:last-child")).click();
		sleep();
		
		
		//validacao - consulta data de devolução
		
		assertEquals("2021/05/14", driver.findElement(By.cssSelector("tr:last-child > td:nth-child(6")).getText());
		driver.navigate().back();
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals("Livro/Aluno não localizado ou existe emprestimo em aberto", driver.findElement(By.cssSelector("body > div > h6")).getText());
		
		
		sleep();

	}


	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
