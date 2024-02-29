package com.example.hospitalmanagement;

import java.util.Date;
import java.text.SimpleDateFormat;


public class RendezVous {
    private Date date;
    private Patient patient;
    private Medecin medecin;
    private boolean confirme;

    public RendezVous(Date date, Patient patient, Medecin medecin) {
        this.date = date;
        this.patient = patient;
        this.medecin = medecin;
        this.confirme = false; // Par défaut, le rendez-vous n'est pas confirmé
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public boolean isConfirme() {
        return confirme;
    }

    public void setConfirme(boolean confirme) {
        this.confirme = confirme;
    }

    public static String toStringRendezVous(Date rendezVous) {
        if (rendezVous == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateString = sdf.format(rendezVous);
        return dateString;
    }

}
