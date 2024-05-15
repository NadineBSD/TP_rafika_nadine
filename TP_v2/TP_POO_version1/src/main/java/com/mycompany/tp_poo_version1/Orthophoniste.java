/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_poo_version1;

import java.util.*;

public class Orthophoniste {

    private String nom;
    private String prenom;
    private String numTel;
    private String email;
    private String mdp;
    private String adresse;
    private Set<Patient> setPatients;
    private Agenda agenda;

    Scanner scanner = new Scanner(System.in);

    public Orthophoniste(String nom, String prenom, String numTel, String email, String mdp, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.mdp = mdp;
        this.numTel = numTel;
        this.setPatients = new HashSet<>();
        this.agenda = new Agenda();
    }

    public String getNom() {
        return (this.nom);

    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return (this.prenom);

    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTel() {
        return (this.numTel);

    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return (this.email);

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return (this.adresse);

    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Agenda getAgenda() {
        return (this.agenda);

    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public boolean equals(Object obj) {
        Orthophoniste ortho = (Orthophoniste) obj;
        return this.nom.equals(ortho.nom) && this.prenom.equals(ortho.prenom); //If the objects are the same stance

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nom);
        hash = 29 * hash + Objects.hashCode(this.prenom);
        return hash;
    }

    public void ajouterNouveauPatient() {

        String nom, prenom, dateNaissance, lieuNaissance, adresse, typeString;
        int age;

        System.out.println("Veuillez entrez les informations du patient : ");
        System.out.println("   -> Nom : ");
        nom = scanner.nextLine();
        System.out.println("   -> Prenom : ");
        prenom = scanner.nextLine();
        System.out.println("   -> Age : ");
        age = scanner.nextInt();
        System.out.println("   -> Date de naissance (format jj/mm/aaaa) : ");
        dateNaissance = scanner.nextLine();
        System.out.println("   -> Lieu de naissance : ");
        lieuNaissance = scanner.nextLine();
        System.out.println("   -> Adresse : ");
        adresse = scanner.nextLine();
        System.out.println("   -> Type patient (ENFANT/ADULTE) : ");
        typeString = scanner.nextLine();
        TypePatient type = TypePatient.valueOf(typeString);
        Patient patient = new Patient(nom, prenom, age, dateNaissance, lieuNaissance, adresse, type);

        // since the patient was created for the first time, we're gonna create his 1st rdv
        System.out.println("Veuillez entrer la date et l'heure (format : jj/mm/aaaa-00:00) : ");
        String dateHeure = scanner.nextLine();
        patient.creerConsultation(dateHeure);

        //Ajouter le patient à la liste des patients
        setPatients.add(patient);

    }

    public Patient rechercherPatient(int numDossier, Set<Patient> setPatients) {
        for (Patient patient : setPatients) {
            if (patient.getDossier().getNumDossier() == numDossier) {
                return patient;
            }
        }
        return null; // Patient non trouvé
    }

    public void creerBO() {

        System.out.println("Entrer le num dossier patient : ");
        int numDossier = scanner.nextInt();
        Patient p = rechercherPatient(numDossier, setPatients);

    }

    public void consulterDossier() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrer le num dossier patient : ");
        int numDossier = scanner.nextInt();
        Patient p = rechercherPatient(numDossier, setPatients);
        if (p != null) {
            //p.getDossier().consulterDossier();
        }
        //Rafika will do consulterDossier?
    }

    public void ajouterRdv() throws PatientIntrouvableExcpetion {

        RendezVous rdv = null;

        System.out.println("Veuillez entrer la date et l'heure (format : jj/mm/aaaa-00:00) : ");
        String dateHeure = scanner.nextLine();

        System.out.println("Souhaitez-vous planifier une consultation pour une personne ou un groupe ? ");
        System.out.println("(0) Individuelle     (1) Groupe");
        int choix = scanner.nextInt();

        if (choix == 0) { // Séance de suivi
            System.out.println("Entrer le num dossier patient : ");
            int numDossier = scanner.nextInt();
            Patient p = rechercherPatient(numDossier, setPatients);
            if (p == null) {
                throw new PatientIntrouvableExcpetion("Ce patient est introuvable.");
            } else {
                p.creerSeanceSuivi(dateHeure);
            }
        } else { // Atelier de groupe
            System.out.println("Veuillez entrer le nombre de patients qui vont participer à cet atelier de groupe : ");
            int n = scanner.nextInt();
            int d;
            Set<Patient> setPatientsAtelier = new HashSet<>();
            Set<Integer> setNum = new HashSet<>();
            System.out.println("Veuillez entrer leurs numéro de dossier :");
            for (int i = 0; i < n; i++) {
                System.out.println("    -> Patient " + (i + 1) + " : ");
                d = scanner.nextInt();
                Patient p = rechercherPatient(d, setPatients);
                if (p != null) {
                    setPatientsAtelier.add(p);
                    setNum.add(d);
                } else {
                    throw new PatientIntrouvableExcpetion("Ce patient est introuvable.");
                }
            }
            System.out.println("Veuillez entrer la thématique de l'atelier de groupe : ");
            String thematique = scanner.nextLine();
            rdv = new AtelierGroupe(dateHeure, thematique, setNum);

            System.out.println("Veuillez entrer votre observation : ");
            String observation = scanner.nextLine();
            rdv.setObservation(observation);
            // Après la création du rdv, on l'ajoute à la liste des rdvs de tous les patients qui ont participé à cet atelier
            for (Patient patient : setPatientsAtelier) {
                patient.getDossier().ajouterRdv(rdv);
            }

        }

    }

}
