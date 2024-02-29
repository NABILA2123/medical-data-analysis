package com.example.hospitalmanagement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class hospitalManagementApp extends Application {

    private List<RendezVous> rendezVousList = new ArrayList<>();
    private List<Medecin> medecinList = new ArrayList<>();
    private List<Patient> patientList = new ArrayList<>();

    private TextField cinTextField;
    private TextArea resultTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initializeData();
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        HBox searchBox = createSearchBox();
        borderPane.setTop(searchBox);
        resultTextArea = new TextArea();
        resultTextArea.setEditable(false);
        borderPane.setCenter(resultTextArea);
        HBox buttonBox = createButtonBox();
        borderPane.setBottom(buttonBox);
        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setTitle("RendezVous App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createSearchBox() {
        Label searchLabel = new Label("CIN du patient:");
        cinTextField = new TextField();
        Button searchButton = new Button("Rechercher");
        searchButton.setOnAction(event -> searchRendezVous());

        HBox searchBox = new HBox(10);
        searchBox.getChildren().addAll(searchLabel, cinTextField, searchButton);
        return searchBox;
    }

    private HBox createButtonBox() {
        Button medecinButton = new Button("Afficher les médecins");
        medecinButton.setOnAction(event -> showMedecins());

        Button patientButton = new Button("Afficher les patients");
        patientButton.setOnAction(event -> showPatients());

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(medecinButton, patientButton);
        return buttonBox;
    }

    private void searchRendezVous() {
        String cin = cinTextField.getText();
        boolean found = false;
        StringBuilder resultText = new StringBuilder();

        for (RendezVous rendezVous : rendezVousList) {
            if (rendezVous.getPatient().getCin().equals(cin)) {
                found = true;
                resultText.append("Date du rendez-vous: ")
                        .append(toStringRendezVous(rendezVous.getDate()))
                        .append("\nNom du médecin: ")
                        .append(rendezVous.getMedecin().getNom())
                        .append(" ")
                        .append(rendezVous.getMedecin().getPrenom())
                        .append("\n");
            }
        }

        if (!found) {
            resultText.append("Aucun rendez-vous correspondant à ce CIN.");
        }

        resultTextArea.setText(resultText.toString());
    }

    private void showMedecins() {
        StringBuilder resultText = new StringBuilder("Liste des médecins:\n");

        for (Medecin medecin : medecinList) {
            resultText.append("Nom: ")
                    .append(medecin.getNom())
                    .append(" ")
                    .append(medecin.getPrenom())
                    .append(", Spécialité: ")
                    .append(medecin.getSpecialite())
                    .append(", Code Médecin: ")
                    .append(medecin.getCodeMedcin())
                    .append("\n");
        }

        resultTextArea.setText(resultText.toString());
    }

    private void showPatients() {
        StringBuilder resultText = new StringBuilder("Liste des patients:\n");

        for (Patient patient : patientList) {
            resultText.append("Nom: ")
                    .append(patient.getNom())
                    .append(" ")
                    .append(patient.getPrenom())
                    .append(", Age: ")
                    .append(patient.getAge())
                    .append(", Groupe Sanguin: ")
                    .append(patient.getGroupeSanguin())
                    .append(", Poids: ")
                    .append(patient.getPoids())
                    .append(", Sexe: ")
                    .append(patient.getGender())
                    .append(", CIN: ")
                    .append(patient.getCin())
                    .append(", Assurance: ")
                    .append(patient.getAssurance())
                    .append("\n");
        }

        resultTextArea.setText(resultText.toString());
    }

    private void initializeData() {
        Medecin medecin1 = new Medecin("nomMedecin1", "Specialité1", "prenomMedecin1", 1);
        Medecin medecin2 = new Medecin("nomMedecin2", "Specialité2", "prenomMedecin2", 2);
        Medecin medecin3 = new Medecin("nomMedecin3", "Specialité3", "prenomMedecin3", 3);
        Medecin medecin4 = new Medecin("nomMedecin4", "Specialité4", "prenomMedecin4", 4);

        Patient patient1 = new Patient("nomPatient1", "prenomPatient1", 11, "sexePatient1", "1111", 11.1, "groupeSanguinPatient1", "AAA Assurance");
        Patient patient2 = new Patient("nomPatient2", "prenomPatient2", 22, "sexePatient2", "2222", 22.2, "groupeSanguinPatient2", "BBB Assurance");
        Patient patient3 = new Patient("nomPatient3", "prenomPatient3", 33, "sexePatient3", "3333", 33.3, "groupeSanguinPatient3", "CCC Assurance");
        Patient patient4 = new Patient("nomPatient4", "prenomPatient4", 44, "sexePatient4", "4444", 44.4, "groupeSanguinPatient4", "DDD Assurance");
        Patient patient5 = new Patient("nomPatient5", "prenomPatient5", 55, "sexePatient5", "5555", 55.5, "groupeSanguinPatient5", "EEE Assurance");
        Patient patient6 = new Patient("nomPatient6", "prenomPatient6", 66, "sexePatient6", "6666", 66.6, "groupeSanguinPatient6", "FFF Assurance");
        Patient patient7 = new Patient("nomPatient7", "prenomPatient7", 77, "sexePatient7", "7777", 77.7, "groupeSanguinPatient7", "GGG Assurance");
        Patient patient8 = new Patient("nomPatient8", "prenomPatient8", 88, "sexePatient8", "8888", 88.8, "groupeSanguinPatient8", "HHH Assurance");
        Patient patient9 = new Patient("nomPatient9", "prenomPatient9", 99, "sexePatient9", "9999", 99.9, "groupeSanguinPatient9", "III Assurance");
        Patient patient10 = new Patient("nomPatient10", "prenomPiatent10", 10, "sexePatient10", "1010", 20.1, "groupeSanguinPatient10", "XYZ Assurance");

        Date currentDate = new Date();
        RendezVous rendezVous1 = new RendezVous(currentDate, patient1, medecin1);
        RendezVous rendezVous2 = new RendezVous(currentDate, patient2, medecin2);
        RendezVous rendezVous3 = new RendezVous(currentDate, patient4, medecin3);

        rendezVousList.add(rendezVous1);
        rendezVousList.add(rendezVous2);
        rendezVousList.add(rendezVous3);

        medecinList.add(medecin1);
        medecinList.add(medecin2);
        medecinList.add(medecin3);
        medecinList.add(medecin4);


        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);
        patientList.add(patient4);
        patientList.add(patient5);
        patientList.add(patient6);
        patientList.add(patient7);
        patientList.add(patient8);
        patientList.add(patient9);
        patientList.add(patient10);
    }
    private String toStringRendezVous(Date rendezVous) {
        if (rendezVous == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(rendezVous);
    }
}


