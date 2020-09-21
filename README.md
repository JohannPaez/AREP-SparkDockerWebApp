# AREP-SparkDockerWebApp



  ## Diseño
 Los detalles del diseño, la arquitectura del programa, problema, definiciones y pruebas se pueden encontrar en el siguiente documento [Artículo Sobre el Diseño]().
   
 ## Prerequisitos
 Tener instalado:
 - Java.
 - Maven.
 - Docker.
 
 Entender sobre peticiones http, docker (contenedores), servidores y demás, así como el lenguaje JAVA en el que fue realizado este proyecto.
 
 ## Comandos 
  Para compilar y correr las pruebas: ```mvn package```
  
  Para ejecutar y utilizar los aplicativos: ```mvn exec:java -Dexec.mainClass="com.arep.SparkWebServer"```
  
  Para generar javadoc con maven: ```mvn javadoc:javadoc```
  
  Para generar javadoc de las pruebas: ```mvn javadoc:test-javadoc```
  
  **IMPORTANTE:** Para poder utilizar el aplicativo es necesario compilar primero el proyecto con **mvn package**.
 
 ## ¿Cómo usar el aplicativo?
 Descargue o clone el repositorio con el siguiente comando.
 
    git clone https://github.com/JohannPaez/AREP-SparkDockerWebApp.git
    
Acceda a los proyectos LoadBalancer y SparkWebApp y compile cada proyecto con el comando.

    mvn package

Luego acceda al directorio DockerCompose y ejecute el siguiente comando para crear los contenedores en docker y poder utilizar el aplicativo.

    docker-compose up -d --scale web=3

Una vez el proyecto termine de crearse, puede acceder al aplicativo web mediante http://localhost:10000/.
        
 
 ## Operaciones
 - **GET**: Permite realizar peticiones get definidas por el usuario como (retornar los mensajes en este caso).
 	- **/mensajes**: Es la operación encargada de dar todos los mensajes.
 - **POST**: Permite realizar peticiones post definidas por el usuario como (insertar un nuevo mensaje).
 	- **/addMensaje**: Es la operación encargada de añadir un nuevo mensaje.


## Pruebas





## Construido 
- [Eclipse](https://www.eclipse.org/) Editor de JAVA donde se puede compilar el proyecto.

- [Maven](https://maven.apache.org/) Administrador de dependencias.

- [Docker](https://www.docker.com/) Administrador de contenedores.

## Autor
**Johann Sebastian Páez Campos** - Trabajo Programación AREP-DockerSparkWebApp **21/09/2020**

## Licencia
Este programa es de uso libre, puede ser usado por cualquier persona.

Los terminos de la licencia se pueden encontrar en el siguiente archivo [License](LICENSE).
