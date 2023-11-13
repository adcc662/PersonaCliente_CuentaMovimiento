# Microservicio Cuenta y movimientos

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
   localhost:8081/cuentas
{
  "numeroCuenta": "1234567890",
  "tipoCuenta": "Ahorros",
  "saldoInicial": 1000.00,
  "estado": true,
  "cliente": {
    // Asumiendo que el cliente ya existe
    "id": 1
  }
  
  localhost:8081/movimientos
{
  "fecha": "2023-01-01T12:00:00Z",
  "tipoMovimiento": "Deposito",
  "valor": 200.00,
  "saldoDespuesMovimiento": 1200.00,
  "cuenta": {
    // Asumiendo que la cuenta ya existe
    "id": 1
  }

```

Espero que la aplicación sea de tu agrado. ¡Saludos!