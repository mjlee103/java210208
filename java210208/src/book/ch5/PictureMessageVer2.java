package book.ch5;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class PictureMessageVer2 extends JDialog {
	//선언부
	String imgPath ="C:\\git_java210208\\java210208\\java210208\\src\\images\\"; //이모티콘 하나씩 나오게 하기 위해서 \\
	JPanel jp_emoticon = new JPanel();
	GridLayout gl_emoticon = new GridLayout(1,5,2,2); //속지에 레이아웃 반영
	JButton pic0 = new JButton(); //이미지가 5장이어서 5개 준비 
	JButton pic1 = new JButton();
	JButton pic2 = new JButton();
	JButton pic3 = new JButton();
	JButton pic4 = new JButton();
	String imgFile[] = {"lion11.png","lion22.png","lion33.png","lion44.png","lion55.png"};//배열로 이미지 파일 정보 선언
	JButton imgButton[] = {pic0,pic1,pic2,pic3,pic4};
	ImageIcon img[] = new ImageIcon[imgButton.length];
	//생성자 - 클래스 이름과 동일하게 설정		
	
	
	//화면처리부
	public void initDisplay() {
		//this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		jp_emoticon.setLayout(gl_emoticon);
		for(int i=0;i<img.length;i++) {
			img[i] = new ImageIcon(imgPath+imgFile[i]);
	
			}
		pic0.setIcon(img[0]);
		pic0.setBorderPainted(false);
		pic0.setFocusPainted(false);
		pic0.setContentAreaFilled(false);
		pic1.setIcon(img[1]);
		pic2.setIcon(img[2]);
		pic3.setIcon(img[3]);
		pic4.setIcon(img[4]);
		
		/*
		pic0.setIcon(new ImageIcon(imgPath+imgFile[0]));
		pic1.setIcon(new ImageIcon(imgPath+imgFile[1]));
		pic2.setIcon(new ImageIcon(imgPath+imgFile[2]));
		pic3.setIcon(new ImageIcon(imgPath+imgFile[3]));
		pic4.setIcon(new ImageIcon(imgPath+imgFile[4]));
		*/
		jp_emoticon.add(pic0);
		jp_emoticon.add(pic1);
		jp_emoticon.add(pic2);
		jp_emoticon.add(pic3);
		jp_emoticon.add(pic4);
		this.add("Center",jp_emoticon);
		this.setSize(500,200);
		this.setVisible(true);
	}
	
	//메인메소드
	public static void main(String[] args) {
		PictureMessageVer2 pm = new PictureMessageVer2();
		pm.initDisplay();

	}

}
