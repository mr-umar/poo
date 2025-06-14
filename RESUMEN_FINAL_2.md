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
```
List<String> nombres = new ArrayList<>();
List<Evento> eventos = new LinkedList<>();
```

---

## 2. Mapas (`Map<K,V>`)
*Implementaciones comunes: `HashMap`, `LinkedHashMap`*

| Método                       | Descripción                       | Ejemplo                                  |
|------------------------------|-----------------------------------|------------------------------------------|
| `put(clave, valor)`          | Añade/actualiza entrada           | `map.put("id-01", new Evento());`        |
| `get(clave)`                 | Obtiene valor por clave           | `Evento e = map.get("id-01");`           |
| `containsKey(clave)`         | ¿Existe clave?                    | `map.containsKey("id-01")`               |
| `containsValue(valor)`       | ¿Existe valor?                    | `map.containsValue(evento)`              |
| `remove(clave)`              | Elimina por clave                 | `map.remove("id-01");`                   |
| `keySet()`                   | Conjunto de claves                | `for (String c : map.keySet()) {...}`    |
| `values()`                   | Colección de valores              | `for (Evento e : map.values()) {...}`    |
| `entrySet()`                 | Pares clave-valor                 | `for (Map.Entry<String,Evento> entrada : map.entrySet()) {...}` |

**Ejemplo de creación:**
```
Map<String, Evento> eventos = new HashMap<>();
```

---

## 3. Strings (`String`)

| Método                       | Descripción                       | Ejemplo                                  |
|------------------------------|-----------------------------------|------------------------------------------|
| `equals(otroString)`         | Compara contenido                 | `s1.equals(s2)`                          |
| `length()`                   | Longitud                          | `int len = s.length();`                  |
| `substring(inicio, fin)`     | Subcadena                         | `s.substring(0, 3);`                     |
| `charAt(indice)`             | Carácter en posición              | `char c = s.charAt(0);`                  |
| `indexOf(sub)`               | Posición de subcadena             | `int pos = s.indexOf("Hola");`           |
| `toLowerCase()` / `toUpperCase()` | Minúsculas/Mayúsculas        | `s.toLowerCase();`                       |
| `split(regex)`               | Divide en array                   | `String[] partes = s.split(",");`        |

---

## 4. Inicialización de Colecciones en Constructores

**Error común:** Olvidar inicializar colecciones.

```
public class Controlador {
    private Map<String, Evento> eventos;
    public Controlador() {
        eventos = new HashMap<>(); // Siempre inicializar
    }
}
```

---

## 5. Iteración sobre Colecciones

| Estructura         | Ejemplo de Iteración                                       |
|--------------------|-----------------------------------------------------------|
| **Listas**         | `for (Evento e : listaEventos) {...}`                     |
| **Mapas (claves)** | `for (String clave : map.keySet()) {...}`                 |
| **Mapas (valores)**| `for (Evento e : map.values()) {...}`                     |
| **Mapas (pares)**  | `for (Map.Entry<String,Evento> entry : map.entrySet()) {...}` |

---

## 6. Conversiones Comunes

| De             | A             | Método                                   |
|----------------|---------------|------------------------------------------|
| `List` → Array | `toArray()`   | `Evento[] array = lista.toArray(new Evento[0]);` |
| Array → `List` | `Arrays.asList()` | `List<Evento> lista = Arrays.asList(array);`   |

---

## 7. Errores Frecuentes en Exámenes

- **No inicializar colecciones** en el constructor.
- **Comparar Strings con `==`** en vez de `.equals()`.
- **Confundir `add()` y `put()`** (`add()` es de listas, `put()` de mapas).
- **Usar `.length` en listas** (debe ser `.size()`).
- **Índices fuera de rango** en listas.

---

## 8. Plantillas para Algoritmos Clave

### Búsqueda en Lista
```
public Evento buscarPorNombre(String nombre) {
    for (Evento evento : listaEventos) {
        if (evento.getNombre().equals(nombre)) {
            return evento;
        }
    }
    return null;
}
```

### Agregación con Map
```
public Map<String, Integer> contarEventosPorFecha() {
    Map<String, Integer> conteo = new HashMap<>();
    for (Evento evento : eventos) {
        String fecha = evento.getFecha();
        conteo.put(fecha, conteo.getOrDefault(fecha, 0) + 1);
    }
    return conteo;
}
```

---

## 9. Ejemplo de Uso Correcto de Métodos

```
List<String> nombres = new ArrayList<>();
nombres.add("Ana");
nombres.add("Luis");
if (nombres.contains("Ana")) {
    nombres.remove("Ana");
}
for (String nombre : nombres) {
    System.out.println(nombre.toUpperCase());
}

Map<String, Integer> edades = new HashMap<>();
edades.put("Ana", 20);
edades.put("Luis", 25);
for (String nombre : edades.keySet()) {
    System.out.println(nombre + ": " + edades.get(nombre));
}
```

---
