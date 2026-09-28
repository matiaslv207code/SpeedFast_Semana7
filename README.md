# 🖥️ Actividad Formativa Semana 7 – Desarrollo Orientado a Objetos II

## 👤 Autor del proyecto
- **Nombre completo:** Matías Felipe Lopez Villarroel
- **Sección:** 005A
- **Carrera:** Analista Programador Computacional
- **Sede:** Modalidad Online

---

## 📘 Descripción general del sistema
Este proyecto corresponde al desarrollo de la Semana 7 para la empresa **SpeedFast**, titulado **"Conectando aplicaciones Java con bases de datos mediante JDBC"**.

El sistema implementa la persistencia de datos conectando la aplicación Java de escritorio con una base de datos relacional **MySQL** mediante JDBC. Permite registrar y consultar información en tiempo real directamente desde los formularios gráficos hacia las tablas del sistema.

### Funcionalidades principales:
- **Gestión de Conexión (`ConexionBD`):** Conexión segura al servidor MySQL utilizando `DriverManager` y manejo de excepciones con bloques try-catch.
- **Capa de Acceso a Datos (DAO):** Clases especializadas (`PedidoDAO`, `RepartidorDAO` y `EntregaDAO`) para realizar consultas e inserciones mediante consultas parametrizadas (`PreparedStatement` y `ResultSet`).
- **Interfaz Gráfica Integrada (`VentanaPrincipal`):** Formulario desarrollado en Java Swing con validaciones, botones de acción y una tabla (`JTable`) que se actualiza automáticamente con los registros de la base de datos.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 src/
├── cl.duoc.speedfast/
    ├── dao/                  # Clases de acceso a datos y conexión con MySQL
    │   ├── ConexionBD.java
    │   ├── EntregaDAO.java
    │   ├── PedidoDAO.java
    │   └── RepartidorDAO.java
    ├── gui/                  # Interfaces gráficas de usuario (Java Swing)
    │   └── VentanaPrincipal.java
    ├── modelo/               # Clases de entidad / POJOs del negocio
    │   ├── Entrega.java
    │   ├── Pedido.java
    │   └── Repartidor.java
    └── Main.java             # Punto de entrada de la aplicación
📁 lib/
    └── mysql-connector-j-*.jar   # Conector JDBC de MySQL
```

---

## ⚙️ Configuración de la Base de Datos

1. Crea la base de datos en MySQL Workbench o consola:
```sql
CREATE DATABASE IF NOT EXISTS speedfast_db;
USE speedfast_db;
Ejecuta el script de creación de tablas:

SQL
CREATE TABLE repartidor (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            nombre VARCHAR(100) NOT NULL
);

CREATE TABLE pedido (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        direccion VARCHAR(150) NOT NULL,
                        tipo VARCHAR(30) NOT NULL,      -- COMIDA | ENCOMIENDA | EXPRESS
                        estado VARCHAR(20) NOT NULL     -- PENDIENTE | EN_REPARTO | ENTREGADO
);

CREATE TABLE entrega (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         id_pedido INT NOT NULL,
                         id_repartidor INT NOT NULL,
                         fecha DATE NOT NULL,
                         hora TIME NOT NULL,
                         FOREIGN KEY (id_pedido) REFERENCES pedido(id),
                         FOREIGN KEY (id_repartidor) REFERENCES repartidor(id)
);
```

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/matiaslv207code/SpeedFast_Semana7.git
```

2. Abre el proyecto completo en tu entorno IntelliJ IDEA.

3. Asegúrate de que el archivo .jar del conector MySQL esté añadido como biblioteca en el proyecto (dentro de la carpeta lib).

4. Verifica tus credenciales de acceso a MySQL en la clase ConexionBD.java (usuario y contraseña).

5. Ejecuta el archivo Main.java ubicado en cl.duoc.speedfast para iniciar la interfaz gráfica conectada a la base de datos.


---

**Repositorio GitHub:** https://github.com/matiaslv207code/SpeedFast_Semana7

**Fecha de entrega:** \[28/09/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos II




