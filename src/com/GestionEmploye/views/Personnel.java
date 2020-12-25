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
		String nom, prenom, query, keepRunning;
		int age, date,nbrUnites, nbrHeures, choix1, choix2, nbrLigne;
		double chiffreAffaire;
		
		boolean res;
		
		Scanner take = new Scanner(System.in);
		

		
	try {
		
		do {
			

			System.out.println("--------------------Bienvenue Vous Pouvez maintenant gérer vous Employée--------------");
			System.out.println("|_____________________________________________________________________________________|");
			System.out.println("--------------------Pour Gérer vous Employées Veulliez Selectionner 1-----------------");
			System.out.println("-----------------Pour Afficher tous vous Employée Veulliez Selectionner 2-------------");
			System.out.println("----------Pour Afficher le Salaire Moyen dans Votre Societé Veulliez Selectionner 3---");
			
			choix1 = take.nextInt();
			
				
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
								query ="select count(*) from employe where fonction = '" + new Vendeur().function()+"'";
								database.connexion();
								
								resultQuery = database.showLists(query);
								nbrLigne = resultQuery.getType();
								if(nbrLigne == 0)
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
									
								}else
								{
									System.out.println("---------------------Vous avez déja un Vendeur ....vous ne pouvez ajouter un autre !!!-----------");
								}
									
								database.deConnexion();
								
								break;
								
							case 2:
								//Ajoyt d'un employe de Type Representeur
								//Recherche s'il existe un Representeur :
								query ="select count(*) from employe where fonction = '" + new Representeur().function()+"'";
								database.connexion();
								
								resultQuery = database.showLists(query);
								nbrLigne = resultQuery.getType();
								
								if(nbrLigne == 0)
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
									System.out.println("-------------------Vous avez déja un Representeur ....vous ne pouvez ajouter un autre !!!---------------");
								
								database.deConnexion();
								
								break;
					
							case 3:
								//Ajoyt d'un employe de Type Producteur
								//Recherche s'il existe un Producteur :
								query ="select count(*) from employe where fonction = '" + new Producteur().function()+"'";
								database.connexion();
								
								resultQuery = database.showLists(query);
								nbrLigne = resultQuery.getType();
								
								if(nbrLigne == 0)
								{
									System.out.println("---Vous avez Recruter un Producteur Veillez enter le---");
									System.out.println("----------------------------------------------------");
									System.out.println("Entrer le nom du Producteur");
									nom = take.next();
									System.out.println("Entrer le prenom du Producteur");
									prenom = take.next();
									System.out.println("Entrer leur age");
									age = take.nextInt();
									System.out.println("Entrer leur date d'entrée (Année)");
									date = take.nextInt();
									System.out.println("Entrer le Nombre d'unité à produire");
									nbrUnites = take.nextInt();
									employe = new Producteur(nom, prenom, age, date, nbrUnites);
									
									query = "insert into employe values(null,'"+nom+"','"+prenom+"',"+age+","+date+","+employe.calculeSalaire()+",'"+employe.function()+"')";
									res = database.insertOne(query);
									if(res == true)
										System.out.println("Ajout Effectué avec Succes");
									else
										System.out.println("Error!!!Ajout Failed");
									
								}else if(resultQuery.getRow() == 1)
									System.out.println("-------------------Vous avez déja un Producteur ....vous ne pouvez ajouter un autre !!!--------------");
								
								database.deConnexion();
								
								break;
								
							case 4:
								//Ajoyt d'un employe de Type Manutentionnaire
								//Recherche s'il existe un Manutentionnaire :
								query ="select count(*) from employe where fonction = '" + new Manutentionnaire().function()+"'";
								database.connexion();
								
								resultQuery = database.showLists(query);
								nbrLigne = resultQuery.getType();
								
								if(nbrLigne == 0)
								{
									System.out.println("---Vous avez Recruter un Manutentionnaire Veillez enter le---");
									System.out.println("----------------------------------------------------");
									System.out.println("Entrer le nom du Manutentionnaire");
									nom = take.next();
									System.out.println("Entrer le prenom du Manutentionnaire");
									prenom = take.next();
									System.out.println("Entrer leur age");
									age = take.nextInt();
									System.out.println("Entrer leur date d'entrée (Année)");
									date = take.nextInt();
									System.out.println("Entrer le Nombre d'heures à travailler");
									nbrHeures = take.nextInt();
									employe = new Manutentionnaire(nom, prenom, age, date, nbrHeures);
									
									query = "insert into employe values(null,'"+nom+"','"+prenom+"',"+age+","+date+","+employe.calculeSalaire()+",'"+employe.function()+"')";
									res = database.insertOne(query);
									if(res == true)
										System.out.println("Ajout Effectué avec Succes");
									else
										System.out.println("Error!!!Ajout Failed");
									
								}else if(resultQuery.getRow() == 1)
									System.out.println("-------------------Vous avez déja un Manutentionnaire ....vous ne pouvez ajouter un autre !!!--------------");
								
								database.deConnexion();
								
								break;
								
							case 5:
								//Ajoyt d'un employe de Type ProducteurRisqué
								//Recherche s'il existe un ProducteurRisqué :
								query ="select count(*) from employe where fonction = '" + new ProducteurRisquee().function()+"'";
								database.connexion();
								
								resultQuery = database.showLists(query);
								nbrLigne = resultQuery.getType();
								
								if(nbrLigne == 0)
								{
									System.out.println("---Vous avez Recruter un Producteur Risqué Veillez enter le---");
									System.out.println("----------------------------------------------------");
									System.out.println("Entrer le nom du Producteur Risqué");
									nom = take.next();
									System.out.println("Entrer le prenom du Producteur Risqué");
									prenom = take.next();
									System.out.println("Entrer leur age");
									age = take.nextInt();
									System.out.println("Entrer leur date d'entrée (Année)");
									date = take.nextInt();
									System.out.println("Entrer le Nombre d'unité à produire");
									nbrUnites = take.nextInt();
									employe = new ProducteurRisquee(nom, prenom, age, date, nbrUnites);
									
									query = "insert into employe values(null,'"+nom+"','"+prenom+"',"+age+","+date+","+employe.calculeSalaire()+",'"+employe.function()+"')";
									res = database.insertOne(query);
									if(res == true)
										System.out.println("Ajout Effectué avec Succes");
									else
										System.out.println("Error!!!Ajout Failed");
									
								}else if(resultQuery.getRow() == 1)
									System.out.println("-------------------Vous avez déja un Producteur Risqué ....vous ne pouvez ajouter un autre !!!--------------");
								
								database.deConnexion();
								
								break;
								
							case 6:
								//Ajoyt d'un employe de Type Manutentionnaire-risqué
								//Recherche s'il existe un Manutentionnaire-risqué :
								query ="select count(*) from employe where fonction = '" + new MantioRisquee().function()+"'";
								database.connexion();
								
								resultQuery = database.showLists(query);
								nbrLigne = resultQuery.getType();
								
								if(nbrLigne == 0)
								{
									System.out.println("---Vous avez Recruter un Manutentionnaire-risqué Veillez enter le---");
									System.out.println("----------------------------------------------------");
									System.out.println("Entrer le nom du Manutentionnaire-risqué");
									nom = take.next();
									System.out.println("Entrer le prenom du Manutentionnaire-risqué");
									prenom = take.next();
									System.out.println("Entrer leur age");
									age = take.nextInt();
									System.out.println("Entrer leur date d'entrée (Année)");
									date = take.nextInt();
									System.out.println("Entrer le Nombre d'heures à travailler");
									nbrHeures = take.nextInt();
									employe = new MantioRisquee(nom, prenom, age, date, nbrHeures);
									
									query = "insert into employe values(null,'"+nom+"','"+prenom+"',"+age+","+date+","+employe.calculeSalaire()+",'"+employe.function()+"')";
									res = database.insertOne(query);
									if(res == true)
										System.out.println("Ajout Effectué avec Succes");
									else
										System.out.println("Error!!!Ajout Failed");
									
								}else if(resultQuery.getRow() == 1)
									System.out.println("-------------------Vous avez déja un Manutentionnaire-risqué ....vous ne pouvez ajouter un autre !!!--------------");
								
								database.deConnexion();
								
								break;
								
							case 7:
								break;
								
							case 8:
								break;
						}
						
					}else if(choix1 == 2)
					{
						//Afficher tous les employee
						
						query = "select * from employe";
						database.connexion();
						
						resultQuery = database.showLists(query);
						while(resultQuery.next())
						{
							System.out.println(" ID |    nom   |    prenom  |   age   |    Salaire   |      Fonction     |");
							System.out.println(resultQuery.getInt("id_employe")+"|"+resultQuery.getString("nom")+"|"+resultQuery.getString("prenom")+
									"|"+resultQuery.getInt("age")+"|"+resultQuery.getDouble("salaire")+"|"+resultQuery.getString("fonction"));
						}
						
						database.deConnexion();
						
					}else if(choix1 == 3)
					{
						//Afficher le salaire Moyen 
						query = "select AVG(salaire) from employe ";
						database.connexion();
						
						resultQuery = database.showLists(query);
						
						System.out.println("le moyen Salaire de tous les employees est :"+ resultQuery.getType());
						
						database.deConnexion();
						
					}
					
					System.out.println("Voulez Vous Continuer Taper OUI ou NON pour Quitter");
					keepRunning = take.next();
			
		}while(keepRunning.equalsIgnoreCase("OUI"));
		
		System.out.println("Fin du Programme");
		take.close();
		System.out.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
