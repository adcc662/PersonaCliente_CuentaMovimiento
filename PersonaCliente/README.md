# Microservicio Persona y clientes

### 🛠️ Tecnologías utilizadas:

- **Java 17** Debido al rápido desarrollo que te da spring boot y la facilidad de implementar librerías.
- **PostgreSQL:** Elegido por su robustez en el procesamiento de datos.
- **Kafka:** Para la comunicación entre microservicios.
- **Docker:** Para la creación de contenedores.
- **JPA:** Para la persistencia de datos.
- **Patrón de diseño Repositorio:** Esto con el fin de tener un mejor diseño de código y una mejor escalabilidad.


### 🔧 Pasos para probar la aplicación:

1. **Clonar el repositorio y ejecutar el contenedor:**

```sh
https://github.com/adcc662/CuentaMovimientoJava.git
cd CuentaMovimientoJava
docker-compose up --build
```
A partir de este punto despues de correr el microservicio solo se debe usar `docker-compose up` para levantar el microservicio.

**Datos para la API**

```sh
   localhost:8080/personas
{
  "nombre": "Juan Perez",
  "genero": "Masculino",
  "edad": 30,
  "identificacion": "11050789",
  "direccion": "123 Calle Principal",
  "telefono": "0987654321"
}
  
  localhost:8080/clientes
{
  "nombre": "Ana Ramirez",
  "genero": "Femenino",
  "edad": 28,
  "identificacion": "11050678",
  "direccion": "456 Calle Secundaria",
  "telefono": "0987654322",
  "contrasena": "8989/*/+",
  "estado": true
}

```

Espero que la aplicación sea de tu agrado. ¡Saludos!

