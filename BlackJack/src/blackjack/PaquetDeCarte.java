
package blackjack;



public class PaquetDeCarte{
    
    //Attributs
    private Carte [ ] paquet;
    private int nbCarte;
    
    //Constructeur
    /**
     * 
     */
    public PaquetDeCarte(){
        
        paquet = new Carte[52];
        String id, idCol, idVal;
        byte indice1, indice2;
        nbCarte = 0;
        
        //Création des cartes par couleurs
        for(indice1 = 0; indice1 < 4; indice1 ++){
            
            //Création des cartes par valeurs
            for(indice2 = 0; indice2 < 13; indice2 ++){
                //Si la valeur d'un sous-id (couleur ou valeur) est inférieur à 10, ajouter un 0 pour toujours obtenir un id sur 4 chiffres
                if(indice1 < 10){
                    idCol = "0" + indice1;
                }
                else{
                    idCol = "" + indice1;
                }
                
                if(indice2 < 10){
                    idVal = "0" + indice2;
                }
                else{
                    idVal = "" + indice2;
                }
                
                id = idCol + idVal;
                paquet[nbCarte] = new Carte(indice2, indice1, id);
                nbCarte ++;
            }
        } 
    }  
    
    /**
     * @param nbCarte 
     */
    public PaquetDeCarte(int nbCarte) {
        this.nbCarte = nbCarte;
    }

    public PaquetDeCarte(PaquetDeCarte pcarte){
        
        this.nbCarte = pcarte.nbCarte;
    }

    //Methodes
    /**
     * 
     */
    public void melanger() {
        
        //Mauvais, à revoir
        
        for(byte indice = 0; indice < paquet.length; indice ++){
            //Création aléatoire d'un entier
            int alea = (int)(Math.random() * (paquet.length - 0));
            //Stockage de l'entier crée aléatoirement
            Carte tmp = paquet[alea];
            //Changement d'emplacement mémoire des valeurs
            paquet[indice] = paquet[alea];
            paquet[alea] = tmp;
        }
    }
    
    /**
     * 
     */
    public void testContenuPaquet(){
        
        //Affichage des id de toutes les cartes d'un paquet, méthode de test uniquement, inutile pour le programme final
        for(byte indice = 0; indice < paquet.length; indice ++){
            System.out.print(indice + " : ");
            paquet[indice].afficherIdCarte();
            System.out.println();
        }
    }
}
