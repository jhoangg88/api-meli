Feature: Products API

  Scenario: Obtener lista de productos
    Given url 'http://localhost:8080/api/v1/products'
    When method GET
    Then status 200
    And match response != null
    And match response[0].id != null

  Scenario: Obtener un solo producto
    Given url 'http://localhost:8080/api/v1/products/P002'
    When method GET
    Then status 200
    And match response != null
    And match response.id == 'P002'

  Scenario: producto no existe
    Given url 'http://localhost:8080/api/v1/products/P888'
    When method GET
    Then status 404
    And match response.error == 'Not Found'
    And match response.message == 'Product not found: P888'