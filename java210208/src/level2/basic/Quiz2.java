package level2.basic;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quiz2 extends JFrame {
	//선언부
	JPanel jp_center = new JPanel();
	JButton jbtn_one = new JButton("만들기");
	JButton jbtn_two = new JButton("처리");
	JButton jbtn_three = new JButton("종료");
	//생성자
	public Quiz2() {
		jp_center.setLayout(new GridLayout(3,4,3,3));
				
	}
	//화면처리부
	public void initDisplay() {
		
	}
	//main 메소드 
	public static void main(String[] args) {
		Quiz2 q2 = new Quiz2();
		Quiz2.initDisplay();

	}

}
