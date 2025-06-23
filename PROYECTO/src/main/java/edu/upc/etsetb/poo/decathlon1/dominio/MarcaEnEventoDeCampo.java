package edu.upc.etsetb.poo.decathlon1.dominio;

public abstract class MarcaEnEventoDeCampo extends MarcaEnEvento {

 
    public MarcaEnEventoDeCampo(double marca) throws MarcaNegativaException {
        super(marca);
    }

    @Override
    public double calcularPuntosEvento(double paramA, double paramB, double paramC, double marca) {
        double puntosCalculados = 0;
        if (marca > paramB) {
            puntosCalculados = paramA * Math.pow(marca - paramB, paramC);
        } else {
            puntosCalculados = 0;
        }
        this.puntos = (int) Math.floor(puntosCalculados);
        return puntosCalculados;
    }
}
