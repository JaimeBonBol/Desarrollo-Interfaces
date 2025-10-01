/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jaimedam
 */
public class Operaciones {    
    
    public String porcentaje(double operador1, double operador2){
        double resultado = ((operador1 * operador2)/100);
        
        return String.valueOf(resultado);
    }
    
    public String dividir(double operador1, double operador2){
        double resultado;
        String salida;
        if (operador2 == 0) {
            return salida = "Sin definir";
        }else{
            resultado = operador1 / operador2;
            salida = resultado + "";
            return salida ;
        }
    }
    
    public String multiplicar(double operador1, double operador2){
        double resultado = operador1 * operador2;
        
        return String.valueOf(resultado);
    }
    
    public String sumar(double operador1, double operador2){
        double resultado = operador1 + operador2;
        
        return String.valueOf(resultado);
    }
    
    public String restar(double operador1, double operador2){
        double resultado = operador1 - operador2;
        
        return String.valueOf(resultado);
    }
    
}
