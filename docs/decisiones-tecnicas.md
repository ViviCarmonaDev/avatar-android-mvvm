# Decisiones técnicas

## ¿Por qué MVVM?

Separa claramente la lógica de negocio (qué avatar está seleccionado, qué animación reproducir) de la UI. Es el patrón recomendado oficialmente por Google para Android con Compose, y facilita testear el ViewModel sin depender de la UI.

## ¿Por qué SceneView en vez de Unity?

Se evaluaron 3 opciones: renderizado nativo (SceneView/Filament), Unity embebido (Unity as a Library), y app completa en Unity. Se eligió **SceneView** porque:
- Permite mantener toda la app en un único stack tecnológico (Kotlin + Compose)
- No requiere aprender un motor de juegos completo para un caso de uso simple (visor de modelos animados)
- Integra naturalmente con MVVM y el ciclo de vida de Android

## ¿Por qué Room y no un backend?

El alcance del proyecto no requiere sincronización entre dispositivos ni multiusuario — Room cubre la necesidad de persistencia local de forma simple, sin la complejidad de levantar y mantener un backend.

## ¿Por qué inyección de dependencias manual en vez de Hilt?

Para un proyecto de este tamaño (pocas pantallas, un solo Repository), un contenedor manual (`AppContainer`) es suficientemente claro y evita la curva de aprendizaje y el boilerplate de configuración de Hilt. Si el proyecto creciera significativamente, sería el primer candidato a incorporar.