package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler2 implements ActionListener {
	ViewApp2 viewApp = null; //전역변수 선언  #15 해결방법 
	//ViewApp viewApp = new ViewApp(); 하면 안됨 


	 public EventHandler2(ViewApp2 viewApp) {
		this.viewApp = viewApp;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==viewApp.jbtn) { //viewapp은 지변이어서 전역변수 선언 필요함, 초기화가 안되서
			//NUllpointException일어남. 
			System.out.println("전송 버튼 호출 성공");
		}
	}

}
