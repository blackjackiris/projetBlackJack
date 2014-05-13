package blackjack;





public class Joueur{

    //Attributs
    private  int mise;
    private int argentTotal;
    private Main mainJoueur;

    //Constructeurs
    /**
     * 
     */
    public Joueur(){
        mise = 0;
        argentTotal = 1000;
        mainJoueur = new Main();
    }
    
    /**
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
        return mainJoueur;
    }

    
    
    public void miser() {
        argentTotal = argentTotal - mise;
    }

    /**
     * Permet au joueur de tirer une carte
     */
    public void tirerUneCarte() {
        mainJoueur.tirerCarte();
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
