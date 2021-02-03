/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kenny
 */

public class habitacion implements Serializable{
 /**
 * 
 * @param number numero de habitacion
 * @param categoria categoria de la habitacion
 * @param estado  estado de la habitacion
 * @param precio precio de la habitacion 
 * @param habs ArrayList de habitaciones
 * @param nums numeros de las habitaciones creadas
 */
    public String number;
    public String categoria;
    public String estado;
    public String precio;
    public static ArrayList<habitacion> habs= new ArrayList<>();
    public static ArrayList<String> nums= new ArrayList<>();
/*Constructor de la clase habitacion*/
    public habitacion(String number, String categoria, String precio, String estado) {
        this.number = number;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

   

    public String getNumber() {
        return number;
    }

    public  String getCategoria() {
        return categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getPrecio() {
        return precio;
    }
    
    public String toString() {
        return number + ";"+categoria +";$"+precio+";"+ estado;
    }
    
    /**Metodo que lee el arichivo de donde se encuentran la informacion de las habitaciones, 
    crea nuevas habitaciones y las agrega al ArrayList**/
    public static void LlenarHabitaciones(){
    String file="src/main/resources/datoshabitacion.csv";
    
        try {
           
            BufferedReader r= new BufferedReader(new FileReader(file));
        String linea=r.readLine();
            while( linea!=null){
                String[]s=linea.split(",");
            habs.add(new habitacion(s[0], s[1], s[2],s[3]));
            nums.add(s[0]);
            linea = r.readLine();
            }
            
            System.out.println(habs);
      
        } catch (FileNotFoundException ex) {
            System.out.println("hola");;
        } catch (IOException ex) {
            System.out.println("chao");;
        }
    }

    }



