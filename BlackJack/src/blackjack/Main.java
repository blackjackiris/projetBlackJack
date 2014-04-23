/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;


public class Main {
 
    public int valeurMain = 0;

    int nbCarteMain=0;

    Carte [ ] main = new Carte[10];
    
    /**
     * Constructeurs
     * @param valeurMain
     * @param nbCarteMain
     */
    public Main(int valeurMain,int nbCarteMain) {
        this.valeurMain = valeurMain;
        this.nbCarteMain = nbCarteMain;
    }

    

/**
 * Méthode pour calculer la valeur de la main entière
 * @return valeurMain
 */
    private int calculerResultat() {

        int cpt;
   
        
        for (cpt=0;cpt<nbCarteMain;cpt++){
        
        valeurMain =  main[nbCarteMain].valeur + valeurMain;
        
        }
        
        
            return valeurMain;
        }
        
    }


