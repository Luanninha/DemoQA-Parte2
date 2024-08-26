package Steps;

import java.io.IOException;

import Elementos.ElementosOrdemCrescente;
import Metodos.Metodos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsElementosOrdemCrescente {

	private Metodos m = new Metodos();
	private ElementosOrdemCrescente e = new ElementosOrdemCrescente();

	@Given("que eu acesse a url de ordem crescente {string}")
	public void que_eu_acesse_a_url(String string) {
		m.AbrirNavegador(string);
	}

	@Given("escolho a opção {string} na página inicial")
	public void escolho_a_opção_na_página_inicial(String string) throws InterruptedException {
		m.rolarAteElemento(e.getCampoInteractions());
		m.clicar(e.getCampoInteractions());
		m.aguardarCarregamentoCompletoPagina();
		m.rolarTelaParaBaixo(250);
	}

	@When("clico submenu do {string}")
	public void clico_submenu_do(String string) {
		m.clicarElementoComJavaScript(e.getSubmenuSortable());
	}

	@Then("utilizo métodos de drag and drop para colocar os elementos na ordem crescente")
	public void utilizo_métodos_de_drag_and_drop_para_colocar_os_elementos_na_ordem_crescente() throws IOException {
		m.utilizarMetodosDeDragAndDropParaColocarElementosNaOrdemCrescente();
		m.tirarPrint("DragAndDrop");
	}

	@Then("fecho o navegador de ordem crescente")
	public void fecho_o_navegador_de_ordem_crescente() throws InterruptedException {
		m.pausa(3000);
		m.fecharNavegador();
	}

}
