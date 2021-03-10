package network.step1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JLabel;

public class TimeClient extends Thread {
   String timeStr = null;
   JLabel jlb_time = null;
   /*TimeClient(){ 
        디폴트 생성자에는 메소드에 아무 값이 들어있지 않기 때문에 실행이 되지 않는다. 	   
    }
    */
   TimeClient(JLabel jlb_time){
	   this.jlb_time = jlb_time;	   
   }
   @Override
   public void run() {//콜백메소드 - 사용자가 아니라 시스템 레벨에서 자동 호출되는 메소드임.
      Socket socket = null;
      BufferedReader br = null;
      boolean isFlag = false;
      try {
         socket = new Socket("192.168.0.35",3000);//local port가 7375
         br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         //내 소켓에 대한 포트번호는 따로 할당
         while(!isFlag) {
            while((timeStr=br.readLine())!=null) {
               System.out.println(timeStr);
               jlb_time.setText(timeStr);//AddressBook2 연관 복습
               try {
                  sleep(1000);
               } catch (InterruptedException e) {
                  System.out.println("너는 ㄴ구야ㅑㅑㅑㅑㅑ");
               }
            }
         }
      } catch (Exception e) {
         
      }
   }
  /*public static void main(String[] args) {
      TimeClient tc = new TimeClient();
      tc.start();//run메소드 호출 해줌.
   }
  */
}