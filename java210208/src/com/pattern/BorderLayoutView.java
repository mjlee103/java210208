package com.pattern;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutView {

	public static void main(String[] args) {
		//버튼객체를 5개 선언 및 초기화 하기 <- 메모리에 로딩이 일어남. 
		JButton jbtn_north = new JButton("북쪽");
		JButton jbtn_south = new JButton("북쪽");
		JButton jbtn_center = new JButton("북쪽");
		JButton jbtn_west = new JButton("북쪽");
		JButton jbtn_east = new JButton("북쪽");
		
		//윈도우에서 독립된 창을 띄울 때 사용함. 
		JFrame jf = new JFrame();
		jf.setLayout(new BorderLayout());//JFrame의 배치 레이아웃 지정
		jf.add("North", jbtn_north);
		jf.add("South", jbtn_south);
		jf.add("Center", jbtn_center);
		jf.add("East", jbtn_east);
		jf.add("West", jbtn_west);
		jf.setSize(600,400);
		jf.setVisible(true);
	}

}
