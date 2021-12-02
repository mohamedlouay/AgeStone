package stoneage.plateaudejeu.cartes;

import stoneage.partie.Partie;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Plateau;
import stoneage.plateaudejeu.Ressource;

import java.util.Random;

import java.util.ArrayList;
import java.util.Collections;

public class CarteCivilisation {

	static Random rand = new Random();


	

	private Ressource ressourceCarte;
	private int nbRessourceCarte;
	private Couleur couleur;
	private boolean PlaceReserver = false;
	private boolean avec_jet_de = false;
	private PartieInferieure inf;
	private int coefficient;
    public enum Couleur {
		VERTE, SABLE;
	}
    
    
    /*5 constructeurs : 
     * selon le fond de la carte  verte ou jaune (il existe un coefficient pour le jaune ) 
     *  selon le gain (par jet de dé ou pas )
    * pour une carte sans partie Supérieure*/
    
    
	CarteCivilisation(int nbRessourceCarte, Couleur couleur, Ressource ressourceCarte, PartieInferieure inf, int coefficient) {
		this.nbRessourceCarte = nbRessourceCarte;
		this.couleur = couleur;
		this.ressourceCarte = ressourceCarte;
		this.PlaceReserver = false;
		this.inf = inf;
		this.coefficient = coefficient;
	}
	CarteCivilisation(int nbRessourceCarte, Couleur couleur, Ressource ressourceCarte, PartieInferieure inf) {
		this.nbRessourceCarte = nbRessourceCarte;
		this.couleur = couleur;
		this.ressourceCarte = ressourceCarte;
		this.PlaceReserver = false;
		this.inf = inf;
	}
	CarteCivilisation(Couleur couleur, Ressource ressourceCarte, boolean jetDe, PartieInferieure inf, int coefficient) {
		this.couleur = couleur;
		this.ressourceCarte = ressourceCarte;
		this.PlaceReserver = false;
		this.avec_jet_de = jetDe;
		this.inf = inf;
		this.coefficient = coefficient;
	}
	CarteCivilisation(Couleur couleur, Ressource ressourceCarte, boolean jetDe, PartieInferieure inf) {
		this.couleur = couleur;
		this.ressourceCarte = ressourceCarte;
		this.PlaceReserver = false;
		this.avec_jet_de = jetDe;
		this.inf = inf;

	}
	CarteCivilisation(Couleur couleur, Ressource ressourceCarte, PartieInferieure inf) {
		this.couleur = couleur;
		this.ressourceCarte = ressourceCarte;
		this.PlaceReserver = false;
		this.inf = inf;

	}

	//setter
	public void setInf(int coefficient) {
		this.coefficient = coefficient;
	}
	public void setInf(PartieInferieure inf) {
		this.inf = inf;
	}
	public void setNbRessourceCarte(int nbRessourceCarte) {
		this.nbRessourceCarte = nbRessourceCarte;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public void setPlaceReservee(boolean placeReservee) {
		this.PlaceReserver = placeReservee;
	}

	public void setressourceCarte(Ressource ressourceCarte) {
		this.ressourceCarte = ressourceCarte;
	}

	//getter

	public int getCoefficient() {
		return this.coefficient;

	}
	public PartieInferieure getInf() {
		return inf;
	}
	public int getNbRessourceCarte() {
		return this.nbRessourceCarte;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	public Ressource getressourceCarte() {
		return this.ressourceCarte;
	}
	public boolean isPlaceReservee() {
		return this.PlaceReserver;
	}

	//methode de classe :

	/**
	 * placer un ouvrier sur une carte

	 */

	public void placeOuvrierSurCarte(Inventaire inventaireJoueur) {

		inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() - 1);
		setPlaceReservee(true);
	}

	/**
	 *
	 *retirer un ouvrier de carte
	 */
	public void retirerOuvrierSurCarte( Inventaire inventaireJoueur) {
		inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + 1);
		this.PlaceReserver = false;

	}

	public String toString() {

		return " ressourceCarte " + this.ressourceCarte + " couleur " + this.couleur + "nbressource " + this.nbRessourceCarte;
	}

	/**
	 * méthode qui permet de verifier si le joueur  posséde les ressources suffisantes pour acheter une carte .
	 * cette methode est utilisée dans la methode recupererCarte .elle retourne un boolean
	 * @param inventaireJoueur
	 */
	public boolean payement(Inventaire inventaireJoueur, int positionCards) {
		int somme = inventaireJoueur.getNbRessourceTotal();
		int prix = positionCards + 1; // le tableau commence de 0 donc le prix est tjrs egale position de la carte + 1
		int[] tab = new int[4];
		tab[0] = inventaireJoueur.getNbBois();
		tab[1] = inventaireJoueur.getNbArgile();
		tab[2] = inventaireJoueur.getNbPierre();
		tab[3] = inventaireJoueur.getNbOr();

		if (somme<prix) {
			return false;
		}

		if (somme == prix) {
			for (int i = 0; i<tab.length; i++) {
				tab[i] = 0;
			}

			inventaireJoueur.setNbBois(tab[0]);
			inventaireJoueur.setNbArgile(tab[1]);
			inventaireJoueur.setNbPierre(tab[2]);
			inventaireJoueur.setNbOr(tab[3]);
			return true;
		}

		if (somme > prix) {
			int i = 0;
			int difference = somme - prix;

			while (somme > difference) {
				if (tab[i] > 0) {
					tab[i] -= 1;
					somme -= 1;

				} else {
					i = i + 1;

				}

			}

			inventaireJoueur.setNbBois(tab[0]);
			inventaireJoueur.setNbArgile(tab[1]);
			inventaireJoueur.setNbPierre(tab[2]);
			inventaireJoueur.setNbOr(tab[3]);
			return true;
		}
		return true;

	}

	
	
	/*
	 * une methode qui permet le joueur  de recuperer une carte sinon retirer son ouvrier le cas contraire
	 * 
	 * */
	
	
	public void recupererCarte(Inventaire i, int positionCards, Plateau p) {

		if (payement(i, positionCards) == true)

		{
			retirerOuvrierSurCarte(i);
			i.addCarteToStockCards(this);

			gainCarte(i, p);

			p.getCards().remove(positionCards);

		} else {

			retirerOuvrierSurCarte(i);

		}
	}
	
	
	
	/*methode qui permet de recuperer le gain d'une carte civilisation selon le type de ressource qui 'elle contient */

	void gainCarte(Inventaire i, Plateau p) {

		Ressource r = this.getressourceCarte();

		switch (r) {
			case OR:
				if (this.avec_jet_de) {
					this.ressource_avec_jet_de(i, r);
				} else {
					i.setNbOr(i.getNbOr()+this.nbRessourceCarte);
				}
				break;
			case NOURRITURE:
				i.setNbNourriture(i.getNbNourriture()+this.nbRessourceCarte);
				break;
			case ARGILE:
				i.setNbArgile(i.getNbArgile()+this.nbRessourceCarte);
				break;
			case BOIS:
				if (this.avec_jet_de) {
					this.ressource_avec_jet_de(i, r);
				} else {
					i.setNbBois(i.getNbBois()+this.nbRessourceCarte);
				}

				break;
			case PIERRE:
				if (this.avec_jet_de) {
					this.ressource_avec_jet_de(i, r);
				} else {
					i.setNbPierre(i.getNbPierre()+this.nbRessourceCarte);

				}
				break;
			case POINT:
				i.setNbPointTotal(i.getNbPointTotal()+this.nbRessourceCarte);
				break;
			case OUTIL:
				i.setNbOutils(i.getNbOutils()+this.nbRessourceCarte);
				break;
			case MULTI:

				this.multiRessource(i, p);

				break;
			case AGRICULTURE:
				i.setNiveauAgriculture(i.getNiveauAgriculture()+this.nbRessourceCarte);
				break;
			case RESSOURCE_AU_CHOIX:

				this.ressource_au_choix(i);
				break;
			case OUTIL_USAGE_UNIQUE:

				i.addOutilUsageUnique(this.getNbRessourceCarte());
				break;

			case AUCUNE:

				break;

		}

	}
	
	
	
	/*methode utilise dans la methode gainCarte pour calculer le gain de la carte de type multiRessource */

	private void multiRessource(Inventaire i, Plateau p) {
		ArrayList<Inventaire> listeInventaire = p.getListeInventaire();

		int size = listeInventaire.size();

		int indexOfInventaire = listeInventaire.indexOf(i);

		for (int k = 0; k<size; k++) {

			int a = rand.nextInt(6) ;

			int[] tab = new int[6];
			tab[0] = listeInventaire.get(indexOfInventaire).getNbBois();
			tab[1] = listeInventaire.get(indexOfInventaire).getNbArgile();
			tab[2] = listeInventaire.get(indexOfInventaire).getNbPierre();
			tab[3] = listeInventaire.get(indexOfInventaire).getNbOr();
			tab[4] = listeInventaire.get(indexOfInventaire).getNbOutils();
			tab[5] = listeInventaire.get(indexOfInventaire).getNiveauAgriculture();

			tab[a] += 1; //on ajoute plus 1  a la ressource choisi par le joueur . on suppose que chaque joueur faire le jet de de et choisir directement la ressource

			listeInventaire.get(indexOfInventaire).setNbBois(tab[0]);
			listeInventaire.get(indexOfInventaire).setNbArgile(tab[1]);
			listeInventaire.get(indexOfInventaire).setNbPierre(tab[2]);
			listeInventaire.get(indexOfInventaire).setNbOr(tab[3]);
			listeInventaire.get(indexOfInventaire).setNbOutils(tab[4]);
			listeInventaire.get(indexOfInventaire).setNiveauAgriculture(tab[5]);

			//le tour pass a le joueur suivant 

			indexOfInventaire = (indexOfInventaire + 1) % size;

		}

	}
	
	
	/*methode utilise dans la methode gainCarte pour calculer le gain de la carte qui nécessite un jet de de */

	private void ressource_avec_jet_de(Inventaire i, Ressource r) {
		/*
		 * cette méthode utilisée dans la méthode gain Carte .elle permet le joueur  de gagner des ressources selon le jet de et le type de ressource fournie par la carte		 * on a supposé que  le joueur va gagner immediatement ces deux ressources pour simplifier le travail.
		 * 
		 * */

		int resultat = rand.nextInt(12) + 1;

		if (r == Ressource.OR) {
			i.setNbOr(i.getNbOr()+(resultat / 6));
		} else if (r == Ressource.PIERRE) {
			i.setNbPierre(i.getNbPierre()+(resultat / 5));
		} else if (r == Ressource.BOIS) {
			i.setNbBois(i.getNbBois()+(resultat / 3));
		}

	}

	
	/*
	 * cette methode utilisée dans la methode gainCarte .elle permet le joueur  de gagner ,immédiatement ou plus tard ,deux ressources au choix (identiques ou differentes)
	 * on a supposé que  le joueur va gagner immediatement ces deux ressources pour simplifier le travail.
	 * on a récupéré les ressources de l'inventaire dans un tableau . et à chaque fois on joute 1 à une ressource choisi par hasard 
	 */
	public void ressource_au_choix(Inventaire i) {
		

		int[] tab = new int[4];
		tab[0] = i.getNbBois();
		tab[1] = i.getNbArgile();
		tab[2] = i.getNbPierre();
		tab[3] = i.getNbOr();

		int index = rand.nextInt(4);

		tab[index] += 1;
		index = rand.nextInt(4);
		tab[index] += 1;

		i.setNbBois(tab[0]);
		i.setNbArgile(tab[1]);
		i.setNbPierre(tab[2]);
		i.setNbOr(tab[3]);

	}

	
	/*methode utiliser dans methode ressource_avec_jet_de */
	public int de() {

		int nbJoueur = Partie.getNbJoueur();
		int resultat = 0;

		for (int i = 0; i<nbJoueur; i++) {
			resultat += rand.nextInt(6) + 1;
		}
		return resultat;

	}

	
	/*methode qui calcule le score finale pour les cartes qui sont gagné par chaque joueur  */

	public static int decompteFinal(Inventaire i, ArrayList<CarteCivilisation> cards) {

		ArrayList<CarteCivilisation> stockCardsSable = new ArrayList<CarteCivilisation> ();
		ArrayList<CarteCivilisation> stockCardsGreen = new ArrayList<CarteCivilisation> ();

		int score = 0;

		for (CarteCivilisation carte: cards) {
			if (carte.couleur == Couleur.VERTE) {
				stockCardsGreen.add(carte);
			} else {

				stockCardsSable.add(carte);

			}

		}

		score = decompteFinalSableCards(i, stockCardsSable);
		score += decompteFinalGreenCards(i, stockCardsGreen);

		return score;
	}
	
	
	/*methode qui calcule le score finale pour les cartes qui ont un fond Sable gagné par chaque joueur  
	 * 	 * cette methode est utilisée dans la methode decompteFinal */


	public static int decompteFinalSableCards(Inventaire i, ArrayList<CarteCivilisation> stockCardsSable) {
		int score = 0;
		int[] tab = new int[4];
		//  |paysants |fabricants | constructeur | chamanes|

		tab[0] = find2(stockCardsSable, PartieInferieure.PAYSANT);
		tab[1] = find2(stockCardsSable, PartieInferieure.FABRICANT);
		tab[2] = find2(stockCardsSable, PartieInferieure.CONSTRUCTEUR);
		tab[3] = find2(stockCardsSable, PartieInferieure.CHAMANE);

		score = tab[0] * i.getNiveauAgriculture() + tab[1] * i.getNbOutils() + tab[2] * i.getNbCartesBatiments() + tab[3] * i.getNbOuvrierTotal();

		return score;
	}
	
	
	
	
	/*methode qui calcule le score finale pour les cartes qui ont un fond verte gagné par chaque joueur 
	 * cette methode est utilisée dans la methode decompteFinal */

	public static int decompteFinalGreenCards(Inventaire i, ArrayList<CarteCivilisation> stockCardsGreen)

	{
		int score = 0;
		int cpt = 0;

		int[] tab = new int[8];
		//  |medecine | art|ecriture|poterie|cadran salaire | transport | musique | tissage |  

		tab[0] = find(stockCardsGreen, PartieInferieure.MEDECINE);
		tab[1] = find(stockCardsGreen, PartieInferieure.ART);
		tab[2] = find(stockCardsGreen, PartieInferieure.ECRITURE);
		tab[3] = find(stockCardsGreen, PartieInferieure.POTERIE);
		tab[4] = find(stockCardsGreen, PartieInferieure.CADRAN_SALAIRE);
		tab[5] = find(stockCardsGreen, PartieInferieure.TRANSPORT);
		tab[6] = find(stockCardsGreen, PartieInferieure.MUSIQUE);
		tab[7] = find(stockCardsGreen, PartieInferieure.TISSAGE);

		for (int n: tab) {

			if (n > 0) {
				cpt++;
			}
		}

		score = cpt * cpt;

		for (int n: tab) {
			if (n > 1) {
				score += n - 1;
			}

		}

		return score;
	}

	
	
	
	/*methode utilise dans la methode decompteFinalGreenCards pour calculer le score final de joueur 
	 * cette methode est utilisée dans le calcule du score finale pour les cartes qui ont un fond Verte */
	
	public static int find(ArrayList<CarteCivilisation> stockCardsGreen, PartieInferieure f) {
		int occ = 0;
		
		for (CarteCivilisation carte: stockCardsGreen) {
			if (carte.getInf() == f) {
				occ++;
			}
		}
		return occ;
	}
	
	
	
	
	/*methode utilise dans la methode decompteFinalSableCards pour calculer le score final de joueur 
	 * cette methode est utilisée dans le calcule du score finale pour les cartes qui ont un fond Sable */
	public static int find2(ArrayList<CarteCivilisation> stockCardsGreen, PartieInferieure f) {
		int occ = 0;
		
		for (CarteCivilisation carte: stockCardsGreen) {
			if (carte.getInf() == f) {
				occ += carte.getCoefficient();
			}
		}
		return occ;
	}
	
	
	/* methode static qui permet de creer l'ensemble des cartes de civilisations pour les  différents types de carte*/
	public static ArrayList<CarteCivilisation> CreationCarte() {

		 ArrayList<CarteCivilisation> cards = new ArrayList<CarteCivilisation> ();

		//5 cartes ressources 
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.PIERRE, PartieInferieure.CHAMANE, 1));
		cards.add(new CarteCivilisation(2, Couleur.VERTE, Ressource.PIERRE, PartieInferieure.TRANSPORT));
		cards.add(new CarteCivilisation(1, Couleur.SABLE, Ressource.ARGILE, PartieInferieure.CHAMANE, 2));
		cards.add(new CarteCivilisation(1, Couleur.SABLE, Ressource.PIERRE, PartieInferieure.PAYSANT, 1));
		cards.add(new CarteCivilisation(1, Couleur.SABLE, Ressource.OR, PartieInferieure.CHAMANE, 1));

		// 7 cartes nourritures 
		cards.add(new CarteCivilisation(3, Couleur.SABLE, Ressource.NOURRITURE, PartieInferieure.PAYSANT, 2));
		cards.add(new CarteCivilisation(4, Couleur.SABLE, Ressource.NOURRITURE, PartieInferieure.CONSTRUCTEUR, 1));
		cards.add(new CarteCivilisation(3, Couleur.VERTE, Ressource.NOURRITURE, PartieInferieure.TISSAGE));
		cards.add(new CarteCivilisation(7, Couleur.VERTE, Ressource.NOURRITURE, PartieInferieure.POTERIE));
		cards.add(new CarteCivilisation(2, Couleur.SABLE, Ressource.NOURRITURE, PartieInferieure.CONSTRUCTEUR, 2));
		cards.add(new CarteCivilisation(5, Couleur.VERTE, Ressource.NOURRITURE, PartieInferieure.MEDECINE));
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.NOURRITURE, PartieInferieure.TISSAGE));

		//3 cartes point de victoire 
		cards.add(new CarteCivilisation(3, Couleur.VERTE, Ressource.POINT, PartieInferieure.MEDECINE));
		cards.add(new CarteCivilisation(3, Couleur.VERTE, Ressource.POINT, PartieInferieure.MEDECINE));
		cards.add(new CarteCivilisation(3, Couleur.SABLE, Ressource.POINT, PartieInferieure.CONSTRUCTEUR, 3));

		//2 cartes agriculture 
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.AGRICULTURE, PartieInferieure.CADRAN_SALAIRE));
		cards.add(new CarteCivilisation(1, Couleur.SABLE, Ressource.AGRICULTURE, PartieInferieure.PAYSANT, 1));

		// 1 carte tuile outil 
		cards.add(new CarteCivilisation(1, Couleur.VERTE, Ressource.OUTIL, PartieInferieure.ART));

		// 1 carte ressource au choix
		cards.add(new CarteCivilisation(2, Couleur.VERTE, Ressource.RESSOURCE_AU_CHOIX, PartieInferieure.MEDECINE));

		// 1 carte pour le calcul  du score 
		cards.add(new CarteCivilisation(0, Couleur.VERTE, Ressource.AGRICULTURE, PartieInferieure.ECRITURE)); //cette carte pour le calcul de score final donc lapartie superieure n' a pas d'effet (voir description cartes de civilisations )

		//3 cartes Ressources avec jet de dés 
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.OR, true, PartieInferieure.ART));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.PIERRE, true, PartieInferieure.CHAMANE, 1));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.BOIS, true, PartieInferieure.CHAMANE, 2));

		// 10 cartes  jet de dés
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.MULTI, true, PartieInferieure.MEDECINE));
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.MULTI, true, PartieInferieure.ECRITURE));
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.MULTI, true, PartieInferieure.TRANSPORT));
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.MULTI, true, PartieInferieure.POTERIE));
		cards.add(new CarteCivilisation(Couleur.VERTE, Ressource.MULTI, true, PartieInferieure.POTERIE));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.MULTI, true, PartieInferieure.CONSTRUCTEUR, 1));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.MULTI, true, PartieInferieure.PAYSANT, 2));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.MULTI, true, PartieInferieure.PAYSANT, 1));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.MULTI, true, PartieInferieure.FABRICANT, 2));
		cards.add(new CarteCivilisation(Couleur.SABLE, Ressource.MULTI, true, PartieInferieure.FABRICANT, 2));

		// 3 cartes   "outils a usage unique "
		cards.add(new CarteCivilisation(4, Couleur.SABLE, Ressource.OUTIL_USAGE_UNIQUE, PartieInferieure.FABRICANT, 1));
		cards.add(new CarteCivilisation(3, Couleur.SABLE, Ressource.OUTIL_USAGE_UNIQUE, PartieInferieure.FABRICANT, 1));
		cards.add(new CarteCivilisation(2, Couleur.SABLE, Ressource.OUTIL_USAGE_UNIQUE, PartieInferieure.FABRICANT, 2));

		Collections.shuffle(cards); // pour mélanger les cartes de façon aléatoire
		return cards;
	}

}