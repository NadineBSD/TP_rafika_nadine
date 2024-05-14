package com.mycompany.tp_poo_version1;

import java.util.*;

public class Questionnaire extends Test {

	private Set<Question> setQuestions;

	public Questionnaire(String nom, int capacite, String conclusion, Set setQuestions) {
		super(nom, capacite, conclusion);
		this.setQuestions = new HashSet<>();
	}

	public Set<Question> getSetQuestions() {
		return setQuestions;
	}

	public void setSetQuestion(Set<Question> setQuestions) {
		this.setQuestions = setQuestions;
	}

	public void ajouterQuestion(String enonce) {
		Question qst;

		//setQuestions.add(qst);
	}

	@Override
	public float calculeScoreTotal() {
		int totalScore = 0;
		for (Question question : setQuestions) {
			totalScore += question.getScore();
		}
		return totalScore;
	}

	public int rechercherQuestion(String enonce) {
		int pos = 0;
		for (Question ex : setQuestions) {
			if (ex.equals(ex) == true) {
				break;
			}
			pos++;
		}
		return (pos);
	}

	public void supprimerQuestion(String enonce) {
		int p = rechercherQuestion(enonce);
		setQuestions.remove(p);
	}

	// @Override
	public void consulterTest() {
		// Affichage 
		Iterator<Question> it = setQuestions.iterator();
		Question q = null;

		while (it.hasNext()) {
			q = it.next();
			System.out.println(q.getEnonce());
		}

	}

	public void modifier() {
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter the patient's name
		System.out.print("Voulez vous : ");
		System.out.print("1_ Ajouter une question. ");
		System.out.print("1_ Rechercher une question . ");
		System.out.print("1_ Supprimer une question . ");
		int choix = scanner.nextInt();

		switch (choix) {
			case 1:
				System.out.print("Voulez vous  la consigne ,nomMateriel , scores");

				break;

			case 2:

				System.out.print("Voulez vous entrer la consigne ");

				String enonce = scanner.nextLine();
				this.rechercherQuestion(enonce);
				break;
			case 3:
				System.out.print("Voulez vous entrer la consigne ");
				String enonce = scanner.nextLine();
				this.supprimerQuestion(enonce);

				break;
		}
	}

	public QCM ajouterQCM(Question qst,String enonce) {
		qst = new QCM(enonce);
		qst
		

	}

	
	
}
