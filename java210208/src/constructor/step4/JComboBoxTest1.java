package constructor.step4;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JComboBoxTest1 extends JFrame {
	//선언부
	JPanel 	  jp_north 		= null; //속지
	JComboBox jcb_top 		= null;
	JComboBox jcb_mid 		= null;
	JComboBox jcb_bottom 	= null;	
	String 	  top_item[]	= {"전체","가전","컴퓨터","모바일"};
	String 	  mid_item0[]	= {"전체","주방가전","생활가전","계절가전"};
	String 	  mid_item1[]	= {"전체"};
	String 	  mid_item2[]	= {"전체"};
	String 	  bottom_item[]	= {"전체"};
	//생성자 
	public JComboBoxTest1() { //public jcomboboxtest1은 자바가 자동으로 제공하는 디폴트 생성자. 
		jp_north = new JPanel(); //속지 인스턴스화 먼저 하는 것이 안전함. 
		//super("대중소분류 실습"); //super = jframe, **super는 항상 생성자의 가장 처음에 위치해야 함.** 
		jcb_top = new JComboBox(top_item);
		jcb_mid = new JComboBox(mid_item0);
		jcb_bottom = new JComboBox(bottom_item);
		initDisplay();
	}
	//화면처리부
	public void initDisplay() {
		jp_north.setBackground(Color.orange);
		jp_north.add(jcb_top);
		jp_north.add(jcb_mid);
		jp_north.add(jcb_bottom);
		this.add("North", jp_north);
		this.setTitle("대중소분류 실습");
		this.setSize(500, 400);
		this.setVisible(true);		
	}
	//메인메소드 선언
	public static void main(String[] args) {
		new JComboBoxTest1(); //생성자를 경유하고 생성자에서 화면처리 메소드 호출해 보기 

	}

}
