package stoneage.plateaudejeu;

import org.junit.jupiter.api.Test;
import stoneage.plateaudejeu.Inventaire;

import static org.junit.jupiter.api.Assertions.*;

class InventaireTest {

    @Test
    void calculPoint() {
        Inventaire inventaire = new Inventaire();
        inventaire.setNbBois(3);

        assertEquals(15, inventaire.calculPoint());
    }

    @Test
    void restRessource(){

        Inventaire inventaire = new Inventaire();
        int[] tab = new int[4];
        tab[0] = inventaire.getNbBois();
        tab[1] = inventaire.getNbArgile();
        tab[2] = inventaire.getNbPierre();
        tab[3] = inventaire.getNbOr();
        inventaire.restRessource(0,3);

        assertEquals(3, inventaire.getNbBois());
    }
}