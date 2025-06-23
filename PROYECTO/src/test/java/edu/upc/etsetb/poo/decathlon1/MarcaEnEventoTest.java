package edu.upc.etsetb.poo.decathlon1;

import edu.upc.ac.corrector.AccreditedSuperClassForTests;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.corrector.TestAll;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEvento;
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
public class MarcaEnEventoTest extends AccreditedSuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public MarcaEnEventoTest() {
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
        showErrors(indErrors, "MarcaEnEvento");
        nota.put("MarcaEnEvento", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private MarcaEnEvento createAbstractInstance(double marca){
        MarcaEnEvento me = new MarcaEnEvento(marca){
            @Override
            public void calcularPuntosEvento(double A, double B, double C, double marca) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        return me;
    }
    
    @Test
    public void test01_Constructor(){
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 4; //¡¡¡¡¡ CAMBIAR !!!!!
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
     * Test of getPuntos method, of class MarcaEnEvento.
     */
    @Test
    public void test02_GetPuntos() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 2; //¡¡¡¡¡ CAMBIAR !!!!!
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nMarcaEnEvento::getPuntos(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        MarcaEnEvento instance = null;
        double marca = 1.3;
        
        int nTests = 1;
        
        try {
            instance = createAbstractInstance(marca);
            int returned = instance.getPuntos();
            error = this.sAssertEquals(returned,0,valorTotal*1.0/nTests,"getPunos() debe devolver"
                    + "los puntos");
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

    private static String trimAll(String original){
        StringBuilder trimmed = new StringBuilder(original);
        int nChars = trimmed.length();
        int j=0;
        for (int i=0;i<nChars;i++){
            char c=trimmed.charAt(j);
            if(c==' '||c=='\n'||c=='\t'){
                trimmed.deleteCharAt(j);
            }
            else j++;
        }
        return trimmed.toString().toLowerCase();
    }
    
    /**
     * Test of getListaEventos method, of class MarcaEnEvento.
     */
    @Test
    public void test03_getListaEventos() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 4; //¡¡¡¡¡ CAMBIAR !!!!!
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nMarcaEnEvento::getListaEventos(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        int nTests = 1;
        try {
            String returned = MarcaEnEvento.getListaEventos();
            String correct = "Lista de eventos:\n" +
"[0]    100 metros lisos	[1]    Salto de longitud	[2]    Lanzamiento de peso	[3]    Salto de altura	[4]    400 metros lisos\n";
            String returnedTrimmed = trimAll(returned);
            String correctTrimmed = trimAll(correct);
            boolean ok = returnedTrimmed.equals(correctTrimmed);
            if (ok){
                error = this.sAssertTrue(true,valorTotal*1.0/nTests,"");
            }
            else {
                String msg = "Expected String:\n"+correct+
                        "\nYour method returned:\n"+returned;
                error = this.sAssertTrue(false,0,msg);
                toThrow = toThrow(error, toThrow);
            }
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
