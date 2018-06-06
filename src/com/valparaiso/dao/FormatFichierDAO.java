package com.valparaiso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.valparaiso.beans.FormatFichierBean;
import com.valparaiso.beans.TypeFichierBean;

public class FormatFichierDAO {
	private DAOFactory daoFactory;
	
	public FormatFichierDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public FormatFichierBean getFormatFichierById(int id) throws Exception {
		Connection co = this.daoFactory.getConnection();
		FormatFichierBean formatFichier = null;
		
		try {
			String sql = "select * from formatfichier where idformat = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, id);

			ResultSet result = requete.executeQuery();
			if(result.next()) {
				formatFichier = new FormatFichierBean(
						id,
						null,
						result.getString(2));
				TypeFichierBean fichierBean = daoFactory.getTypeFichierDao().getTypeFichierById(result.getInt(1));
				formatFichier.setTypeFichier(fichierBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return formatFichier;
	}
	
	public List<FormatFichierBean> getAllFormatFichierByTypeFichier(int idTypeFichier) throws Exception {
		Connection co = this.daoFactory.getConnection();
		List<FormatFichierBean> listFormat = new ArrayList<>();
		
		try {
			String sql = "select * from formatfichier where idtypefichier = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idTypeFichier);

			ResultSet result = requete.executeQuery();
			while(result.next()) {
				FormatFichierBean formatFichier = new FormatFichierBean(
						result.getInt(0),
						null,
						result.getString(2));
				TypeFichierBean fichierBean = daoFactory.getTypeFichierDao().getTypeFichierById(result.getInt(1));
				formatFichier.setTypeFichier(fichierBean);
				
				listFormat.add(formatFichier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return listFormat;
	}
}
