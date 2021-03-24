package com.onj;														
														
import java.awt.event.ActionEvent;														
import java.awt.event.ActionListener;														
														
import javax.swing.JButton;														
import javax.swing.JTextField;														
														
public class MyCalcEventHandler implements ActionListener{														
	private JTextField jtf_result = null;													
	private JButton jbt_one = null;													
	private JButton jbt_two = null;													
	private JButton jbt_plus = null;													
	private JButton jbt_equals = null; 													
	private JButton jbt_clear = null; 													
	String v1 = "";													
	String v2 = "";													
	String op = "";													
	public MyCalcEventHandler(){													
														
	}		//생성자가 들어와야함 why? 괄호가 있는데 리턴타입이 없기 때문이다.  MyCalcEventHandler											
	public MyCalcEventHandler(JTextField jtf_result, JButton jbt_one, JButton jbt_two, JButton jbt_plus, JButton jbt_equals, JButton jbt_clear){													
		this.jtf_result = jtf_result;												
		this.jbt_one = jbt_one;												
		this.jbt_two = jbt_two;												
		this.jbt_plus = jbt_plus;												
		this.jbt_equals = jbt_equals;												
		this.jbt_clear = jbt_clear;												
	}													
	@Override													
	public void actionPerformed(ActionEvent ae) {													
		Object obj = ae.getSource();												
														
		if(obj == jbt_one){ //one <-이벤트 소스, 주소번지를 jvm이 버튼을 눌렀을 때 감지. 												
			jtf_result.setText(jtf_result.getText()+"1"); //set text											
		}else if(obj == jbt_two){												
			jtf_result.setText(jtf_result.getText()+"2"); //Oop											
		}else if(obj == jbt_plus){												
			v1 = jtf_result.getText();											
			System.out.println("v1 : "+v1);											
			op = "+"; //?는 +											
			jtf_result.setText("");											
		}else if(obj == jbt_equals){												
			v2 = jtf_result.getText();											
			System.out.println("v1:"+v1 +"-> v2 : "+v2+" op : "+op); 											
			String result = MyCalcurate.calcurate(v1,v2,op); //s Value1											
			jtf_result.setText(""); //											
		}else if(obj == jbt_clear){												
			jtf_result.setText("");											
		}												
	}													
														
}														
														
														
														
														
