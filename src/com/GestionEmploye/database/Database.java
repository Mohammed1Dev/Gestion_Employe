package com.GestionEmploye.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Database {

	String  serverName = "jdbc:mysql://localhost:3306/gestion_employee";
	String	userName = "root";
	String	password = "";
	
	Connection myConnection;
	Statement stmt;
	ResultSet result;
	PreparedStatement prestmt;
	
	
	
	 public void connexion()
	 {

		try {
				
				//1.Get a connection to database
				Class.forName("com.mysql.cj.jdbc.Driver");  
				myConnection = DriverManager.getConnection(serverName, userName, password);
				
		
				
			}catch(Exception exc) {
				exc.printStackTrace();
			}
	 }
	 
	 
	 public void deConnexion()
	 {
		 try {
			myConnection.close();
			
		} catch (SQLException exc) {
			
			exc.printStackTrace();
		}
	 }
	 
	 
	 public boolean insertOne(String query)
	 {
			boolean res = false;
				try{  
					
					stmt = myConnection.createStatement();
					
					int statut = stmt.executeUpdate(query);
					if(statut == 1)
					{
						res = true;
					} 
					}catch(Exception e){ 
						
						System.out.println(e.getMessage());
						
					} 	
				
			return res;
	 }
	 
	 public boolean updateContractDate(String query){
			
		 	boolean result = false;
		 	
			try{  
				
						stmt = myConnection.createStatement();
						
						int statut = stmt.executeUpdate(query);
						if(statut == 1)
						{
							result = true;
						} 
				           
			}catch(Exception e){ 
			
					System.out.println(e);
					
			} 
			
			return result;
			
		}
	
	 
		public boolean deleteOne(String query){
			
			boolean result = false;
			;  
			try {
				 
				stmt = myConnection.createStatement();
			    int  statut = stmt.executeUpdate(query);  
			    if(statut == 1)
			    {
			    	result = true;
			    }
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
		return result;
		}
	 
	public ResultSet showLists(String query){
			
		
			try{  
				
			
				 stmt = myConnection.createStatement();
			     result = stmt.executeQuery(query);
			     
			    
			     
				//here sonoo is database name, root is username and password      
				}catch(Exception e){ 
					
					System.out.println(e);
					
				} 	
			 return result;
		}

}