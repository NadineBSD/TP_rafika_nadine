package com.mycompany.tp_poo_version1;

import java.util.*;

class Patient {

    private Dossier dossier;
    private int nbBO;
    private int nbRdv;
    private String nom;
    private String prenom;
    private int age;
    private String dateNaissance;
    private String lieuNaissance;
    private String adresse;
    private TypePatient type;
    Scanner scanner = new Scanner(System.in);

    public Patient(String nom, String prenom, int age, String dateNaissance, String lieuNaissance, String adresse, TypePatient type) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
        this.type = type;
    }

    public void creerDossier() {
        Dossier dossier = new Dossier();
    }

    // Getters
    public Dossier getDossier() {
        return dossier;
    }

    public int getNbBO() {
        return nbBO;
    }

    public int getNbRdv() {
        return nbRdv;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    // Setters
    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public void setNbBO(int nbBO) {
        this.nbBO = nbBO;
    }

    public void setNbRdv(int nbRdv) {
        this.nbRdv = nbRdv;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void passerBO() {

    }

    public void creerRdv(String dateHeure) {
        // this one is to create a rdv for the patient when he comes
        // It's gonna be either a consultation or Séance de suivi

        RendezVous rdv = null;

        if (nbRdv == 0) { // la 1ère fois que le patient se présente : Consultation
            // Création d'un dossier (since it's the first time this person registers in here)
            creerDossier();
            this.nbRdv++;
            if (type == TypePatient.ENFANT) {
                rdv = new ConsultationEnfant(dateHeure, nom, prenom, age); // Le rdv pour enfant a été crée avec succès
            } else {
                if (type == TypePatient.ADULTE) {
                    rdv = new ConsultationAdulte(dateHeure, nom, prenom, age); // Le rdv pour adulte a été crée avec succès
                }
            }
        } else { // pas la première fois : Séance de suivi
            System.out.println("Le rendez-vous va-t-il se dérouler en présentiel (0) ou en ligne (1) ? : ");
            int etat = scanner.nextInt();
            if (etat == 0) { // présentiel
                rdv = new SeanceSuivi(dateHeure, etat, dossier.getNumDossier());
            }
        }

        System.out.println("Veuillez entrer votre observation : ");
        String observation = scanner.nextLine();
        rdv.setObservation(observation);
        // Après la création du rdv, on l'ajoute à la liste des rdvs du patient
        dossier.ajouterRdv(rdv);
    }

    // Override equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Patient patient = (Patient) o;
        return dossier.getNumDossier() == dossier.getNumDossier();
    }

    // Override hashCode() method
    @Override
    public int hashCode() {
        return Objects.hash(dossier.getNumDossier());
    }

    public Patient rechercherPatient(int numDossier, HashSet<Patient> setPatients) {
        for (Patient patient : setPatients) {
            if (patient.getDossier().getNumDossier() == numDossier) {
                return patient;
            }
        }
        return null; // Patient non trouvé
    }

}

        /*public void creerRdv (Set<Patient> setPatients) throws PatientIntrouvableExcpetion {
        // this one is to create a rdv for the patient when he comes
        // It's gonna be either a consultation or Séance de suivi
        
        RendezVous rdv = null;
        System.out.println("Veuillez entrer : ");
        System.out.println("     -> une date : ");
        String date = scanner.nextLine();
        System.out.println("     -> une heure : ");
        String heure = scanner.nextLine();
        System.out.println("Souhaitez-vous planifier une consultation pour une personne ou un groupe ? ");
        System.out.println("(0) Individuelle     (1) Groupe");
        int choix = scanner.nextInt();
        
        if (choix == 0) { // Consultation ou Séance de suivi
            if (nbRdv == 0) { // la 1ère fois que le patient se présente : Consultation
                // Création d'un dossier (since it's the first time this person registers in here)
                creerDossier();
                if (type == TypePatient.ENFANT) {
                    rdv = new ConsultationEnfant(date, heure, nom, prenom, age); // Le rdv pour enfant a été crée avec succès
                } else {
                    if (type == TypePatient.ADULTE) {
                        rdv = new ConsultationAdulte(date, heure, nom, prenom, age); // Le rdv pour adulte a été crée avec succès
                    }
                }
            } else { // pas la première fois : Séance de suivi
                System.out.println("Le rendez-vous va-t-il se dérouler en présentiel (0) ou en ligne (1) ? : ");
                int etat = scanner.nextInt();
                if (etat == 0) { // présentiel
                    rdv = new SeanceSuivi(date, heure, etat, dossier.getNumDossier());
                }
            }
        } else { // Atelier de groupe
            System.out.println("Veuillez entrer le nombre de patients qui vont participer à cet atelier de groupe : ");
            int n = scanner.nextInt();
            int d;
            Set<Integer> setNum = new HashSet<>();
            System.out.println("Veuillez entrer leurs numéro de dossier :");
            for (int i = 0; i < n; i++) {
                System.out.println("    -> Patient " + (i + 1) + " : ");
                d = scanner.nextInt();
                if (rechercherPatient(d,setPatients) != null) {
                    setNum.add(d);
                } else {
                    throw new PatientIntrouvableExcpetion("Ce patient est introuvable.");
                }
            }
            setNum.add(dossier.getNumDossier()); // on ajoute le patient qui fait la demande
            System.out.println("Veuillez entrer la thématique de l'atelier de groupe : ");
            String thematique = scanner.nextLine();
            rdv = new AtelierGroupe(date, heure, thematique, setNum);
        }
        
        System.out.println("Veuillez entrer votre observation : ");
        String observation = scanner.nextLine();
        rdv.setObservation(observation);
        // Après la création du rdv, on l'ajoute à la liste des rdvs du patient
        dossier.ajouterRdv(rdv);
    }

    // Override equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Patient patient = (Patient) o;
        return dossier.getNumDossier() == dossier.getNumDossier();
    }*/
