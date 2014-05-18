/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author PC
 */
public class Plateau extends javax.swing.JFrame {

    //Attributs
    private final int BLACKJACK = 21;
    private boolean victoire;
    private Joueur j;
    private Donneur d;
    private PaquetDeCartes jeuDeCartes;

    private int valeurMainDonneur;
    private int valeurMainJoueur;
    private byte indiceDonneur;
    private byte indiceJoueur;
    private int miseJoueur;
    private boolean choixAssurance;
    private final int DECALAGEGAUCHE = 16;
    private final int DECALAGEBAS = 32;
    private final int x = 16;
    private final int y = 50;

    /**
     * Creates new form Plateau
     */
    public Plateau() {

        j = new Joueur();
        d = new Donneur();
        jeuDeCartes = new PaquetDeCartes();
        choixAssurance = false;
        indiceDonneur = 0;
        indiceJoueur = 0;

        miseJoueur = j.getMise();
        valeurMainDonneur = d.main.getValeurMain();
        valeurMainJoueur = j.main.getValeurMain();

        initComponents();
        Graphics monDC;
        monDC = getGraphics();
        argent.setText(String.valueOf((j.getArgentTotal())));
        boutonNewPartie.setEnabled(false);
         boutonTirer.setEnabled(false);
        boutonRester.setEnabled(false);
        boutonDoubler.setEnabled(false);
        boutonAssurance.setEnabled(false);
        boutonPartager.setEnabled(false);

    }

    /**
     * Méthode détérmination du gagnant
     */
    public void victoire() {

        // calcule la valeur de la main du joueur
        valeurMainJoueur = j.main.getValeurMain();

        // calcule la valeur de la main du donneur
        valeurMainDonneur = d.main.getValeurMain();

        // Si la valeur de la MainJoueur est > à celle de la MainDonneur sans dépasser 21 ou si la valeur de la MainDonneur dépasse 21, alors le joueur gagne
        if((valeurMainJoueur > valeurMainDonneur && valeurMainJoueur <= BLACKJACK) || valeurMainDonneur > BLACKJACK) {
            victoire = true;
        }
        // Sinon le joueur perd         
        else{
            victoire = false;
        }

        // affichage du résultat à l'écran
        if (victoire == true) {

            messVictoire.setText("VOUS AVEZ GAGNE !");
            miseJoueur = miseJoueur * 2;
            j.argentGagne(miseJoueur);
            miseJoueur = 0;
            valeurMise.setText("0");
            argent.setText(String.valueOf((j.getArgentTotal())));

            boutonTirer.setEnabled(false);
            boutonRester.setEnabled(false);
            boutonDoubler.setEnabled(false);

            boutonNewPartie.setEnabled(true);

        } else {

            boutonTirer.setEnabled(false);
            boutonRester.setEnabled(false);
            boutonDoubler.setEnabled(false);

            boutonNewPartie.setEnabled(true);
            messVictoire.setText("VOUS AVEZ PERDU !");

            miseJoueur = 0;
            valeurMise.setText("0");
            argent.setText(String.valueOf((j.getArgentTotal())));

        }
    }
    
    //Méthode permettant d'afficher/éffacer les bouttons en fonction des cartes/valeurs
    public void switchEtatBouttons(){
        
        Carte carte1, carte2;
        int val;
        
        //Affiche ou efface le boutton Assurance
        carte1 = d.main.getCarteDansMain(0);
        
        if(carte1.getValeur() == 1 && choixAssurance == false){
            boutonAssurance.setEnabled(true);
        }
        else{
            boutonAssurance.setEnabled(false);
        }
        
        //Affiche ou efface le boutton Doubler
        carte1 = j.main.getCarteDansMain(0);
        carte2 = j.main.getCarteDansMain(1);
        val = carte1.getValeur() + carte2.getValeur();
        
        if(val >= 9 && val <= 11){
            boutonDoubler.setEnabled(true);
        }
        else{
            boutonDoubler.setEnabled(false);
        }
        
        //Affiche ou efface le boutton Partager
        if(carte1.getValeur() == carte2.getValeur()){
            boutonPartager.setEnabled(true);
        }
        else{
            boutonPartager.setEnabled(true);
        }
    }
    
    /**
     * Méthode pour retourné la carte face cachée du donneur
     */
    public void retournerSecondeCarteDonneur(){
        Image img;
        Graphics monDC;
        monDC = getGraphics();
        
        String id = "image/" + d.main.getIdSecondeCarte() + ".png";
        img = getImage(id);
        monDC.drawImage(img, 582, 250, null);
        valMainD.setText(String.valueOf((d.main.getValeurMain())));
        
    
    }
    
        /**
     * Méthode pour retourné la carte face cachée du Joueur
     */
    public void retournerSecondeCarteJoueur(){
        Image img;
        Graphics monDC;
        monDC = getGraphics();
        
        String id = "image/" + j.main.getIdSecondeCarte() + ".png";
        img = getImage(id);
        monDC.drawImage(img, 582, 600, null);
        valMainD.setText(String.valueOf((j.main.getValeurMain())));
        
    
    }

    /**
     * charge une image à partir d'un fichier utilise ImageIO
     *
     * @param fichImg chaine du nom de l'image
     * @return
     */
    private Image getImage(String fichImg) {
        //récup de l'URL du fichier
        Image img = null;
        URL url;
        URI ur = null;
        File fichier;
        url = getClass().getResource(fichImg);
        try {
            //convertit l'URL en URI
            ur = url.toURI();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
        fichier = new File(ur);
        try {
            img = ImageIO.read(fichier);
        } catch (IOException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boutonNewPartie = new javax.swing.JButton();
        boutonMiser = new javax.swing.JButton();
        bouton100 = new javax.swing.JButton();
        bouton10 = new javax.swing.JButton();
        bouton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        valMainD = new javax.swing.JLabel();
        messVictoire = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        valMain = new javax.swing.JLabel();
        boutonDebutPartie = new javax.swing.JButton();
        boutonTirer = new javax.swing.JButton();
        boutonRester = new javax.swing.JButton();
        boutonDoubler = new javax.swing.JButton();
        boutonPartager = new javax.swing.JButton();
        boutonAssurance = new javax.swing.JButton();
        valeurMise = new javax.swing.JLabel();
        texteValeurMise = new javax.swing.JLabel();
        argent = new javax.swing.JLabel();
        textteArgenttotale = new javax.swing.JLabel();
        Plateau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setName("Blackjack"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boutonNewPartie.setText("Rejouer");
        boutonNewPartie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonNewPartieActionPerformed(evt);
            }
        });
        getContentPane().add(boutonNewPartie, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 970, -1, -1));

        boutonMiser.setText("Miser");
        boutonMiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonMiserActionPerformed(evt);
            }
        });
        getContentPane().add(boutonMiser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 940, -1, -1));

        bouton100.setText("100");
        bouton100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton100ActionPerformed(evt);
            }
        });
        getContentPane().add(bouton100, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 890, -1, -1));

        bouton10.setText("10");
        bouton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton10ActionPerformed(evt);
            }
        });
        getContentPane().add(bouton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 890, -1, -1));

        bouton5.setText("5");
        bouton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton5ActionPerformed(evt);
            }
        });
        getContentPane().add(bouton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 890, -1, -1));

        jLabel5.setText("Valeur de la main ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));
        getContentPane().add(valMainD, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 40, 30));

        messVictoire.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        getContentPane().add(messVictoire, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 930, 170, 80));

        jLabel4.setText("Valeur de la main");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, -1, -1));
        getContentPane().add(valMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 610, 20, 20));

        boutonDebutPartie.setText("Commencer");
        boutonDebutPartie.setEnabled(false);
        boutonDebutPartie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonDebutPartieActionPerformed(evt);
            }
        });
        getContentPane().add(boutonDebutPartie, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 970, -1, -1));

        boutonTirer.setText("Tirer");
        boutonTirer.setEnabled(false);
        boutonTirer.setRolloverEnabled(false);
        boutonTirer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonTirerActionPerformed(evt);
            }
        });
        getContentPane().add(boutonTirer, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 910, -1, -1));

        boutonRester.setText("Rester");
        boutonRester.setEnabled(false);
        boutonRester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonResterActionPerformed(evt);
            }
        });
        getContentPane().add(boutonRester, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 910, -1, -1));

        boutonDoubler.setText("Doubler");
        boutonDoubler.setEnabled(false);
        getContentPane().add(boutonDoubler, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 910, -1, -1));

        boutonPartager.setText("Partager");
        boutonPartager.setEnabled(false);
        boutonPartager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonPartagerActionPerformed(evt);
            }
        });
        getContentPane().add(boutonPartager, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 910, -1, -1));

        boutonAssurance.setText("Assurance");
        getContentPane().add(boutonAssurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 910, -1, -1));
        getContentPane().add(valeurMise, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 900, 50, 20));

        texteValeurMise.setText("Valeur de la mise :");
        getContentPane().add(texteValeurMise, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 900, 140, 20));
        getContentPane().add(argent, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 870, 50, 20));

        textteArgenttotale.setText("Argent total : ");
        getContentPane().add(textteArgenttotale, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 880, -1, -1));

        Plateau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/image/TapisDeCartesBJ.png"))); // NOI18N
        Plateau.setAutoscrolls(true);
        Plateau.setFocusable(false);
        Plateau.setName(""); // NOI18N
        getContentPane().add(Plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void bouton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton5ActionPerformed

        // augmente la mise de 5
        miseJoueur = miseJoueur + 5;
        valeurMise.setText(String.valueOf(miseJoueur));

// TODO add your handling code here:
    }//GEN-LAST:event_bouton5ActionPerformed

    private void boutonTirerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonTirerActionPerformed
        Graphics monDC;
        monDC = getGraphics();

        //le joueur joue
        j.tirer(jeuDeCartes);

        //monDC.drawString("titi est content", 200, 200);
        // affiche les cartes de la main du joueur
        String nomCarte = "image/" + j.main.getIdCarteMain() + ".png";
        Image img = getImage(nomCarte);
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceJoueur + 1), 600, null);

        valMain.setText(String.valueOf((j.main.valeurMainCarteCache())));

        indiceJoueur++;
        if (j.main.valeurMainCarteCache() > 21) {

            boutonNewPartie.setEnabled(true);

            messVictoire.setText("VOUS AVEZ PERDU !");

            boutonTirer.setEnabled(false);
            boutonRester.setEnabled(false);
            boutonDoubler.setEnabled(false);

        }
        
        switchEtatBouttons();

    }//GEN-LAST:event_boutonTirerActionPerformed

    private void boutonResterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonResterActionPerformed

        Graphics monDC;
        monDC = getGraphics();
        
        retournerSecondeCarteDonneur();
        retournerSecondeCarteJoueur();

        while(d.main.getValeurMain() < 17){
            d.tirer(jeuDeCartes);

            // affiche les cartes de la main du Croupier
            String nomCarte = "image/" + d.main.getIdCarteMain() + ".png";
            Image img = getImage(nomCarte);
            monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceDonneur + 1), 250, null);

            indiceDonneur++;

        }

        valMainD.setText(String.valueOf((d.main.getValeurMain())));
           valMain.setText(String.valueOf((j.main.getValeurMain())));

        if (d.main.getValeurMain() > 21) {

            boutonTirer.setEnabled(false);
            boutonRester.setEnabled(false);
            boutonDoubler.setEnabled(false);

      
            boutonNewPartie.setEnabled(true);

            messVictoire.setText("VOUS AVEZ GAGNE !");

        } else {
            victoire();
        }


    }//GEN-LAST:event_boutonResterActionPerformed

    private void bouton100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton100ActionPerformed
        // TODO add your handling code here:

        miseJoueur = miseJoueur + 100;
        valeurMise.setText(String.valueOf(miseJoueur));

    }//GEN-LAST:event_bouton100ActionPerformed

    private void boutonMiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonMiserActionPerformed
        // TODO add your handling code here:

        // désactive les boutons de mise
        bouton10.setEnabled(false);
        bouton100.setEnabled(false);
        bouton5.setEnabled(false);
        boutonMiser.setEnabled(false);
        
        // atcive le bouton pour commencer a jouer
        boutonDebutPartie.setEnabled(true);

        // Retire l'argent miser de l'argent totale              
        j.miser(miseJoueur);
        argent.setText(String.valueOf((j.getArgentTotal())));


    }//GEN-LAST:event_boutonMiserActionPerformed

    private void boutonNewPartieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonNewPartieActionPerformed

        // vide la plateau
        Plateau.repaint();
        
        messVictoire.setText("");

        // vide la main du joueur
        j.main.viderMain();
        valMain.setText(String.valueOf((j.main.getValeurMain())));

        //Vide la main du donneur
        d.main.viderMain();
        valMainD.setText(String.valueOf((d.main.getValeurMain())));

        //Efface les boutons de jeu
        boutonTirer.setEnabled(false);
        boutonRester.setEnabled(false);
        boutonDoubler.setEnabled(false);
        boutonNewPartie.setEnabled(false);

        //Affiche les boutons de mise
        bouton10.setEnabled(true);
        bouton100.setEnabled(true);
        bouton5.setEnabled(true);
        boutonMiser.setEnabled(true);
        
        //Affiche le bouton pour commencer la partie
        boutonDebutPartie.setEnabled(true);

    }//GEN-LAST:event_boutonNewPartieActionPerformed

    private void bouton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton10ActionPerformed

        //Augmente la mise de 10
        miseJoueur = miseJoueur + 10;
        valeurMise.setText(String.valueOf(miseJoueur));

    }//GEN-LAST:event_bouton10ActionPerformed

    private void boutonPartagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonPartagerActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_boutonPartagerActionPerformed

    private void boutonDebutPartieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonDebutPartieActionPerformed
        // TODO add your handling code here:
        
        String nomCarte;
        Image img;
        Graphics monDC;
        monDC = getGraphics();
        
        //Efface le bouton de début de partie
        boutonDebutPartie.setEnabled(false);
        
        //Affiche les boutons de jeu
        boutonTirer.setEnabled(true);
        boutonRester.setEnabled(true);
        boutonDoubler.setEnabled(true);
        
        //Indices Joueur et Donneur remis à zero
        indiceJoueur = 0;
        indiceDonneur = 0;
        
        //Le donneur tire une carte face visible
        d.tirer(jeuDeCartes);
        nomCarte = "image/" + d.main.getIdCarteMain() + ".png";
        img = getImage(nomCarte);
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceDonneur + 1), 250, null);
        valMainD.setText(String.valueOf((d.main.getValeurMain())));
        indiceDonneur ++;
        
        //Le joueur tire une carte face visible
        j.tirer(jeuDeCartes);
        nomCarte = "image/" + j.main.getIdCarteMain() + ".png";
        img = getImage(nomCarte);
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceJoueur + 1), 600, null);
        valMain.setText(String.valueOf((j.main.getValeurMain())));
        indiceJoueur ++;
        
        //Le donneur tire une carte face cachée
        d.tirer(jeuDeCartes);
       String blank = "image/blank.png";
        img = getImage(blank);
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceDonneur + 1), 250, null);
        //Ici, l'affichage de la valeur de la main du donneur n'est pas mis à jour, pour garder la valeur de la carte face cachée secrete
        indiceDonneur ++;
        
        //Le joueur tire une carte face cachéé
        j.tirer(jeuDeCartes);
       
         img = getImage(blank);
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceJoueur + 1), 600, null);
      //  valMain.setText(String.valueOf((j.main.getValeurMain())));
        indiceJoueur ++;
        
    }//GEN-LAST:event_boutonDebutPartieActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Plateau().setVisible(true);

            }
        });

        //Début de la partie
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Plateau;
    private javax.swing.JLabel argent;
    private javax.swing.JButton bouton10;
    private javax.swing.JButton bouton100;
    private javax.swing.JButton bouton5;
    private javax.swing.JButton boutonAssurance;
    private javax.swing.JButton boutonDebutPartie;
    private javax.swing.JButton boutonDoubler;
    private javax.swing.JButton boutonMiser;
    private javax.swing.JButton boutonNewPartie;
    private javax.swing.JButton boutonPartager;
    private javax.swing.JButton boutonRester;
    private javax.swing.JButton boutonTirer;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel messVictoire;
    private javax.swing.JLabel texteValeurMise;
    private javax.swing.JLabel textteArgenttotale;
    private javax.swing.JLabel valMain;
    private javax.swing.JLabel valMainD;
    private javax.swing.JLabel valeurMise;
    // End of variables declaration//GEN-END:variables
}
