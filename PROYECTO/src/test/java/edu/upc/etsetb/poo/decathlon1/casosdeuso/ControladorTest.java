/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1.casosdeuso;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.corrector.TestAll;
import edu.upc.etsetb.poo.decathlon1.dominio.Atleta;
import edu.upc.etsetb.poo.decathlon1.dominio.Competicion;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEvento;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaNegativaException;
import edu.upc.etsetb.poo.decathlon1.dominio.NoAtletasInscritosException;
import edu.upc.etsetb.poo.decathlon1.dominio.NumInscripcionException;
import edu.upc.etsetb.poo.decathlon1.dominio.NumeroDeAtletasException;
import edu.upc.etsetb.poo.decathlon1.dominio.TipoEventoException;
import edu.upc.etsetb.poo.decathlon1.iu.InterficieUsuario;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.WantedButNotInvoked;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorTest extends SuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    protected InterficieUsuario mockIu;

    protected Competicion mockCompeticion;

    @InjectMocks
    protected Controlador controlador;

    public ControladorTest() {
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
        showErrors(indErrors, "Controlador");
        nota.put("Controlador", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
        this.mockIu = Mockito.mock(InterficieUsuario.class);
        this.mockCompeticion = Mockito.mock(Competicion.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01_Constructor() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 1.5; //¡¡¡¡¡ CAMBIAR !!!!!
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nControlador::"
                + "Controlador(...). Valor: " + valorTotal);
        try {
            this.printlnAlways("\n\tPrueba 1. Con argumento inicializa a false ");
            this.testConstructorConFalse(valorTotal * 0.5);
            this.printlnAlways("\n\tPrueba 2. Con argumento inicializa a true ");
            this.testConstructorConTrue(valorTotal * 0.5);
            this.printlnAlways("");
        } catch (Throwable ex) {
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

    private void testConstructorConFalse(double valor) {
        try {
            String competicion = "UnaCompetición";
            String fecha = "20220320";
            String lugar = "Valencia";
            controlador = new Controlador(competicion, fecha, lugar, mockIu, false);
            this.testConstructorMenosAtletas(controlador, competicion, fecha, lugar, 0, valor * 0.8);
            this.printlnAlways("\t*Comprobación del atributo atletas");
            this.checkAttributeAfterConstructor(controlador, "atletas",
                    new HashMap<Integer, Atleta>(), valor * 0.2, 0.5, 0.5, 1);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
    }

    private void testConstructorConTrue(double valor) {
        AssertionError toThrow = null;
        AssertionError error = null;
        try {
            String competicion = "UnaCompetición";
            String fecha = "20220320";
            String lugar = "Valencia";
            controlador = new Controlador(competicion, fecha, lugar, mockIu, true);
            this.testConstructorMenosAtletas(controlador, competicion, fecha,
                    lugar, 5, valor * 0.8);
            this.printlnAlways("\t*Comprobación del atributo atletas");
            this.printlnAlways("\tTest 1. Comprobar si el atributo atletas es "
                    + "diferente de null y tiene 5 atletas inscritos, prueba indirecta de "
                    + "que se han inscrito atletas");
            Optional<Object> attr = this.getPrivateFieldValue(controlador, "atletas");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "El atributo \'atletas\' es "
                        + "una referencia a null. No parece pues, que se haya "
                        + "invocado al método inicializaConAtletasYMarcasIniciales()");
                toThrow = toThrow(error, toThrow);
                return;
            }
            Map<Integer, Atleta> atletas = (Map<Integer, Atleta>) attr.get();
            error = this.sAssertEquals(5, atletas.size(), valor * 0.2,
                    "No se han inscrito 5 atletas. No parece pues, que se haya "
                    + "invocado al método inicializaConAtletasYMarcasIniciales()");
            toThrow = toThrow(error, toThrow);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
    }

    private void testConstructorMenosAtletas(Controlador controlador,
            String competicion, String fecha, String lugar,
            int numInscritos, double valor) {
        try {
            this.testCompeticionDeConstructor(controlador, competicion, fecha, lugar,
                    numInscritos, valor * 0.8);
            this.printlnAlways("\t*Comprobación del atributo iu");
            this.checkAttributeAfterConstructor(controlador, "iu", this.mockIu,
                    valor * 0.2, 0.5, 0.5, 1);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
    }

    private void testCompeticionDeConstructor(Controlador controlador,
            String nombre, String fecha, String lugar, int numInscritos, double valor) {
        AssertionError toThrow = null;
        AssertionError error = null;
        try {
            this.printlnAlways("\t*Comprobar que se ha construido bien el objeto Competicion");
            Optional<Object> attr = this.getPrivateFieldValue(controlador, "competicion");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "El atributo competicion es una "
                        + "referencia a null");
                toThrow = toThrow(error, toThrow);
                return;
            }
            error = this.sAssertTrue(true, valor * 0.2, "");
            Competicion competicion = (Competicion) attr.get();
            this.checkAttributeAfterConstructor(competicion, "nombre", nombre,
                    valor * 0.2, 0.5, 0.5, 1);
            this.checkAttributeAfterConstructor(competicion, "fecha", fecha,
                    valor * 0.2, 0.5, 0.5, 3);
            this.checkAttributeAfterConstructor(competicion, "lugar", lugar,
                    valor * 0.2, 0.5, 0.5, 5);
            this.checkAttributeAfterConstructor(competicion, "numInscritos", numInscritos,
                    valor * 0.2, 0.5, 0.5, 7);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
    }

    /**
     * Test of inscribirAtleta method, of class Controlador.
     */
    @Test
    public void test02_inscribirAtleta() {
        double valorTotal = 1.5; //¡¡¡¡¡ CAMBIAR !!!!!
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nControlador::"
                + "inscribirAtleta(...). Valor: " + valorTotal);
        try {
            controlador = new Controlador("nombreCompeticion", "20220320",
                    "Valencia", mockIu, true);
            String nombreEsperado = "Pepe Pérez";
            String nacionalidadEsperada = "ES";
            controlador.inscribirAtleta(nombreEsperado, nacionalidadEsperada);
            this.printlnAlways("\tComprobar que se ha creado un objeto Atleta y se "
                    + "ha añadido al contenedor de atletas");
            Optional<Object> attr = this.getPrivateFieldValue(controlador, "atletas");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "No parece haberse creado ningún contenedor "
                        + "para el atributo \'atletas\'");
                toThrow = toThrow(error, toThrow);
                return;
            }
            Map<Integer, Atleta> atletas = (Map<Integer, Atleta>) attr.get();
            error = this.sAssertEquals(6, atletas.size(), valorTotal * 0.25, "Antes de inscribir a un "
                    + "nuevo atleta, había 5 inscritos; ahora debería haber 6; sin embargo "
                    + "hay " + atletas.size());
            toThrow = toThrow(error, toThrow);

            this.printlnAlways("\tComprobar que el Atleta creado y añadido tiene el "
                    + "número de inscripción adecuado");
            Atleta atleta = atletas.get(6);
            if (atleta == null) {
                this.sAssertTrue(false, 0, "No parece haberse creado ningún atleta "
                        + "al que se ha asignado el número de inscripción adecuado (6)");
                toThrow = toThrow(error, toThrow);
                return;
            }
            error = this.sAssertTrue(true, valorTotal * 0.25, "");
            toThrow = toThrow(error, toThrow);
            this.printlnAlways("\tComprobar que el Atleta creado y añadido tiene el "
                    + "nombre pasado como argumento");
            String nombre = atleta.getNombre();
            error = this.sAssertEquals(nombreEsperado, nombre, valorTotal * 0.25,
                    "El nombre del atleta inscrito debería ser " + nombreEsperado + ". "
                    + "En su lugar, el nombre es " + nombre);
            toThrow = toThrow(error, toThrow);

            this.printlnAlways("\tComprobar que el Atleta creado y añadido tiene la "
                    + "nacionalidad pasada como argumento");
            String nacionalidad = atleta.getNacionalidad();
            error = this.sAssertEquals(nacionalidadEsperada, nacionalidad, valorTotal * 0.25,
                    "La nacionalidad del atleta inscrito debería ser " + nombreEsperado + ". "
                    + "En su lugar, la nacionalidad es " + nacionalidad);
            toThrow = toThrow(error, toThrow);

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    /**
     * Test of getInfoCompeticion method, of class Controlador.
     */
    @Test
    public void test03_getInfoCompeticion() {
        double valorTotal = 0.5; //¡¡¡¡¡ CAMBIAR !!!!!
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nControlador::"
                + "getInfoCompeticion(...). Valor: " + valorTotal);
        //
        try {
            controlador = new Controlador("UnaCompeticionPrueba", "20220320",
                    "Valencia", mockIu, true);
            Mockito.spy(this.controlador);
            try {
                String infoCompeticion = this.controlador.getInfoCompeticion()
                        .toLowerCase().replaceAll("\\s+", "");
                this.testInString(infoCompeticion, "unacompeticionprueba", "el nombre de la", valorTotal * 0.25);
                this.testInString(infoCompeticion, "20220320", "la fecha de la", valorTotal * 0.25);
                this.testInString(infoCompeticion, "valencia", "el lugar de la", valorTotal * 0.25);
                String expReg = "\\S+inscritos\\S+5([^\\d])*\\S*";
                if (infoCompeticion.matches(expReg)) {
                    this.sAssertTrue(true, valorTotal * 0.25, "");
                } else {
                    this.sAssertTrue(false, 0, "El string con la información no "
                            + "contiene el número de inscritos en la competicion");
                    toThrow = toThrow(error, toThrow);
                }

            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 1 * valorTotal,
                        " El método getInfoCompeticion() debería invocar a "
                        + "Competicion::mytoString()");
                toThrow = toThrow(error, toThrow);
            }
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    public void testInString(String input, String buscado, String que, double valor) {
        AssertionError error = null;
        AssertionError toThrow = null;
        if (input.contains(buscado)) {
            this.sAssertTrue(true, valor, "");
        } else {
            this.sAssertTrue(false, 0, "El string con la información no "
                    + "contiene " + que + "  competicion");
            toThrow = toThrow(error, toThrow);
        }
    }

    /**
     * Test of getNumInscritosEnCompeticion method, of class Controlador.
     */
    @Test
    public void test04_numInscritosEnCompeticion() {
        double valorTotal = 0.5; //¡¡¡¡¡ CAMBIAR !!!!!
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nControlador::"
                + "numInscritosEnCompeticion(...). Valor: " + valorTotal);
        //
        try {
            controlador = new Controlador("nombreCompeticion", "20220320",
                    "Valencia", mockIu, true);
            Mockito.spy(this.controlador);
            try {
                this.setPrivateField(controlador, "competicion", this.mockCompeticion);
                this.controlador.getNumInscritosEnCompeticion();
                Mockito.verify(this.mockCompeticion).getNumInscritos();
                error = this.sAssertTrue(true, 1 * valorTotal, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 1 * valorTotal,
                        " El método getNumInscritosEnCompeticion() debería invocar a "
                        + "Competicion::getNumInscritos()");
                toThrow = toThrow(error, toThrow);
            }
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    /**
     * Test of anyadirMarcaEnEventoDeUnAtleta method, of class Controlador.
     */
    @Test
    public void test05_anyadirMarcaEnEventoDeUnAtleta() {
        double valorTotal = 3;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nControlador::"
                + "anyadirMarcaEnEventoDeUnAtleta(...). Valor: " + valorTotal);
        //
        int resultado;
        int esperado;
        Map<Integer, Atleta> atletas;
        int size, sizeBefore;
        try {
            this.printlnAlways("\tCaso 1: no hay ningún atleta inscrito");
            controlador = new Controlador("nombreCompeticion", "20220320",
                    "Valencia", mockIu, false);
            Optional<Object> attr = this.getPrivateFieldValue(controlador, "atletas");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "No parece haberse creado ningún contenedor "
                        + "para el atributo \'atletas\'");
                toThrow = toThrow(error, toThrow);
                return;
            }
            atletas = (Map<Integer, Atleta>) attr.get();
            size = atletas.size();
            try {
                controlador.anyadirMarcaEnEventoDeUnAtleta(1, 1, 12.0);
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "anyadirMarcaEnEventoDeUnAtleta cuando no había "
                        + "ningún atleta inscrito y NO ha lanzado la excepción "
                        + "NoAtletasInscritosException");
                toThrow = toThrow(error, toThrow);
            } catch (NoAtletasInscritosException ex) {
                error = this.sAssertTrue(true, valorTotal * 0.05, "");
                toThrow = toThrow(error, toThrow);
            }catch(Exception ex){
                error = this.sAssertTrue(false, 0, "El método ha lanzado "
                        + "una excepción que no debía lanzar. La excepción "
                        + "lanzada es de clase " + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            }
            error = this.sAssertEquals(0, atletas.size(), valorTotal * 0.025, "El "
                    + "método no debería haber añadido ningún atleta al mapa "
                    + "de atletas. Sin embargo el mapa tiene ahora "
                    + size + " atletas.");
            toThrow = toThrow(error, toThrow);

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        try {
            this.printlnAlways("\tCaso 2.1: el número de inscripción es negativa");
            controlador = new Controlador("nombreCompeticion", "20220320",
                    "Valencia", mockIu, false);
            controlador.inscribirAtleta("Pepe Pérez", "ES");
            Optional<Object> attr = this.getPrivateFieldValue(controlador, "atletas");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "No parece haberse creado ningún contenedor "
                        + "para el atributo \'atletas\'");
                toThrow = toThrow(error, toThrow);
                return;
            }
            atletas = (Map<Integer, Atleta>) attr.get();
            sizeBefore = atletas.size();
            try {
                controlador.anyadirMarcaEnEventoDeUnAtleta(-1, 1, 12.0);
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "anyadirMarcaEnEventoDeUnAtleta con un número "
                        + "de inscripción negativo y NO ha lanzado la excepción "
                        + "NumInscripcionException");
                toThrow = toThrow(error, toThrow);
            } catch (NumInscripcionException ex) {
                error = this.sAssertTrue(true, valorTotal * 0.05, "");
                toThrow = toThrow(error, toThrow);
            }catch(Exception ex){
                error = this.sAssertTrue(false, 0, "El método ha lanzado "
                        + "una excepción que no debía lanzar. La excepción "
                        + "lanzada es de clase " + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            }
            size = atletas.size();
            error = this.sAssertEquals(1, atletas.size(), valorTotal * 0.05, "El "
                    + "método no debería haber añadido ningún atleta al mapa "
                    + "de atletas. Antes tenía " + sizeBefore + ". Y ahora tiene "
                    + size + " atletas.");
            toThrow = toThrow(error, toThrow);
            this.checkSiSeHaAnyadidoMarcaAAtleta(atletas, 1, valorTotal * 0.025);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        //
        try {
            this.printlnAlways("\tCaso 2.2: el número supera al número de atletas inscritos");
            Optional<Object> attr = this.getPrivateFieldValue(controlador, "atletas");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "No parece haberse creado ningún contenedor "
                        + "para el atributo \'atletas\'");
                toThrow = toThrow(error, toThrow);
                return;
            }
            atletas = (Map<Integer, Atleta>) attr.get();
            sizeBefore = atletas.size();
            try {
                controlador.anyadirMarcaEnEventoDeUnAtleta(7, 1, 12.0);
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "anyadirMarcaEnEventoDeUnAtleta con un número "
                        + "de inscripción mayor que el número de atletas "
                        + "inscritos y NO ha lanzado la excepción "
                        + "NumInscripcionException");
                toThrow = toThrow(error, toThrow);
            } catch (NumInscripcionException ex) {
                error = this.sAssertTrue(true, valorTotal * 0.05, "");
                toThrow = toThrow(error, toThrow);
            }catch(Exception ex){
                error = this.sAssertTrue(false, 0, "El método ha lanzado "
                        + "una excepción que no debía lanzar. La excepción "
                        + "lanzada es de clase " + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            }
            size = atletas.size();
            error = this.sAssertEquals(1, atletas.size(), valorTotal * 0.05, "El "
                    + "método no debería haber añadido ningún atleta al mapa "
                    + "de atletas. Antes tenía " + sizeBefore + ". Y ahora tiene "
                    + size + " atletas.");
            toThrow = toThrow(error, toThrow);
            this.checkSiSeHaAnyadidoMarcaAAtleta(atletas, 1, valorTotal * 0.025);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        try {
            this.printlnAlways("\tCaso 3.1: el identificador del evento es negativo");
            Optional<Object> attr = this.getPrivateFieldValue(controlador, "atletas");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "No parece haberse creado ningún contenedor "
                        + "para el atributo \'atletas\'");
                toThrow = toThrow(error, toThrow);
                return;
            }
            atletas = (Map<Integer, Atleta>) attr.get();
            sizeBefore = atletas.size();
            try {
                controlador.anyadirMarcaEnEventoDeUnAtleta(1, -1, 12.0);
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "anyadirMarcaEnEventoDeUnAtleta con un número "
                        + "de evento negativo y NO ha lanzado la excepción "
                        + "TipoEventoException");
                toThrow = toThrow(error, toThrow);
            } catch (TipoEventoException ex) {
                error = this.sAssertTrue(true, valorTotal * 0.05, "");
                toThrow = toThrow(error, toThrow);
            }catch(Exception ex){
                error = this.sAssertTrue(false, 0, "El método ha lanzado "
                        + "una excepción que no debía lanzar. La excepción "
                        + "lanzada es de clase " + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            }
            size = atletas.size();
            error = this.sAssertEquals(1, atletas.size(), valorTotal * 0.05, "El "
                    + "método no debería haber añadido ningún atleta al mapa "
                    + "de atletas. Antes tenía " + sizeBefore + ". Y ahora tiene "
                    + size + " atletas.");
            toThrow = toThrow(error, toThrow);
            this.checkSiSeHaAnyadidoMarcaAAtleta(atletas, 1, valorTotal * 0.025);
            //
            this.printlnAlways("\tCaso 3.2: el identificador del evento supera "
                    + "al número de eventos registrados MarcaEnEvento.NUM_EVENTOS) (5)");
            sizeBefore = atletas.size();
            try {
                controlador.anyadirMarcaEnEventoDeUnAtleta(1, 20, 12.0);
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "anyadirMarcaEnEventoDeUnAtleta con un número "
                        + "de evento positivo mayor que  el número de eventos "
                        + "registrados MarcaEnEvento.NUM_EVENTOS) (5) y NO ha "
                        + "lanzado la excepción TipoEventoException");
                toThrow = toThrow(error, toThrow);
            } catch (TipoEventoException ex) {
                error = this.sAssertTrue(true, valorTotal * 0.05, "");
                toThrow = toThrow(error, toThrow);
            }catch(Exception ex){
                error = this.sAssertTrue(false, 0, "El método ha lanzado "
                        + "una excepción que no debía lanzar. La excepción "
                        + "lanzada es de clase " + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            }
            size = atletas.size();
            error = this.sAssertEquals(1, atletas.size(), valorTotal * 0.05, "El "
                    + "método no debería haber añadido ningún atleta al mapa "
                    + "de atletas. Antes tenía " + sizeBefore + ". Y ahora tiene "
                    + size + " atletas.");
            toThrow = toThrow(error, toThrow);
            this.checkSiSeHaAnyadidoMarcaAAtleta(atletas, 1, valorTotal * 0.025);
            //
            this.printlnAlways("\tCaso 4: la marca es negativa");
            sizeBefore = atletas.size();
            try {
                controlador.anyadirMarcaEnEventoDeUnAtleta(1, 2, -12.0);
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "anyadirMarcaEnEventoDeUnAtleta con una marca "
                        + "negativa  y NO ha lanzado la excepción "
                        + "MarcaNegativaException");
                toThrow = toThrow(error, toThrow);
            } catch (MarcaNegativaException ex) {
                error = this.sAssertTrue(true, valorTotal * 0.05, "");
                toThrow = toThrow(error, toThrow);
            }catch(Exception ex){
                error = this.sAssertTrue(false, 0, "El método ha lanzado "
                        + "una excepción que no debía lanzar. La excepción "
                        + "lanzada es de clase " + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            }
            size = atletas.size();
            error = this.sAssertEquals(1, atletas.size(), valorTotal * 0.05, "El "
                    + "método no debería haber añadido ningún atleta al mapa "
                    + "de atletas. Antes tenía " + sizeBefore + ". Y ahora tiene "
                    + size + " atletas.");
            toThrow = toThrow(error, toThrow);
            this.checkSiSeHaAnyadidoMarcaAAtleta(atletas, 1, valorTotal * 0.025);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        try {
            this.testsAnyadirMarcaCaso5(valorTotal * 0.3);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    /**
     * Test of getInfoAtleta method, of class Controlador.
     */
    @Test
    public void test06_getInfoAtleta() {
        double valorTotal = 0.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nControlador::"
                + "getInfoAtleta(...). Valor: " + valorTotal);
        //
        try {
            controlador = new Controlador("nombreCompeticion", "20220320",
                    "Valencia", mockIu, false);
            controlador.inscribirAtleta("Pepe Pérez", "ES");
            Optional<Object> attr = this.getPrivateFieldValue(controlador, "atletas");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "No parece haberse creado ningún contenedor "
                        + "para el atributo \'atletas\'");
                toThrow = toThrow(error, toThrow);
                return;
            }
            Map<Integer, Atleta> atletas = (Map<Integer, Atleta>) attr.get();
            Atleta atleta = atletas.get(1);
            if (atleta == null) {
                error = this.sAssertTrue(false, 0, "Se ha intentado inscribir un primer atleta  "
                        + "pero no se ha encontrado ninguno con el número de inscripción 1. "
                        + "Parece haber algún error en el método Controlador::inscribirAtleta(...)");
                toThrow = toThrow(error, toThrow);
                return;
            }
            controlador.anyadirMarcaEnEventoDeUnAtleta(1, 0, 11.278);
            controlador.anyadirMarcaEnEventoDeUnAtleta(1, 1, 694);
            controlador.anyadirMarcaEnEventoDeUnAtleta(1, 2, 15.16);
            controlador.anyadirMarcaEnEventoDeUnAtleta(1, 3, 199);
            controlador.anyadirMarcaEnEventoDeUnAtleta(1, 4, 50.32);

            this.test_getInfoAtletaNumInscrNegativo(controlador, valorTotal);
            this.test_getInfoAtletaNumInscrMayorQueNumInscripciones(controlador, valorTotal);
            this.test_getInfoAtletaNumInscrCorrecto(controlador, valorTotal);

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    /**
     * Test of getClasificacion method, of class Controlador.
     */
    @Test
    public void test07_getClasificacion() {
        double valorTotal = 2.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nControlador::getClasificacion()(...). Valor: "
                + valorTotal);
        try {
            this.test_getClasificacionNoAtletasInscritos(valorTotal * 0.3333333333);
            this.test_getClasificacionMalNumeroAtletas(valorTotal * 0.3333333333);
            this.test_getClasificacionNumeroAtletasOK(valorTotal * 0.3333333333);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);

    }

    public void test_getInfoAtletaNumInscrNegativo(Controlador controlador,
            double valor) {
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\tCaso 1. Número de inscripción negativo");
        try {
            try {
                String infor = controlador.getInfoAtleta(-1);
                error = this.sAssertTrue(false, 0, "Se ha invocado a getInfoAtleta con "
                        + "el argumento -1 y no se ha lanzado la excepción "
                        + "NumInscripcionException");
                toThrow = toThrow(error, toThrow);
            } catch (NumInscripcionException ex) {
                error = this.sAssertTrue(true, valor * 0.05, "");
                toThrow = toThrow(error, toThrow);
            }

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);

    }

    public void test_getInfoAtletaNumInscrMayorQueNumInscripciones(Controlador controlador,
            double valor) {
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\tCaso 2. Número de inscripción mayor que el número "
                + "de atletas inscritos");
        try {
            try {
                String infor = controlador.getInfoAtleta(3);
                error = this.sAssertTrue(false, 0, "Se ha invocado a getInfoAtleta con "
                        + "el argumento 3 (siendo 1 el número de atletas "
                        + "inscritos) y no se ha lanzado la excepción "
                        + "NumInscripcionException");
                toThrow = toThrow(error, toThrow);
            } catch (NumInscripcionException ex) {
                error = this.sAssertTrue(true, valor * 0.05, "");
                toThrow = toThrow(error, toThrow);
            }catch(Exception ex){
                error = this.sAssertTrue(false, 0, "El método ha lanzado "
                        + "una excepción que no debía lanzar. La excepción "
                        + "lanzada es de clase " + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            }
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    public void test_getInfoAtletaNumInscrCorrecto(Controlador controlador,
            double valor) {
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\tCaso 3. Número de inscripción correcto");
        try {
            try {
                String info = controlador.getInfoAtleta(1);
                this.testInfoAtleta(info, valor * 0.9);
            } catch (NumInscripcionException ex) {
                error = this.sAssertTrue(false, 0, "Se ha invocado a getInfoAtleta con "
                        + "el argumento 1 (siendo 1 el número de atletas "
                        + "inscritos) y se ha lanzado la excepción "
                        + "NumInscripcionException");
                toThrow = toThrow(error, toThrow);
            }

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    public void test_getClasificacionNoAtletasInscritos(double valor) {
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        //
        this.printlnAlways("\tCaso 1. No hay atletas inscritos");
        try {
            controlador = new Controlador("nombreCompeticion", "20220320",
                    "Valencia", mockIu, false);
            try {
                String result = controlador.getClasificacion(3);
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "getClasificacion cuando no hay ningún atleta "
                        + "inscrito y NO ha lanzado la excepción "
                        + "NoAtletasInscritosException");
                toThrow = toThrow(error, toThrow);
            } catch (NoAtletasInscritosException ex) {
                error = this.sAssertTrue(true, valor, "");
                toThrow = toThrow(error, toThrow);
            }
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
    }

    public void test_getClasificacionMalNumeroAtletas(double valor) {
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        //
        this.printlnAlways("\tCaso 1. Se pasa un número de atletas erróneo");
        try {
            controlador = new Controlador("nombreCompeticion", "20220320",
                    "Valencia", mockIu, true);
            this.printlnAlways("\t  Se pasa 0 como argumento");
            String result = null;
            try {
                result = controlador.getClasificacion(0);
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "getClasificacion con un argumento 0 y NO ha lanzado "
                        + "la excepción NumeroDeAtletasException");
                toThrow = toThrow(error, toThrow);
            } catch (NumeroDeAtletasException ex) {
                error = this.sAssertTrue(true, valor * 0.333333333, "");
                toThrow = toThrow(error, toThrow);
            }

            //
            this.printlnAlways("\t  Se pasa un argumento negativo");
            try {
                result = controlador.getClasificacion(-1);
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "getClasificacion con un argumento -1 y NO ha lanzado "
                        + "la excepción NumeroDeAtletasException");
                toThrow = toThrow(error, toThrow);
            } catch (NumeroDeAtletasException ex) {
                error = this.sAssertTrue(true, valor * 0.333333333, "");
                toThrow = toThrow(error, toThrow);
            }catch(Exception ex){
                error = this.sAssertTrue(false, 0, "El método ha lanzado "
                        + "una excepción que no debía lanzar. La excepción "
                        + "lanzada es de clase " + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            }
            //
            this.printlnAlways("\t  Se pasa un argumento mayor que el número de atletas inscritos");
            try {
                result = controlador.getClasificacion(6);
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "getClasificacion con un argumento mayor que "
                        + "el número de atletas inscritos y NO ha lanzado "
                        + "la excepción NumeroDeAtletasException");
                toThrow = toThrow(error, toThrow);
            } catch (NumeroDeAtletasException ex) {
                error = this.sAssertTrue(true, valor * 0.333333333, "");
                toThrow = toThrow(error, toThrow);
            }catch(Exception ex){
                error = this.sAssertTrue(false, 0, "El método ha lanzado "
                        + "una excepción que no debía lanzar. La excepción "
                        + "lanzada es de clase " + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            }
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
    }

    public void test_getClasificacionNumeroAtletasOK(double valor) {
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        //
        this.printlnAlways("\tCaso 3. Se pasa un argumento igual al número de atletas inscritos");
        try {
            controlador = new Controlador("nombreCompeticion", "20220320",
                    "Valencia", mockIu, true);
            String resultadoSinProcesar = controlador.getClasificacion(5);
            String resultadoParaComparar = resultadoSinProcesar.replaceAll("\\s+", "").toLowerCase();
            //Resultado a devolver sin espacios en blanco ni finales de línea 
            //y todo en minúsculas.
            String esperadoParaComparar = "1alglarbibourrada2kazdimitriykarpov3frakevinmayer4"
                    + "usaashtoneaton5ausashleymoloney";
            //Y esto es lo esperado sin procesar para presentarlo en caso de error
            String esperadoSinProcesar = "1 ALG Larbi Bourrada\n"
                    + "2 KAZ Dimitriy Karpov\n" + "3 FRA Kevin Mayer\n"
                    + "4 USA Ashton Eaton\n" + "5 AUS Ashley Moloney";

            error = this.sAssertEquals(esperadoParaComparar,
                    resultadoParaComparar, valor, "Al pasar el argumento 5, el método "
                    + "debería devolver \'" + esperadoSinProcesar
                    + "\'. En su lugar ha devuelto \'" + resultadoSinProcesar + "\'");
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
    }

    private void checkSiSeHaAnyadidoMarcaAAtleta(Map<Integer, Atleta> atletas,
            int numInscripcion, double valor) {
        AssertionError toThrow = null;
        AssertionError error = null;
        try {
            Atleta atleta = atletas.get(numInscripcion);
            if (atleta == null) {
                error = this.sAssertTrue(false, puntos, "Debe haber algún error "
                        + "en el método que calcula el número de inscripción (constructor"
                        + " de Atleta) puesto "
                        + "que se ha inscrito solo un atleta y sin embargo el mapa "
                        + "no ha mapeado el atleta con el número de inscripción "
                        + numInscripcion);
                toThrow = toThrow(error, toThrow);
            } else {
                //Comprobar que no se le ha añadido marca alguna al atleta
                Optional<Object> marcasAttr = this.getPrivateFieldValue(atleta, "marcas");
                if (marcasAttr.isPresent()) {
                    boolean notNull = false;
                    MarcaEnEvento[] marcas = (MarcaEnEvento[]) marcasAttr.get();
                    for (MarcaEnEvento marca : marcas) {
                        if (marca != null) {
                            notNull = true;
                            break;
                        }
                    }
                    this.sAssertFalse(notNull, valor, "Alguna de las "
                            + "marcas del único atleta inscrito es diferente de "
                            + "null, lo que quiere decir que el método ha añadido "
                            + "alguna marca, cosa que no debería haber sucedido");
                }
            }
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
    }

    private void testsAnyadirMarcaCaso5(double valor) {
        AssertionError error = null;
        AssertionError toThrow = null;
        try {
            this.printlnAlways("\tCaso 5: se añade una marca de un atleta en un evento correctos");
            Optional<Object> attr = this.getPrivateFieldValue(controlador, "atletas");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "No parece haberse creado ningún contenedor "
                        + "para el atributo \'atletas\'");
                toThrow = toThrow(error, toThrow);
                return;
            }
            Map<Integer, Atleta> atletas = (Map<Integer, Atleta>) attr.get();
            int sizeBefore = atletas.size();
            this.printlnAlways("\t  Prueba 1: el método no lanza ninguna excepción");
            try {
                controlador.anyadirMarcaEnEventoDeUnAtleta(1, 2, 12.0);
                error = this.sAssertTrue(true, valor * 0.16666666, "");
                toThrow = toThrow(error, toThrow);
            } catch (NoAtletasInscritosException | NumInscripcionException
                    | TipoEventoException | MarcaNegativaException ex) {
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "anyadirMarcaEnEventoDeUnAtleta() con los argumentos "
                        + "correctos y sin embargo ha lanzado la excepción "
                        + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            } catch (Exception ex) {
                error = this.sAssertTrue(false, 0, "Se ha invocado a "
                        + "anyadirMarcaEnEventoDeUnAtleta() con los argumentos "
                        + "correctos y sin embargo ha lanzado la excepción "
                        + ex.getClass().getName());
                toThrow = toThrow(error, toThrow);
            }
            int size = atletas.size();
            this.printlnAlways("\t  Prueba 2: se ha generado un nuevo objeto MarcaEnEvento");
            Atleta atleta = atletas.get(1);
            if (atleta == null) {
                this.sAssertTrue(false, 0, "No parece haberse creado ningún atleta "
                        + "al que se ha asignado el número de inscripción adecuado (1)");
                toThrow = toThrow(error, toThrow);
                return;
            }
            Optional<Object> optMarcas = this.getPrivateFieldValue(atleta, "marcas");
            if (optMarcas == null) {
                this.sAssertTrue(false, 0, "No parece haberse creado el array de "
                        + "marcas para el atleta. No se puede acabar la corrección"
                        + " de este método");
                toThrow = toThrow(error, toThrow);
                return;
            }
            MarcaEnEvento marca = ((MarcaEnEvento[]) optMarcas.get())[2];
            error = this.sAssertNotNull(marca, valor * 0.16666666, "En la posición "
                    + "del array de marcas del atleta hay un null; sin embargo "
                    + "debería haber una referencia al objeto MarcaEnEvento que "
                    + "debería haberse creado");
            toThrow = toThrow(error, toThrow);
            //Solo si se ha creado el objeto MarcaEnEvento en la posición correcta
            if (error == null) {
                this.printlnAlways("\t  Prueba 3: la subclase de MarcaEnEvento instanciada es correcta");
                int esperado = 2;
                Optional<Object> optEv = this.getPrivateFieldValue(marca, "evento");
                String claseDeMarca = marca.getClass().getName();
                String expected = "edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEventoLanzamientoPeso";
                error = this.sAssertEquals(expected, claseDeMarca,
                        valor * 0.16666666, "La marca creada debería "
                        + "haber sido un objeto " + expected + ". Sin "
                                + "embaro, se ha creado un objeto " + claseDeMarca);
                toThrow = toThrow(error, toThrow);
                this.printlnAlways("\t  Prueba 4: la marca del objeto MarcaEnEvento es correcta");
                double doubleEsperado = 12;
                Optional<Object> optMarca = this.getPrivateFieldValue(marca, "marca");
                if (!optMarca.isPresent()) {
                    error = this.sAssertTrue(false, 0, "No parece que el objeto MarcaEnEvento "
                            + "tenga el atributo \'marca\'.");
                    toThrow = toThrow(error, toThrow);
                } else {
                    error = this.sAssertEquals(doubleEsperado, (double) optMarca.get(), valor * 0.16666666,
                            "La marca en el objeto MarcaEnEvento no es correcto. "
                            + "Su valor es " + (double) optMarca.get() + ". Sin embargo, "
                            + "dicho valor debería ser " + doubleEsperado);
                    toThrow = toThrow(error, toThrow);
                }
                this.printlnAlways("\t  Prueba 5: los puntos del objeto MarcaEvento son correctos");
                Optional<Object> optPuntos = this.getPrivateFieldValue(marca, "puntos");
                if (!optPuntos.isPresent()) {
                    error = this.sAssertTrue(false, 0, "No parece que el objeto MarcaEnEvento "
                            + "tenga el atributo \'puntos\'.");
                    toThrow = toThrow(error, toThrow);
                } else {
                    esperado = 606;
                    error = this.sAssertEquals(esperado, (int) optPuntos.get(), valor * 0.16666666,
                            "Los puntos en el objeto MarcaEnEvento no son correctos. "
                            + "Su valor es " + (int) optPuntos.get() + ". Sin embargo, "
                            + "dicho valor debería ser " + esperado);
                    toThrow = toThrow(error, toThrow);
                }
                this.printlnAlways("\t  Prueba 6: los puntos totales del atleta se han actualizado correctamente");
                optPuntos = this.getPrivateFieldValue(atleta, "puntos");
                if (!optPuntos.isPresent()) {
                    error = this.sAssertTrue(false, 0, "No parece que el atleta "
                            + "tenga el atributo \'puntos\'.");
                    toThrow = toThrow(error, toThrow);
                } else {
                    error = this.sAssertEquals(esperado, (int) optPuntos.get(), valor * 0.16666666,
                            "Los puntos del atleta no son correctos. "
                            + "Su valor es " + (int) optPuntos.get() + ". Sin embargo, "
                            + "dicho valor debería ser " + esperado);
                    toThrow = toThrow(error, toThrow);
                }
            }
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

    }

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
