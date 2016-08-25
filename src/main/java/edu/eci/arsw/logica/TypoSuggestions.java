/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.logica;

import javax.swing.JTextArea;

/**
 *
 * @author 2099340
 */
public interface TypoSuggestions {

        public String check(String word, Languages lang);
        public void setSelectedLanguage(Languages selectedLanguage);
        public Languages getSelectedLanguage();
     public void cargar(JTextArea txa);
     public void salvar(JTextArea txa);
     
    
}
