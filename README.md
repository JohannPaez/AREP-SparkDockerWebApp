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
### Local
Aplicativo web funcionando correctamente en el puerto 10000 y contenido de los mensajes de la base de datos Mongo.

![](Images/imagen1.png)

Agregar un nuevo mensaje a la base de datos mediante el aplicativo.

![](Images/imagen2.png)

Mensaje agregado correctamente a la base de datos 

![](Images/imagen3.png)

Contenido de la base de datos mediante el cliente Studio 3T.

![](Images/imagen4.png)

Petición Post al servidor web usando Curl para añadir un nuevo mensaje a la base de datos.

![](Images/imagen2_2.png)

Petición Get al servidor web usando Curl para ver todos los mensajes de la base de datos.

![](Images/imagen2_3.png)

Logs del balanceador de carga al realizar las anteriores operaciones (se puede evidenciar el balanceo de cargas de Round Robin, delegando el procesamiento del mensaje).

![](Images/imagen5.png)

### AWS

Aplicativo web funcionando correctamente en AWS en el puerto 10000 y contenido de los mensajes de la base de datos Mongo.

![](Images/imagen6.png)

Logs del balanceador de carga de AWS (se puede evidenciar el balanceo de cargas de Round Robin, delegando el procesamiento del mensaje).

![](Images/imagen7.png)

Contenido de la base de datos mediante el cliente Studio 3T.

![](Images/imagen8.png)

Petición Post al servidor web en AWS usando Curl para añadir un nuevo mensaje a la base de datos.

![](Images/imagen9.png)

Petición Get al servidor web usando Curl para comprobar que el mensaje anterior se agrego correctamente.

![](Images/imagen10.png)

Contenido del aplicativo web después de realizar la petición Post mediante el curl.

![](Images/imagen11.png)


## Construido 
- [Eclipse](https://www.eclipse.org/) Editor de JAVA donde se puede compilar el proyecto.

- [Maven](https://maven.apache.org/) Administrador de dependencias.

- [Docker](https://www.docker.com/) Administrador de contenedores.

## Autor
**Johann Sebastian Páez Campos** - Trabajo Programación AREP-DockerSparkWebApp **21/09/2020**

## Licencia
Este programa es de uso libre, puede ser usado por cualquier persona.

Los terminos de la licencia se pueden encontrar en el siguiente archivo [License](LICENSE).
