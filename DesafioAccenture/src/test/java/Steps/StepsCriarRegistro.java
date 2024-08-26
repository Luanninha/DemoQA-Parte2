package Steps;

import java.io.IOException;

import Elementos.ElementosCriarRegistro;
import Metodos.Metodos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsCriarRegistro {

	private Metodos m = new Metodos();
	private ElementosCriarRegistro e = new ElementosCriarRegistro();

	@Given("Given que eu acesse a URL de criação de registro  {string}")
	public void given_que_eu_acesse_a_url_de_criação_de_registro(String string) {
		m.AbrirNavegador(string);
	}

	@Given("escolho a opção {string}")
	public void escolho_a_opção(String string) {
		m.rolarAteElemento(e.getCampoElements());
		m.clicar(e.getCampoElements());
	}

	@When("clico no submenu do {string}")
	public void clico_no_submenu_do(String string) {
		m.clicarElementoComJavaScript(e.getSubmenuWebTables());
	}

	@When("crio um novo registro")
	public void crio_um_novo_registro() {
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Luiza Simone");
		m.preencher(e.getLastName(), "Aparício");
		m.preencher(e.getEmail(), "luiza_aparicio@engenharia.ufjf.br");
		m.preencher(e.getAge(), "63");
		m.preencher(e.getSalary(), "3000");
		m.preencher(e.getDepartment(), "Legal");
		m.clicar(e.getSubmitRegistro());

	}

	@When("edito o novo registro criado")
	public void edito_o_novo_registro_criado() {
		m.rolarAteElemento(e.getBtEdit());
		m.clicar(e.getBtEdit());
		m.clicar(e.getAge());
		m.apagarTexto(e.getAge());
		m.preencher(e.getAge(), "62");
		m.clicar(e.getSubmitRegistro());
	}

	@Then("verifico que o registro foi atualizado corretamente")
	public void verifico_que_o_registro_foi_atualizado_corretamente() throws IOException, InterruptedException {
		m.validarTexto(e.getElementEdit(), "62");
		m.pausa(3000);
		m.tirarPrint("Registro Editado");
	}

	@When("crio mais doze novos registros")
	public void crio_mais_doze_novos_registros() throws InterruptedException, IOException {
		m.pausa(3000);

		// Registro 1
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Ana Clara");
		m.preencher(e.getLastName(), "Silva");
		m.preencher(e.getEmail(), "ana_clara_silva@example.com");
		m.preencher(e.getAge(), "25");
		m.preencher(e.getSalary(), "2500");
		m.preencher(e.getDepartment(), "Finance");
		m.clicar(e.getSubmitRegistro());

		m.pausa(3000);

		// Registro 2
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Carlos Eduardo");
		m.preencher(e.getLastName(), "Oliveira");
		m.preencher(e.getEmail(), "carlos_eduardo_oliveira@example.com");
		m.preencher(e.getAge(), "32");
		m.preencher(e.getSalary(), "3500");
		m.preencher(e.getDepartment(), "HR");
		m.clicar(e.getSubmitRegistro());

		m.pausa(3000);

		// Registro 3
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Beatriz Costa");
		m.preencher(e.getLastName(), "Pereira");
		m.preencher(e.getEmail(), "beatriz_costa_pereira@example.com");
		m.preencher(e.getAge(), "28");
		m.preencher(e.getSalary(), "2700");
		m.preencher(e.getDepartment(), "Marketing");
		m.clicar(e.getSubmitRegistro());

		m.pausa(3000);

		// Registro 4
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Fernando Almeida");
		m.preencher(e.getLastName(), "Ribeiro");
		m.preencher(e.getEmail(), "fernando_almeida_ribeiro@example.com");
		m.preencher(e.getAge(), "40");
		m.preencher(e.getSalary(), "4000");
		m.preencher(e.getDepartment(), "Sales");
		m.clicar(e.getSubmitRegistro());

		m.pausa(3000);

		// Registro 5
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Mariana Santos");
		m.preencher(e.getLastName(), "Cardoso");
		m.preencher(e.getEmail(), "mariana_santos_cardoso@example.com");
		m.preencher(e.getAge(), "29");
		m.preencher(e.getSalary(), "2900");
		m.preencher(e.getDepartment(), "Legal");
		m.clicar(e.getSubmitRegistro());

		m.pausa(3000);

		// Registro 6
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Gabriel Lima");
		m.preencher(e.getLastName(), "Martins");
		m.preencher(e.getEmail(), "gabriel_lima_martins@example.com");
		m.preencher(e.getAge(), "35");
		m.preencher(e.getSalary(), "3200");
		m.preencher(e.getDepartment(), "Finance");
		m.clicar(e.getSubmitRegistro());

		// Registro 7
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Juliana Ferreira");
		m.preencher(e.getLastName(), "Mendes");
		m.preencher(e.getEmail(), "juliana_ferreira_mendes@example.com");
		m.preencher(e.getAge(), "31");
		m.preencher(e.getSalary(), "3100");
		m.preencher(e.getDepartment(), "HR");
		m.clicar(e.getSubmitRegistro());

		m.pausa(3000);

		// Registro 8
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Roberto Souza");
		m.preencher(e.getLastName(), "Nogueira");
		m.preencher(e.getEmail(), "roberto_souza_nogueira@example.com");
		m.preencher(e.getAge(), "37");
		m.preencher(e.getSalary(), "3300");
		m.preencher(e.getDepartment(), "Marketing");
		m.clicar(e.getSubmitRegistro());

		m.pausa(3000);

		// Registro 9
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Luciana Gomes");
		m.preencher(e.getLastName(), "Lima");
		m.preencher(e.getEmail(), "luciana_gomes_lima@example.com");
		m.preencher(e.getAge(), "26");
		m.preencher(e.getSalary(), "2600");
		m.preencher(e.getDepartment(), "Sales");
		m.clicar(e.getSubmitRegistro());

		m.pausa(3000);

		// Registro 10
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Eduardo Martins");
		m.preencher(e.getLastName(), "Silveira");
		m.preencher(e.getEmail(), "eduardo_martins_silveira@example.com");
		m.preencher(e.getAge(), "33");
		m.preencher(e.getSalary(), "3100");
		m.preencher(e.getDepartment(), "Legal");
		m.clicar(e.getSubmitRegistro());

		m.pausa(3000);

		// Registro 11
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Larissa Costa");
		m.preencher(e.getLastName(), "Fernandes");
		m.preencher(e.getEmail(), "larissa_costa_fernandes@example.com");
		m.preencher(e.getAge(), "27");
		m.preencher(e.getSalary(), "2800");
		m.preencher(e.getDepartment(), "Finance");
		m.clicar(e.getSubmitRegistro());

		m.pausa(3000);

		// Registro 12
		m.rolarAteElemento(e.getNovoRegistroAdd());
		m.clicar(e.getNovoRegistroAdd());
		m.preencher(e.getFirstName(), "Rafael Pacheco");
		m.preencher(e.getLastName(), "Barbosa");
		m.preencher(e.getEmail(), "rafael_pacheco_barbosa@example.com");
		m.preencher(e.getAge(), "39");
		m.preencher(e.getSalary(), "3400");
		m.preencher(e.getDepartment(), "HR");
		m.clicar(e.getSubmitRegistro());

		m.tirarPrint("Todos Registros");
	}

	@When("apago todos os registros criados")
	public void apago_todos_os_registros_criados() throws InterruptedException, IOException {
		m.clicar(e.getBtDelete4());
		m.clicar(e.getBtDelete5());
		m.clicar(e.getBtDelete6());
		m.clicar(e.getBtDelete7());
		m.clicar(e.getBtDelete8());
		m.clicar(e.getBtDelete9());
		m.clicar(e.getBtDelete10());
		m.clicar(e.getBtDelete11());
		m.clicar(e.getBtDelete12());
		m.clicar(e.getBtDelete13());
		m.clicar(e.getBtDelete14());
		m.clicar(e.getBtDelete15());
		m.clicar(e.getBtDelete16());

		m.tirarPrint("Apaga todos os registros");
		m.pausa(6000);
		m.fecharNavegador();
	}
}