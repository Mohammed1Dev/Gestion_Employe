package com.GestionEmploye.models;

import com.GestionEmploye.interfaces.PrimeRisque;

public class MantioRisquee extends Manutentionnaire implements PrimeRisque {

	public MantioRisquee() {}
    public MantioRisquee(String prenom, String nom, int age, int date, int nbr_heures) 
    {
        super(prenom, nom, age, date, nbr_heures);
    }

    public double calculeSalaire() {
        return super.calculeSalaire() + PRIME;
    }
    
    @Override
    public String function()
        {
            return "Manutentionnaire-risqu� =>";
        }
}
