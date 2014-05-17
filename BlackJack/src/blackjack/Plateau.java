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
    private int miseJoueur;
    private int indice;
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

        miseJoueur = j.getMise();
        valeurMainDonneur = d.main.getValeurMain();
        valeurMainJoueur = j.main.getValeurMain();

        initComponents();
        Graphics monDC;
        monDC = getGraphics();
        argent.setText(String.valueOf((j.getArgentTotal())));
        boutonNewPartie.setEnabled(false);

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
            bouttonDoubler.setEnabled(false);

            boutonNewPartie.setEnabled(true);

        } else {

            boutonTirer.setEnabled(false);
            boutonRester.setEnabled(false);
            bouttonDoubler.setEnabled(false);

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
            bouttonAssurance.setEnabled(true);
        }
        else{
            bouttonAssurance.setEnabled(false);
        }
        
        //Affiche ou efface le boutton Doubler
        carte1 = j.main.getCarteDansMain(0);
        carte2 = j.main.getCarteDansMain(1);
        val = carte1.getValeur() + carte2.getValeur();
        
        if(val >= 9 && val <= 11){
            bouttonDoubler.setEnabled(true);
        }
        else{
            bouttonDoubler.setEnabled(false);
        }
        
        //Affiche ou efface le boutton Partager
        if(carte1.getValeur() == carte2.getValeur()){
            bouttonPartager.setEnabled(true);
        }
        else{
            bouttonPartager.setEnabled(true);
        }
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
        boutonTirer = new javax.swing.JButton();
        boutonRester = new javax.swing.JButton();
        bouttonDoubler = new javax.swing.JButton();
        bouttonPartager = new javax.swing.JButton();
        bouttonAssurance = new javax.swing.JButton();
        valeurMise = new javax.swing.JLabel();
        argent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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
        getContentPane().add(valMainD, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        messVictoire.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        getContentPane().add(messVictoire, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 860, 340, 140));

        jLabel4.setText("Valeur de la main");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, -1, -1));
        getContentPane().add(valMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 70, 50));

        boutonTirer.setText("Tirer");
        boutonTirer.setRolloverEnabled(false);
        boutonTirer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonTirerActionPerformed(evt);
            }
        });
        getContentPane().add(boutonTirer, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 910, -1, -1));

        boutonRester.setText("Rester");
        boutonRester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonResterActionPerformed(evt);
            }
        });
        getContentPane().add(boutonRester, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 910, -1, -1));

        bouttonDoubler.setText("Doubler");
        getContentPane().add(bouttonDoubler, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 910, -1, -1));

        bouttonPartager.setText("Partager");
        bouttonPartager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonPartagerActionPerformed(evt);
            }
        });
        getContentPane().add(bouttonPartager, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 910, -1, -1));

        bouttonAssurance.setText("Assurance");
        getContentPane().add(bouttonAssurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 910, -1, -1));
        getContentPane().add(valeurMise, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 900, 50, 20));
        getContentPane().add(argent, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 870, 50, 20));

        jLabel1.setText("Argent total : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 880, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/image/TapisDeCartesBJ.png"))); // NOI18N
        jLabel3.setAutoscrolls(true);
        jLabel3.setFocusable(false);
        jLabel3.setName(""); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 1024));

        jLabel2.setText("Valeur de la mise :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 900, 140, 20));

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
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indice + 1), 600, null);

        valMain.setText(String.valueOf((j.main.getValeurMain())));

        indice++;
        if (j.main.getValeurMain() > 21) {

            boutonNewPartie.setEnabled(true);

            messVictoire.setText("VOUS AVEZ PERDU !");

            boutonTirer.setEnabled(false);
            boutonRester.setEnabled(false);
            bouttonDoubler.setEnabled(false);

        }
        
        switchEtatBouttons();

    }//GEN-LAST:event_boutonTirerActionPerformed

    private void boutonResterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonResterActionPerformed

        Graphics monDC;
        monDC = getGraphics();

        do {
            d.tirer(jeuDeCartes);

            // affiche les cartes de la main du Croupier
            String nomCarte = "image/" + d.main.getIdCarteMain() + ".png";
            Image img = getImage(nomCarte);
            monDC.drawImage(img, 550 + x * (indice + 1), 250, null);

            indice++;

        } while (d.main.getValeurMain() < 17);

        valMainD.setText(String.valueOf((d.main.getValeurMain())));

        if (d.main.getValeurMain() > 21) {

            boutonTirer.setEnabled(false);
            boutonRester.setEnabled(false);
            bouttonDoubler.setEnabled(false);

            boutonNewPartie.setVisible(true);
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

        // Retire l'argent miser de l'argent totale              
        j.miser(miseJoueur);
        argent.setText(String.valueOf((j.getArgentTotal())));


    }//GEN-LAST:event_boutonMiserActionPerformed

    private void boutonNewPartieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonNewPartieActionPerformed

        // vide la plateau
        jLabel3.repaint();
        
            messVictoire.setText("");

        // vide la main du joueur
        j.main.viderMain();
        valMain.setText(String.valueOf((j.main.getValeurMain())));

          // vide la main du donneur
        d.main.viderMain();
        valMainD.setText(String.valueOf((d.main.getValeurMain())));

        // réactive les boutons de jeux
        boutonTirer.setEnabled(true);
        boutonRester.setEnabled(true);
        bouttonDoubler.setEnabled(true);
        boutonNewPartie.setEnabled(false);

        // réactive les boutons de mise
        bouton10.setEnabled(true);
        bouton100.setEnabled(true);
        bouton5.setEnabled(true);
        boutonMiser.setEnabled(true);
        
        indice = 0;
        
        switchEtatBouttons();

    }//GEN-LAST:event_boutonNewPartieActionPerformed

    private void bouton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton10ActionPerformed

        // augmente la mise de 10
        miseJoueur = miseJoueur + 10;
        valeurMise.setText(String.valueOf(miseJoueur));

    }//GEN-LAST:event_bouton10ActionPerformed

    private void bouttonPartagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonPartagerActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_bouttonPartagerActionPerformed

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
    private javax.swing.JLabel argent;
    private javax.swing.JButton bouton10;
    private javax.swing.JButton bouton100;
    private javax.swing.JButton bouton5;
    private javax.swing.JButton boutonMiser;
    private javax.swing.JButton boutonNewPartie;
    private javax.swing.JButton boutonRester;
    private javax.swing.JButton boutonTirer;
    private javax.swing.JButton bouttonAssurance;
    private javax.swing.JButton bouttonDoubler;
    private javax.swing.JButton bouttonPartager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel messVictoire;
    private javax.swing.JLabel valMain;
    private javax.swing.JLabel valMainD;
    private javax.swing.JLabel valeurMise;
    // End of variables declaration//GEN-END:variables
}
