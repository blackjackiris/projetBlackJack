/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;

/**
 *
 * @author clement
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PaquetDeCartes p = new PaquetDeCartes();
        
        p.testContenuPaquet();
        p.melanger();
        p.testContenuPaquet();
    }
    
}
