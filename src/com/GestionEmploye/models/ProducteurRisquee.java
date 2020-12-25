package com.GestionEmploye.models;

import com.GestionEmploye.interfaces.PrimeRisque;

class ProducteurRisquee extends Producteur implements PrimeRisque {

    public ProducteurRisquee(String prenom, String nom, int age, String date, int nbr_unite) 
    {
    	
        super(prenom, nom, age, date, nbr_unite);
    }

    public double calculeSalaire() 
    {
        return super.calculeSalaire() + PRIME;
    }
}
