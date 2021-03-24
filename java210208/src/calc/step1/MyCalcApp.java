package calc.step1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.onj.MyCalcurate;

public class MyCalcApp extends JFrame implements ActionListener{
	//선언부
	private JTextField jtf_result = null;													
	private JButton jbt_one = null;	//숫자 1번 버튼												
	private JButton jbt_two = null;	//숫자 2번 버튼 												
	private JButton jbt_plus = null;													
	private JButton jbt_equals = null;													
	private JButton jbt_clear = null;													
	private JPanel jp_pad = null;		
	String v1 = "";													
	String v2 = "";													
	String op = "";		
	
																		
	//생성자
	public MyCalcApp(){													
		initDispaly();
	}
	//화면처리부 
		
	private void initDispaly() {													
			jtf_result = new JTextField();												
			jtf_result.setHorizontalAlignment(JTextField.RIGHT);												
			jbt_one = new JButton("1");												
			jbt_two = new JButton("2");												
			jbt_plus = new JButton("+");												
			jbt_equals = new JButton("=");					//						
			jbt_clear = new JButton("C");																								
			jtf_result.addActionListener(this);	//이벤트소스와 클래스 연결, 클래스가 쪼개져 있기 때문에 THIS가 아니라 주소번지가 사용되어야 함. 					
			jbt_one.addActionListener(this);		//선언은 19번 전역변수에서 하고 34번에서 인스턴스화 함. 					 
			jbt_two.addActionListener(this);												
			jbt_plus.addActionListener(this);												
			jbt_equals.addActionListener(this);												
			jbt_clear.addActionListener(this);												
			jp_pad = new JPanel(new GridLayout(1,5,2,2));	//괄호 안에 인스턴스가 왔음.  원래는 두 문장 GridLayout g = new GridLayout(); , jp-pad = new JPanel(g);					
			jp_pad.add(jbt_one);												
			jp_pad.add(jbt_two);												
			jp_pad.add(jbt_plus);												
			jp_pad.add(jbt_equals);												
			jp_pad.add(jbt_clear);												
			this.getContentPane().add("North",jtf_result);												
			this.getContentPane().add("Center",jp_pad);												
			this.setTitle("전자계산기");												
			this.setSize(300,150);												
			this.setVisible(true);												
		}	
	public static String calcurate(String sValue1, String sValue2, String sOp)										
	{										
		double v1 = Double.parseDouble(sValue1);									
		double v2 = Double.parseDouble(sValue2);									
											
		System.out.println("sValue1 : "+sValue1+" : sValue2 : "+sValue2 + "==> "+sOp);									
		if(sOp.equals("+")){									
			return ""+(v1+v2);								
		}									
		else{									
			return "error";								
		}									
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
	public static void main(String[] args) {
		new MyCalcApp();		

	}

}
