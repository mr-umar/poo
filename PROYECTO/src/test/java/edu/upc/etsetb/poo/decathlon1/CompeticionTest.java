/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1;

import edu.upc.ac.corrector.AccreditedSuperClassForTests;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.corrector.TestAll;
import edu.upc.etsetb.poo.decathlon1.dominio.Competicion;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.junit.MockitoJUnitRunner;


/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class CompeticionTest extends AccreditedSuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public CompeticionTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "Competicion");
        nota.put("Competicion", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01_Constructor() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 2; //¡¡¡¡¡ CAMBIAR !!!!!
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nCompeticion::"
                + "Competicion(...). Valor: " + valorTotal);
        
        Competicion instance = null;
        String nombre = "Decathlon";
        String fecha = "ddmmaaaa";
        String lugar = "Barcelona";
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            //CADA PRUEBA INVOCARÁ A ALGÚN MÉTODO DE SuperClassForTests y
            //algún sAsserts según el patrón que sigue:
            //error = this.sAssert....
            //toThrow = toThrow(error, toThrow);
            instance = new Competicion(nombre, fecha, lugar);
            this.checkAttributeAfterConstructor(instance, "nombre", nombre,
                    valorTotal, 0.1, 0.15, 1);
            this.checkAttributeAfterConstructor(instance, "fecha", fecha,
                    valorTotal, 0.1, 0.15, 3);
            this.checkAttributeAfterConstructor(instance, "lugar", lugar,
                    valorTotal, 0.1, 0.15, 5);
            this.checkAttributeAfterConstructor(instance, "numInscritos", 0,
                    valorTotal, 0.1, 0.15, 7);
            
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //DESPUÉS DE TODAS LAS PRUEBAS AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

    /**
     * Test of getNumInscritos method, of class Competicion.
     */
    @Test
    public void test02_getNumInscritos() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 1; //¡¡¡¡¡ CAMBIAR !!!!!
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nCompeticion::"
                + "getNumInscritos(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            //CADA PRUEBA INVOCARÁ A ALGÚN MÉTODO DE SuperClassForTests y
            //algún sAsserts según el patrón que sigue:
            //error = this.sAssert....
            //toThrow = toThrow(error, toThrow);
            Competicion instance = new Competicion("nombre", "nacionalidad", "Barcelona");
            this.println("\tTest 1: comprobar que se retorna el valor de "
                    + " \'numInscritos\' al invocar este método (100%)");
            error = this.checkFieldValue(instance, "numInscritos", instance.getNumInscritos(),
                    valorTotal, toThrow);
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //DESPUÉS DE TODAS LAS PRUEBAS AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

    /**
     * Test of obtenerSiguienteNumInscripcion method, of class Competicion.
     */
    @Test
    public void test03_obtenerSiguienteNumInscripcion() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 3; //¡¡¡¡¡ CAMBIAR !!!!!
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nCompeticion::"
                + "obtenerSiguienteNumInscripcion(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            //CADA PRUEBA INVOCARÁ A ALGÚN MÉTODO DE SuperClassForTests y
            //algún sAsserts según el patrón que sigue:
            //error = this.sAssert....
            //toThrow = toThrow(error, toThrow);
            Competicion instance = new Competicion("nombre", "nacionalidad", "Barcelona");
            instance.obtenerSiguienteNumInscripcion();
            instance.obtenerSiguienteNumInscripcion();
            instance.obtenerSiguienteNumInscripcion();
            this.println("\tTest 1: comprobar que se siguienteInscripción retorna"
                    + " el valor adecuado.");
            error = this.checkFieldValue(instance, "numInscritos", 3,
                    valorTotal, toThrow);
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //DESPUÉS DE TODAS LAS PRUEBAS AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

    /**
     * Test of toString method, of class Competicion.
     */
    @Test
    public void test04_toString() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 4; //¡¡¡¡¡ CAMBIAR !!!!!
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nCompeticion::"
                + "toString(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            //CADA PRUEBA INVOCARÁ A ALGÚN MÉTODO DE SuperClassForTests y
            //algún sAsserts según el patrón que sigue:
            //error = this.sAssert....
            //toThrow = toThrow(error, toThrow);
            
            //Crear un objeto Competicion
            Competicion instance = new Competicion( "EuroCOPA", "20220613",  "Austria");
            // Generar string
            String salida = instance.toString();
            //dividir por líneas
            String[] linea = salida.split("\n");
            
            //comprobar que hay tantas líneas como corresponde:4
            this.println("\tTest 1: comprobar que el número de línias es el que"
                    + " corresponde.");
            boolean res = (linea.length == 4);
            error = this.sAssertTrue(res, 0.2 * valorTotal, "Si el metodo toString() "
                    + "estuviera bien debería tener cuatro líneas, según el formato"
                    + "especificado");
            toThrow = toThrow(error, toThrow);
            
            //Comprobar que la información de cada linea es la que corresponde 
            //nombre
            this.println("\tTest 2: comprobar que el texto contiene la"
                    + " información adecuada de Competicion.");
            res = linea[0].contains("EuroCOPA");
            error = this.sAssertTrue(res, 0.2 * valorTotal, "Si el metodo toString() "
                    + "estuviera bien en la primera línea debería aparecer el nombre"
                    + "de la Competición");
            toThrow = toThrow(error, toThrow);
            res = linea[1].contains("20220613");
            error = this.sAssertTrue(res, 0.2 * valorTotal, "Si el metodo toString() "
                    + "estuviera bien en la segunda línea debería aparecer la fecha"
                    + "de la Competición");
            toThrow = toThrow(error, toThrow);
            res = linea[2].contains("Austria");
            error = this.sAssertTrue(res, 0.2 * valorTotal, "Si el metodo toString() "
                    + "estuviera bien en la tercera línea debería aparecer el lugar"
                    + "de la Competición");
            toThrow = toThrow(error, toThrow);
            Integer inscritos = instance.getNumInscritos();  
            res = linea[3].contains(inscritos.toString());
            error = this.sAssertTrue(res, 0.2 * valorTotal, "Si el metodo toString() "
                    + "estuviera bien en la última línea debería aparecer el número"
                    + "de inscritos en la Competición");
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //DESPUÉS DE TODAS LAS PRUEBAS AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

}