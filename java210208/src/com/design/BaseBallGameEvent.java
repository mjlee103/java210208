package com.design;

import java.awt.event.ActionEvent;
/*ActionListener al = new BaseBallGameEvent();
 * 액션리스너는 인터페이스인데 인터페이스는 반드시 BaseBallGameEvent와 같은 구현체 클래스가 필요하다.
 * actionhlistener는 버튼을 눌렀을 때 일어나는 일에 대해 알 수 없다. 결정할 수 없다. 모르기 때문이다. 
 * 따라서  actionperformed라는 추상 메소드를 구현해야 한다. 
 */
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class BaseBallGameEvent implements ActionListener {//ActionListener는 인터페이스이다.
	BaseBallGameView bbgView = null; //전역변수 , 원본 & = new BaseBallGameView();<-복사본
	BaseBallGameLogic bbgLogic = null;
	public BaseBallGameEvent(BaseBallGameView bbgView) {
		this.bbgView = bbgView;
	}
public BaseBallGameEvent(BaseBallGameView bbgView, BaseBallGameLogic bbgLogic) {
		this.bbgView = bbgView;
		this.bbgLogic =bbgLogic;
	} 
	@Override
	public void actionPerformed(ActionEvent e) {//이벤트가 감지된 소소의 주소번지를 알기 (버튼의 주소번지: e.getsource)
		Object obj = e.getSource();
		// 라벨값으로 처리하고 싶으면
		String label = e.getActionCommand(); //새게임,지우기
		System.out.println("event label:"+label);
		if(obj == bbgView.jbtns[0]){ //배열의 0번지가 새게임, view파일 #40 확인해보기 , #14로 가서 nullpoint Exception나오게됨. 
			//->bbgView가 null이 아니기 위해서는 반드시 BaseBallGameEvent 생성자를 경유해야 함. 
			String input =  bbgView.jtf_input.getText().trim();
			
			//만일 숫자가 아닌 값이 있을 때도 고려해야 한다.
			try {
				Integer.parseInt(input);//356			
			} catch (NumberFormatException nfe) {
				bbgView.jop.showMessageDialog(bbgView.jf, "숫자만 입력하세요", "Error", JOptionPane.ERROR_MESSAGE);
				bbgView.jtf_input.setText("");
				bbgView.jtf_input.requestFocus();				
				return ;
			}
			
			if(input.length()!=3){
				return;
			}
			else{
				bbgView.jta_display.append(++bbgView.cnt+"."+ bbgView.jtf_input.getText()+":"+bbgLogic.call(input)+"\n");
				bbgView.jtf_input.setText("");
			}
		}
		else if("지우기".equals(label)){
			bbgView.jta_display.setText("");
			bbgView.jtf_input.requestFocus();
		}
		else if("종료".equals(label)){
			System.exit(0);// 자바 가상머신과의 연결고리를 끊는다.
		}
		else if(obj ==  bbgView.jmi_dap){
			bbgView.jta_display.append("정답은 "+ bbgLogic.com[0]+ bbgLogic.com[1]+ bbgLogic.com[2]+"\n");
			bbgLogic.nanSu();
		}
		else if(obj ==  bbgView.jbtns[1]){
			bbgView.jta_display.append("정답은 "+ bbgLogic.com[0]+ bbgLogic.com[1]+ bbgLogic.com[2]+"\n");
			bbgLogic.nanSu();
		}
		//새게임
		else if(obj ==  bbgView.jbtns[0]){
			bbgView.cnt = 0;
			bbgLogic.nanSu();
			bbgView.jta_display.setText("");
			bbgView.jtf_input.setText("");
			bbgView.jtf_input.requestFocus();
		}
	}
}