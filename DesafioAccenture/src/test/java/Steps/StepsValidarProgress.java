package Steps;

import java.io.IOException;

import Elementos.ElementosValidarProgress;
import Metodos.Metodos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsValidarProgress {

	private Metodos m = new Metodos();
	private ElementosValidarProgress e = new ElementosValidarProgress();

	@Given("que eu acesse a URL de validar o Progress {string}")
	public void que_eu_acesse_a_url_de_validar_o_progress(String url) {
		m.AbrirNavegador(url);
	}

	@Given("e vou ate a {string}")
	public void e_vou_ate_a(String string) {
		m.rolarAteElemento(e.getCampoWidget());
		m.clicar(e.getCampoWidget());
	}

	@Given("escolho a opção do {string}")
	public void escolho_a_opção_do(String string) {
		m.rolarAteElemento(e.getCampoProgressBar());
		m.clicar(e.getCampoProgressBar());
	}

	@When("clico no botão {string} e paro antes dos {int}%")
	public void clico_no_botao_e_paro_antes_dos(String botao, Integer percentual) throws InterruptedException {
		m.rolarAteElemento(e.getBarraProgress());
		m.clicar(e.getBtStart());
		m.pausa(2000);
		m.clicar(e.getBtStart());
		m.pausa(4000);
	}

	@When("valido que o valor da progress bar é menor ou igual a {int}%")
	public void valido_que_o_valor_da_progress_bar_e_menor_ou_igual_a(Integer percentual)
			throws IOException, InterruptedException {
		m.obterProgressBar();
		m.tirarPrint("ProgressBar");
		m.pausa(3000);
	}

	@Then("clico no botão {string} novamente e ao chegar aos {int}% reseto a progress bar")
	public void clico_no_botao_novamente_e_ao_chegar_aos_reseto_a_progress_bar(String botao, Integer percentual)
			throws InterruptedException {
		m.clicar(e.getBtStart());
		m.pausa(9000);
		m.fecharNavegador();
	}
}