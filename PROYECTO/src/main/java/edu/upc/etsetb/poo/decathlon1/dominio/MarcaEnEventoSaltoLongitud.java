package edu.upc.etsetb.poo.decathlon1.dominio;

public class MarcaEnEventoSaltoLongitud extends MarcaEnEventoDeCampo {

    /**
     * Los 3 parámetros (A, B y C) de este evento en cuestión que forman parte
     * de las fórmulas que permiten calcular los puntos en función de una marca
     * para cada uno de dichos eventos; para más detalles, debéis consultar la
     * página web
     *
     * https://es.wikipedia.org/wiki/Decatl%C3%B3n#Sistema_de_puntos
     */
    public static final double A = 0.14354;
    public static final double B = 220.0;
    public static final double C = 1.40;

    /**
     * Método constructor de la clase.
     *
     * @param marca Marca. La marca (o performance (o P)) es la marca obtenida
     * por el atleta, medida en segundos (eventos de pista, es decir, carreras),
     * metros (lanzamientos), o centímetros (saltos).
     * @throws MarcaNegativaException si la marca es negativa.
     */
    public MarcaEnEventoSaltoLongitud(double marca) throws MarcaNegativaException {
        super(marca);
        this.evento = MarcaEnEvento.SALTO_DE_LONGITUD;
        calcularPuntosEvento(A, B, C, marca);
    }
}
