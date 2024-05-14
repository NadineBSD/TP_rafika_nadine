/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_poo_version1;

import java.util.ArrayList;
import java.util.Scanner;

public class TestExercices extends Test {

	ArrayList<Exercice> exercices;

	public TestExercices(String nom, int capacite, String conclusion, ArrayList<Exercice> exercices) {
		super(nom, capacite, conclusion);
		this.exercices = exercices;
	}

	@Override
	public float calculeScoreTotal() {

		for (Exercice ex : exercices) {
			scoreTotal = +ex.calculeMoyenne();

		}
		return (scoreTotal);
	}

	public void ajouterExercies(String consigne, String nomMateriel, float scores[]) {
		Exercice exercice = new Exercice(consigne, nomMateriel, scores);
		exercices.add(exercice);

	}

	public int rechercherExercices(String consigne) {
		int pos = 0;
		for (Exercice ex : exercices) {
			if (ex.equals(consigne) == true) {
				break;
			}
			pos++;
		}
		return (pos);
	}

	public void supprimerExercies(String cons) {
		int p = rechercherExercices(cons);
		exercices.remove(p);
	}

	@Override
	
	public void modifier() {
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter the patient's name
		System.out.print("Voulez vous : ");
		System.out.print("1_ Ajouter un exercices. ");
		System.out.print("1_ Rechercher un exercices. ");
		System.out.print("1_ Supprimer un exercices. ");
		int choix = scanner.nextInt();

		switch (choix) {
			case 1:
				System.out.print("Voulez vous entrer la consigne ,nomMateriel , scores");

				String consigne = scanner.nextLine();

				String nomMateriel = scanner.nextLine();

				float[] scores = remplirescore();

				this.ajouterExercies(consigne, nomMateriel, scores);

				break;

			case 2:

				System.out.print("Voulez vous entrer la consigne ,nomMateriel , scores");

				String c = scanner.nextLine();
				this.rechercherExercices(c);

				break;
			case 3:
				System.out.print("Voulez vous entrer la consigne ,nomMateriel , scores");

				String consi = scanner.nextLine();
				this.rechercherExercices(consi);
				this.supprimerExercies(consi);
				break;
		}
	}

	public float[] remplirescore() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Entrer le nombre de foix effectuer ");
		int size = scanner.nextInt();

		float[] score = new float[size];

		// Prompt the user to enter the elements of the array
		System.out.println("Enter the elements of the array:");
		for (int i = 0; i < size; i++) {
			System.out.print("Entrer le score " + (i + 1) + ": ");
			score[i] = scanner.nextFloat();
		}
		return (score);
	}

}
