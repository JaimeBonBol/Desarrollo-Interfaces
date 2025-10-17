/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jaimedam
 * Clase para compartir datos entre todos los controladores.
 */
public class DatosCompartidos {
    
    // ObservableList porque se actualiza automaticamente en la TbaleView al aadir o eliminar
    private static final ObservableList<Alimento> alimentos = FXCollections.observableArrayList();
    
    static {
        alimentos.addAll(
            new Alimento("Leche", 1, "L"),
            new Alimento("Huevos", 12, "Unidades"),
            new Alimento("Manzanas", 2.5, "kg")
        );
    }


    // Getter
    public static ObservableList<Alimento> getAlimentos() {
        return alimentos;
    }
    
    
}
