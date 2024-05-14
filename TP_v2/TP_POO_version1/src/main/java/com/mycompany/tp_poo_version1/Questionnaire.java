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

	public void ajouterQuestion() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Voulez vous ajouter :");
		System.out.print("1_ Ajouter une QCM. ");
		System.out.print("2_ Rechercher une QCU . ");
		System.out.print("3_ Ajouter une Question Libre. ");
		int c = scanner.nextInt();
		switch (c) {
			case 1 -> {
				System.out.print("Voulez donner l'enonce :");
				String enonce = scanner.nextLine();
				ajouterQCM(enonce);
			}
			case 2 -> {
				System.out.print("Voulez donner l'enonce :");
				String enonc = scanner.nextLine();
				ajouterQCU(enonc);
			}
			case 3 -> {
				System.out.print("Voulez donner l'enonce :");
				String enon = scanner.nextLine();
				QuestionLibre qst = new QuestionLibre(enon);
				setQuestions.add(qst);
				
			}
		}

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

	@Override
	public void modifier() {
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter the patient's name
		System.out.print("Voulez vous : ");
		System.out.print("1_ Ajouter une question. ");
		System.out.print("2_ Rechercher une question . ");
		System.out.print("3_ Supprimer une question . ");
		int choix = scanner.nextInt();

		switch (choix) {
			case 1:
				ajouterQuestion();

			case 2:

				System.out.print("Voulez vous entrer la consigne ");

				String enonce = scanner.nextLine();
				this.rechercherQuestion(enonce);
				break;
			case 3:
				System.out.print("Voulez vous entrer la consigne ");
				String enonc = scanner.nextLine();
				this.supprimerQuestion(enonc);

				break;
		}
	}

	public void ajouterQCM(String enonce) {
		QCM qst = new QCM(enonce);
		qst.remplireListRF();
		qst.remplireListRJ();
		setQuestions.add(qst);

	}

	public void ajouterQCU(String enonce) {
		QCU qst = new QCU(enonce);

		qst.remplireListRF();
		qst.remplireListRJ();
		setQuestions.add(qst);

	}

}
