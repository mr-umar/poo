/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1.iu;

import java.util.Scanner;

/**
 *
 * @author JuanCarlos
 */
public class RunnerDesdeTeclado {

    public static void main(String[] args) {
        try {
            System.out.println("Programa para la gestión de una competición de decathlon");
            System.out.println("Para simplificar sólo tendremos las 5 prubas que se celebran el primer día");
            System.out.println("Cuidado: Tu configuración de sistema puede tener como carácter decimal '.' o ','.");
            System.out.println("Esta clase leerá todos los datos del teclado y "
                    + "por tanto la ejecución requiere intervención humana...");
            Scanner lectorComandos = new Scanner(System.in);
            System.out.println("Introduce el nombre de la competición, la fecha "
                    + "en formato AAAMMMDD y el lugar, separando cada dato con "
                    + "el caracter \':\'");
            String comando = lectorComandos.nextLine();
            //Pon a false el segundo argumento del constructor para que el 
            //Controlador NO invoque al método que inicializa los atletas y sus marcas 
            //automáticamente
            InterficieUsuario iu = new InterficieUsuario(comando, true);
            String[] partes = comando.split(":");
            String nombre = partes[0];
            String fecha = partes[1];
            String lugar = partes[2];
            System.out.println("Nombre de competición: " + nombre);
            System.out.println("Fecha: " + fecha);
            System.out.println("Lugar: " + lugar);
            System.out.println("============================================");
            iu.mostrarOpciones();
            iu.mostrarOpciones();
            System.out.println(">>Entra un comando");
            comando = lectorComandos.nextLine();
            while (!comando.equalsIgnoreCase("FI")) {
                try {
                    iu.ejecutaComando(comando);
                } catch (Exception ex) {
                    System.out.println("Error durante el procesado del comando. "
                            + "Detalles: " + ex.getMessage());
                }
                System.out.println(">>Entra un comando");
                comando = lectorComandos.nextLine();
            }
        } catch (Exception ex) {
            System.out.println("¡ERROR!. Ha ocurrido un error de ejecución."
                    + " El programa finalizará su ejecución tras presentar la "
                    + "traz de las excepciones.");
            ex.printStackTrace();
        }
    }
}
