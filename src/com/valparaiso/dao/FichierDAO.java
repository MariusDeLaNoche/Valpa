package com.valparaiso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valparaiso.beans.FichierBean;
import com.valparaiso.beans.FormatFichierBean;
import com.valparaiso.beans.UtilisateurBean;

public class FichierDAO {
	private DAOFactory daoFactory;
	
	public FichierDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	
	public List<FichierBean> getAllFichierByUtilisateur(UtilisateurBean utilisateur) throws Exception {
		Connection co = this.daoFactory.getConnection();
		List<FichierBean> listFichier = new ArrayList<>();
		
		try {
			String sql = "select * from fichier where lower(idutilisateur) = lower(?)";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, utilisateur.getId());

			ResultSet result = requete.executeQuery();
			while(result.next()) {
				FichierBean fichier = new FichierBean(
						result.getInt(0),
						null,
						utilisateur,
						null,
						result.getString(4),
						result.getString(5),
						result.getLong(6),
						result.getBoolean(7));
				
				// Récupération du fichier parent si présent
				int idParent = result.getInt(1);
				if(idParent != 0) {
					// On regarde dans la liste si le FichierBean correspondant a déjà été récupéré
					FichierBean fichierParent = listFichier.stream().filter(f -> f.getId() == idParent).findFirst().orElse(null);
					if(fichierParent == null)
						fichierParent = getFichierById(listFichier, idParent);
					fichier.setParent(fichierParent);
				}				
				
				// Récupération du format du fichier
				int idFormat = result.getInt(3);
				if(idFormat != 0) {
					FormatFichierBean formatFichier = daoFactory.getFormatFichierDao().getFormatFichierById(result.getInt(3));
					fichier.setFormat(formatFichier);
				}
				
				listFichier.add(fichier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return listFichier;
	}
	
	public FichierBean getFichierById(List<FichierBean> listFichier, int idFichier) throws Exception {
		Connection co = this.daoFactory.getConnection();
		FichierBean fichier = null;
		
		try {
			String sql = "?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idFichier);

			ResultSet result = requete.executeQuery();
			if(result.next()) {
				fichier = new FichierBean(
						result.getInt(0),
						null,
						null,
						null,
						result.getString(4),
						result.getString(5),
						result.getLong(6),
						result.getBoolean(7));
				
				// Récupération du fichier parent si présent
				int idParent = result.getInt(1);
				if(idParent != 0) {
					// On regarde dans la liste si le FichierBean correspondant a déjà été récupéré
					FichierBean fichierParent = listFichier.stream().filter(f -> f.getId() == idParent).findFirst().orElse(null);
					if(fichierParent == null)
						fichierParent = getFichierById(listFichier, idParent);
					fichier.setParent(fichierParent);
				}				
				
				// Récupération de l'utilisateur
				int idUtilisateur = result.getInt(2);
				if(idUtilisateur != 0) {
					UtilisateurBean utilisateur = daoFactory.getUtilisateurDao().getUtilisateurById(idUtilisateur);
					fichier.setUtilisateur(utilisateur);
				}
				
				// Récupération du format du fichier
				int idFormat = result.getInt(3);
				if(idFormat != 0) {
					FormatFichierBean formatFichier = daoFactory.getFormatFichierDao().getFormatFichierById(result.getInt(3));
					fichier.setFormat(formatFichier);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return fichier;
	}
}
