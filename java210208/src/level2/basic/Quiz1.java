package level2.basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
//JLable은 ActionListener를 지원 받지 못함.
class Quiz1_sub extends JPanel{
   JButton jbtn = new JButton("버튼");
   public void initDisplay() {
      this.setLayout(new BorderLayout());
      this.add("Center",jbtn);
   }
}
public class Quiz1 extends JFrame implements MouseListener{
   JTextArea jta = new JTextArea();
   JLabel  jlb = new JLabel("화면갱신");
   public void initDisplay() {
      jlb.addMouseListener(this);
      jta.setBackground(Color.green);
      this.add("Center",jta);
      this.add("South",jlb);
      this.setSize(600, 450);
      this.setVisible(true);
   }
   public static void main(String[] args) {
      Quiz1 q1 = new Quiz1();
      q1.initDisplay();
   }
   @Override
   public void mouseClicked(MouseEvent arg0) {
      System.out.println("JLabel");
      
   }
   @Override
   public void mouseEntered(MouseEvent arg0) {
      // TODO Auto-generated method stub
      
   }
   @Override
   public void mouseExited(MouseEvent arg0) {
      // TODO Auto-generated method stub
      
   }
   @Override
   public void mousePressed(MouseEvent arg0) {
      // TODO Auto-generated method stub
      
   }
   @Override
   public void mouseReleased(MouseEvent arg0) {
      // TODO Auto-generated method stub
      
   }

}