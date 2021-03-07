package variable.step1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginView2 extends JFrame implements ActionListener  { // 인터페이스 이다 . 결합도를 낮추는 코드를 작성할때 필요-클래시 설계시 필요- 복습할 필요가 없는 이유는 요즘 웹기반으로 처리를 하니까
	//java.lang에 있는 패키지가 아니므로 별도로 import해야 함.
	JButton jbtn_login = new JButton("로그인");
	//화면 그리기 구현
	public void initDisplay() {
		//내 자신이 이벤트 처리를 담당하는 핸들러 클래스이다 라는 의미로 this를 사용하기도 한다.
		//jbtn_login.addActionListener(this); //이벤트 소스와 이벤트 처리를 담당하는 클래스 연결. 매칭 - 콜백함수가 호출됨.
		this.setTitle("네이버 로그인");
		this.add("North",jbtn_login);
		this.setSize(500, 400);
		this.setVisible(true); //true이면 화면에 보여줄게, false:비활성화 해줄게-메모리는 갖고 있으나 멈춰 있는 것임.
	}
	//내안에 있는 메소드이지만 static영역 안에서 non-static을 접근할 수 없으므로 인스턴스화를 해서 해결함.
	public static void main(String[] args) {
		LoginView2 view = new LoginView2();
		view.initDisplay();
	}
	//같은 이름의 메소드를 여러개 정의 할 수 있다. - 뒷바침하는 개념이 메소드 오버로딩과 오버라이딩(메소드이름이 같고 서로 상속관계)이다.
	//오버로딩의 규칙은 둘 중에 하나만 만족해도 ㄱㅊ
	//@Override와 같은 것을 '어노테이션'이라고 부름.=메소드오버라이드
	@Override
	public void actionPerformed(ActionEvent e) {//콜백메소드라고 함.내가 호출하는 메소드가 아니라 이벤트 감지가 일어나면 자동 호출됨.
		//로그인 버튼을 누른 거야?
		if(jbtn_login==e.getSource()){ //이벤트 감지는 컴터가 하고 버튼의 주번은 내가 정의 함. 주소번지가 같니?
			System.out.println("나야나");
		}
	}
}
