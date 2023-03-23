/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.ed03_imc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author BirtLH
 */
public class MainIMCTest {
    
    public MainIMCTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test para el método main de la clase MainIMC.
    */
    @Disabled("Deshabilitar por ahora")
    @Test
    public void testMain() {
        System.out.println("main");
        
        // Redirigimos una cadena de caracteres hacia la entrada por consola
        String input = "1,70\n55\n1,80\n100\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
         // Redireccionamos la salida por consola al objeto out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        // Llamamos al método main. El resultado del programa se almacena en out
        // Como los métodos de la clase MainIMC son estáticos, no hace falta instanciar un objeto
        // Llamamos a los métodos utilizando el nombre de la clase como hacemos con las clases Math, Scanner...
        String[] args = null;    
        MainIMC.main(args);
        
        // Generamos un String con el resultado esperado.
        // Se introduce un salto de línea que depende del SO para evitar problemas
        // En Linux y MacOS introducirá "\n"
        // En Windows introduce “\r\n”
        String expResult = "Este programa lee la altura y el peso de" + System.getProperty("line.separator");
        expResult += "una persona y calcula su IMC" + System.getProperty("line.separator");
        expResult += "su Indice de Masa Corporal." + System.getProperty("line.separator");
        expResult += System.getProperty("line.separator");
        
        expResult += "Introduce los datos de la siguiente persona" + System.getProperty("line.separator");
        expResult += "altura en metros:" + System.getProperty("line.separator");
        expResult += "peso en kilogramos:" + System.getProperty("line.separator");
        expResult += System.getProperty("line.separator");
        
        expResult += "Introduce los datos de la siguiente persona" + System.getProperty("line.separator");
        expResult += "altura en metros:" + System.getProperty("line.separator");
        expResult += "peso en kilogramos:" + System.getProperty("line.separator");
        expResult += System.getProperty("line.separator");
        
        expResult += "Persona #1 indice de masa corporal = 19.0" + System.getProperty("line.separator");
        expResult += "normal" + System.getProperty("line.separator");
        expResult += "Persona #2 indice de masa corporal = 30.9" + System.getProperty("line.separator");
        expResult += "obeso" + System.getProperty("line.separator");
        
        // Ejecutamos el test
        // Comparamos el String esperado con el almacenado en out después de ejecutar el método
        assertEquals(expResult, out.toString());       
    }

    /**
     * Test del método presentacion de la clase MainIMC.
     */
    @Disabled("Deshabilitar por ahora")
    @Test
    public void testPresentacion() {
        System.out.println("presentacion");
        
        // Redireccionamos la salida por consola para que se guarde en el objeto out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        // Llamamos al método presentacion() de la clase MainIMC
        // El resultado queda almacenado en out
        MainIMC.presentacion();
        
        // Generamos un String con el resultado esperado
        String expResult = "Este programa lee la altura y el peso de" + System.getProperty("line.separator");
        expResult += "una persona y calcula su IMC" + System.getProperty("line.separator");
        expResult += "su Indice de Masa Corporal." + System.getProperty("line.separator");
        expResult += System.getProperty("line.separator");
        
        // Ejecutamos el test.
        // Comparamos el String esperado con el almacenado en out después de ejecutar el método
        assertEquals(expResult, out.toString());
    }

    /**
     * Test del método getIMC de la clase MainIMC.
     */
    @Disabled("Deshabilitar por ahora")
    @Test
    public void testGetIMC() {
        System.out.println("getIMC");
        
        // Creamos un Scanner desde un String para leer los datos
        String datosEntrada = "1,70\n55\n";
        Scanner leerDatos = new Scanner(datosEntrada);
        
        // Ejecutamos el test
        // Comparamos el resultado esperado con el obtenido de ejecutar el método
        double expResult = 19.031141868512112;
        double result = MainIMC.getIMC(leerDatos);
        assertEquals(expResult, result, 0.0);
        
        // Repetimos el test con otros datos
        datosEntrada = "1,80\n100\n";
        leerDatos = new Scanner(datosEntrada);
        result = MainIMC.getIMC(leerDatos);
        assertEquals(30.864197530864196, result, 0.0);
    }

    /**
     * Test del método calculaIMC de la clase MainIMC.
     */
    @Test
    public void testCalculaIMC() {
        System.out.println("calculaIMC");
        
        // Definimos los datos de entrada y el resultado esperado
        double altura = 1.70;
        double peso = 55.0;
        double expResult = 19.031141868512112;
        
        // Ejecutamos el método y comparamos el resultado obtenido con el esperado
        double result = MainIMC.calculaIMC(altura, peso);
        assertEquals(expResult, result, 0.0);
        
        // Repetimos el test con otros valores
        expResult = 30.864197530864196;
        result = MainIMC.calculaIMC(1.80, 100);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test del método formatearResultados de la clase MainIMC.
     */
    @Test
    public void testFormatearResultados() {
        System.out.println("formatearResultados");
        
        // Definimos los datos de entrada y el resultado esperado
        double imc1 = 19.031141868512112;
        double imc2 = 30.864197530864196;
        
        String expResult = "Persona #1 indice de masa corporal = 19.0" + System.getProperty("line.separator");
        expResult += "normal" + System.getProperty("line.separator");
        expResult += "Persona #2 indice de masa corporal = 30.9" + System.getProperty("line.separator");
        expResult += "obeso";
        
        // Ejecutamos el método y comparamos el resultado obtenido con el esperado
        String result = MainIMC.formatearResultados(imc1, imc2);
        assertEquals(expResult, result);
    }


    /**
     * Test del método reportStatus de la clase MainIMC.
     */
    @Test
    public void testReportStatus() {
        System.out.println("reportStatus");
        
        // Definimos el valor de entrada y el resultado esperado
        double imc = 18.4;
        String expResult = "bajo peso";
        
        // Ejecutamos el método y comparamos el resultado obtenido con el esperado
        String result = MainIMC.reportStatus(imc);
        assertEquals(expResult, result);
        
        // Ejecutamos el mismo test con otros valores
        result = MainIMC.reportStatus(18.5);
        assertEquals("normal", result);
        
        result = MainIMC.reportStatus(24.9);
        assertEquals("normal", result);

        assertEquals("sobrepeso", MainIMC.reportStatus(25));
    }

    /**
     * Test del método round1 de la clase MainIMC.
     */
    @Test
    public void testRound1() {
        System.out.println("round1");
        
        // Definimos el valor de entrada y el resultado esperado
        double n = 18.557;
        double expResult = 18.6;
        
        // Ejecutamos el método y comparamos el resultado obtenido con el esperado
        double result = MainIMC.round1(n);
        assertEquals(expResult, result, 0.0);
        
        // Ejecutamos el mismo test con otros valores
        expResult = 18.6;
        result = MainIMC.round1(18.550001);
        assertEquals(expResult, result, 0.0);
        
        assertEquals(18.5, MainIMC.round1(18.54999), 0.0);
    }
    
    /**
     * Test parametrizado del método round1 de la clas MainIMC.
     * Nos permite ejecutar el mismo test con diferentes valores
     * Con @CsvSource definimos los valores para las pruebas
     * name identifica el nombre para trabajar con ese valor
     * index indica la posición en la fila del valor dentro CsvSource
     */
    @DisplayName("Test con muchos datos")
    @ParameterizedTest(name = "{index} => valor={0}, expResult={1}")
    @CsvSource({
            "18.557, 18.6",
            "18.550001, 18.6",
            "18.54999, 18.5"
    })
    
    // Se le pasan como parámetros los valores definidos con @ParameterizedTest
    public void ParameterizedTestRound1(double valor, double expResult) {
        assertEquals(expResult, MainIMC.round1(valor), 0.0);
    }
    
    /**
     * Test parametrizado del método round1 de la clas MainIMC.
     * Los valores se guardan en el fichero datos.csv
     * El fichero debe guardarse en la carpeta resources dentro de test
     */
    @DisplayName("Test con muchos datos")
    @ParameterizedTest(name = "{index} => valor={0}, expResult={1}")
    @CsvFileSource(resources = "/datos.csv")
    public void ParameterizedTestRound2(double valor, double expResult) {
        assertEquals(expResult, MainIMC.round1(valor), 0.0);
    }

    /**
     * Test de excepciones.
     * Se comprueba que al pasarle ciertos valores el método calculaIMC
     * se produce la excepción IllegalArgumentException
     * y el programa falla
     * Permite comprobar precondiciones
     */
    @Test
    public void testExpectedException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.out.println("calculaIMC");
            double altura = 0.70;
            double peso = 55.0;
            double result = MainIMC.calculaIMC(altura, peso);
        });

    }    
}
