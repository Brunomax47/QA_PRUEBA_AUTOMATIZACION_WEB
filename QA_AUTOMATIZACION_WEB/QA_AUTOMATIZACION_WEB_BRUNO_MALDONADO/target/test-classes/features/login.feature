#language: es
@testfeature
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los items

  @test
  Escenario: Iniciar sesión
    Dado que me encuentro en la página de login de Juntoz
    Cuando inicio sesión con las credenciales correo: brunomax47@gmail.com y contraseña: Mayuscula1@
    Entonces entrara a la pagina Juntoz
