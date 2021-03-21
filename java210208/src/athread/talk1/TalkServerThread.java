package athread.talk1;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
	TalkServer 			ts 		= null;
	Socket 				client 	= null;
	ObjectOutputStream  oos 	= null;
	ObjectInputStream   ois 	= null;
	//닉네임
	String nickName             = null;//재훈님 창, 희태님, 제정님	
	public TalkServerThread(TalkServer talkServer) {
		this.ts = talkServer;
		this.client = ts.client;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			String msg = (String)ois.readObject();
			ts.jta_log.append(msg+"\n");
			StringTokenizer st = new StringTokenizer(msg,"#");
			st.nextToken();//100
			nickName = st.nextToken();
			ts.jta_log.append(nickName+"님이 입장하였습니다.\n");
			for(TalkServerThread tst:ts.globalList) { //재훈이 입장하기 전에 기존 친구들의 정보 받기. 
				this.send(100+"#"+tst.nickName);
			}
			ts.globalList.add(this);//현재 스레드는 재훈 스레드 
			this.broadCasting(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public TalkServerThread(athread.talk2.TalkServer talkServer) {
		// TODO Auto-generated constructor stub
	}
	//현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
	public void broadCasting(String msg) { //glabalList에는 서버에 접속해온 클라이언트에 대한 스레드 객체 담김. 
		for(TalkServerThread tst:ts.globalList) {
			tst.send(msg); //해당 스레드에 send 메소드 호출하여 메시지 정송. 
		}
	}
	//클라이언트에게 말하기 구현
	public void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	@Override
	public void run() {
		 boolean isStop = false;		
		 try {
			 run_start:
		 while(!isStop) {
			 try {
				String msg = "";
				msg = (String)ois.readObject();
				ts.jta_log.append(msg+"\n");
				StringTokenizer st = null; //문자열을 썰을때?
				int protocol = 0;
				if(msg!=null) {//100#제훈# 오늘 스터디 할까?
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken()); //100
				}
				switch(protocol) {
				case 200:{
					String nickName = st.nextToken();
					String msg2 = st.nextToken();//오늘 스터디 할까?
					broadCasting(200+"#"+nickName+"#"+msg2);
				};
				
			}////////////end of switch
			} catch (Exception e) {
				System.out.println("while inner ===> "+e.toString());
			}
		 }//////////////////end of while	
	   } catch(Exception e) {
		
	  }
	}
}	