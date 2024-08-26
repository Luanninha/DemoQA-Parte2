package Elementos;

import org.openqa.selenium.By;

public class ElementosValidarProgress {

	private By campoWidget = By.cssSelector(":nth-child(4) > :nth-child(1) > .card-up");
	private By campoProgressBar = By.cssSelector(":nth-child(4) > .element-list > .menu-list > #item-4");
	private By btStart = By.cssSelector("#startStopButton");
	private By barraProgress = By.cssSelector("#progressBar");

	public By getCampoWidget() {
		return campoWidget;
	}

	public By getCampoProgressBar() {
		return campoProgressBar;
	}

	public By getBtStart() {
		return btStart;
	}

	public By getBarraProgress() {
		return barraProgress;
	}
}