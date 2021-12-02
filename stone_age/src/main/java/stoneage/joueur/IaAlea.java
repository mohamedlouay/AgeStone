package stoneage.joueur;

import org.jetbrains.annotations.NotNull;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Ressource;
import stoneage.plateaudejeu.cartes.Cartebatiment;
import stoneage.plateaudejeu.zones.Zone;
import stoneage.plateaudejeu.zones.ZoneVillage;

import javax.naming.spi.ObjectFactoryBuilder;
import java.util.*;

public class IaAlea {


    Random rand = new Random();


    /**
     * Choisit le nombre d'ouvrier à placer
     * @param inventaire L'inventaire du joueur
     * @param choixZone La zone choisit
     * @return Un nombre d'ouvriers
     */
    public int choixNbOuvrier(Inventaire inventaire, Zone choixZone) {
        int alea = 0;
        if ((choixZone instanceof ZoneVillage )) {
            if ( ((ZoneVillage) choixZone).getType_zone()==2){
            alea = 2;}
            else alea=1;
        }
        else {
            alea = rand.nextInt(inventaire.getNbOuvrier()) + 1; //le +1 a l'exterieur de rand sinon ca peut retourner 0.

        }
        return alea;
    }



    public int choixCarteOuZone() {
        return rand.nextInt(2)+1;
    }

    public Cartebatiment choixCartePlacement(ArrayList<ArrayList<Cartebatiment>> listeCarteTotale) {
        int alea = rand.nextInt(listeCarteTotale.size()); // Sans +1 a l'interieur de rand sinon ca peut retourner alea=8 alors qu'on a index max = 7.
        return listeCarteTotale.get(alea).get(0);
    }

    public Cartebatiment choixCarteRecuperation(ArrayList<Cartebatiment> CarteVisitees) {
        int alea = rand.nextInt(CarteVisitees.size());
        return CarteVisitees.get(alea);
    }

    /**
     * Choisit la zone de placement
     * @param zonesDispo Les zones disponibles au placement
     * @return Une zone
     */
    public Zone choixZone(ArrayList<Zone> zonesDispo) {
        int alea = rand.nextInt(zonesDispo.size()); // Sans +1 a l'interieur de rand sinon ca peut retourner alea=8 alors qu'on a index max = 7.
        return zonesDispo.get(alea);
    }




    /**
     * Choisit s'il utiliser ses outils
     * @param inventaire Inventaire du joueur
     * @return Un boolean
     */
    public boolean choixOutils(Inventaire inventaire) {
        if (inventaire.getOutilsDispo().size()>0) {
            return rand.nextBoolean();
        }
        else {
            return false;
        }
    }

    public int choixNbRessource(){
        return rand.nextInt(7)+1;
    }

    /**
     * Récupère la somme des outils utilisés
     * @param inventaire L'inventaire du joueur
     * @return La somme des outils
     */
    public int choixNbOutils(Inventaire inventaire) {
        int sommeOutils =0;
        int nbOutilsUtilise = rand.nextInt(inventaire.getOutilsDispo().size())+1;

        for (int i = 0; i < nbOutilsUtilise ; i++) {
            int indice = rand.nextInt(inventaire.getOutilsDispo().size());
            sommeOutils += inventaire.getOutilsDispo().get(indice);
            inventaire.getOutilsNonDispo().add(inventaire.getOutilsDispo().get(indice));
            inventaire.getOutilsDispo().remove(indice);
        }

        return sommeOutils;
    }


    /**
     * Représente le choix d'une ressource pour nourrir les ouvriers, le choix est aléatoire parmi les ressources disponibles pour nourrir les ouvriers?
     * @param inventaire l'inventaire d'un joueur
     * @return Retourne une ressource aleatoire avec laquelle les ouvriers seront nourris.
     */
    public Ressource choixNourrir(Inventaire inventaire){
        HashMap<Ressource, Integer> dicoRessources;
        dicoRessources = dicoDesRessourcesNourrissable(inventaire.getDicoDesRessources(), inventaire.getNbOuvrierTotal());
        Object[] listKeys = dicoRessources.keySet().toArray();
        Object keyAlea = listKeys[new Random().nextInt(listKeys.length)];
        return (Ressource) keyAlea;
    }


    /**
     * Représente les ressources, avec leur nombre, par lesquelles le joueur peut nourrir ses ouvriers
     * @param dictionaryOfRessources Représentes toutes les ressources(clé) du joueurs et leur quantité(valeur).
     * @param nbOuvrier Représente le nombre d'ouvrier que le joueur doit nourrir.
     * @return Retourne un dictionnaire dont les valeurs pour chaque clé de dictionaryOfRessources sont supérieur au paramètre nbOuvrier
     */
    public HashMap<Ressource, Integer> dicoDesRessourcesNourrissable(HashMap<Ressource, Integer> dictionaryOfRessources, int nbOuvrier){
        HashMap<Ressource, Integer> dico = new HashMap<>();
        for (Ressource ressource : dictionaryOfRessources.keySet()) {
            if (dictionaryOfRessources.get(ressource) >= nbOuvrier){
                dico.put(ressource, dictionaryOfRessources.get(ressource));
            }
        }
        return dico;
    }

    /**
     * Choisit s'il utilise ses ouvriers
     * @return Un boolean
     */
    public boolean choixUtiliser() {
        return true;
    }



}
