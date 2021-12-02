package stoneage.plateaudejeu.zones;

import org.junit.jupiter.api.Test;
import stoneage.joueur.Joueur;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.zones.ZoneVillage;

import static org.junit.jupiter.api.Assertions.*;

class ZoneVillageTest {

    @Test
    void gainZone() {
        ZoneVillage hutte = new ZoneVillage(0,2,2);
        ZoneVillage fabrique = new ZoneVillage(0,1,1);

        Inventaire inventaire = new Inventaire();
        Joueur IA = new Joueur();

        for (int i = 0; i < 6; i++) {
            hutte.gainZone(inventaire,0,IA);
        }
        for (int i = 0; i < 20; i++) {
            fabrique.gainZone(inventaire,0,IA);
        }

        assertEquals(10, inventaire.getNbOuvrierTotal());
        assertEquals(3, inventaire.getOutils().size());
        assertEquals(12, inventaire.getNbOutils());

    }
}