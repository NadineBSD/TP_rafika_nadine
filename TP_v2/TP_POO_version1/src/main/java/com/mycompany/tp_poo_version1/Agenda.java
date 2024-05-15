/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_poo_version1;

import java.util.*;

public class Agenda {
    private Map<String, ArrayList<RendezVous>> mapRdv; 

    public Agenda() {
        mapRdv = new HashMap<>();
    }

    // Method to add an appointment to the agenda
    public void ajouterRdv(String date, RendezVous rendezVous) {
        mapRdv.computeIfAbsent(date, k -> new ArrayList<>()).add(rendezVous);
    }

    // Method to get appointments for a specific date
    public ArrayList<RendezVous> getRdv(String date) {
        return mapRdv.getOrDefault(date, new ArrayList<>());
    }

    // Other methods as needed...
}
