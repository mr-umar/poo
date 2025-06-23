/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1.iu;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 *
 * @author JuanCarlos
 */
public class AutoRunnerDesdeMemoria {

    private static String comandos = "UnaCompeticion:20250330:Valencia\nAM:2:2:15.16\nAY\nZZ\n\nMC\nMA:6\nMA:1\nIA:Atleta-6:Pais-6\n"+
        "CL\nAM:6:8:15.16\nAM:6:0:11.278\nAM:6:1:694\nAM:6:2:15.16\nAM:6:3: 199\n"+
        "AM:6:4:50.32\nMA:6\nIA:Atleta-7:Pais-7\nAM:7:0:10.395\nAM:7:1:776\n"+
        "AM:7:2:18.40\nAM:7:3:221\nAM:7:4:46.17\nMA:7\nMA:1\nMA:2\nMA:3\n"+
        "CL:0\nCL:3\nCL:2\nAY\nFI";

    public static void main(String[] args) {
        try {
            System.out.println("Programa para la gestión de una competición de decathlon");
            System.out.println("Para simplificar sólo tendremos las 5 prubas que se celebran el primer día");
            System.out.println("Cuidado: Tu configuración de sistema puede tener como carácter decimal '.' o ','.");
            System.out.println("Esta clase leerá todos los datos de un String que contiene todos los comandos y "
                    + "los ejecutará automáticamente de principio a fin sin intervención humana.\n"
                    + "La ejecución comenzará en 1,5 segundos...");
            Thread.sleep(1500);
            Scanner lectorComandos = new Scanner(new ByteArrayInputStream(comandos.getBytes()));
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
