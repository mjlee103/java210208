package athread.talk1;

import java.util.StringTokenizer;

public class TalkClientThread extends Thread {
	TalkClient tc = null;
	
	public TalkClientThread(TalkClient talkClient) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() { //actionperformed는 말하기 run은 듣기 
		 System.out.println("run 호출 성공");
		 boolean isStop = false;
		 while(!isStop) {
			 try {
				String msg = "";
				msg = (String)tc.ois.readObject();
				StringTokenizer st = null; //문자열을 썰을때?
				int protocol = 0;
				if(msg!=null) {//100#제훈# 오늘 스터디 할까?
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken()); //100
				}
				switch(protocol) {
				case 100:{
					String nickName = st.nextToken();
					tc.jta_display.append(nickName+"님이 입장하셨습니다.\n");
				};
				case 200:{
					String nickName = st.nextToken();
					String msg2 = st.nextToken(); // 오늘 스터디 할까?
					tc.jta_display.append("["+nickName+"]"+msg+"\n");
				};
				}////////////end of switch
			} catch (Exception e) {
				// TODO: handle exception
			}
		 }//////////////////end of while
	}
}
