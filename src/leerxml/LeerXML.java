/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerxml;

/**
 *
 * @author Hairon
 */
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LeerXML {

   public static void main(String argv[]) {
       
       
    

          
    try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler;
               handler = new DefaultHandler() {
               String Texto = new String();
               int ID;
               
               boolean bID = false;
               boolean bText = false;
               boolean bTitle = false;
               boolean bNS = false;
               
               
               @Override
               public void startElement(String uri, String localName,String qName,Attributes attributes) throws SAXException {
                   
                   // System.out.println("Start Element :" + qName + attributes.getValue(uri));
                   
                   if (qName.equalsIgnoreCase("TITLE")) {
                       bTitle = true;
                   }
                   if(qName.equalsIgnoreCase("NS"))bNS= true;
                           
                   if (qName.equalsIgnoreCase("ID")&& bNS) {
                       bID = true;
                   }
                   if (qName.equalsIgnoreCase("TEXT")) {
                      // System.out.println("TEXTO !!");
                       bText = true;
                   }
                   
                   
                   
               }
               
               public void endElement(String uri, String localName,String qName) throws SAXException {
                   
                   if (qName.equalsIgnoreCase("TEXT")) {
                       //System.out.println(Texto);
                       
                       bText = false;
                       Hilo hilo = new Hilo(Texto,ID);
                       hilo.run();
                       Texto ="";
                       ID = 0;
                   }
                   
               }
               
               public void characters(char ch[], int start, int length) throws SAXException {
                   
                   String Aux =new String(ch, start, length);
                   
                   if (bTitle) {
                       //System.out.print("TITULO : " + Aux+"\n");
                        Texto+=Aux+"\n\n\n";    
                       //System.out.print("\n");
                       bTitle = false;
                       
                   }
                   if (bID) {
                       //System.out.print("ID : " + Aux+"\n");
                       ID = Integer.parseInt(Aux);
                       bID = false;
                       bNS = false;
                   }
                   
                   if (bText) {
                       Texto += Aux;
                       //System.out.print(Aux);
                       // blname = false;
                       
                   }
                   
                   
               }
               
           };

       saxParser.parse("C:\\Users\\Hairon\\Desktop\\Destruidos\\Hidalgo\\Lab\\Lab 2\\eswiki-20151202-stub-meta-current1.xml", handler);
 
     } catch (Exception e) {
       e.printStackTrace();
     }
  
   }

}

    

