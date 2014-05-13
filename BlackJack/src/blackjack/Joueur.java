package blackjack;





public class Joueur extends Personne{

    //Attributs
    private int mise;
    private int argentTotal;
    private Main[] mainMultiple;
    private int indiceMainSup;

    //Constructeurs
    /**
     * 
     */
    public Joueur(){
        super();
        mise = 0;
        indiceMainSup = 0;
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
        indiceMainSup = 0;
    }
    
    /**
     * 
     * @param j 
     */
    public Joueur(Joueur j){
        super(j);
        mise = j.mise;
        argentTotal = j.argentTotal;
        indiceMainSup = j.indiceMainSup;
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

    public int getMise() {
        return mise;
    }
    
    public int getNbMainSup(){
        return indiceMainSup;
    }
    
    public void setIndiceMainSupZero(){
        indiceMainSup = 0;
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
    public void doubler(PaquetDeCartes paquet) {
        mise *= 2;
        tirer(paquet);
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
     * Permet au joueur de partager ses cartes en deux lorsqu'il possède un double dans sa main de base
     */
    public void partager() {
        Carte split = main.enleverCarte();
        mainMultiple[indiceMainSup] = new Main(mise);
        mainMultiple[indiceMainSup].ajouterCarte(split);
        indiceMainSup ++;
    }

}
