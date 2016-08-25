/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2108221
 */
public class OnlineDataSource implements DataSource{
    URL urlEng;
    URL urlEspa;
    BufferedReader inEng;
    BufferedReader inEspa;
    String inputLine;
  
   
    private  LinkedHashMap<String, String> engEquivalencesMap= null;
    private  LinkedHashMap<String, String> spaEquivalencesMap= null;
    public OnlineDataSource(String engUrl,String espaUrl) throws IOException {
        try {
            urlEng =  new URL(engUrl);
            urlEspa =  new URL(espaUrl);
            inEng = new BufferedReader(new InputStreamReader(urlEng.openStream()));
            inEspa = new BufferedReader(new InputStreamReader(urlEspa.openStream()));
            spaEquivalencesMap = new LinkedHashMap<>();
            engEquivalencesMap = new LinkedHashMap<>();
        } catch (MalformedURLException ex) {
            Logger.getLogger(OnlineDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    

    @Override
    public LinkedHashMap<String, String> getSpaEquivalencesMap() {
        try {
            while ((inputLine = inEspa.readLine())!= null) {
                System.out.println("linea: "+ inputLine);
                String[] split = inputLine.split("->"); 
                System.out.println("Array : "+ split.toString());
               
                spaEquivalencesMap.put(split[0], split[1]);
            }
        } catch (IOException ex) {
            Logger.getLogger(OnlineDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return spaEquivalencesMap;
    }

    @Override
    public LinkedHashMap<String, String> getEngEquivalencesMap() {
        try {
            while ((inputLine = inEng.readLine())!= null) {
                System.out.println("linea: "+ inputLine);
                String[] split = inputLine.split("->"); 
                System.out.println("Array : "+ split[0]+ "Spli" + split[1]);
                engEquivalencesMap.put(split[0], split[1]);
            }
        } catch (IOException ex) {
            Logger.getLogger(OnlineDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return engEquivalencesMap;
    }
    
}
