Feature: Actualizar un usuario con método PUT
  Cuando el usuario con id "12345" es actualizado con nombre "Nuevo Nombre" y correo "nuevo.email@ejemplo.com"
  Entonces la respuesta debe tener código de estado 200 y contener el nombre actualizado "Nuevo Nombre" y correo "nuevo.email@ejemplo.com"

  Scenario: Actualizar el nombre y email de un usuario existente
    Given se establece la base url "https://gorest.co.in/"
    And un usuario con id "1234" necesita ser actualizado
    When se actualiza el nombre a "Nuevo Nombre" y el email a "nuevoemail@example.com"
    Then se valida que el status code sea 200
    And se verifica que el nombre del usuario sea "Nuevo Nombre" y el email "nuevoemail@example.com"
