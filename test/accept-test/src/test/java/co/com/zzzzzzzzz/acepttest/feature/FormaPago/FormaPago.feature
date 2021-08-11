Feature: Obtener una Forma de Pago
  Background:
    #* url 'https://internal-dev.apps.ambientesbc.com/horus/payment-causation/'
    * url 'http://localhost:9124'
    * configure ssl = true

  Scenario: Validar estado Ok
    Given path 'formapago/2'
    When method get
    Then status 200

  Scenario: Obtener TRANSFERENCIA BANCOLOMBIA
    Given path 'formapago/2'
    When method get
    Then status 200
    And match $.nombre == 'TRANSFERENCIA BANCOLOMBIA\r\n'

  Scenario: Obtener ACH
    Given path 'formapago/3'
    When method get
    Then status 200
    And match $.nombre == 'ACH\r\n'
    
  Scenario: Obtener formas de pago
    Given path 'formapago-todos'
    When method get
    Then status 200

  Scenario: Validar existencia tipo de pago Efectivo Sucursal Bancolombia
    Given path 'formapago-todos'
    When method get
    Then status 200
    And match $.[0].descripcion == 'Efectivo Sucursal Bancolombia'

  Scenario: Validar que ningun id sea nulo
    Given path 'formapago-todos'
    When method get
    Then status 200
    And match each $.[*].id == '#notnull'