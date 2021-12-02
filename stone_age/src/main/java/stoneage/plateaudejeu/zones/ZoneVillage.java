package stoneage.plateaudejeu.zones;

import stoneage.joueur.IaAlea;
import stoneage.joueur.Joueur;
import stoneage.plateaudejeu.Inventaire;

import java.util.ArrayList;

public class ZoneVillage extends Zone{

    /**
     * Le nombre maximum d'ouvriers sur la zone
     */
    private int nbOuvrierMaxSurZone;

    /**
     * Le nombre d'ouvriers sur la zone
     */
    private int nbOuvrierSurZone;

    /**
     * La liste du nombre d'ouvriers placés sur la zone par les joueurs
     */
    private ArrayList<Integer> nbOuvirerDuJoueur = new ArrayList<Integer>(); //Pour savoir cb d'ouvriers le joueur i a placé sur la zone z.

    public int getType_zone() {
        return type_zone;
    }

    /**
     * ZoneVillage est 0 si c'est le Champ
     * ZoneVillage est 1 si c'est la Fabrique d'outils
     * ZoneVillage est 2 si c'est la Hutte
     */
    private int type_zone;



    /**
     * Constructeur de la classe
     * @param nbOuvrierSurZone    Le nombre d'ouvriers sur la zone
     * @param nbOuvrierMaxSurZone Le nombre d'ouviers maximum sur la zone
     */
    public ZoneVillage(int nbOuvrierSurZone, int nbOuvrierMaxSurZone, int type_zone) {
        super( nbOuvrierSurZone, nbOuvrierMaxSurZone);
        this.type_zone = type_zone;
    }



    public void gainZone(Inventaire inventaire, int nJoueur, Joueur IA){
        if(this.type_zone==0){
            inventaire.setNiveauAgriculture(inventaire.getNiveauAgriculture()+1);
        }
        else if (this.type_zone==1){
            if (inventaire.getNbOutils()<12){
                inventaire.setNbOutils(inventaire.getNbOutils()+1);
                for (int i = 0; i < 3; i++) {
                    if (inventaire.getNbOutils()<4) {
                        if (inventaire.getOutils().get(i)<1) {
                            inventaire.getOutils().set(i, 1);
                            break;
                        }
                    }
                    if (inventaire.getNbOutils()>=3 && inventaire.getNbOutils()<7) {
                        if (inventaire.getOutils().get(i)<2) {
                            inventaire.getOutils().set(i, 2);
                            break;
                        }
                    }
                    if (inventaire.getNbOutils()>=6 && inventaire.getNbOutils()<10) {
                        if (inventaire.getOutils().get(i)<3) {
                            inventaire.getOutils().set(i, 3);
                            break;
                        }
                    }
                    if (inventaire.getNbOutils()>=9 && inventaire.getNbOutils()<13) {
                        if (inventaire.getOutils().get(i)<4) {
                            inventaire.getOutils().set(i, 4);
                            break;
                        }
                    }

                }
            }
        }
        else {
            if (inventaire.getNbOuvrierTotal()<10){
                inventaire.setNbOuvrier(inventaire.getNbOuvrier()+1);
                inventaire.setNbOuvrierTotal(inventaire.getNbOuvrierTotal()+1);
            }
        }
        retirerOuvrierSurZone(inventaire, getNbOuvirerDuJoueur(nJoueur), nJoueur);

    }

    @Override
    public String toString() {
        switch (this.getType_zone()){
            case 0:
                return "CHAMP";
            case 1:
                return "FABRIQUE";
            case 2:
                return "HUTTE";
            default:
                return "BEUG";
        }
    }
}
