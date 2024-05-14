package com.mycompany.tp_poo_version1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EpreuveClinique {

	private String observationClinique;
	private Set<Test> setTests;

	public EpreuveClinique(String observationClinique, Set setTest) {
		this.observationClinique = observationClinique;
		this.setTests = new HashSet<>();

	}

	public void creerTest(Set setTest) {
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter the patient's name
		System.out.print("Voulez vous creer un Test d'exercices (a) ou un Questionnaire (b)");
		String choix = scanner.nextLine();
		Test t;
		switch (choix) {
			case "a":
				t = creerTestExercices();

				t.modifier();
				setTests.add(t);

			case "b":
				t = creerQuestionnaire();
				t.modifier();
				setTests.add(t);

		}

	}

	public TestExercices creerTestExercices() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("donner le nom d'exercices ");
		String nom = scanner.nextLine();
		System.out.print("donner la conclusion d'exercices ");
		String conclusion = scanner.nextLine();
		ArrayList<Exercice> exercices;
		exercices = new ArrayList<>();
		TestExercices e = new TestExercices(nom, 10, conclusion, exercices);
		return (e);
	}

	public Questionnaire creerQuestionnaire() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("donner le nom de questionnaire ");
		String nom = scanner.nextLine();
		System.out.print("donner la conclusion ");
		String conclusion = scanner.nextLine();
		Set<Question> Questions = new HashSet();
		Questionnaire q = new Questionnaire(nom, 10, conclusion, Questions);
		return (q);
	}
	public void setObservationClinique(String observation)
	{
		this.observationClinique = observation;
	}
	public String getObservationClinique(String observation)
	{
		return(this.observationClinique) ;
	}

}
