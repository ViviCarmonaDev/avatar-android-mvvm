# Blender → Android

Proceso completo para crear un nuevo avatar animado, desde el modelado en Blender hasta verlo funcionando en la app.

## 1. Modelado

Se usan primitivas simples de Blender (cubos, esferas, cilindros, conos) unidas en un solo objeto con `Ctrl+J`. No se busca realismo, sino simplicidad y consistencia en el flujo completo.

## 2. Rigging (esqueleto)

- Se agrega un `Armature` con huesos nombrados de forma descriptiva (`columna`, `brazo_izq`, `pierna_der`, etc.)
- Se vincula el esqueleto al modelo con **Parenting → With Automatic Weights**, que calcula automáticamente qué parte de la malla se mueve con cada hueso

## 3. Animación

En **Pose Mode**, se insertan keyframes de rotación (o posición) en distintos frames de la timeline, creando el ciclo de animación (ej: saludo, salto, giro de cabeza).

## 4. Exportación

`File → Export → glTF 2.0 (.glb)`, con:
- Format: **glTF Binary (.glb)**
- Include: **Selected Objects**
- Animation: **activado**

El resultado es un único archivo `.glb` que contiene modelo + esqueleto + animación.

## 5. Integración en Android

1. El `.glb` se copia a `app/src/main/assets/`
2. `DetalleAvatarViewModel` recibe el nombre del archivo como argumento de navegación
3. `DetalleAvatarScreen` usa **SceneView** (que envuelve el motor **Filament** de Google) para cargar y renderizar el modelo
4. Un botón dispara la reproducción de la animación embebida en el `.glb`

## Avatares actuales

| Avatar | Animación | Archivo |
|---|---|---|
| Robotito | Saludo con el brazo | `robotito.glb` |
| Zorrito | Salto | `zorrito.glb` |
| Astronauta | Giro de cabeza | `astronauta.glb` |

## Cómo agregar un avatar nuevo

1. Repetir el flujo de modelado + rig + animación en un archivo `.blend` nuevo dentro de `blender-assets/avatares/`
2. Exportar a `blender-assets/exports/nombre.glb`
3. Copiar a `app/src/main/assets/`
4. Agregar la entrada correspondiente en `AvataresViewModel.kt` (lista de avatares mock)