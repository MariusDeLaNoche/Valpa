package com.valparaiso.beans;

public class ForfaitBean {
	private int idForfait;
	private String libelleForfait;
	
	public ForfaitBean(int idForfait, String libelleForfait) {
		this.idForfait = idForfait;
		this.libelleForfait = libelleForfait;
	}

	/**
	 * @return the idForfait
	 */
	public int getIdForfait() {
		return idForfait;
	}

	/**
	 * @param idForfait the idForfait to set
	 */
	public void setIdForfait(int idForfait) {
		this.idForfait = idForfait;
	}

	/**
	 * @return the libelleForfait
	 */
	public String getLibelleForfait() {
		return libelleForfait;
	}

	/**
	 * @param libelleForfait the libelleForfait to set
	 */
	public void setLibelleForfait(String libelleForfait) {
		this.libelleForfait = libelleForfait;
	}
	
	
}
