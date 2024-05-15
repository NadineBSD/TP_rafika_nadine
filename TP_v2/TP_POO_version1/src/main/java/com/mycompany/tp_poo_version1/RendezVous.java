/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_poo_version1;

/**
 *
 * @author DELL
 */
public class RendezVous {
    
    protected TypeRdv type;
    protected String dateHeure;
    protected String duree;
    protected String observation;
    
    public RendezVous(String dateHeure, String duree) {
        this.dateHeure = dateHeure;
        this.duree = duree;
    }
    
    public void setObservation(String observation) {
        this.observation = observation;
    }
    
}
