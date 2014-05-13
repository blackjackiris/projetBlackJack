/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;


public class Main {
    
    //Attributs
    private byte valeurMain;
    private byte nbCarteMain;
    private byte indiceMain;
    private int miseAttribuee;
    private Carte [] main;
    
    //Constructeur
    /**
     * 
     */
    public Main(){
        valeurMain = 0;
        nbCarteMain = 0;
        indiceMain = 0;
        miseAttribuee = 0;
        main = new Carte[10];
    }
    
    /**
     * Constructeurs
     * @param valeurMain
     * @param nbCarteMain
     */
    public Main(byte valeurMain, byte nbCarteMain, int miseAttribuee) {
        this.valeurMain = valeurMain;
        this.nbCarteMain = nbCarteMain;
        this.miseAttribuee = miseAttribuee;
    }

    public Main(int miseAttribuee) {
        this.miseAttribuee = miseAttribuee;
    }

    /**
     * Méthode pour calculer la valeur de la main entière
     * @return valMain
     */
    public byte getValeurMain(){

        byte cpt;
        byte valMain = 0;
        
        for(cpt=0; cpt<nbCarteMain; cpt++){
            valMain = (byte) (main[cpt].getValeur() + valMain);
        }
        
        return valMain;
    }
    
    /**
     * 
     * @param nouvelleCarte 
     */
    public void ajouterCarte(Carte nouvelleCarte){
        main[indiceMain]= nouvelleCarte;
        nbCarteMain ++;
        indiceMain ++;
    }
    
    public Carte enleverCarte(){
        Carte stkg = main[indiceMain];
        main[indiceMain] = new Carte();
        indiceMain --;
        return stkg;
    }
}


