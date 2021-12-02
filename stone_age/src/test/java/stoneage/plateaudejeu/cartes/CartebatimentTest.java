package stoneage.plateaudejeu.cartes;

import org.junit.jupiter.api.Test;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Ressource;
import stoneage.plateaudejeu.cartes.Cartebatiment;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CartebatimentTest {

    Inventaire inventaire = new Inventaire();
    Cartebatiment carte = new Cartebatiment(2,3,3);


    @Test
    void retirerOuvrierSurCarte() {
        int nbOuvriersTotal=6;
        carte.retirerOuvrierSurCarte(inventaire);
        int nbTotaledansInventaire=inventaire.getNbOuvrier();
        assertEquals(nbOuvriersTotal,nbTotaledansInventaire);

    }

    @Test
    void payement() {

        //TYPE DE CARTE3 :

        Cartebatiment carte = new Cartebatiment(2, 3, 3);
        Inventaire inventaire = new Inventaire();
        inventaire.setNbBois(10);
        inventaire.setNbArgile(10);
        inventaire.setNbPierre(10);
        inventaire.setNbOr(10);
        carte.payement(inventaire, 2);
        assertEquals(8, inventaire.getNbBois());
        assertEquals(6, inventaire.getNbPointTotal());


        inventaire.setNbPointTotal(0);
        inventaire.setNbBois(2);
        inventaire.setNbArgile(3);
        inventaire.setNbPierre(1);
        inventaire.setNbOr(10);

        Cartebatiment carte1 = new Cartebatiment(5,3,3);
        carte1.payement(inventaire, 7);
        assertEquals(0, inventaire.getNbBois());
        assertEquals(0, inventaire.getNbArgile());
        assertEquals(0, inventaire.getNbPierre());
        assertEquals(9, inventaire.getNbOr());
        assertEquals(29, inventaire.getNbPointTotal());

        inventaire.setNbPointTotal(0);
        inventaire.setNbBois(3);
        inventaire.setNbArgile(3);
        inventaire.setNbPierre(1);
        inventaire.setNbOr(10);


//TYPE DE CARTE 1
        Cartebatiment carte3 = new Cartebatiment(10, new ArrayList<Ressource>(Arrays.asList(Ressource.BOIS, Ressource.BOIS, Ressource.ARGILE)));
        inventaire.setNbPointTotal(0);
        inventaire.setNbBois(2);
        inventaire.setNbArgile(3);
        inventaire.setNbPierre(1);
        inventaire.setNbOr(10);
        carte3.payement(inventaire, 3);
        assertEquals(10, inventaire.getNbPointTotal());
        assertEquals(0, inventaire.getNbBois());
        assertEquals(2, inventaire.getNbArgile());

        inventaire.setNbPointTotal(0);
        inventaire.setNbBois(1);
        inventaire.setNbArgile(3);
        inventaire.setNbPierre(1);
        inventaire.setNbOr(10);
        carte3.payement(inventaire, 3);
        assertEquals(1, inventaire.getNbBois());
        assertEquals(3, inventaire.getNbArgile());


        inventaire.setNbPointTotal(0);
        inventaire.setNbBois(1);
        inventaire.setNbArgile(3);
        inventaire.setNbPierre(1);
        inventaire.setNbOr(10);
        carte3.payement(inventaire, 3);
        assertEquals(1, inventaire.getNbBois());
        assertEquals(3, inventaire.getNbArgile());


//TYPE DE CARTE 2 :
        inventaire.setNbPointTotal(0);
        inventaire.setNbBois(3);
        inventaire.setNbArgile(3);
        inventaire.setNbPierre(4);
        inventaire.setNbOr(10);
        Cartebatiment carte22 = new Cartebatiment(4, 4, 2);
        carte22.payement(inventaire, 5);
        assertEquals(2, inventaire.getNbBois());
        assertEquals(2, inventaire.getNbArgile());
        assertEquals(3, inventaire.getNbPierre());
        assertEquals(9, inventaire.getNbOr());
        assertEquals(18, inventaire.getNbPointTotal());


        inventaire.setNbPointTotal(0);
        inventaire.setNbBois(3);
        inventaire.setNbArgile(3);
        inventaire.setNbPierre(4);
        inventaire.setNbOr(10);
        Cartebatiment carte18 = new Cartebatiment(5, 4, 2);
        carte18.payement(inventaire, 5);
        assertEquals(2, inventaire.getNbBois());
        assertEquals(2, inventaire.getNbArgile());
        assertEquals(3, inventaire.getNbPierre());
        assertEquals(8, inventaire.getNbOr());
        assertEquals(24, inventaire.getNbPointTotal());

        Cartebatiment carte19 = new Cartebatiment(5, 3, 2);
        carte19.payement(inventaire, 5);
        assertEquals(2, inventaire.getNbBois());
        assertEquals(1, inventaire.getNbArgile());
        assertEquals(2, inventaire.getNbPierre());
        assertEquals(6, inventaire.getNbOr());
        assertEquals(45, inventaire.getNbPointTotal());


        inventaire.setNbPointTotal(0);
        inventaire.setNbBois(3);
        inventaire.setNbArgile(3);
        inventaire.setNbPierre(2);
        inventaire.setNbOr(1);
        carte19.payement(inventaire, 5);
        assertEquals(3, inventaire.getNbBois());
        assertEquals(2, inventaire.getNbArgile());
        assertEquals(0, inventaire.getNbPierre());
        assertEquals(0, inventaire.getNbOr());


        inventaire.setNbBois(3);
        inventaire.setNbArgile(2);
        inventaire.setNbPierre(1);
        inventaire.setNbOr(0);
        carte19.payement(inventaire, 5);
        assertEquals(2, inventaire.getNbBois());
        assertEquals(0, inventaire.getNbArgile());
        assertEquals(0, inventaire.getNbPierre());
        assertEquals(0, inventaire.getNbOr());


        Cartebatiment carte25 = new Cartebatiment(4, 1, 2);
        inventaire.setNbBois(10);
        inventaire.setNbArgile(10);
        inventaire.setNbPierre(10);
        inventaire.setNbOr(10);

        carte25.payement(inventaire, 4);
        assertEquals(10, inventaire.getNbBois());
        assertEquals(10, inventaire.getNbArgile());
        assertEquals(10, inventaire.getNbPierre());
        assertEquals(6, inventaire.getNbOr());


        inventaire.setNbBois(2);
        inventaire.setNbArgile(3);
        inventaire.setNbPierre(3);
        inventaire.setNbOr(3);
        carte25.payement(inventaire, 4);
        assertEquals(2, inventaire.getNbBois());
        assertEquals(3, inventaire.getNbArgile());
        assertEquals(3, inventaire.getNbPierre());
        assertEquals(3, inventaire.getNbOr());


        inventaire.setNbBois(4);
        inventaire.setNbArgile(3);
        inventaire.setNbPierre(3);
        inventaire.setNbOr(3);
        carte25.payement(inventaire, 4);
        assertEquals(0, inventaire.getNbBois());
        assertEquals(3, inventaire.getNbArgile());
        assertEquals(3, inventaire.getNbPierre());
        assertEquals(3, inventaire.getNbOr());

        inventaire.setNbBois(3);
        inventaire.setNbArgile(4);
        inventaire.setNbPierre(4);
        inventaire.setNbOr(4);

        carte25.payement(inventaire, 4);
        assertEquals(3, inventaire.getNbBois());
        assertEquals(4, inventaire.getNbArgile());
        assertEquals(4, inventaire.getNbPierre());
        assertEquals(0, inventaire.getNbOr());


    }
}






















