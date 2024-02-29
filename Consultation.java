package com.example.hospitalmanagement;

import java.util.Date;

public class Consultation extends RendezVous{
    private String resultat;

    public Consultation(Date date, Patient patient, Medecin medecin) {
        super(date, patient, medecin);
        this.setConfirme(true);
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

}
