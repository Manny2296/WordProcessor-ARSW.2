/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persitencia;

import edu.eci.arsw.presentacion.GuordMainFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Felipe
 */
public class SerializacionBin implements Serializable{

   private String defaultPath="src/main/resources/tmp/";
    public SerializacionBin() {
        
    }

   
    
    @Override
    public void load(JTextArea txtA){
         String name=null;
        
        File filesPath=new File(defaultPath);
        String[] choices=filesPath.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".guord"));
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
            ObjectInputStream ois=null;
            try {   
                FileInputStream fis = new FileInputStream(defaultPath+name);
                ois = new ObjectInputStream(fis);            
                Object readObject = ois.readObject();
                
                   System.out.println("" + (String) readObject);
                txtA.setText((String)readObject);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(GuordMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (ois!=null) ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(GuordMainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        }
    }
     
    @Override
    public void save(JTextArea txa){
      String name = JOptionPane.showInputDialog(this, "Enter file name.");
        if (!name.endsWith(".guord")){
            name=name+".guord";
        }
        ObjectOutputStream oos=null;
        try {
            String body=txa.getText();        
            oos = new ObjectOutputStream(new FileOutputStream(defaultPath+name));
            oos.writeObject(body);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GuordMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GuordMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(GuordMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }

   
}
