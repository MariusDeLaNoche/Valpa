package com.valparaiso.beans;

public class FormatFichierBean {
	int id;
	TypeFichierBean typeFichier;
	String codeFormat;
	
	/**
	 * Constructeur d'un format de fichier
	 * @param id id du format
	 * @param typeFichier Type du format
	 * @param codeFormat Code du format
	 */
	public FormatFichierBean(int id, TypeFichierBean typeFichier, String codeFormat) {
		this.id = id;
		this.typeFichier = typeFichier;
		this.codeFormat = codeFormat;
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
	 * @return the typeFichier
	 */
	public TypeFichierBean getTypeFichier() {
		return typeFichier;
	}
	
	/**
	 * @param typeFichier the typeFichier to set
	 */
	public void setTypeFichier(TypeFichierBean typeFichier) {
		this.typeFichier = typeFichier;
	}
	
	/**
	 * @return the codeFormat
	 */
	public String getCodeFormat() {
		return codeFormat;
	}
	/**
	 * @param codeFormat the codeFormat to set
	 */
	public void setCodeFormat(String codeFormat) {
		this.codeFormat = codeFormat;
	}
	
}
