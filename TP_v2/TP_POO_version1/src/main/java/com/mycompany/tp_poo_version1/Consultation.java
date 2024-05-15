/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_poo_version1;

/**
 *
 * @author DELL
 */
public class Consultation extends RendezVous {
    
    protected String nom;
    protected String prenom;
    protected int age;
    
    public Consultation(String dateHeure, String duree, String nom, String prenom, int age) {
        super(dateHeure,duree);
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    
}
