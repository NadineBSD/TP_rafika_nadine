package com.mycompany.tp_poo_version1;

import java.util.ArrayList;

public class Dossier {

    // HHH MEOW MEOW MEOW
    private int numDossier;
    private static int cpt;
    private ArrayList<RendezVous> listeRdv = new ArrayList<>();
    private ArrayList<BO> listeBO = new ArrayList<>();
    private ArrayList<FicheDeSuivi> listeFicheSuivi = new ArrayList<>();

    public Dossier() {
        this.numDossier = ++cpt;
    }
    
    public Dossier(ArrayList<RendezVous> listeRdv, ArrayList<BO> listeBO, ArrayList<FicheDeSuivi> listeFicheSuivi) {
        this.numDossier = ++cpt;
        this.listeRdv = listeRdv;
        this.listeBO = listeBO;
        this.listeFicheSuivi = listeFicheSuivi;
    }

    // Getters
    public int getNumDossier() {
        return numDossier;
    }

    public ArrayList<RendezVous> getListeRdv() {
        return listeRdv;
    }

    public ArrayList<BO> getListeBO() {
        return listeBO;
    }

    public ArrayList<FicheDeSuivi> getListeFicheSuivi() {
        return listeFicheSuivi;
    }

    // Setters
    public void setListeRdv(ArrayList<RendezVous> listeRdv) {
        this.listeRdv = listeRdv;
    }

    public void setListeBO(ArrayList<BO> listeBO) {
        this.listeBO = listeBO;
    }

    public void setListeFicheSuivi(ArrayList<FicheDeSuivi> listeFicheSuivi) {
        this.listeFicheSuivi = listeFicheSuivi;
    }

    public void ajouterRdv(RendezVous rdv) {
        listeRdv.add(rdv);
    }
    /*
    public void consulterDossier() {
        System.out.println("Numéro dossier :" + numDossier);
        System.out.println("RendezVous:");
        for (RendezVous rdv : listeRdv) {
            System.out.println(" - " + rdv); // Assuming RendezVous class has overridden toString() method
        }
        System.out.println("BO:");
        for (BO bo : listeBO) {
            System.out.println(" - " + bo); // Assuming BO class has overridden toString() method
        }
        System.out.println("Fiche de Suivi:");
        for (FicheDeSuivi fiche : listeFicheSuivi) {
            System.out.println(" - " + fiche); // Assuming FicheDeSuivi class has overridden toString() method
        }
    }*/
}
