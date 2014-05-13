package blackjack;





public class Joueur extends Personne{

    //Attributs
    private int mise;
    private int argentTotal;

    public int getMise() {
        return mise;
    }
    

    //Constructeurs
    /**
     * 
     */
    public Joueur(){
        super();
        mise = 0;
        argentTotal = 1000;
    }
    
    /**
     * @param mise
     * @param argentTotal
     * @param mainJoueur
     */
    public Joueur(int mise, int argentTotal, Main mainJoueur) {
        super(mainJoueur);
        this.mise = mise;
        this.argentTotal = argentTotal;
    }
    
    /**
     * 
     * @param j 
     */
    public Joueur(Joueur j){
        super(j);
        mise = j.mise;
        argentTotal = j.argentTotal;
    }
    
    /**
     * Méthodes
     * Permet au joueur de miser
     */
    /**
     * getter pour le plateau
     * @return 
     */
    public int getArgentTotal() {
        return argentTotal;
    }

    public Main getMainJoueur() {
        return main;
    }

    
    
    public void miser() {
        argentTotal = argentTotal - mise;
    }

    /**
     * Permet au joueur de d'arreter de piocher
     * @param stay
     * @return 
     */
    public boolean rester(boolean stay) {
        stay = true;
        return stay;
    }

    /**
     * Permet au joueur de doubler ca mise lors de sa main de base mais le fait piocher une carte
     */
    public void doubler() {
        mise *= 2;
        tirer();
    }

    /**
     * Permet au joueur de prendre une assurance lorsque le donneur à un As visible dans sa main de base
     * @return 
     */
    public int assurance() {
        mise /= 2;
        return mise;
    }

     /**
     * Permet au joueur de partage ces cartes en deux lorsqu'il possède un double dans sa main de base
     */
    public void partager() {
        
    }

}
