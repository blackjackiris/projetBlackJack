/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;


public class Carte {

    
    private byte valeur;
    private byte couleur;
    private int idCarte;
    
       
    /**
     * Constructeur
     * @param valeur
     * @param couleur
     * @param idCarte 
     */
    public Carte(byte valeur, byte couleur, int idCarte) {
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
    
   
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
