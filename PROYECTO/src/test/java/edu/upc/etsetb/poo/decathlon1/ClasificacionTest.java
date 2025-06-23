/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.decathlon1;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.corrector.TestAll;
import edu.upc.etsetb.poo.decathlon1.dominio.Atleta;
import edu.upc.etsetb.poo.decathlon1.dominio.Clasificacion;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class ClasificacionTest extends SuperClassForTests{
    
    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public ClasificacionTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "Clasificacion");
        nota.put("Clasificacion", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01_Constructor(){
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 2; //CAMBIADO
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nClasificacion::"
                + "Clasificacion(...). Valor: " + valorTotal);
        

        Clasificacion instance = null;
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            //CADA PRUEBA INVOCARÁ A ALGÚN MÉTODO DE SuperClassForTests y
            //algún sAsserts según el patrón que sigue:
            //error = this.sAssert....
            //toThrow = toThrow(error, toThrow);
            int numAtletas = 2;
            instance = new Clasificacion(numAtletas);
            this.checkAttributeAfterConstructor(instance, "numAtletas", numAtletas,
                    valorTotal, 0.2, 0.2, 1);    

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        try {
            System.out.println("\tTest 3: Comprobación de existencia del "
                    + "atributo de nombre \'atletas\' (20%)"); // TODO: Modificar puntaje?
            error = this.checkPrivateFieldExists(instance, "atletas", valorTotal * 0.2, null);
            toThrow = toThrow(error, toThrow);
            if (error == null) {
                System.out.println("\tTest 4: Comprobación de que el atributo "
                        + "de nombre \'atletas\' es una LinkedList de atletas (20%).");
                error = this.checkPrivateFieldIsOfASpecificClass(instance, 
                        "atletas", java.util.LinkedList.class, valorTotal * 0.2, null); // TODO: debe ser una linkedlist siempre?
                toThrow = toThrow(error, toThrow);
                
                Optional<Object> attrVal = this.getPrivateFieldValue(instance, "atletas");
                System.out.println("\tTest 5: Comprobación de que \'atletas\' "
                        + "al construirse es una lista vacía en vez de NULL (20%).");
                if (attrVal.isPresent()) {
                    LinkedList<Atleta> atletas = (LinkedList<Atleta>) attrVal.get(); // TODO: qué pasa si hacen otro tipo de lista?
                    //MarcaEnEvento[] marcas = (MarcaEnEvento[]) attrVal.get();
                    
                    error = this.sAssertEquals(atletas.size(), 0,
                            valorTotal * 0.2 , "El atributo \'atletas\' debe ser "
                            + "una lista vacía al construirse. En su lugar, su dimensión es " + atletas.size());
                    toThrow = toThrow(error, toThrow);
                    

                } else {
                    error = this.sAssertTrue(false, 0, "El atributo \'atletas\' tiene un valor "
                            + "null en lugar de referenciar a una lista de atletas.");
                    toThrow = toThrow(error, toThrow); 
                }
            }
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }


        
        //DESPUÉS DE TODAS LAS PRUEBAS AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);        
    }

    /**
     * Test of anyadirAClasificacion method, of class Clasificacion.
     */
    @Test
    public void test02_anyadirAClasificacion(){
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 5; // CAMBIADO
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nClasificacion::"
                + "anyadirAClasificacion(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        
        Clasificacion instance = null;
        
        
        try {
            int numAtletas = 3;
            instance = new Clasificacion(numAtletas);
            
            // Posibles fallos:
            // - que no añade.
            // - que no haga caso a numAtletas.
            // - que no esté ordenado.
            
            Atleta a1 = new Atleta("nombre1", "nacionalidad1", 10);
            a1.anyadirMarcaEnEvento(0, 5);
            Atleta a2 = new Atleta("nombre2", "nacionalidad2", 20);
            a2.anyadirMarcaEnEvento(0, 4);
            Atleta a3 = new Atleta("nombre3", "nacionalidad3", 30);
            a3.anyadirMarcaEnEvento(0, 3);
            Atleta a4 = new Atleta("nombre4", "nacionalidad4", 40);
            a4.anyadirMarcaEnEvento(0, 2);
            instance.anyadirAClasificacion(a1);
            instance.anyadirAClasificacion(a2);
                     
            // MIRANDO QUE AÑADA BIEN LOS OBJETOS.
            Optional<Object> attrVal = this.getPrivateFieldValue(instance, "atletas");
            LinkedList<Atleta> atletas = (LinkedList<Atleta>) attrVal.get();
            
            this.println("\tTest 1: comprobar que se añaden los atletas en la "
                    + " lista \'atletas\' al invocar este método (20%)");
            error = this.sAssertEquals(2, atletas.size(),valorTotal*0.2, "La clasificación "
                    + "no se llena correctamente, puede que no se estén añadiendo "
                    + "los atletas.");
            toThrow = toThrow(error, toThrow);
            
            // MIRANDO QUE NO SE PASE Y NO AÑADA MÁS QUE NUMATLETAS (3)
            instance.anyadirAClasificacion(a3);
            instance.anyadirAClasificacion(a4);
            
  
            this.println("\tTest 2: comprobar que la lista nunca es más"
                    + " grande que el atributo \'numAtletas\' (40%)");
            error = this.sAssertEquals(3, atletas.size(),valorTotal*0.4, "La "
                    + "clasificación no debería ser más grande que \'numAtletas\'");
            toThrow = toThrow(error, toThrow);

            // MIRANDO QUE ESTE ORDENADO
            // que los puntos del primero sean > o = al segundo, del segundo al tercero, y así...
            this.println("\tTest 3: comprobar que la lista de atletas"
                    + " está ordenada (40%)");
            boolean condicion = true;
            for(int i=0;i<atletas.size()-1;i++) {
                if(atletas.get(i).getPuntos() < atletas.get(i+1).getPuntos()) {
                    condicion = false;
                    break;
                }
            }
            
            error = this.sAssertTrue(condicion, valorTotal*0.4, 
                    "La clasificación no está ordenada."); 
            toThrow = toThrow(error, toThrow);
          

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        
        //DESPUÉS DE TODAS LAS PRUEBAS AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);        
    }

    /**
     * Test of toString method, of class Clasificacion.
     */
    @Test
    public void test03_toString(){
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 3; // CAMBIADO
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        this.printlnAlways("\nClasificacion::"
                + "toString(...). Valor: " + valorTotal);
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            //CADA PRUEBA INVOCARÁ A ALGÚN MÉTODO DE SuperClassForTests y
            //algún sAsserts según el patrón que sigue:
            //error = this.sAssert....
            //toThrow = toThrow(error, toThrow);
            
            // Primera prueba: formato linea correcto
            this.println("\tTest 1: Formato de línea correcto (60%)");
            // Crear una clasificación
            int numAtletas = 3;
            Clasificacion instance = new Clasificacion(numAtletas);
            
            // Crear 1 atleta y darle unos puntos
            Atleta a1 = new Atleta("nombre1", "nacionalidad1", 10);
            a1.anyadirMarcaEnEvento(0,11.23);
            
            // Añadir el atleta a la clasificación
            instance.anyadirAClasificacion(a1);
            
            // Generar string
            String salida = instance.toString();
            //Comprobar que la información es la que corresponde en el formato adecuado
            String[] clasifLinea = salida.split(" ");
            String[] nombre = clasifLinea[2].split("\n");
            error = this.sAssertEquals(clasifLinea[0],"1",0.2*valorTotal, "La clasificación debería empezar con la posición del Atleta");
            toThrow = toThrow(error, toThrow);
            error = this.sAssertEquals(clasifLinea[1],a1.getNacionalidad(),0.2*valorTotal, "El segundo valor de la línea debería ser la nacionalidad");
            toThrow = toThrow(error, toThrow);
            error = this.sAssertEquals(nombre[0],a1.getNombre(),0.2*valorTotal, "El tercer valor de la línea debería ser el nombre");
            toThrow = toThrow(error, toThrow);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "El string generado deberia ser del tipo:\n"
                    + "num.clas nacionalidad nombre \n");
            this.printStackTraceUpc(ex);
        }
        try {
            //CADA PRUEBA INVOCARÁ A ALGÚN MÉTODO DE SuperClassForTests y
            //algún sAsserts según el patrón que sigue:
            //error = this.sAssert....
            //toThrow = toThrow(error, toThrow);
            
            // Segunda prueba: Se recorre toda la lista de atletas
            this.println("\tTest 2: Se recorre toda la lista de atletas (40%)");
            // Crear una clasificación
            int numAtletas = 3;
            Clasificacion instance = new Clasificacion(numAtletas);
            
            // Crear 3 atletas y darles unos puntos
            Atleta a1 = new Atleta("nombre1", "nacionalidad1", 10);
            a1.anyadirMarcaEnEvento(0,11.23);
            Atleta a2 = new Atleta("nombre2", "nacionalidad2", 20);
            a2.anyadirMarcaEnEvento(0,10.53);
            Atleta a3 = new Atleta("nombre3", "nacionalidad3", 30);
            a3.anyadirMarcaEnEvento(0,12.03);
            
            // Añadir los atletas a la clasificación
            instance.anyadirAClasificacion(a1);
            instance.anyadirAClasificacion(a2);
            instance.anyadirAClasificacion(a3);
            
            // Generar string
            String salida = instance.toString();
            //dividir por líneas
            String[] numLinea = salida.split("\n");
            
            //comprobar que hay tantas líneas como atletas
            error = this.checkFieldValue(instance, "numAtletas", numLinea.length,
                    0.4 * valorTotal, toThrow);
            toThrow = toThrow(error, toThrow);
            
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        //DESPUÉS DE TODAS LAS PRUEBAS AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
        throwIfAnError(toThrow);        
    }
    
}
