@tag
Feature: Validar Mensagem

  @tag1
  Scenario: Verificação de nova janela
    Given que eu acesse a url de Validar a Mensagem "https://demoqa.com/"
    And escolho na pagina inicial a opção "Alerts, Frame & Windows"
    When clico o submenu "Browser Windows"
    And clico no botao "New Window"
    And verifico que uma nova janela foi aberta e valido a mensagem "This is a sample page"
    Then fecho a nova janela aberta