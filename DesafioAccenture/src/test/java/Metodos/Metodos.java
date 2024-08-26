package Metodos;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Metodos {
	WebDriver driver;

	// Método para abrir e maximizar navegador
	public void AbrirNavegador(String url) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	// Método para clicar
	public void clicar(By elemento) {
		driver.findElement(elemento).click();
	}

	// Método para selecionar dia
	public void selecionarDia(String dia) {
		List<WebElement> dias = driver.findElements(By.cssSelector(".react-datepicker__day"));
		for (WebElement e : dias) {
			if (e.getText().equals(dia)) {
				e.click();
				return;
			}
		}
		throw new NoSuchElementException("Dia " + dia + " não encontrado no calendário.");
	}

	// Método para preencher
	public void preencher(By elemento, String nome) {
		driver.findElement(elemento).sendKeys(nome);
	}

	// Método para selecionar um valor em um dropdown
	public void selecionar(By elemento, String valor) {
		Select dropdown = new Select(driver.findElement(elemento));
		dropdown.selectByVisibleText(valor);
	}

	// Método para pausar
	public void pausa(int tempo) throws InterruptedException {
		Thread.sleep(tempo);
	}

	// Método para fechar navegador
	public void fecharNavegador() {
		driver.quit();
	}

	// Método para validar texto
	public void validarTexto(By elemento, String textoEsperado) {
		String mensagemCapturada = driver.findElement(elemento).getText().trim();
		mensagemCapturada = mensagemCapturada.replaceAll("\\s+", " ");
		textoEsperado = textoEsperado.trim().replaceAll("\\s+", " ");
		System.out.println("Texto Capturado: [" + mensagemCapturada + "]");
		assertEquals(textoEsperado, mensagemCapturada);
	}

	// Método para tirar print
	public void tirarPrint(String nome) throws IOException {
		TakesScreenshot print = ((TakesScreenshot) driver);
		File SrcFile = print.getScreenshotAs(OutputType.FILE);
		File Desfile = new File("./src/evidencias/" + nome + ".png");
		FileUtils.copyFile(SrcFile, Desfile);
	}

	// Método para forçar clique com javascript
	public void clicarElementoComJavaScript(By elemento) {
		rolarAteElemento(elemento);
		WebElement webElement = driver.findElement(elemento);
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
	}

	// Método para apagar campo
	public void apagarTexto(By elemento) {
		WebElement campo = driver.findElement(elemento);
		campo.clear();
	}

	// Método para rolar a página até um elemento
	public void rolarAteElemento(By elemento) {
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(elemento));
	}

	// Método para rolar a tela para baixo
	public void rolarTelaParaBaixo(int pixels) {
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
	}

	// Método Drag and Drop
	public void utilizarMetodosDeDragAndDropParaColocarElementosNaOrdemCrescente() {
		WebElement elemento1 = driver.findElement(By.cssSelector("#demo-tabpane-list > div > div:nth-child(1)"));
		WebElement elemento2 = driver.findElement(By.cssSelector("#demo-tabpane-list > div > div:nth-child(2)"));
		WebElement elemento3 = driver.findElement(By.cssSelector("#demo-tabpane-list > div > div:nth-child(3)"));
		WebElement elemento4 = driver.findElement(By.cssSelector("#demo-tabpane-list > div > div:nth-child(4)"));
		WebElement elemento5 = driver.findElement(By.cssSelector("#demo-tabpane-list > div > div:nth-child(5)"));
		WebElement elemento6 = driver.findElement(By.cssSelector("#demo-tabpane-list > div > div:nth-child(6)"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(elemento1, 0, -100).perform();
		actions.dragAndDropBy(elemento2, 0, -100).perform();
		actions.dragAndDropBy(elemento3, 0, -100).perform();
		actions.dragAndDropBy(elemento4, 0, -100).perform();
		actions.dragAndDropBy(elemento5, 0, -100).perform();
		actions.dragAndDropBy(elemento6, 0, -100).perform();
		aguardarCarregamentoCompletoPagina();
	}

	// Método para aguardar o carregamento completo da página
	public void aguardarCarregamentoCompletoPagina() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").equals("complete");
			}
		};
		wait.until(pageLoadCondition);
	}

	// Método para alternar para uma nova janela
	public void mudarParaNovaJanela() {
		String janelaAtual = driver.getWindowHandle();
		for (String janela : driver.getWindowHandles()) {
			if (!janela.equals(janelaAtual)) {
				driver.switchTo().window(janela);
				break;
			}
		}
	}

	// Método para obter o valor da barra de progresso
	public int obterProgressBar() {
		String progressoTexto = driver.findElement(By.cssSelector("#progressBar > div")).getAttribute("aria-valuenow");
		return Integer.parseInt(progressoTexto);
	}

	// Método para aguardar o elemento ficar visível
	public void aguardarElementoVisivel(By elemento, int tempo) {
		WebDriverWait wait = new WebDriverWait(driver, tempo);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
	}

	// Método para aguardar o elemento estar clicável
	public void aguardarElementoClicavel(By elemento, int tempo) {
		WebDriverWait wait = new WebDriverWait(driver, tempo);
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}

	// Método para preencher e Selecionar em um container
	public void preencherESelecionarContainer(By containerElemento, String textoParaPreencher,
			String valorParaSelecionar) throws InterruptedException {
		try {
			aguardarElementoVisivel(containerElemento, 10);
			aguardarElementoClicavel(containerElemento, 10);

			WebElement container = driver.findElement(containerElemento);
			container.click();

			WebElement inputElement = driver.findElement(By.id("subjectsInput"));
			inputElement.sendKeys(textoParaPreencher);

			aguardarElementoVisivel(containerElemento, 10);
			pausa(3000);

			WebElement opcaoSelecionar = driver
					.findElement(By.xpath("//div[contains(@class, 'subjects-auto-complete__menu')]//div[text()='"
							+ valorParaSelecionar + "']"));
			if (opcaoSelecionar != null) {
				opcaoSelecionar.click();
			} else {
				System.out.println("Valor " + valorParaSelecionar + " não encontrado.");
			}
		} catch (Exception e) {
			System.out.println("Erro ao interagir com o elemento: " + e.getMessage());
		}
	}

}