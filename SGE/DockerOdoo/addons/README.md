# Carpeta de Addons Personalizados

Este directorio está destinado a almacenar **módulos personalizados** desarrollados por el equipo o módulos comunitarios de terceros (OCA u otros).

- **Control de Versiones:** Este directorio **SÍ** se versiona en Git.
- **Montaje en Docker:** Se monta en el contenedor Odoo en la ruta `/mnt/extra-addons`.
- **Recomendación:** Cada módulo debe contener su estructura estándar:
  - `__manifest__.py`
  - `__init__.py`
  - `models/`
  - `views/`
  - `security/`
