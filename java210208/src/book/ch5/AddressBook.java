package book.ch5;

import javax.swing.JFrame;

public class AddressBook extends JFrame {  //extends는 상속
	//선언부
	
	//생성자
	public AddressBook() {
		
	}
	//화면처리부
	public void initDisplay() {
		this.setTitle("주소록-Ver1.0");
		this.setSize(500, 400);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		AddressBook aBook = new AddressBook(); 
		aBook.initDisplay();
	}

}
