package level2.basic;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A extends JFrame {
		jbtn = new jbtn();
		initDisplay();
	}
	public void initDisplay() {
		this.setSize(500,300);//상수로 처리
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		new A(true);

	}

}
