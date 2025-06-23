package edu.upc.etsetb.poo.decathlon1;

import edu.upc.ac.corrector.AccreditedSuperClassForTests;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.corrector.TestAll;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEvento;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEventoLanzamientoPeso;
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
public class MarcaEnEventoLanzamientoPesoTest extends AccreditedSuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public MarcaEnEventoLanzamientoPesoTest() {
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
        showErrors(indErrors, "MarcaEnEventoLanzamientoPeso");
        nota.put("MarcaEnEventoLanzamientoPeso", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void test01_Constructor(){
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 5; //¡¡¡¡¡ CAMBIAR !!!!!
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nMarcaEnEventoLanzamientoPeso::"
                + "nMarcaEnEventoLanzamientoPeso(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES

        MarcaEnEvento instance = null;
        double marca = 18.40;
        
        int nTests = 4;
        
        try {
            instance = new MarcaEnEventoLanzamientoPeso(marca);
            this.checkAttributeAfterConstructor(instance, "marca", marca,
                    valorTotal, 1.0/nTests, 1.0/nTests, 1);
            this.checkAttributeAfterConstructor(instance, "puntos", 1000,
                    valorTotal, 1.0/nTests, 1.0/nTests, 3);
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


    @Test
    public void test02_toString() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 5; //¡¡¡¡¡ CAMBIAR !!!!!
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nMarcaEnEventoLanzamientoPeso::"
                + "toString(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES

        MarcaEnEvento instance = null;
        double marca = 18.45;

        int nTests = 4;

        try {
            instance = new MarcaEnEventoLanzamientoPeso(marca);
            String result = instance.toString().toLowerCase().replaceAll("\\s+", "");
            //Comprobar que incluye el nombre del evento
            int pos1 = result.indexOf("lanzamientodepeso");
            int pos2 = result.indexOf("lanzamientopeso");
            this.sAssertTrue(pos1 > -1 || pos2 > -1, valorTotal / 3, "El string "
                    + "no contiene el nombre del evento ('lanzamiento de peso' o "
                    + "'lanzamiento peso'");
            //Comprobar que incluye la marca correcta
            pos1 = result.indexOf("marca=18.45");
            pos2 = result.indexOf("marca=18,45");
            this.sAssertTrue(pos1 > -1 || pos2 > -1, valorTotal / 3, "El string "
                    + "no contiene un substring indicando la marca del evento "
                    + "('marca = 18.45' o 'marca = 18,45'");
            //Comprobar que incluye el número de puntos correcto
            pos1 = result.indexOf("puntos=1003");
            this.sAssertTrue(pos1 > -1, valorTotal / 3, "El string "
                    + "no contiene un substring indicando los puntos correspondientes "
                    + "a la marca 'puntos = 1003'");
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
