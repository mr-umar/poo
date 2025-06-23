package edu.upc.etsetb.poo.decathlon1.dominio;

public abstract class MarcaEnEventoDePista extends MarcaEnEvento {

    
    public MarcaEnEventoDePista(double marca) throws MarcaNegativaException {
        super(marca);
    }

   
    @Override
    public double calcularPuntosEvento(double paramA, double paramB, double paramC, double marca) {
        double puntosCalculados = 0;
        if (marca < paramB) {
            puntosCalculados = paramA * Math.pow(paramB - marca, paramC);
        } else {
            puntosCalculados = 0;
        }
        this.puntos = (int) Math.floor(puntosCalculados);
        return puntosCalculados;
    }
}
