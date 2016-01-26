/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerxml;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
/**
 *
 * @author Hairon
 */
public class MongoDB  {
    
    DB baseDatos;
    DBCollection tIndice; 
    DBCollection tPaginas; 
    Mongo mongo;
    
    public MongoDB() {
                
        try {
            mongo = new Mongo("localhost", 27017);
            baseDatos = mongo.getDB("BaseDatos");
            tIndice = baseDatos.getCollection("Indice");
            tPaginas = baseDatos.getCollection("Paginas");
           
            
            BasicDBObject index = new BasicDBObject("Frecuencia",-1);  // Error en la entrega comentar las 2 lineas de abajo!!!!
           // BasicDBObject index2 = new BasicDBObject("Palabra",1);
  
            tIndice.createIndex(index);
           // tPaginas.createIndex(index2);
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
   /* public void MostrarBDs(){    
        List <String> basesDatos = mongo.getDatabaseNames();
        System.out.println("Bases de datos disponibles: " + basesDatos + "\n");
    }
    */
    // Ingresa los textos a la coleccion correspondiente
    public void IngresarPaguina(String titulo,String texto,int id){
        BasicDBObject documento = new BasicDBObject();            
        documento.put("ID",Integer.toString(id));
        documento.put("Titulo",titulo);
        documento.put("Texto",texto);
        
        tPaginas.insert(documento);
        documento.clear();
    }
    
    // Ingresa las palabras con su frecuencia e Id a la coleccion correspondiente
    public void IngresarPalabra(String palabra,int frecuencia,int id){
 
        
       // System.out.println("Cantidad tablas antes agregado: " + tIndice.count());
        BasicDBObject documento = new BasicDBObject();        // creo un documento para ingresar a la db    
        documento.put("Palabra",palabra);                       // se le ingresan los parametros al documento
        documento.put("ID", Integer.toString(id));
        documento.put("Frecuencia", frecuencia);
        tIndice.insert(documento);            // se inserta a la tabla de Indice (Palabras)
        documento.clear();  // limpio el documento insertado
            
        
    }
    
    
}
