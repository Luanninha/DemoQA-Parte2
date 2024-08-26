@tag
Feature: Manipulação de Progress

@tag1
  Scenario: Interagir com a progress bar
    Given que eu acesse a URL de validar o Progress "https://demoqa.com/"
    And e vou ate a "Widgets"
    And escolho a opção do "Progress"
    When clico no botão "Start Progress" e paro antes dos 25%
    And valido que o valor da progress bar é menor ou igual a 25%
    Then clico no botão "Reset Progress" novamente e ao chegar aos 100% reseto a progress bar