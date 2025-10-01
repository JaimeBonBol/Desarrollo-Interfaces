/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import modelo.Operaciones;

/**
 * FXML Controller class
 *
 * @author jaimedam
 */
public class VistaCalculadoraController implements Initializable {

    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn0;
    @FXML
    private Button btnAC;
    @FXML
    private Button btnDivision;
    @FXML
    private Button btnMultiplicacion;
    @FXML
    private Button btnSuma;
    @FXML
    private Button btnResta;
    @FXML
    private Button btnPorcentaje;
    @FXML
    private Button btnResultado;
    @FXML
    private Pane pantalla;
    @FXML
    private Label labelOperador1;
    @FXML
    private Label labelOperador2;
    @FXML
    private Label labelOperacion;
    @FXML
    private Label labelResultado;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickBtn0(ActionEvent event) {
        
        if(labelOperacion.getText().isEmpty()){
            labelOperador1.setText(labelOperador1.getText() + "0");
            // Se comprueba en el ese si la pantalla resultado está´a para una vez que se ha mostrado
            // el resultado no se pongan más números en la pantalla del operador 2
        }else if(labelResultado.getText().isEmpty()){
            labelOperador2.setText(labelOperador2.getText() + "0");
        } 
        
    }

    @FXML
    private void clickBtn7(ActionEvent event) {
        
        if(labelOperacion.getText().isEmpty()){
            labelOperador1.setText(labelOperador1.getText() + "7");
            // Se comprueba en el ese si la pantalla resultado está´a para una vez que se ha mostrado
            // el resultado no se pongan más números en la pantalla del operador 2
        }else if(labelResultado.getText().isEmpty()){
            labelOperador2.setText(labelOperador2.getText() + "7");
        }
        
    }

    @FXML
    private void clickBtn8(ActionEvent event) {
        
        if(labelOperacion.getText().isEmpty()){
            labelOperador1.setText(labelOperador1.getText() + "8");
            // Se comprueba en el ese si la pantalla resultado está´a para una vez que se ha mostrado
            // el resultado no se pongan más números en la pantalla del operador 2
        }else if(labelResultado.getText().isEmpty()){
            labelOperador2.setText(labelOperador2.getText() + "8");
        }
        
    }

    @FXML
    private void clickBtn9(ActionEvent event) {
        
        if(labelOperacion.getText().isEmpty()){
            labelOperador1.setText(labelOperador1.getText() + "9");
            // Se comprueba en el ese si la pantalla resultado está´a para una vez que se ha mostrado
            // el resultado no se pongan más números en la pantalla del operador 2
        }else if(labelResultado.getText().isEmpty()){
            labelOperador2.setText(labelOperador2.getText() + "9");
        }
        
    }

    @FXML
    private void clickBtn4(ActionEvent event) {
        
        if(labelOperacion.getText().isEmpty()){
            labelOperador1.setText(labelOperador1.getText() + "4");
            // Se comprueba en el ese si la pantalla resultado está´a para una vez que se ha mostrado
            // el resultado no se pongan más números en la pantalla del operador 2
        }else if(labelResultado.getText().isEmpty()){
            labelOperador2.setText(labelOperador2.getText() + "4");
        }
        
    }

    @FXML
    private void clickBtn5(ActionEvent event) {
        
        if(labelOperacion.getText().isEmpty()){
            labelOperador1.setText(labelOperador1.getText() + "5");
            // Se comprueba en el ese si la pantalla resultado está´a para una vez que se ha mostrado
            // el resultado no se pongan más números en la pantalla del operador 2
        }else if(labelResultado.getText().isEmpty()){
            labelOperador2.setText(labelOperador2.getText() + "5");
        }
        
    }

    @FXML
    private void clickBtn6(ActionEvent event) {
        
        if(labelOperacion.getText().isEmpty()){
            labelOperador1.setText(labelOperador1.getText() + "6");
            // Se comprueba en el ese si la pantalla resultado está´a para una vez que se ha mostrado
            // el resultado no se pongan más números en la pantalla del operador 2
        }else if(labelResultado.getText().isEmpty()){
            labelOperador2.setText(labelOperador2.getText() + "6");
        }
        
    }

    @FXML
    private void clickBtn1(ActionEvent event) {
        
        if(labelOperacion.getText().isEmpty()){
            labelOperador1.setText(labelOperador1.getText() + "1");
            // Se comprueba en el ese si la pantalla resultado está´a para una vez que se ha mostrado
            // el resultado no se pongan más números en la pantalla del operador 2
        }else if(labelResultado.getText().isEmpty()){
            labelOperador2.setText(labelOperador2.getText() + "1");
        }
        
    }

    @FXML
    private void clickBtn2(ActionEvent event) {
        
        if(labelOperacion.getText().isEmpty()){
            labelOperador1.setText(labelOperador1.getText() + "2");
            // Se comprueba en el ese si la pantalla resultado está´a para una vez que se ha mostrado
            // el resultado no se pongan más números en la pantalla del operador 2
        }else if(labelResultado.getText().isEmpty()){
            labelOperador2.setText(labelOperador2.getText() + "2");
        }
        
    }

    @FXML
    private void clickBtn3(ActionEvent event) {
        
        if(labelOperacion.getText().isEmpty()){
            labelOperador1.setText(labelOperador1.getText() + "3");
            // Se comprueba en el ese si la pantalla resultado está´a para una vez que se ha mostrado
            // el resultado no se pongan más números en la pantalla del operador 2
        }else if(labelResultado.getText().isEmpty()){
            labelOperador2.setText(labelOperador2.getText() + "3");
        }
        
    }

    @FXML
    private void clickBtnAC(ActionEvent event) {
        resetearPantalla();
    }

    @FXML
    private void clickBtnDivision(ActionEvent event) {
        
        if(!labelOperador1.getText().isEmpty() && labelOperacion.getText().isEmpty()){
            labelOperacion.setText(btnDivision.getText());
        }
        
    }

    @FXML
    private void clickBtnMultiplicacion(ActionEvent event) {
        
        if(!labelOperador1.getText().isEmpty() && labelOperacion.getText().isEmpty()){
            labelOperacion.setText(btnMultiplicacion.getText());
        }
        
    }

    @FXML
    private void clickBtnSuma(ActionEvent event) {
        
        if(!labelOperador1.getText().isEmpty() && labelOperacion.getText().isEmpty()){
            labelOperacion.setText(btnSuma.getText());
        }
        
    }

    @FXML
    private void clickBtnResta(ActionEvent event) {
        
        if(!labelOperador1.getText().isEmpty() && labelOperacion.getText().isEmpty()){
            labelOperacion.setText(btnResta.getText());
        }
        
    }

    @FXML
    private void clickBtnPorcentaje(ActionEvent event) {
        
        if(!labelOperador1.getText().isEmpty() && labelOperacion.getText().isEmpty()){
            labelOperacion.setText(btnPorcentaje.getText());
        }
        
    }

    @FXML
    private void clickBtnResultado(ActionEvent event) {
        
        if (!labelOperador1.getText().isEmpty() && !labelOperador2.getText().isEmpty() && !labelOperacion.getText().isEmpty()) {
            double operador1 = Double.parseDouble(labelOperador1.getText());
            double operador2 = Double.parseDouble(labelOperador2.getText());
            
            realizarOperacion(operador1, operador2);
        }
        
    }
    
    public void resetearPantalla(){
        labelOperador1.setText("");
        labelOperador2.setText("");
        labelOperacion.setText("");
        labelResultado.setText("");
    }
    
    public void realizarOperacion(double operador1, double operador2){
        
        Operaciones operaciones = new Operaciones();
        
        String operacion = labelOperacion.getText();
        
        if (operacion.equals("%")) {
            labelResultado.setText(operaciones.porcentaje(operador1, operador2));
        }
        else if(operacion.equals("/")){
            labelResultado.setText(operaciones.dividir(operador1, operador2));
        }
        else if(operacion.equals("x")){
            labelResultado.setText(operaciones.multiplicar(operador1, operador2));
        }
        else if(operacion.equals("+")){
            labelResultado.setText(operaciones.sumar(operador1, operador2));
        }
        else if(operacion.equals("-")){
            labelResultado.setText(operaciones.restar(operador1, operador2));
        }
    }
    
}
