/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;

import java.awt.Graphics;

/**
 *
 * @author PC
 */
public class Plateau extends javax.swing.JFrame {
    
        //Attributs
    private final byte BLACKJACK = 21;
    private boolean victoire;
    private Joueur j;
    private Donneur d;
    public static PaquetDeCartes jeuDeCartes;
    
    Main mainDuDonneur;
    Main mainDuJoueur;
    int valeurMainDonneur;
    int valeurMainJoueur;
    int miseJoueur;

    /**
     * Creates new form Plateau
     */
    public Plateau() {
        
        j = new Joueur();
        d = new Donneur();
        jeuDeCartes = new PaquetDeCartes();
        
        mainDuDonneur=d.getMainDonneur();
        mainDuJoueur=j.getMainJoueur();
        valeurMainDonneur=mainDuDonneur.getValeurMain();
        valeurMainJoueur=mainDuJoueur.getValeurMain();
        
    
        initComponents();
    }

    /**
     * Méthode détérmination du gagnant
     */
    public void victoire() {

        // victoire du donneur
        // Si la valeur de la main du croupier = 21
        if (valeurMainDonneur == BLACKJACK) {

            victoire = false;
        }
        // victoire du donneur
        // Si la valeur de la main du croupier > celle du joueur
        if(valeurMainJoueur< valeurMainDonneur){
        
            victoire = false;
        }
         // victoire du donneur
        // Si la valeur de la main du croupier = celle du joueur
        if(valeurMainJoueur == valeurMainDonneur){
            victoire = false;
        }
        // victoire du joueur
        // Si la valeur de la main du joueur > celle du croupier
        if(valeurMainJoueur > valeurMainDonneur){
        
            victoire = true;
        }
    
 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bouton5 = new javax.swing.JButton();
        boutonTirer = new javax.swing.JButton();
        Rester = new javax.swing.JButton();
        Doubler = new javax.swing.JButton();
        valeurMise = new javax.swing.JLabel();
        argent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bouton10 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 540));
        setMinimumSize(new java.awt.Dimension(720, 520));
        setPreferredSize(new java.awt.Dimension(720, 540));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bouton5.setText("5");
        bouton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bouton5MouseClicked(evt);
            }
        });
        bouton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton5ActionPerformed(evt);
            }
        });
        getContentPane().add(bouton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        boutonTirer.setText("Tirer");
        boutonTirer.setRolloverEnabled(false);
        boutonTirer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonTirerActionPerformed(evt);
            }
        });
        getContentPane().add(boutonTirer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, -1));

        Rester.setText("Rester");
        getContentPane().add(Rester, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, -1, -1));

        Doubler.setText("Doubler");
        getContentPane().add(Doubler, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, -1, -1));
        getContentPane().add(valeurMise, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 60, 20));
        getContentPane().add(argent, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 50, 20));

        jLabel1.setText("Argent total : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        bouton10.setText("10");
        bouton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bouton10MouseClicked(evt);
            }
        });
        getContentPane().add(bouton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        jLabel2.setText("Valeur de la mise :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/Cartes/imgPlateau.jpeg"))); // NOI18N
        jLabel3.setFocusable(false);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void bouton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouton10MouseClicked
       
//        Joueur.mise = Joueur.mise + 10;
//        Joueur.argentTotal = Joueur.argentTotal - 10;
//
//        valeurMise.setText(String.valueOf(Joueur.mise));
//        argent.setText(String.valueOf(Joueur.argentTotal));
    }//GEN-LAST:event_bouton10MouseClicked

    private void bouton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bouton5MouseClicked
       
//        Joueur.mise = Joueur.mise + 5;
//        Joueur.argentTotal = Joueur.argentTotal - 5;
//        valeurMise.setText(String.valueOf(Joueur.mise));
//        argent.setText(String.valueOf(Joueur.argentTotal));
    }//GEN-LAST:event_bouton5MouseClicked

    private void bouton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bouton5ActionPerformed

    private void boutonTirerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonTirerActionPerformed
        // TODO add your handling code here:
        Graphics monDC = getGraphics();
        monDC.drawString("titi est content", 200, 200);
    }//GEN-LAST:event_boutonTirerActionPerformed

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
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Doubler;
    private javax.swing.JButton Rester;
    private javax.swing.JLabel argent;
    private javax.swing.JButton bouton10;
    private javax.swing.JButton bouton5;
    private javax.swing.JButton boutonTirer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel valeurMise;
    // End of variables declaration//GEN-END:variables
}
