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
    
    private static final ObservableList<Alimento> alimentos = leerFichero(rutaArchivoAlimentos);

    // --- VARIABLES PARA AJUSTES ADICIONALES ---
    private static double temperatura = 0.0;
    private static String formatoTemp = "ºC";
    private static String modo = "Eco";
    private static String medidaAlimentos = "KG";
    private static double brillo = 0.5;
    
    // NUEVAS VARIABLES
    private static boolean notificaciones = false;
    private static boolean wifiConectado = false;

    // --- GETTERS Y SETTERS PARA AJUSTES ADICIONALES ---
    public static double getTemperatura() { return temperatura; }
    public static void setTemperatura(double temp) { temperatura = temp; }

    public static String getFormatoTemp() { return formatoTemp; }
    public static void setFormatoTemp(String formato) { formatoTemp = formato; }

    public static String getModo() { return modo; }
    public static void setModo(String m) { modo = m; }

    public static String getMedidaAlimentos() { return medidaAlimentos; }
    public static void setMedidaAlimentos(String medida) { medidaAlimentos = medida; }

    public static double getBrillo() { return brillo; }
    public static void setBrillo(double b) { brillo = b; }

    // NUEVOS GETTERS Y SETTERS
    public static boolean isNotificaciones() { return notificaciones; }
    public static void setNotificaciones(boolean n) { notificaciones = n; }

    public static boolean isWifiConectado() { return wifiConectado; }
    public static void setWifiConectado(boolean w) { wifiConectado = w; }


    // Getter alimentos
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
            br.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return alimentos;
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