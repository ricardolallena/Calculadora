# Calculadora

## Descripción

Microservicio para realizar operaciones.
La aplicación traza todas las operaciones y errores con la libreria librería tracer-1.0.0.jar.  

Diseño realizado por capas: controlador, servicio y modelo.

Test unitario para asegurar la calidad del codigo.

Para añadir nuevas operaciones en el futuro de forma agil, se realiza un diseño modular implementando una clase por cada operacion.

## Tecnologías

* Spring Boot 3.0.2
* Java 17
* Apache Maven 3.9.0

## Dependencias

Es necesario instalar en el repositorio local de maven la libreria tracer-1.0.0.jar, para poder resolver la siguiente dependencia

	<dependency>
			<groupId>io.corp.calculator</groupId>
			<artifactId>tracer</artifactId>
			<version>1.0.0</version>	
    </dependency>

Comando para instalar la libreria en el repositorio local de maven:
`mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=./lib/tracer-1.0.0.jar`

## Compilar y crear jar ejecutable
`mvn clean package`

## Iniciar aplicación
`java -jar target\calculadora-0.0.1-SNAPSHOT.jar`

Una vez ejecutada la aplicación puede acceder a la definicion de la Api y realizar pruebas en la siguente direccion: 
[http://localhost:9090/calculadora/swagger-ui/index.html](http://localhost:9090/calculadora/swagger-ui/index.html)
