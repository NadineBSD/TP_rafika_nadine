package com.mycompany.tp_poo_version1;

import java.util.*;

public class Questionnaire extends Test {    
    
    private Set<Question> setQuestions;

    public Questionnaire(String nom, int capacite, String conclusion) {
        super(nom, capacite, conclusion);
        this.setQuestions = new HashSet<Question>();
    }

    public ArrayList<Question> getListeQuestion() {
        return listeQuestion;
    }

    public void setListeQuestion(ArrayList<Question> listeQuestion) {
        this.listeQuestion = listeQuestion;
    }

    public void addQuestion(String enonce) {
        Question qst = new Question(enonce);
        listeQuestion.add(qst);
    }

    @Override
    public float calculeScoreTotal() {
        int totalScore = 0;
        for (Question question : listeQuestion) {
            totalScore += question.getScore();
        }
        return totalScore;
    }

    public int rechercherQuestion(String enonce) {
        int pos = 0;
        for (Question ex : listeQuestion) {
            if (ex.equals(ex) == true) {
                break;
            }
            pos++;
        }
        return (pos);
    }

    public void supprimerQuestion(String enonce) {
        int p = rechercherQuestion(enonce);
        listeQuestion.remove(p);
    }

    public void consulterTest() {
        if (!listeQuestion.isEmpty()) {
            for (int i = 0; i < listeQuestion.size(); i++) {
                System.out.println(listeQuestion.get(i).consulterTest());
            }
        }

    }
}
