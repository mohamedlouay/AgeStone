
package stoneage.joueur;

import stoneage.plateaudejeu.Ressource;
import stoneage.plateaudejeu.Inventaire;

import java.util.* ;


/**
 * La classe qui représente les informations et actions du joueur
 */
public class Joueur {


    //CHAMPS

    /**
     * Le numero du joueur
     */
    private int num = 0;

    /**
     * Le nombre de joueur de type Joueur
     */
    private static int nbJoueur;

    /**
     * Objet de type Random
     */
    Random rand = new Random();


    //CONSTRUCTEUR

    /**
     * Constructeur du Joueur.
     */
    public Joueur(){
        nbJoueur ++;
        num = nbJoueur;
    }


    //METHODES

    /**
     *
     * @return le numéro du Joueur.
     */
    public int getNum(){
        return num;
    }


    /**
     *
     * @param inventaire : L'inventaire du Joueur.
     * @param nbOuvrierAPlacerSurLaZone : Le nombre d'ouvriers que le joueur veut placer sur une Zone.
     */
    public void placementOuvrierSurZone(Inventaire inventaire, int nbOuvrierAPlacerSurLaZone){
        inventaire.setNbOuvrier(inventaire.getNbOuvrier() - nbOuvrierAPlacerSurLaZone);
    }

    /**
     *
     * @param inventaire : l'inventaire du Joueur.
     * @param nbOuvrierPlaceSurCetteZone : Le nombre d'ouvriers sur cette Zone déjà placer par le joueur précédemment.
     */
    public void retraitOuvrierSurZone(Inventaire inventaire, int nbOuvrierPlaceSurCetteZone){
        inventaire.setNbOuvrier(inventaire.getNbOuvrier() + nbOuvrierPlaceSurCetteZone);
    }


    /**
     *
     * @param inventaire : l'inventaire du Joueur.
     * @param ressource : Une ressource du joueur .
     */
    public void nourrir(Inventaire inventaire, Ressource ressource) {
        for (Ressource r: inventaire.getListeRessources()) {
            if (r.equals(ressource) && r.equals(Ressource.OR)){
                inventaire.setNbOr(inventaire.getNbOr() - inventaire.getNbOuvrierTotal());
            }
            else if (r.equals(ressource) && r.equals(Ressource.ARGILE)){
                inventaire.setNbArgile(inventaire.getNbArgile() - inventaire.getNbOuvrierTotal());
            }
            else if (r.equals(ressource) && r.equals(Ressource.NOURRITURE)){
                inventaire.setNbNourriture(inventaire.getNbNourriture() - inventaire.getNbOuvrierTotal());
            }
            else if (r.equals(ressource) && r.equals(Ressource.BOIS)){
                inventaire.setNbBois(inventaire.getNbBois() - inventaire.getNbOuvrierTotal());
            }
            else if (r.equals(ressource) && r.equals(Ressource.PIERRE)){
                inventaire.setNbPierre(inventaire.getNbPierre() - inventaire.getNbOuvrierTotal());
            }
            else {

            }

        }
//        for (int j = 0; j < i.getNbOuvrier(); j++) {
//            if (i.getNbNourriture()==0) { //Si le joueur doit nourrir encore des ouvriers mais n'a plus de nourriture
//                boolean choixChange = rand.nextBoolean(); // Aleatoirement il choisit ou non d'echanger des ressources pour nourrir ses ouvriers
//                if (choixChange && i.getNbRessourceTotal()>0) { //Si il choisit d'echanger et qu'il a de quoi echanger
//                    for (int k = 0; k < i.getNbOuvrier()-j ; k++) { // On boucle sur le nombre d'ouvriers pas nourrir
//                        if (i.getNbBois()>0) { //On commencer par changer avec la ressource la moins prestigieuse
//                            i.setNbBois(i.getNbBois()-1);
//                            continue;
//                        }
//                        else if (i.getNbArgile()>0) {
//                            i.setNbArgile(i.getNbArgile()-1);
//                            continue;
//                        }
//                        else if (i.getNbPierre()>0) {
//                            i.setNbPierre(i.getNbPierre()-1);
//                            continue;
//                        }
//                        else if (i.getNbOr()>0) {
//                            i.setNbOr(i.getNbOr()-1);
//                            continue;
//                        }
//                    }
//                }
//                else { // S'il choisit de pas changer
//                    i.setNbPointTotal(i.getNbPointTotal()-10);
//                    break;
//                }
//            }
//            if(i.getNbNourriture()>0)
//                i.setNbNourriture(i.getNbNourriture()-1);
//
//        }
    }

    /**
     *
     * @return la valeur du dé.
     */
    public int de(){
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }

}

