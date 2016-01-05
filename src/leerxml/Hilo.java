/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerxml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hairon
 */
public class Hilo extends Thread{
    //Se declarna las variables a utilizar
    String Texto=new String(); 
    int ID;
    
    public Hilo(String Texto,int ID){ //Los recibe del servidor

        //Luego se instancian
        this.Texto= Texto;
        this.ID=ID;
        
        
    }
    
    //El hilo de ejecución
    @Override
    public void run() {
     
      String palabras = Texto.replaceAll("[^A-Za-z0-9-á-úÁ-Ú\n]", " ");
      
      System.out.print("Hebra "+ID+": "+palabras+"\n");
      
      PrintWriter writer = null;
        try {
            writer = new PrintWriter(""+ID+".txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        writer.print(palabras);
        
        writer.close();

    }

public void ElminarCaracteresInutiles(String texto,int id){
        


       
    
    }
    
    public void AgregarEntrada(String Busqueda,int Nparticion){

    }
    

}
