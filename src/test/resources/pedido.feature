Feature: Pedido
  Testes relacionados ao pedido

  Scenario: Salvar um pedido menor que 100.0 reais do DF com Frete
    Given que eu tenha um pedido com o valor de 50.0 reais
    And o cliente eh do DF
    When salvar um pedido
    Then o pedido tem que ter acrescentado o frete

  Scenario: Salvar um pedido menor que 100.0 reais do RJ com Frete
    Given que eu tenha um pedido com o valor de 50.0 reais
    And o cliente eh do RJ
    When salvar um pedido
    Then o pedido tem que ter acrescentado o frete

  Scenario: Salvar um pedido maior que 100.0 reais do DF sem Frete
    Given que eu tenha um pedido com o valor de 150.0 reais
    And o cliente eh do DF
    When salvar um pedido
    Then o valor tem que ser mantido

  Scenario Outline: Salvar pedido
    Given que eu tenha um pedido com o valor de <valor> reais
    And o cliente eh do <estado>
    When salvar um pedido
    Then o valor tem que ser de <result>

    Examples:
      | valor | result | estado |
      | 150.0 | 150.0  | DF     |
      | 99.0  | 114.0  | DF     |
      | 170.0 | 185    | RJ     |
