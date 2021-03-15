package athread.talk1;

import java.awt.Color;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/*
 * 클라이언트 측에서 접속 시도가 있을 때 서버측에서 클라이언트의 로그 정보를 보고 싶다.
 * 따라서 화면에 전광판을 하나 추가하여 텍스트로 로그 정보를 확인할 수 있도록 하기 위해서 
 * JFrame 상속 받음.
 * main 메소드가 잇는 클래스는 디폴트 스레드를 가진다.
 * 이 쓰레드에서 소켓 서버 정보를 관리하는 하면 경합이 일어날 수 잇고 그에 따라 충돌이나 이상이 발생 가능함
 * 따라서 별도의 스레드를 구현하고 그 안에서 run 메소드를 실행하여 안전하게 소켓들이 생성되고 관리될 수 있도록 해야 한다. 
 */
public class TalkServer extends JFrame implements Runnable{
	//////////////////[통신에 관련 전변 추가///////////////////..
	ServerSocket 		server = null;
	Socket 				client = null;
	TalkServerThread			tst 		= null;
	Vector<TalkServerThread>	globalList 	= null;   // **********vector가 핵심 키워드. 
	JTextArea 	jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	public void initDisplay(){
		System.out.println("initDisplay호출 성공");
		jta_log.setBackground(Color.orange);
		this.add("Center", jsp_log);
		this.setSize(500,400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		TalkServer ts = new TalkServer();
		ts.initDisplay();
		Thread th = new Thread(ts); //thread 상속 안받 았기때문에 인스턴스화 해서 사용 (ts)는 thread와 talkserver 매칭
		th.start(); //run 메소드 호출		
	}

	@Override
	public void run() {
		System.out.println("run 호출 성공");
		globalList = new Vector<>();
		boolean isStop = false;
		try {
			server = new ServerSocket(7000);
			jta_log.append("Server Ready.......\n");//\n 은 줄바꿈
			while(!isStop) {
				client = server.accept();
				jta_log.append("client info : "+client+"\n");
				TalkServerThread tst = new TalkServerThread(this);
				tst.start();
			}
		} catch (Exception e) {
			// printStackTrace는 예외 발생에 대한 메시지들을 stack 영역에서 관리하는데 이것들을 출력해주는 메소드입니다.
			//라인 번호와 호출 순서에 대한 내용까지도 포함하기 때문에 더 많은 힌트를 얻을 수 있음
			//디버깅에 유용한 메소드 
			e.printStackTrace();
		}
		
	}

}
