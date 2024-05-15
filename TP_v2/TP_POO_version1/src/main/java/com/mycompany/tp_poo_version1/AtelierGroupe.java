/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_poo_version1;

import java.util.*;

/**
 *
 * @author DELL
 */
public class AtelierGroupe extends RendezVous {
    
    private String thematique;
    private Set<Integer> setPatients = new HashSet<Integer>();
    
    public AtelierGroupe(String dateHeure, String thematique, Set<Integer> listePatients) {
        super(dateHeure,"1h");
        this.thematique = thematique;
        this.setPatients =  setPatients;      
    }
    
}
