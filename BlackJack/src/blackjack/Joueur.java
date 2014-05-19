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
     * @return argentTotal
     */
    public int getArgentTotal() {
        return argentTotal;
    }

    public Main getMainJoueur() {
        return main;
    }
    
    public Main getMainJoueurSupp(byte nroMain){
        nroMain --;
        return mainMultiple[nroMain];
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
    
    public int miser(int miseJ, byte nroMain) {
        argentTotal = argentTotal - miseJ;
        if(nroMain == 0){
            main.setMiseAttribuee(miseJ);
        }
        else{
            mainMultiple[nroMain].setMiseAttribuee(miseJ);
        }
        
        return miseJ;
    }
    
    public void argentGagne(int argent){
        argentTotal = argentTotal + argent;
    }
    
    public void tirer(PaquetDeCartes paquet, byte nroMain){
        
        Carte stkg;
        
        if(nroMain == 0){
            super.tirer(paquet);
        }
        else{
            stkg = paquet.piocherCarte();
            mainMultiple[nroMain - 1].ajouterCarte(stkg);
        }
    }

    /**
     * Permet au joueur de d'arreter de piocher
     * @param stay
     * @return stay
     */
    public boolean rester(boolean stay) {
        stay = true;
        return stay;
    }

    /**
     * Permet au joueur de doubler ca mise lors de sa main de base mais le fait piocher une carte
     * @param paquet
     * @param miseJ
     * @param nroMain
     */
    public int doubler(PaquetDeCartes paquet, byte nroMain, int miseJ){
        miser(miseJ, nroMain);
        tirer(paquet, nroMain);
        return miseJ;
    }

    /**
     * Permet au joueur de prendre une assurance lorsque le donneur à un As visible dans sa main de base
     * @return mise
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
