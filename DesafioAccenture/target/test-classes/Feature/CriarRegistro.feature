@tag
Feature: Criar Registro

  @tag1
  Scenario: Criar e editar um registro na tabela
    Given Given que eu acesse a URL de criação de registro  "https://demoqa.com/"
    And escolho a opção "Elements" 
    When clico no submenu do "Web Tables"
    And crio um novo registro
    And edito o novo registro criado
    Then verifico que o registro foi atualizado corretamente
    When crio mais doze novos registros  
    And apago todos os registros criados 