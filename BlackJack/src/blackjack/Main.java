/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;


public class Main {
 
    private byte valeurMain;
    private byte nbCarteMain;
    private byte indiceMain;
    private Carte [] main;
    
    /**
     * 
     */
    public Main(){
        valeurMain = 0;
        nbCarteMain = 0;
        indiceMain = 0;
        main = new Carte[10];
    }
    
    /**
     * Constructeurs
     * @param valeurMain
     * @param nbCarteMain
     */
    public Main(byte valeurMain, byte nbCarteMain) {
        this.valeurMain = valeurMain;
        this.nbCarteMain = nbCarteMain;
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
    
    public void tirerCarte(){
    //    main[indiceMain] = BlackJack.jeuDeCartes.piocherCarte();
        nbCarteMain ++;
        indiceMain ++;
    }
}


