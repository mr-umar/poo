package edu.upc.etsetb.poo.decathlon1.iu;

import edu.upc.etsetb.poo.decathlon1.casosdeuso.Controlador;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaEnEvento;
import edu.upc.etsetb.poo.decathlon1.dominio.MarcaNegativaException;
import edu.upc.etsetb.poo.decathlon1.dominio.NoAtletasInscritosException;
import edu.upc.etsetb.poo.decathlon1.dominio.NumInscripcionException;
import edu.upc.etsetb.poo.decathlon1.dominio.NumeroDeAtletasException;
import edu.upc.etsetb.poo.decathlon1.dominio.TipoEventoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * La interficie de usuario del programa
 */
/*
 * https://en.wikipedia.org/wiki/Decathlon
 * https://es.wikipedia.org/wiki/%Decatl%C3%B3n
 */
public class InterficieUsuario {

    /**
     * Lector utilizado para leer los comandos introducidos por el usuario.
     */
    private Scanner lector;

    /**
     * El controlador.
     */
    private final Controlador controlador;

    /**
     * La consola del sistema. Siempre debe usarse para mostrar la información al
     * usuario.
     */
    private final PrintStream console = System.out;

    /**
     * Separador utilizado en los comandos de entrada.
     */
    public static final String SEPARADOR = ":";

    /**
     * Mensaje de error que notifica que no hay atletas inscritos.
     */
    public static final String NO_ATLETAS_INSCRITOS_STR
            = "ERROR: Aún no hay ningún atleta inscrito.";
    /**
     * Mensaje de error que notifica que el número de atletas es erróneo
     */
    public static final String NUM_ATLETAS_ERRONEO_STR
            = "ERROR: Número de atletas erróneo.";
    /**
     * Mensaje de error que notifica que el número de inscripción es erróneo.
     */
    public static final String NUM_INSCRIPCION_ERRONEO_STR
            = "ERROR: El número de inscripción es erróneo.";

    /**
     * Mensaje de error que notifica que el tipo de evento es erróneo.
     */
    public static final String TIPO_DE_EVENTO_ERRONEO_STR
            = "ERROR: Número de tipo de evento erróneo.";

    /**
     * Mensaje de error que notifica que el código de retorno del método es ilegal.
     */
    public static final String CODIGO_ILEGAL_STR
            = "ERROR: Código ilegal.";

    /**
     * Mensaje de error que notifica que el comando de entrada es erróneo.
     */
    public static final String CMD_ERRONEO_STR
            = "ERROR: Comando erróneo!";

    /**
     * Mensaje que notifica que la marca se ha añadido correctamente.
     */
    public static final String MARCA_ANYADIDA_STR = "Marca añadida";

    
    public InterficieUsuario(String detallesCompeticion, boolean contrInitAtletasYMarcas) throws NoAtletasInscritosException, NumInscripcionException, TipoEventoException, MarcaNegativaException, IOException {
        this.lector = new Scanner(System.in);
        String[] partes = detallesCompeticion.split(SEPARADOR);
        String nombre = "";
        String fecha = "";
        String lugar = "";

        if (partes.length > 0) {
            nombre = partes[0];
        }
        if (partes.length > 1) {
            fecha = partes[1];
        }
        if (partes.length > 2) {
            lugar = partes[2];
        }

        this.controlador = new Controlador(nombre, fecha, lugar, this, contrInitAtletasYMarcas);
    }

    /**
     * Inscribe un atleta con el nombre y la nacionalidad pasados en la segunda y
     * tercera posición del argumento args (que es un array de Strings).
     *
     * @param args Un array de Strings que en su segunda y tercera posición tiene el
     * nombre y la nacionalidad de un atleta respectivamente.
     */
    public void inscribirAtleta(String[] args) {
        String nombre = args[1];
        String nacionalidad = args[2];
        controlador.inscribirAtleta(nombre, nacionalidad);
    }

    /**
     * Obtiene los datos de la competición y los presenta por pantalla.
     */
    public void mostrarCompeticion() {
        console.println(controlador.getInfoCompeticion());
    }

    
    public void mostrarAtleta(String[] args) {
        try {
            int numInscripcion = Integer.parseInt(args[1]);
            console.println(controlador.getInfoAtleta(numInscripcion));
        } catch (NumberFormatException e) {
            console.println(CMD_ERRONEO_STR + " Número de inscripción debe ser un entero.");
        } catch (NoAtletasInscritosException e) {
            console.println(NO_ATLETAS_INSCRITOS_STR);
        } catch (NumInscripcionException e) {
            console.println(NUM_INSCRIPCION_ERRONEO_STR);
        }
    }

   
    public void anyadirMarcaEnEventoDeUnAtleta(String[] args) {
        try {
            int numInscripcion = Integer.parseInt(args[1]);
            int evento = Integer.parseInt(args[2]);
            double marca = Double.parseDouble(args[3]);
            controlador.anyadirMarcaEnEventoDeUnAtleta(numInscripcion, evento, marca);
            console.println(MARCA_ANYADIDA_STR);
        } catch (NumberFormatException e) {
            console.println(CMD_ERRONEO_STR + " Número de inscripción, evento o marca no son válidos.");
        } catch (NoAtletasInscritosException e) {
            console.println(NO_ATLETAS_INSCRITOS_STR);
        } catch (NumInscripcionException e) {
            console.println(NUM_INSCRIPCION_ERRONEO_STR);
        } catch (TipoEventoException e) {
            console.println(TIPO_DE_EVENTO_ERRONEO_STR);
            console.println("Eventos válidos:");
            console.println(MarcaEnEvento.getListaEventos());
        } catch (MarcaNegativaException e) {
            console.println(e.getMessage()); // El mensaje de MarcaNegativaException ya es descriptivo
        }
    }

    
    public void mostrarClasificacion(String[] args) {
        try {
            int numAtletas = Integer.parseInt(args[1]);
            String clasificacionStr = controlador.getClasificacion(numAtletas);
            console.println(clasificacionStr);
        } catch (NumberFormatException e) {
            console.println(CMD_ERRONEO_STR + " Número de atletas debe ser un entero.");
        } catch (NoAtletasInscritosException e) {
            console.println(NO_ATLETAS_INSCRITOS_STR);
        } catch (NumeroDeAtletasException e) {
            console.println(NUM_ATLETAS_ERRONEO_STR);
        }
    }

    /**
     * Presenta por consola el menú del programa.
     */
    public void mostrarOpciones() {
        console.println("\nOpciones disponibles:");
        console.println("  inscribir:" + "<nombre>" + SEPARADOR + "<nacionalidad>");
        console.println("  competicion");
        console.println("  atleta:" + "<num_inscripcion>");
        console.println("  marca:" + "<num_inscripcion>" + SEPARADOR + "<evento>" + SEPARADOR + "<marca>");
        console.println("      Eventos disponibles:");
        console.println("      " + MarcaEnEvento.getListaEventos().replace("\n", "\n      "));
        console.println("  clasificacion:" + "<num_atletas>");
        console.println("  opciones");
        console.println("  salir");
        console.println("Introduce comando (separando argumentos con '" + SEPARADOR + "'):");

    }

    /**
     * Este método recibe un comando y lo ejecuta. Si el comando pasado como
     * parámetro es erróneo, el método debe indicarlo mediante un mensaje. Utilizad
     * la constante de tipo String definida en la clase para ello.
     *
     * @param comando String con el comando.
     */
    public void ejecutaComando(String comando) {
        String[] partes = comando.split(SEPARADOR);
        String cmd = partes[0].toLowerCase(); // Convertir a minúsculas para ser insensible a mayúsculas

        switch (cmd) {
            case "inscribir":
            case "ia":
                if (partes.length == 3) {
                    inscribirAtleta(partes);
                } else {
                    console.println(CMD_ERRONEO_STR);
                }
                break;
            case "competicion":
            case "mc":
                if (partes.length == 1) {
                    mostrarCompeticion();
                } else {
                    console.println(CMD_ERRONEO_STR);
                }
                break;
            case "atleta":
            case "ma":
                if (partes.length == 2) {
                    mostrarAtleta(partes);
                } else {
                    console.println(CMD_ERRONEO_STR);
                }
                break;
            case "marca":
            case "am":
                if (partes.length == 4) {
                    anyadirMarcaEnEventoDeUnAtleta(partes);
                } else {
                    console.println(CMD_ERRONEO_STR);
                }
                break;
            case "clasificacion":
            case "cl":
                if (partes.length == 2) {
                    mostrarClasificacion(partes);
                } else {
                    console.println(CMD_ERRONEO_STR);
                }
                break;
            case "opciones":
            case "ay": // Añadido alias 'ay' para 'opciones'
                if (partes.length == 1) {
                    mostrarOpciones();
                } else {
                    console.println(CMD_ERRONEO_STR);
                }
                break;
            case "salir":
            case "fi": 
                break;
            default:
                console.println(CMD_ERRONEO_STR);
        }
    }

    /**
     * Muestra el menú y va pidiendo y ejecutando los comandos que el usuario va
     * introduciendo hasta que se introduce el comando de acabar la ejecución del
     * programa.
     */
    public void start() {
        lector = new Scanner(System.in);
        String comando;
        do {
            mostrarOpciones();
            console.print("> ");
            comando = lector.nextLine();
            ejecutaComando(comando);
        } while (!comando.equalsIgnoreCase("salir") && !comando.equalsIgnoreCase("fi"));
        lector.close();
    }

   
    public void inicializaConAtletasYMarcasInicialesDesdeArchivo() throws NoAtletasInscritosException, NumInscripcionException, TipoEventoException, MarcaNegativaException, IOException {
        String nombreFichero = "atletasymarcas.txt"; // Nombre del fichero según enunciado
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            linea = br.readLine();
            if (linea == null || !linea.trim().equalsIgnoreCase("ATLETAS")) {
                throw new IOException("Formato de fichero incorrecto: Se esperaba 'ATLETAS' al inicio.");
            }

            while ((linea = br.readLine()) != null && !linea.trim().toUpperCase().startsWith("MARCASDE")) {
                String[] datosAtleta = linea.split(SEPARADOR);
                if (datosAtleta.length == 2) {
                    controlador.inscribirAtleta(datosAtleta[0].trim(), datosAtleta[1].trim());
                } else {
                }
            }

            while (linea != null) {
                if (linea.trim().toUpperCase().startsWith("MARCASDE")) {
                    String[] partesCabeceraMarca = linea.split(SEPARADOR);
                    if (partesCabeceraMarca.length == 2) {
                        try {
                            int numInscripcionAtleta = Integer.parseInt(partesCabeceraMarca[1].trim());
                            for (int i = 0; i < MarcaEnEvento.NUM_EVENTOS; i++) {
                                linea = br.readLine();
                                if (linea == null) {
                                    throw new IOException("Formato de fichero incorrecto: Faltan marcas para el atleta " + numInscripcionAtleta);
                                }
                                String[] datosMarca = linea.split(",");
                                if (datosMarca.length == 2) {
                                    int evento = Integer.parseInt(datosMarca[0].trim());
                                    double marca = Double.parseDouble(datosMarca[1].trim());
                                    controlador.anyadirMarcaEnEventoDeUnAtleta(numInscripcionAtleta, evento, marca);
                                } else {
                                }
                            }
                        } catch (NumberFormatException e) {
                            throw new IOException("Formato de fichero incorrecto: Número de inscripción o datos de marca no válidos.", e);
                        }
                        linea = br.readLine(); 
                    } else {
                        linea = br.readLine();
                    }
                } else {
                     
                    linea = br.readLine();
                }
            }
        } catch (IOException e) {
            console.println("Error al leer el fichero " + nombreFichero + ": " + e.getMessage());
            throw e; 
        }
    }
}
