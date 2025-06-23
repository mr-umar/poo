/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.corrector.TestAll;
import edu.upc.etsetb.poo.decathlon1.dominio.Atleta;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEvento;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaNegativaException;
import java.util.Map;
import java.util.Optional;
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
public class AtletaTest extends SuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public AtletaTest() {
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
        showErrors(indErrors, "Atleta");
        nota.put("Atleta", puntosTotales);
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
        double valorTotal = 1;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nAtleta::Atleta(). Valor: " + valorTotal);

        Atleta instance = null;
        String nombre = "nombreAtleta";
        String nacionalidad = "española";
        int numInscripcion = 12;
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            instance = new Atleta(nombre, nacionalidad, numInscripcion);
            this.checkAttributeAfterConstructor(instance, "nombre", nombre,
                    valorTotal, 0.1, 0.1, 1);
            this.checkAttributeAfterConstructor(instance, "nacionalidad", nacionalidad,
                    valorTotal, 0.1, 0.1, 3);
            this.checkAttributeAfterConstructor(instance, "numInscripcion", numInscripcion,
                    valorTotal, 0.1, 0.1, 5);
            this.checkAttributeAfterConstructor(instance, "puntos", 0,
                    valorTotal, 0.1, 0.1, 7);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        try {
            System.out.println("\tTest 9: Comprobación de existencia del "
                    + "atributo de nombre \'marcas\' (" + (valorTotal * 0.25/5) + ")");
            error = this.checkPrivateFieldExists(instance, "marcas", valorTotal * 0.25/5, null);
            toThrow = toThrow(error, toThrow);
            if (error == null) {
                MarcaEnEvento[] a = new MarcaEnEvento[10];
                System.out.println("\tTest 10: Comprobación de que el atributo de nombre \'marcas\' es un array de MarcaEvento");
                error = this.checkPrivateFieldIsOfASpecificClass(instance, 
                        "marcas", edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEvento[].class, valorTotal * 0.25/5, null);
                toThrow = toThrow(error, toThrow);
                Optional<Object> attrVal = this.getPrivateFieldValue(instance, "marcas");
                if (attrVal.isPresent()) {
                    MarcaEnEvento[] marcas = (MarcaEnEvento[]) attrVal.get();
                    error = this.sAssertEquals(MarcaEnEvento.NUM_EVENTOS, marcas.length,
                            valorTotal * 0.25/5 , "El atributo \'marcas\' debe ser "
                            + "un array de dimensión " + MarcaEnEvento.NUM_EVENTOS
                            + ". En su lugar, su dimensión es " + marcas.length);
                    toThrow = toThrow(error, toThrow);
                    System.out.println("\tTest 11: Comprobación de que el array tiene null en todas sus posiciones");
                    boolean allNull = true;
                    for(int i=0;i<marcas.length;i++){
                        if(marcas[i]!=null){
                            allNull = false;
                            break;
                        }
                    }
                    error = this.sAssertTrue(allNull,
                            valorTotal * 0.25/5 , "El atributo \'marcas\' debe tener "
                            + "el valor null en todas sus posiciones, pero hay "
                            + "alguna posición en la que eso no es cierto");
                    toThrow = toThrow(error, toThrow);

                } else {
                    error = this.sAssertTrue(false, 0, "El atributo \'marcas\' tiene un valor "
                            + "null en lugar de referenciar a un array.");
                    toThrow = toThrow(error, toThrow);
                }
            }
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

    /**
     * Test of getNumInscripcion method, of class Atleta.
     */
    @Test
    public void test02_GetNumInscripcion() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 0.5;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nAtleta::getNumInscripcion(). Valor: " + valorTotal);

        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            Atleta instance = new Atleta("nombre", "nacionalidad", 12);
            this.println("\tTest 1: comprobar que se retorna el valor de "
                    + " \'nunInscripcion\' al invocar este método.");
            error = this.checkFieldValue(instance, "numInscripcion", instance.getNumInscripcion(),
                    valorTotal, toThrow);
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

    /**
     * Test of getNombre method, of class Atleta.
     */
    @Test
    public void test03_GetNombre() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 0.5;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nAtleta::getNombre(). Valor: " + valorTotal);

        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            Atleta instance = new Atleta("nombre", "nacionalidad", 12);
            this.println("\tTest 1: comprobar que se retorna el valor de "
                    + " \'nombre\' al invocar este método");
            error = this.sAssertEquals("nombre", instance.getNombre(), valorTotal,
                    "Los puntos deberían ser los que tiene el atleta en "
                    + "atributo");
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

    /**
     * Test of getNacionalidad method, of class Atleta.
     */
    @Test
    public void test04_GetNacionalidad() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 0.5;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nAtleta::getNacionalidad(). Valor: " + valorTotal);

        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            Atleta instance = new Atleta("nombre", "nacionalidad", 12);
            this.println("\tTest 1: comprobar que se retorna el valor de "
                    + " \'nacionalidad\' al invocar este método.");
            error = this.sAssertEquals("nacionalidad", instance.getNacionalidad(), valorTotal,
                    "La nacionalidad debería ser la que atleta tiene como "
                    + "atributo");
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

    /**
     * Test of getPuntos method, of class Atleta.
     */
    @Test
    public void test05_GetPuntos() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 0.5;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nAtleta::getPuntos(). Valor: " + valorTotal);

        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            Atleta instance = new Atleta("nombre", "nacionalidad", 12);
            this.println("Test 1: comprobar que se retorna el valor de "
                    + " \'puntos\' al invocar este método.");
            error = this.checkFieldValue(instance, "puntos", instance.getPuntos(),
                    valorTotal, toThrow);
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

    /**
     * Test of anyadirMarcaEnEvento method, of class Atleta.
     */
    @Test
    public void test06_AnyadirMarcaEnEvento() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 2;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nAtleta::anyadirMarcaEnEvento(). Valor: " + valorTotal);

        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            // crear una atleta
            Atleta instance = new Atleta("nombre", "nacionalidad", 12);
            this.println("\tTest 1: comprobar que al pasar una marca de valor negativo se lanza la excepción correspondiente.");
            try {
                //añadir una marca en el evento dado
                instance.anyadirMarcaEnEvento(0, -2.0);
                this.println("El valor de la marca es negativo y debería lanzar una excepción MarcaNegativaException");
            } catch (MarcaNegativaException ex) {
                this.acumula(0.5 * valorTotal);
            }
    
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        try {
            // crear una atleta
            Atleta instance = new Atleta("nombre", "nacionalidad", 12);
            this.println("\tTest 2: comprobar que al añadir una marca a un evento el atributo "
                    + " \'puntos\' queda actualizado correctamente.");
            //añadir una marca en el evento dado
            instance.anyadirMarcaEnEvento(0, 2.0);
            //comprobar que despues de añadir la Marca, los puntos quedan modificados
            error = this.checkFieldValue(instance, "puntos", (int) (25.4347
                        * Math.pow((18 - 2.0), 1.81)),
                    0.5 * valorTotal, toThrow);
            
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

    /**
     * Test of calcularPuntos method, of class Atleta.
     */
    @Test
    public void test07_calcularPuntos() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 3;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nAtleta::calcularPuntos(). Valor: " + valorTotal);

        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            Atleta instance = new Atleta("nombre", "nacionalidad", 12);
            this.println("\tTest 1: comprobar que al añadir una nueva marca a un evento el atributo "
                    + " \'puntos\' queda actualizado correctamente.");
            //añadir una marca en el evento dado
            instance.anyadirMarcaEnEvento(0, 2.0);
            //comprobar correcto funcionamiento de calcular puntos añadiendo otro evento
            int puntosOld = instance.getPuntos();
            instance.anyadirMarcaEnEvento(1, 7.0);
            error = this.checkFieldValue(instance, "puntos", puntosOld + (int) (0.14354
                        * Math.pow((7.0 - 220), 1.40)),
                    valorTotal, toThrow);
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }

    /**
     * Test of toString method, of class Atleta.
     */
    @Test
    public void test08_ToString() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 2;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nAtleta::toString(). Valor: " + valorTotal);

        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            // Crear un atleta
            Atleta instance = new Atleta("Pepe Pérez", "ES", 1);
            
            // Añadir unas marcas
            instance.anyadirMarcaEnEvento(0, 11.278);
            instance.anyadirMarcaEnEvento(1, 694.0);
            instance.anyadirMarcaEnEvento(2, 15.16);
            instance.anyadirMarcaEnEvento(3, 199.0);
            instance.anyadirMarcaEnEvento(4, 50.32);
            
            //copiar métodos de JC
            String info = instance.toString();
            this.testInfoAtleta(info, valorTotal);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);
    }
    
    //métodos JC para toString
    private void testInfoAtleta(String infoArg, double valorTotal) {
        AssertionError error = null;
        AssertionError toThrow = null;
        String info = infoArg.replaceAll("\\s+", "").toLowerCase()
                .replaceAll("\\.((0)+(?!\\d))", "")
                .replace("100metroslisos", "cienmetroslisos")
                .replace("400metroslisos", "cuatrocientosmetroslisos");
        error = this.testAtletaDetails(info, "n[úu]merodeinscripci[óo]n([^\\d]+)1[^\\d]\\S+",
                "número de inscripción", "1", valorTotal * 0.1111111111);
        toThrow = toThrow(error, toThrow);
        error = this.testAtletaDetails(info, "(\\S+)nombre([^\\d]+)pepepérez\\S+",
                "nombre", "Pepe Pérez", valorTotal * 0.1111111111);
        error = this.testAtletaDetails(info, "(\\S+)nacionalidad([^\\d]+)es\\S+",
                "nacionalidad", "ES", valorTotal * 0.1111111111);
        toThrow = toThrow(error, toThrow);
        this.testInfoMarca(info, "cienmetroslisos", "11(\\.|,)278(\\d*)",
                "800", "100 metros lisos", "11.278", "saltodelongitud", valorTotal * 0.1111111111);
        this.testInfoMarca(info, "saltodelongitud", "694([^\\d]+)",
                "799", "salto de longitud", "694.0 o 694", "lanzamientodepeso", valorTotal * 0.1111111111);
        this.testInfoMarca(info, "lanzamientodepeso", "15(\\.|,)16(\\d*)",
                "800", "lanzamiento de peso", "15.16", "saltodealtura", valorTotal * 0.1111111111);
        this.testInfoMarca(info, "saltodealtura", "199([^\\d]+)",
                "794", "salto de altura", "199 o 199.0", "cuatrocientosmetroslisos", valorTotal * 0.1111111111);
        this.testInfoMarca(info, "cuatrocientosmetroslisos", "50(\\.|,)32(\\d*)",
                "800", "salto de altura", "50.32", "puntostotales", valorTotal * 0.1111111111);
        error = this.testAtletaDetails(info, "(\\S+)puntostotales([^\\d]+)3993([^\\d]*)",
                "puntos totales", "3393", valorTotal * 0.1111111111);
    }

    private AssertionError testAtletaDetails(String info, String expReg1,
            String que, String esperado, double puntos) {
        AssertionError error;
        AssertionError toThrow = null;
        this.printlnAlways("\t  Comprobando " + que);
        if (info.matches(expReg1)) {
            error = this.sAssertTrue(true, puntos, "");
            toThrow = toThrow(error, toThrow);
            return error;
        }
        error = this.sAssertTrue(false, puntos, "No se ha encontrado el valor esperado "
                + "de " + que + ". Debería ser " + esperado
                + RECOMENDACION_ATLETA_TOSTRING);
        toThrow = toThrow(error, toThrow);
        return error;

    }

    private AssertionError testInfoMarca(String info, String evento, String marcaRegex,
            String puntosRegex, String que, String marca, String siguiente,
            double valor) {
        AssertionError error = null;
        AssertionError toThrow = null;
        this.printlnAlways("\t  Comprobando " + que);
        String regex = "(\\S+)" + evento + "\\S+marca([^\\d]+)" + marcaRegex + "\\S+puntos([^\\d]+)" + puntosRegex + "(?![\\d])([^\\d]*)" + siguiente + "\\S*";
        if (info.matches(regex)) {
            error = this.sAssertTrue(true, valor, "");
            toThrow = toThrow(error, toThrow);
            return error;
        } else {
            regex = "(\\S+)" + evento + "\\S+marca([^\\d]+)" + marcaRegex + "\\S*";
            if (info.matches(regex)) {
                //Comprobar si solp está la marca
                error = this.sAssertTrue(true, valor * 0.5, "");
                error = this.sAssertTrue(false, 0, "El string contiene la marca "
                        + "correcta para " + que + " pero no el número de puntos"
                        + ", que debería ser " + puntosRegex + RECOMENDACION_ATLETA_TOSTRING);
                toThrow = toThrow(error, toThrow);
                return error;
            } else {
                //Comprobar si solo están los puntos
                regex = "(\\S+)" + evento + "\\S+marca\\S+([^(marca)])puntos([^\\d]+)" + puntosRegex + "(?![\\d])([^\\d]*)\\S*";
                if (info.matches(regex)) {
                    error = this.sAssertTrue(true, valor * 0.5, "");
                    error = this.sAssertTrue(false, 0, "El string contiene el número "
                            + "de puntos correcto para " + que + " pero no la marca"
                            + ", que debería ser " + marca + RECOMENDACION_ATLETA_TOSTRING);
                    toThrow = toThrow(error, toThrow);
                    return error;
                } else {
                    error = this.sAssertTrue(false, 0, "El string no contiene ni la marca "
                            + "correcta para " + que + ", que debería ser " + marca
                            + ", ni el número de puntos, que debería ser "
                            + puntosRegex + RECOMENDACION_ATLETA_TOSTRING);
                    toThrow = toThrow(error, toThrow);
                    return error;
                }
            }
        }
    }

    private static final String RECOMENDACION_ATLETA_TOSTRING
            = "\n\t\t  Comprueba el valor y si has seguido la especificación de "
            + "Atleta::toString()\n\t\t  en lo tocante a la estructura del "
            + "string resultante";

}
