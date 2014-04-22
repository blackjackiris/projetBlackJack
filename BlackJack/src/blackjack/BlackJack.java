/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author mlouaze
 */
public class BlackJack {

    final int blackJack = 21;
    boolean victoire;
    Joueur j;
    Donneur d;

    /**
     * Méthode détérmination du gagnant
     */
    public void Victoire() {

        // victoire du donneur
       // Si la valeur de la main du croupier = 21
        if ((d.mainDonneur.valeurMain) == blackJack) {

            victoire = false;
        }
        
          // victoire du donneur
        // Si la valeur de la main du croupier > celle du joueur
        if(j.mainJoueur.valeurMain < d.mainDonneur.valeurMain){
        
            
            victoire = false;
        }

         // victoire du donneur
        // Si la valeur de la main du croupier = celle du joueur
        if(j.mainJoueur.valeurMain == d.mainDonneur.valeurMain){
        
            
            victoire = false;
        }
        
        // victoire du joueur
        // Si la valeur de la main du joueur > celle du croupier
        if(j.mainJoueur.valeurMain > d.mainDonneur.valeurMain){
        
            
            victoire = true;
        }
    
 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    }

}
