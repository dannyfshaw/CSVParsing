package com.corprotex.csv.ui;

import java.awt.Dimension;
import javax.swing.*;
public class GUItest01 extends JFrame {
  public static void main(String[] args) {
      JFrame frame = new JFrame("main");
       frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      ImageIcon ii = new ImageIcon("C:\\GIT\\CSVParsing\\src\\main\\resources\\corportex_logo.png");
      JLabel lable = new JLabel(ii);
      JScrollPane jsp = new JScrollPane(lable);
      frame.getContentPane().add(jsp);
      frame. setSize(1000, 700);
      JButton button = new JButton();
      button.setSize(new Dimension(50, 50));
      button.setLocation(500, 350);
     frame.getContentPane().add(button);
     
frame.setVisible(true);
  }
}