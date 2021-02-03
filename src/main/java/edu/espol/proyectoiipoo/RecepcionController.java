package edu.espol.proyectoiipoo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.espol.modelo.ReporteHabs;
import edu.espol.modelo.habitacion;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author kenny
 */
public class RecepcionController implements  Initializable {
    /*
    Elementos del FXML Recepcion
    */
    @FXML
    private DatePicker fechaele;
    @FXML
    private FlowPane paneReservados;
    String img;
 
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
  
    
    /*
    Método que presenta habitaciones en recepcion en orden numérico y con sus 
    respectivos datos
    */
    public void PresentRoom(){
        paneReservados.getChildren().clear();
    for(ReporteHabs g: ReporteHabs.df){
        if((fechaele.getValue().toString()).equals(g.getDate())){
        VBox hhab= new VBox();
        Label label1= new Label("Habitacion nro: "+g.getNumber());
        Label label2= new Label("Tipo: "+g.getType());
        Label label3= new Label("Costo: "+g.getCost());
        Label label4= new Label("Estado: "+g.getStatus());
        if(g.getStatus().equals("disponible")){
        img="file:///C:/Users/kenny/Downloads/camas.png";
        }
        else if(g.getStatus().equals("reservado")){
        img="file:///C:/Users/kenny/Downloads/reserved.png"   ;   
        }
        else if(g.getStatus().equals("ocupado")){
        img ="file:///C:/Users/kenny/Downloads/occupied.png";
        }
        ImageView imghab= new ImageView(new Image(img));
        Button button= new Button();
        button.setGraphic(imghab);
        imghab.setFitHeight(100);
        imghab.setFitWidth(110);
        hhab.getChildren().addAll(label1,label2,label3,label4,button);
        paneReservados.getChildren().add(hhab);
        button.setOnAction(e->Accion2(g.getStatus(),g));
        }
        else if (!(fechaele.getValue().toString()).equals(g.getDate())){
                }
        }
    }
   
    /*Método que se llama al hacer click a la habitacion 
    deseada y dependiendo de su estado lleva a cabo una accion
    */
    public void Accion2(String tipo,ReporteHabs h){
        if(tipo.equals("disponible")){
    
        }
        else if(tipo.equals("reservado")){
           try(BufferedWriter escritor= new BufferedWriter(new FileWriter("src/main/resources/habitacionesNuevo.csv",true));){
            h.setStatus("ocupado");          
            escritor.write(h.getDate()+":"+ReporteHabs.df+"\n");}
            catch(IOException e){}
            System.out.println(h);
            Alert alert= new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMACION");
            alert.setHeaderText("Informacion");
            alert.setContentText("Huesped ha llegado a su habitacion");
            alert.showAndWait();
           }
        
        else if (tipo.equals("ocupado")){
            try(BufferedWriter escritor= new BufferedWriter(new FileWriter("src/main/resources/habitacionesNuevo.csv",true));){
            h.setStatus("disponible");
            escritor.write(h.getDate()+":"+ReporteHabs.df+"\n");
            }
            catch(IOException e){}
            System.out.println(h);
            Alert alert= new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMACION");
            alert.setHeaderText("Informacion");
            alert.setContentText("Huesped ha dejado habitacion");
            alert.showAndWait();
        }
    }  
    
   
}
    
    


    
    

