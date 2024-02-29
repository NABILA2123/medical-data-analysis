package com.example.hospitalmanagement;

public class Medecin {
    private String nom;
    private String prenom;
    private String specialite;
    private int codeMedecin;

    public Medecin(String nom, String specialite, String prenom, int codeMedecin) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.codeMedecin = codeMedecin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getCodeMedcin(){
        return codeMedecin;
    }

    public void setCodeMedecin(int codeMedecin){
        this.codeMedecin = codeMedecin;
    }
}
