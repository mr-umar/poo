## Tabla genérica para trasladar UML a atributos Java en exámenes POO

Esta tabla te sirve para **cualquier examen de POO** donde debas declarar los atributos de las clases (incluyendo relaciones y multiplicidades) a partir de un diagrama UML. Usa esta tabla como checklist y guía visual para no olvidar ningún atributo ni relación.

---

| Clase         | Atributos propios (del rectángulo UML)                  | Relaciones (atributos de asociación)                                           | Multiplicidad UML           | Tipo Java recomendado                | Notas clave                                                                                       |
|---------------|---------------------------------------------------------|--------------------------------------------------------------------------------|-----------------------------|--------------------------------------|---------------------------------------------------------------------------------------------------|
| **ClaseA**    | `private Tipo atributo;`                                | `private ClaseB ref;`<br>`private List<ClaseC> lista;`<br>`private Map<Clave,ClaseD> mapa;` | 0..1, 1, * (según UML)      | Referencia simple, List, Map         | Si la relación es 0..1 o 1: referencia simple. Si es * o 1..*: colección (List/Map).             |
| **ClaseB**    | ...                                                     | ...                                                                            | ...                         | ...                                  | ...                                                                                               |

---

### **Cómo interpretar y trasladar el UML a Java**

- **Atributos propios:**  
  - Son los que aparecen dentro del rectángulo de la clase en el UML.
  - Decláralos con el tipo y nombre indicados.

- **Relaciones (líneas entre clases):**
  - **Multiplicidad 1:**  
    - `private ClaseX x;`
  - **Multiplicidad 0..1:**  
    - `private ClaseX x; // Puede ser null`
  - **Multiplicidad *, 1..*, 0..*:**
    - `private List<ClaseX> xs;`
  - **Multiplicidad 2:**  
    - `private ClaseX[] xs; // Array de tamaño 2`
  - **Relación con clave única:**  
    - `private Map<Clave,ClaseX> xs; // Clave según UML (ej: nombre, id, etc.)`

- **Herencia:**  
  - Si hay flecha de herencia, usa `extends` en Java.
    - `public class Subclase extends Superclase { ... }`

- **Constantes y atributos estáticos:**  
  - Si el UML indica constantes o atributos subrayados, usa `public static final` o `private static`.

- **Visibilidad:**  
  - Usa `private` para atributos salvo que el UML indique otra cosa o sea necesario para herencia (`protected`).

---

### **Ejemplo genérico de declaración de atributos en Java**

