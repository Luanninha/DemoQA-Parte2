package Steps;

import java.io.IOException;

import Elementos.ElementosFormulario;
import Metodos.Metodos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsFormulario {

	private Metodos m = new Metodos();
	private ElementosFormulario e = new ElementosFormulario();

	@Given("que eu acesse a url de Formulário {string}")
	public void que_eu_acesse_a_url_de_formulário(String string) {
		m.AbrirNavegador(string);
		m.rolarAteElemento(e.getOpcaoForms());
	}

	@Given("escolho a opção {string} na tela")
	public void escolho_a_opcao_na_tela(String opcao) {
		m.clicar(e.getOpcaoForms());
		m.rolarAteElemento(e.getPracticeForm());
	}

	@When("clico no {string}")
	public void clico_no(String no) throws InterruptedException {
		m.pausa(3000);
		m.clicarElementoComJavaScript(e.getPracticeForm());
	}

	@When("preencho todo o formulário com valores aleatórios")
	public void preencho_todo_o_formulario_com_valores_aleatorios() throws InterruptedException {
		m.pausa(4000);
		// m.aguardarElementoVisivel(e.getCampoFirstName(), 10);
		m.rolarAteElemento(e.getCampoFirstName());
		m.preencher(e.getCampoFirstName(), "Carla Aurora");
		m.preencher(e.getCampoLastName(), "Aparecida Mendes");
		m.preencher(e.getCampoUserEmail(), "carla_mendes@rodomen.com.br");
		m.clicar(e.getOpcaoGen());
		m.preencher(e.getCampoUserNumber(), "6135520144");
		m.pausa(3000);
		m.clicar(e.getCampoDateOfBirthInput());
		m.selecionar(e.getSelecaoAno(), "1985");
		m.selecionar(e.getSelecaoMes(), "March");
		m.selecionarDia("5");
		m.preencherESelecionarContainer(e.getCampoSubjects(), "e", "English");
		m.clicar(e.getOpcaoSports());
		m.pausa(4000);
		m.preencher(e.getCampoCurrentAddress(), "123 Main St");
		m.rolarTelaParaBaixo(200);
		m.pausa(2000);
		m.preencherESelecionarContainer(e.getSelecaoEstado(), "N", "NCR");
		m.pausa(4000);
		m.preencherESelecionarContainer(e.getSelecaoCidade(), "e", "elh");

	}

	@Then("submeto o formulário")
	public void submeto_o_formulario() throws IOException, InterruptedException {
		m.clicar(e.getBotaoSubmit());
		m.pausa(4000);

	}

	@Then("garanto que um popup foi aberto após o submit e fecho o popup")
	public void garanto_que_um_popup_foi_aberto_apos_o_submit_e_fecho_o_popup() throws IOException {
		m.tirarPrint("Formulario");
		m.fecharNavegador();
	}
}
