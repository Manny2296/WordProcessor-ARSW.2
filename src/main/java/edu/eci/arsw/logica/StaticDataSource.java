/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.logica;

import java.util.LinkedHashMap;

/**
 *
 * @author Felipe
 */
public class StaticDataSource implements DataSource{
     private final LinkedHashMap<String, String> engEquivalencesMap;
       private final LinkedHashMap<String, String> spaEquivalencesMap;
     @Override
  public LinkedHashMap<String, String> getEngEquivalencesMap() {
        return engEquivalencesMap;
    }

     @Override
    public LinkedHashMap<String, String> getSpaEquivalencesMap() {
        return spaEquivalencesMap;
    }

    public StaticDataSource(){
       spaEquivalencesMap = new LinkedHashMap<>();

        spaEquivalencesMap.put("hoal", "hola");
        spaEquivalencesMap.put("yola", "hola");
        spaEquivalencesMap.put("jola", "hola");
        spaEquivalencesMap.put("hol", "hola");
        spaEquivalencesMap.put("vuenas", "buenas");
        spaEquivalencesMap.put("nuenas", "buenas");
        spaEquivalencesMap.put("huenas", "buenas");
        spaEquivalencesMap.put("pocible", "posible");

        engEquivalencesMap = new LinkedHashMap<>();

        engEquivalencesMap.put("absolutly", "absolutely");
        engEquivalencesMap.put("absorbsion", "absorption");
        engEquivalencesMap.put("absorbtion", "absorption");
        engEquivalencesMap.put("abudance", "abundance");
        engEquivalencesMap.put("abundacies", "abundances");
        engEquivalencesMap.put("abundancies", "abundances");
        engEquivalencesMap.put("abundunt", "abundant");
        engEquivalencesMap.put("abutts", "abuts");
        engEquivalencesMap.put("acadamy", "academy");
        engEquivalencesMap.put("acadmic", "academic");
        engEquivalencesMap.put("accademic", "academic");
    }
       
}
