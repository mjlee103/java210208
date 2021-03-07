package book.ch4;

import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwitchTestVer2 extends JFrame{

	public static void main(String[] args) {  //trotocol을 써서 경우의 수를 나눔 
		SwitchTestVer2 stv = new SwitchTestVer2();
		int 	protocol = 0; //로그인
		String 	nickName = "tomato";
		String 	inputValue = "오늘 스터디 할까?"; //inputvalue 사용자가 입력한 값이라고 변수 선언한 것 
		String 	msg = 300+"#"+nickName+"#"+inputValue; //
		StringTokenizer st = new StringTokenizer(msg, "#");  //
				protocol = Integer.parseInt(st.nextToken()); // parseint? 스트링을 받아서 int로 변환시켜줌
		String s_nickName = st.nextToken();
		String s_inputvalue = st.nextToken();
		switch(protocol) {//원시형 타입+String 타입
		case 100: //실행문
			System.out.println("0입니다.");
			break;
		case 200: //실행문
			System.out.println("301입니다.");
			break;
		case 300: //실행문
			System.out.println("["+s_nickName+"]"+s_inputvalue); //s_inputvalue: 서버의 inputvalue
			break;
		default:
			JOptionPane.showInternalMessageDialog(stv, "잘못된 메시지입니다."); //
		}//////////////end of switch
		System.out.println("여기");
			
	}//// #31의 파라미터(this, ~) 안 됨 ! static은 클래스 급이기 때문에 static 안에서 this나 super사용 불가능하다. 해결하기 위해서 인스턴스화해주면 됨 
	// #31를 위해서 #11  인스턴스화 해 줌 

}
