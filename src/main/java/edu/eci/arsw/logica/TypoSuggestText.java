/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.logica;

import edu.eci.arsw.persitencia.Serializable;
import edu.eci.arsw.persitencia.SerializacionPlainText;
import edu.eci.arsw.persitencia.SerializacionBin;
import java.util.LinkedHashMap;
import javax.swing.JTextArea;

/**
 *
 * @author Felipe
 */
public class TypoSuggestText implements TypoSuggestions {

    private final LinkedHashMap<Languages, LinkedHashMap<String, String>> langMaps;
    private LinkedHashMap<String, String> selectedTyposMap;
    private SerializacionPlainText srzPlntxt;
   private DataSource dts;
   private CorrectionStyle crrStyle;
  

    public TypoSuggestText() {
        // srzPlntxt = new SerializacionPlainText();
        //dts= new  StaticDataSource();

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
    public CorrectionStyle getCrrStyle() {
        return crrStyle;
    }

    public void setCrrStyle(CorrectionStyle crrStyle) {
        this.crrStyle = crrStyle;
    }
    

    public SerializacionPlainText getSrzPlntxt() {
        return srzPlntxt;
    }

    public void setSrzPlntxt(SerializacionPlainText srzPlntxt) {
        this.srzPlntxt = srzPlntxt;
    }
    @Override
    public void cargar(JTextArea txa) {
        //To change body of generated methods, choose Tools | Templates.
        srzPlntxt.load(txa);
    }

    @Override
    public void salvar(JTextArea txa) {
        srzPlntxt.save(txa);
    }

    @Override
    public String check(String word, Languages lang) {
     return crrStyle.CorrectionCheck(word, lang, selectedTyposMap);
    }

    @Override
    public void setSelectedLanguage(Languages selectedLanguage) {
        selectedTyposMap = langMaps.get(selectedLanguage);
    }

    @Override
    public Languages getSelectedLanguage() {
        return Languages.ENGLISH;
    }

}
