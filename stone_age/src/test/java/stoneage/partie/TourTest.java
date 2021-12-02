package stoneage.partie;

import org.junit.jupiter.api.Test;
import stoneage.partie.Tour;
import stoneage.plateaudejeu.Plateau;

import static org.junit.jupiter.api.Assertions.*;

class TourTest {

    @Test
    void placementPhase() {
        Plateau plateau = new Plateau(2);
        Tour tour = new Tour(plateau);

        tour.placementPhase();

        assertTrue(plateau.getListeInventaire().get(0).getNbOuvrier()==0);
        //assertTrue(plateau.nbOuvrierDispoTotal(plateau.getListeInventaire())==0);
    }

    /*@Test
    void recuperationPhase() {
        Plateau plateau = new Plateau(2);
        Tour tour = new Tour(plateau);

        tour.placementPhase();
        tour.recuperationPhase();

        assertTrue(plateau.getListeInventaire().get(0).getNbOuvrier()>=5);

    }*/

    @Test
    void phaseNourrir() {
        Plateau plateau = new Plateau(2);
        Tour tour = new Tour(plateau);

        tour.phaseNourrir();

        assertEquals(7, plateau.getListeInventaire().get(0).getNbNourriture());
        assertEquals(7, plateau.getListeInventaire().get(1).getNbNourriture());

        plateau.getListeInventaire().get(0).setNbNourriture(0);
        tour.phaseNourrir();

        assertEquals(0, plateau.getListeInventaire().get(0).getNbPointTotal());

    }

    @Test
    void resetOutils() {
        Plateau plateau = new Plateau(2);
        Tour tour = new Tour(plateau);

        for (int i = 0; i < 4; i++) {
            if (plateau.getListeInventaire().get(0).getOutilsDispo().size()<3) {
                plateau.getListeInventaire().get(0).getOutilsDispo().add(1);
            }
            else {
                plateau.getListeInventaire().get(0).getOutilsDispo().set(0,plateau.getListeInventaire().get(0).getOutilsDispo().get(0)+1);
            }
        }

        assertEquals(4, plateau.getListeInventaire().get(0).getOutilsDispo().get(0));
        assertEquals(3, plateau.getListeInventaire().get(0).getOutilsDispo().size());

        tour.resetOutils(0);
        assertEquals(3, plateau.getListeInventaire().get(0).getOutilsDispo().size());



    }

    @Test
    void updateStatutZone() {
        Plateau plateau = new Plateau(2);
        Tour tour = new Tour(plateau);

        plateau.getZonesDispo().get(0).placeOuvrierSurZone(7,0);

        tour.updateStatutZone();

        assertEquals(1, plateau.getZonesPleines().size());
        assertEquals(7, plateau.getZonesDispo().size());
    }


    @Test
    void resetZone() {
        Plateau plateau = new Plateau(2);
        Tour tour = new Tour(plateau);

        plateau.getZonesDispo().get(0).placeOuvrierSurZone(7,0);

        tour.updateStatutZone();
        tour.resetZone();

        assertEquals(0, plateau.getZonesPleines().size());
        assertEquals(8, plateau.getZonesDispo().size());
    }
}