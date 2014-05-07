
package blackjack;



public class PaquetDeCarte{
    
    //Attributs
    private Carte [] paquet;
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
    
    /**
     * 
     * @param pcarte 
     */
    public PaquetDeCarte(PaquetDeCarte pcarte){
        this.nbCarte = pcarte.nbCarte;
    }

    //Methodes
    /**
     * 
     */
    public void melanger() {
        
        int alea1, alea2;
        Carte swap;
        
        //La boucle execute 1000 fois l'opération suivante :
        //2 cartes sont choisie aléatoirement dans le paquet
        //La 1ère carte choisie prend les valeurs de la 2nd, et inversement
        for(int indice = 0; indice < 1000; indice ++){
            //Génération d'un 1er nombre aléatoire, compris entre 0 et 51
            alea1 = (int) (Math.random() * (paquet.length));
            
            //Génération d'un 2nd nombre aléatoire, compris entre 0 et 51, relancer la génération tant qu'il est identique au 1er nombre
            do{
                alea2 = (int) (Math.random() * (paquet.length));
            }while(alea2 == alea1);
            
            //Invertion des cartes numéro "alea1" et "aléa2"
            //La Carte swap prends les valeurs de la 1ère carte choisie
            swap = paquet[alea1];
            //La 1ère carte choisie prends les valeurs la 2nd carte choisie
            paquet[alea1] = paquet[alea2];
            //Les valeurs stockées dans swap sont mises dans la 2nd carte choisie
            paquet[alea2] = swap;
        }
    }
    
    /**
     * 
     * @return carteTiree
     */
    public Carte tirerCarte(){
        
        //La 1ère carte du tableau est stockée dans carteTiree
        Carte carteTiree = paquet[0];
        byte indice;
        
        //Déplacement de toutes les cartes d'une position en arrière
        for(indice = 0; indice < paquet.length; indice ++){
            paquet[indice] = paquet[indice + 1];
        }
        
        nbCarte --;
        return carteTiree;
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
