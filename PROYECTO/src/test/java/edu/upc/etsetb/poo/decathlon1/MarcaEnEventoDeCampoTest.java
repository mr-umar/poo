package edu.upc.etsetb.poo.decathlon1;

import edu.upc.ac.corrector.AccreditedSuperClassForTests;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.corrector.TestAll;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEvento;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEventoDeCampo;
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
public class MarcaEnEventoDeCampoTest extends AccreditedSuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public MarcaEnEventoDeCampoTest() {
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
        showErrors(indErrors, "MarcaEnEventoDeCampo");
        nota.put("MarcaEnEventoDeCampo", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private MarcaEnEventoDeCampo createAbstractInstance(double marca){
        MarcaEnEventoDeCampo me = new MarcaEnEventoDeCampo(marca){
        };
        return me;
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
        this.printlnAlways("\nMarcaEnEvento::"
                + "MarcaEnEvento(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES

        MarcaEnEvento instance = null;
        double marca = 1.3;
        
        int nTests = 4;
        
        try {
            instance = createAbstractInstance(marca);
            this.checkAttributeAfterConstructor(instance, "marca", marca,
                    valorTotal, 1.0/nTests, 1.0/nTests, 1);
            this.checkAttributeAfterConstructor(instance, "puntos", 0,
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

    /**
     * Test of calcularPuntosEvento method, of class MarcaEnEvento.
     */
    @Test
    public void test02_CalcularPuntosEvento() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 5; //¡¡¡¡¡ CAMBIAR !!!!!
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nMarcaEnEvento::calcularPuntosEvento(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES

        int nTests=1;
        
        MarcaEnEvento instance = null;
        double marca = 80;
        double A = 0.8465;
        double B = 75;
        double C = 1.42;  //SALTO_ALTURA

        try {
            instance = createAbstractInstance(marca);
            instance.calcularPuntosEvento(A,B,C,marca);
            int puntosCalculados = instance.getPuntos();
            int puntosOk = 8; 
            error = this.sAssertEquals(puntosOk,puntosCalculados,valorTotal*1.0/nTests,"Calculo incorrecto: ");
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
