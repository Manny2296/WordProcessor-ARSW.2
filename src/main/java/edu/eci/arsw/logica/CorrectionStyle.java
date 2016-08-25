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
public interface CorrectionStyle {
    public String CorrectionCheck(String word, Languages lang, LinkedHashMap<String, String> selectedTyposMap);
}
