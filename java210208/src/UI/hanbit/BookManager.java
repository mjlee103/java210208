package UI.hanbit;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookManager extends JFrame {
	Logger logger = LogManager.getLogger(BookManager.class);
	//선언부
	JFrame jf = new JFrame(); // new window()를 부르는 것이다.
	//static JFrame bm = new BookManager(); //new JFrame(); 이 호출된다. 
	//static BookManager bm2 = new BookManager();//new JFrmae();
	static BookManager bm3 = null;//new JFrmae(); <- 선언만 되어있는 게으른 인스턴스화이기 떄문에 nullpointer Exception조심해야 한다. 
	//생성자
	public BookManager() {//3번: 아직 메모리에 올라가지 않은 상태이다. 
		/*
		 * this는 자기자신이기 때문에 jvm이 이 객체를 인지하고 있다. 따라서 nullpointerException을 피해갈 수 있다. 
		 */
		//bm.initDisplay();//할 수 없다. 교집합만 처리할 수 있기 때문에 호출이 불가하낟.
		//jf.initDisplay();//위에와 같은 논리이다.
		//initDisplay();// 내 안에 있는 메소드이기 때문에 즉시 호출해야 한다. 
		//this는 자기 자신이니까 bookmanager를 말하는 것이다. super를 쓴다면 JFrame을 가리키는 것이다. 
		//this.setSize(500,300);
		//super.setSize(600, 700);
		//bm3.setSize(600,700);
		this.setSize(600, 700);
		//우리는 setvisible에 대해서 오버라이딩을 하지 않았다. 따라서 부모의 메소드가 호출되었다. 
		//bm.setVisible(true);
		//bm3.setVisible(true);
		this.setVisible(true);
	}
	//화면처리부
	public void initDisplay() {
		logger.info("initDisplay() 호출성공");
	
	}
	//메인메소드
	public static void main(String[] args) {//1번
		//new BookManager();
		//bm2.initDisplay();//setvisible이 내 클래스 것이 아니어서 화면 구현이 되지 않는다. 
		bm3 = new BookManager(); //2번:생성자 호출 => public bookmanager로 간다. 
		bm3.initDisplay();
	}
}
