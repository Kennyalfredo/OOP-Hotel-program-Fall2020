package edu.espol.proyectoiipoo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.espol.modelo.habitacion;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author kenny
 */
public class ReservacionController implements Initializable {
/*Elementos del FXML Reservacion*/
    @FXML
    private DatePicker fechainicio;
    @FXML
    private ComboBox<String> categoriare;
    @FXML
    private FlowPane paneHab;
    @FXML
    private Button btnPresent;
    @FXML
    private VBox paneInfo;
    @FXML
    private ComboBox<String> comboHabs;
    @FXML
    private Button btnSiguiente;
    private ArrayList<String> numerosReservados= new ArrayList<>();
    @FXML
    private DatePicker fechaFin;
   

    /**
     * Initializes the controller class.
     */
    @Override
    /*Agregamos a los comboBox la respectiva informacion
    
    */
    public void initialize(URL url, ResourceBundle rb) {
        categoriare.getItems().addAll("Matrimonial","Suite","Doble","Triple");
       
        for (habitacion h: habitacion.habs){
        comboHabs.getItems().addAll(h.getNumber());}
        
    }    
    @FXML
    /*
    Método que presenta las habitaciones segun la busqueda del usario
    */
    public void PresentarHabitaciones(){
    numerosReservados.clear();
    String rutaimg="file:///C:/Users/kenny/Downloads/hotel-sign%20(1).png";
    paneHab.getChildren().clear();
    for (habitacion h: habitacion.habs){
    if (h.getCategoria().equals(categoriare.getValue())){
    VBox hhab= new VBox();
    Label l= new Label("Habitacion nro: "+h.getNumber()+"\n"+"$"+h.getPrecio()+"\n"+"Estado: "+h.getEstado());
    Button bt= new Button("Reservar");
    numerosReservados.add(h.getNumber());
    ImageView imghab= new ImageView(new Image(rutaimg));
    imghab.setFitHeight(100);
    imghab.setFitWidth(110);
    
    hhab.getChildren().addAll(l,bt,imghab);
    paneHab.getChildren().add(hhab);
    bt.setOnAction(e->clickReservar());
   
            }
        }
    }
  /*
    Metodo que se llama cuando se hace click en el boton reservar 
    */
    public void clickReservar(){
        paneInfo.getChildren().clear();
        Thread t= new Thread(()->ObtenerFechas());
        t.start();
        
        Label n1= new Label("Nombre:");
        TextField t1=new  TextField();
        Label n2=new Label("ID:");
        TextField t2=new  TextField();
        Label n3=new Label("Pais de Origen:");
        TextField t3=new  TextField();
        Label n4=new Label("Forma de pago");
        TextField t4=new  TextField();
            
    paneInfo.getChildren().addAll(n1,t1,n2,t2,n3,t3,n4,t4);
    
    }
    @FXML
    /*
    Método que guarda las habitaciones y las reserva con toda su informacion y con sus fechas de entrada 
     y de salida del usuario en un archivo 
    */
    public void Accion(){
        for(String h: numerosReservados){
            if(comboHabs.getValue().equals(h)){
                for(habitacion hab: habitacion.habs){
                    if(hab.getNumber().equals(h)){
                    hab.setEstado("reservado");
                    } 
                }
            }
        }                
          try(BufferedWriter escritor= new BufferedWriter(new FileWriter("src/main/resources/habitacionesNuevo.csv",true));){
          escritor.write(fechainicio.getValue()+":"+habitacion.habs+"\n");
          for(habitacion h:habitacion.habs){
            if(!h.getEstado().equals("disponible")){
                h.setEstado("disponible");
            }  
          }
                escritor.write(fechaFin.getValue()+":"+habitacion.habs+"\n");
                } catch (IOException ex) {
                  Logger.getLogger(ReservacionController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Alert alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMACION");
                    alert.setHeaderText("Atención");
                    alert.setContentText("Ha realizado Reservacion");
                    alert.showAndWait();
    }

    public void ObtenerFechas(){
        System.out.println(fechainicio.getValue());
       
    }
}
