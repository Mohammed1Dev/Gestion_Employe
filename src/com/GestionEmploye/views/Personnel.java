package com.GestionEmploye.views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.GestionEmploye.database.Database;
import com.GestionEmploye.models.*;

public class Personnel {
	

	public static void main(String[] args) {
		
		Employe employe;
		Database database = new Database();
		ResultSet resultQuery;
		String nom, prenom, fonction, query, keepRunnig;
		int age, date, choix1, choix2;
		double chiffreAffaire;
		
		boolean res;
		
		Scanner take = new Scanner(System.in);
		

	
		System.out.println("--------------------Bienvenue Vous Pouvez maintenant gérer vous Employée--------------");
		System.out.println("|_____________________________________________________________________________________|");
		System.out.println("--------------------Pour Gérer vous Employées Veulliez Selectionner 1-----------------");
		System.out.println("-----------------Pour Afficher tous vous Employée Veulliez Selectionner 2-------------");
		System.out.println("----------Pour Afficher le Salaire Moyen dans Votre Societé Veulliez Selectionner 3---");
		
		choix1 = take.nextInt();
		
			try {
				if(choix1 == 1)
				{
					System.out.println("--------------------Pour Ajouter Un Employée(Vendeur) Veulliez Selectionner 1-----------------");
					System.out.println("--------------------Pour Ajouter Un Employée(Representeur) Veulliez Selectionner 2------------");
					System.out.println("--------------------Pour Ajouter Un Employée(Producteur) Veulliez Selectionner 3--------------");
					System.out.println("--------------------Pour Ajouter Un Employée(Manutentionnaire) Veulliez Selectionner 4--------");
					System.out.println("--------------------Pour Ajouter Un Employée(ProducteurRisqué) Veulliez Selectionner 5--------");
					System.out.println("--------------------Pour Ajouter Un Employée(MantioRisqué) Veulliez Selectionner 6------------");
					System.out.println("--------------------NB: Que vous Pouvez Ajouter Un Seule Type D'employée-!!!------------------");
					System.out.println("------------------~--Pour Modifier Un Employée Veulliez Selectionner 7------------------------");
					System.out.println("------------------~--Pour Supprimer Un Employée Veulliez Selectionner 8-----------------------");
					
					choix2 = take.nextInt();
					
					switch(choix2)
					{
						case 1:
							//Ajout d'un Employe de Type Vendeur
								//Recherche s'il existe un Vendeur :
							query ="select * from employe where fonction = '" + new Vendeur().function();
							database.connexion();
							
							resultQuery = database.showLists(query);
							
							if(resultQuery.getRow() == 0)
							{
								System.out.println("---Vous avez Recruter un Vendeur Veillez enter le---");
								System.out.println("----------------------------------------------------");
								System.out.println("Entrer le nom du vendeur");
								nom = take.next();
								System.out.println("Entrer le prenom du Vendeur");
								prenom = take.next();
								System.out.println("Entrer leur age");
								age = take.nextInt();
								System.out.println("Entrer leur date d'entrée (Année)");
								date = take.nextInt();
								System.out.println("Entrer le Chiffre d'affaire de la Societé");
								chiffreAffaire = take.nextDouble();
								employe = new Vendeur(nom, prenom, age, date, chiffreAffaire);
								
								query = "insert into employe values(null,'"+nom+"','"+prenom+"',"+age+","+date+","+employe.calculeSalaire()+",'"+employe.function()+"')";
								res = database.insertOne(query);
								if(res == true)
									System.out.println("Ajout Effectué avec Succes");
								else
									System.out.println("Error!!!Ajout Failed");
								
							}else if(resultQuery.getRow() == 1)
								System.out.println("Vous avez déja un Vendeur ....vous ne pouvez ajouter un autre !!!");
							
							break;
							
						case 2:
							//Ajoyt d'un employe de Type Representeur
							//Recherche s'il existe un Representeur :
							query ="select * from employe where fonction = '" + new Representeur().function();
							database.connexion();
							
							resultQuery = database.showLists(query);
							
							if(resultQuery.getRow() == 0)
							{
								System.out.println("---Vous avez Recruter un Representeur Veillez enter le---");
								System.out.println("----------------------------------------------------");
								System.out.println("Entrer le nom du Representeur");
								nom = take.next();
								System.out.println("Entrer le prenom du Representeur");
								prenom = take.next();
								System.out.println("Entrer leur age");
								age = take.nextInt();
								System.out.println("Entrer leur date d'entrée (Année)");
								date = take.nextInt();
								System.out.println("Entrer le Chiffre d'affaire de la Societé");
								chiffreAffaire = take.nextDouble();
								employe = new Vendeur(nom, prenom, age, date, chiffreAffaire);
								
								query = "insert into employe values(null,'"+nom+"','"+prenom+"',"+age+","+date+","+employe.calculeSalaire()+",'"+employe.function()+"')";
								res = database.insertOne(query);
								if(res == true)
									System.out.println("Ajout Effectué avec Succes");
								else
									System.out.println("Error!!!Ajout Failed");
								
							}else if(resultQuery.getRow() == 1)
								System.out.println("Vous avez déja un Representeur ....vous ne pouvez ajouter un autre !!!");
							break;
							
						case 3:
							
							break;
							
						case 4:
							break;
							
						case 5:
							break;
							
						case 6:
							break;
							
						case 7:
							break;
							
						case 8:
							break;
					}
					
				}else if(choix1 == 2)
				{
					
				}else if(choix1 == 3)
				{
					
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
