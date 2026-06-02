# 📋 Sistema de Contactos

Aplicación web para la gestión de contactos, desarrollada con Spring Boot y Thymeleaf. Permite realizar operaciones CRUD completas sobre contactos almacenados en una base de datos MySQL.

---

## 🚀 Funcionalidades

- **Listar** todos los contactos registrados
- **Agregar** un nuevo contacto
- **Editar** la información de un contacto existente
- **Eliminar** un contacto

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Versión |
|---|---|
| Java | 17 |
| Spring Boot | 3.x |
| Spring Data JPA | 3.x |
| Thymeleaf | 3.x |
| MySQL | 8.x |
| Lombok | 1.18.x |
| Bootstrap | 5.3.8 |
| Maven | 3.x |

---

## 📦 Modelo de datos

Un **Contacto** se compone de los siguientes atributos:

| Campo | Tipo | Descripción |
|---|---|---|
| `idContacto` | Integer | Identificador único (autogenerado) |
| `nombre` | String | Nombre del contacto |
| `celular` | String | Número de celular |
| `email` | String | Correo electrónico |

---

## 📁 Estructura del proyecto

```
src/main/
├── java/gm/contactos/
│   ├── controlador/
│   │   └── ContactoControlador.java
│   ├── modelo/
│   │   └── Contacto.java
│   ├── repositorio/
│   │   └── ContactosRepositorio.java
│   └── servicio/
│       ├── IContactoServicio.java
│       └── ContactoServicio.java
└── resources/
    ├── templates/
    │   ├── fragmentos/
    │   │   └── fragmentos.html
    │   ├── index.html
    │   ├── agregar.html
    │   └── editar.html
    └── application.properties
```

---

## ⚙️ Requisitos previos

Antes de ejecutar el proyecto asegúrate de tener instalado:

- [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3+](https://maven.apache.org/download.cgi)
- [MySQL 8+](https://dev.mysql.com/downloads/)
- Un IDE como [IntelliJ IDEA](https://www.jetbrains.com/idea/)

---

## 🔧 Configuración y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/contactos.git
cd contactos
```

### 2. Configurar las variables de entorno

El proyecto usa variables de entorno para proteger las credenciales de la base de datos. Configura las siguientes variables en tu sistema o en tu IDE:

| Variable | Descripción | Ejemplo |
|---|---|---|
| `URL` | URL de conexión a MySQL | `jdbc:mysql://localhost:3306/contactos_db?createDatabaseIfNotExist=true` |
| `USER_NAME` | Usuario de MySQL | `root` |
| `PASSWORD_DB` | Contraseña de MySQL | `tu_password` |

**En IntelliJ:** `Run > Edit Configurations > Environment Variables`

### 3. Ejecutar el proyecto

```bash
mvn spring:boot run
```

O directamente desde IntelliJ ejecutando la clase principal.

### 4. Acceder a la aplicación

```
http://localhost:8080/
```

> La base de datos `contactos_db` se creará automáticamente si no existe gracias a la propiedad `createDatabaseIfNotExist=true`.

---

## 📌 Endpoints

| Método | URL | Descripción |
|---|---|---|
| GET | `/` | Lista todos los contactos |
| GET | `/agregar` | Muestra el formulario de agregar |
| POST | `/agregar` | Guarda un nuevo contacto |
| GET | `/editar/{id}` | Muestra el formulario de editar |
| POST | `/editar` | Actualiza un contacto existente |
| GET | `/eliminar/{id}` | Elimina un contacto |
