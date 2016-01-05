/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerxml;

import java.util.*;
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
      
 
    }

public void ElminarCaracteresInutiles(String texto,int id){
        

        
       
    
    }
    
    public void AgregarEntrada(String Busqueda,int Nparticion){

    }
    

}
