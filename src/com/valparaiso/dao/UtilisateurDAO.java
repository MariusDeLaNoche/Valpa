package com.valparaiso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.valparaiso.beans.UtilisateurBean;
// TODO : mettre a jour en fonction du bean
public class UtilisateurDAO {
	private DAOFactory daoFactory;

	public UtilisateurDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}

	public UtilisateurBean getUtilisateurById(String id) throws SQLException {
		Connection co = this.daoFactory.getConnection();
		UtilisateurBean uBean = null;

		try {
			String sql = "select loginutilisateur, nomutilisateur, prenomutilisateur, mdputilisateur, isadmin\n"
					+ "from utilisateur where lower(idutilisateur) = lower(?)";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setString(1, id);

			ResultSet result = requete.executeQuery();
			if(result.next()) {
				uBean = new UtilisateurBean(
						id,
						result.getString(1),
						result.getString(2), 
						result.getString(2), 
						result.getString(3),  
						result.getBoolean(4)
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

	}
}
