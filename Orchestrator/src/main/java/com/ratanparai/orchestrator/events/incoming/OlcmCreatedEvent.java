package com.ratanparai.orchestrator.events.incoming;

public class OlcmCreatedEvent {

    private Olcm olcm;

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