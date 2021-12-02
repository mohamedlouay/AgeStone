# Bilan des tests pour l'iteration 5

---
---
 ##  *Test avec Succés*
 
 * *Dans Inventaire*:
  * [x] calculPoint
    - Creation d'un objet inventaire, 
    - Rajout de 3 ressources dans l'inventaire,
    - Par defaut l'inventaire a 12 nourritures , or avec l'ajout de 3 bois avant on obtient 15 ressources → donc 15 points
    et le test sort avec succes!
    
  * [x] resetRessource
    - Cration d'objet inventaire, 
    - Creation de liste qui stocke les ressources de l'inventaire,
    - Appel de resetRessource qui prend en parametres (index du tableau qui correspond à la ressource , une valeur),
    - On s'attend à 3 et le test sort avec succes!
---
---
  * *Dans Joueur*:
  * [x] nourrir
    - Creation d'objet inventaire et Joueur,
    - le Joueur (IA) appel nourrir avec comme parametre (inventaire),
    - De base , l'inventaire contient 5 ouvriers et 12 nouritures → chaque ouvrier consomme 1 nourriture , on s'attend donc a n'avoir 
    plus que 7 nourritures et le test sort avec succes!
---
--- 
   * *Dans Zone*:
   
  * [x] placeOuvrierSurZone
    - Au debut 0 ouvrier est placé sur la zone → nb ouvriers sur zone =0 !
    - Notre test consiste a placer 5 ouvriers sur une Zone zone ,
    - zone appelle la methode placeOuvrierSurZone avec comme parametres (le nb ouvrier a placer , le numero du joueur qui place les ouvrier),
    - On s'attend  ce que le nb ouvriers sur zone =5 , et que le nb ouvrier du joueur 0 sur a zone=5.
    - Test avec succes !
    - On test ensuite avec d'autres valeurs et d'autres situations.
    
  * [x] retirerOuvrierSurZone
    - Au debut 3 ouvriers sont places sur la zone → nb ouvriers sur zone = 3 !
    - On cree un inventaire et une zone ,
    - La zone appelle placeOuvrierSurZone avec en parametre (3 ouvrier a placer , le joueur 0),
    - zone appelle retirerOuvrierSurZone avec en parametre (l'inventaire , le nb ouvrier a retirer, le numero du joueur),
    - Etant donné qu'on a placé 3 ouvriers et que le joueur 0 a retiré tout ses ouvrers sur la zone on s'attend 
     à ce qu'il ne reste plus d'ouvrier dans la zone pour le joueur 0, et on s'attend a ce que le nombre d'ouvriers total sur la zone =3.
    - test avec succe!
    
  * [x] gainZone
    - On cree une zone.
    - Le joueur 0 place 6 ouvriers sur la zone .
    - On crée un inventaire.
    - zone appelle gainZone.
    - On s'attend a ce que le nb d'or dans l'inventaire augemente .
    - Test avec succes !
   
      
      
    
    
   
   
  
  
  
