@tag
Feature: Formulário de Testes

@tag1
  Scenario: Preencher e submeter o formulário
    Given que eu acesse a url de Formulário "https://demoqa.com/"
    And escolho a opção "Forms" na tela
    When clico no "Practice Form"
    And preencho todo o formulário com valores aleatórios
    Then submeto o formulário
    And garanto que um popup foi aberto após o submit e fecho o popup