package com.valparaiso.beans;

public class FichierBean {
	int id;
	UtilisateurBean utilisateur;
	FormatFichierBean format;
	FichierBean parent;
	String libelleUserFichier;
	String libelleTechniqueFichier;
	long tailleFichier;
	Boolean estUnDossier;
	
	/**
	 * Constructeur d'un fichier
	 * @param id id du fichier
	 * @param parent parent du fichier
	 * @param utilisateur utilisateur du fichier
	 * @param format format du fichier
	 * @param libelleUser libelle du fichier pour l'utilisateur
	 * @param libelleTechnique libelle du fichier sur le serveur de fichier
	 * @param tailleFichier taille du fichier
	 * @param estUnDossier indication si le fichier est un dossier
	 */
	public FichierBean(
			int id,
			FichierBean parent,
			UtilisateurBean utilisateur,
			FormatFichierBean format,
			String libelleUser,
			String libelleTechnique,
			long tailleFichier,
			Boolean estUnDossier) {
		
		this.id = id;
		this.parent = parent;
		this.utilisateur = utilisateur;
		this.format = format;
		this.libelleUserFichier = libelleUser;
		this.libelleTechniqueFichier = libelleTechnique;
		this.tailleFichier = tailleFichier;
		this.estUnDossier = estUnDossier;
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
	 * @return the utilisateur
	 */
	public UtilisateurBean getUtilisateur() {
		return utilisateur;
	}
	
	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(UtilisateurBean utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	/**
	 * @return the format
	 */
	public FormatFichierBean getFormat() {
		return format;
	}
	
	/**
	 * @param format the format to set
	 */
	public void setFormat(FormatFichierBean format) {
		this.format = format;
	}
	
	/**
	 * @return the parent
	 */
	public FichierBean getParent() {
		return parent;
	}
	
	/**
	 * @param parent the parent to set
	 */
	public void setParent(FichierBean parent) {
		this.parent = parent;
	}
	
	/**
	 * @return the libelleUserFichier
	 */
	public String getLibelleUserFichier() {
		return libelleUserFichier;
	}
	
	/**
	 * @param libelleUserFichier the libelleUserFichier to set
	 */
	public void setLibelleUserFichier(String libelleUserFichier) {
		this.libelleUserFichier = libelleUserFichier;
	}
	
	/**
	 * @return the libelleTechniqueFichier
	 */
	public String getLibelleTechniqueFichier() {
		return libelleTechniqueFichier;
	}
	
	/**
	 * @param libelleTechniqueFichier the libelleTechniqueFichier to set
	 */
	public void setLibelleTechniqueFichier(String libelleTechniqueFichier) {
		this.libelleTechniqueFichier = libelleTechniqueFichier;
	}
	
	/**
	 * @return the tailleFichier
	 */
	public long getTailleFichier() {
		return tailleFichier;
	}
	
	/**
	 * @param tailleFichier the tailleFichier to set
	 */
	public void setTailleFichier(long tailleFichier) {
		this.tailleFichier = tailleFichier;
	}
	
	/**
	 * @return the estUnDossier
	 */
	public Boolean getEstUnDossier() {
		return estUnDossier;
	}
	
	/**
	 * @param estUnDossier the estUnDossier to set
	 */
	public void setEstUnDossier(Boolean estUnDossier) {
		this.estUnDossier = estUnDossier;
	}
	
}
