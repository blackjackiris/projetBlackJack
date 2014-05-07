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
     * Constructeurs
     * @param valeurMain
     * @param nbCarteMain
     */
    public Main(byte valeurMain, byte nbCarteMain) {
        this.valeurMain = valeurMain;
        this.nbCarteMain = nbCarteMain;
    }

    public Main(){
        valeurMain = 0;
        nbCarteMain = 0;
        indiceMain = 0;
        main = new Carte[10];
    }

    /**
     * Méthode pour calculer la valeur de la main entière
     * @return valMain
     */
    public int calculerResultat() {

        int cpt;
        int valMain = 0;
        
        for (cpt=0; cpt<nbCarteMain; cpt++){
            valMain =  main[nbCarteMain].valeur + valMain;
        }
        
        return valMain;
    }
    
    public void ajoutCarte(){
//        nbCarteMain ++;
//        main[indiceMain] = ;
//                
//        indiceMain ++;
    }
}


