package edu.upc.etsetb.poo.decathlon1.casosdeuso;

import edu.upc.etsetb.poo.decathlon1.dominio.Atleta;
import edu.upc.etsetb.poo.decathlon1.dominio.Clasificacion;
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

/**
 * El controlador del programa. Os lo damos casi completamente implementado.
 * Deberéis implementar el código de los métodos que se os indica más abajo.
 */
public class Controlador {

    /**
     * El contenedor en el que se guardan los atletas inscritos en la
     * competición. La clave es su número de inscripción y el valor es el
     * objeto de tipo Atleta.
     */
    private final Map<Integer, Atleta> atletas;
    /**
     * La competición.
     */
    private final Competicion competicion;
    /**
     * La interfaz de usuario.
     */
    private final InterficieUsuario iu;

    /**
     * Método constructor de la clase.
     *
     * @param nombre El nombre de la competición.
     * @param fecha La fecha de la competición.
     * @param lugar El lugar de la competición.
     * @param iu La interfaz de usuario.
     * @param contrInitAtletasYMarcas Si es true, se invoca al método
     * inicializaConAtletasYMarcasIniciales(); si es false, no se le invoca.
     * @throws NoAtletasInscritosException Si contrInitAtletasYMarcas es true y ocurre un error.
     * @throws NumInscripcionException Si contrInitAtletasYMarcas es true y ocurre un error.
     * @throws TipoEventoException Si contrInitAtletasYMarcas es true y ocurre un error.
     * @throws MarcaNegativaException Si contrInitAtletasYMarcas es true y ocurre un error.
     */
    public Controlador(String nombre, String fecha, String lugar, InterficieUsuario iu, boolean contrInitAtletasYMarcas) throws NoAtletasInscritosException, NumInscripcionException, TipoEventoException, MarcaNegativaException {
        this.iu = iu;
        this.atletas = new HashMap<>();
        this.competicion = new Competicion(nombre, fecha, lugar);
        if (contrInitAtletasYMarcas) {
            this.inicializaConAtletasYMarcasIniciales();
        }
    }

    public void inicializaConAtletasYMarcasIniciales() throws NoAtletasInscritosException, NumInscripcionException, TipoEventoException, MarcaNegativaException {
        String[] nombres = {"Kevin Mayer", "Larbi Bourrada", "Dimitriy Karpov", "Ashton Eaton", "Ashley Moloney"};
        String[] nacionalidades = {"FRA", "ALG", "KAZ", "USA", "AUS"};

        for (int i = 0; i < nombres.length; i++) {
            this.inscribirAtleta(nombres[i], nacionalidades[i]);
        }

        double[][][] marcas = {
            { // Kevin Mayer (numInscripcion 1)
                {MarcaEnEvento.CIEN_METROS, 11.278}, {MarcaEnEvento.SALTO_DE_LONGITUD, 694},
                {MarcaEnEvento.LAZAMIENTO_DE_PESO, 15.16}, {MarcaEnEvento.SALTO_DE_ALTURA, 199},
                {MarcaEnEvento.CUATROCIENTOS_METROS, 50.32}
            },
            { // Larbi Bourrada (numInscripcion 2)
                {MarcaEnEvento.CIEN_METROS, 10.395}, {MarcaEnEvento.SALTO_DE_LONGITUD, 776},
                {MarcaEnEvento.LAZAMIENTO_DE_PESO, 18.40}, {MarcaEnEvento.SALTO_DE_ALTURA, 221},
                {MarcaEnEvento.CUATROCIENTOS_METROS, 46.17}
            },
            { // Dimitriy Karpov (numInscripcion 3)
                {MarcaEnEvento.CIEN_METROS, 10.827}, {MarcaEnEvento.SALTO_DE_LONGITUD, 736},
                {MarcaEnEvento.LAZAMIENTO_DE_PESO, 16.79}, {MarcaEnEvento.SALTO_DE_ALTURA, 210},
                {MarcaEnEvento.CUATROCIENTOS_METROS, 48.19}
            },
            { // Ashton Eaton (numInscripcion 4)
                {MarcaEnEvento.CIEN_METROS, 11.756}, {MarcaEnEvento.SALTO_DE_LONGITUD, 651},
                {MarcaEnEvento.LAZAMIENTO_DE_PESO, 13.53}, {MarcaEnEvento.SALTO_DE_ALTURA, 188},
                {MarcaEnEvento.CUATROCIENTOS_METROS, 52.58}
            }
        // Ashley Moloney no tiene marcas iniciales
        };

        for (int i = 0; i < marcas.length; i++) {
            int numInscripcionAtleta = i + 1; 
            for (int j = 0; j < marcas[i].length; j++) {
                int evento = (int) marcas[i][j][0];
                double marcaObtenida = marcas[i][j][1];
                this.anyadirMarcaEnEventoDeUnAtleta(numInscripcionAtleta, evento, marcaObtenida);
            }
        }
    }

    /**
     * Se crea un atleta y se inscribe en la competición
     *
     * @param nombre Nobre del Atleta.
     * @param nacionalidad Nacionalidad del Atleta.
     */
    public void inscribirAtleta(String nombre, String nacionalidad) {
        int numInscripcionNuevo = competicion.obtenerSiguienteNumInscripcion();
        Atleta atleta = new Atleta(nombre, nacionalidad, numInscripcionNuevo);
        this.atletas.put(numInscripcionNuevo, atleta);
    }

    /**
     * Devuelve un String con los datos de la competición.
     *
     * @return String con los datos de la competición.
     */
    public String getInfoCompeticion() {
        return this.competicion.toString() + "\nNúmero de inscritos: " + this.getNumInscritosEnCompeticion();
    }

    /**
     * Devuelve el número de inscritos en la competición.
     *
     * @return el número de inscritos en la competición.
     */
    public int getNumInscritosEnCompeticion() {
        return this.competicion.getNumInscritos();
    }

   
    public String getInfoAtleta(int numInscripcion) throws NoAtletasInscritosException, NumInscripcionException {
        if (this.competicion.getNumInscritos() == 0) {
            throw new NoAtletasInscritosException("ERROR: Aún no hay ningún atleta inscrito.");
        }
        if (numInscripcion < 1 || numInscripcion > this.competicion.getNumInscritos()) {
            throw new NumInscripcionException("ERROR: El número de inscripción es erróneo.");
        }
        Atleta atleta = this.atletas.get(numInscripcion);
        if (atleta == null) {
            throw new NumInscripcionException("ERROR: Atleta con número de inscripción " + numInscripcion + " no encontrado.");
        }
        return atleta.toString();
    }

    
    public void anyadirMarcaEnEventoDeUnAtleta(int numInscripcion, int evento, double marca) throws NoAtletasInscritosException, NumInscripcionException, TipoEventoException, MarcaNegativaException {
        if (this.competicion.getNumInscritos() == 0) {
            throw new NoAtletasInscritosException("ERROR: Aún no hay ningún atleta inscrito.");
        }
        if (numInscripcion < 1 || numInscripcion > this.competicion.getNumInscritos()) {
            throw new NumInscripcionException("ERROR: El número de inscripción es erróneo.");
        }
        if (evento < 0 || evento >= MarcaEnEvento.NUM_EVENTOS) {
            throw new TipoEventoException("ERROR: Número de tipo de evento erróneo.");
        }
        Atleta atleta = this.atletas.get(numInscripcion);
        if (atleta == null) {
            throw new NumInscripcionException("ERROR: Atleta con número de inscripción " + numInscripcion + " no encontrado.");
        }
        atleta.anyadirMarcaEnEvento(evento, marca);
    }

   
    public String getClasificacion(int numAtletas) throws NoAtletasInscritosException, NumeroDeAtletasException {
        if (this.competicion.getNumInscritos() == 0) {
            throw new NoAtletasInscritosException("ERROR: Aún no hay ningún atleta inscrito.");
        }
        if (numAtletas <= 0 || numAtletas > this.competicion.getNumInscritos()) {
            throw new NumeroDeAtletasException("ERROR: Número de atletas erróneo.");
        }

        Clasificacion clasificacion = new Clasificacion(numAtletas);
        for (Atleta atleta : this.atletas.values()) {
            clasificacion.anyadirAClasificacion(atleta);
        }
        return clasificacion.toString();
    }
}
