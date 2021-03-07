package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewApp1_2 implements ActionListener{
	JFrame jf 		= new JFrame();// 1번재 방법: 선언부 & 생성 같이 함  <- setSize 하기 전에 인스턴스화 함. 
	//인스턴스화를 분리해서 할 수도 있는데 이때의 차이가 무엇인지 생각해봐야 함. 
	JFrame jf2 		= null; 	//2번째 방법: 선언만 해놓고 생성하지 않음  <- null point exception 일어날 수 있음. 
	JButton jbtn 	= null;
	public void initDisplay() {
		jf2  = new JFrame();//#12와 인스턴스화를 분리해서 한 것.
		//jbtn = new JButton();//#13번과 인스턴스화 분리
		//jbtn.setText("전송"); //버튼의 라벨을 붙이기 위해 jbtn.setText 메소드 호출 ("전송")
		jbtn = new JButton("전송");//
		//이벤트 소스와 이벤트 처리를 담당하는 클래스를 연결해주어야 함.
		//이벤트 처리를 담당하는 클래스를 이벤트 핸들러 클래스라고 한다.
		///이벤트 처리를 담당하는 클래스는 반드시 ActionPerforemd라는 메소드를 오버라이딩 해야 함. 
		jbtn.addActionListener(this); //내안에 이벤트 처리 메소드가 잇다. 
		//이벤트 처리 메소드가 외부에 있을때는
		//VeiwAppEvent ve = new ViewAppEcent();
		//jbtn.addAncestorListener(ve); // 시점의 문제를 당할 수 있다. 이를 해결하는 문제해결능력을 키워야 함. 
		jf2.add("North", jbtn); //생성된 버튼을 JFrmae의 북쪽에 배치해 본다.
		jf2.setSize(300, 200);
		jf2.setVisible(true);
	}

	public static void main(String[] args) {
		ViewApp1_2 va = new ViewApp1_2(); //내 안에 있는 메소드라 하더라도 메인에서 불러오기 위해서는 인스턴스화 해야 함. 
		va.initDisplay();
	}//

	@Override
	public void actionPerformed(ActionEvent ae) { //변수 선언하는 자리
		//너 전송버튼 누른거야?
		//ae.getSource()는 이벤트가 일어난 버튼의 주소번지를 반환해주는 메소드이다. 
		if(ae.getSource()==jbtn) { //전송 버튼의 주소번지는 jbtn이다. 
			System.out.println("전송버튼 호출 성공");
		}
		
	}

}
