
package stoneage.plateaudejeu;

import stoneage.plateaudejeu.cartes.CarteCivilisation;
import stoneage.plateaudejeu.cartes.Cartebatiment;

import java.util.*;

/**
 * La classe de l'inventaire du joueur
 */
public class Inventaire {

    //CHAMPS

    private int nbOuvrierTotal;

    /**
     * Le nombre d'ouvrier du joueur
     */
    private int nbOuvrier;

    /**
     * La quantitee de nourriture du joueur (debut de jeu = 10 pour tous)
     */
    private int nbNourriture;

    /**
     * La quantitée de la ressource bois du joueur
     */
    private int nbBois;

    /**
     * La quantitée d'Argile du joueur
     */
    private int nbArgile;

    /**
     * La quantitée de pierre du joueur
     */
    private int nbPierre;

    /**
     * La quantitée d'or du joueur
     */
    private int nbOr;

    /**
     * La quantité d'outils du joueur
     */
    private int nbOutils;

    /**
     * La quantité d'outils a usage unique pour les cartes de civilisation  du joueur
     */
    private int OutilUsageUnique=0;


	/**
     *  Le niveau d'agriculture du joueur
     */
    private int niveauAgriculture;

    /**
     * Nombre de points du joueur
     */
    private int nbPointTotal;

    /**
     * tableau qui contient les cartes des civilisations gagnées par le joueur
     * */

    ArrayList<CarteCivilisation> stockCards = new ArrayList<CarteCivilisation>();




    public void addCarteToStockCards(CarteCivilisation carte)
    {
    stockCards.add(carte);
    }


    /**
     * tableau qui contient les cartes des civilisations "outils a usage unique "
     * */

     ArrayList<CarteCivilisation> outilUsageUnique = new ArrayList<CarteCivilisation>();




    /**
     * La liste des outils de l'inventaire
     */
    private ArrayList<Integer> outils;

    /**
     * La liste des outils dispo du joueur
     */
    private ArrayList<Integer> outilsDispo;

    /**
     * La liste des outils non-dispo du joueur
     */
    private ArrayList<Integer> outilsNonDispo;

    /**
     * La liste des cartes Batiments
     */
    private ArrayList<Cartebatiment> cartesBatiments;

    /**
     * Liste des ressources
     */
    private ArrayList<Ressource> listeRessources;

    /**
     * Liste des compteurs de Ressources
     */
    private ArrayList<Integer> listCptRessources;

    /**
     * le dictionnaire des ressources (keys) que l'inventaire possède avec leur quantité comme valeur.
     */

    private HashMap<Ressource, Integer> dicoDesRessources = new HashMap<>();


    //CONSTRUCTEUR


    /**
     * Constructeur de la classe
     */
    public Inventaire(){
        this.nbOuvrierTotal=5;
        this.nbOuvrier = nbOuvrierTotal;
        this.nbNourriture = 12;
        this.nbBois = 0;
        this.nbArgile = 0;
        this.nbPierre = 0;
        this.nbOr = 0;
        this.nbOutils = 0;
        this.niveauAgriculture = 0;
        this.listeRessources = new ArrayList<>(Arrays.asList(Ressource.OR,Ressource.NOURRITURE,Ressource.BOIS,Ressource.ARGILE,Ressource.PIERRE));
        this.listCptRessources = new ArrayList<>(Arrays.asList(this.nbOr,this.nbNourriture,this.nbBois,this.nbArgile,this.nbPierre));
        for (int i = 0; i < listeRessources.size(); i++) {
            dicoDesRessources.put(listeRessources.get(i), listCptRessources.get(i));
        }
        this.outils = new ArrayList<Integer>(Arrays.asList(0,0,0));
        this.outilsDispo = new ArrayList<Integer>(Arrays.asList(0,0,0));
        this.outilsNonDispo = new ArrayList<Integer>(Arrays.asList(0,0,0));
        this.cartesBatiments = new ArrayList<>();
    }


    // ================================== GETTERS & SETTERS ============================== //

    public ArrayList<Cartebatiment> getCartesBatiments() {
        return cartesBatiments;
    }

    public int getNbOuvrierTotal() {
        return nbOuvrierTotal;
    }

    public void setNbOuvrierTotal(int nbOuvrierTotal) {
        this.nbOuvrierTotal = nbOuvrierTotal;
    }

    public ArrayList<Ressource> getListeRessources() {
        return listeRessources;
    }

    public ArrayList<Integer> getListCptRessources() {
        return listCptRessources;
    }

    public void setListCptRessources(ArrayList<Integer> listCptRessources) {
        this.listCptRessources = listCptRessources;
    }

    public HashMap<Ressource, Integer> getDicoDesRessources() {
        return dicoDesRessources;
    }

    /**
     * Récupère la liste des outils non-dispo du joueur
     * @return La liste des outils
     */
    public ArrayList<Integer> getOutilsNonDispo() {
        return outilsNonDispo;
    }

    /**
     * Récupère la liste des outils du joueur
     * @return La liste des outils
     */
    public ArrayList<Integer> getOutils() {
        return outils;
    }

    /**
     * Récupère la liste des outils dispo du joueur
     * @return La liste des outils
     */
    public ArrayList<Integer> getOutilsDispo() {
        return outilsDispo;
    }

    /**
     * Recupere le niveau d'agriculture du joueur
     * @return  Le niveau d'agriculture
     */
    public int getNiveauAgriculture(){ return this.niveauAgriculture; }

    /**
     * Affecte un nombre au niveau d'agriculture du joueur
     * @param niveauAgriculture Un nombre
     */
    public void setNiveauAgriculture(int niveauAgriculture) {this.niveauAgriculture = niveauAgriculture;}

    /**
     * Recupere le nombre d'ouvrier du joueur
     * @return Le nombre d'ouvrier
     */
    public int getNbOuvrier() {
        return nbOuvrier;
    }


/**
     * Recupere le nombre des outils a usaqge unique  du joueur
     * */

    public int getOutilUsageUnique() {
		return OutilUsageUnique;
	}


    public void setOutilUsageUnique(int outilUsageUnique) {
    	this.OutilUsageUnique = outilUsageUnique;
    }
	public void addOutilUsageUnique(int outilUsageUnique) {
		this.OutilUsageUnique += outilUsageUnique;
	}


    /**
     * Affecte un nombre d'ouvrier au joueur
     * @param nbOuvrier Le nombre d'ouvrier
     */

    public void setNbOuvrier(int nbOuvrier) {this.nbOuvrier = nbOuvrier; }

    /**
     * Recupere la quantité de nourriture du joueur
     * @return quantitee de nourriture
     */
    public int getNbNourriture() {
        return nbNourriture;
    }

    /**
     * Affecte une quantité de nourriture au joueur
     * @param nourriture Une quantité de nourriture
     */
    public void setNbNourriture(int nourriture) {this.nbNourriture=nourriture;}

    /**
     * Recuperer la quantité de bois du joueur
     * @return La quantité de bois
     */
    public int getNbBois() {
        return nbBois;
    }

    /**
     * Affecte une quantité de bois au joueur
     * @param nbBois Une quantité de bois
     */
    public void setNbBois(int nbBois) {
        this.nbBois = nbBois;
    }

    /**
     * Recuperer la quantité d'argile du joueur
     * @return La quantité d'argile
     */
    public int getNbArgile() { return nbArgile; }

    /**
     * Affecte une quantité de d'argile au joueur
     * @param nbArgile La quantité d'argile
     */
    public void setNbArgile(int nbArgile) { this.nbArgile = nbArgile; }

    /**
     * Recuperer la quantité de pierre du joueur
     * @return La quantité de pierre
     */
    public int getNbPierre() {return nbPierre; }

    /**
     * Affecte une quantité de pierre au joueur
     * @param nbPierre Une quantité de pierre
     */
    public void setNbPierre(int nbPierre) { this.nbPierre = nbPierre; }

    /**
     * Recuperer la quantité d'or du joueur
     * @return La quantité d'or
     */
    public int getNbOr() {return nbOr; }

    /**
     * Affecte une quantité d'or au joueur
     * @param nbOr Une quantité d'or
     */
    public void setNbOr(int nbOr) {this.nbOr = nbOr; }

    /**
     * Recuperer le nombre d'outils du joueur
     * @return Le nombre d'outils
     */
    public int getNbOutils() { return nbOutils; }

    /**
     * Affecte un nombre d'outils au joueur
     * @param nbOutils Un nombre d'outils
     */
    public void setNbOutils(int nbOutils) {this.nbOutils = nbOutils; }

    /**
     * Récupère le nombre de points du joueur
     * @return Un nombre de points
     */
    public int getNbPointTotal() {
        return nbPointTotal;
    }

    /**
     * Affecte un nombre de points au joueur
     * @param nbPointTotal Un nombre de points
     */
    public void setNbPointTotal(int nbPointTotal) {
        this.nbPointTotal = nbPointTotal;
    }

    /**
     * Rècupère le nombre de ressource total du joueur
     * @return Le nombre de ressource
     */
    public int getNbRessourceTotal() {
        return getNbBois()+getNbArgile()+getNbPierre()+getNbOr()+getNiveauAgriculture();
    }



    // ===================================    METHODES   ======================================== //



    public String toString() {
    	return "nb d'ouvrier= " +nbOuvrierTotal+
    		     "\nnb bois = " +nbBois+
    		     "\nnbd'Argile = " +nbArgile+
    		     "\nnb Pierre = " +nbPierre+
    		     "\nnb d'or  = " +nbOr+
    		     "\nnb d'outils  = " +nbOutils+
    		     "\nnb nourriture = " +nbNourriture+
    		     "\nLe niveau d'agriculture = " +niveauAgriculture+
    		     "\nnb de points  = " + this.calculPoint() ;
    }


    /**
     * Calcule les points du joueur
     * @return Un nombre de points
     */
    public int calculPoint(){
        int point;
        point = this.getNbArgile()+this.getNbBois()+this.getNbNourriture()+this.getNbOr()+this.getNbPierre()+this.getNbOutils();
        return point;
    }

    /**
     * Réinitialise les ressources
     * @param i L'index du tableau
     * @param valeur La valeur à affecter
     */
    public void restRessource ( int  i,int valeur ){

        switch (i){

            case 0 :
                setNbBois(valeur);
                break;
            case 1:
                setNbArgile(valeur);
                break;
            case 2:
                setNbPierre(valeur);
                break;
            case 3:
                setNbOr(valeur);
                break;
        }
    }

    /**
     * En cas d'égalité entre joueur,
     * on compte le nombre d'ouvrier, d'outils et du niveau d'agriculture de l'inventaire
     * pour le départager entre les autres joueur
     * @return la somme du nombre d'ouvrier, d'outils et du niveau d'agriculture
     */
    public int pointDeDepartage(){
        int sommeOutils = 0 ;
        for (int outil: this.outils) {
            sommeOutils+=outil;
        }
        return this.niveauAgriculture + this.nbOuvrierTotal + sommeOutils;
    }

    public void resetNbOuvrierDispo(){
        this.nbOuvrier = this.nbOuvrierTotal;
    }

    public int getNbCartesBatiments() {
        return this.cartesBatiments.size();
    }

}
