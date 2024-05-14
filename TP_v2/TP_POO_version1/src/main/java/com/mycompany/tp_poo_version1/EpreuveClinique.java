package com.mycompany.tp_poo_version1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class EpreuveClinique {
	
    private String [] observationClinique ; 
    private ArrayList <Test> listeTests ; 
    
    public EpreuveClinique(String [] observationClinique){
        this.observationClinique=observationClinique;
        this.listeTests= new ArrayList<>();

    }

    public void creerTest() 
    {
	Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the patient's name
        System.out.print("Voulez vous creer un Test d'exercices (a) ou un Questionnaire (b)");
        String choix = scanner.nextLine();
        
	/*switch (choix){
		case "a" : creerTestExercices;
		break;
		
		case "b" : creerQuestionnaire;
		break;
	}*/
      

           
    }
    public void creerTestExercices()
    {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("donner le nom d'exercices ");
            String nom = scanner.nextLine();
	    ArrayList<Exercice> exercices;
	    exercices = new  ArrayList<> ();
	    TestExercices e = new TestExercices( nom,  100, exercices);
    }
        public void creerQuestionnaire()
    {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("donner le nom d'exercices ");
            String nom = scanner.nextLine();
	    Set<Question> Questions;
	    Questions= new  Set <> ();
	    Questionnaire q = new Questionnaire( nom,  100,questions);
    }
    
}