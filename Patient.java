package com.example.hospitalmanagement;

public class Patient {
    private String nom;
    private String prenom;
    private int age;
    private String gender;
    private String cin;
    private double poids;
    private String groupeSanguin;
    private String assurance;


    public Patient(String nom, String prenom, int age, String gender, String cin, double poids, String groupeSanguin, String assurance) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.gender = gender;
        this.cin = cin;
        this.poids = poids;
        this.groupeSanguin = groupeSanguin;
        this.assurance = assurance;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCin(){
        return cin;
    }

    public void setCin(String cin){
        this.cin = cin;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }




}