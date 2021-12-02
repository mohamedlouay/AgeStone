package stoneage.plateaudejeu;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void nbOuvrierDispoTotal() {
        Plateau plateau = new Plateau(2);
        int ouvrierDiso = plateau.nbOuvrierDispoTotal(plateau.getListeInventaire());


        assertEquals(10,ouvrierDiso);

        plateau.getListeInventaire().get(0).setNbOuvrier(2);
        ouvrierDiso = plateau.nbOuvrierDispoTotal(plateau.getListeInventaire());
        assertEquals(7, ouvrierDiso);

        plateau.getListeInventaire().get(1).setNbOuvrier(2);
        ouvrierDiso = plateau.nbOuvrierDispoTotal(plateau.getListeInventaire());
        assertEquals(4, ouvrierDiso);

        plateau.getListeInventaire().get(0).setNbOuvrier(0);
        ouvrierDiso = plateau.nbOuvrierDispoTotal(plateau.getListeInventaire());
        assertEquals(2, ouvrierDiso);

        plateau.getListeInventaire().get(1).setNbOuvrier(0);
        ouvrierDiso = plateau.nbOuvrierDispoTotal(plateau.getListeInventaire());
        assertEquals(0, ouvrierDiso);


    }
}