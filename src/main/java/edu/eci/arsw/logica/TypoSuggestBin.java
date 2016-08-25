/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.logica;

import edu.eci.arsw.persitencia.Serializable;
import edu.eci.arsw.persitencia.SerializacionBin;
import java.util.LinkedHashMap;
import javax.swing.JTextArea;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author dummyProgrammer
 */
public class TypoSuggestBin implements TypoSuggestions{


    

    private final LinkedHashMap<Languages, LinkedHashMap<String, String>> langMaps;    
    private LinkedHashMap<String,String> selectedTyposMap;
    private SerializacionBin srz;
    private DataSource dts;

    public SerializacionBin getSrz() {
        return srz;
    }

    public void setSrz(SerializacionBin srz) {
        this.srz = srz;
    }
          


   
   
    public  TypoSuggestBin() {
         
       // srz = new SerializacionBin();
    
        //dts = new StaticDataSource();
        langMaps = new LinkedHashMap<>();
        
        
    }
    
    public DataSource getDts() {
        return dts;
    }

    public void setDts(DataSource dts) {
        this.dts = dts;
        langMaps.put(Languages.SPANISH, dts.getSpaEquivalencesMap());
        langMaps.put(Languages.ENGLISH, dts.getEngEquivalencesMap());
        selectedTyposMap = dts.getEngEquivalencesMap();
    }



    @Override
    public void setSelectedLanguage(Languages selectedLanguage) {
        selectedTyposMap=langMaps.get(selectedLanguage);
    }
    

    /**
     * Obj: Verificar que la palabra ingresada esté sujeta a correcciones, por
     * ejemplo por un error típico de digitación identificado.
     *
     * @param word
     * @param lang
     * @return
     */
    @Override
    public String check(String word, Languages lang) {

        String res = selectedTyposMap.get(word);
        if (res == null) {
            return null;
        } else {
            return res;
        }

    }
    
    @Override
    public Languages getSelectedLanguage(){
        return Languages.ENGLISH;
    }
    
    @Override
    public void cargar(JTextArea txa){
        srz.load(txa);
    }
    @Override
    public void salvar(JTextArea txa){
        srz.save(txa);
    }

    

}
