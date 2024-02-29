package com.example.hospitalmanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DossierMedical {
    private Patient patient;
    private List<Medecin> medecins;
    private List<RendezVous> rendezVousList;
    private List<Consultation> consultations;
    private Facture facture;

    public DossierMedical(Patient patient, List<Medecin> medecins, List<RendezVous> rendezVousList,
                          List<Consultation> consultations, Facture facture) {
        this.patient = patient;
        this.medecins = medecins;
        this.rendezVousList = rendezVousList;
        this.consultations = consultations;
        this.facture = facture;
    }

    public void sauvegarderDossierMedical(String cheminFichier) throws DossierMedicalException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(cheminFichier))) {
            objectOutputStream.writeObject(this);
            System.out.println("Dossier médical sauvegardé avec succès dans le fichier: " + cheminFichier);
        } catch (IOException e) {
            throw new DossierMedicalException("Erreur lors de la sauvegarde du dossier médical", e);
        }
    }

    public static DossierMedical chargerDossierMedical(String cheminFichier) throws DossierMedicalException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(cheminFichier))) {
            return (DossierMedical) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new DossierMedicalException("Erreur lors du chargement du dossier médical", e);
        }
    }

    public static void main(String[] args) {
        try {
            Patient patient = new Patient("nompat", "prenompat", 30, "genderpat", "123456789", 70.0, "A+", "XYZ Assurance");
            Medecin medecin1 = new Medecin("nommed", "specialitemed", "prenommed", 9);
            RendezVous rendezVous1 = new RendezVous(new Date(), patient, medecin1);
            Consultation consultation1 = new Consultation(new Date(), patient, medecin1);
            consultation1.setResultat("Examen cardiaque normal");
            Facture facture1 = new Facture(1, new Date(), consultation1, 150.0, "XYZ Assurance");

            List<Medecin> medecins = new ArrayList<>();
            medecins.add(medecin1);

            List<RendezVous> rendezVousList = new ArrayList<>();
            rendezVousList.add(rendezVous1);

            List<Consultation> consultations = new ArrayList<>();
            consultations.add(consultation1);

            DossierMedical dossierMedical = new DossierMedical(patient, medecins, rendezVousList, consultations, facture1);

            dossierMedical.sauvegarderDossierMedical("dossier_medical.ser");

            DossierMedical dossierMedicalCharge = DossierMedical.chargerDossierMedical("dossier_medical.ser");
            System.out.println("Dossier médical chargé avec succès.");
        } catch (DossierMedicalException e) {
            System.err.println("Erreur dans le dossier médical: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class DossierMedicalException extends Exception {
    public DossierMedicalException(String message, Throwable cause) {
        super(message, cause);
    }
}

