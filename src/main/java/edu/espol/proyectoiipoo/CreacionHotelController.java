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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kenny
 */
public  class CreacionHotelController implements Initializable {
    /*Elementos del FXML realizado en el scenebuider*/
    @FXML
    private TextField nombreH;
    @FXML
    private ComboBox<String> city;
    @FXML
    private TextField direction;
    @FXML
    private   TextField phone;
    @FXML
    private Button crearHotel;

    /**
     * Initializes the controller class.
     */
    @Override
    /*Agrega a el combo box de ciudades las ciudades*/
    public void initialize(URL url, ResourceBundle rb) {
        city.getItems().addAll("Guayaquil","Quito","Cuenca","Azogues","Ambato");
        // TODO
    }
    /*Método que crea un archivo donde se va a guardar toda la informacion del hotel*/
    public  void crearArchivoHotel(){
    
         try(BufferedWriter escritor= new BufferedWriter(new FileWriter("src/main/resources/datoshotel.csv",true));)
      {
          escritor.write("Nombre"+"Ciudad"+"Direccion"+"Teléfono"+"\n");
          escritor.write(nombreH.getText()+","+ city.getValue()+","+ direction.getText()+","+ phone.getText());
              
          } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
     
  
    

