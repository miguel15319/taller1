Feature: Automatización de REST API - POM
  Yo como estudiante de calidad de software
  necesito construir una petición a una API
  para aprender a automatizar servicios

  Scenario: Consultar un usuario con método GET
    Given se establece la base url "https://gorest.co.in/"
    When se consulta en el endpoint "public/v2/users/" por id "6919842"
    Then se valida que el status code 200 y que contenga el nombre "Nuevo Nombre"

  Scenario: Modificar un usuario con método PUT
    Given se establece la base url "https://gorest.co.in/"
    When se modifica el usuario en el endpoint "public/v2/users/" con id "6919842" con nombre "Miguel Roa" y email "Roa@gmail.com"
    Then se valida que el status code 200 y que el nombre sea "Miguel Roaa" y el email sea "Roa@gmail.com"
