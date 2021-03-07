package ch5.singleton;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewApp {
	JFrame jf = new JFrame();// 1번재 방법, 선언부 & 생성 같이 함  <- setSize 하기 전에 인스턴스화 함. 
	JFrame jf2 = null; 	//2번째 방법, 선언만 해놓고 생성하지 않음  <- null point exception 일어날 수 있음.  
	JButton jbtn = new JButton("전송");
	public void initDisplay() { // 화면 구현 
		jf2 = new JFrame();
		//#12 디폴트 생성자는 제공하지만 파라미터 갖는 생성자는 제공되지 않음. new eventhandler 오버
		//create ~ view app
		EventHandler eh = new EventHandler(this); //this는 viewApp클래스 가리키는 것
		jbtn.addActionListener(eh);
		jf2.add("North", jbtn);
		jf2.setSize(300, 200);
		jf2.setVisible(true);
	} 

	public static void main(String[] args) {
		ViewApp va = new ViewApp();  
		va.initDisplay(); //내 안에 있는 메소드라 하더라도 메인에서 불러오기 위해서는 인스턴스화 해야 함.
			
	}

}
