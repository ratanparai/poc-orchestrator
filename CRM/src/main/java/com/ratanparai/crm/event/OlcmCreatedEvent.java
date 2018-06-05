package com.ratanparai.crm.event;

import java.io.Serializable;

import com.ratanparai.crm.models.Olcm;

public class OlcmCreatedEvent implements Serializable {

    private Olcm olcm;

    public OlcmCreatedEvent(Olcm olcm){
        this.olcm = olcm;
    }

	/**
	 * @return the olcm
	 */
	public Olcm getOlcm() {
		return olcm;
	}

	/**
	 * @param olcm the olcm to set
	 */
	public void setOlcm(Olcm olcm) {
		this.olcm = olcm;
	}
}