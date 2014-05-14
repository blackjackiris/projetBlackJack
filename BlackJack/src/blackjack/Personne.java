/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;

/**
 *
 * @author croux
 */
public class Personne {
    
    //Attribut
    protected Main main;
    
    //Constructeurs
    /**
     * 
     */
    public Personne(){
        main = new Main();
    }
    
    public Personne(Main m){
        main = m;
    }
    
    /**
     * 
     * @param p 
     */
    public Personne(Personne p){
        this.main = p.main;
    }
    
    //Methode
    public void tirer(PaquetDeCartes paquet) {
      Carte stkg = paquet.piocherCarte();
      main.ajouterCarte(stkg);
    }
}
