package book.ch6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ClassGubun extends JFrame{
	JButton jbtn_search = new JButton("조희");
	JButton jbtn_exit = new JButton("종료");
	//ClassGutun cg2 = new ClassGubun();
	public void start() {
		jbtn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("조회 버튼 호출 성공");
			}	
	
		});
	jbtn_exit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("나가기 버튼 호출 성공");
			}
		});
	}
	public void initDisplay() {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(jbtn_search);
		this.add(jbtn_exit);
		this.setSize(500, 300);
	}
	public static void main(String[] args) {
		ClassGubun cg = new ClassGubun();
		cg.initDisplay();
	}

}
