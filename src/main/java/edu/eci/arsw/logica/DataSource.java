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
public interface DataSource {
 public LinkedHashMap<String, String> getSpaEquivalencesMap(); 
  public LinkedHashMap<String, String> getEngEquivalencesMap();
}
