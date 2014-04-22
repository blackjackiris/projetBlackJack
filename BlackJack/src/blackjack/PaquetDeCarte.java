
package blackjack;



public class PaquetDeCarte {
 
    public int nbCarte;
    Carte [ ] paquet;
    
    /**
     * 
     */
    public PaquetDeCarte(){
        
        paquet = new Carte[52];
        byte indice1, indice2;
        byte nbCarte = 0;
        
        for(indice1 = 0; indice1 < 4; indice1 ++){
            
            for(indice2 = 0; indice2 < 14; indice2 ++){
                paquet[nbCarte] = new Carte(indice2, indice1, "" + indice1 + "" + indice2);
                nbCarte ++;
            }
        } 
    }  
    

    /**
     * Constructeur
     * @param nbCarte 
     */
    public PaquetDeCarte(int nbCarte) {
        this.nbCarte = nbCarte;
    }

    public PaquetDeCarte(PaquetDeCarte pcarte){
        
        this.nbCarte = pcarte.nbCarte;        
        
    }
        
    
    
    
/**
 * Utilisation du random lorsqu'une carte est tirer du paquet
 */
    public void melanger() {
        
    }

}
