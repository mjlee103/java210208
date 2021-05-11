package UI.hanbit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//JFrame을 상속받은 상태이고 actionlistener가 있다는건 이벤트를 감지할 것이라는 것이다. 
//JFrame이 상위 클래스이고 JInternalFrmaeEx가 구현체 클래스이다. \
//                   ActionListener a 				= new JInternalframeEx();
//  선언부 (추상클래스나 인터페이스가 오는 것이 권장사항)-다형성                   반드시 구현체 클래스가 되어야 한다. 
// @override는 클래스 결합도를 낮출 수 있다. -> 결합이 느슨해 진다. actionlistener를 b라는 클래스에서 사용하는 것은 항상 정상이다. 
// 
public class JInternalFrameEx extends JFrame implements ActionListener {
	/*
	 * JDesktopPane ~ int 까지 전역변수이다. 
	 * = 기준으로 메모리(ram)에 상주하게 되었다. 그러나 아직 실행은 안된 상태이다. -> 아직 main 메소드가 call을 받지 못한 것이다.
	 * call 해주는 일을 jvm이 담당한다. 
	 * 세상 구경을 하기 위해서는 pulbic JInternalFrame이라는 생성자가 필요하다. 
	 */
	
	JDesktopPane desktop = new JDesktopPane();
	
	JMenuItem openItem = new JMenuItem("New");
	JMenuItem closeItem = new JMenuItem("Close");
	JMenuItem exitItem = new JMenuItem("Exit");
	
	int cnt=1;

	public JInternalFrameEx() {
		
		super("JInternalFrame 테스트");
		
		buildGUI();

		setBounds(300,200,500,400);
		setVisible(true);
	}
	
	void buildGUI() {
    	
		add(desktop, BorderLayout.CENTER);
		
		JMenuBar menubar = new JMenuBar();
		//위치가 없이 붙고 있는데 이는 JFrame에 붙이는게 아니다. JFrame은 east, north, west, center south이어야 한다.
		//~pane이 눈에 보이지 않지만 한 겹 더 깔려 있는 것이다. 
		setJMenuBar(menubar);
		
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		
		fileMenu.add(openItem);
		fileMenu.add(closeItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		openItem.addActionListener(this);
		closeItem.addActionListener(this);
		exitItem.addActionListener(this);
	}

	public void openFrame() {
		//JInternalFrame은 윈도우의 자녀가 아니어서 독립적으로 처리 불가능하다. JFrame, JDialog, JFileDialog를 이용해야 한다. 
		JInternalFrame frame = new JInternalFrame("새문서"+cnt, true, true, true, true );
		//JLabel 문자열을 나타낸다. 
		JLabel imageLabel = new JLabel("새문서");
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().add(imageLabel);
		if(cnt==1)
			frame.setSize(200,200);
		else
			frame.setBounds((cnt-1)*20, (cnt-1)*20, 200, 200);
		cnt++;

		desktop.add(frame);
		frame.setVisible(true);
	}
	
	public void closeFrame() {	
		JInternalFrame frame = desktop.getSelectedFrame();
		if(frame == null) { return; }		
		frame.setVisible(false);
		frame.dispose();	
	}
	
	public void actionPerformed(ActionEvent e) {
	
		Object obj = e.getSource();
		
		if(obj == openItem) {
			openFrame();
		}
		else if(obj == closeItem) {
			closeFrame();
		}
		else if(obj == exitItem) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args){
		new JInternalFrameEx();
	}
}
