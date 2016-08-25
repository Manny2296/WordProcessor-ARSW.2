/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persitencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Felipe
 */
public class SerializacionPlainText implements Serializable{
   
   private String defaultPath="src/main/resources/tmp/";

   
    public String getDefaultPath() {
        return defaultPath;
    }

    public SerializacionPlainText() {
       
    }
   
    @Override
    public void load(JTextArea txa) {
    String name=null;
        
        File filesPath=new File(defaultPath);
        String[] choices=filesPath.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".txt"));
            }
        });        
          if (choices.length>0){
            name = (String) JOptionPane.showInputDialog(null, "Choose document...",
            "Choose document", JOptionPane.QUESTION_MESSAGE, null, // Use
            choices, // Array of choices
            choices[0]); // Initial choice            
        }
        else{
            JOptionPane.showMessageDialog(null, "No documents found");
        }
        
        if (name!=null){
        try {
            FileReader fr = null;
            BufferedReader br = null;
           
            fr = new FileReader(defaultPath+name);
            br = new BufferedReader(fr);
            //Leer linea por linea 
            String line ;
            line = br.readLine();
          
            br.close();
             txa.setText(line);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializacionPlainText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializacionPlainText.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
} 
    
       
    

    @Override
    public void save(JTextArea txa) {
      javax.swing.JFileChooser jF1= new javax.swing.JFileChooser(defaultPath); 
String ruta = ""; 
FileWriter fw = null;
PrintWriter pw = null;
String body=txa.getText();
FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
jF1.setFileFilter(filter);
try{ 
if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION){ 
    
     
    ruta = jF1.getSelectedFile().getAbsolutePath(); 
fw = new FileWriter(ruta+".txt");
    
pw = new PrintWriter(fw);
BufferedWriter bf = new BufferedWriter(pw);

    System.out.println("texto:"+ txa.getText());
pw.write(txa.getText());
    System.out.println("Fichero guardado correctamente ");

fw.close();
pw.close();
bf.close();
} 
}catch (Exception ex){ 
ex.printStackTrace(); 
} 
    }
    
}
