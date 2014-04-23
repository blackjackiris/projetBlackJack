/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;


public class Carte{

    //Attributs
    private byte valeur;
    private byte couleur;
    private String idCarte;
    
       
    /**
     * Constructeur
     * @param valeur
     * @param couleur
     * @param idCarte 
     */
    public Carte(byte valeur, byte couleur, String idCarte) {
        this.valeur = valeur;
        this.couleur = couleur;
        this.idCarte = idCarte;
    }

    /**
     * 
     * @param c
     */    
    public Carte(Carte c) {
        this.valeur = c.valeur;
        this.couleur = c.couleur;
        this.idCarte = c.idCarte;       
    }  
    
    //Méthodes
    
    /**
     * 
     */
    //Affichage de l'id d'une carte, méthode de test uniquement, inutile pour le programme final
    public void afficherIdCarte(){
        System.out.println(idCarte);
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
