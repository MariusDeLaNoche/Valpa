package com.valparaiso.metiers;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.valparaiso.beans.FichierBean;
import com.valparaiso.beans.UtilisateurBean;
import com.valparaiso.dao.FichierDAO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


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
	
	@SuppressWarnings("unchecked")
	public String generateJsonByRootFile(FichierBean root) {
	    JSONObject obj = new JSONObject();
	    obj.put("id", root.getId()); // ID
	    obj.put("text", root.getLibelleUserFichier()); // TEXT
	    obj.put("type", "ROOT FOLDER"); // TYPE
	    obj.put("icon", ""); // ICON
	    obj.put("state", "open"); // STATE
	    
	    ArrayList<Map<String, Object>> children = new ArrayList<Map<String, Object>>();
	    getChildrenJson(root.getChildren(), children);
	    obj.put("children", children); // CHILDREN

		StringWriter out = new StringWriter();
		try {
			obj.writeJSONString(out);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		 
		String jsonText = out.toString();
		return jsonText;
	}
	
	public void getChildrenJson(List<FichierBean> files, ArrayList<Map<String, Object>> mapChild) {
	    for(FichierBean f : files) {
		    Map<String, Object> child  = new HashMap<String, Object>();
		    child.put("id", f.getId()); // ID
		    child.put("text", f.getLibelleUserFichier()); // TEXT
		    if(f.getFormat() != null) { 
		    	child.put("format", f.getFormat().getCodeFormat()); // TYPE
		    	child.put("type", f.getFormat().getTypeFichier().getLibelleTypeFichier()); // TYPE
		    }
		    else
		    	child.put("type", "Folder"); // TYPE
		    if(f.getEstUnDossier())
		    	child.put("icon", ""); // ICON
		    else
		    	child.put("icon", "jstree-file"); // ICON
		    if(!f.getChildren().isEmpty()) {
		    	ArrayList<Map<String, Object>> children = new ArrayList<Map<String, Object>>();
			    getChildrenJson(f.getChildren(), children);
		    	child.put("children", children); // CHILDREN
		    }

		    mapChild.add(child);
	    }
	}
}
