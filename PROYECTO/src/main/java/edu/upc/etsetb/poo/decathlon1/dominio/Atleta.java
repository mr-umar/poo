package edu.upc.etsetb.poo.decathlon1.dominio;

/**
 * Clase para gestionar la información de un atleta
 */
public class Atleta {

    private final String nombre;
    private final String nacionalidad;
    private final int numInscripcion;
    /**
     * Cada posición se corresponde a un evento.
     */
    private final MarcaEnEvento[] marcas;
    private int puntos;

    /**
     * Método constructor de la clase
     *
     * @param nombre Nombre del Atleta.
     * @param nacionalidad Nacionalidad del Atleta.
     * @param numInscripcion Número de Inscripción del Atleta.
     */
    public Atleta(String nombre, String nacionalidad, int numInscripcion) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.numInscripcion = numInscripcion;
        this.marcas = new MarcaEnEvento[MarcaEnEvento.NUM_EVENTOS];
        this.puntos = 0;
    }

    /**
     * Método getter.
     *
     * @return Devuelve el nombre del atleta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método getter.
     *
     * @return Devuelve la nacionalidad del atleta.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Método getter.
     *
     * @return Devuelve el número de inscripción del atleta.
     */
    public int getNumInscripcion() {
        return numInscripcion;
    }

    /**
     * Método getter.
     *
     * @return Devuelve los puntos totales del atleta.
     */
    public int getPuntos() {
        return puntos;
    }

    
    public void anyadirMarcaEnEvento(int evento, double marca) throws MarcaNegativaException {
        if (marca < 0) {
            throw new MarcaNegativaException("La marca no puede ser negativa: " + marca);
        }
        switch (evento) {
            case MarcaEnEvento.CIEN_METROS:
                this.marcas[evento] = new MarcaEnEvento100m(marca);
                break;
            case MarcaEnEvento.SALTO_DE_LONGITUD:
                this.marcas[evento] = new MarcaEnEventoSaltoLongitud(marca);
                break;
            case MarcaEnEvento.LAZAMIENTO_DE_PESO:
                this.marcas[evento] = new MarcaEnEventoLanzamientoPeso(marca);
                break;
            case MarcaEnEvento.SALTO_DE_ALTURA:
                this.marcas[evento] = new MarcaEnEventoSaltoAltura(marca);
                break;
            case MarcaEnEvento.CUATROCIENTOS_METROS:
                this.marcas[evento] = new MarcaEnEvento400m(marca);
                break;
            default:
              
                break;
        }
        this.calcularPuntos();
    }

    /**
     * Recalcula los puntos totales obtendos por el atleta hasta el momento.
     * Recorre todas las marcas de todos los eventos y suma sus puntos.
     */
    public void calcularPuntos() {
        this.puntos = 0;
        for (MarcaEnEvento marcaEnEvento : marcas) {
            if (marcaEnEvento != null) {
                this.puntos += marcaEnEvento.getPuntos();
            }
        }
    }

    /**
     * Método toString() de la clase.
     *
     * @return Devuelve un String con la información del Atleta.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Número de inscripción: ").append(this.numInscripcion).append("\n");
        sb.append("Nombre: ").append(this.nombre).append("\n");
        sb.append("Nacionalidad:").append(this.nacionalidad).append("\n");
        for (int i = 0; i < this.marcas.length; i++) {
            if (this.marcas[i] != null) {
                sb.append(this.marcas[i].toString()).append("\n");
            }
        }
        sb.append("\nPuntos totales: ").append(this.puntos).append("\n");
        return sb.toString();
    }
}
