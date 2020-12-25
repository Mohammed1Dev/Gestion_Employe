package com.GestionEmploye.models;

class Manutentionnaire extends Employe {
	
    private final double HEUR_PRICE = 50;
    private int nbrHeurs;

    public Manutentionnaire(String prenom, String nom, int age, String date, int nbrHeurs) 
    {
        super(prenom, nom, age, date);
        this.nbrHeurs = nbrHeurs;
    }

    
    public double calculeSalaire() 
    {
    	
        return this.HEUR_PRICE * this.nbrHeurs;
    }

    @Override
    public String function()
        {
            return "Le Manutentionnaire =>" ;
        }
}
