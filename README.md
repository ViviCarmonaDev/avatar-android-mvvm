# Avatar-android-mvv

App Android nativa con avatares 3D animados, creados en Blender y renderizados con SceneView (Filament).

📖 Documentación técnica completa (arquitectura, decisiones de diseño, flujo de auth):

[![Documentación en GitBook](https://img.shields.io/badge/Docs-GitBook-3884FF?style=for-the-badge&logo=gitbook&logoColor=white)](https://v-c-myproyects.gitbook.io/avatar_android_mvvm/) 

## ✨ Características

-  **Home** con saludo personalizado y buscador
-  **Lista de avatares** en formato grid, con 3 avatares propios (Robotito, Zorrito, Astronauta)
-  **Visor 3D animado**: cada avatar tiene su propia animación (saludo, salto, giro de cabeza)
-  **Perfil editable**, con persistencia real (Room)
-  **Configuración** con tema claro/oscuro funcional
-  Navegación con barra inferior (BottomNavBar)

## 🏗️ Arquitectura

El proyecto sigue **MVVM (Model-View-ViewModel)**:

com.vivicarmonadev.avatarapp

├── data/ → Model: entidades, DAO, Database (Room), Repository

├── ui/

│ ├── home/ → HomeScreen (View) + HomeViewModel

│ ├── avatares/ → AvataresScreen + AvataresViewModel + DetalleAvatarScreen

│ ├── perfil/ → PerfilScreen + PerfilViewModel

│ ├── configuracion/ → ConfiguracionScreen + ConfiguracionViewModel

│ ├── theme/ → Colores, tipografía, tema claro/oscuro

│ ├── BottomNavBar.kt → Componente de navegación compartido

│ └── NavGraph.kt → Grafo de navegación (Navigation Compose)

├── AvatarApp.kt → Application, punto de entrada del contenedor de dependencias

└── MainActivity.kt

**Reglas seguidas:**
- El **ViewModel** nunca importa nada de Compose — solo expone estado (`StateFlow`) y lógica.
- La **View** (Composable) solo dibuja y notifica acciones del usuario, nunca decide nada por sí sola.
- El **Repository** es la única puerta de entrada a los datos (Room); los ViewModels no conocen la base de datos directamente.

## 🛠️ Stack técnico

| Tecnología | Uso |
|---|---|
| Kotlin + Jetpack Compose | UI declarativa |
| Navigation Compose | Navegación entre pantallas |
| ViewModel + StateFlow | Gestión de estado (MVVM) |
| Room | Persistencia local (perfil, preferencias) |
| SceneView (Filament) | Renderizado de modelos 3D (glTF/GLB) |
| Blender | Modelado, rigging y animación de los avatares |

## 🎨 Los avatares (Blender → Android)

1. Modelado con primitivas simples en Blender
2. Rigging (esqueleto/Armature) con Automatic Weights
3. Animación por keyframes en Pose Mode
4. Exportación a `.glb` (glTF Binario, incluye modelo + animación)
5. El `.glb` se coloca en `app/src/main/assets/`
6. SceneView lo carga y renderiza en Android, reproduciendo la animación al tocar un botón

Los archivos fuente de Blender (`.blend`) están en `blender-assets/avatares/`, y los `.glb` exportados en `blender-assets/exports/`.

## 🚀 Cómo correr el proyecto

1. Cloná el repo: `git clone https://github.com/ViviCarmonaDev/avatar-android-mvvm.git`
2. Abrí la carpeta en Android Studio (versión reciente, con soporte JDK 17)
3. Sincronizá Gradle (automático al abrir)
4. Corré en un emulador o dispositivo físico (mínimo API 24)

