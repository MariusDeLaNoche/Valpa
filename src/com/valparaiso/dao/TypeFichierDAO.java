package com.valparaiso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.valparaiso.beans.TypeFichierBean;

public class TypeFichierDAO {
	private DAOFactory daoFactory;
	
	public TypeFichierDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public TypeFichierBean getTypeFichierById(int id) throws SQLException {
		Connection co = this.daoFactory.getConnection();
		TypeFichierBean typeFichier = null;
		
		try {
			String sql = "select * from typefichier where idtypefichier = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, id);

			ResultSet result = requete.executeQuery();
			if(result.next()) {
				typeFichier = new TypeFichierBean(
						id,
						result.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return typeFichier;
	}
}
