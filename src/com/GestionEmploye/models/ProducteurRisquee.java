package com.GestionEmploye.models;

import com.GestionEmploye.interfaces.PrimeRisque;

public class ProducteurRisquee extends Producteur implements PrimeRisque {

	public ProducteurRisquee() {}
    public ProducteurRisquee(String prenom, String nom, int age, int date, int nbr_unite) 
    {
    	
        super(prenom, nom, age, date, nbr_unite);
    }

    public double calculeSalaire() 
    {
        return super.calculeSalaire() + PRIME;
    }
    
    @Override
    public String function()
        {
            return "Producteur-risqué =>";
        }
}
