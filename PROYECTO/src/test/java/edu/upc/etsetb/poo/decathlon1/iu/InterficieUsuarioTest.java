/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1.iu;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.corrector.TestAll;
import edu.upc.etsetb.poo.decathlon1.casosdeuso.Controlador;
import edu.upc.etsetb.poo.decathlon1.dominio.Atleta;
import edu.upc.etsetb.poo.decathlon1.dominio.NoAtletasInscritosException;
import edu.upc.etsetb.poo.decathlon1.dominio.NumInscripcionException;
import edu.upc.etsetb.poo.decathlon1.dominio.TipoEventoException;
import java.io.PrintStream;
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
import org.mockito.Mockito;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import org.mockito.exceptions.verification.junit.ArgumentsAreDifferent;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class InterficieUsuarioTest extends SuperClassForTests {

    private static int numErrorsBefore;
    private static int numInstances = 0;
    private static Map<String, Double> nota;
    protected InterficieUsuario mockIu;
    protected Controlador mockControlador;
    protected PrintStream mockPrintStream;

    public InterficieUsuarioTest() {
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
        showErrors(indErrors, "InterficieUsuario");
        nota.put("InterficieUsuario", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
        this.mockIu = Mockito.mock(InterficieUsuario.class);
        this.mockControlador = Mockito.mock(Controlador.class);
        this.mockPrintStream = Mockito.mock(PrintStream.class);
        try {
            Mockito.doThrow(new NoAtletasInscritosException("ERROR: Aún no hay ningún atleta inscrito.")).when(this.mockControlador).anyadirMarcaEnEventoDeUnAtleta(1, 0, 0);
            Mockito.doThrow(new NumInscripcionException("ERROR: El número de inscripción es erróneo.")).when(this.mockControlador).anyadirMarcaEnEventoDeUnAtleta(-1, 0, 0);
            Mockito.doThrow(new TipoEventoException("ERROR: Número de tipo de evento erróneo.")).when(this.mockControlador).anyadirMarcaEnEventoDeUnAtleta(1, -1, 0);
        } catch (Exception e) {
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Constructor method, of class InterficieUsuario.
     */
    @Test
    public void test01_Constructor() {
        double valorTotal = 1.0;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;

        this.printlnAlways("\nInterficieUsuario::"
                + "InterficieUsuario(...). Valor: " + valorTotal);
        try {
            this.printlnAlways("    Caso 1: comprobar que se ha creado el atributo de tipo Controlador");
            InterficieUsuario instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", false);
            Optional<Object> attr = this.getPrivateFieldValue(instance, "controlador");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "Atributo de tipo Controlador = null!");
                toThrow = toThrow(error, toThrow);

            } else {
                error = this.sAssertTrue(true, valorTotal * 0.34, "");
            }
        } catch (Exception ex) {
            this.printlnAlways("\n*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...\n");
            this.printStackTraceUpc(ex);
        }
        this.printlnAlways("    Caso 2: comprobar que se ha invocado correctamente "
                + "al constructor con argumento inicializa a true y se han creado "
                + "los atletas desde el método Controlador::inicializaConAtletasYMarcasIniciales()");
        try {
            InterficieUsuario instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", true);
            Optional<Object> attr = this.getPrivateFieldValue(instance, "controlador");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "Atributo de tipo Controlador = null!");
                toThrow = toThrow(error, toThrow);
            } else {
                Controlador contr = (Controlador) attr.get();
                Optional<Object> atletasAttr = this.getPrivateFieldValue(contr, "atletas");
                if (!atletasAttr.isPresent()) {
                    error = this.sAssertTrue(false, 0, "No se ha creado el atributo \'atletas\' en "
                            + "el controlador = null!");
                    toThrow = toThrow(error, toThrow);
                } else {
                    Map<Integer, Atleta> atletas = (Map<Integer, Atleta>) atletasAttr.get();
                    error = this.sAssertEquals(5, atletas.size(), 0.33 * valorTotal,
                            "Error: el tamaño del mapa de atletas debería ser 5. En "
                            + "su lugar es " + atletas.size());
                    toThrow = toThrow(error, toThrow);
                }
            }
            boolean stop = true;
        } catch (Exception ex) {
            this.printlnAlways("\n*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...\n");
            this.printStackTraceUpc(ex);
        }
        this.printlnAlways("    Caso 3: comprobar que se ha invocado correctamente "
                + "al constructor con argumento inicializa a false y NO se han creado "
                + "los atletas");
        try {
            InterficieUsuario instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", false);
            Optional<Object> attr = this.getPrivateFieldValue(instance, "controlador");
            if (!attr.isPresent()) {
                error = this.sAssertTrue(false, 0, "Atributo de tipo Controlador = null!");
                toThrow = toThrow(error, toThrow);
            } else {
                Controlador contr = (Controlador) attr.get();
                Optional<Object> atletasAttr = this.getPrivateFieldValue(contr, "atletas");
                if (!atletasAttr.isPresent()) {
                    error = this.sAssertTrue(false, 0, "No se ha creado el atributo \'atletas\' en "
                            + "el controlador = null!");
                    toThrow = toThrow(error, toThrow);
                } else {
                    Map<Integer, Atleta> atletas = (Map<Integer, Atleta>) atletasAttr.get();
                    error = this.sAssertEquals(0, atletas.size(), 0.33 * valorTotal,
                            "Error: el tamaño del mapa de atletas debería ser 0. En "
                            + "su lugar es " + atletas.size());
                    toThrow = toThrow(error, toThrow);
                }
            }
            boolean stop = true;
        } catch (Exception ex) {
            this.printlnAlways("\n*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...\n");
            this.printStackTraceUpc(ex);
        }

        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    /**
     * Test of inscribirAtleta method, of class InterficieUsuario.
     */
    @Test
    public void test02_inscribirAtleta() {
        double valorTotal = 1.0;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;

        this.printlnAlways("\nInterficieUsuario::"
                + "inscribirAtleta(...). Valor: " + valorTotal);

        try {
            this.printlnAlways("    Caso 1: comprobar que se invoca a "
                    + "método inscribirAtleta() de clase Controlador, "
                    + "pasándole valores adecuados como parámetro.");
            InterficieUsuario instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", false);
            this.setPrivateField(instance, "controlador", this.mockControlador);
            Mockito.spy(this.mockControlador);

            try {
                String[] args = {"ia", "Nom. A", "Nac. A"};
                instance.inscribirAtleta(args);
                Mockito.verify(this.mockControlador).inscribirAtleta("Nom. A", "Nac. A");
                error = this.sAssertTrue(true, 1 * valorTotal, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::inscribirAtleta() debería "
                        + "invocar a Controlador::inscribirAtleta(), "
                        + "pasándole los valores adecuados como parámetro.");
                toThrow = toThrow(error, toThrow);
            }

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
     * Test of mostrarCompeticion method, of class InterficieUsuario.
     */
    @Test
    public void test03_mostrarCompeticion() {
        double valorTotal = 1.0;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;

        this.printlnAlways("\nInterficieUsuario::"
                + "mostrarCompeticion(...). Valor: " + valorTotal);

        try {
            this.printlnAlways("     Caso 1: comprobar que se invoca a "
                    + "método getInfoCompeticion() de clase Controlador.");
            InterficieUsuario instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", false);
            this.setPrivateField(instance, "controlador", this.mockControlador);
            Mockito.spy(this.mockControlador);

            try {
                instance.mostrarCompeticion();
                Mockito.verify(this.mockControlador).getInfoCompeticion();
                error = this.sAssertTrue(true, 1 * valorTotal, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::mostrarCompeticion() debería "
                        + "invocar a Controlador::getInfoCompeticion().");
                toThrow = toThrow(error, toThrow);
            }

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
     * Test of mostrarAtleta method, of class InterficieUsuario.
     */
    @Test
    public void test04_mostrarAtleta() {
        double valorTotal = 1.0;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;

        this.printlnAlways("\nInterficieUsuario::"
                + "mostrarAtleta(...). Valor: " + valorTotal);

        try {
            this.printlnAlways("    Caso 1: comprobar que se invoca a "
                    + "método getInfoAtleta() de clase Controlador y que "
                    + "recibe correctamente número de inscripción.\n");
            InterficieUsuario instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", false);
            this.setPrivateField(instance, "controlador", this.mockControlador);
            Mockito.spy(this.mockControlador);

            try {
                String[] args = {"ma", "124"};
                instance.mostrarAtleta(args);
                Mockito.verify(this.mockControlador).getInfoAtleta(124);
                error = this.sAssertTrue(true, 1 * valorTotal, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::mostrarAtleta() debería "
                        + "invocar a Controlador::getInfoAtletaAtleta(), "
                        + "pasándole el valor adecuado como parámetro.");
                toThrow = toThrow(error, toThrow);
            }

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
     * Test of anyadirMarcaEnEventoDeUnAtleta method, of class
     * InterficieUsuario.
     */
    @Test
    public void test05_anyadirMarcaEnEventoDeUnAtleta() {
        double valorTotal = 1.0;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;

        this.printlnAlways("\nInterficieUsuario::"
                + "anyadirMarcaEnEventoDeUnAtleta(...). Valor: " + valorTotal);

        try {
            InterficieUsuario instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", false);
            this.setPrivateField(instance, "controlador", this.mockControlador);
            this.setPrivateField(instance, "console", this.mockPrintStream);
            Mockito.spy(this.mockControlador);
            Mockito.spy(this.mockPrintStream);

            this.printlnAlways("    Caso 1: comprobar que se invoca método "
                    + "anyadirMarcaEnEventoDeUnAtleta() de clase Controlador. "
                    + "Además, se muestra el mensaje adecuado por la consola cuando "
                    + "no hay atletas inscritos en la competición.");

            try {
                String[] args = {"am", "1", "0", "0"};
                instance.anyadirMarcaEnEventoDeUnAtleta(args);
                Mockito.verify(this.mockControlador).anyadirMarcaEnEventoDeUnAtleta(1, 0, 0);
                Mockito.verify(this.mockPrintStream).println("ERROR: Aún no hay ningún atleta inscrito.");
                error = this.sAssertTrue(true, 0.25 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::anyadirMarcaEnEventoDeUnAtleta() parece "
                        + "no invocar el método adecuado de la clase Controlador. O puede "
                        + "ser que no se acabe mostrando el mensaje adecuado por la "
                        + "consola del sistema.");
                toThrow = toThrow(error, toThrow);
            }

            this.printlnAlways("    Caso 2:  comprobar que se invoca método "
                    + "anyadirMarcaEnEventoDeUnAtleta() de clase Controlador. "
                    + "Además, se muestra el mensaje adecuado por la consola cuando "
                    + "el número de inscripción es erróneo.");

            try {
                String[] args = {"am", "-1", "0", "0"};
                instance.anyadirMarcaEnEventoDeUnAtleta(args);
                Mockito.verify(this.mockControlador).anyadirMarcaEnEventoDeUnAtleta(-1, 0, 0);
                Mockito.verify(this.mockPrintStream).println("ERROR: El número de inscripción es erróneo.");
                error = this.sAssertTrue(true, 0.25 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::anyadirMarcaEnEventoDeUnAtleta() parece "
                        + "no invocar el método adecuado de la clase Controlador. O puede "
                        + "ser que no se acabe mostrando el mensaje adecuado por la "
                        + "consola del sistema.");
                toThrow = toThrow(error, toThrow);
            }

            this.printlnAlways("    Caso 3: comprobar que se invoca método "
                    + "anyadirMarcaEnEventoDeUnAtleta() de clase Controlador. "
                    + "Además, se muestra el mensaje adecuado por la consola cuando "
                    + "el tipo de evento es erróneo.");

            try {
                String[] args = {"am", "1", "-1", "0"};
                instance.anyadirMarcaEnEventoDeUnAtleta(args);
                Mockito.verify(this.mockControlador).anyadirMarcaEnEventoDeUnAtleta(1, -1, 0);
                Mockito.verify(this.mockPrintStream).println("ERROR: Número de tipo de evento erróneo.");
                error = this.sAssertTrue(true, 0.25 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::anyadirMarcaEnEventoDeUnAtleta() parece "
                        + "no invocar el método adecuado de la clase Controlador. O puede "
                        + "ser que no se acabe mostrando el mensaje adecuado por la "
                        + "consola del sistema.");
                toThrow = toThrow(error, toThrow);
            }

            this.printlnAlways("    Caso 4:  comprobar que se invoca método "
                    + "anyadirMarcaEnEventoDeUnAtleta() de clase Controlador. "
                    + "Además, se muestra el mensaje adecuado por la consola cuando "
                    + "la marca ha podido añadirse.");

            try {
                String[] args = {"am", "1", "0", "12.25"};
                instance.anyadirMarcaEnEventoDeUnAtleta(args);
                Mockito.verify(this.mockControlador).anyadirMarcaEnEventoDeUnAtleta(1, 0, 12.25);
                Mockito.verify(this.mockPrintStream).println("Marca añadida");
                error = this.sAssertTrue(true, 0.25 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::anyadirMarcaEnEventoDeUnAtleta() parece "
                        + "no invocar el método adecuado de la clase Controlador. O puede "
                        + "ser que no se acabe mostrando el mensaje adecuado por la "
                        + "consola del sistema.");
                toThrow = toThrow(error, toThrow);
            }

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
     * Test of mostrarClasificacion method, of class InterficieUsuario.
     */
    @Test
    public void test06_mostrarClasificacion() {
        double valorTotal = 1.0;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;

        this.printlnAlways("\nInterficieUsuario::"
                + "mostrarClasificacion(...). Valor: " + valorTotal);

        try {
            InterficieUsuario instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", false);
            this.setPrivateField(instance, "controlador", this.mockControlador);
            Mockito.spy(this.mockControlador);

            this.printlnAlways("    Caso 1: comprobar que se invoca a "
                    + "método getClasificacion() de clase Controlador, "
                    + "pasándole el valor adecuado como parámetro.");

            try {
                String[] args = {"mc", "3"};
                instance.mostrarClasificacion(args);
                Mockito.verify(this.mockControlador).getClasificacion(3);
                error = this.sAssertTrue(true, 0.5 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::mostrarClasificacion() parece "
                        + "no invocar el método adecuado de la clase "
                        + "Controlador o pasarle el valor adecuado como parámetro.");
                toThrow = toThrow(error, toThrow);
            }

            this.printlnAlways("    Caso 2: comprobar que se muestra por la consola "
                    + "la información que devuelve el método getClasificacion() de "
                    + "clase Controlador.");

            instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", true);
            this.setPrivateField(instance, "console", this.mockPrintStream);
            Mockito.spy(this.mockPrintStream);

            try {
                String[] args = {"mc", "3"};
                instance.mostrarClasificacion(args);
                Mockito.verify(this.mockPrintStream).println("1 ALG Larbi Bourrada\n"
                        + "2 KAZ Dimitriy Karpov\n"
                        + "3 FRA Kevin Mayer\n");
                error = this.sAssertTrue(true, 0.5 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::mostrarClasificacion() parece "
                        + "no invocar el método adecuado de la clase "
                        + "Controlador o pasarle el valor adecuado como parámetro.");
                toThrow = toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0, "Error: el controlador nor ha "
                        + "invocado a println() con el String que muestra a los "
                        + "tres primeros");
                toThrow = toThrow(error, toThrow);
            }
        } catch (Throwable ex) {
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
     * Test of ejecutaComando method, of class InterficieUsuario.
     */
    @Test
    public void test07_ejecutaComando() {
        double valorTotal = 1.0;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;

        this.printlnAlways("\nInterficieUsuario::"
                + "ejecutaComando(...). Valor: " + valorTotal);

        this.printlnAlways("    Caso 1: comprobar que el método detecta "
                + "adecuadamente algunos comandos incorrectos.");

        try {
            InterficieUsuario instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", false);
            this.setPrivateField(instance, "console", this.mockPrintStream);
            this.setPrivateField(instance, "controlador", this.mockControlador);
            Mockito.spy(this.mockPrintStream);
            Mockito.spy(this.mockControlador);

            try {
                instance.ejecutaComando("");            //Entrada vacía, ergo comando erróneo
                Mockito.verify(this.mockPrintStream).println(InterficieUsuario.CMD_ERRONEO_STR);
                error = this.sAssertTrue(true, 0.05 * valorTotal, "");
                Mockito.reset(this.mockPrintStream);
                instance.ejecutaComando("¡hola!");        //Comando erróneo
                Mockito.verify(this.mockPrintStream).println(InterficieUsuario.CMD_ERRONEO_STR);
                error = this.sAssertTrue(true, 0.05 * valorTotal, "");
                Mockito.reset(this.mockPrintStream);
                instance.ejecutaComando("hola:¡hola!");   //Comando erróneo
                Mockito.verify(this.mockPrintStream).println(InterficieUsuario.CMD_ERRONEO_STR);
                error = this.sAssertTrue(true, 0.05 * valorTotal, "");
                Mockito.reset(this.mockPrintStream);
                instance.ejecutaComando("ia:nombre");   //Comando erróneo: falta argumento
                Mockito.verify(this.mockPrintStream).println(InterficieUsuario.CMD_ERRONEO_STR);
                error = this.sAssertTrue(true, 0.05 * valorTotal, "");
                Mockito.reset(this.mockPrintStream);
                instance.ejecutaComando("ia:nombre:nacionalidad:¡hola!"); //Comando erróneo: sobra argumento
                Mockito.verify(this.mockPrintStream).println(InterficieUsuario.CMD_ERRONEO_STR);
                error = this.sAssertTrue(true, 0.05 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::ejecutaComando() parece "
                        + "no detectar e indicar como erróneo el comando introducido");
                toThrow = toThrow(error, toThrow);
            }

            this.printlnAlways("    Caso 2: comprobar que el comando ia acaba invocando el "
                    + "método adecuado de la clase Controlador, pasándole los valores "
                    + "correctos como parámetro.");

            try {
                instance.ejecutaComando("ia:nombre:nacionalidad");
                Mockito.verify(this.mockControlador).inscribirAtleta("nombre", "nacionalidad");
                error = this.sAssertTrue(true, 0.15 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::ejecutaComando() parece "
                        + "no invocar el método adecuado de la clase "
                        + "Controlador al introduir el comando ia:nombre:nacionalidad");
                toThrow = toThrow(error, toThrow);
            }

            this.printlnAlways("    Caso 3: comprobar que el comando mc acaba invocando el "
                    + "método adecuado de la clase Controlador, pasándole los valores "
                    + "correctos como parámetro.");

            try {
                instance.ejecutaComando("mc");
                Mockito.verify(this.mockControlador).getInfoCompeticion();
                error = this.sAssertTrue(true, 0.15 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::ejecutaComando() parece "
                        + "no invocar el método adecuado de la clase "
                        + "Controlador al introduir el comando mc");
                toThrow = toThrow(error, toThrow);
            }

            this.printlnAlways("    Caso 4: comprobar que el comando ma acaba invocando el "
                    + "método adecuado de la clase Controlador, pasándole los valores "
                    + "correctos como parámetro.");

            try {
                instance.ejecutaComando("ma:12");
                Mockito.verify(this.mockControlador).getInfoAtleta(12);
                error = this.sAssertTrue(true, 0.15 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::ejecutaComando() parece "
                        + "no invocar el método adecuado de la clase "
                        + "Controlador al introduir el comando ma:12");
                toThrow = toThrow(error, toThrow);
            }

            this.printlnAlways("    Caso 5: comprobar que el comando am acaba invocando el "
                    + "método adecuado de la clase Controlador, pasándole los valores "
                    + "correctos como parámetro.");

            try {
                instance.ejecutaComando("am:0:1:16.79");
                Mockito.verify(this.mockControlador).anyadirMarcaEnEventoDeUnAtleta(0, 1, 16.79);
                error = this.sAssertTrue(true, 0.15 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::ejecutaComando() parece "
                        + "no invocar el método adecuado de la clase "
                        + "Controlador al introduir el comando am:0:1:16.79");
                toThrow = toThrow(error, toThrow);
            }

            try {
                instance.ejecutaComando("cl:3");
                Mockito.verify(this.mockControlador).getClasificacion(3);
                error = this.sAssertTrue(true, 0.15 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::ejecutaComando() parece "
                        + "no invocar el método adecuado de la clase "
                        + "Controlador al introduir el comando cl:3");
                toThrow = toThrow(error, toThrow);
            }

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
     * Test of inicializaConAtletasYMarcasInicialesDesdeArchivo method, of class
     * InterficieUsuario.
     */
    @Test
    public void test08_inicializaConAtletasYMarcasInicialesDesdeArchivo() {
        double valorTotal = 3.0;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;

        this.printlnAlways("\nInterficieUsuario::"
                + "inicializaConAtletasYMarcasInicialesDesdeArchivo(...). Valor: " + valorTotal);

        try {
            this.printlnAlways("\n    Caso 1: comprobar que se han cargado adecuadamente "
                    + "todos los atletas del fichero atletasymarcas.txt.");
            try {
                InterficieUsuario instance = new InterficieUsuario("UnaCompeticion:20250330:Valencia", true);
                this.setPrivateField(instance, "console", this.mockPrintStream);
                Mockito.spy(this.mockPrintStream);
                String[] args = {"mc", "5"};
                instance.mostrarClasificacion(args);
                Mockito.verify(this.mockPrintStream).println("1 ALG Larbi Bourrada\n"
                        + "2 KAZ Dimitriy Karpov\n"
                        + "3 FRA Kevin Mayer\n"
                        + "4 USA Ashton Eaton\n"
                        + "5 AUS Ashley Moloney\n");

                error = this.sAssertTrue(true, 1.0 * valorTotal, "");
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método InterficieUsuario::inicializaConAtletasYMarcasInicialesDesdeArchivo() parece "
                        + "no leer de forma adecuada la información contenida en el fichero de texto "
                        + "atletasymarcas.txt.\n");
                toThrow = toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0, "Error: el controlador no ha "
                        + "invocado a println() con el String que muestra a los "
                        + "tres primeros");
                toThrow = toThrow(error, toThrow);
            }
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }
}
