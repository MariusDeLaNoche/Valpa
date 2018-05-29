package com.valparaiso.beans;

public class ForfaitBean {
	private String idForfait;
	private String libelleForfait;
	
	public ForfaitBean(String idForfait, String libelleForfait) {
		this.idForfait = idForfait;
		this.libelleForfait = libelleForfait;
	}

	/**
	 * @return the idForfait
	 */
	public String getIdForfait() {
		return idForfait;
	}

	/**
	 * @param idForfait the idForfait to set
	 */
	public void setIdForfait(String idForfait) {
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
