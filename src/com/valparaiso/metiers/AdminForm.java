package com.valparaiso.metiers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.valparaiso.dao.DAOFactory;

@MultipartConfig
public final class AdminForm {
	private DAOFactory daoFactory;
	private Map<String, String> messages = new HashMap<>();

	public AdminForm(DAOFactory d) {
		this.daoFactory = d;
	}

	/**
	 * @return les messages à afficher à l'utilisateur
	 */
	public Map<String, String> getMessages() {
		return messages;
	}

	/**
	 * @param key
	 *            identifiant du message
	 * @param value
	 *            contenu du message
	 */
	public void addMessage(String key, String value) {
		this.messages.put(key, value);
	}

	// -------
	// --- Helpers Traitements AJAX
	// -------

	public void handleAJAXCall(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

	}
}
