/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Fennan
 */
public class Calculette extends JFrame{
 private JPanel container = new JPanel();
    String[] opers = {"1", "2", "3","4","5","6","7","8","9","0","+","-","*","/","=","AC"}; // on ajoutera par la suite les autres
    JButton[] boutons = new JButton[opers.length]; // tous les boutons
    private JLabel ecran = new JLabel(); // ecran: chiffre et résultats
    private double a,b;  // les opérants, on calcule a+b
    private String X ="";
    private boolean saisieb = false; // quand on clique sur + saisieb devient true
    // ie on saisie le chiffre b une fois on appuie sur = saisieb devient false


  public Calculette(){
     // le frame calculette
     this.setSize(300, 400);
     this.setTitle("Ma Calculette");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setLocationRelativeTo(null);
     // le panel
      container.setBackground(Color.gray);
      //Panel pour l'ecran resultat
    JPanel ecranPanel = new JPanel();
    ecranPanel.setPreferredSize(new Dimension(220, 30));
    ecranPanel.setBackground(Color.white) ;
    ecran = new JLabel("0"); //on met d'abord 0 comme résultat
    ecran.setPreferredSize(new Dimension(220, 20));
    ecranPanel.add(ecran);
    // Panel pour les opérateurs
    JPanel operateursPanel = new JPanel();
    operateursPanel.setPreferredSize(new Dimension(55, 225));
    // Panel por les nombres et .
    JPanel nombresPanel = new JPanel();
    nombresPanel.setPreferredSize(new Dimension(165, 225));
    nombresPanel.setBackground(Color.pink);
    operateursPanel.setBackground(Color.black);
    //on construit les boutons et on leur associe les listener
    // chiffreListerner por les nombre et .
    //PlusListener pour le bouton +
    //EgalListener pour le bouton =
     for(int i = 0; i < opers.length; i++){
      boutons[i] = new JButton(opers[i]);
      boutons[i].setPreferredSize(new Dimension(50, 40));
      switch(i){
        case 14 :  //= si on ajoute d'autres chiffre il faut modifier 3
          boutons[i].addActionListener(new Calculette.EgalListener());
            boutons[i].setPreferredSize(new Dimension(50, 30));
          operateursPanel.add(boutons[i]);
          break;
        case 10:  //+ si on ajoute d'autres chiffre il faut modifier 4
          boutons[i].addActionListener(new Calculette.PlusListener());
          boutons[i].setPreferredSize(new Dimension(50, 30));
          operateursPanel.add(boutons[i]);
          break;
          case 11:  //+ si on ajoute d'autres chiffre il faut modifier 4
              boutons[i].addActionListener(new Calculette.MoinListener());
              boutons[i].setPreferredSize(new Dimension(50, 30));
              operateursPanel.add(boutons[i]);
              break;
          case 12:  //*
              boutons[i].addActionListener(new Calculette.MultListener());
              boutons[i].setPreferredSize(new Dimension(50, 30));
              operateursPanel.add(boutons[i]);
              break;
          case 13:  /// si on ajoute d'autres chiffre il faut modifier 4
              boutons[i].addActionListener(new Calculette.DivListener());
              boutons[i].setPreferredSize(new Dimension(50, 30));
              operateursPanel.add(boutons[i]);
              break;
          case 15:  /// si on ajoute d'autres chiffre il faut modifier 4
              boutons[i].addActionListener(new Calculette.ACListener());
              boutons[i].setPreferredSize(new Dimension(50, 30));
              operateursPanel.add(boutons[i]);
              break;

        default :
          nombresPanel.add(boutons[i]);
          boutons[i].addActionListener(new Calculette.ChiffreListener());
          break;
      }
    }
    //on positionne les 3 panels sur le panel principal container
    container.add(ecranPanel, BorderLayout.NORTH);
    container.add(nombresPanel, BorderLayout.CENTER);
    container.add(operateursPanel, BorderLayout.EAST);
    this.setContentPane(container);
    this.setVisible(true);
  }

  class ChiffreListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      String chiffre = ((JButton)e.getSource()).getText(); //chiffre cliqué
      if(saisieb){
        saisieb = false;
      }
      else{
        if(!ecran.getText().equals("0"))
          chiffre = ecran.getText() + chiffre; // on concatène avec ecran
      }
      ecran.setText(chiffre);
    }
  }

  class EgalListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
        if (X=="+"){
            b= Double.valueOf(ecran.getText()).doubleValue();
      ecran.setText(String.valueOf(a+b));  //calcul a+b et mettre dans ecran
      saisieb= true;
        }
        else if (X=="-") {
            b= Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(a-b));  //calcul a+b et mettre dans ecran
            saisieb= true;
        }
        else if (X=="*") {
            b= Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(a*b));  //calcul a+b et mettre dans ecran
            saisieb= true;
        }
        else if (X=="/") {
            b= Double.valueOf(ecran.getText()).doubleValue();
            if (b==0) {
                ecran.setText("impossible");
                saisieb = true;
            }
            else {
                ecran.setText(String.valueOf(a / b));  //calcul a+b et mettre dans ecran
                saisieb = true;
            }
        }
    }
  }
    class ACListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            ecran.setText(" ");
            a = 0;
            saisieb = true;
        }
    }
  class PlusListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){

      a = Double.valueOf(ecran.getText()).doubleValue();
      saisieb = true;
      X="+";
    }
  }
    class MoinListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){

            a = Double.valueOf(ecran.getText()).doubleValue();
            saisieb = true;
            X="-";
        }
    }
    class MultListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){

            a = Double.valueOf(ecran.getText()).doubleValue();
            saisieb = true;
            X="*";
        }
    }
    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){

            a = Double.valueOf(ecran.getText()).doubleValue();
            saisieb = true;
            X="/";
        }
    }


  public static void main(String[] args) {
    Calculette maCalculette = new Calculette(); //instance
  }

} // fin de la classe
