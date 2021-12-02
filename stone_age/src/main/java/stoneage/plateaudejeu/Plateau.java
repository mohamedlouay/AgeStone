package stoneage.plateaudejeu;


import stoneage.joueur.IaAlea;
import stoneage.joueur.Joueur;
import stoneage.partie.Partie;
import stoneage.plateaudejeu.cartes.CarteCivilisation;
import stoneage.plateaudejeu.cartes.Cartebatiment;
import stoneage.plateaudejeu.zones.Zone;
import stoneage.plateaudejeu.zones.ZoneVillage;

import java.util.*;

/**
 * La classe du plateau de jeu
 */
public class Plateau {


    //CHAMPS

    boolean twoPlayers= (Partie.getNbJoueur()==2);
    boolean threePlayers= (Partie.getNbJoueur()==3);

    /**
     * Zone riviere
     */
    private Zone Riviere;

    /**
     * Zone chasse
     */
    private Zone Chasse;

    /**
     * Zone Foret
     */
    private Zone Foret;

    /**
     * Zone Glaciere
     */
    private Zone Glaisiere;

    /**
     * Zone Carriere
     */
    private Zone Carriere;

    /**
     * Zone Champ
     */
    private ZoneVillage Champ;

    /**
     * Zone Hutte
     */
    private ZoneVillage Hutte;

    /**
     * Zone FabriqueOutils
     */
    private ZoneVillage FabriqueOutils;
    
    /**
     * tableau qui contient toutes les cartes de civilisations .
     * */
   public static  ArrayList<CarteCivilisation> cards=CarteCivilisation.CreationCarte();

    /**
     * La liste des zones disponibles au placement
     */
    private ArrayList<Zone> ZonesDispo;
    
    /**
     * La liste des zones pleines au placement
     */
    private ArrayList<Zone> ZonesPleines;
    
    /**
     * La liste des zones visitées par le joueur
     */
    private ArrayList<ArrayList<Zone>> ZoneVisitees;

    /**
     * La liste des cartes visitées par le joueur
     */
    private ArrayList<ArrayList<Cartebatiment>> CarteVisitees;

    /**
     * Liste des inventaires des joueurs
     */
    private ArrayList<Inventaire> listeInventaire = new ArrayList<Inventaire>();

    /**
     * Le tableau des IAs qui font les choix de jeu
     */
    private ArrayList<IaAlea> IA = new ArrayList<>();

    /**
     * Le tableau qui contient les joueurs
     */
    private ArrayList<Joueur> joueurs = new ArrayList<>();

    /**
     * La liste des numéro des joueurs
     */
    private ArrayList<Integer> tableauFirstPlayer;

    /**
     * Le tableau de toutes les zones
     */
    private Zone [] tabAllZone;

    /**
     * La liste de toutes les cartes batiment
     */
    private  ArrayList<Cartebatiment> cartetotale;

    /**
     * Liste qui contient le deck des cartes batiment construit grace a la liste cartetotale
     */
    private ArrayList<ArrayList<Cartebatiment>> listeCarteTotale;


    /**
     * Creation de cartes batiments
     */
    private Cartebatiment carte1,carte2,carte3,carte4,carte5,carte6,carte7,
            carte8,carte9,carte10,carte11,carte12,carte13,carte14,carte15,
            carte16,carte17,carte18,carte19,carte20,carte21,carte22,carte23,
            carte24,carte25,carte26,carte27,carte28;




    //===================  CONSTRUTEUR  ==============================//

    /**
     * Constructeur de la classe
     * @param nbjoueur Le nombre de joueurs dans le jeu
     */
    public Plateau(int nbjoueur){

        this.carte1=new Cartebatiment(10,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.BOIS,Ressource.ARGILE)));
        this.carte2=new Cartebatiment(11,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.BOIS,Ressource.PIERRE)));
        this.carte3=new Cartebatiment(11,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.ARGILE,Ressource.ARGILE)));
        this.carte4=new Cartebatiment(12,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.BOIS,Ressource.OR)));
        this.carte5=new Cartebatiment(12,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.ARGILE,Ressource.PIERRE)));
        this.carte6=new Cartebatiment(12,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.ARGILE,Ressource.PIERRE)));
        this.carte7=new Cartebatiment(13,new ArrayList<Ressource>(Arrays.asList(Ressource.ARGILE,Ressource.ARGILE,Ressource.PIERRE)));
        this.carte8=new Cartebatiment(14,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.PIERRE,Ressource.OR)));
        this.carte9=new Cartebatiment(14,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.PIERRE,Ressource.OR)));
        this.carte10=new Cartebatiment(13,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.PIERRE,Ressource.PIERRE)));
        this.carte11=new Cartebatiment(13,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.ARGILE,Ressource.OR)));
        this.carte12=new Cartebatiment(13,new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS,Ressource.ARGILE,Ressource.OR)));
        this.carte13=new Cartebatiment(14,new ArrayList<Ressource>(Arrays.asList(Ressource.ARGILE,Ressource.ARGILE,Ressource.OR)));
        this.carte14=new Cartebatiment(14,new ArrayList<Ressource>(Arrays.asList(Ressource.ARGILE,Ressource.PIERRE,Ressource.PIERRE)));
        this.carte15=new Cartebatiment(15,new ArrayList<Ressource>(Arrays.asList(Ressource.ARGILE,Ressource.PIERRE,Ressource.OR)));
        this.carte16=new Cartebatiment(15,new ArrayList<Ressource>(Arrays.asList(Ressource.ARGILE,Ressource.PIERRE,Ressource.OR)));
        this.carte17=new Cartebatiment(15,new ArrayList<Ressource>(Arrays.asList(Ressource.PIERRE,Ressource.PIERRE,Ressource.OR)));
        this.carte18=new Cartebatiment(5,4,2);
        this.carte19=new Cartebatiment(5,3,2);
        this.carte20=new Cartebatiment(5,2,2);
        this.carte21=new Cartebatiment(5,1,2);
        this.carte22=new Cartebatiment(4,4,2);
        this.carte23=new Cartebatiment(4,3,2);
        this.carte24=new Cartebatiment(4,2,2);
        this.carte25=new Cartebatiment(4,1,2);
        this.carte26=new Cartebatiment(1,7,3);
        this.carte27=new Cartebatiment(1,7,3);
        this.carte28=new Cartebatiment(1,7,3);

        this.cartetotale = new ArrayList<Cartebatiment>(Arrays.asList(this.carte1,this.carte2,this.carte3,this.carte4,
                this.carte5,this.carte6,this.carte7,this.carte8,
                this.carte9,this.carte10,this.carte11,this.carte12,
                this.carte13,this.carte14,this.carte15,this.carte16,
                this.carte17,this.carte18,this.carte19,this.carte20,
                this.carte21,this.carte22,this.carte23,this.carte24,
                this.carte25,this.carte26,this.carte27,this.carte28));
        Collections.shuffle(cartetotale);
        this.listeCarteTotale= new ArrayList<ArrayList<Cartebatiment>>();

        this.Riviere = new Zone(Ressource.OR, 12, 6, 0, 7);
        this.Chasse = new Zone(Ressource.NOURRITURE, 12, 2, 0, Integer.MAX_VALUE);
        this.Foret = new Zone(Ressource.BOIS, 12, 3, 0, 7);
        this.Glaisiere = new Zone(Ressource.ARGILE, 12, 4, 0, 7);
        this.Carriere = new Zone(Ressource.PIERRE, 12, 5, 0, 7);
        this.Champ = new ZoneVillage(0,1,0);
        this.FabriqueOutils = new ZoneVillage(0,1,1);
        this.Hutte = new ZoneVillage(0,2,2);
        this.tabAllZone = new Zone[] {this.Riviere, this.Chasse, this.Foret, this.Glaisiere, this.Carriere,this.Champ,this.FabriqueOutils,this.Hutte};
        this.ZonesDispo = new ArrayList<Zone>(Arrays.asList(tabAllZone));
        this.ZoneVisitees = new ArrayList<ArrayList<Zone>>();
        this.CarteVisitees = new ArrayList<ArrayList<Cartebatiment>>();
        this.ZonesPleines = new ArrayList<Zone>();
        this.tableauFirstPlayer = new ArrayList<Integer>();

        ArrayList<Zone> zp;
        ArrayList<Cartebatiment> cp;
        ArrayList<Cartebatiment> carteTuiles;
        for (int i = 0; i < nbjoueur ; i++) {
            this.IA.add(new IaAlea());
            this.joueurs.add(new Joueur());
            Inventaire inventaire = new Inventaire();
            listeInventaire.add(inventaire);
            zp = new ArrayList<Zone>();
            ZoneVisitees.add(zp);
            cp = new ArrayList<Cartebatiment>();
            CarteVisitees.add(cp);

            carteTuiles = new ArrayList<Cartebatiment>();
            listeCarteTotale.add(carteTuiles);
            for (int j = 0; j < 7; j++) {
                listeCarteTotale.get(i).add(cartetotale.get(0));
                cartetotale.remove(0);
            }
            tableauFirstPlayer.add(i);
        }

    }

    //METHODES
    // ============================ GETTERS =========================== //

    /**
     * Récupère les zones disponibles lors du placement
     * @return La liste des zones disponibles
     */
    public ArrayList<Zone> getZonesDispo() {
        return ZonesDispo;
    }

    /**
     * Récupère les zones pleines lors du placement
     * @return La liste des zones pleines
     */
    public ArrayList<Zone> getZonesPleines() {
        return ZonesPleines;
    }

    /**
     * Récupère la liste des inventaires
     * @return Les inventaires
     */
    public ArrayList<Inventaire> getListeInventaire() {
        return listeInventaire;
    }

    /**
     * Récupère la liste des Joueurs
     * @return Liste de Joueurs
     */
    public ArrayList<Joueur> getJoueurs(){
        return this.joueurs;
    }

    public boolean isTwoPlayers() {
        return twoPlayers;
    }

    public boolean isThreePlayers() {
        return threePlayers;
    }

    public static ArrayList<CarteCivilisation> getCards() {
        return cards;
    }

    public ArrayList<ArrayList<Zone>> getZoneVisitees() {
        return ZoneVisitees;
    }

    public ArrayList<ArrayList<Cartebatiment>> getCarteVisitees() {
        return CarteVisitees;
    }

    public ArrayList<IaAlea> getIA() {
        return IA;
    }

    public ArrayList<Integer> getTableauFirstPlayer() {
        return tableauFirstPlayer;
    }

    public Zone[] getTabAllZone() {
        return tabAllZone;
    }

    public ArrayList<Cartebatiment> getCartetotale() {
        return cartetotale;
    }

    public ArrayList<ArrayList<Cartebatiment>> getListeCarteTotale() {
        return listeCarteTotale;
    }


    public Zone getRiviere() {
        return Riviere;
    }

    public Zone getChasse() {
        return Chasse;
    }

    public Zone getForet() {
        return Foret;
    }

    public Zone getGlaisiere() {
        return Glaisiere;
    }

    public Zone getCarriere() {
        return Carriere;
    }

    public Zone getChamp() {
        return Champ;
    }

    public Zone getHutte() {
        return Hutte;
    }

    public Zone getFabriqueOutils() {
        return FabriqueOutils;
    }


    // ====================== METHODES =============================//



    /**
     * Récupère le nombre d'ouvriers total qui ne sont pas encore placés
     * @return Le nombre d'ouvriers
     */
    public static int nbOuvrierDispoTotal(ArrayList<Inventaire> listeInventaire) {
        int n = 0;
        for (int i = 0; i<listeInventaire.size(); i++){
            n += listeInventaire.get(i).getNbOuvrier(); //On reste que sur nbOuvriers et on ne travaille plus avec nbOuvriersDispo
        }
        return n;
    }

//    public boolean verifierNbCarteCivilisation() {
//        if ((carteCivilisationPioche.size()+carteCivilisationDispo.size())<4)
//            return false;
//        else
//            return true;
//    }

    public boolean verifierNbCarteBatiment() {
        for (int i = 0; i < listeCarteTotale.size(); i++) {
            if (listeCarteTotale.get(i).size()<1) {
                return false;
            }
        }

        return true;
    }

    public void updateDico() {
        for (Inventaire inventaire : listeInventaire) {
            /* On update la liste des compteurs d'abord*/
            inventaire.setListCptRessources(new ArrayList<>(Arrays.asList(inventaire.getNbOr(),inventaire.getNbNourriture(), inventaire.getNbBois(),
                    inventaire.getNbArgile(), inventaire.getNbPierre())));

            /* On update le dictionnaire*/
            for (int i = 0; i < inventaire.getListeRessources().size(); i++) {
                inventaire.getDicoDesRessources().put(inventaire.getListeRessources().get(i), inventaire.getListCptRessources().get(i));
            }
        }
    }

}
