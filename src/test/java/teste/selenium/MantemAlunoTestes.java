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

public class MantemAlunoTestes {

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
	public void REQ03EREQ05MantemAlunosTestes() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		sleep();
		driver.findElement(By.linkText("Alunos")).click();
		sleep();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("4242");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("Ricardo teste");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("teste@gmail.com");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("03666000");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		sleep();
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		sleep();
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).clear();
		driver.findElement(By.id("nome")).sendKeys("alterado");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		// validacao
		assertEquals("Rua São Severo", driver.findElement(By.cssSelector("td:nth-child(6)")).getText());
		assertEquals("alterado", driver.findElement(By.cssSelector("td:nth-child(3)")).getText());
		sleep();
		driver.findElement(By.linkText("Excluir")).click();
		driver.quit();
	}

	@Test
	public void REQ04MantemAlunosExcecoesTestes() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		sleep();
		driver.findElement(By.linkText("Alunos")).click();
		sleep();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("424");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("0366600");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		sleep();
		// validacao
		assertEquals("RA deve ter 4 caracteres",
				driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[1]/div/span")).getText());
		assertEquals("Nome deve ter entre 1 e 50 caracteres",
				driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[2]/div/span")).getText());
		assertEquals("E-mail deve ter entre 1 e 50 caracteres",
				driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[3]/div[1]/span")).getText());
		assertEquals("CEP deve ter 8 caracteres",
				driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[3]/div[2]/div[1]/span")).getText());
		
		driver.quit();

	}

	public void sleep() {
		try {
			Thread.sleep(1750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
