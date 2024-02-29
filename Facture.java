package com.example.hospitalmanagement;

import java.util.Date;

public class Facture {
    private int numeroFacture;
    private Date dateFacturation;
    private Consultation consultation;
    private double montant;
    private boolean payee;
    private String assurance;

    public Facture(int numeroFacture, Date dateFacturation, Consultation consultation, double montant, String assurance) {
        this.numeroFacture = numeroFacture;
        this.dateFacturation = dateFacturation;
        this.consultation = consultation;
        this.montant = montant;
        this.payee = false; // Par défaut, la facture n'est pas payée
        this.assurance = assurance;
    }

    public int getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(int numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Date getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean isPayee() {
        return payee;
    }

    public void setPayee(boolean payee) {
        this.payee = payee;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }
}
