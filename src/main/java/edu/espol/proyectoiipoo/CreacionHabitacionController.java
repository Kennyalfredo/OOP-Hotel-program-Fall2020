package edu.espol.proyectoiipoo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kenny
 */
public class CreacionHabitacionController implements Initializable {
/**
 * Elementos del FXML CreacionHabitacion
   **/
    
    @FXML
    private TextField numerohab;
    @FXML
    private TextField preciohab;
   
    @FXML
    private ComboBox<String> cathab;
    
     public static ArrayList<String> numbers = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
     
    @Override
    /*Agregamos los tipos de habitacion al combo box*/
    public void initialize(URL url, ResourceBundle rb) {
        cathab.getItems().addAll("Matrimonial","Suite","Doble","Triple");
        
        // TODO
    }    
    
    public void consultarHabitacion(){    
      /*Metodo que crea un archivo donde se escribira toda la informacion de las
        habitaciones y valida que no hayan repetidas
        */
    try(BufferedWriter escritor= new BufferedWriter(new FileWriter("src/main/resources/datoshabitacion.csv",true));)
      {
          
          numbers.add(numerohab.getText());
          Set<String> hs = new HashSet<>();
          hs.addAll(numbers);
          if((hs.size())==(numbers.size())){
          escritor.write(numerohab.getText()+","+cathab.getValue()+","+preciohab.getText()+","+"disponible"+"\n");
          }
          else if((hs.size())!=(numbers.size())) {
              numbers.remove(numbers.size()-1);
          Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Error");
            alert.setContentText("Habitacion ya ha sido creada previamente");
            alert.showAndWait();
          }
         
    
    }   catch (IOException ex) {
            ex.printStackTrace();
        }}
   
    




}
    



    

