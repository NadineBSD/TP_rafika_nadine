package com.mycompany.tp_poo_version1;

import java.util.*;

public class Questionnaire extends Test {

    private Set<Question> setQuestions;

    public Questionnaire(String nom, int capacite, String conclusion) {
        super(nom, capacite, conclusion);
        this.setQuestions = new HashSet<>();
    }

    public Set<Question> getSetQuestions() {
        return setQuestions;
    }

    public void setSetQuestion(Set<Question> setQuestions) {
        this.setQuestions = setQuestions;
    }

    public void addQuestion(String enonce) {
        Question qst = new Question(enonce);
        setQuestions.add(qst);
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
}
