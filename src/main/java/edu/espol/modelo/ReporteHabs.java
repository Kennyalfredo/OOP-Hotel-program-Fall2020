/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kenny
 */
public class ReporteHabs implements Serializable{
    /**
     * @param date dia de la reservacion
     * @param number numero de habitacion
     * @param Type tipo de habitacion
     * @param Cost costo de la habitacion
     * @param status estado de la habitacion
     * @param df ArrayList de habitaciones con su fecha
     */
    String date;
    String number;
    String Type;
    String Cost;
    String Status;
public static ArrayList<ReporteHabs> df= new ArrayList<>();
/*
    Constructor de ReporteHabs
*/
    public ReporteHabs(String date, String number, String Type, String Cost, String Status) {
        this.date = date;
        this.number = number;
        this.Type = Type;
        this.Cost = Cost;
        this.Status = Status;
    }

    public String getDate() {
        return date;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return Type;
    }

    public String getCost() {
        return Cost;
    }

    public String getStatus() {
        return Status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setCost(String Cost) {
        this.Cost = Cost;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return date + number + Type +  Cost + Status;  }
    
    /*
    Método que lee los datos de la habitacion con su fecha 
    y crea un onjeto tipo ReporteHabs
    */
    public static  void LeerDatos(){
  
        String file="src/main/resources/habitacionesNuevo.csv";
        try{BufferedReader r= new BufferedReader(new FileReader(file));
         String linea = r.readLine();
        
            while(linea!= null){
            String[] date_and_habs=linea.split(":");    
            String[] rooms= date_and_habs[1].split(",");
            for(String a: rooms){
            String[] roomPerDate= a.split(";");
            df.add(new ReporteHabs(date_and_habs[0], roomPerDate[0], roomPerDate[1], roomPerDate[2], roomPerDate[3]));
            }
            linea=r.readLine();
            
            }System.out.println(df);}
        
        catch(IOException e){
            System.out.println(e);
            }
    }
    
    
    
    }
    

