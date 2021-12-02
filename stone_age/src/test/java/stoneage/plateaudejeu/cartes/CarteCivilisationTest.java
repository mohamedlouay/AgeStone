package stoneage.plateaudejeu.cartes;

import org.junit.jupiter.api.Test;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Plateau;
import stoneage.plateaudejeu.Ressource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarteCivilisationTest {

    Plateau plateau = new Plateau(4);

    Inventaire i = new Inventaire();
    CarteCivilisation carte = new CarteCivilisation(1, CarteCivilisation.Couleur.VERTE, Ressource.PIERRE, PartieInferieure.CHAMANE, 1);

    @Test
    void placeOuvrierSurCarte() {
        // inventaire a 5 ouvriers par defaut

        carte.placeOuvrierSurCarte(i);
        assertEquals(true,carte.isPlaceReservee());
        assertEquals(4,i.getNbOuvrier());

    }



    @Test
    void retirerOuvrierSurCarte() {

        int nb ;
        carte.placeOuvrierSurCarte(i);
        nb =i.getNbOuvrier();
        carte.retirerOuvrierSurCarte(i);
        assertEquals(nb+1,i.getNbOuvrier());
        assertEquals(false,carte.isPlaceReservee());


    }

    @Test
    void payement() {
        i.setNbPierre(1);
        i.setNbOr(1);
        i.setNbArgile(1);
        // le joueur a 3 ressources . donc il peut payer une carte a la postion : 0 , 1 ou 2 et non 3
        assertEquals(true,carte.payement(i,2));//positioncards = 2 => prix = 2+1 = 3 donc true
        assertEquals(false,carte.payement(i,3));//positioncards = 3 => prix = 3+1 = 4 donc false


    }

    @Test
    void gainCarte() {
        // carte gain ressource sans jet de de
        CarteCivilisation carte = new CarteCivilisation(2, CarteCivilisation.Couleur.VERTE, Ressource.PIERRE, PartieInferieure.CHAMANE, 1);
        int nbPierreAvant = i.getNbPierre();
        carte.gainCarte(i,plateau);
        int NbPierreApres = i.getNbPierre();
        assertEquals(nbPierreAvant+2,NbPierreApres);


        // carte gain ressource avec jet de de
        i=new Inventaire();
        carte =  new CarteCivilisation(CarteCivilisation.Couleur.SABLE, Ressource.PIERRE, true, PartieInferieure.CHAMANE, 1);
        nbPierreAvant = i.getNbPierre();
        carte.gainCarte(i,plateau);
         NbPierreApres = i.getNbPierre();
        assertEquals(true,NbPierreApres>=nbPierreAvant);

        // carte gain nourriture
        i= new Inventaire();
        carte = new CarteCivilisation(3, CarteCivilisation.Couleur.SABLE, Ressource.NOURRITURE, PartieInferieure.PAYSANT, 2);

        int nbNourritureAvant = i.getNbNourriture();
        carte.gainCarte(i,plateau);
         int NbnourritureApres = i.getNbNourriture();
        assertEquals(nbNourritureAvant+3,NbnourritureApres);

        // carte gain point de vectoire
        i= new Inventaire();
        carte = new CarteCivilisation(3, CarteCivilisation.Couleur.VERTE, Ressource.POINT, PartieInferieure.MEDECINE);

        int nbPointAvant = i.getNbPointTotal();
        carte.gainCarte(i,plateau);
         int nbPointApres = i.getNbPointTotal();
        assertEquals(nbPointAvant+3,nbPointApres);

  // carte gain niveau agriculture
        i= new Inventaire();
        carte = new CarteCivilisation(1, CarteCivilisation.Couleur.VERTE, Ressource.AGRICULTURE, PartieInferieure.CADRAN_SALAIRE);

        int niveauAvant = i.getNiveauAgriculture();
        carte.gainCarte(i,plateau);
         int niveauApres = i.getNiveauAgriculture();
        assertEquals(niveauAvant+1,niveauApres);

        // carte gain tuile outil
        i= new Inventaire();
        carte = new CarteCivilisation(1, CarteCivilisation.Couleur.VERTE, Ressource.OUTIL, PartieInferieure.ART);

        int nbOutilsAvant = i.getNbOutils();
        carte.gainCarte(i,plateau);
         int nbOutilsApres = i.getNbOutils();
        assertEquals(nbOutilsAvant+1,nbOutilsApres);


        // carte gain ressource au choix
        i= new Inventaire();
        carte = new CarteCivilisation(2, CarteCivilisation.Couleur.VERTE, Ressource.RESSOURCE_AU_CHOIX, PartieInferieure.MEDECINE);

        int nbRessourceAvants = i.getNbRessourceTotal();
        carte.gainCarte(i,plateau);
        int nbRessourceApress = i.getNbRessourceTotal();
        assertEquals(nbRessourceAvants+2,nbRessourceApress);

        // carte gain multi ressources
        i =plateau.getListeInventaire().get(0);
        carte = new CarteCivilisation(CarteCivilisation.Couleur.VERTE, Ressource.MULTI, true, PartieInferieure.MEDECINE);

        int nbRessourceAvant = i.getNbRessourceTotal();
        carte.gainCarte(i,plateau);
        int nbRessourceApres = i.getNbRessourceTotal();
        assertEquals(nbRessourceAvant+1,nbRessourceApres);

    }


    @Test
    void recupererCarte() {
         plateau.getListeInventaire().get(0).setNbPierre(2);
         i=plateau.getListeInventaire().get(0);
         CarteCivilisation carte = plateau.cards.get(1);
         carte.recupererCarte(i,1,plateau);

         assertEquals(false,plateau.cards.contains(carte));

        plateau.getListeInventaire().get(1).setNbPierre(2);
        i=plateau.getListeInventaire().get(1);
        CarteCivilisation carte2 = plateau.cards.get(3);
        carte2.recupererCarte(i,3,plateau);

        assertEquals(true,plateau.cards.contains(carte2));







    }



    @Test
    void decompteFinal() {
        Inventaire i =new Inventaire();
        i.setNiveauAgriculture(4);
        ArrayList<CarteCivilisation> cards =new ArrayList<>();
        cards.add(new CarteCivilisation(1, CarteCivilisation.Couleur.SABLE, Ressource.ARGILE, PartieInferieure.CHAMANE, 1));
        cards.add(new CarteCivilisation(1, CarteCivilisation.Couleur.SABLE, Ressource.PIERRE, PartieInferieure.PAYSANT, 1));





    }

    @Test
    void decompteFinalSableCards() {

        Inventaire i =new Inventaire();
        i.setNiveauAgriculture(4);
        ArrayList<CarteCivilisation> cards =new ArrayList<>();
        cards.add(new CarteCivilisation(1, CarteCivilisation.Couleur.SABLE, Ressource.ARGILE, PartieInferieure.CHAMANE, 1));
        cards.add(new CarteCivilisation(1, CarteCivilisation.Couleur.SABLE, Ressource.PIERRE, PartieInferieure.PAYSANT, 1));
        cards.add(new CarteCivilisation(3, CarteCivilisation.Couleur.VERTE, Ressource.NOURRITURE, PartieInferieure.TISSAGE));
        cards.add(new CarteCivilisation(7, CarteCivilisation.Couleur.VERTE, Ressource.NOURRITURE, PartieInferieure.POTERIE));
        cards.add(new CarteCivilisation(7, CarteCivilisation.Couleur.VERTE, Ressource.NOURRITURE, PartieInferieure.POTERIE));

        int score =CarteCivilisation.decompteFinal(i,cards);

        assertEquals(14,score);//decompte final Green = 9 + decompte final SAble = 5 donc  decompte final = 14




    }

    @Test
    void decompteFinalGreenCards() {
        Inventaire i =new Inventaire();
        ArrayList<CarteCivilisation> cards =new ArrayList<>();

        cards.add(new CarteCivilisation(3, CarteCivilisation.Couleur.VERTE, Ressource.NOURRITURE, PartieInferieure.TISSAGE));
        cards.add(new CarteCivilisation(7, CarteCivilisation.Couleur.VERTE, Ressource.NOURRITURE, PartieInferieure.POTERIE));
        cards.add(new CarteCivilisation(7, CarteCivilisation.Couleur.VERTE, Ressource.NOURRITURE, PartieInferieure.POTERIE));

        int score= CarteCivilisation.decompteFinalGreenCards(i,cards);

        assertEquals(5,score);



    }




}