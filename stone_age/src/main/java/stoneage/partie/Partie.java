
package stoneage.partie;

import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Plateau;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * La classe qui gère le déroulement du jeu
 */
public class Partie {

    //CHAMPS

    /**
     * Le nombre de joueur
     */
    private static  int nbJoueur ;

    /**
     * Objet qui represente le plateau de jeu
     */
    private final Plateau plateau;
    /**
     * Liste des scores des joueurs
     */
    private int[] score;

    /**
     * Active l'affichage des actions en details (Desactiver par défaut)
     */
    private Affichage affichage;

    /**
     * Instance de Tour
     * Le déroulement d'un tour
     */
    private Tour unTour;


    //========================= CONSTRUCTEUR =====================================//

    /**
     * Constructeur de la classe
     * @param nbJoueur Le nombre de joueurs
     */
    public Partie(int nbJoueur, boolean affichage){
        this.nbJoueur = nbJoueur;
        plateau = new Plateau(nbJoueur);
        score = new int[nbJoueur];
        this.affichage = new Affichage(affichage);
        this.unTour = new Tour(plateau, this.affichage);
    }


    //METHODES

    /**
     * Récupère le nombre de joueurs
     * @return Le nombre de joueurs
     */
    public static int getNbJoueur() {
        return nbJoueur;
    }

    /**
     * Recupère la liste des scores
     * @return la liste des scores
     */
    public int[] getScore() {
        return score;
    }

    /**
     * Lance la boucle du jeu
     */
    public void jouer() {
        int tour = 1;
        System.out.println("Nb de joueur : " + nbJoueur);

        while(plateau.verifierNbCarteBatiment()) {
            /* On affiche le message des infos du tour (nbr de tours, 1er joueur)*/
            affichage.AfficheInfoTour(tour, plateau.getTableauFirstPlayer().get(0));

            /* On execute la phase de placement*/
            unTour.placementPhase();

            /* On affiche le message de la phase recup*/
            affichage.AfficheRecup();

            /* On execute la phase de Recup*/
            unTour.recuperationPhase();

            /* On affiche le message de la phase nourrir*/
            affichage.AffichePhaseNourrir();

            /* On execute la phase nourrir*/
            unTour.phaseNourrir();

            /* On met à jour les dictionnaires (Ressources : nbRessources) des inventaires*/
            plateau.updateDico();

            swap(plateau.getTableauFirstPlayer());
            unTour.resetOuvrierDispoDesInventaires();
            tour++;
        }
        affichage.AfficheMessageFin();
        resultat(plateau.getListeInventaire());
        int indexDuPremier = this.indexGagnant(score);
        int equal = egalite(score, indexDuPremier);
        if (equal != 0){
            departage(score, equal, indexDuPremier);
        }
        affichage.AfficheGagnant(indexDuPremier, plateau.getListeInventaire().get(indexDuPremier));
    }


    /**
     * Departage les joueurs à égalité: l'index du joueur gagnant est changé (ou pas) en fonction
     * de la valeur renvoyée par pointDeDepartage() de son inventaire (l'inventaire du même index).
     * @param score tableau des scores
     * @param equal
     * @param indexDuPremier
     */
    private void departage(int[] score, int equal, int indexDuPremier) {
        for (int i = 0; i < score.length; i++) {
            if ( (i != indexDuPremier) && (score[i] == score[indexDuPremier]) ){
                if( plateau.getListeInventaire().get(i).pointDeDepartage() > plateau.getListeInventaire().get(indexDuPremier).pointDeDepartage()){
                    indexDuPremier = i;
                }
                equal--;
            }
            if(equal <= 0){
                break;
            }
        }
    }


    /**
     * Stocke les scores des joueurs dans la liste score
     * @param listInventaire La liste des inventaires
     */
    public void resultat(ArrayList<Inventaire> listInventaire){
        for (int i = 0; i < listInventaire.size(); i++) {
            this.score[i] = listInventaire.get(i).calculPoint();
        }
    }

    /**
     * Calcule s'il y a des joueurs à égalité à la fin d'une partie
     * @param points
     * @param indexDuPremier
     * @return Le nombre de joueurs à égalité.
     */
    public int egalite(int[] points, int indexDuPremier){
        int equal = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i] == points[indexDuPremier]&& i!=indexDuPremier) {
                equal++;
            }
        }
        return equal;
    }


    /**
     * Récupère le numero du joueur gagnant
     * @param points La liste des scores
     * @return Le numéro du joueur gagnant
     */
    public int indexGagnant(int[] points){
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            if (max < points[i]){
                max = points[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Permutation de l'ordre du premier joueur à jouer
     * @param tableauFirstPlayer Le tableau des numéros des joueurs
     */
    public void swap (ArrayList<Integer> tableauFirstPlayer) {
        for (int i =0;i < tableauFirstPlayer.size()-1; i++) {
            Collections.swap(tableauFirstPlayer, i, i+1);
        }
    }

}

