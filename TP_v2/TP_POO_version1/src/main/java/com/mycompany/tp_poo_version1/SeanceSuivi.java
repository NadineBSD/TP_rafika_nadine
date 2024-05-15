/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_poo_version1;

/**
 *
 * @author DELL
 */
public class SeanceSuivi extends RendezVous{
    
    private int etat; // variable pour indiquer si la séance de suivi se déroule en présentiel ou en ligne
                          // 0 presentiel 1 en ligne
    private int numDossier;
    
    public SeanceSuivi(String dateHeure, int etat, int numDossier) {
        super(dateHeure,"1h");
        this.etat = etat;
        this.numDossier = numDossier;
    }
    
}
