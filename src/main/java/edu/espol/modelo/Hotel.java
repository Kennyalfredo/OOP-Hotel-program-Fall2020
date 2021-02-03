/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class Hotel implements Serializable{
    /**
     * @param name nombre del hotel
     * @param ciudad ciudad en donde se encuentra el hotel
     * @param direccion direccion en la que se encuentra el hotel
     * @param telefono telefono del hotel
     */
    String name;
    String ciudad;
    String direccion;
    String telefono;
/**
 * Constructor de la clase Hotel
 **/
    public Hotel(String name, String ciudad, String direccion, String telefono) {
        this.name = name;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }
   
    
    
    
      
    
}
