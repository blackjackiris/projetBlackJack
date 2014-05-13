

package blackjack;




public class Donneur extends Personne{

    //Constructeurs
    
    
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
   */
    
    public void jeuCroupier() {
        
        byte val;
        
        do{
            tirer();
            val = main.getValeurMain();
        }while(val < 17);
    }

}