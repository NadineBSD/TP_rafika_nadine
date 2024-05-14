package com.mycompany.tp_poo_version1;

public class Trouble {

	private String nom ;
	private TypeTrouble categorie ;
	
	public Trouble(String nom, String categorie) {
		this.nom = nom ;
		switch (categorie) {
		case "Trouble de déglutition" : this.categorie = TypeTrouble.Deglutition ;
		case "Trouble neuro-dévloppemental" : this.categorie = TypeTrouble.NeuroDevloppemental ;
		case "Trouble cognitif" : this.categorie = TypeTrouble.Cognitif ;
		}
	}

	public String getNom() {
		return nom;
	}

	public String getCategorie() {

		return switch (this.categorie) {
			case Deglutition -> "trouble de la déglutition";
			case NeuroDevloppemental -> "trouble neuro-développemental";
			case Cognitif -> "trouble cognitif";
			default -> "";
		};
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setCategorie(TypeTrouble categorie) {
        this.categorie = categorie;
    }

}
