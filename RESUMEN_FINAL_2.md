# Resumen Definitivo de Métodos y Estructuras Clave en Java para Exámenes

---

## 1. Listas (`List<T>`)
*Implementaciones comunes: `ArrayList`, `LinkedList`*

| Método                       | Descripción                       | Ejemplo                                 |
|------------------------------|-----------------------------------|-----------------------------------------|
| `add(elemento)`              | Añade al final                    | `lista.add("Hola");`                    |
| `add(pos, elemento)`         | Inserta en posición               | `lista.add(0, "Primero");`              |
| `get(indice)`                | Obtiene por posición              | `String s = lista.get(0);`              |
| `size()`                     | Número de elementos               | `int total = lista.size();`             |
| `remove(indice)`             | Elimina por posición              | `lista.remove(0);`                      |
| `remove(elemento)`           | Elimina por objeto                | `lista.remove("Hola");`                 |
| `contains(elemento)`         | Comprueba existencia              | `lista.contains("Hola")`                |
| `clear()`                    | Vacía la lista                    | `lista.clear();`                        |
| `isEmpty()`                  | ¿Está vacía?                      | `lista.isEmpty()`                       |

**Ejemplo de creación:**
