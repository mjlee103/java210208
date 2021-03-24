package calc.step1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class MyCalcLogic implements ActionListener{

   MyCalcView myCalcView = null;
   String v1 = null;
   String v2 = null;
   String op = null;
   
   public MyCalcLogic(MyCalcView myCalcView) {
      this.myCalcView = myCalcView;
   }

   /************************************
    * 연산처리
    * @param sValue1 처음에 입력한 숫자값
    * @param sValue2 연산자 다음에 입력된 숫자값
    * @param sOP 사용자가 선택한 연산자
    * @return 연산처리 결과 값
    *************************************/
   public static String calcurate(String sValue1, String sValue2, String sOP) {
      
      double b1 = Double.parseDouble(sValue1);
      double b2 = Double.parseDouble(sValue2);
      
      System.out.println("sValue1 : "+sValue1+"  sValue2 : "+sValue2+"==>"+sOP);
      if(sOP.equals("+")) {
         return ""+(b1+b2);
      }
      else {
         return "error";
      }
   }
      
   @Override
   public void actionPerformed(ActionEvent ae) {
      Object obj = ae.getSource();
      if(obj == myCalcView.getJbt_one()) {
         myCalcView.getJtf_result().setText(myCalcView.getJtf_result().getText()+"1"); //set계속 바뀌는거, append 뒤에 붙이는거
      }else if(obj == myCalcView.getJbt_two()) {
         myCalcView.getJtf_result().setText(myCalcView.getJtf_result().getText()+"2");
      }else if(obj == myCalcView.getJbt_plus()) {
         v1 = myCalcView.getJtf_result().getText();
         //System.out.println("v1:"+v1 +"-> v2 : "+v2+" op : "+op);
         op = "+";
         myCalcView.getJtf_result().setText("");
      }else if(obj == myCalcView.getJbt_equals()) {
         v2 = myCalcView.getJtf_result().getText();
         String result = MyCalcLogic.calcurate(v1,v2,op);
         myCalcView.getJtf_result().setText(result);
      }else if(obj == myCalcView.getJbt_clear()) {
         myCalcView.getJtf_result().setText("");
      }
   }
   
   
}