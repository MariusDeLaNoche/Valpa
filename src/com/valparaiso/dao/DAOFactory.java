package com.valparaiso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
	// TODO : changer info base
	private String url;
	private String username;
	private String password;


	/**
	 * Constructeur
	 * @param url
	 * @param username
	 * @param password
	 */
	DAOFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}


	/**
	 * Créé une connexion à la BdD et instancie un DAOFactory en cas de succès
	 * @return instance de DAOFactory
	 * @throws Exception
	 */
	public static DAOFactory getInstance() throws Exception {
		// Recup du driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Le driver SQL est introuvable");
		}

		DAOFactory instance = new DAOFactory("localhost:5432/BaseValpa", "postgres", "password");
		return instance;
	}

	/**
	 * Fournit la connection à la BdD
	 * @return la connection
	 * @throws SQLException
	 */
	Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(("jdbc:postgresql://" + url), username, password);
		} catch (SQLException e) {
			throw new SQLException("Erreur de connection à la base de données. Veuillez contacter l'administrateur système. ");
		}
	}

	/*
	 * Méthodes de récupération de l'implémentation des différents DAO
	 */
	public UtilisateurDAO getUtilisateurDao() {
		return new UtilisateurDAO(this);
	}
	
	/*
	 * Méthodes de récupération de l'implémentation des différents DAO
	 */
	public ForfaitDAO getForfaitDao() {
		return new ForfaitDAO(this);
	}
	
	/*
	 * Méthodes de récupération de l'implémentation des différents DAO
	 */
	public TypeFichierDAO getTypeFichierDao() {
		return new TypeFichierDAO(this);
	}
	
	/*
	 * Méthodes de récupération de l'implémentation des différents DAO
	 */
	public FormatFichierDAO getFormatFichierDao() {
		return new FormatFichierDAO(this);
	}
	
	/*
	 * Méthodes de récupération de l'implémentation des différents DAO
	 */
	public FichierDAO getFichierDao() {
		return new FichierDAO(this);
	}
}
