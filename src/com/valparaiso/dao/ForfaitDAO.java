package com.valparaiso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.valparaiso.beans.ForfaitBean;

public class ForfaitDAO {
	private DAOFactory daoFactory;

	public ForfaitDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}

	public ForfaitBean getForfaitById(int id) throws SQLException {
		Connection co = this.daoFactory.getConnection();
		ForfaitBean fBean = null;

		try {
			String sql = "select LIBELLEFORFAIT \n"
					+ "from FORFAIT where IDFORFAIT = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, id);

			ResultSet result = requete.executeQuery();
			if(result.next()) {
				fBean = new ForfaitBean(
						id,
						result.getString(1)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return fBean;
	}
}
