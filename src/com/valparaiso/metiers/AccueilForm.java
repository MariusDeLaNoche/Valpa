package com.valparaiso.metiers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.valparaiso.beans.FichierBean;
import com.valparaiso.beans.UtilisateurBean;
import com.valparaiso.dao.FichierDAO;

public class AccueilForm {
	private FichierDAO fichierDAO;
	
	public AccueilForm(FichierDAO fichierDAO) {
		this.fichierDAO = fichierDAO;
	}
	
	public FichierBean getFichierRootByIdUtilisateur(UtilisateurBean utilisateur) {
		FichierBean root = null;
		try {
			List<FichierBean> fichiers = fichierDAO.getAllFichierByUtilisateur(utilisateur);
			root = fichiers.stream().filter(f -> f.getLibelleTechniqueFichier().equals("root")).findFirst().orElse(null);
			final int rootId = root.getId();
			fichiers = fichiers.stream().filter(f -> f.getId() != rootId).collect(Collectors.toList());
			List<FichierBean> children = fichiers.stream().filter(f -> f.getParent().getId() == rootId).collect(Collectors.toList());
			root.setChildren(children);
			getChildrenFiles(children, fichiers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return root;
	}
	
	public void getChildrenFiles(List<FichierBean> files, List<FichierBean> allFiles) {
		for (FichierBean file : files) {
			final int fileId = file.getId();
			List<FichierBean> children = allFiles.stream().filter(f -> f.getParent().getId() == fileId).collect(Collectors.toList());
			file.setChildren(children);
			getChildrenFiles(file.getChildren(), allFiles);
		}
		
	}
}
