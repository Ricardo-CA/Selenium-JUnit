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

public class MantemLivroTestes {
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
	public void REQ01MantemLivrosTestes() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		sleep();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("7894");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("tester");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("A Arte do Teste");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		sleep();
		driver.findElement(By.linkText("Editar")).click();
		sleep();
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).clear();
		driver.findElement(By.id("autor")).sendKeys("alterado");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		sleep();
		driver.findElement(By.linkText("Excluir")).click();
	}

	@Test
	public void REQ02MantemLivrosExcecoesTestes() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		sleep();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("789");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		sleep();
		
		// validacao
		assertEquals("ISBN deve ter 4 caracteres",
				driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[1]/div/span")).getText());
		assertEquals("Autor deve ter entre 1 e 50 caracteres",
				driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[2]/div/span")).getText());
		assertEquals("Titulo deve ter entre 1 e 50 caracteres",
				driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[3]/div[1]/span")).getText());
		
		
	}

	public void sleep() {
		try {
			Thread.sleep(1750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}