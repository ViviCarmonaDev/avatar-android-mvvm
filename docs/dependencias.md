# Dependencias del proyecto

## build.gradle.kts (Module :app)

```kotlin
dependencies {
    // Navigation
    implementation("androidx.navigation:navigation-compose:2.8.4")

    // ViewModel + Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")

    // Room
    implementation("androidx.room:room-runtime:2.7.1")
    implementation("androidx.room:room-ktx:2.7.1")
    ksp("androidx.room:room-compiler:2.7.1")

    // SceneView (renderizado 3D)
    implementation("io.github.sceneview:sceneview:2.2.1")
}
```

## Plugins

```kotlin
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp") version "2.2.10-2.0.2"
}
```

## gradle.properties

```properties
android.disallowKotlinSourceSets=false
```
Necesario por un conflicto entre KSP y el manejo de "built-in Kotlin" de versiones recientes de AGP.

## Por qué cada una

- **Navigation Compose**: manejar las 5 pantallas (Home, Avatares, Perfil, Configuración, Detalle) sin Activities/Fragments separados
- **Lifecycle ViewModel/Runtime Compose**: integrar `ViewModel` y `StateFlow` de forma nativa con Composables (`viewModel()`, `collectAsStateWithLifecycle()`)
- **Room**: persistencia local del perfil de usuario y preferencias, sin necesidad de backend
- **SceneView**: renderizar y animar los modelos `.glb` exportados de Blender, usando el motor Filament de Google por debajo