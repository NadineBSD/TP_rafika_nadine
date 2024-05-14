/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_poo_version1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Rafika MK
 */
public class Orthophoniste {

	private String nom;
	private String prenom;
	private String numTel;
	private String email;
	private String adresse;
	private Set<Patient> setPatients;

	public Orthophoniste(String nom, String prenom, String numTel, String email, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.numTel = numTel;
		this.setPatients = new HashSet<>();
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

	/**
	 *
	 * @param obj
	 * @return
	 */
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

	public void creerTest() {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Entrer le nom patient : ");
		String nom = scanner.nextLine();

		System.out.println("Entrer le prenom de patient: ");
		String prenom = scanner.nextLine();

		System.out.println("Entrer le  patient ID: ");
		int id = scanner.nextInt();
		//here it gonna do patient.research 3la 7ssab le nom l id wa prenom 
		//nadine tdir patient so I need thouse classes 
		//Appelle la methode patient.creer test 
	}

}
