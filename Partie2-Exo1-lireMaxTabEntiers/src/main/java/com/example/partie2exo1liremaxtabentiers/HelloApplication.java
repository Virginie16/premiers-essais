package com.example.partie2exo1liremaxtabentiers;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {

    /**
     * Saisie des paramètres du tableau : taille, min, max, affichage du tableau généré aléatoirement, affichage du max trouvé dans ce tableau
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
      int taille = saisirEntier("Veuillez saisir la taille du tableau", "Taille");
      int min = saisirEntier("Veuillez saisir le nombre minimum", "min");
      int max = saisirEntier("Veuillez saisir le nombre maximum", "max");

      int [] TabEntiers = randomTab(taille,min,max);

      // Afficher les nombres du tableau
      StringBuilder nombres = new StringBuilder();
        for (int i = 0; i < taille; i++) {
            nombres.append(TabEntiers[i]).append(" | ");
        }
      afficherBoiteDeDialogue(nombres.toString(), "Tableau");

      // Trouver le maximum dans le tableau
      int max1 = lireMaxTabEntiers(TabEntiers);
      afficherBoiteDeDialogue("L'entier maximum dans le tableau est " + max1, "Le Max");
    }

    /**
     * Rempli aléatoirement un tableau d'entiers
     * @param size
     * @param minInclu
     * @param maxExclu
     * @return
     */
    public static int []randomTab(int size, int minInclu, int maxExclu){
        int[] tab = new int[size];
        for (int i = 0; i< tab.length; i++){
            tab[i]=(int)(Math.random()*(maxExclu+1-minInclu))+minInclu;
        }
        return tab;
    }

    /**
     * Recherche l'entier maximum présent dans un tableau
     * @param tab argument de la fonction lireMaxTabEntiers
     * @return retourne la valeur max trouvée
     */
    public static int lireMaxTabEntiers(int[] tab){
        int maxValue = tab[0];
        for (int j=0; j<tab.length;j++) {
            if(tab[j]>maxValue)
                maxValue = tab[j];
        }
    return maxValue;

    }

    /**
     * permet d'afficher une fenêtre de saisie d'un entier
     * @param message indique à quoi correspond l'entier saisi
     * @param titre titre de la fenêtre
     * @return retourne la fonction saisirEntier
     */
    public static final int saisirEntier(String message, String titre) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titre);
        dialog.setContentText(message);
        dialog.setHeaderText(null);

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            try {
                return Integer.parseInt(result.get());

            } catch (NumberFormatException e) {
                // Afficher un message d'erreur si la saisie n'est pas un entier
                Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez entrer un nombre entier valide.", ButtonType.OK);
                alert.setTitle("Erreur de saisie");
                alert.showAndWait();
                return saisirEntier(message, titre); // Répéter la saisie
            }

        }

        return 0; // retourner 0 si l'utilisateur annule la saisie

    }

    /**
     * Permet d'afficher une fenêtre avec des informations
     * @param message concerne le message affiché dans la fenêtre
     * @param titre concerne le titre de la fenêtre
     */
    public static void afficherBoiteDeDialogue(String message, String titre) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}