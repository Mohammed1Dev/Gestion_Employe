package com.GestionEmploye.models;

//abstract Class
public abstract class Employe {
	
    private String nom;
    private String prenom;
    private int age;
    private String date;


    public Employe(String prenom, String nom, int age, String date) 
    {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.date = date;
    }

    
    //abstract method
    public abstract double calculeSalaire();

    
    public String function()
        {
            return "L'employé =>" ;
        }

    public String getNomComplet() 
    {
        return function() + prenom + " " + nom;
    }

    //age & date Getters & Setters
	public int getAge() {
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}

	@Override
	public String toString() 
	{
		return this.getNomComplet() + ",son age :" + age + ",et sa date d'entrée :" + date + "]";
	}
    
    
	
    
}
