

package blackjack;




public class Donneur extends Personne{
    
    /**
     * Constructeurs par default
     */
    public Donneur(){
        super();
    }
    
    /**
     * Constructeurs
     * @param mainDonneur 
     */
    public Donneur(Main mainDonneur) {
        super(mainDonneur);
    }
    
    /**
     * Constructeurs
     * @param d
     */
    public Donneur(Donneur d){
        super(d);
    }
    
    //Methode
    public Main getMainDonneur() {
        return main;
    }
    
  
   /**
   * Intelligence artificielle du donneur
     * @param paquet
   */
    
  

}