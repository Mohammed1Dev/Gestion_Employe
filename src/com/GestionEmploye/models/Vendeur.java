package com.GestionEmploye.models;

class Vendeur extends Employe {
	
    private final double POURCENTAGE = 0.2;
    private final int BONUS = 1500;
    
    private double chiffreAffaire;

    public Vendeur(String prenom, String nom, int age, String date, double chiffreAffaire) 
    {
        super(prenom, nom, age, date);
        this.chiffreAffaire = chiffreAffaire;
        
    }

    
    public double calculeSalaire() 
    {
    	
        return (this.POURCENTAGE * this.chiffreAffaire) + this.BONUS;
    }

    @Override
    public String function()
        {
            return "Le vendeur =>";
        }
    

}
