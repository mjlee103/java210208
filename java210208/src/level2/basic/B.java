package level2.basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class B implements ActionListener {
	A a = null;
	//public B(A a) {
	public B(A abc) {
		System.out.println("B(A a) 생성자 호출 성공");
		this.a = a;
		//a = abc;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {//콜백 메소드이다.자동 호출
		System.out.println("actionPerformed 호출 성공");
		Object obj = ae.getSource();
		obj = ae.getSource().getClass();
		if(a.jbtn==obj) {
			
		}
	}

}
