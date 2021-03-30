package level2.basic;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A3 extends JFrame {
	JButton jbtn = null;
	//JButton jbtn = new JButton("전송");
	boolean isView = false;
	public A3(boolean isView) {
		this.isView = isView;
	//	jbtn = new JButton("진송3");
		jbtn = new JButton();
		jbtn.setText("전송4");
		initDisplay(); //위치가 중요함. 
	}
	public void initDisplay() {
		this.add("Center",jbtn);
		this.setSize(500,300);//상수로 처리
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		new A3(true);

	}

}
