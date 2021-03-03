import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TestCadastrarUsuario {
	WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	
	@Test
	@Ignore
	public void nomeObrigatorioTest() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		String msg = driver.switchTo().alert().getText();
		Assert.assertEquals("Nome eh obrigatorio", msg);
		driver.switchTo().alert().accept();
	}
	
	@Test
	@Ignore
	public void sobreNomeObrigatorioTest() {
		//Escrevendo First Name
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lucas");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		String msg = driver.switchTo().alert().getText();
		Assert.assertEquals("Sobrenome eh obrigatorio", msg);
		driver.switchTo().alert().accept();
		
	}
	
	@Test
	@Ignore
	public void sexoObrigatorioTest() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lucas");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Emanuel");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		String msg = driver.switchTo().alert().getText();
		Assert.assertEquals("Sexo eh obrigatorio", msg);
		driver.switchTo().alert().accept();
	}
	
	@Test
	@Ignore
	public void validarComidaFavoritaDoVegetariano() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lucas");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Emanuel");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		String msg = driver.switchTo().alert().getText();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", msg);
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void validarSeOTipoDeEsporteEMarcadoEPerguntado() {
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lucas");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Emanuel");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		Select selecao = new Select(elemento);
		selecao.selectByValue("futebol");
		selecao.selectByValue("nada");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		String msg = driver.switchTo().alert().getText();
		
		Assert.assertEquals("Voce faz esporte ou nao?", msg);
		driver.switchTo().alert().accept();
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}

}
