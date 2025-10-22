/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jaimedam
 * Clase para compartir datos entre todos los controladores.
 */
public class DatosCompartidos {
    
    private static String rutaArchivoAlimentos = "src/fichero/alimentos.txt";
    
    // ObservableList porque se actualiza automaticamente en la TbaleView al aadir o eliminar
    private static final ObservableList<Alimento> alimentos = leerFichero(rutaArchivoAlimentos);
    
//    static {
//        alimentos.addAll(
//            new Alimento("Leche", 1, "L"),
//            new Alimento("Huevos", 12, "Unidades"),
//            new Alimento("Manzanas", 2.5, "kg")
//        );
//    }


    // Getter
    public static ObservableList<Alimento> getAlimentos() {
        return alimentos;
    }
    
    public static ObservableList<Alimento> leerFichero(String rutaFichero){
        ObservableList<Alimento> alimentos = FXCollections.observableArrayList();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
            
            String linea;
            while ((linea = br.readLine()) != null) {                
                String[] palabrasLinea = linea.split("-");
                
                String nombre = palabrasLinea[0];
                double cantidad = Double.parseDouble(palabrasLinea[1]);
                String unidad = palabrasLinea[2];
                
                alimentos.add(new Alimento(nombre, cantidad, unidad));
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return  alimentos;

    }
    
    public static void guardarAlimentosFichero(String ruta){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            
            for(Alimento alimento : alimentos){
                StringBuilder sb = new StringBuilder();
                sb.append(alimento.getNombre() + "-" + alimento.getCantidad() + "-" + alimento.getUnidad());
                
                bw.write(sb.toString());
                bw.newLine();
            }
            
            bw.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    
}
