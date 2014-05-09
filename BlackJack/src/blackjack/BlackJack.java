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

    //Attributs
    private final byte BLACKJACK = 21;
    private boolean victoire;
    private Joueur j;
    private Donneur d;
    public static PaquetDeCartes jeuDeCartes;
    
    //Constructeur
    public BlackJack(){
        j = new Joueur();
        d = new Donneur();
        jeuDeCartes = new PaquetDeCartes();
    }

    /**
     * Méthode détérmination du gagnant
     */
    public void victoire() {

        // victoire du donneur
        // Si la valeur de la main du croupier = 21
        if ((d.mainDonneur.getValeurMain()) == BLACKJACK) {

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
        
        BlackJack partie = new BlackJack();
        
        
    }

}
