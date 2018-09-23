package com.valparaiso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.valparaiso.beans.UtilisateurBean;
// TODO : a tester
public class UtilisateurDAO {
	private DAOFactory daoFactory;

	public UtilisateurDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}

	public UtilisateurBean getUtilisateurById(int id) throws Exception {
		Connection co = this.daoFactory.getConnection();
		UtilisateurBean uBean = null;

		try {
			String sql = "select LOGINUTILISATEUR, NOMUTILISATEUR, PRENOMUTILISATEUR, MDPUTILISATEUR, IDFORFAIT \n"
					+ "from UTILISATEUR where IDUTILISATEUR = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, id);

			ResultSet result = requete.executeQuery();
			if(result.next()) {
				uBean = new UtilisateurBean(
						id,
						result.getString(1),
						result.getString(2), 
						result.getString(3), 
						result.getString(4),  
						DAOFactory.getInstance().getForfaitDao().getForfaitById(result.getInt(5))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return uBean;
	}
	
	public UtilisateurBean getUtilisateurByLogin(String login) throws Exception {
		Connection co = this.daoFactory.getConnection();
		UtilisateurBean uBean = null;

		try {
			String sql = "select * \n"
					+ "from UTILISATEUR where lower(LOGINUTILISATEUR) = lower(?)";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setString(1, login);

			ResultSet result = requete.executeQuery();
			if(result.next()) {
				uBean = new UtilisateurBean(
						result.getInt(1),
						login,
						result.getString(5),
						result.getString(6), 
						result.getString(4),  
						DAOFactory.getInstance().getForfaitDao().getForfaitById(result.getInt(2))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return uBean;
	}

	public void createUtilisateur(UtilisateurBean u) {
		// TODO : create new user
	}
}
