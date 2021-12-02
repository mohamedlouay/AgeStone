package stoneage.plateaudejeu.cartes;


import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Ressource;

import java.util.ArrayList;
import java.util.HashMap;



public class Cartebatiment {

    private int nbRessourceApayer;
    private int point;
    private int nbOuvrierSurCarte;
    ArrayList<Ressource> ressource;
    private int nbRessourceDiff;
    public boolean isPlaceReserver() {
        return PlaceReserver;
    }
    private boolean PlaceReserver;
    private int type_carte;


    /**
     * Constructeur de CarteBatiment
     *
     * @param point  : le nombre de point d'une carte.
     * @param ressource : Une liste De ressources de la carte .
     *
     */
    public Cartebatiment(int point, ArrayList<Ressource> ressource) {
        this.nbOuvrierSurCarte = 1;
        this.nbRessourceApayer = 3;
        this.point = point;
        this.type_carte=1;
        this.ressource = ressource;
        this.PlaceReserver = false;

    }

    /**
     *
     * @param nbRessourceApayer : Le nombre de ressources que le joueur doit payer afin d'acquérir la carte.
     * @param nbRessourceDiff : le nombre de ressources différentes d'une carte .
     * @param type_carte
     */
    public Cartebatiment(int nbRessourceApayer, int nbRessourceDiff, int type_carte) {
        this.nbOuvrierSurCarte = 1;
        this.nbRessourceApayer = nbRessourceApayer;
        this.point = point;
        this.type_carte=type_carte;
        this.nbRessourceDiff = nbRessourceDiff;
        this.PlaceReserver = false;


    }

    Cartebatiment( int nbRessourceDiff, int type_carte) {
        this.nbOuvrierSurCarte = 1;
        this.type_carte = type_carte;
        this.nbRessourceDiff = nbRessourceDiff;
        this.PlaceReserver = false;
    }


    public int getNbRessourceApayer() {
        return nbRessourceApayer;
    }

    /**
     * Methode qui permet au joueur de pouvoir récuperer son ouvrier sur la carte.
     *
     * @param inventaireJoueur
     */
    public void retirerOuvrierSurCarte(Inventaire inventaireJoueur) {
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + 1);
        this.PlaceReserver = false;
    }


    /**
     *
     * @param inventaireJoueur :l'inventaire du Joueur.
     * @param choixNbRessource : Le nombre de ressources que le Joueur doit payer afin d'acquérir La carte.
     */
    public void payement(Inventaire inventaireJoueur, int choixNbRessource) {
        int somme = inventaireJoueur.getNbOr()+ inventaireJoueur.getNbPierre()+inventaireJoueur.getNbArgile()+inventaireJoueur.getNbBois();


        if (this.type_carte==3) {

            for (int i = 0; i < choixNbRessource; i++) {
                if (inventaireJoueur.getNbBois() > 0) {
                    inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                    point += 3;
                    continue;
                }
                if (inventaireJoueur.getNbArgile() > 0) {
                    inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                    point +=4;
                    continue;
                }
                if (inventaireJoueur.getNbPierre() > 0) {
                    inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                    point += 5;
                    continue;
                }
                if (inventaireJoueur.getNbOr() > 0) {
                    inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                    point += 6;
                    continue;
                }
            }
            inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier()-1);
        }

        if (this.type_carte==2) {
            switch (nbRessourceDiff) {
                case 1 :
                    if (inventaireJoueur.getNbOr() >= nbRessourceApayer) {
                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - nbRessourceApayer);
                            point = point + nbRessourceApayer*6;
                            break;


                    }
                    if (inventaireJoueur.getNbPierre() >= nbRessourceApayer) {
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - nbRessourceApayer);
                            point = point + nbRessourceApayer*5;
                            break;


                    }
                    if (inventaireJoueur.getNbArgile() >= nbRessourceApayer) {
                        inventaireJoueur.setNbArgile(inventaireJoueur.getNbPierre() - nbRessourceApayer);
                        point = point + nbRessourceApayer*4;
                        break;

                    }
                    if (inventaireJoueur.getNbBois() >= nbRessourceApayer) {
                        inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - nbRessourceApayer);
                        point = point + nbRessourceApayer*3;
                        break;
                    }
                    inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier()-1);
                    break;

                case 2 :
                    int[] tab = new int[]{inventaireJoueur.getNbOr(),inventaireJoueur.getNbPierre(),inventaireJoueur.getNbArgile(),
                        inventaireJoueur.getNbBois()};
                    for (int i = 0; i < tab.length; i++) {
                        for (int j = i + 1; j < tab.length; j++) {
                            if ((tab[i] > 0) && (tab[j] > 0)) {
                                if (tab[i] + tab[j] >= nbRessourceApayer) {
                                    if ((i == 0) || (j == 1)) {
                                        if (nbRessourceApayer <= tab[i]) {
                                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - (nbRessourceApayer - 1));
                                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                                            point = point + (nbRessourceApayer - 1) * 6 + 5;
                                            break;
                                        } else {
                                            point = inventaireJoueur.getNbOr() * 6 + (nbRessourceApayer - (inventaireJoueur.getNbOr())) * 5;
                                            inventaireJoueur.setNbOr(0);
                                            nbRessourceApayer -= inventaireJoueur.getNbOr();
                                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - nbRessourceApayer);
                                            break;
                                        }
                                    }
                                    if ((i == 0) || (j == 2)) {
                                        if (nbRessourceApayer <= tab[i]) {
                                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - (nbRessourceApayer - 1));
                                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                                            point = point + (nbRessourceApayer - 1) * 6 + 4;

                                        } else {
                                            point = inventaireJoueur.getNbOr() * 6 + (nbRessourceApayer - (inventaireJoueur.getNbOr())) * 4;
                                            inventaireJoueur.setNbOr(0);
                                            nbRessourceApayer -= inventaireJoueur.getNbOr();
                                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - nbRessourceApayer);

                                        }

                                    }
                                    if ((i == 0) || (j == 3)) {
                                        if (nbRessourceApayer <= tab[i]) {
                                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - (nbRessourceApayer - 1));
                                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                                            point = point + (nbRessourceApayer - 1) * 6 + 3;

                                        } else {
                                            point = inventaireJoueur.getNbOr() * 6 + (nbRessourceApayer - (inventaireJoueur.getNbOr())) * 3;
                                            inventaireJoueur.setNbOr(0);
                                            nbRessourceApayer -= inventaireJoueur.getNbOr();
                                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - nbRessourceApayer);
                                        }

                                    }
                                    if ((i == 1) || (j == 2)) {
                                        if (nbRessourceApayer <= tab[i]) {
                                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - (nbRessourceApayer - 1));
                                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                                            point = point + (nbRessourceApayer - 1) * 5 + 4;

                                        } else {
                                            point = inventaireJoueur.getNbPierre() * 5 + (nbRessourceApayer - (inventaireJoueur.getNbPierre())) * 4;
                                            inventaireJoueur.setNbPierre(0);
                                            nbRessourceApayer -= inventaireJoueur.getNbPierre();
                                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - nbRessourceApayer);
                                        }

                                    }
                                    if ((i == 1) || (j == 3)) {
                                        if (nbRessourceApayer <= tab[i]) {
                                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - (nbRessourceApayer - 1));
                                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                                            point = point + (nbRessourceApayer - 1) * 5 + 3;

                                        } else {
                                            point = inventaireJoueur.getNbPierre() * 5 + (nbRessourceApayer - (inventaireJoueur.getNbPierre())) * 3;
                                            inventaireJoueur.setNbPierre(0);
                                            nbRessourceApayer -= inventaireJoueur.getNbPierre();
                                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - nbRessourceApayer);


                                        }
                                    }
                                    if ((i == 2) || (j == 3)) {
                                        if (nbRessourceApayer <= tab[i]) {
                                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - (nbRessourceApayer - 1));
                                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                                            point = point + (nbRessourceApayer - 1) * 5 + 3;

                                        } else {
                                            point = inventaireJoueur.getNbArgile() * 4 + (nbRessourceApayer - (inventaireJoueur.getNbArgile())) * 3;
                                            inventaireJoueur.setNbArgile(0);
                                            nbRessourceApayer -= inventaireJoueur.getNbArgile();
                                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - nbRessourceApayer);

                                        }


                                    }
                                }
                            }
                        }
                    }
                    tab[0] = inventaireJoueur.getNbOr();
                    tab[1] = inventaireJoueur.getNbPierre();
                    tab[2] = inventaireJoueur.getNbArgile();
                    tab[3] = inventaireJoueur.getNbBois();
                    inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier()-1);

                case 3:
                    if(inventaireJoueur.getNbOr()>0 &&(inventaireJoueur.getNbPierre()>0 && inventaireJoueur.getNbArgile()>0)) {
                        if (nbRessourceApayer == 3) {
                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                            point = point +6 + 5 + 4;
                            break;

                        }
                        if (nbRessourceApayer > 3 && (inventaireJoueur.getNbOr() > 1)) {
                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 2);
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                            point = point +2*6 + 5 + 4;
                            break;

                        }
                        if (nbRessourceApayer > 3 && (inventaireJoueur.getNbPierre() > 1 && inventaireJoueur.getNbOr() == 1)) {
                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 2);
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                            point = point +6 + 2*5 + 4;
                            break;

                        } else {
                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 2);
                            point = point +6 + 5 + 2*4;
                            break;
                        }
                    }
                    if(inventaireJoueur.getNbOr()>0 &&(inventaireJoueur.getNbPierre()>0 && inventaireJoueur.getNbBois()>0)) {
                        if (nbRessourceApayer == 3) {
                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                            point = point +6 + 5 + 3;
                            break;


                        }
                        if (nbRessourceApayer > 3 && (inventaireJoueur.getNbOr() > 1)) {
                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 2);
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                            point = point + 2*6 + 5 + 3;
                            break;

                        }
                        if (nbRessourceApayer > 3 && (inventaireJoueur.getNbPierre() > 1 && inventaireJoueur.getNbOr() == 1)) {
                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 2);
                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                            point = point + 6 + 2*5 + 3;
                            break;


                        } else {
                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 2);
                            point = point + 6 + 5 + 2*3;
                            break;

                        }

                    }
                    if(inventaireJoueur.getNbArgile()>0 &&(inventaireJoueur.getNbPierre()>0 && inventaireJoueur.getNbBois()>0)) {
                        if (nbRessourceApayer == 3) {
                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois()- 1);
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbBois() - 1);
                            point = point + 5 +4+ 3;
                            break;


                        }
                        if (nbRessourceApayer > 3 && (inventaireJoueur.getNbPierre() > 1)) {
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 2);
                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                            point = point + 2*5 +4+ 3;
                            break;


                        }
                        if (nbRessourceApayer > 3 && (inventaireJoueur.getNbArgile() > 1 && inventaireJoueur.getNbPierre() == 1)) {
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 2);
                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                            point =point + 5+ 2*4 + 3;
                            break;

                        } else {
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbBois() - 2);
                            point = point + 5 +4 +2*3;
                            break;
                        }

                    }
                        case 4 :
                            if(inventaireJoueur.getNbOr()>0 &&(inventaireJoueur.getNbPierre()>0 && inventaireJoueur.getNbArgile()>0)
                            && (inventaireJoueur.getNbBois()>0)) {
                                if (somme > nbRessourceApayer) {
                                    if (nbRessourceApayer == 4) {
                                        inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                                        inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                                        inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                                        inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                                        point = point + 6 + 5 + 4 + 3;
                                        break;
                                    }
                                    if (nbRessourceApayer == 5) {
                                        if (inventaireJoueur.getNbOr() > 1) {
                                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 2);
                                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                                            point = point + 2 * 6 + 5 + 4 + 3;
                                            break;

                                        }
                                        if (inventaireJoueur.getNbPierre() > 1 && (inventaireJoueur.getNbOr() == 1)) {
                                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 2);
                                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                                            point = point + 6 + 2 * 5 + 4 + 3;
                                            break;

                                        }
                                        if (inventaireJoueur.getNbArgile() > 1 && (inventaireJoueur.getNbOr() == 1) && inventaireJoueur.getNbPierre() == 1) {
                                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 2);
                                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                                            point = point + 6 + 5 + 2 * 4 + 3;
                                            break;

                                        } else {
                                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 2);
                                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 2);
                                            point = point + 6 + 5 + 4 + 2 * 3;
                                            break;
                                        }

                                    }
                                }
                            }

                    inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier()-1);


            }
        }
        if (this.type_carte==1){
            int nbargile = 0;
            int nbbois = 0;
            int nbor = 0;
            int nbpierre = 0;

            for (Ressource r : ressource) {
                switch (r) {
                    case OR:
                        nbor++;
                        break;
                    case BOIS:
                        nbbois++;
                        break;
                    case PIERRE:
                        nbpierre++;
                        break;
                    case ARGILE:
                        nbargile++;
                        break;
                }
            }
            if ((nbargile <= inventaireJoueur.getNbArgile()) && (nbbois <= inventaireJoueur.getNbBois()) && (nbpierre <= inventaireJoueur.getNbPierre())
                    && nbor <= inventaireJoueur.getNbOr()) {
                inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - nbargile);
                inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - nbpierre);
                inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - nbbois);
                inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - nbor);
            }
        }

        this.retirerOuvrierSurCarte(inventaireJoueur);
        inventaireJoueur.setNbPointTotal(inventaireJoueur.getNbPointTotal() + point);
    }

    public String toString() {
        if (nbRessourceDiff==7)
            return "CarteBatiment1-7";
        if (nbRessourceDiff>=1 && nbRessourceDiff<5)
            return "CarteBatiment-5";
        else
            return "CarteBatiment-3";
    }
}




