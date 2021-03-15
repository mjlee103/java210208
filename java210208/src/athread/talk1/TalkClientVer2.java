package athread.talk1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TalkClientVer2 extends JFrame implements ActionListener{
	/////////////속지 두 장 추가하기 ////////////////
	JPanel jp_first = new JPanel();
	JPanel jp_secound = new JPanel();
	JPanel jp_secound_south = new JPanel();
	/////////////통신과 관련된 전역변수 추가////////////////////
	Socket 				socket 		= null;
	ObjectOutputStream 	oos 		= null; //확장성 고려, 직렬화 누릴 수 있음. 
	ObjectInputStream 	ois 		= null; //확장성 고려, 직렬화 누릴 수 있음. 
	String 				nickName 	= null; //닉네임
	/////////////////[화면관련 전역변수 추가]/////////////////////
	JTextArea 	jta_display = new JTextArea();
	JScrollPane jsp_display = new JScrollPane(jta_display);
	JPanel 		jp_south 	= new JPanel();
	JTextField 	jtf_msg 	= new JTextField(20);
	JButton 	jbtn_send 	= new JButton("전송");
	//////////////// 두번째 화면에 들어갈 전역변수 선언///////////////
	String cols[] = {"대화명"};
	String data[][] = new String[0][1];
	DefaultTableModel dtm_nick = new DefaultTableModel(data,cols);
	JTable jtb_nick 		= new JTable(dtm_nick);
	JScrollPane jsp_nick 	= new JScrollPane(jtb_nick); 
	JButton jbtn_one 		= new JButton("1:1대화");
	JButton jbtn_change 	= new JButton("대화명 변경");
	JButton jbtn_emotion 	= new JButton("이모티콘");
	JButton jbtn_exit 		= new JButton("나가기");
	// 소켓 관련 초기화
	public void init() {
		try {//소켓 생성하기: ip, port - 서버측 serversocket과 연결됨.
			 socket = new Socket("192.168.0.16", 7000);
			 oos = new ObjectOutputStream(socket.getOutputStream());
			 ois = new ObjectInputStream(socket.getInputStream());
			 oos.writeObject(100+"#"+nickName);
			 TalkClientThread tct = new TalkClientThread(this);
			 tct.start();//run()메소드 호출 
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public void initDisplay() {
		nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		jtf_msg.addActionListener(this);
		jta_display.setEditable(false);
		jp_south.setLayout(new BorderLayout());//borderlayout으로 해야지 center,south 박을 수 있음. 
		jp_south.add("Center", jtf_msg);
		jp_south.add("East",jbtn_send);
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_south);
		jp_first.setBackground(Color.green);
		jp_secound_south.setLayout(new GridLayout(2,2));
		jp_secound_south.add(jbtn_one);
		jp_secound_south.add(jbtn_change);
		jp_secound_south.add(jbtn_emotion);
		jp_secound_south.add(jbtn_exit);
		jp_secound.setBackground(Color.red);
		jp_secound.setLayout(new BorderLayout());
		jp_secound.add("Center", jsp_nick);
		jp_secound.add("South", jp_secound_south);
		this.setLayout(new GridLayout(1,2));
		this.add(jp_first); //전광판 가운데 삽입 
		this.add(jp_secound); //South, Center등은 첫 글자를 반드시 대문자로!
		this.setTitle(nickName+"님의 창");
		this.setSize(500,400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		TalkClientVer2 tc = new TalkClientVer2();
		tc.initDisplay();
		tc.init(); //소켓 처리 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		if(jtf_msg == obj) {
			try {
				oos.writeObject(200
						+"#"+nickName
						+"#"+msg);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
