package calc.step1;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calc.step1.MyCalcLogic;

public class MyCalcView extends JFrame {
   
   private JTextField    jtf_result    = null;
   private JButton    jbt_one    = null;
   private JButton      jbt_two    = null;
   private JButton       jbt_plus    = null;
   private JButton    jbt_equals    = null;
   private JButton    jbt_clear    = null;
   private JPanel       jp_pad       = null;
   MyCalcLogic myLogic    = null;
   

   public MyCalcView(){
      initDisplay();
   }
   
   public void initDisplay() {
      jtf_result   = new JTextField();
      jtf_result.setHorizontalAlignment(JTextField.RIGHT); //이거 텍스트 오른쪽에 입력하게 하는 그거같은디
      jbt_one      = new JButton("1");
      jbt_two    = new JButton("2");
      jbt_plus   = new JButton("+");
      jbt_equals    = new JButton("=");
      jbt_clear    = new JButton("C");
      
      myLogic = new MyCalcLogic(this);
      jtf_result.addActionListener(myLogic);
      jbt_one.addActionListener(myLogic);
      jbt_two.addActionListener(myLogic);
      jbt_plus.addActionListener(myLogic);
      jbt_equals.addActionListener(myLogic);
      jbt_clear.addActionListener(myLogic);
      
      jp_pad       = new JPanel(new GridLayout(1,5,2,2));
      jp_pad.add(jbt_one);
      jp_pad.add(jbt_two);
      jp_pad.add(jbt_plus);
      jp_pad.add(jbt_equals);
      jp_pad.add(jbt_clear);
         
      this.getContentPane().add("North",jtf_result);
      this.getContentPane().add("Center",jp_pad);
      
      this.setTitle("계산기33쪼개기쪼개기");
      this.setSize(300, 150);
      this.setVisible(true);
      }
   
   
   public static void main(String[] args) {
      new MyCalcView();   //생성자 호출
   }

   public JTextField getJtf_result() {
      return jtf_result;
   }

   public JButton getJbt_one() {
      return jbt_one;
   }

   public JButton getJbt_two() {
      return jbt_two;
   }

   public JButton getJbt_plus() {
      return jbt_plus;
   }

   public JButton getJbt_equals() {
      return jbt_equals;
   }

   public JButton getJbt_clear() {
      return jbt_clear;
   }

   public JPanel getJp_pad() {
      return jp_pad;
   }

   public MyCalcLogic getMyLogic() {
      return myLogic;
   }
   
   
}