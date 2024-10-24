# Backend Challenge: 👻 API de Monstruos 👻

¡Prepárate para un escalofriante viaje al mundo de los monstruos! ️ Este proyecto te invita a crear una API RESTful en Java para gestionar una base de datos de criaturas de Halloween. ¡Imagina un bestiario digital donde podrás crear, modificar y eliminar a tus monstruos favoritos!

## Funcionalidades 🕸️
+ Creación de monstruos: Da vida a tus pesadillas más aterradoras creando nuevos monstruos con sus características únicas. ‍♂️
+ Lectura de monstruos: Explora tu colección de monstruos y descubre sus detalles más siniestros. ‍♂️
+ Actualización de monstruos: Modifica las características de tus monstruos para hacerlos aún más terroríficos.
+ Eliminación de monstruos: Despide a tus criaturas menos favoritas con un clic.
+ Autenticación: Protege tu colección de monstruos con un sistema de autenticación básico.
+ Documentación: Explora la API utilizando Swagger u OpenAPI para descubrir todas sus posibilidades.

## Tecnologías Utilizadas 🎃
+ Java: Lenguaje de programación principal.
+ Spring Boot: Framework para desarrollo de aplicaciones Java.
+ Base de datos relacional: H2 (en memoria para desarrollo, configurable para producción).
+ Autenticación: Básica (username y password).
+ Documentación: Swagger/OpenAPI.

![swagger](https://github.com/user-attachments/assets/318ec114-bcca-439e-965d-2bab789d3724)

+ Estructura del Proyecto ⚰️
`src/main/java`: Contiene el código fuente de la aplicación.
`src/test/java`: Contiene los tests unitarios.
`resources`: Contiene los archivos de configuración, como el archivo `application.properties`.

## Endpoints 🧛
+ `GET /monsters`: Obtiene una lista de todos los monstruos.
+ `POST /monsters`: Crea un nuevo monstruo. Cuerpo de la solicitud: JSON con los atributos del monstruo (nombre, tipo, etc.)
+ `GET /monsters/{id}`: Obtiene un monstruo específico por su ID.
+ `PUT /monsters/{id}`: Actualiza un monstruo específico.
+ `DELETE /monsters/{id}`: Elimina un monstruo específico.

## Ejecución del Proyecto 🧟
+ Clona el repositorio: git clone https://github.com/Orliluq/monster.git
+ Importa el proyecto en tu IDE favorito.
+ Ejecuta la aplicación Spring Boot.
+ Accede a la documentación de la API a través de Swagger UI (la URL se mostrará en la consola).

## Contribuciones 🦹
¡Las contribuciones son bienvenidas! Si encuentras algún error o deseas agregar nuevas funcionalidades, por favor, abre un issue o crea una pull request.

## Licencia ⚡
Este proyecto está licenciado bajo los términos de la licencia MIT. Puedes encontrar el texto completo de la licencia en el archivo LICENSE
