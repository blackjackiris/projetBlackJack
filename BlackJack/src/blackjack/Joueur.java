package blackjack;





public class Joueur{
  
    //Attributs
    private int mise;
    private int argentTotal;
    public Main mainJoueur;

    
    /**
     * Constructeur
     * @param mise
     * @param argentTotal
     * @param mainJoueur
     */
    
    public Joueur(int mise, int argentTotal, Main mainJoueur) {
        this.mise = mise;
        this.argentTotal = argentTotal;
        this.mainJoueur = mainJoueur;
        
        
    }

    
    /**
    * Méthode
    * Permet au joueur de miser
    */
    public void miser() {
        
        
    }

    /**
     * Permet au joueur de tirer une carte
     */
    public void tirer() {
    mainJoueur.nbCarteMain ++;
    }

    /**
     * Permet au joueur de partage ces cartes en deux lorsqu'il possède un double dans sa main de base
     */
    public void partager() {
        
    }

    /**
     * Permet au joueur de d'arreter de piocher
     */
    public void rester() {
        
    }

    /**
     * Permet au joueur de doubler ca mise lors de sa main de base mais le fait piocher une carte
     */
    public void doubler() {
    }

    /**
     * Permet au joueur de prendre une assurance lorsque le donneur à un As visible dans sa main de base
     */
    public void assurance() {
    }

}
