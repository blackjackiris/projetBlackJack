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
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
    private byte mainUtilisee;  //Permet de savoir combien de mains supplémentaires à le joueur, et de tirer les cartes dans la bonne main
    private int miseJoueur;
    private int miseValidee;
    private int miseAssurance;
    private boolean choixAssurance;
    private boolean propAssurance;
    private boolean propDoubler;
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
        propAssurance = false;
        propDoubler = false;
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
            miseValidee = miseValidee * 2;
            j.argentGagne(miseValidee);
            miseValidee = 0;
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
        
        if(carte1.getValeur() == 1 && choixAssurance == false && propAssurance == false){
            boutonAssurance.setEnabled(true);
            propAssurance = true;
        }
        else{
            boutonAssurance.setEnabled(false);
        }
        
        //Affiche ou efface le boutton Doubler
        carte1 = j.main.getCarteDansMain(0);
        carte2 = j.main.getCarteDansMain(1);
        val = carte1.getValeur() + carte2.getValeur();
        
        if(val > 8 && val < 12 && propDoubler == false){
            boutonDoubler.setEnabled(true);
            propDoubler = true;
        }
        else{
            boutonDoubler.setEnabled(false);
        }
        
        //Affiche ou efface le boutton Partager
        if(carte1.getValeur() == carte2.getValeur()){
            boutonPartager.setEnabled(true);
        }
        else{
            boutonPartager.setEnabled(false);
        }
    }
    
    /**
     * Méthode pour retourné la carte face cachée du donneur
     */
    public void retournerSecondeCarteDonneur(){
        Image img;
        Graphics monDC;
        monDC = getGraphics();
        
        String id = "image/" + d.main.getIdCarteSelec(1) + ".png";
        img = getImage(id);
        monDC.drawImage(img, 582, 250, null);
        valMainD.setText(String.valueOf((d.main.getValeurMain())));
    }
    
    public void verifPropAssurance(){
        if(boutonAssurance.isEnabled() == true){
            propAssurance = true;
        }
    }

    /**
     * charge une image à partir d'un fichier utilise ImageIO
     * dans le cas du jar, le fichier n'est pas directement accessible
     * donc, créé une image à partir de l'url dans une imageIcone
     *
     * @param fichImg chaine du nom de l'image
     * @return
     */
    private Image getImage(String fichImg) {
        //récup de l'URL du fichier
        Image img = null;
        URL url;
        URI ur = null;
        File fichier = null;
        url = getClass().getResource(fichImg);
        //System.out.println("url : " + url.toString());
        try {
            //convertit l'URL en URI
            ur = url.toURI();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ur != null) {
            //System.out.println("uri n'est pas null :" + ur.toString());
            try {
                fichier = new File(ur);
                //System.out.println("fichier créé");
                img = ImageIO.read(fichier);
            } catch (IllegalArgumentException ie) {
                //System.out.println("fichier non accessible url : " + url.toString());
                ImageIcon icon;
                icon = new ImageIcon(url);
                //System.out.println("icone :" + icon.toString());
                img = icon.getImage();
            } catch (NullPointerException npe) {
                System.out.println("ptr null");
            } catch (IOException ex) {
                Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        boutonMiserCommencer = new javax.swing.JButton();
        boutonRetirerMise = new javax.swing.JButton();
        bouton100 = new javax.swing.JButton();
        bouton50 = new javax.swing.JButton();
        bouton10 = new javax.swing.JButton();
        bouton5 = new javax.swing.JButton();
        labelMainD = new javax.swing.JLabel();
        valMainD = new javax.swing.JLabel();
        messVictoire = new javax.swing.JLabel();
        labelMain = new javax.swing.JLabel();
        valMain = new javax.swing.JLabel();
        boutonTirer = new javax.swing.JButton();
        boutonRester = new javax.swing.JButton();
        boutonDoubler = new javax.swing.JButton();
        boutonPartager = new javax.swing.JButton();
        boutonAssurance = new javax.swing.JButton();
        labelMise = new javax.swing.JLabel();
        valeurMise = new javax.swing.JLabel();
        labelArgent = new javax.swing.JLabel();
        argent = new javax.swing.JLabel();
        labelAssurance = new javax.swing.JLabel();
        valAssurance = new javax.swing.JLabel();
        tapis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setName("Blackjack"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boutonNewPartie.setText("Rejouer");
        boutonNewPartie.setEnabled(false);
        boutonNewPartie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonNewPartieActionPerformed(evt);
            }
        });
        getContentPane().add(boutonNewPartie, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 950, -1, -1));

        boutonMiserCommencer.setText("Miser/Commencer");
        boutonMiserCommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonMiserCommencerActionPerformed(evt);
            }
        });
        getContentPane().add(boutonMiserCommencer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 940, -1, -1));

        boutonRetirerMise.setText("Retirer Mise");
        boutonRetirerMise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonRetirerMiseActionPerformed(evt);
            }
        });
        getContentPane().add(boutonRetirerMise, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 940, -1, -1));

        bouton100.setText("100");
        bouton100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton100ActionPerformed(evt);
            }
        });
        getContentPane().add(bouton100, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 900, -1, -1));

        bouton50.setText("50");
        bouton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton50ActionPerformed(evt);
            }
        });
        getContentPane().add(bouton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 900, 50, -1));

        bouton10.setText("10");
        bouton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton10ActionPerformed(evt);
            }
        });
        getContentPane().add(bouton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 870, 50, -1));

        bouton5.setText("5");
        bouton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton5ActionPerformed(evt);
            }
        });
        getContentPane().add(bouton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 870, 50, -1));

        labelMainD.setText("Valeur de la main ");
        getContentPane().add(labelMainD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));
        getContentPane().add(valMainD, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 40, 30));

        messVictoire.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        getContentPane().add(messVictoire, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 860, 340, 140));

        labelMain.setText("Valeur de la main :");
        getContentPane().add(labelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, -1, -1));
        getContentPane().add(valMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, 60, 30));

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
        boutonDoubler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonDoublerActionPerformed(evt);
            }
        });
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
        boutonAssurance.setEnabled(false);
        boutonAssurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonAssuranceActionPerformed(evt);
            }
        });
        getContentPane().add(boutonAssurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 910, -1, -1));

        labelMise.setText("Valeur de la mise :");
        getContentPane().add(labelMise, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 880, 100, 20));
        getContentPane().add(valeurMise, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 880, 50, 20));

        labelArgent.setText("Argent total : ");
        getContentPane().add(labelArgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 860, -1, -1));
        getContentPane().add(argent, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 860, 50, 20));

        labelAssurance.setText("Valeur assurance :");
        getContentPane().add(labelAssurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, -1, -1));
        getContentPane().add(valAssurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 610, 60, 30));

        tapis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack/image/TapisDeCartesBJ.png"))); // NOI18N
        tapis.setAutoscrolls(true);
        tapis.setFocusable(false);
        tapis.setName(""); // NOI18N
        getContentPane().add(tapis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 1024));

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
        j.tirer(jeuDeCartes, mainUtilisee);

        // affiche les cartes de la main du joueur
        String nomCarte = "image/" + j.main.getIdCarteMain() + ".png";
        Image img = getImage(nomCarte);
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceJoueur + 1), 600 + DECALAGEBAS * (mainUtilisee + 1), null);

        valMain.setText(String.valueOf((j.main.getValeurMain())));

        indiceJoueur++;
        
        //Vérifie si l'assurance à été proposée pour désactiver le bouton
        verifPropAssurance();
        
        if (j.main.getValeurMain() > 21){
            
            //Si le joueur à plus d'une main, continuer la partie sur la suivante, sinon DEFAITE
            if(mainUtilisee > 0){
                mainUtilisee --;
                switchEtatBouttons();
            }
            else{
                victoire();
            }
        }
        else{
            switchEtatBouttons();
        }
    }//GEN-LAST:event_boutonTirerActionPerformed

    private void boutonResterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonResterActionPerformed

        Graphics monDC;
        monDC = getGraphics();
        
        retournerSecondeCarteDonneur();

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
        
        //Vérifie si l'assurance à été proposée pour désactiver le bouton
        verifPropAssurance();
        
        //Vérifie qui est le gagnant
        victoire();
    }//GEN-LAST:event_boutonResterActionPerformed

    private void bouton100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton100ActionPerformed
        // TODO add your handling code here:

        miseJoueur = miseJoueur + 100;
        valeurMise.setText(String.valueOf(miseJoueur));

    }//GEN-LAST:event_bouton100ActionPerformed

    private void boutonMiserCommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonMiserCommencerActionPerformed
        // TODO add your handling code here:
        
        String nomCarte;
        Image img;
        Graphics monDC;
        monDC = getGraphics();
        
        //Désactive les boutons de mise
        bouton5.setEnabled(false);
        bouton10.setEnabled(false);
        bouton100.setEnabled(false);
        boutonMiserCommencer.setEnabled(false);
        boutonRetirerMise.setEnabled(false);

        // Retire l'argent miser de l'argent totale              
        miseValidee = j.miser(miseJoueur, (byte) (0) );
        argent.setText(String.valueOf((j.getArgentTotal())));
        valeurMise.setText(String.valueOf(miseValidee));

        //Affiche les boutons de jeu
        boutonTirer.setEnabled(true);
        boutonRester.setEnabled(true);

        //Indices Joueur et Donneur remis à zero, initialisations des attributs
        indiceJoueur = 0;
        indiceDonneur = 0;
        mainUtilisee = 0;
        j.setIndiceMainSupZero();
        jeuDeCartes = new PaquetDeCartes();
        choixAssurance = false;
        propAssurance = false;
        miseAssurance = 0;
        miseJoueur = 0;

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
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceJoueur + 1), 600 + DECALAGEBAS * (mainUtilisee + 1), null);
        valMain.setText(String.valueOf((j.main.getValeurMain())));
        indiceJoueur ++;

        //Le donneur tire une carte face cachée
        d.tirer(jeuDeCartes);
        img = getImage("image/blank.png");
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceDonneur + 1), 250, null);
        //Ici, l'affichage de la valeur de la main du donneur n'est pas mis à jour, pour garder la valeur de la carte face cachée secrete
        indiceDonneur ++;

        //Le joueur tire une carte face visible
        j.tirer(jeuDeCartes);
        nomCarte = "image/" + j.main.getIdCarteMain() + ".png";
        img = getImage(nomCarte);
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceJoueur + 1), 600 + DECALAGEBAS * (mainUtilisee + 1), null);
        valMain.setText(String.valueOf((j.main.getValeurMain())));
        indiceJoueur ++;
        
        switchEtatBouttons();
    }//GEN-LAST:event_boutonMiserCommencerActionPerformed

    private void boutonNewPartieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonNewPartieActionPerformed

        // vide la plateau
        tapis.repaint();
        
        messVictoire.setText("");
        valeurMise.setText("");

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
        boutonPartager.setEnabled(false);
        boutonAssurance.setEnabled(false);
        boutonNewPartie.setEnabled(false);

        //Affiche les boutons de mise
        bouton5.setEnabled(true);
        bouton10.setEnabled(true);
        bouton100.setEnabled(true);
        boutonMiserCommencer.setEnabled(true);
        boutonRetirerMise.setEnabled(true);

    }//GEN-LAST:event_boutonNewPartieActionPerformed

    private void bouton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton10ActionPerformed

        //Augmente la mise de 10
        miseJoueur = miseJoueur + 10;
        valeurMise.setText(String.valueOf(miseJoueur));

    }//GEN-LAST:event_bouton10ActionPerformed

    private void boutonPartagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonPartagerActionPerformed
        // TODO add your handling code here:
        Graphics monDC;
        monDC = getGraphics();
        String nomCarte;
        Image img;
        
        //Efface l'affichage des carte et le remet à jour
        tapis.repaint();
        
        indiceDonneur = 0;
        nomCarte = "image/" + d.main.getIdCarteSelec(0)+ ".png";
        img = getImage(nomCarte);
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceDonneur + 1), 250, null);
        valMainD.setText(String.valueOf((d.main.getValeurMain())));
        indiceDonneur ++;
        
        img = getImage("blank.png");
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceDonneur + 1), 250, null);
        indiceDonneur ++;
        
        //Partage des 2 mains en deux
        j.partager();
        mainUtilisee ++;
        //Attribution de la mise initial à la nouvelle main;
        j.miser(miseJoueur, mainUtilisee);
        
        //Distribution d'une carte dans l'ancienne et la nouvelle main
        j.tirer(jeuDeCartes, mainUtilisee);
        j.tirer(jeuDeCartes, (byte) (mainUtilisee - 1));
        
        //Affichage des cartes
        for(byte indice1 = 0; indice1 <= mainUtilisee; indice1 ++){
            
            if(indice1 == 0){
                for(byte indice2 = 0; indice2 < j.main.getNbCarteMain(); indice2 ++){
                    nomCarte = "image/" + j.main.getIdCarteSelec(indice2)+ ".png";
                    img = getImage(nomCarte);
                    monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indice2 + 1), 600 + DECALAGEBAS, null);
                }
            }
            else{
                for(byte indice2 = 0; indice2 < j.main.getNbCarteMain(); indice2 ++){
                    nomCarte = "image/" + j.getMainJoueurSupp(indice1).getIdCarteSelec(indice2)+ ".png";
                    img = getImage(nomCarte);
                    monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceJoueur + 1), 600 + DECALAGEBAS * (indice1 + 1), null);              
                }
            }
        }
        valMain.setText(String.valueOf((j.getMainJoueurSupp(mainUtilisee).getValeurMain())));
        
        switchEtatBouttons();
    }//GEN-LAST:event_boutonPartagerActionPerformed

    private void boutonRetirerMiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonRetirerMiseActionPerformed
        // TODO add your handling code here:
        
        //Annule la mise
        miseJoueur = 0;
        valeurMise.setText(String.valueOf(miseJoueur));
    }//GEN-LAST:event_boutonRetirerMiseActionPerformed

    private void boutonAssuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAssuranceActionPerformed
        // TODO add your handling code here:
        
        choixAssurance = true;
        propAssurance = true;
        miseValidee = j.assurance();
        miseAssurance = miseValidee;
        
        switchEtatBouttons();
    }//GEN-LAST:event_boutonAssuranceActionPerformed

    private void boutonDoublerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonDoublerActionPerformed
        // TODO add your handling code here:
        
        Graphics monDC;
        monDC = getGraphics();

        //le joueur double et joue
        miseValidee += j.doubler(jeuDeCartes, mainUtilisee, miseValidee);

        // affiche les cartes de la main du joueur
        String nomCarte = "image/" + j.main.getIdCarteMain() + ".png";
        Image img = getImage(nomCarte);
        monDC.drawImage(img, 550 + DECALAGEGAUCHE * (indiceJoueur + 1), 600 + DECALAGEBAS * (mainUtilisee + 1), null);

        valMain.setText(String.valueOf((j.main.getValeurMain())));
        valeurMise.setText(String.valueOf(miseValidee));

        indiceJoueur++;
        
        //Vérifie si l'assurance à été proposée pour désactiver le bouton
        verifPropAssurance();
        
        if (j.main.getValeurMain() > 21){
            
            //Si le joueur à plus d'une main, continuer la partie sur la suivante, sinon DEFAITE
            if(mainUtilisee > 0){
                mainUtilisee --;
                switchEtatBouttons();
            }
            else{
                victoire();
            }
        }
        else{
            switchEtatBouttons();
        }
        
    }//GEN-LAST:event_boutonDoublerActionPerformed

    private void bouton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton50ActionPerformed
        // TODO add your handling code here:
        miseJoueur = miseJoueur + 50;
        valeurMise.setText(String.valueOf(miseJoueur));
    }//GEN-LAST:event_bouton50ActionPerformed

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
    private javax.swing.JButton bouton50;
    private javax.swing.JButton boutonAssurance;
    private javax.swing.JButton boutonDoubler;
    private javax.swing.JButton boutonMiserCommencer;
    private javax.swing.JButton boutonNewPartie;
    private javax.swing.JButton boutonPartager;
    private javax.swing.JButton boutonRester;
    private javax.swing.JButton boutonRetirerMise;
    private javax.swing.JButton boutonTirer;
    private javax.swing.JLabel labelArgent;
    private javax.swing.JLabel labelAssurance;
    private javax.swing.JLabel labelMain;
    private javax.swing.JLabel labelMainD;
    private javax.swing.JLabel labelMise;
    private javax.swing.JLabel messVictoire;
    private javax.swing.JLabel tapis;
    private javax.swing.JLabel valAssurance;
    private javax.swing.JLabel valMain;
    private javax.swing.JLabel valMainD;
    private javax.swing.JLabel valeurMise;
    // End of variables declaration//GEN-END:variables
}
