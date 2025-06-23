/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1.iu;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 *
 * @author JuanCarlos
 */
public class AutoRunnerDesdeArchivo {

    public static void main(String[] args) {
        try {
            System.out.println("Programa para la gestión de una competición de decathlon");
            System.out.println("Para simplificar sólo tendremos las 5 pruebas que se celebran el primer día");
            System.out.println("Cuidado: Tu configuración de sistema puede tener como carácter decimal '.' o ','.");
            System.out.println("Esta clase leerá todos los datos del archivo \'ComandosEjecucion.txt\' que contiene todos los comandos y "
                    + "los ejecutará automáticamente de principio a fin sin intervención humana.\n"
                    + "La ejecución comenzará en 1,5 segundos...");
            Thread.sleep(1500);
            Scanner lectorComandos = new Scanner(new FileInputStream(System.getProperty("user.dir")+"/ComandosEjecucion.txt"));
            String comando = lectorComandos.nextLine();
            //Pon a true el segundo argumento del constructor para que el 
            //Controlador invoque al método que inicializa los atletas y sus marcas 
            //automáticamente
            InterficieUsuario iu = new InterficieUsuario(comando, false);
            String[] partes = comando.split(":");
            String nombre = partes[0];
            String fecha = partes[1];
            String lugar = partes[2];

            System.out.println("============================================");
            iu.mostrarOpciones();
            while (lectorComandos.hasNextLine()) {
                System.out.println("Entra un comando");
                comando = lectorComandos.nextLine();
                System.out.println(">" + comando);
                try {
                    iu.ejecutaComando(comando);
                } catch (Exception ex) {
                    System.out.println("Error durante el procesado del comando. "
                            + "Excepción: " + ex.getClass().getSimpleName()
                            + ". Detalles: "+ ex.getMessage());
                }
            }
            lectorComandos.close();
        } catch (Exception ex) {
            System.out.println("¡ERROR!. Ha ocurrido un error de ejecución."
                    + " El programa finalizará su ejecución tras presentar la "
                    + "traz de las excepciones.");
            ex.printStackTrace();
        }
    }
}
