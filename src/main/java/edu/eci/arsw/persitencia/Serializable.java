/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persitencia;

import javax.swing.JTextArea;

/**
 *
 * @author Felipe
 */
public interface Serializable {
    public void load(JTextArea txa);
    public void save(JTextArea txa);
}
