/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerxml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    String Texto,SinBasura,SinStopWords=new String(); 
    // string especialmente diseñado para contener las stopwords de forma que .replaceall las pueda utilizar
    String StopWords = " algún | alguna | algunas | algun | algunos | ambos | ampleamos | ante | antes | aquel | aquellas | aquellos | aqui | arriba | atras | bajo | bastante | bien | cada | cierta | ciertas | cierto | ciertos | como | con | conseguimos | conseguir | consigo | consigue | consiguen | consigues | cual | cuando | dentro | desde | donde | dos | el | ellas | ellos | empleais | emplean | emplear | empleas | empleo | en | encima | entonces | entre | era | eramos | eran | eras | eres | es | esta | estaba | estado | estais | estamos | estan | estoy | fin | fue | fueron | fui | fuimos | gueno | ha | hace | haceis | hacemos | hacen | hacer | haces | hago | incluso | intenta | intentais | intentamos | intentan | intentar | intentas | intento | ir | la | largo | las | lo | los | mientras | mio | modo | muchos | muy | nos | nosotros | otro | para | pero | podeis | podemos | poder | podria | podriais | podriamos | podrian | podrias | por | por qué | porque | primero | puede | pueden | puedo | quien | sabe | sabeis | sabemos | saben | saber | sabes | ser | si | siendo | sin | sobre | sois | solamente | solo | somos | soy | su | sus | también | teneis | tenemos | tener | tengo | tiempo | tiene | tienen | todo | trabaja | trabajais | trabajamos | trabajan | trabajar | trabajas | trabajo | tras | tuyo | ultimo | un | una | unas | uno | unos | usa | usais | usamos | usan | usar | usas | uso | va | vais | valor | vamos | van | vaya | verdad | verdadera | verdadero | vosotras | vosotros | voy | yo";
    int ID;
    
    public Hilo(String Texto,int ID){ //Los recibe del servidor

        //agrega un espacio al inicio del texto
        this.Texto= " "+Texto;
        this.ID=ID;
        
        
    }
    
    //El hilo de ejecución
    @Override
    public void run() {
     
        EliminarCaracteresInutiles();
        EliminarStopWords();
        ContaryEnviar();
        Crearfichero();
                
    }

public void EliminarCaracteresInutiles(){ 
    // se reemplaza todo lo que no sea letras y numeros por espacio en blanco
    SinBasura = Texto.replaceAll("[^A-Za-z0-9-á-úÁ-Ú]", " ");
    // quita los espacios excesivos (deja cada palabra separada por espacio
    SinBasura = SinBasura.replaceAll("\\s+"," ");
    //System.out.print("Hebra "+ID+": "+SinBasura+"\n");
    }
    
    public void EliminarStopWords(){ // se reemplazan las stopwords por *** (por el momento solo para darse cuenta q se eliminarion"
        SinStopWords=SinBasura.replaceAll(StopWords, " ");
    }

    private void ContaryEnviar() {// contara cada palabra y la enviara a la basse de datos en mongo
        
      
       
    }

    private void Crearfichero() {  // la hebra crea su respectivo archivo con Nombre ID y escribe el contenido del texto
    PrintWriter writer = null;
    try {
        writer = new PrintWriter("ID "+ID+".txt", "UTF-8");
    } catch (FileNotFoundException | UnsupportedEncodingException ex) {
        Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    writer.print(SinStopWords);
        
    writer.close();
    }
    

}
