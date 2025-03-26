# Programación Orientada a Objetos en Java: Guía Completa


## Clases y objetos en Java

Una clase en Java es una plantilla o molde que define las características y comportamientos que tendrán los objetos creados a partir de ella. Cada clase representa un concepto o entidad del mundo real que queremos modelar en nuestro programa.

### Estructura básica de una clase

```java
// Importación de librerías necesarias
import java.util.ArrayList;
import java.util.List;

// Definición de la clase
public class Persona {
    // Atributos (variables de instancia)
    private String nombre;
    private int edad;
    private String dni;
    
    // Constructor
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    
    // Métodos
    public void saludar() {
        System.out.println("Hola, me llamo " + nombre);
    }
    
    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
}
```


### Creación de objetos

Un objeto es una instancia de una clase. Se crea utilizando el operador `new` seguido del constructor de la clase:

```java
public class Main {
    public static void main(String[] args) {
        // Creación de un objeto Persona
        Persona persona1 = new Persona("Juan", 25, "12345678A");
        
        // Uso de métodos del objeto
        persona1.saludar();
        
        // Acceso a atributos mediante getters
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Edad: " + persona1.getEdad());
        
        // Modificación de atributos mediante setters
        persona1.setEdad(26);
        System.out.println("Nueva edad: " + persona1.getEdad());
    }
}
```


## Atributos y métodos

### Atributos

Los atributos son variables que pertenecen a la clase y representan las características o propiedades de los objetos. Se declaran al principio de la clase.

#### Tipos de atributos:

1. **Atributos de instancia**: Cada objeto tiene su propia copia de estos atributos.
2. **Atributos de clase (static)**: Son compartidos por todos los objetos de la clase.
```java
public class Cuenta {
    // Atributos de instancia
    private String titular;
    private double saldo;
    
    // Atributo de clase (static)
    private static double tasaInteres = 0.05;
    
    // Constructor
    public Cuenta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    // Getters y setters para atributos de instancia
    public String getTitular() {
        return titular;
    }
    
    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    // Getters y setters para atributos de clase
    public static double getTasaInteres() {
        return tasaInteres;
    }
    
    public static void setTasaInteres(double nuevaTasa) {
        tasaInteres = nuevaTasa;
    }
}
```


### Métodos

Los métodos son funciones asociadas a la clase que definen el comportamiento de los objetos. Pueden acceder y modificar los atributos de la clase.

#### Tipos de métodos:

1. **Métodos de instancia**: Operan sobre un objeto específico.
2. **Métodos de clase (static)**: No necesitan un objeto para ser invocados.
```java
public class Calculadora {
    // Atributo de instancia
    private double memoria;
    
    // Constructor
    public Calculadora() {
        this.memoria = 0;
    }
    
    // Métodos de instancia
    public void sumar(double valor) {
        memoria += valor;
    }
    
    public void restar(double valor) {
        memoria -= valor;
    }
    
    public double getMemoria() {
        return memoria;
    }
    
    // Métodos de clase (static)
    public static double sumarNumeros(double a, double b) {
        return a + b;
    }
    
    public static double multiplicarNumeros(double a, double b) {
        return a * b;
    }
}
```

Ejemplo de uso:

```java
public class Main {
    public static void main(String[] args) {
        // Uso de métodos de instancia
        Calculadora calc = new Calculadora();
        calc.sumar(10);
        calc.sumar(5);
        System.out.println("Memoria: " + calc.getMemoria()); // Imprime 15
        
        // Uso de métodos de clase (static)
        double resultado = Calculadora.sumarNumeros(3, 4);
        System.out.println("Suma: " + resultado); // Imprime 7
        
        double producto = Calculadora.multiplicarNumeros(2, 5);
        System.out.println("Producto: " + producto); // Imprime 10
    }
}
```


## Constructores

Los constructores son métodos especiales que se utilizan para inicializar objetos. Tienen el mismo nombre que la clase y no tienen tipo de retorno.

### Características de los constructores:

1. Se llaman automáticamente cuando se crea un objeto con `new`.
2. Inicializan los atributos del objeto.
3. Una clase puede tener múltiples constructores (sobrecarga).
4. Si no se define ningún constructor, Java proporciona uno por defecto sin parámetros.
```java
public class Rectangulo {
    private double ancho;
    private double alto;
    
    // Constructor por defecto
    public Rectangulo() {
        this.ancho = 1.0;
        this.alto = 1.0;
    }
    
    // Constructor con parámetros
    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
    
    // Constructor que crea un cuadrado
    public Rectangulo(double lado) {
        this.ancho = lado;
        this.alto = lado;
    }
    
    // Constructor de copia
    public Rectangulo(Rectangulo otroRectangulo) {
        this.ancho = otroRectangulo.ancho;
        this.alto = otroRectangulo.alto;
    }
    
    // Método para calcular el área
    public double calcularArea() {
        return ancho * alto;
    }
    
    // Getters y setters
    public double getAncho() {
        return ancho;
    }
    
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    
    public double getAlto() {
        return alto;
    }
    
    public void setAlto(double alto) {
        this.alto = alto;
    }
}
```

Ejemplo de uso:

```java
public class Main {
    public static void main(String[] args) {
        // Uso de diferentes constructores
        Rectangulo r1 = new Rectangulo(); // Constructor por defecto
        System.out.println("Área de r1: " + r1.calcularArea()); // 1.0
        
        Rectangulo r2 = new Rectangulo(5.0, 3.0); // Constructor con parámetros
        System.out.println("Área de r2: " + r2.calcularArea()); // 15.0
        
        Rectangulo r3 = new Rectangulo(4.0); // Constructor para cuadrado
        System.out.println("Área de r3: " + r3.calcularArea()); // 16.0
        
        Rectangulo r4 = new Rectangulo(r2); // Constructor de copia
        System.out.println("Área de r4: " + r4.calcularArea()); // 15.0
    }
}
```


### Uso de `this()` para llamar a otros constructores

El operador `this()` permite llamar a otro constructor de la misma clase desde un constructor:

```java
public class Empleado {
    private String nombre;
    private double salario;
    private String departamento;
    
    // Constructor completo
    public Empleado(String nombre, double salario, String departamento) {
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }
    
    // Constructor que llama al constructor completo
    public Empleado(String nombre, double salario) {
        this(nombre, salario, "General"); // Llama al constructor completo
    }
    
    // Constructor que llama al constructor anterior
    public Empleado(String nombre) {
        this(nombre, 1000.0); // Llama al segundo constructor
    }
    
    // Constructor por defecto
    public Empleado() {
        this("Sin nombre"); // Llama al tercer constructor
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public String getDepartamento() {
        return departamento;
    }
}
```


## Encapsulación de datos

La encapsulación es uno de los principios fundamentales de la POO que consiste en ocultar los detalles internos de una clase y proporcionar una interfaz pública para interactuar con ella.

### Modificadores de acceso

Java proporciona cuatro niveles de control de acceso:

1. **private**: Solo accesible dentro de la misma clase.
2. **default** (sin modificador): Accesible dentro del mismo paquete.
3. **protected**: Accesible dentro del mismo paquete y subclases.
4. **public**: Accesible desde cualquier parte del programa.
```java
package com.ejemplo.banco;

public class CuentaBancaria {
    // Atributos privados
    private String numeroCuenta;
    private double saldo;
    private String titular;
    
    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    // Métodos públicos (interfaz)
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Error: La cantidad debe ser positiva");
        }
    }
    
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Error: Cantidad inválida o saldo insuficiente");
        }
    }
    
    // Métodos de acceso (getters)
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public String getTitular() {
        return titular;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    // Método protegido (accesible por subclases)
    protected void actualizarSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }
    
    // Método con acceso por defecto (package)
    void imprimirDetalles() {
        System.out.println("Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }
}
```

Ejemplo de uso:

```java
package com.ejemplo.aplicacion;

import com.ejemplo.banco.CuentaBancaria;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("123456789", "Juan Pérez", 1000.0);
        
        // Acceso a métodos públicos
        System.out.println("Saldo inicial: " + cuenta.getSaldo());
        cuenta.depositar(500.0);
        cuenta.retirar(200.0);
        
        // Acceso a atributos a través de getters
        System.out.println("Titular: " + cuenta.getTitular());
        
        // Estos accesos generarían errores de compilación:
        // cuenta.saldo = 5000.0; // Error: saldo es private
        // cuenta.imprimirDetalles(); // Error: imprimirDetalles tiene acceso package
        // cuenta.actualizarSaldo(5000.0); // Error: actualizarSaldo es protected
    }
}
```


## Atributos de clase y constantes

### Atributos de clase (static)

Los atributos de clase se comparten entre todas las instancias de una clase. Se declaran con la palabra clave `static`:

```java
public class Contador {
    // Atributo de clase (compartido por todos los objetos)
    private static int contador = 0;
    
    // Atributo de instancia (cada objeto tiene su propia copia)
    private int id;
    
    // Constructor
    public Contador() {
        contador++;
        this.id = contador;
    }
    
    // Getter para el atributo de instancia
    public int getId() {
        return id;
    }
    
    // Getter para el atributo de clase
    public static int getContador() {
        return contador;
    }
}
```

Ejemplo de uso:

```java
public class Main {
    public static void main(String[] args) {
        // Creamos varios objetos
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();
        
        // Cada objeto tiene su propio id
        System.out.println("ID de c1: " + c1.getId()); // 1
        System.out.println("ID de c2: " + c2.getId()); // 2
        System.out.println("ID de c3: " + c3.getId()); // 3
        
        // Pero todos comparten el mismo contador
        System.out.println("Contador total: " + Contador.getContador()); // 3
    }
}
```


### Constantes

Las constantes son valores que no pueden cambiar después de su inicialización. Se declaran con las palabras clave `static final`:

```java
public class Matematicas {
    // Constantes
    public static final double PI = 3.14159265359;
    public static final double E = 2.71828182846;
    
    // Métodos que utilizan las constantes
    public static double calcularAreaCirculo(double radio) {
        return PI * radio * radio;
    }
    
    public static double calcularPerimetroCirculo(double radio) {
        return 2 * PI * radio;
    }
}
```

Ejemplo de uso:

```java
public class Main {
    public static void main(String[] args) {
        // Uso de constantes
        System.out.println("Valor de PI: " + Matematicas.PI);
        
        // Uso de métodos que utilizan constantes
        double radio = 5.0;
        System.out.println("Área del círculo: " + Matematicas.calcularAreaCirculo(radio));
        System.out.println("Perímetro del círculo: " + Matematicas.calcularPerimetroCirculo(radio));
    }
}
```


## Lenguaje Unificado de Modelado: Diagramas de clase

UML (Unified Modeling Language) es un lenguaje gráfico para visualizar, especificar, construir y documentar un sistema de software. Los diagramas de clase son uno de los tipos más importantes de diagramas UML.

### Elementos de un diagrama de clase UML

1. **Clase**: Representada por un rectángulo dividido en tres secciones:
    - Nombre de la clase
    - Atributos
    - Métodos
2. **Visibilidad**:
    - `+` : public
    - `-` : private
    - `#` : protected
    - `~` : package (default)
3. **Relaciones**:
    - **Asociación**: Una clase usa objetos de otra clase.
    - **Agregación**: Una clase contiene objetos de otra clase, pero estos pueden existir independientemente.
    - **Composición**: Una clase contiene objetos de otra clase, y estos no pueden existir independientemente.
    - **Herencia**: Una clase hereda de otra clase.
    - **Implementación**: Una clase implementa una interfaz.

### Ejemplo de diagrama de clase UML

```
+------------------------+
|        Persona         |
+------------------------+
| - nombre: String       |
| - edad: int            |
| - dni: String          |
+------------------------+
| + Persona(nombre, edad, dni) |
| + getNombre(): String  |
| + setNombre(nombre: String): void |
| + getEdad(): int       |
| + setEdad(edad: int): void |
| + getDni(): String     |
| + setDni(dni: String): void |
+------------------------+
```


### Representación de relaciones en UML

#### Asociación

```
+----------------+       +----------------+
|     Profesor   | 1   * |   Estudiante   |
+----------------+-------+----------------+
| - nombre       |       | - nombre       |
+----------------+       +----------------+
| + enseñar()    |       | + estudiar()   |
+----------------+       +----------------+
```

Un profesor puede enseñar a muchos estudiantes, y un estudiante puede ser enseñado por un profesor.

#### Agregación

```
+----------------+       +----------------+
|   Universidad  |<>-----| Departamento   |
+----------------+       +----------------+
| - nombre       |       | - nombre       |
+----------------+       +----------------+
| + getNombre()  |       | + getNombre()  |
+----------------+       +----------------+
```

Una universidad tiene departamentos, pero los departamentos pueden existir sin la universidad.

#### Composición

```
+----------------+       +----------------+
|      Coche     |<>-----| Motor          |
+----------------+       +----------------+
| - marca: String|       | - cilindrada   |
| - modelo: String|      | - potencia     |
+----------------+       +----------------+
| + arrancar()   |       | + encender()   |
+----------------+       +----------------+
```

Un coche tiene un motor, y el motor no puede existir sin el coche (cuando el coche se destruye, el motor también)[^3][^6].

La composición es un tipo específico de relación donde una clase contiene objetos de otra clase, y estos objetos no pueden existir independientemente de la clase contenedora[^3]. En la composición, existe una fuerte dependencia entre los objetos, de modo que cuando el objeto principal (contenedor) es destruido, también se destruyen los objetos que lo componen[^3][^6].

### Diferencias entre Agregación y Composición

La agregación y la composición son dos tipos de asociaciones entre clases que representan relaciones "tiene un", pero con diferentes niveles de dependencia:


| Agregación | Composición |
| :-- | :-- |
| Relación "débil" | Relación "fuerte" |
| Los objetos pueden existir independientemente | Los objetos no pueden existir sin su contenedor |
| Eliminar un elemento no afecta al otro | Eliminar el contenedor elimina también sus componentes |
| Se representa con un diamante vacío | Se representa con un diamante lleno |

## Excepciones

Las excepciones son eventos que ocurren durante la ejecución del programa y alteran el flujo normal de las instrucciones. Java proporciona un mecanismo robusto para manejar excepciones.

### Jerarquía de excepciones

En Java, todas las excepciones son subclases de la clase `Throwable`. Esta clase tiene dos subclases principales:

1. **Error**: Representa errores graves que generalmente no deberían ser capturados por la aplicación (como `OutOfMemoryError`).
2. **Exception**: Representa condiciones excepcionales que los programas pueden querer manejar.
    - **RuntimeException**: Excepciones que ocurren durante la ejecución normal del programa (como `NullPointerException`).
    - **Otras excepciones**: Excepciones comprobadas que deben ser declaradas o capturadas (como `IOException`).
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManejoExcepciones {
    public static void main(String[] args) {
        // Ejemplo 1: Try-catch simple
        try {
            int resultado = 10 / 0; // Esto lanzará una ArithmeticException
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
        
        // Ejemplo 2: Try-catch con múltiples catch
        try {
            int[] numeros = {1, 2, 3};
            System.out.println(numeros[^5]); // Esto lanzará ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error de índice: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
        
        // Ejemplo 3: Try-catch-finally
        FileReader fr = null;
        try {
            fr = new FileReader(new File("archivo.txt")); // Puede lanzar FileNotFoundException
            int caracter = fr.read(); // Puede lanzar IOException
            while (caracter != -1) {
                System.out.print((char) caracter);
                caracter = fr.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } finally {
            // El bloque finally siempre se ejecuta, haya o no excepción
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
        
        // Ejemplo 4: Try-with-resources (Java 7+)
        try (FileReader fr2 = new FileReader("archivo.txt")) {
            int caracter = fr2.read();
            while (caracter != -1) {
                System.out.print((char) caracter);
                caracter = fr2.read();
            }
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
        
        // Ejemplo 5: Lanzar excepciones
        try {
            validarEdad(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
        
        // Ejemplo 6: Excepciones personalizadas
        try {
            verificarSaldo(100, 200);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error de saldo: " + e.getMessage());
        }
    }
    
    // Método que lanza una excepción
    public static void validarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        System.out.println("Edad válida: " + edad);
    }
    
    // Método que lanza una excepción personalizada
    public static void verificarSaldo(double saldo, double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo actual: " + saldo);
        }
        System.out.println("Operación realizada con éxito");
    }
}

// Definición de una excepción personalizada
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
```


### Tipos de excepciones

1. **Excepciones comprobadas (checked)**: Son excepciones que el compilador obliga a manejar, ya sea capturándolas con un bloque try-catch o declarándolas en la firma del método con throws.
2. **Excepciones no comprobadas (unchecked)**: Son excepciones que el compilador no obliga a manejar. Incluyen las subclases de RuntimeException.
```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TiposExcepciones {
    // Método que declara una excepción comprobada
    public static void leerArchivo(String ruta) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(ruta);
        int dato = fis.read();
        fis.close();
    }
    
    // Método que maneja una excepción comprobada
    public static void leerArchivoSeguro(String ruta) {
        try {
            FileInputStream fis = new FileInputStream(ruta);
            int dato = fis.read();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    // Método que lanza una excepción no comprobada
    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero");
        }
        return a / b;
    }
}
```


## Contenedores

Los contenedores (o colecciones) en Java son clases que permiten almacenar y manipular grupos de objetos. El framework de colecciones de Java proporciona interfaces y clases para implementar diferentes tipos de estructuras de datos.

### Jerarquía de colecciones

Las principales interfaces del framework de colecciones son:

1. **Collection**: Raíz de la jerarquía de colecciones.
    - **List**: Colección ordenada que permite elementos duplicados.
    - **Set**: Colección que no permite elementos duplicados.
    - **Queue**: Colección que representa una cola (FIFO).
2. **Map**: Colección de pares clave-valor, donde las claves son únicas.

### Implementaciones comunes

#### List

- **ArrayList**: Implementación basada en arrays. Acceso rápido por índice, pero inserción/eliminación más lenta.
- **LinkedList**: Implementación basada en listas enlazadas. Inserción/eliminación rápida, pero acceso más lento.

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class EjemploList {
    public static void main(String[] args) {
        // ArrayList
        List<String> listaArray = new ArrayList<>();
        
        // Añadir elementos
        listaArray.add("Manzana");
        listaArray.add("Banana");
        listaArray.add("Cereza");
        
        // Acceder a elementos
        System.out.println("Elemento en posición 1: " + listaArray.get(1));
        
        // Modificar elementos
        listaArray.set(1, "Pera");
        
        // Eliminar elementos
        listaArray.remove("Cereza");
        
        // Recorrer la lista con for-each
        System.out.println("Elementos de ArrayList:");
        for (String fruta : listaArray) {
            System.out.println(fruta);
        }
        
        // LinkedList
        List<Integer> listaEnlazada = new LinkedList<>();
        
        // Añadir elementos
        listaEnlazada.add(10);
        listaEnlazada.add(20);
        listaEnlazada.add(30);
        
        // Añadir al principio (operación eficiente en LinkedList)
        ((LinkedList<Integer>) listaEnlazada).addFirst(5);
        
        // Añadir al final (operación eficiente en LinkedList)
        ((LinkedList<Integer>) listaEnlazada).addLast(40);
        
        // Recorrer la lista con Iterator
        System.out.println("Elementos de LinkedList:");
        Iterator<Integer> iterador = listaEnlazada.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }
}
```


#### Set

- **HashSet**: Implementación basada en tablas hash. No garantiza orden.
- **TreeSet**: Implementación basada en árboles. Mantiene los elementos ordenados.
- **LinkedHashSet**: Mantiene el orden de inserción.

```java
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class EjemploSet {
    public static void main(String[] args) {
        // HashSet
        Set<String> hashSet = new HashSet<>();
        
        // Añadir elementos
        hashSet.add("Perro");
        hashSet.add("Gato");
        hashSet.add("Pájaro");
        hashSet.add("Perro"); // No se añade (duplicado)
        
        // Recorrer el conjunto
        System.out.println("Elementos de HashSet:");
        for (String animal : hashSet) {
            System.out.println(animal); // Orden no garantizado
        }
        
        // TreeSet
        Set<String> treeSet = new TreeSet<>();
        
        // Añadir elementos
        treeSet.add("Naranja");
        treeSet.add("Manzana");
        treeSet.add("Plátano");
        
        // Recorrer el conjunto
        System.out.println("Elementos de TreeSet:");
        for (String fruta : treeSet) {
            System.out.println(fruta); // Orden alfabético
        }
        
        // LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();
        
        // Añadir elementos
        linkedHashSet.add("Primero");
        linkedHashSet.add("Segundo");
        linkedHashSet.add("Tercero");
        
        // Recorrer el conjunto
        System.out.println("Elementos de LinkedHashSet:");
        for (String elemento : linkedHashSet) {
            System.out.println(elemento); // Orden de inserción
        }
    }
}
```


#### Map

- **HashMap**: Implementación basada en tablas hash. No garantiza orden.
- **TreeMap**: Implementación basada en árboles. Mantiene las claves ordenadas.
- **LinkedHashMap**: Mantiene el orden de inserción.

```java
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class EjemploMap {
    public static void main(String[] args) {
        // HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        
        // Añadir elementos
        hashMap.put("Juan", 25);
        hashMap.put("María", 30);
        hashMap.put("Pedro", 22);
        
        // Acceder a un valor
        System.out.println("Edad de María: " + hashMap.get("María"));
        
        // Verificar si existe una clave
        if (hashMap.containsKey("Juan")) {
            System.out.println("Juan está en el mapa");
        }
        
        // Recorrer el mapa
        System.out.println("Elementos de HashMap:");
        for (Map.Entry<String, Integer> entrada : hashMap.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
        
        // TreeMap
        Map<String, String> treeMap = new TreeMap<>();
        
        // Añadir elementos
        treeMap.put("ES", "España");
        treeMap.put("UK", "Reino Unido");
        treeMap.put("FR", "Francia");
        
        // Recorrer el mapa
        System.out.println("Elementos de TreeMap:");
        for (Map.Entry<String, String> entrada : treeMap.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue()); // Orden alfabético por clave
        }
        
        // LinkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        
        // Añadir elementos
        linkedHashMap.put(3, "Tercero");
        linkedHashMap.put(1, "Primero");
        linkedHashMap.put(2, "Segundo");
        
        // Recorrer el mapa
        System.out.println("Elementos de LinkedHashMap:");
        for (Map.Entry<Integer, String> entrada : linkedHashMap.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue()); // Orden de inserción
        }
    }
}
```


### Operaciones comunes en colecciones

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OperacionesColecciones {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3));
        
        // Ordenar
        Collections.sort(numeros);
        System.out.println("Lista ordenada: " + numeros);
        
        // Ordenar en reversa
        Collections.reverse(numeros);
        System.out.println("Lista en reversa: " + numeros);
        
        // Mezclar
        Collections.shuffle(numeros);
        System.out.println("Lista mezclada: " + numeros);
        
        // Máximo y mínimo
        int maximo = Collections.max(numeros);
        int minimo = Collections.min(numeros);
        System.out.println("Máximo: " + maximo + ", Mínimo: " + minimo);
        
        // Frecuencia
        List<String> palabras = Arrays.asList("hola", "mundo", "hola", "java");
        int frecuencia = Collections.frequency(palabras, "hola");
        System.out.println("Frecuencia de 'hola': " + frecuencia);
        
        // Reemplazar todos
        List<String> colores = new ArrayList<>(Arrays.asList("rojo", "verde", "azul", "rojo"));
        Collections.replaceAll(colores, "rojo", "amarillo");
        System.out.println("Lista con reemplazos: " + colores);
    }
}
```
