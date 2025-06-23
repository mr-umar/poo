package edu.upc.etsetb.poo.decathlon1.dominio;

/**
 * Clase para gestionar la marca obtenida en un evento por un atleta.
 */
public abstract class MarcaEnEvento {

    /**
     * Código para el evento 100 metros lisos.
     */
    public static final int CIEN_METROS = 0;
    /**
     * Código para el evento salto de longitud.
     */
    public static final int SALTO_DE_LONGITUD = 1;
    /**
     * Código para el evento lanzamiento de peso.
     */
    public static final int LAZAMIENTO_DE_PESO = 2;
    /**
     * Código para el evento salto de altura.
     */
    public static final int SALTO_DE_ALTURA = 3;
    /**
     * Código para el evento 400 metros lisos.
     */
    public static final int CUATROCIENTOS_METROS = 4;
    /**
     * Número total de eventos (5).
     */
    public static final int NUM_EVENTOS = 5;

    protected int evento; 
    protected final double marca; 
    protected int puntos; 

    /**
     * Método constructor de la clase
     *
     * @param marca Marca. La marca (o performance (o P)) es la marca obtenida
     * por el atleta, medida en segundos (eventos de pista, es decir, carreras),
     * metros (lanzamientos), o centímetros (saltos).
     * @throws MarcaNegativaException si la marca es negativa.
     */
    public MarcaEnEvento(double marca) throws MarcaNegativaException {
        if (marca < 0) {
            throw new MarcaNegativaException("La marca no puede ser negativa: " + marca);
        }
        this.marca = marca;
        this.puntos = 0; 
    }

    /**
     * Método getter. Devuelve los puntos de MarcaEnEvento.
     *
     * @return Devuelve los puntos de MarcaEnEvento.
     */
    public int getPuntos() {
        return this.puntos;
    }

    public abstract double calcularPuntosEvento(double paramA, double paramB, double paramC, double marca);

    /**
     * Devuelve un String con las unidades en las que se mide una marca de este
     * tipo de evento: segundos (para eventos de pista), metros (para
     * lanzamientos), y centímetros (para saltos).
     *
     * @param evento El tipo de evento.
     * @return El String con el tipo de únidades ("segundos", "metros" o
     * "centímetros".
     */
    public static String getUnidadMarcaEnEvento(int evento) {
        switch (evento) {
            case CIEN_METROS:
            case CUATROCIENTOS_METROS:
                return "segundos";
            case LAZAMIENTO_DE_PESO:
                return "metros";
            case SALTO_DE_LONGITUD:
            case SALTO_DE_ALTURA:
                return "centimetros";
            default:
                return null;
        }
    }

    /**
     * Devuelve un String con la lista de eventos y sus números de evento
     * correspondiente.
     *
     * @return Dicho String.
     */
    public static String getListaEventos() {
        return "Lista de eventos:\n" +
               "[" + CIEN_METROS + "] 100 metros lisos\n" +
               "[" + SALTO_DE_LONGITUD + "] Salto de longitud\n" +
               "[" + LAZAMIENTO_DE_PESO + "] Lanzamiento de peso\n" +
               "[" + SALTO_DE_ALTURA + "] Salto de altura\n" +
               "[" + CUATROCIENTOS_METROS + "] 400 metros lisos\n";
    }

    /**
     * Método toString() de la clase.
     *
     * @return String con la información de la marca; a continuación se
     * muestra un ejemplo:<br>
     * 100 metros lisos:     marca=11.278 segundos, puntos=800
     */
    @Override
    public String toString() {
        String eventoString;
        switch (this.evento) {
            case CIEN_METROS:
                eventoString = "100 metros lisos";
                break;
            case SALTO_DE_LONGITUD:
                eventoString = "Salto de longitud";
                break;
            case LAZAMIENTO_DE_PESO:
                eventoString = "Lanzamiento de peso";
                break;
            case SALTO_DE_ALTURA:
                eventoString = "Salto de altura";
                break;
            case CUATROCIENTOS_METROS:
                eventoString = "400 metros lisos";
                break;
            default:
                eventoString = "Evento desconocido";
                break;
        }
        String unidad = getUnidadMarcaEnEvento(this.evento);

        int paddingLength = 21 - (eventoString.length() + 1);
        String padding = "";
        if (paddingLength > 0) {
            padding = String.format("%" + paddingLength + "s", "");
        }

        return eventoString + ":" + padding + "marca=" + this.marca + " " + unidad + ", puntos=" + this.puntos;
    }

    public int getEvento() {
        return evento;
    }
}
