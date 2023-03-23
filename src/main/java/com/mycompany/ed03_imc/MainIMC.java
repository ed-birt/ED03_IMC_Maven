// Este program obtiene el IMC para 2 personas.
// Esta version incluye distintos metodos bien diseñados
// que proporciona estructura y evitan la redundancia.
package com.mycompany.ed03_imc;

import java.util.*;
public class MainIMC {
    
    // Programa principal. Utiliza el resto de métodos de la clase
    // Como todos son métodos estáticos, no hace falta instanciar un objto con new
    public static void main(String[] args) {
        presentacion();
        Scanner leerTeclado = new Scanner(System.in);
        double imc1 = getIMC(leerTeclado);
        double imc2 = getIMC(leerTeclado);
        String mensaje = formatearResultados(imc1, imc2);
        System.out.println(mensaje);
    }

    // Presenta el program al usuario
    public static void presentacion() {
        System.out.println("Este programa lee la altura y el peso de");
        System.out.println("una persona y calcula su IMC");
        System.out.println("su Indice de Masa Corporal.");
        System.out.println();
    }

    // Utiliza el objeto Scanner para pedir la altura y el peso,
    // y devuelve el IMC
    public static double getIMC(Scanner leerTeclado) {
        System.out.println("Introduce los datos de la siguiente persona");
        
        // Falta controlar que la altura es válida
        System.out.println("altura en metros:");
        double altura = leerTeclado.nextDouble();
        System.out.println("peso en kilogramos:");
        double peso = leerTeclado.nextDouble();
        double imc = calculaIMC(altura, peso);
        System.out.println();
        return imc;
    }

    // Calcula el IMC a partir del peso en kilos y la altura en metros
    // PRECONDICION: dato altura > 1
    public static double calculaIMC(double altura, double peso) {
        // Si los datos no cumplen con la precondicón, se genera una excepción
        // y el proograma falla
        if (altura < 1) {
            throw new IllegalArgumentException("Valor de altura incorrecto");
        }
        double resultado = peso / (altura * altura);
        return resultado;
    }

    // Muestra los resultados obtenidos para cada persona
    // Se introduce un salto de línea que depende del SO para evitar problemas
    // En Linux y MacOS introducirá "\n"
    // En Windows introduce “\r\n”
    public static String formatearResultados(double imc1, double imc2) {
        String texto = "Persona #1 indice de masa corporal = " + round1(imc1) + System.getProperty("line.separator");
        texto = texto + reportStatus(imc1) + System.getProperty("line.separator");
        texto = texto + "Persona #2 indice de masa corporal = " + round1(imc2) + System.getProperty("line.separator");
        texto = texto + reportStatus(imc2);
        return texto;
    }

    // Obtiene y devuelve el estado de una persona segun su IMC
    public static String reportStatus(double imc) {
        String estado;
        if (imc < 18.5) {
            estado = "bajo peso";
        } else if (imc < 25) {
            estado = "normal";
        } else if (imc < 30) {
            estado = "sobrepeso";
        } else { // imc >= 30
            estado = "obeso";
        }
        return estado;
    }

    // devuelve el resultado de redondear el numero a un decimal
    public static double round1(double n) {
        return Math.round(n * 10.0) / 10.0;
    }
}