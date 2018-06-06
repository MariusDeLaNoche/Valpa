package com.valparaiso.beans;

public class TypeFichierBean {
	int id;
	String libelleTypeFichier;

	/**
	 * Constructeur d'un type de fichier
	 * @param id id du type
	 * @param libelle libelle du type
	 */
	public TypeFichierBean(int id, String libelle) {
		this.id = id;
		this.libelleTypeFichier = libelle;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the libelleTypeFichier
	 */
	public String getLibelleTypeFichier() {
		return libelleTypeFichier;
	}

	/**
	 * @param libelleTypeFichier the libelleTypeFichier to set
	 */
	public void setLibelleTypeFichier(String libelleTypeFichier) {
		this.libelleTypeFichier = libelleTypeFichier;
	}
}
