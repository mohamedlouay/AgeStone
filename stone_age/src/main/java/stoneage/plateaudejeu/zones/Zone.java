package stoneage.plateaudejeu.zones;

import stoneage.joueur.IaAlea;
import stoneage.joueur.Joueur;
import stoneage.partie.Affichage;
import stoneage.partie.Partie;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Ressource;

import java.util.ArrayList;
import java.util.Random;


/**
 * La classe enum qui gère les differentes zones du jeu
 */
public class Zone {


    /**
     * Un objet de Random
     */
    Random rand = new Random();

    /**
     * La Ressource ressource
     */
    private Ressource ressource;

    /**
     * La valeur du diviseur pour le calcul du gain
     */
    private int diviseur;

    /**
     * Le nombre maximum d'ouvriers sur la zone
     */
    private int nbOuvrierMaxSurZone;

    /**
     * Le nombre d'ouvriers sur la zone
     */
    private int nbOuvrierSurZone;

    /**
     * Le nombre de ressources de la zone
     */
    private int nbRessourcesZone;

    /**
     * La liste du nombre d'ouvriers placés sur la zone par les joueurs
     * Pour savoir combien d'ouvriers chaque joueur a placé sur la zone z.
     * Initialisation de la liste nbOuvrierDuJoueur par des valeurs 0 dans le constructeur.
     */
    private ArrayList<Integer> nbOuvirerDuJoueur = new ArrayList<Integer>();

    //CONSTRUCTEUR

    /**
     * Constructeur de la classe
     * @param ressource Le nom de la ressource
     * @param nbRessourcesZone Le nombre de ressources de la zone
     * @param diviseur Le diviseur de gain de la zone
     * @param nbOuvrierSurZone Le nombre d'ouvriers sur la zone
     * @param nbOuvrierMaxSurZone Le nombre d'ouviers maximum sur la zone
     */
    public Zone(Ressource ressource, int nbRessourcesZone, int diviseur, int nbOuvrierSurZone, int nbOuvrierMaxSurZone) {
        this.ressource = ressource;
        this.nbRessourcesZone = nbRessourcesZone;
        this.diviseur = diviseur;
        this.nbOuvrierSurZone = nbOuvrierSurZone;
        this.nbOuvrierMaxSurZone = nbOuvrierMaxSurZone;
        for (int i = 0; i < Partie.getNbJoueur(); i++) {
            this.nbOuvirerDuJoueur.add(0);
        }
    }


    /**
     * 2eme Constructeur pour les zones Villages
     * @param nbOuvrierSurZone
     * @param nbOuvrierMaxSurZone
     */

    public Zone(int nbOuvrierSurZone, int nbOuvrierMaxSurZone) {
        this.nbOuvrierSurZone = nbOuvrierSurZone;
        this.nbOuvrierMaxSurZone = nbOuvrierMaxSurZone;
        for (int i = 0; i < Partie.getNbJoueur(); i++) { //Initialisation de la liste nbOuvrierDuJoueur par des valeurs 0.
            this.nbOuvirerDuJoueur.add(0);
        }
    }



    //METHODES

    /**
     * Redéfinition de la methode toString pour les zones
     * @return Le nom de la zone
     */
    @Override
    public String toString() {
        switch (this.getRessource()) {
            case OR:
                return "RIVIERE";
            case BOIS:
                return "FORET";
            case NOURRITURE:
                return "CHASSE";
            case PIERRE:
                return "CARRIERE";
            case ARGILE:
                return "GLAISIERE";
            default:
                return "K-OU";
        }
    }

    /**
     * Récupère le nombre d'ouvriers du joueur placés sur la zone
     * @param i Le numéro du joueur
     * @return Le nombre d'ouvriers
     */
    public int getNbOuvirerDuJoueur(int i) {
        return  nbOuvirerDuJoueur.get(i);
    }

    /**
     * Récupère le nombre d'ouvriers maximum sur la zone
     * @return Le nombre d'ouvriers maximum
     */
    public int getNbOuvrierMaxSurZone() {
        return nbOuvrierMaxSurZone;
    }

    /**
     * Récupère le nombre de ressources sur la zone
     * @return Le nombre de ressources
     */
    public int getNbRessourcesZone() {
        return nbRessourcesZone;
    }

    /**
     * Récupère le nombre d'ouvriers sur la zone
     * @return Le nombre d'ouvriers sur la zone
     */
    public int getNbOuvrierSurZone() {
        return this.nbOuvrierSurZone;
    }

    /**
     * Récupère le nom de la ressources de la zone
     * @return le nom de la ressource
     */
    public Ressource getRessource() {
        return ressource;
    }

    /**
     * Récupère le diviseur de la zone
     * @return Le diviseur
     */
    public int getDiviseur() {
        return diviseur;
    }

    /**
     * Affecte un nombre d'ouvriers sur la zone
     * @param nbOuvrierSurZone Un nombre d'ouvriers
     */
    public void setNbOuvrierSurZone(int nbOuvrierSurZone) {
        this.nbOuvrierSurZone = nbOuvrierSurZone;
    }

    /**
     * Affecte un nombre de ressources sur la zone
     * @param nbRessourcesZone Un nombre de ressources
     */
    public void setNbRessourcesZone(int nbRessourcesZone) {
        this.nbRessourcesZone = nbRessourcesZone;
    }

    /**
     * Place un nombre d'ouvriers sur la zone
     * @param nbOuvrierAplacer Le nombre d'ouvriers que le joueur place
     * @param nJoueur Le numéro du joueur
     */
    public void placeOuvrierSurZone(int nbOuvrierAplacer, int nJoueur) {
        if (nbOuvrierAplacer>0){
        this.nbOuvrierSurZone += nbOuvrierAplacer;
        this.nbOuvirerDuJoueur.set(nJoueur, getNbOuvirerDuJoueur(nJoueur) + nbOuvrierAplacer); //set permet de remplacer un element à un index donné contrairement a add.
        }
    }

    /**
     * Retire un nombre d'ouvriers de la zone
     * @param inventaireJoueur L'inventaire du joueur qui retire
     * @param nbOuvrierAretirer Le nombre d'ouvriers que le joueur retire
     * @param nJoueur Le numéro du joueur
     */
    public void retirerOuvrierSurZone(Inventaire inventaireJoueur, int nbOuvrierAretirer, int nJoueur) {
        //inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + nbOuvrierAretirer);
        this.nbOuvrierSurZone -= nbOuvrierAretirer;
        this.nbOuvirerDuJoueur.set(nJoueur, 0); // On réinitialise a 0 une fois les ouvriers récuperés.
    }

    /**
     * Lance un dé
     * @return Un chiffre entre 1 et 6
     */
    public int de(){
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }

    /**
     * Procédure de gain des zones
     * On le lance le de autant de fois que le nombre d'ouvriers du joueur sur la Zone
     * C'est dans Tour qu'on gere l'attribution des gains
     * @param inventaire L'inventaire du joueur
     * @param nJoueur Le numéro du joueur
     * @param IA Le bot effectuant les choix
     * @param affichage Un affichage pour afficher les résultats des dés et les gains.
     * @return Renvoie le nombre de ressources gagnées
     */
    public int gainZone(Inventaire inventaire, int nJoueur, IaAlea IA, Affichage affichage) {
        ArrayList<Integer> listDés = new ArrayList<Integer>();
        int somme = 0;
        int gain = 0;
        int D = 0;
        for (int i = 0; i < this.getNbOuvirerDuJoueur(nJoueur); i++) {
            D = de();
            listDés.add(D);
            somme += D;
        }
        affichage.AfficheLanceDe(nJoueur+1,listDés,this.getNbOuvirerDuJoueur(nJoueur));
        if (IA.choixOutils(inventaire)){
            somme += IA.choixNbOutils(inventaire);
        }
        gain = somme/this.getDiviseur();
        affichage.AfficheGain(somme,this.getDiviseur(), gain);
        return gain;
    }
}
