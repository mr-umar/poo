# Guía Definitiva de POO para el Examen

Este documento es tu manual de consulta único. Contiene todo lo necesario para resolver cualquier ejercicio de tus exámenes, estructurado en tres niveles de dificultad.

---

## NIVEL 1: LOS CIMIENTOS (Si fallas aquí, es imposible aprobar)

*Esta es la base. Son las primeras preguntas de **todos** los exámenes y valen entre 2 y 3 puntos. Debes dominarlas a la perfección, sin errores de sintaxis.*

### 1. Interpretación del Diagrama UML

El UML es tu biblia. Es la fuente de la verdad sobre la estructura del sistema.

| Símbolo | Nombre | Significado y Cómo Pensarlo |
| :--- | :--- | :--- |
| `-` | **Private** | El atributo/método solo es visible dentro de su propia clase. |
| `+` | **Public** | Visible para cualquier clase. |
| `#` | **Protected** | Visible para la clase y sus subclases. |
| `───▷` | **Herencia** | "Es-un". La subclase hereda todo lo `public` y `protected` de la superclase. (Ej: `SocioPremium` **es un** `Socio`). |
| `o───` | **Agregación** | "Tiene-un" (débil). La parte puede existir sin el todo. (Ej: un `Controlador` **tiene** `Equipos`, pero si se borra, los equipos siguen existiendo). Tu analogía: *la tortuga y el tortuguero*. |
| `◆───` | **Composición** | "Posee-un" (fuerte). La parte **NO** puede existir sin el todo. (Ej: una `Compra` **posee** `Items`. Si se borra la compra, los ítems desaparecen). Tu analogía: *el baño y la casa*. |
| `*`, `1..*` | **Multiplicidad** | Cuántos objetos se relacionan. `*` significa "cero o más", `1..*` significa "uno o más". |
| ***Cursiva*** | **Abstracto** | **¡CRÍTICO!** Si el nombre de una clase o método está en cursiva, significa que es `abstract`. No puedes hacer `new` de una clase abstracta, y estás **obligado** a implementar los métodos abstractos en las subclases concretas. |
| `<<interface>>`| **Interfaz** | Un contrato 100% abstracto. La relación de implementación se dibuja con una línea discontinua (`- - - ▷`). |

### 2. Declaración de Clases y Atributos

*   **Tu Tarea:** Traducir las cajas del UML a código Java.
*   **Reglas de Oro:**
    *   Atributos casi siempre `private`.
    *   Si el UML dice `libros: Map<String, Libro>`, tú escribes `private Map<String, Libro> libros;`.
    *   Si es una constante, como `MAX_JUGADORES`, se escribe `public static final int MAX_JUGADORES = ...;`.

### 3. Constructores

*   **Tu Tarea:** Dar vida a los objetos. Inicializar **todos** sus atributos.
*   **La Receta Infalible:**
    1.  El constructor es `public` y tiene el mismo nombre que la clase.
    2.  Recibe como parámetros los datos iniciales (ej: `String nombre`).
    3.  Usa `this.atributo = parametro;` para asignar los valores.
    4.  **¡EL PASO MÁS IMPORTANTE!** Las colecciones (`Map`, `List`) **DEBEN** ser inicializadas para evitar `NullPointerException`. **Este ha sido uno de tus errores recurrentes; no lo olvides.**
        ```
        public Controlador() {
            this.equipos = new HashMap<>(); // ¡OBLIGATORIO!
            this.partidos = new ArrayList<>(); // ¡OBLIGATORIO!
        }
        ```
    5.  **Herencia (`super()`):** Si estás en una subclase, la **primera línea** de tu constructor debe ser `super(...)` para llamar al constructor de la clase padre.
    
---
    
## NIVEL 2: EL NÚCLEO DEL EXAMEN (Aquí se decide el aprobado)

*Estos son los algoritmos y patrones que aparecen en las preguntas de mitad de examen, las que valen más puntos.*

### 4. Herencia y Polimorfismo

*   **Tu Tarea:** Implementar la funcionalidad que varía entre subclases.
*   **Reglas de Oro:**
    1.  **`extends` es la clave:** La herencia no existe sin `public class Estudiante extends Asistente`. **Omitir esto fue uno de tus errores conceptuales más graves.**
    2.  **`@Override` es obligatorio:** Usa **SIEMPRE** la anotación `@Override` cuando implementes un método de una superclase. Es tu seguro contra errores de tipeo y un requisito conceptual.

### 5. El Algoritmo de Búsqueda (¡EL MÁS IMPORTANTE!)

*   **Tu Tarea:** Encontrar un elemento en una colección que cumple una condición. Es el patrón más repetido.
*   **La Receta para `List` o `map.values()`:**
    ```
    public Estacion getEstacionPorNombre(String nombre) {
        // 1. Recorre la colección (en este caso, una lista)
        for (Estacion estacion : this.estaciones) {
            
            // 2. Aplica la condición de búsqueda
            //    (¡RECUERDA! para Strings, usa .equals())
            if (estacion.getNombre().equals(nombre)) {
                
                // 3. Si lo encuentras, devuélvelo INMEDIATAMENTE
                return estacion;
            }
        }
        
        // 4. Si el bucle termina, significa que no lo encontraste. Devuelve null.
        //    ¡NUNCA pongas un 'else { return null; }' dentro del bucle!
        //    Este ha sido uno de tus errores lógicos más importantes.
        return null;
    }
    ```

### 6. El Algoritmo de Agregación (Construir un Resumen)

*   **Tu Tarea:** Recorrer una colección para construir y devolver una nueva (casi siempre un `Map`) que resume la información.
*   **La Receta:**
    1.  Crea un mapa de resultados vacío: `Map<String, Integer> resultado = new HashMap<>();`.
    2.  Recorre la colección principal (ej. todas las reservas).
    3.  Para cada elemento, extrae la clave (ej. la matrícula del vehículo) y el valor a acumular (ej. la distancia).
    4.  **Si la clave ya existe en `resultado`, actualiza el valor:** `resultado.put(clave, resultado.get(clave) + valor);`.
    5.  **Si no existe, la añades:** `resultado.put(clave, valor);`.

---

## NIVEL 3: LÓGICA AVANZADA Y TEMAS FINALES

*Estas son las preguntas finales, las más complejas. Combinan todo lo anterior.*

### 7. Gestión de Errores con Excepciones

*   **Tu Tarea:** Manejar situaciones anómalas sin que el programa se caiga.
*   **Los 4 Componentes Clave (tu duda sobre `throw` vs. `throws`):**
    1.  **Crear tu propia excepción:** Una clase que hereda de `Exception`.
        ```
        public class TareaException extends Exception {
            public TareaException(String mensaje) {
                super(mensaje); // Pasa el mensaje al padre
            }
        }
        ```
    2.  **`throw`: Lanzar la excepción.** Es la acción, va dentro del método.
        ```
        if (tarea == null) {
            throw new TareaException("La tarea no existe.");
        }
        ```
    3.  **`throws`: Avisar en la firma.** Es la advertencia, va en la declaración del método. Es obligatorio para excepciones "checked" (las que heredan de `Exception`).
        ```
        public void miMetodo() throws TareaException { ... }
        ```
    4.  **`try-catch`: Capturar y manejar.** El `try` envuelve el código peligroso, el `catch` es el plan de contingencia.
        ```
        try {
            miControlador.asignarTarea("T-01");
        } catch (TareaException e) {
            System.out.println("Error: " + e.getMessage());
        }
        ```

### 8. Lógica de Negocio Secuencial

*   **Tu Tarea:** Implementar un método que realiza una serie de validaciones en orden estricto. Si una falla, lanza una excepción. Si todas pasan, modifica el estado del sistema.
*   **La Estructura (Patrón de Búsqueda Directa + Validación):**
    ```
    public void traspasarJugador(...) throws ... {
        // Validación 1: Busca directamente, no con un bucle
        Equipo equipoOrigen = this.equipos.get(nombreEquipoOrigen);
        if (equipoOrigen == null) {
            throw new EquipoException("Equipo origen no existe.");
        }
        
        // Validación 2
        Jugador jugador = equipoOrigen.getJugadores().get(numFederado);
        if (jugador == null) {
            throw new JugadorException("Jugador no encontrado.");
        }
        
        // Validación 3
        Equipo equipoDestino = this.equipos.get(nombreEquipoDestino);
        if (equipoDestino == null) {
            throw new EquipoException("Equipo destino no existe.");
        }
        
        // Si todo está bien, ejecutar la lógica:
        equipoOrigen.getJugadores().remove(numFederado);
        equipoDestino.getJugadores().put(numFederado, jugador);
        jugador.setEquipo(equipoDestino);
    }
    ```

### 9. Comprobación de Tipos y Casting (El 5% Final)

*   **Tu Tarea:** Tratar a objetos de una colección de manera diferente según su tipo real.
*   **La Receta de 2 Pasos:**
    1.  **La Pregunta con `instanceof`:** Pregunta si un objeto es de un tipo específico.
        ```
        if (asistenteActual instanceof Estudiante) {
            // ...
        }
        ```
    2.  **La Acción con el `cast`:** Si la respuesta es sí, convierte la referencia para acceder a los métodos/atributos de la subclase.
        ```
        if (asistenteActual instanceof Estudiante) {
            // Convertimos la referencia de Asistente a Estudiante
            Estudiante est = (Estudiante) asistenteActual;
            // Ahora podemos usar métodos que solo existen en Estudiante
            System.out.println("Universidad: " + est.getUniversidad());
        }
        ```

### 10. Algoritmo de Ordenación

*   **Tu Tarea:** Construir una lista ordenada a partir de una colección.
*   **El Método de Inserción Ordenada:**
    1.  Crea una lista de resultados vacía (ej: `LinkedList`).
    2.  Recorre la colección original.
    3.  Para cada elemento, busca con un `while` la posición correcta en la lista de resultados para mantener el orden.
    4.  Inserta el elemento en esa posición con `lista.add(posicion, elemento)`.
    5.  Devuelve la lista ordenada.
