# Conceptos de Docker y configuración de Odoo

## Comandos Principales de Docker

- `docker run`: Crea y arranca un nuevo contenedor a partir de una imagen especificada.
- `docker build`: Construye una imagen Docker a partir de las instrucciones de un archivo `Dockerfile`.
- `docker ps`: Lista los contenedores en ejecución (usa `-a` para incluir detenidos).
- `docker stop` / `docker start`: Detiene de forma segura o inicia uno o varios contenedores existentes.
- `docker exec`: Ejecuta un comando dentro de un contenedor en marcha (ej. shell interactiva con `-it`).
- `docker compose up` / `docker compose down`: Levanta o destruye todos los servicios, redes y volúmenes definidos en el archivo de Compose.

### Imagen
Una **imagen** es la plantilla o receta congelada (de solo lectura) que contiene todo lo necesario para que una aplicación funcione: código, dependencias, librerías y configuración básica.

### Contenedor
Un **contenedor** es una instancia en ejecución de una imagen. Es ligero, aislado del sistema operativo principal y rápido de iniciar o detener.

### Volumen
Un **volumen** es el mecanismo para guardar datos de forma permanente (persistencia). Por defecto, los datos dentro de un contenedor se pierden cuando este se elimina; un volumen guarda los archivos fuera del ciclo de vida del contenedor (en disco o gestionado directamente por Docker).

---

## Estructura y Parámetros de compose.yml

El archivo `compose.yml` (o `docker-compose.yml`) permite definir y levantar múltiples contenedores de forma coordinada mediante bloques de configuración estructurados.

| Bloque / Parámetro | Descripción |
| :--- | :--- |
| `services:` | Define los contenedores a ejecutar (ej. aplicación web, base de datos). |
| `image:` | Especifica la imagen Docker a descargar o utilizar. |
| `build:` | Ruta al archivo `Dockerfile` si la imagen se compila localmente. |
| `ports:` | Mapeo de puertos entre el host y el contenedor (`puerto-host:puerto-contenedor`). |
| `environment:` | Variables de entorno y configuraciones dinámicas de la aplicación. |
| `volumes:` | Rutas del sistema o volúmenes montados dentro del contenedor. |
| `restart:` | Política de reinicio ante fallos o reinicios del sistema (ej. `always`). |
| `volumes:` | Declara volúmenes persistentes globales compartidos entre servicios. |
| `networks:` | Define redes internas aisladas para la comunicación entre contenedores. |

---

## Optimización de Recursos y Seguridad

### Eficiencia de recursos

- **Límites de CPU/RAM:** Define topes con `deploy.resources.limits` para que Odoo o la base de datos no saturen el servidor.
- **Workers de Odoo:** Evita `workers = 0` en producción, calcula `(CPUs * 2) + 1` y limita su memoria (`limit memory hard / soft`) para frenar fugas.
- **Ajuste de PostgreSQL:** Configura `shared_buffers` y `work_mem` según tu memoria real en vez de dejar los valores por defecto.
- **Imágenes ligeras:** Elige imágenes base reducidas (ej. `slim`) y limpia cachés temporales para ahorrar espacio e iniciar más rápido.

### Variables de entorno y secretos seguros

- **`.env` fuera de Git:** Guarda credenciales en `.env`, agrégalo a `.gitignore` y comparte solo una plantilla vacía (`.env.example`).
- **Sin texto plano:** Llama a las variables con sintaxis `${VARIABLE}` en el archivo Compose.
- **Docker Secrets:** Monta contraseñas en archivos de solo lectura dentro de `/run/secrets/` para que no se puedan leer con un simple comando de inspección.
- **Gestores externos:** En producción, usa herramientas dedicadas (Vault, AWS Secrets Manager o Doppler) para inyectar credenciales al desplegar.

---

## Variables de Entorno en Compose vs. odoo.conf

- **Diferencias:** `odoo.conf` concentra toda la configuración avanzada del framework en un único archivo estático. Las variables de entorno en `compose.yml` permiten sobreescribir o inyectar parámetros rápidamente sin editar ficheros.
- **¿Qué es más seguro?** Las variables de entorno combinadas con un archivo `.env` (ignorado en Git) o Docker Secrets. Un archivo `odoo.conf` suele subirse por error a repositorios exponiendo contraseñas.
- **¿Qué es más práctico para desarrollo local?** Un archivo `odoo.conf` montado como volumen, ya que facilita ajustar rutas de addons, logs y depuración en un solo sitio.

---

## Configuración en Producción vs. Desarrollo

- **Desarrollo:** Modo reload/dev activado, volúmenes de código montados para cambios en vivo, puertos expuestos a localhost y `workers = 0`.
- **Producción:** Multiproceso activado (`workers > 0`), proxy inverso (Nginx/Traefik) con SSL/HTTPS, sin recarga en caliente y `restart: always`.
- **Cómo convivir en Compose:**
  - **Archivos combinados (Recomendado):** `compose.yml` (base) + `compose.override.yml` (automático en local) y `compose.prod.yml` para producción.
  - **Perfiles:** Uso de `profiles: ["dev"]` y `profiles: ["prod"]` dentro del mismo fichero.

---

## Gestión de Directorios en Repositorios Git

- **`addons` (Módulos propios):** SÍ en el repositorio. Es el código fuente a versionar.
- **`filestore` (Adjuntos, imágenes, facturas):** NO en el repositorio. Datos dinámicos y privados; debe ir en volumen persistente.
- **`sessions` (Sesiones activas):** NO en el repositorio. Datos volátiles; gestionar mediante volumen o almacenamiento temporal.
