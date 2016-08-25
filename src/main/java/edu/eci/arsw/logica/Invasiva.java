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
public class Invasiva implements  CorrectionStyle{

    public Invasiva()  {
    }
    
    
    @Override
    public String CorrectionCheck(String word, Languages lang, LinkedHashMap<String, String> selectedTyposMap) {
        String res = selectedTyposMap.get(word);
        if (res == null) {
            return null;
        } else {
            if(res.contains(",")){
                String replace = res.replace(",", "//");
               res = "[" +replace + "]";
            }
            return res ;
        }
    }
}
