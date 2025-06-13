# La Guía Maestra Definitiva de POO para el Examen

*Este documento es tu manual de consulta único. Contiene todo lo necesario para resolver cualquier ejercicio de tus exámenes, estructurado de lo más básico a lo más complejo. Se basa en el temario de tus exámenes, tus dudas y tus errores pasados.*

---

## NIVEL 1: LOS CIMIENTOS (Conceptos que debes dominar al 100%)

*Esta es la base. Omitir o fallar en estos puntos hace imposible resolver el resto del examen. Son los "puntos fáciles" que debes asegurar.*

### 1.1. Tipos de Datos Fundamentales

Antes de las clases, están los datos. Es crucial no cometer errores aquí.

| Tipo | Categoría | Descripción | Sintaxis y Ejemplo de Uso |
| :--- | :--- | :--- | :--- |
| `int` | **Primitivo** | Números enteros (ej: -1, 0, 5, 100). | `int edad = 25;` <br> `if (edad == 25)` |
| `double`| **Primitivo** | Números con decimales (ej: 1.99, 3.14). | `double precio = 9.99;` <br> `if (precio > 5.0)` |
| `boolean`| **Primitivo**| Valor de verdadero o falso. | `boolean disponible = true;`<br>`if (disponible)` |
| `String`| **Objeto** | Cadenas de texto. **¡CRÍTICO!** Al ser un objeto, **NO** se compara con `==`. | `String nombre = "Ana";` <br> `if (nombre.equals("Ana"))` |

> **Tu Error a Recordar:** En tus prácticas, has intentado comparar un `int` con `.equals()`. **Regla de oro:** Los tipos primitivos se comparan con `==`, `>` o `<`. Los objetos (como `String`) se comparan con el método `.equals()`[6].

### 1.2. Interpretación del Diagrama UML

El UML es tu mapa del tesoro. Te dice exactamente cómo es la estructura.

| Símbolo | Nombre | Significado y Cómo Pensarlo |
| :--- | :--- | :--- |
| `-` | **Private** | El atributo/método solo es visible dentro de su propia clase. |
| `+` | **Public** | Visible para cualquier clase. |
| `#` | **Protected** | Visible para la clase y sus subclases. |
| `───▷` | **Herencia** | "Es-un". La subclase hereda todo lo `public` y `protected` de la superclase. |
| `o───` | **Agregación** | "Tiene-un" (débil). La parte puede existir sin el todo. (Tu analogía: *la tortuga y el tortuguero*). |
| `◆───` | **Composición** | "Posee-un" (fuerte). La parte **NO** puede existir sin el todo. (Tu analogía: *el baño y la casa*). |
| ***Cursiva*** | **Abstracto** | **¡CLAVE!** Si una clase o método está en cursiva, es `abstract`[2][5]. No puedes hacer `new` de una clase abstracta, y estás **obligado** a implementar los métodos abstractos en las subclases. |

### 1.3. Las Colecciones: `List` y `Map`

Son los contenedores de datos. Saber cuál usar y cómo es vital.

#### **`List`: La Lista Ordenada**
*   **Concepto:** Una colección de objetos **ordenada** donde los elementos se acceden por su posición (índice) y **se permiten duplicados**.
*   **Implementaciones Comunes:**
    *   **`ArrayList`**: La más usada. Rápida para acceder a elementos (`.get(index)`). **Úsala por defecto si no tienes una razón para no hacerlo.**[3][4]
    *   **`LinkedList`**: Más rápida para añadir/quitar elementos en cualquier posición. Buena para algoritmos de ordenación manual[1][7].
*   **Sintaxis Esencial:**
    ```
    // Creación
    List<String> nombres = new ArrayList<>();
    List<Evento> listaOrdenada = new LinkedList<>();

    // Añadir un elemento al final
    nombres.add("Carlos"); // nombres: ["Carlos"]

    // Añadir un elemento en una posición específica
    nombres.add(0, "Ana"); // nombres: ["Ana", "Carlos"]

    // Obtener un elemento por su índice
    String primerNombre = nombres.get(0); // devuelve "Ana"

    // Obtener el tamaño de la lista
    int total = nombres.size(); // devuelve 2

    // Eliminar un elemento
    nombres.remove("Carlos"); // por objeto
    nombres.remove(0);      // por índice
    ```

#### **`Map`: El Diccionario Clave-Valor**
*   **Concepto:** Una colección de pares **clave-valor**. No tiene orden. Es extremadamente rápido para encontrar un valor si tienes su clave. **No permite claves duplicadas.**
*   **Implementación Común:**
    *   **`HashMap`**: La implementación estándar. Rápida y eficiente. **La única que necesitas para tus exámenes.**[2][7]
*   **Sintaxis Esencial:**
    ```
    // Creación (Clave: String, Valor: Jugador)
    Map<String, Jugador> jugadores = new HashMap<>();

    // Añadir un par clave-valor
    jugadores.put("J-10", nuevoJugador);

    // Obtener un valor usando su clave
    Jugador j = jugadores.get("J-10"); // Devuelve el objeto Jugador o null si no existe

    // Comprobar si una clave existe
    boolean existe = jugadores.containsKey("J-10"); // devuelve true

    // Eliminar un par por su clave
    jugadores.remove("J-10");

    // Recorrer las CLAVES
    for (String id : jugadores.keySet()) { /* ... */ }

    // Recorrer los VALORES (¡muy común en tus exámenes!)
    for (Jugador jugador : jugadores.values()) { /* ... */ }
    ```
> **Tu Error a Recordar:** Has intentado iterar sobre un `Map` como si fuera una `List` (`for (Jugador j : mapa)`). **Esto no funciona.** Debes usar `.values()` o `.keySet()`[4].

### 1.4. Constructores

*   **Tu Tarea:** Dar vida a los objetos, inicializando **todos** sus atributos.
*   **La Receta Infalible:**
    1.  El constructor es `public` y tiene el mismo nombre que la clase.
    2.  Usa `this.atributo = parametro;` para asignar los valores recibidos.
    3.  **¡EL PASO MÁS IMPORTANTE!** Las colecciones (`Map`, `List`) **DEBEN** ser inicializadas con `new`.
        ```
        public Controlador() {
            // Este ha sido uno de tus errores recurrentes. ¡No lo olvides!
            this.equipos = new HashMap<>(); 
            this.partidos = new ArrayList<>(); 
        }
        ```
    4.  **Herencia (`super()`):** Si estás en una subclase, la **primera línea** de tu constructor debe ser `super(...)` para llamar al constructor de la clase padre[1].

---

## NIVEL 2: EL NÚCLEO DEL EXAMEN (Aquí se decide el aprobado)

*Estos son los algoritmos y patrones que aparecen en las preguntas de mitad de examen, las que valen más puntos.*

### 2.1. Herencia y Polimorfismo (`extends` y `@Override`)

*   **Tu Tarea:** Implementar la funcionalidad que varía entre subclases.
*   **Reglas de Oro:**
    1.  **`extends` es la clave:** La herencia no existe sin `public class Estudiante extends Asistente`. **Omitir esto fue uno de tus errores conceptuales más graves.**[1]
    2.  **`@Override` es obligatorio:** Usa **SIEMPRE** la anotación `@Override` cuando implementes un método de una superclase[5]. Es tu seguro contra errores y un requisito conceptual.
    
### 2.2. El Algoritmo de Búsqueda y Filtro (¡El más repetido!)

*   **Tu Tarea:** Encontrar elementos en una colección que cumplen una condición.
*   **La Receta:**
    ```
    public Estacion getEstacionPorNombre(String nombre) {
        // 1. Crear la lista vacía de resultados
        List<Estacion> encontrados = new ArrayList<>();
        
        // 2. Recorrer la colección principal
        for (Estacion estacion : this.linea.getEstaciones()) {
            
            // 3. Aplicar la condición
            if (estacion.getNombre().equals(nombre)) { // para Strings, .equals()
                
                // 4. Si se cumple, añadir a la lista de resultados
                encontrados.add(estacion);
            }
        }
        
        // 5. Devolver la lista (puede estar vacía)
        // ¡NUNCA pongas un 'else { return null; }' dentro del bucle!
        // Este ha sido uno de tus errores lógicos más importantes.
        return encontrados;
    }
    ```

### 2.3. El Algoritmo de Agregación (Construir un Resumen)

*   **Tu Tarea:** Recorrer una colección para construir una nueva (casi siempre un `Map`) que resume información[7].
*   **La Receta (Ej: contar tareas por estado):**
    ```
    public Map<String, Integer> getTareasPorEstado() {
        // 1. Crear el mapa de resultados
        Map<String, Integer> conteo = new HashMap<>();

        // 2. Recorrer la colección principal
        for (Tarea tarea : this.tareas.values()) {
            String estado = tarea.getEstado();
            
            // 3. Si el estado ya está en el mapa, incrementa su valor
            if (conteo.containsKey(estado)) {
                conteo.put(estado, conteo.get(estado) + 1);
            } else { // 4. Si no, añádelo con valor inicial 1
                conteo.put(estado, 1);
            }
            // Versión corta con getOrDefault:
            // conteo.put(estado, conteo.getOrDefault(estado, 0) + 1);
        }
        return conteo;
    }
    ```

---

## NIVEL 3: LÓGICA AVANZADA Y TEMAS FINALES

*Estas son las preguntas finales, las más complejas. Combinan todo lo anterior.*

### 3.1. Gestión de Errores con Excepciones

*   **Tu Tarea:** Manejar situaciones anómalas sin que el programa se caiga.
*   **Los 4 Componentes Clave (tu duda sobre `throw` vs. `throws`):**
    1.  **Crear tu propia excepción:** Una clase que hereda de `Exception`[5].
        ```
        public class TareaException extends Exception {
            public TareaException(String mensaje) { super(mensaje); }
        }
        ```
    2.  **`throw`: Lanzar la excepción.** Es la acción, va **dentro** del método[1].
        ```
        if (tarea == null) { throw new TareaException("La tarea no existe."); }
        ```
    3.  **`throws`: Avisar en la firma.** Es la advertencia, va en la **declaración** del método. Es obligatorio para excepciones "checked" (las que heredan de `Exception`)[3].
        ```
        public void miMetodo() throws TareaException { /* ... */ }
        ```
    4.  **`try-catch`: Capturar y manejar.**[5]
        ```
        try { miControlador.asignarTarea("T-01"); } 
        catch (TareaException e) { System.out.println("Error: " + e.getMessage()); }
        ```

### 3.2. Lógica de Negocio Secuencial

*   **Tu Tarea:** Implementar un método que realiza validaciones en orden. Si una falla, lanza excepción. Si todo pasa, modifica el estado[4][7].
*   **La Estructura (Patrón de Búsqueda Directa + Validación):**
    ```
    public void traspasarJugador(...) throws ... {
        // Validación 1: Busca directamente, no con un bucle.
        Equipo equipoOrigen = this.equipos.get(nombreEquipoOrigen);
        if (equipoOrigen == null) {
            throw new EquipoException("Equipo origen no existe.");
        }
        
        // Validación 2: Usa el resultado anterior para la siguiente búsqueda.
        Jugador jugador = equipoOrigen.getJugadores().get(numFederado);
        if (jugador == null) {
            throw new JugadorException("Jugador no encontrado.");
        }
        
        // ... más validaciones ...
        
        // Si todo está bien, ejecutar la lógica:
        equipoOrigen.getJugadores().remove(numFederado);
        equipoDestino.getJugadores().put(numFederado, jugador);
        jugador.setEquipo(equipoDestino);
    }
    ```

### 3.3. Comprobación de Tipos y Casting (El 5% Final)

*   **Tu Tarea:** Tratar a objetos de una colección de manera diferente según su tipo real[6][7].
*   **La Receta de 2 Pasos:**
    1.  **La Pregunta con `instanceof`:** Pregunta si un objeto es de un tipo específico.
        ```
        if (asistenteActual instanceof Estudiante) { /* ... */ }
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

### 3.4. Algoritmo de Ordenación

*   **Tu Tarea:** Construir una lista ordenada a partir de una colección.
*   **El Método de Inserción Ordenada:**
    1.  Crea una lista de resultados vacía (ej: `LinkedList`).
    2.  Recorre la colección original.
    3.  Para cada elemento, busca con un `while` la posición correcta en la lista de resultados para mantener el orden.
    4.  Inserta el elemento en esa posición con `lista.add(posicion, elemento)`.
    5.  Devuelve la lista ordenada[1][7].
    
    ```
    public List<Evento> getEventosOrdenadosPorPresentaciones() {
        List<Evento> ordenados = new LinkedList<>();
        for (Evento eventoAInsertar : this.eventos.values()) {
            int pos = 0;
            // Busca la posición correcta para mantener el orden decreciente
            while (pos < ordenados.size() && 
                   eventoAInsertar.getPresentaciones().size() < ordenados.get(pos).getPresentaciones().size()) {
                pos++;
            }
            ordenados.add(pos, eventoAInsertar);
        }
        return ordenados;
    }
    ```
