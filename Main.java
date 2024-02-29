package com.example.hospitalmanagement;
import java.util.Date;

public class main{


    public static void main(String[] args) {

        Patient patient2 = new Patient("nomPatient2", "prenomPatient2", 22, "sexePatient2", "2222", 22.2, "groupeSanguinPatient2", "BBB Assurance");
        Patient patient4 = new Patient("nomPatient4", "prenomPatient4", 44, "sexePatient4", "4444", 44.4, "groupeSanguinPatient4", "DDD Assurance");

        Medecin medecin1 = new Medecin("nomMedecin1", "Specialité1", "prenomMedecin1", 1);
        Medecin medecin3 = new Medecin("nomMedecin3", "Specialité3", "prenomMedecin3", 3);

        Date currentDate = new Date();
        RendezVous rendezVous1 = new RendezVous(currentDate, patient2, medecin1);
        RendezVous rendezVous2 = new RendezVous(currentDate, patient2, medecin3);

        Consultation consultation1 = new Consultation(currentDate, patient2, medecin1);
        consultation1.setResultat("Examen cardiaque normal");

        Facture facture1 = new Facture(1, currentDate, consultation1, 150.0, "XYZ Assurance");

        System.out.println("Informations du patient 2:");
        displayPatientInfo(patient2);

        System.out.println("\nInformations du médecin 1:");
        displayMedecinInfo(medecin1);

        System.out.println("\nInformations du rendez-vous 1:");
        displayRendezVousInfo(rendezVous1);

        System.out.println("\nInformations du rendez-vous 2:");
        displayRendezVousInfo(rendezVous2);

        System.out.println("\nInformations de la consultation 1:");
        displayConsultationInfo(consultation1);

        System.out.println("\nInformations de la facture 1:");
        displayFactureInfo(facture1);
    }

    private static void displayPatientInfo(Patient patient) {
        System.out.println("Nom: " + patient.getNom());
        System.out.println("Prenom: " + patient.getPrenom());
        System.out.println("Age: " + patient.getAge());
        System.out.println("Sexe: " + patient.getGender());
        System.out.println("CIN: " + patient.getCin());
        System.out.println("Poids: " + patient.getPoids());
        System.out.println("Groupe Sanguin: " + patient.getGroupeSanguin());
        System.out.println("Assurance: " + patient.getAssurance());
    }

    private static void displayMedecinInfo(Medecin medecin) {
        System.out.println("Nom: " + medecin.getNom());
        System.out.println("Prenom: " + medecin.getPrenom());
        System.out.println("Spécialité: " + medecin.getSpecialite());
        System.out.println("Code Médecin: " + medecin.getCodeMedcin());
    }

    private static void displayRendezVousInfo(RendezVous rendezVous) {
        System.out.println("Date du rendez-vous: " + RendezVous.toStringRendezVous(rendezVous.getDate()));
        System.out.println("Nom du patient: " + rendezVous.getPatient().getNom());
        System.out.println("Nom du médecin: " + rendezVous.getMedecin().getNom());
        System.out.println("Confirmation: " + (rendezVous.isConfirme() ? "Oui" : "Non"));
    }

    private static void displayConsultationInfo(Consultation consultation) {
        displayRendezVousInfo(consultation); // Utilise la méthode existante pour afficher les informations de base

        System.out.println("Résultat de la consultation: " + consultation.getResultat());
    }

    private static void displayFactureInfo(Facture facture) {
        System.out.println("Numéro de facture: " + facture.getNumeroFacture());
        System.out.println("Date de facturation: " + RendezVous.toStringRendezVous(facture.getDateFacturation()));

        // Affiche les informations spécifiques à la consultation (en utilisant displayConsultationInfo)
        displayConsultationInfo(facture.getConsultation());

        System.out.println("Montant: " + facture.getMontant());
        System.out.println("Payée: " + (facture.isPayee() ? "Oui" : "Non"));
        System.out.println("Assurance: " + facture.getAssurance());
    }

}

