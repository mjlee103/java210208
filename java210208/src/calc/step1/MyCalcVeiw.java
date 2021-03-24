package calc.step1;
import java.awt.GridLayout;														

import javax.swing.JButton;														
import javax.swing.JFrame;														
import javax.swing.JPanel;														
import javax.swing.JTextField;

import com.onj.MyCalcEventHandler;
import com.onj.MyCalcView;	

public class MyCalcVeiw extends JFrame{

	//선언부													
		private JTextField jtf_result = null;													
		private JButton jbt_one = null;													
		private JButton jbt_two = null;													
		private JButton jbt_plus = null;													
		private JButton jbt_equals = null;													
		private JButton jbt_clear = null;													
		private JPanel jp_pad = null;													
		MyCalcEventHandler myEventHandler = null;													
		//생성자													
		public MyCalcVeiw(){													
			initDisplay();												
		}													
		//화면처리부													
		public void initDisplay()													
		{													
			jtf_result = new JTextField();												
			jtf_result.setHorizontalAlignment(JTextField.RIGHT);												
			jbt_one = new JButton("1");												
			jbt_two = new JButton("2");												
			jbt_plus = new JButton("+");												
			jbt_equals = new JButton("=");												
			jbt_clear = new JButton("C");												
			myEventHandler = new MyCalcEventHandler(jtf_result,jbt_one,jbt_two,jbt_plus,jbt_equals, jbt_clear);												
			jtf_result.addActionListener(myEventHandler);	//이벤트소스와 클래스 연결, 클래스가 쪼개져 있기 때문에 THIS가 아니라 주소번지가 사용되어야 함. 					
			jbt_one.addActionListener(myEventHandler);		//선언은 19번 전역변수에서 하고 34번에서 인스턴스화 함. 					 
			jbt_two.addActionListener(myEventHandler);												
			jbt_plus.addActionListener(myEventHandler);												
			jbt_equals.addActionListener(myEventHandler);												
			jbt_clear.addActionListener(myEventHandler);												
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
		//main메소드													
		public static void main(String[] args) {													
			new MyCalcView();												
		}													
															
}
